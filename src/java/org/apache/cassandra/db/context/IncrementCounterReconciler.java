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
package org.apache.cassandra.db.context;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.LinkedList;

import org.apache.commons.lang.ArrayUtils;

import org.apache.cassandra.db.Column;
import org.apache.cassandra.db.IClock;
import org.apache.cassandra.db.IClock.ClockRelationship;
import org.apache.cassandra.db.IncrementCounterClock;
import org.apache.cassandra.utils.FBUtilities;

public class IncrementCounterReconciler extends AbstractReconciler
{
    private static IncrementCounterContext contextManager;

    static
    {
        contextManager = IncrementCounterContext.instance();
    }

    public Column reconcile(Column left, Column right)
    {
        // note: called in addColumn(IColumn) to aggregate local node id's counts

        // delete + delete: keep later tombstone, higher clock
        if (left.isMarkedForDelete() && right.isMarkedForDelete())
        {
            // use later local delete time
            int leftLocalDeleteTime  = FBUtilities.byteArrayToInt(left.value());
            int rightLocalDeleteTime = FBUtilities.byteArrayToInt(right.value());

            // merge clocks
            List<IClock> clocks = new LinkedList<IClock>();
            clocks.add(right.clock());
            IClock clock = (IClock)left.clock().getSuperset(clocks);

            return new Column(
                left.name(),
                leftLocalDeleteTime >= rightLocalDeleteTime ? left.value() : right.value(),
                clock,
                true);
        }

        // normal + delete
        //
        // in clock context:
        // if local node delete timestamp > local node's last count timestamp,
        // then treat local row as completely deleted, locally.
        // (require read repair to pull this row's count.)
        // note: tombstones win ties.
        if (left.isMarkedForDelete())
        {
            switch (left.clock().compare(right.clock()))
            {
                case EQUAL:
                case GREATER_THAN:
                    return new Column(
                        left.name(),
                        left.value(),
                        left.clock(),
                        true);
                default: // LESS_THAN
                    return new Column(
                        left.name(),
                        right.value(),
                        right.clock(),
                        false);
                // note: DISJOINT is not possible
            }
        }
        else if (right.isMarkedForDelete())
        {
            switch (left.clock().compare(right.clock()))
            {
                case GREATER_THAN:
                    return new Column(
                        left.name(),
                        left.value(),
                        left.clock(),
                        false);
                default: // EQUAL, LESS_THAN
                    return new Column(
                        left.name(),
                        right.value(),
                        right.clock(),
                        true);
                // note: DISJOINT is not possible
            }
        }
        // normal + normal
        else
        {
            // merge clocks
            List<IClock> clocks = new LinkedList<IClock>();
            clocks.add(right.clock());
            IClock clock = (IClock)left.clock().getSuperset(clocks);

            // set value to aggregate
            byte[] value = contextManager.total(((IncrementCounterClock)clock).context());

            return new Column(left.name(), value, clock, false);
        }
    }
}