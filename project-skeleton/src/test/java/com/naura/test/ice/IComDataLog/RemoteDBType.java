// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComDataLog;

public final class RemoteDBType {
    private static RemoteDBType[] __values = new RemoteDBType[3];
    private int __value;

    public static final int _UNKNOWN = 0;
    public static final RemoteDBType UNKNOWN = new RemoteDBType(_UNKNOWN);
    public static final int _MYSQL = 1;
    public static final RemoteDBType MYSQL = new RemoteDBType(_MYSQL);
    public static final int _SQLSERVER = 2;
    public static final RemoteDBType SQLSERVER = new RemoteDBType(_SQLSERVER);

    public static RemoteDBType
    convert(int val) {
        assert val < 3;
        return __values[val];
    }

    public static RemoteDBType
    convert(String val) {
        for (int __i = 0; __i < __values.length; ++__i) {
            if (__values[__i].toString().equals(val)) {
                return __values[__i];
            }
        }
        assert false;
        return null;
    }

    public int
    value() {
        return __value;
    }

    public String
    toString() {
        return __T[__value];
    }

    private RemoteDBType(int val) {
        __value = val;
        __values[val] = this;
    }

    public void
    __write(IceInternal.BasicStream __os) {
        __os.writeByte((byte) __value);
    }

    public static RemoteDBType
    __read(IceInternal.BasicStream __is) {
        int __v = __is.readByte();
        if (__v < 0 || __v >= 3) {
            throw new Ice.MarshalException();
        }
        return RemoteDBType.convert(__v);
    }

    final static private String[] __T =
            {
                    "UNKNOWN",
                    "MYSQL",
                    "SQLSERVER"
            };
}
