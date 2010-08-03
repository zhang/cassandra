package org.apache.cassandra.avro;

@SuppressWarnings("all")
public interface Cassandra {
  public static final org.apache.avro.Protocol PROTOCOL = org.apache.avro.Protocol.parse("{\"protocol\":\"Cassandra\",\"namespace\":\"org.apache.cassandra.avro\",\"types\":[{\"type\":\"enum\",\"name\":\"AccessLevel\",\"symbols\":[\"NONE\",\"READONLY\",\"READWRITE\",\"FALL\"]},{\"type\":\"record\",\"name\":\"ColumnPath\",\"fields\":[{\"name\":\"column_family\",\"type\":\"string\"},{\"name\":\"super_column\",\"type\":[\"bytes\",\"null\"]},{\"name\":\"column\",\"type\":[\"bytes\",\"null\"]}]},{\"type\":\"record\",\"name\":\"ColumnParent\",\"fields\":[{\"name\":\"column_family\",\"type\":\"string\"},{\"name\":\"super_column\",\"type\":[\"bytes\",\"null\"]}]},{\"type\":\"record\",\"name\":\"Clock\",\"fields\":[{\"name\":\"timestamp\",\"type\":\"long\"}]},{\"type\":\"record\",\"name\":\"Column\",\"fields\":[{\"name\":\"name\",\"type\":\"bytes\"},{\"name\":\"value\",\"type\":\"bytes\"},{\"name\":\"clock\",\"type\":\"Clock\"},{\"name\":\"ttl\",\"type\":[\"int\",\"null\"]}]},{\"type\":\"record\",\"name\":\"SuperColumn\",\"fields\":[{\"name\":\"name\",\"type\":\"bytes\"},{\"name\":\"columns\",\"type\":{\"type\":\"array\",\"items\":\"Column\"}}]},{\"type\":\"record\",\"name\":\"ColumnOrSuperColumn\",\"fields\":[{\"name\":\"column\",\"type\":[\"Column\",\"null\"]},{\"name\":\"super_column\",\"type\":[\"SuperColumn\",\"null\"]}]},{\"type\":\"record\",\"name\":\"SliceRange\",\"fields\":[{\"name\":\"start\",\"type\":\"bytes\"},{\"name\":\"finish\",\"type\":\"bytes\"},{\"name\":\"reversed\",\"type\":\"boolean\"},{\"name\":\"count\",\"type\":\"int\"},{\"name\":\"bitmasks\",\"type\":[{\"type\":\"array\",\"items\":\"bytes\"},\"null\"]}]},{\"type\":\"record\",\"name\":\"SlicePredicate\",\"fields\":[{\"name\":\"column_names\",\"type\":[{\"type\":\"array\",\"items\":\"bytes\"},\"null\"]},{\"name\":\"slice_range\",\"type\":[\"SliceRange\",\"null\"]}]},{\"type\":\"record\",\"name\":\"Deletion\",\"fields\":[{\"name\":\"clock\",\"type\":\"Clock\"},{\"name\":\"super_column\",\"type\":[\"bytes\",\"null\"]},{\"name\":\"predicate\",\"type\":[\"SlicePredicate\",\"null\"]}]},{\"type\":\"record\",\"name\":\"Mutation\",\"fields\":[{\"name\":\"column_or_supercolumn\",\"type\":[\"ColumnOrSuperColumn\",\"null\"]},{\"name\":\"deletion\",\"type\":[\"Deletion\",\"null\"]}]},{\"type\":\"enum\",\"name\":\"IndexType\",\"symbols\":[\"KEYS\"]},{\"type\":\"record\",\"name\":\"ColumnDef\",\"fields\":[{\"name\":\"name\",\"type\":\"bytes\"},{\"name\":\"validation_class\",\"type\":\"string\"},{\"name\":\"index_type\",\"type\":[\"IndexType\",\"null\"]},{\"name\":\"index_name\",\"type\":[\"string\",\"null\"]}]},{\"type\":\"record\",\"name\":\"CfDef\",\"fields\":[{\"name\":\"keyspace\",\"type\":\"string\"},{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"column_type\",\"type\":[\"string\",\"null\"]},{\"name\":\"clock_type\",\"type\":[\"string\",\"null\"]},{\"name\":\"comparator_type\",\"type\":[\"string\",\"null\"]},{\"name\":\"subcomparator_type\",\"type\":[\"string\",\"null\"]},{\"name\":\"reconciler\",\"type\":[\"string\",\"null\"]},{\"name\":\"comment\",\"type\":[\"string\",\"null\"]},{\"name\":\"row_cache_size\",\"type\":[\"double\",\"null\"]},{\"name\":\"preload_row_cache\",\"type\":[\"boolean\",\"null\"]},{\"name\":\"key_cache_size\",\"type\":[\"double\",\"null\"]},{\"name\":\"read_repair_chance\",\"type\":[\"double\",\"null\"]},{\"name\":\"gc_grace_seconds\",\"type\":[\"int\",\"null\"]},{\"name\":\"column_metadata\",\"type\":[{\"type\":\"array\",\"items\":\"ColumnDef\"},\"null\"]},{\"name\":\"id\",\"type\":[\"int\",\"null\"]}]},{\"type\":\"record\",\"name\":\"KsDef\",\"fields\":[{\"name\":\"name\",\"type\":\"string\"},{\"name\":\"strategy_class\",\"type\":\"string\"},{\"name\":\"strategy_options\",\"type\":[{\"type\":\"map\",\"values\":\"string\"},\"null\"]},{\"name\":\"replication_factor\",\"type\":\"int\"},{\"name\":\"cf_defs\",\"type\":{\"type\":\"array\",\"items\":\"CfDef\"}}]},{\"type\":\"record\",\"name\":\"MutationsMapEntry\",\"fields\":[{\"name\":\"key\",\"type\":\"bytes\"},{\"name\":\"mutations\",\"type\":{\"type\":\"map\",\"values\":{\"type\":\"array\",\"items\":\"Mutation\"}}}]},{\"type\":\"record\",\"name\":\"CoscsMapEntry\",\"fields\":[{\"name\":\"key\",\"type\":\"bytes\"},{\"name\":\"columns\",\"type\":{\"type\":\"array\",\"items\":\"ColumnOrSuperColumn\"}}]},{\"type\":\"enum\",\"name\":\"ConsistencyLevel\",\"symbols\":[\"ZERO\",\"ONE\",\"QUORUM\",\"DCQUORUM\",\"DCQUORUMSYNC\",\"ALL\"]},{\"type\":\"error\",\"name\":\"InvalidRequestException\",\"fields\":[{\"name\":\"why\",\"type\":[\"string\",\"null\"]}]},{\"type\":\"error\",\"name\":\"NotFoundException\",\"fields\":[{\"name\":\"why\",\"type\":[\"string\",\"null\"]}]},{\"type\":\"error\",\"name\":\"UnavailableException\",\"fields\":[{\"name\":\"why\",\"type\":[\"string\",\"null\"]}]},{\"type\":\"error\",\"name\":\"TimedOutException\",\"fields\":[{\"name\":\"why\",\"type\":[\"string\",\"null\"]}]}],\"messages\":{\"get\":{\"request\":[{\"name\":\"key\",\"type\":\"bytes\"},{\"name\":\"column_path\",\"type\":\"ColumnPath\"},{\"name\":\"consistency_level\",\"type\":\"ConsistencyLevel\"}],\"response\":\"ColumnOrSuperColumn\",\"errors\":[\"InvalidRequestException\",\"NotFoundException\",\"UnavailableException\",\"TimedOutException\"]},\"get_slice\":{\"request\":[{\"name\":\"key\",\"type\":\"bytes\"},{\"name\":\"column_parent\",\"type\":\"ColumnParent\"},{\"name\":\"predicate\",\"type\":\"SlicePredicate\"},{\"name\":\"consistency_level\",\"type\":\"ConsistencyLevel\"}],\"response\":{\"type\":\"array\",\"items\":\"ColumnOrSuperColumn\"},\"errors\":[\"InvalidRequestException\",\"UnavailableException\",\"TimedOutException\"]},\"multiget_slice\":{\"request\":[{\"name\":\"keys\",\"type\":{\"type\":\"array\",\"items\":\"bytes\"}},{\"name\":\"column_parent\",\"type\":\"ColumnParent\"},{\"name\":\"predicate\",\"type\":\"SlicePredicate\"},{\"name\":\"consistency_level\",\"type\":\"ConsistencyLevel\"}],\"response\":{\"type\":\"array\",\"items\":\"CoscsMapEntry\"},\"errors\":[\"InvalidRequestException\",\"UnavailableException\",\"TimedOutException\"]},\"get_count\":{\"request\":[{\"name\":\"key\",\"type\":\"bytes\"},{\"name\":\"column_parent\",\"type\":\"ColumnParent\"},{\"name\":\"predicate\",\"type\":\"SlicePredicate\"},{\"name\":\"consistency_level\",\"type\":\"ConsistencyLevel\"}],\"response\":\"int\",\"errors\":[\"InvalidRequestException\",\"UnavailableException\",\"TimedOutException\"]},\"insert\":{\"request\":[{\"name\":\"key\",\"type\":\"bytes\"},{\"name\":\"column_parent\",\"type\":\"ColumnParent\"},{\"name\":\"column\",\"type\":\"Column\"},{\"name\":\"consistency_level\",\"type\":\"ConsistencyLevel\"}],\"response\":\"null\",\"errors\":[\"InvalidRequestException\",\"UnavailableException\",\"TimedOutException\"]},\"remove\":{\"request\":[{\"name\":\"key\",\"type\":\"bytes\"},{\"name\":\"column_path\",\"type\":\"ColumnPath\"},{\"name\":\"clock\",\"type\":\"Clock\"},{\"name\":\"consistency_level\",\"type\":\"ConsistencyLevel\"}],\"response\":\"null\",\"errors\":[\"InvalidRequestException\",\"UnavailableException\",\"TimedOutException\"]},\"batch_mutate\":{\"request\":[{\"name\":\"mutation_map\",\"type\":{\"type\":\"array\",\"items\":\"MutationsMapEntry\"}},{\"name\":\"consistency_level\",\"type\":\"ConsistencyLevel\"}],\"response\":\"null\",\"errors\":[\"InvalidRequestException\",\"UnavailableException\",\"TimedOutException\"]},\"system_add_keyspace\":{\"request\":[{\"name\":\"ks_def\",\"type\":\"KsDef\"}],\"response\":\"null\",\"errors\":[\"InvalidRequestException\"]},\"set_keyspace\":{\"request\":[{\"name\":\"keyspace\",\"type\":\"string\"}],\"response\":\"null\",\"errors\":[\"InvalidRequestException\"]},\"describe_keyspaces\":{\"request\":[],\"response\":{\"type\":\"array\",\"items\":\"string\"}},\"describe_cluster_name\":{\"request\":[],\"response\":\"string\"},\"describe_version\":{\"request\":[],\"response\":\"string\"}}}");
  org.apache.cassandra.avro.ColumnOrSuperColumn get(java.nio.ByteBuffer key, org.apache.cassandra.avro.ColumnPath column_path, org.apache.cassandra.avro.ConsistencyLevel consistency_level)
    throws org.apache.avro.ipc.AvroRemoteException, org.apache.cassandra.avro.InvalidRequestException, org.apache.cassandra.avro.NotFoundException, org.apache.cassandra.avro.UnavailableException, org.apache.cassandra.avro.TimedOutException;
  org.apache.avro.generic.GenericArray<org.apache.cassandra.avro.ColumnOrSuperColumn> get_slice(java.nio.ByteBuffer key, org.apache.cassandra.avro.ColumnParent column_parent, org.apache.cassandra.avro.SlicePredicate predicate, org.apache.cassandra.avro.ConsistencyLevel consistency_level)
    throws org.apache.avro.ipc.AvroRemoteException, org.apache.cassandra.avro.InvalidRequestException, org.apache.cassandra.avro.UnavailableException, org.apache.cassandra.avro.TimedOutException;
  org.apache.avro.generic.GenericArray<org.apache.cassandra.avro.CoscsMapEntry> multiget_slice(org.apache.avro.generic.GenericArray<java.nio.ByteBuffer> keys, org.apache.cassandra.avro.ColumnParent column_parent, org.apache.cassandra.avro.SlicePredicate predicate, org.apache.cassandra.avro.ConsistencyLevel consistency_level)
    throws org.apache.avro.ipc.AvroRemoteException, org.apache.cassandra.avro.InvalidRequestException, org.apache.cassandra.avro.UnavailableException, org.apache.cassandra.avro.TimedOutException;
  int get_count(java.nio.ByteBuffer key, org.apache.cassandra.avro.ColumnParent column_parent, org.apache.cassandra.avro.SlicePredicate predicate, org.apache.cassandra.avro.ConsistencyLevel consistency_level)
    throws org.apache.avro.ipc.AvroRemoteException, org.apache.cassandra.avro.InvalidRequestException, org.apache.cassandra.avro.UnavailableException, org.apache.cassandra.avro.TimedOutException;
  java.lang.Void insert(java.nio.ByteBuffer key, org.apache.cassandra.avro.ColumnParent column_parent, org.apache.cassandra.avro.Column column, org.apache.cassandra.avro.ConsistencyLevel consistency_level)
    throws org.apache.avro.ipc.AvroRemoteException, org.apache.cassandra.avro.InvalidRequestException, org.apache.cassandra.avro.UnavailableException, org.apache.cassandra.avro.TimedOutException;
  java.lang.Void remove(java.nio.ByteBuffer key, org.apache.cassandra.avro.ColumnPath column_path, org.apache.cassandra.avro.Clock clock, org.apache.cassandra.avro.ConsistencyLevel consistency_level)
    throws org.apache.avro.ipc.AvroRemoteException, org.apache.cassandra.avro.InvalidRequestException, org.apache.cassandra.avro.UnavailableException, org.apache.cassandra.avro.TimedOutException;
  java.lang.Void batch_mutate(org.apache.avro.generic.GenericArray<org.apache.cassandra.avro.MutationsMapEntry> mutation_map, org.apache.cassandra.avro.ConsistencyLevel consistency_level)
    throws org.apache.avro.ipc.AvroRemoteException, org.apache.cassandra.avro.InvalidRequestException, org.apache.cassandra.avro.UnavailableException, org.apache.cassandra.avro.TimedOutException;
  java.lang.Void system_add_keyspace(org.apache.cassandra.avro.KsDef ks_def)
    throws org.apache.avro.ipc.AvroRemoteException, org.apache.cassandra.avro.InvalidRequestException;
  java.lang.Void set_keyspace(org.apache.avro.util.Utf8 keyspace)
    throws org.apache.avro.ipc.AvroRemoteException, org.apache.cassandra.avro.InvalidRequestException;
  org.apache.avro.generic.GenericArray<org.apache.avro.util.Utf8> describe_keyspaces()
    throws org.apache.avro.ipc.AvroRemoteException;
  org.apache.avro.util.Utf8 describe_cluster_name()
    throws org.apache.avro.ipc.AvroRemoteException;
  org.apache.avro.util.Utf8 describe_version()
    throws org.apache.avro.ipc.AvroRemoteException;
}
