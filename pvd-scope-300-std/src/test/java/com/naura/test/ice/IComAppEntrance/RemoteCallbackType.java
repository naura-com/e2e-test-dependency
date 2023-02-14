// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComAppEntrance;

public final class RemoteCallbackType {
    private static RemoteCallbackType[] __values = new RemoteCallbackType[2];
    private int __value;

    public static final int _BICESTORM = 0;
    public static final RemoteCallbackType BICESTORM = new RemoteCallbackType(_BICESTORM);
    public static final int _BIDIRECTION = 1;
    public static final RemoteCallbackType BIDIRECTION = new RemoteCallbackType(_BIDIRECTION);

    public static RemoteCallbackType
    convert(int val) {
        assert val < 2;
        return __values[val];
    }

    public static RemoteCallbackType
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

    private RemoteCallbackType(int val) {
        __value = val;
        __values[val] = this;
    }

    public void
    __write(IceInternal.BasicStream __os) {
        __os.writeByte((byte) __value);
    }

    public static RemoteCallbackType
    __read(IceInternal.BasicStream __is) {
        int __v = __is.readByte();
        if (__v < 0 || __v >= 2) {
            throw new Ice.MarshalException();
        }
        return RemoteCallbackType.convert(__v);
    }

    final static private String[] __T =
            {
                    "BICESTORM",
                    "BIDIRECTION"
            };
}
