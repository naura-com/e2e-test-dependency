// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComData;

public class RemoteDataInfo extends Ice.ObjectImpl {
    public RemoteDataInfo() {
    }

    public RemoteDataInfo(RemoteDataType type, RemoteAccessMode accessMode, boolean isSimulated, int nodeNum, int channelNum) {
        this.type = type;
        this.accessMode = accessMode;
        this.isSimulated = isSimulated;
        this.nodeNum = nodeNum;
        this.channelNum = channelNum;
    }

    private static class __F extends Ice.LocalObjectImpl implements Ice.ObjectFactory {
        public Ice.Object
        create(String type) {
            assert (type.equals(ice_staticId()));
            return new RemoteDataInfo();
        }

        public void
        destroy() {
        }
    }

    private static Ice.ObjectFactory _factory = new __F();

    public static Ice.ObjectFactory
    ice_factory() {
        return _factory;
    }

    public static final String[] __ids =
            {
                    "::IComData::RemoteDataInfo",
                    "::Ice::Object"
            };

    public boolean
    ice_isA(String s) {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current) {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids() {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current) {
        return __ids;
    }

    public String
    ice_id() {
        return __ids[0];
    }

    public String
    ice_id(Ice.Current __current) {
        return __ids[0];
    }

    public static String
    ice_staticId() {
        return __ids[0];
    }

    public void
    __write(IceInternal.BasicStream __os) {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        type.__write(__os);
        accessMode.__write(__os);
        __os.writeBool(isSimulated);
        __os.writeInt(nodeNum);
        __os.writeInt(channelNum);
        __os.endWriteSlice();
        super.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid) {
        if (__rid) {
            __is.readTypeId();
        }
        __is.startReadSlice();
        type = RemoteDataType.__read(__is);
        accessMode = RemoteAccessMode.__read(__is);
        isSimulated = __is.readBool();
        nodeNum = __is.readInt();
        channelNum = __is.readInt();
        __is.endReadSlice();
        super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS) {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type IComData::RemoteDataInfo was not generated with stream support";
        throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid) {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type IComData::RemoteDataInfo was not generated with stream support";
        throw ex;
    }

    public RemoteDataType type;

    public RemoteAccessMode accessMode;

    public boolean isSimulated;

    public int nodeNum;

    public int channelNum;
}
