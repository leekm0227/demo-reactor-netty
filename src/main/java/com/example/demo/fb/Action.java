package com.example.demo.fb;// automatically generated by the FlatBuffers compiler, do not modify

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

@SuppressWarnings("unused")
public final class Action extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_1_12_0(); }
  public static Action getRootAsAction(ByteBuffer _bb) { return getRootAsAction(_bb, new Action()); }
  public static Action getRootAsAction(ByteBuffer _bb, Action obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Action __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public Object object() { return object(new Object()); }
  public Object object(Object obj) { int o = __offset(4); return o != 0 ? obj.__assign(__indirect(o + bb_pos), bb) : null; }

  public static int createAction(FlatBufferBuilder builder,
      int objectOffset) {
    builder.startTable(1);
    Action.addObject(builder, objectOffset);
    return Action.endAction(builder);
  }

  public static void startAction(FlatBufferBuilder builder) { builder.startTable(1); }
  public static void addObject(FlatBufferBuilder builder, int objectOffset) { builder.addOffset(0, objectOffset, 0); }
  public static int endAction(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Action get(int j) { return get(new Action(), j); }
    public Action get(Action obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}
