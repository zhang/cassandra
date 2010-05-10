/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.cassandra.db;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.net.InetAddress;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.commons.lang.ArrayUtils;

import org.apache.cassandra.db.context.IContext.ContextRelationship;
import org.apache.cassandra.db.context.IncrementCounterContext;
import org.apache.cassandra.io.ICompactSerializer2;
import org.apache.cassandra.utils.FBUtilities;

public class IncrementCounterClock implements IClock
{
    private static Logger logger_ = Logger.getLogger(IncrementCounterClock.class);
    public static IncrementCounterClock MIN_VALUE = new IncrementCounterClock(ArrayUtils.EMPTY_BYTE_ARRAY);
    public static ICompactSerializer2<IClock> SERIALIZER = new IncrementCounterClockSerializer();

    private static IncrementCounterContext contextManager = IncrementCounterContext.instance();
//TODO: TEST (NOTE: if we use final, we need to re-create every CF on insert in RowMutation : updateClocks())
//    public final byte[] context;
    public byte[] context;

    public IncrementCounterClock(byte[] context)
    {
        this.context = context;
    }

    public byte[] context()
    {
        return context;
    }

    public void update(InetAddress node, long delta)
    {
        context = contextManager.update(context, node, delta);
    }

    public ClockRelationship compare(IClock other)
    {
        assert other instanceof IncrementCounterClock : "Wrong class type.";

        ContextRelationship rel = contextManager.compare(context, ((IncrementCounterClock)other).context());
        switch (rel)
        {
            case EQUAL:
                return ClockRelationship.EQUAL;
            case GREATER_THAN:
                return ClockRelationship.GREATER_THAN;
            case LESS_THAN:
                return ClockRelationship.LESS_THAN;
            default: // DISJOINT
                return ClockRelationship.DISJOINT;
        }
    }

    public IClock getSuperset(List<IClock> otherClocks)
    {
        List<byte[]> contexts = new LinkedList<byte[]>();

        contexts.add(context);
        for (IClock clock : otherClocks)
        {
            assert clock instanceof IncrementCounterClock : "Wrong class type.";
            contexts.add(((IncrementCounterClock)clock).context);
        }

        return new IncrementCounterClock(contextManager.merge(contexts));
    }

    public int size()
    {
        return DBConstants.intSize_ + context.length;
    }

    public void serialize(DataOutput out) throws IOException
    {
        SERIALIZER.serialize(this, out);
    }

    public String toString()
    {
        return contextManager.toString(context);
    }

    public void cleanNodeCounts(InetAddress node)
    {
        contextManager.cleanNodeCounts(context, node);
    }
}

class IncrementCounterClockSerializer implements ICompactSerializer2<IClock> 
{
    public void serialize(IClock c, DataOutput out) throws IOException
    {
        FBUtilities.writeByteArray(((IncrementCounterClock)c).context(), out);
    }

    public IClock deserialize(DataInput in) throws IOException
    {
        int length = in.readInt();
        if ( length < 0 )
        {
            throw new IOException("Corrupt (negative) value length encountered");
        }
        byte[] context = new byte[length];
        if ( length > 0 )
        {
            in.readFully(context);
        }
        return new IncrementCounterClock(context);
    }
}