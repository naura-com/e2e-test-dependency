// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComRecipe;

import com.naura.test.ice.IComData.RemoteDataType;

public class RemoteParamInfo extends Ice.ObjectImpl {
    public RemoteParamInfo() {
    }

    public RemoteParamInfo(String name, String dataObj, String defaultValue, RemoteDataType type) {
        this.name = name;
        this.dataObj = dataObj;
        this.defaultValue = defaultValue;
        this.type = type;
    }

    private static class __F extends Ice.LocalObjectImpl implements Ice.ObjectFactory {
        @Override
        public Ice.Object
        create(String type) {
            assert (type.equals(ice_staticId()));
            return new RemoteParamInfo();
        }

        @Override
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
                    "::IComRecipe::RemoteParamInfo",
                    "::Ice::Object"
            };

    @Override
    public boolean
    ice_isA(String s) {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    @Override
    public boolean
    ice_isA(String s, Ice.Current __current) {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    @Override
    public String[]
    ice_ids() {
        return __ids;
    }

    @Override
    public String[]
    ice_ids(Ice.Current __current) {
        return __ids;
    }

    @Override
    public String
    ice_id() {
        return __ids[0];
    }

    @Override
    public String
    ice_id(Ice.Current __current) {
        return __ids[0];
    }

    public static String
    ice_staticId() {
        return __ids[0];
    }

    @Override
    public void
    __write(IceInternal.BasicStream __os) {
        __os.writeTypeId(ice_staticId());
        __os.startWriteSlice();
        __os.writeString(name);
        __os.writeString(dataObj);
        __os.writeString(defaultValue);
        type.__write(__os);
        __os.endWriteSlice();
        super.__write(__os);
    }

    @Override
    public void
    __read(IceInternal.BasicStream __is, boolean __rid) {
        if (__rid) {
            __is.readTypeId();
        }
        __is.startReadSlice();
        name = __is.readString();
        dataObj = __is.readString();
        defaultValue = __is.readString();
        type = RemoteDataType.__read(__is);
        __is.endReadSlice();
        super.__read(__is, true);
    }

    @Override
    public void
    __write(Ice.OutputStream __outS) {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type IComRecipe::RemoteParamInfo was not generated with stream support";
        throw ex;
    }

    @Override
    public void
    __read(Ice.InputStream __inS, boolean __rid) {
        Ice.MarshalException ex = new Ice.MarshalException();
        ex.reason = "type IComRecipe::RemoteParamInfo was not generated with stream support";
        throw ex;
    }

    public String name;

    public String dataObj;

    public String defaultValue;

    public RemoteDataType type;
}
