// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task.proto

package com.chaos.dr.strange.model;

public final class Task {
  private Task() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface TaskProtoOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // required uint32 typ = 1;
    /**
     * <code>required uint32 typ = 1;</code>
     */
    boolean hasTyp();
    /**
     * <code>required uint32 typ = 1;</code>
     */
    int getTyp();

    // required uint64 delayTime = 2;
    /**
     * <code>required uint64 delayTime = 2;</code>
     */
    boolean hasDelayTime();
    /**
     * <code>required uint64 delayTime = 2;</code>
     */
    long getDelayTime();

    // required string reqTyp = 3;
    /**
     * <code>required string reqTyp = 3;</code>
     */
    boolean hasReqTyp();
    /**
     * <code>required string reqTyp = 3;</code>
     */
    java.lang.String getReqTyp();
    /**
     * <code>required string reqTyp = 3;</code>
     */
    com.google.protobuf.ByteString
        getReqTypBytes();

    // required string reqUrl = 4;
    /**
     * <code>required string reqUrl = 4;</code>
     */
    boolean hasReqUrl();
    /**
     * <code>required string reqUrl = 4;</code>
     */
    java.lang.String getReqUrl();
    /**
     * <code>required string reqUrl = 4;</code>
     */
    com.google.protobuf.ByteString
        getReqUrlBytes();

    // required string reqContent = 5;
    /**
     * <code>required string reqContent = 5;</code>
     */
    boolean hasReqContent();
    /**
     * <code>required string reqContent = 5;</code>
     */
    java.lang.String getReqContent();
    /**
     * <code>required string reqContent = 5;</code>
     */
    com.google.protobuf.ByteString
        getReqContentBytes();
  }
  /**
   * Protobuf type {@code com.chaos.dr.strange.model.TaskProto}
   */
  public static final class TaskProto extends
      com.google.protobuf.GeneratedMessage
      implements TaskProtoOrBuilder {
    // Use TaskProto.newBuilder() to construct.
    private TaskProto(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private TaskProto(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final TaskProto defaultInstance;
    public static TaskProto getDefaultInstance() {
      return defaultInstance;
    }

    public TaskProto getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private TaskProto(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              typ_ = input.readUInt32();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              delayTime_ = input.readUInt64();
              break;
            }
            case 26: {
              bitField0_ |= 0x00000004;
              reqTyp_ = input.readBytes();
              break;
            }
            case 34: {
              bitField0_ |= 0x00000008;
              reqUrl_ = input.readBytes();
              break;
            }
            case 42: {
              bitField0_ |= 0x00000010;
              reqContent_ = input.readBytes();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.chaos.dr.strange.model.Task.internal_static_com_chaos_dr_strange_model_TaskProto_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.chaos.dr.strange.model.Task.internal_static_com_chaos_dr_strange_model_TaskProto_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.chaos.dr.strange.model.Task.TaskProto.class, com.chaos.dr.strange.model.Task.TaskProto.Builder.class);
    }

    public static com.google.protobuf.Parser<TaskProto> PARSER =
        new com.google.protobuf.AbstractParser<TaskProto>() {
      public TaskProto parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new TaskProto(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<TaskProto> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // required uint32 typ = 1;
    public static final int TYP_FIELD_NUMBER = 1;
    private int typ_;
    /**
     * <code>required uint32 typ = 1;</code>
     */
    public boolean hasTyp() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required uint32 typ = 1;</code>
     */
    public int getTyp() {
      return typ_;
    }

    // required uint64 delayTime = 2;
    public static final int DELAYTIME_FIELD_NUMBER = 2;
    private long delayTime_;
    /**
     * <code>required uint64 delayTime = 2;</code>
     */
    public boolean hasDelayTime() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required uint64 delayTime = 2;</code>
     */
    public long getDelayTime() {
      return delayTime_;
    }

    // required string reqTyp = 3;
    public static final int REQTYP_FIELD_NUMBER = 3;
    private java.lang.Object reqTyp_;
    /**
     * <code>required string reqTyp = 3;</code>
     */
    public boolean hasReqTyp() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>required string reqTyp = 3;</code>
     */
    public java.lang.String getReqTyp() {
      java.lang.Object ref = reqTyp_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          reqTyp_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string reqTyp = 3;</code>
     */
    public com.google.protobuf.ByteString
        getReqTypBytes() {
      java.lang.Object ref = reqTyp_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        reqTyp_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string reqUrl = 4;
    public static final int REQURL_FIELD_NUMBER = 4;
    private java.lang.Object reqUrl_;
    /**
     * <code>required string reqUrl = 4;</code>
     */
    public boolean hasReqUrl() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>required string reqUrl = 4;</code>
     */
    public java.lang.String getReqUrl() {
      java.lang.Object ref = reqUrl_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          reqUrl_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string reqUrl = 4;</code>
     */
    public com.google.protobuf.ByteString
        getReqUrlBytes() {
      java.lang.Object ref = reqUrl_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        reqUrl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    // required string reqContent = 5;
    public static final int REQCONTENT_FIELD_NUMBER = 5;
    private java.lang.Object reqContent_;
    /**
     * <code>required string reqContent = 5;</code>
     */
    public boolean hasReqContent() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>required string reqContent = 5;</code>
     */
    public java.lang.String getReqContent() {
      java.lang.Object ref = reqContent_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          reqContent_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string reqContent = 5;</code>
     */
    public com.google.protobuf.ByteString
        getReqContentBytes() {
      java.lang.Object ref = reqContent_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        reqContent_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      typ_ = 0;
      delayTime_ = 0L;
      reqTyp_ = "";
      reqUrl_ = "";
      reqContent_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      if (!hasTyp()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasDelayTime()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasReqTyp()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasReqUrl()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasReqContent()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeUInt32(1, typ_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeUInt64(2, delayTime_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeBytes(3, getReqTypBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeBytes(4, getReqUrlBytes());
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeBytes(5, getReqContentBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(1, typ_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt64Size(2, delayTime_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, getReqTypBytes());
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(4, getReqUrlBytes());
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(5, getReqContentBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.chaos.dr.strange.model.Task.TaskProto parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.chaos.dr.strange.model.Task.TaskProto parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.chaos.dr.strange.model.Task.TaskProto parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.chaos.dr.strange.model.Task.TaskProto parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.chaos.dr.strange.model.Task.TaskProto parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.chaos.dr.strange.model.Task.TaskProto parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.chaos.dr.strange.model.Task.TaskProto parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.chaos.dr.strange.model.Task.TaskProto parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.chaos.dr.strange.model.Task.TaskProto parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.chaos.dr.strange.model.Task.TaskProto parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.chaos.dr.strange.model.Task.TaskProto prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.chaos.dr.strange.model.TaskProto}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements com.chaos.dr.strange.model.Task.TaskProtoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.chaos.dr.strange.model.Task.internal_static_com_chaos_dr_strange_model_TaskProto_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.chaos.dr.strange.model.Task.internal_static_com_chaos_dr_strange_model_TaskProto_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.chaos.dr.strange.model.Task.TaskProto.class, com.chaos.dr.strange.model.Task.TaskProto.Builder.class);
      }

      // Construct using com.chaos.dr.strange.model.Task.TaskProto.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        typ_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        delayTime_ = 0L;
        bitField0_ = (bitField0_ & ~0x00000002);
        reqTyp_ = "";
        bitField0_ = (bitField0_ & ~0x00000004);
        reqUrl_ = "";
        bitField0_ = (bitField0_ & ~0x00000008);
        reqContent_ = "";
        bitField0_ = (bitField0_ & ~0x00000010);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.chaos.dr.strange.model.Task.internal_static_com_chaos_dr_strange_model_TaskProto_descriptor;
      }

      public com.chaos.dr.strange.model.Task.TaskProto getDefaultInstanceForType() {
        return com.chaos.dr.strange.model.Task.TaskProto.getDefaultInstance();
      }

      public com.chaos.dr.strange.model.Task.TaskProto build() {
        com.chaos.dr.strange.model.Task.TaskProto result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.chaos.dr.strange.model.Task.TaskProto buildPartial() {
        com.chaos.dr.strange.model.Task.TaskProto result = new com.chaos.dr.strange.model.Task.TaskProto(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.typ_ = typ_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.delayTime_ = delayTime_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.reqTyp_ = reqTyp_;
        if (((from_bitField0_ & 0x00000008) == 0x00000008)) {
          to_bitField0_ |= 0x00000008;
        }
        result.reqUrl_ = reqUrl_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000010;
        }
        result.reqContent_ = reqContent_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.chaos.dr.strange.model.Task.TaskProto) {
          return mergeFrom((com.chaos.dr.strange.model.Task.TaskProto)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.chaos.dr.strange.model.Task.TaskProto other) {
        if (other == com.chaos.dr.strange.model.Task.TaskProto.getDefaultInstance()) return this;
        if (other.hasTyp()) {
          setTyp(other.getTyp());
        }
        if (other.hasDelayTime()) {
          setDelayTime(other.getDelayTime());
        }
        if (other.hasReqTyp()) {
          bitField0_ |= 0x00000004;
          reqTyp_ = other.reqTyp_;
          onChanged();
        }
        if (other.hasReqUrl()) {
          bitField0_ |= 0x00000008;
          reqUrl_ = other.reqUrl_;
          onChanged();
        }
        if (other.hasReqContent()) {
          bitField0_ |= 0x00000010;
          reqContent_ = other.reqContent_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasTyp()) {
          
          return false;
        }
        if (!hasDelayTime()) {
          
          return false;
        }
        if (!hasReqTyp()) {
          
          return false;
        }
        if (!hasReqUrl()) {
          
          return false;
        }
        if (!hasReqContent()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.chaos.dr.strange.model.Task.TaskProto parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.chaos.dr.strange.model.Task.TaskProto) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // required uint32 typ = 1;
      private int typ_ ;
      /**
       * <code>required uint32 typ = 1;</code>
       */
      public boolean hasTyp() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required uint32 typ = 1;</code>
       */
      public int getTyp() {
        return typ_;
      }
      /**
       * <code>required uint32 typ = 1;</code>
       */
      public Builder setTyp(int value) {
        bitField0_ |= 0x00000001;
        typ_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint32 typ = 1;</code>
       */
      public Builder clearTyp() {
        bitField0_ = (bitField0_ & ~0x00000001);
        typ_ = 0;
        onChanged();
        return this;
      }

      // required uint64 delayTime = 2;
      private long delayTime_ ;
      /**
       * <code>required uint64 delayTime = 2;</code>
       */
      public boolean hasDelayTime() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required uint64 delayTime = 2;</code>
       */
      public long getDelayTime() {
        return delayTime_;
      }
      /**
       * <code>required uint64 delayTime = 2;</code>
       */
      public Builder setDelayTime(long value) {
        bitField0_ |= 0x00000002;
        delayTime_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required uint64 delayTime = 2;</code>
       */
      public Builder clearDelayTime() {
        bitField0_ = (bitField0_ & ~0x00000002);
        delayTime_ = 0L;
        onChanged();
        return this;
      }

      // required string reqTyp = 3;
      private java.lang.Object reqTyp_ = "";
      /**
       * <code>required string reqTyp = 3;</code>
       */
      public boolean hasReqTyp() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>required string reqTyp = 3;</code>
       */
      public java.lang.String getReqTyp() {
        java.lang.Object ref = reqTyp_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          reqTyp_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string reqTyp = 3;</code>
       */
      public com.google.protobuf.ByteString
          getReqTypBytes() {
        java.lang.Object ref = reqTyp_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          reqTyp_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string reqTyp = 3;</code>
       */
      public Builder setReqTyp(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        reqTyp_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string reqTyp = 3;</code>
       */
      public Builder clearReqTyp() {
        bitField0_ = (bitField0_ & ~0x00000004);
        reqTyp_ = getDefaultInstance().getReqTyp();
        onChanged();
        return this;
      }
      /**
       * <code>required string reqTyp = 3;</code>
       */
      public Builder setReqTypBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000004;
        reqTyp_ = value;
        onChanged();
        return this;
      }

      // required string reqUrl = 4;
      private java.lang.Object reqUrl_ = "";
      /**
       * <code>required string reqUrl = 4;</code>
       */
      public boolean hasReqUrl() {
        return ((bitField0_ & 0x00000008) == 0x00000008);
      }
      /**
       * <code>required string reqUrl = 4;</code>
       */
      public java.lang.String getReqUrl() {
        java.lang.Object ref = reqUrl_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          reqUrl_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string reqUrl = 4;</code>
       */
      public com.google.protobuf.ByteString
          getReqUrlBytes() {
        java.lang.Object ref = reqUrl_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          reqUrl_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string reqUrl = 4;</code>
       */
      public Builder setReqUrl(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        reqUrl_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string reqUrl = 4;</code>
       */
      public Builder clearReqUrl() {
        bitField0_ = (bitField0_ & ~0x00000008);
        reqUrl_ = getDefaultInstance().getReqUrl();
        onChanged();
        return this;
      }
      /**
       * <code>required string reqUrl = 4;</code>
       */
      public Builder setReqUrlBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000008;
        reqUrl_ = value;
        onChanged();
        return this;
      }

      // required string reqContent = 5;
      private java.lang.Object reqContent_ = "";
      /**
       * <code>required string reqContent = 5;</code>
       */
      public boolean hasReqContent() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>required string reqContent = 5;</code>
       */
      public java.lang.String getReqContent() {
        java.lang.Object ref = reqContent_;
        if (!(ref instanceof java.lang.String)) {
          java.lang.String s = ((com.google.protobuf.ByteString) ref)
              .toStringUtf8();
          reqContent_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string reqContent = 5;</code>
       */
      public com.google.protobuf.ByteString
          getReqContentBytes() {
        java.lang.Object ref = reqContent_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          reqContent_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string reqContent = 5;</code>
       */
      public Builder setReqContent(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        reqContent_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string reqContent = 5;</code>
       */
      public Builder clearReqContent() {
        bitField0_ = (bitField0_ & ~0x00000010);
        reqContent_ = getDefaultInstance().getReqContent();
        onChanged();
        return this;
      }
      /**
       * <code>required string reqContent = 5;</code>
       */
      public Builder setReqContentBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000010;
        reqContent_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.chaos.dr.strange.model.TaskProto)
    }

    static {
      defaultInstance = new TaskProto(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.chaos.dr.strange.model.TaskProto)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_chaos_dr_strange_model_TaskProto_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_chaos_dr_strange_model_TaskProto_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\ntask.proto\022\032com.chaos.dr.strange.model" +
      "\"_\n\tTaskProto\022\013\n\003typ\030\001 \002(\r\022\021\n\tdelayTime\030" +
      "\002 \002(\004\022\016\n\006reqTyp\030\003 \002(\t\022\016\n\006reqUrl\030\004 \002(\t\022\022\n" +
      "\nreqContent\030\005 \002(\t"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_chaos_dr_strange_model_TaskProto_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_chaos_dr_strange_model_TaskProto_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_chaos_dr_strange_model_TaskProto_descriptor,
              new java.lang.String[] { "Typ", "DelayTime", "ReqTyp", "ReqUrl", "ReqContent", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
