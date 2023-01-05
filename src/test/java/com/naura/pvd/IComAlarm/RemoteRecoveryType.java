// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComAlarm;

public final class RemoteRecoveryType
{
    private static RemoteRecoveryType[] __values = new RemoteRecoveryType[6];
    private int __value;

    public static final int _NOTINIT = 0;
    public static final RemoteRecoveryType NOTINIT = new RemoteRecoveryType(_NOTINIT);
    public static final int _ABORT = 1;
    public static final RemoteRecoveryType ABORT = new RemoteRecoveryType(_ABORT);
    public static final int _RETRY = 2;
    public static final RemoteRecoveryType RETRY = new RemoteRecoveryType(_RETRY);
    public static final int _CONTINUE = 3;
    public static final RemoteRecoveryType CONTINUE = new RemoteRecoveryType(_CONTINUE);
    public static final int _CLEAR = 4;
    public static final RemoteRecoveryType CLEAR = new RemoteRecoveryType(_CLEAR);
    public static final int _USERTYPE = 5;
    public static final RemoteRecoveryType USERTYPE = new RemoteRecoveryType(_USERTYPE);

    public static RemoteRecoveryType
    convert(int val)
    {
	assert val < 6;
	return __values[val];
    }

    public static RemoteRecoveryType
    convert(String val)
    {
	for(int __i = 0; __i < __values.length; ++__i)
	{
	    if(__values[__i].toString().equals(val))
	    {
		return __values[__i];
	    }
	}
	assert false;
	return null;
    }

    public int
    value()
    {
	return __value;
    }

    public String
    toString()
    {
	return __T[__value];
    }

    private
    RemoteRecoveryType(int val)
    {
	__value = val;
	__values[val] = this;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
	__os.writeByte((byte)__value);
    }

    public static RemoteRecoveryType
    __read(IceInternal.BasicStream __is)
    {
	int __v = __is.readByte();
	if(__v < 0 || __v >= 6)
	{
	    throw new Ice.MarshalException();
	}
	return RemoteRecoveryType.convert(__v);
    }

    final static private String[] __T =
    {
	"NOTINIT",
	"ABORT",
	"RETRY",
	"CONTINUE",
	"CLEAR",
	"USERTYPE"
    };
}
