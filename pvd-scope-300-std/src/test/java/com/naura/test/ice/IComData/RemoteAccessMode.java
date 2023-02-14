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

public final class RemoteAccessMode {
    private static RemoteAccessMode[] __values = new RemoteAccessMode[2];
    private int __value;

    public static final int _READONLY = 0;
    public static final RemoteAccessMode READONLY = new RemoteAccessMode(_READONLY);
    public static final int _READWRITE = 1;
    public static final RemoteAccessMode READWRITE = new RemoteAccessMode(_READWRITE);

    public static RemoteAccessMode
    convert(int val) {
        assert val < 2;
        return __values[val];
    }

    public static RemoteAccessMode
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

    private RemoteAccessMode(int val) {
        __value = val;
        __values[val] = this;
    }

    public void
    __write(IceInternal.BasicStream __os) {
        __os.writeByte((byte) __value);
    }

    public static RemoteAccessMode
    __read(IceInternal.BasicStream __is) {
        int __v = __is.readByte();
        if (__v < 0 || __v >= 2) {
            throw new Ice.MarshalException();
        }
        return RemoteAccessMode.convert(__v);
    }

    final static private String[] __T =
            {
                    "READONLY",
                    "READWRITE"
            };
}
