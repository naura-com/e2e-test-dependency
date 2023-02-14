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

public final class RemoteValidity {
    private static RemoteValidity[] __values = new RemoteValidity[5];
    private int __value;

    public static final int _NOTINIT = 0;
    public static final RemoteValidity NOTINIT = new RemoteValidity(_NOTINIT);
    public static final int _VALID = 1;
    public static final RemoteValidity VALID = new RemoteValidity(_VALID);
    public static final int _STALE = 2;
    public static final RemoteValidity STALE = new RemoteValidity(_STALE);
    public static final int _INVALID = 3;
    public static final RemoteValidity INVALID = new RemoteValidity(_INVALID);
    public static final int _OFFLINE = 4;
    public static final RemoteValidity OFFLINE = new RemoteValidity(_OFFLINE);

    public static RemoteValidity
    convert(int val) {
        assert val < 5;
        return __values[val];
    }

    public static RemoteValidity
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

    private RemoteValidity(int val) {
        __value = val;
        __values[val] = this;
    }

    public void
    __write(IceInternal.BasicStream __os) {
        __os.writeByte((byte) __value);
    }

    public static RemoteValidity
    __read(IceInternal.BasicStream __is) {
        int __v = __is.readByte();
        if (__v < 0 || __v >= 5) {
            throw new Ice.MarshalException();
        }
        return RemoteValidity.convert(__v);
    }

    final static private String[] __T =
            {
                    "NOTINIT",
                    "VALID",
                    "STALE",
                    "INVALID",
                    "OFFLINE"
            };
}
