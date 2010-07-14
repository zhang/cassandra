/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.apache.cassandra.thrift;
/*
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 */


import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.protocol.*;

public class Deletion implements TBase<Deletion, Deletion._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("Deletion");

  private static final TField CLOCK_FIELD_DESC = new TField("clock", TType.STRUCT, (short)1);
  private static final TField SUPER_COLUMN_FIELD_DESC = new TField("super_column", TType.STRING, (short)2);
  private static final TField PREDICATE_FIELD_DESC = new TField("predicate", TType.STRUCT, (short)3);

  public Clock clock;
  public byte[] super_column;
  public SlicePredicate predicate;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    CLOCK((short)1, "clock"),
    SUPER_COLUMN((short)2, "super_column"),
    PREDICATE((short)3, "predicate");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // CLOCK
          return CLOCK;
        case 2: // SUPER_COLUMN
          return SUPER_COLUMN;
        case 3: // PREDICATE
          return PREDICATE;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.CLOCK, new FieldMetaData("clock", TFieldRequirementType.REQUIRED, 
        new StructMetaData(TType.STRUCT, Clock.class)));
    tmpMap.put(_Fields.SUPER_COLUMN, new FieldMetaData("super_column", TFieldRequirementType.OPTIONAL, 
        new FieldValueMetaData(TType.STRING)));
    tmpMap.put(_Fields.PREDICATE, new FieldMetaData("predicate", TFieldRequirementType.OPTIONAL, 
        new StructMetaData(TType.STRUCT, SlicePredicate.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(Deletion.class, metaDataMap);
  }

  public Deletion() {
  }

  public Deletion(
    Clock clock)
  {
    this();
    this.clock = clock;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Deletion(Deletion other) {
    if (other.isSetClock()) {
      this.clock = new Clock(other.clock);
    }
    if (other.isSetSuper_column()) {
      this.super_column = new byte[other.super_column.length];
      System.arraycopy(other.super_column, 0, super_column, 0, other.super_column.length);
    }
    if (other.isSetPredicate()) {
      this.predicate = new SlicePredicate(other.predicate);
    }
  }

  public Deletion deepCopy() {
    return new Deletion(this);
  }

  @Deprecated
  public Deletion clone() {
    return new Deletion(this);
  }

  public Clock getClock() {
    return this.clock;
  }

  public Deletion setClock(Clock clock) {
    this.clock = clock;
    return this;
  }

  public void unsetClock() {
    this.clock = null;
  }

  /** Returns true if field clock is set (has been asigned a value) and false otherwise */
  public boolean isSetClock() {
    return this.clock != null;
  }

  public void setClockIsSet(boolean value) {
    if (!value) {
      this.clock = null;
    }
  }

  public byte[] getSuper_column() {
    return this.super_column;
  }

  public Deletion setSuper_column(byte[] super_column) {
    this.super_column = super_column;
    return this;
  }

  public void unsetSuper_column() {
    this.super_column = null;
  }

  /** Returns true if field super_column is set (has been asigned a value) and false otherwise */
  public boolean isSetSuper_column() {
    return this.super_column != null;
  }

  public void setSuper_columnIsSet(boolean value) {
    if (!value) {
      this.super_column = null;
    }
  }

  public SlicePredicate getPredicate() {
    return this.predicate;
  }

  public Deletion setPredicate(SlicePredicate predicate) {
    this.predicate = predicate;
    return this;
  }

  public void unsetPredicate() {
    this.predicate = null;
  }

  /** Returns true if field predicate is set (has been asigned a value) and false otherwise */
  public boolean isSetPredicate() {
    return this.predicate != null;
  }

  public void setPredicateIsSet(boolean value) {
    if (!value) {
      this.predicate = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case CLOCK:
      if (value == null) {
        unsetClock();
      } else {
        setClock((Clock)value);
      }
      break;

    case SUPER_COLUMN:
      if (value == null) {
        unsetSuper_column();
      } else {
        setSuper_column((byte[])value);
      }
      break;

    case PREDICATE:
      if (value == null) {
        unsetPredicate();
      } else {
        setPredicate((SlicePredicate)value);
      }
      break;

    }
  }

  public void setFieldValue(int fieldID, Object value) {
    setFieldValue(_Fields.findByThriftIdOrThrow(fieldID), value);
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case CLOCK:
      return getClock();

    case SUPER_COLUMN:
      return getSuper_column();

    case PREDICATE:
      return getPredicate();

    }
    throw new IllegalStateException();
  }

  public Object getFieldValue(int fieldId) {
    return getFieldValue(_Fields.findByThriftIdOrThrow(fieldId));
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    switch (field) {
    case CLOCK:
      return isSetClock();
    case SUPER_COLUMN:
      return isSetSuper_column();
    case PREDICATE:
      return isSetPredicate();
    }
    throw new IllegalStateException();
  }

  public boolean isSet(int fieldID) {
    return isSet(_Fields.findByThriftIdOrThrow(fieldID));
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Deletion)
      return this.equals((Deletion)that);
    return false;
  }

  public boolean equals(Deletion that) {
    if (that == null)
      return false;

    boolean this_present_clock = true && this.isSetClock();
    boolean that_present_clock = true && that.isSetClock();
    if (this_present_clock || that_present_clock) {
      if (!(this_present_clock && that_present_clock))
        return false;
      if (!this.clock.equals(that.clock))
        return false;
    }

    boolean this_present_super_column = true && this.isSetSuper_column();
    boolean that_present_super_column = true && that.isSetSuper_column();
    if (this_present_super_column || that_present_super_column) {
      if (!(this_present_super_column && that_present_super_column))
        return false;
      if (!java.util.Arrays.equals(this.super_column, that.super_column))
        return false;
    }

    boolean this_present_predicate = true && this.isSetPredicate();
    boolean that_present_predicate = true && that.isSetPredicate();
    if (this_present_predicate || that_present_predicate) {
      if (!(this_present_predicate && that_present_predicate))
        return false;
      if (!this.predicate.equals(that.predicate))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Deletion other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Deletion typedOther = (Deletion)other;

    lastComparison = Boolean.valueOf(isSetClock()).compareTo(typedOther.isSetClock());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClock()) {      lastComparison = TBaseHelper.compareTo(this.clock, typedOther.clock);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetSuper_column()).compareTo(typedOther.isSetSuper_column());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSuper_column()) {      lastComparison = TBaseHelper.compareTo(this.super_column, typedOther.super_column);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPredicate()).compareTo(typedOther.isSetPredicate());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPredicate()) {      lastComparison = TBaseHelper.compareTo(this.predicate, typedOther.predicate);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // CLOCK
          if (field.type == TType.STRUCT) {
            this.clock = new Clock();
            this.clock.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // SUPER_COLUMN
          if (field.type == TType.STRING) {
            this.super_column = iprot.readBinary();
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // PREDICATE
          if (field.type == TType.STRUCT) {
            this.predicate = new SlicePredicate();
            this.predicate.read(iprot);
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.clock != null) {
      oprot.writeFieldBegin(CLOCK_FIELD_DESC);
      this.clock.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.super_column != null) {
      if (isSetSuper_column()) {
        oprot.writeFieldBegin(SUPER_COLUMN_FIELD_DESC);
        oprot.writeBinary(this.super_column);
        oprot.writeFieldEnd();
      }
    }
    if (this.predicate != null) {
      if (isSetPredicate()) {
        oprot.writeFieldBegin(PREDICATE_FIELD_DESC);
        this.predicate.write(oprot);
        oprot.writeFieldEnd();
      }
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Deletion(");
    boolean first = true;

    sb.append("clock:");
    if (this.clock == null) {
      sb.append("null");
    } else {
      sb.append(this.clock);
    }
    first = false;
    if (isSetSuper_column()) {
      if (!first) sb.append(", ");
      sb.append("super_column:");
      if (this.super_column == null) {
        sb.append("null");
      } else {
          int __super_column_size = Math.min(this.super_column.length, 128);
          for (int i = 0; i < __super_column_size; i++) {
            if (i != 0) sb.append(" ");
            sb.append(Integer.toHexString(this.super_column[i]).length() > 1 ? Integer.toHexString(this.super_column[i]).substring(Integer.toHexString(this.super_column[i]).length() - 2).toUpperCase() : "0" + Integer.toHexString(this.super_column[i]).toUpperCase());
          }
          if (this.super_column.length > 128) sb.append(" ...");
      }
      first = false;
    }
    if (isSetPredicate()) {
      if (!first) sb.append(", ");
      sb.append("predicate:");
      if (this.predicate == null) {
        sb.append("null");
      } else {
        sb.append(this.predicate);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
    if (clock == null) {
      throw new TProtocolException("Required field 'clock' was not present! Struct: " + toString());
    }
  }

}

