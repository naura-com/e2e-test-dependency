// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComControlObject;

public final class RemoteControlState
{
    private static RemoteControlState[] __values = new RemoteControlState[7];
    private int __value;

    public static final int _UNKNOWN = 0;
    public static final RemoteControlState UNKNOWN = new RemoteControlState(_UNKNOWN);
    public static final int _IDLE = 1;
    public static final RemoteControlState IDLE = new RemoteControlState(_IDLE);
    public static final int _RUNNING = 2;
    public static final RemoteControlState RUNNING = new RemoteControlState(_RUNNING);
    public static final int _ALMPAUSE = 3;
    public static final RemoteControlState ALMPAUSE = new RemoteControlState(_ALMPAUSE);
    public static final int _ALMRESUME = 4;
    public static final RemoteControlState ALMRESUME = new RemoteControlState(_ALMRESUME);
    public static final int _ABORTING = 5;
    public static final RemoteControlState ABORTING = new RemoteControlState(_ABORTING);
    public static final int _ABORTED = 6;
    public static final RemoteControlState ABORTED = new RemoteControlState(_ABORTED);

    public static RemoteControlState
    convert(int val)
    {
	assert val < 7;
	return __values[val];
    }

    public static RemoteControlState
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
    RemoteControlState(int val)
    {
	__value = val;
	__values[val] = this;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
	__os.writeByte((byte)__value);
    }

    public static RemoteControlState
    __read(IceInternal.BasicStream __is)
    {
	int __v = __is.readByte();
	if(__v < 0 || __v >= 7)
	{
	    throw new Ice.MarshalException();
	}
	return RemoteControlState.convert(__v);
    }

    final static private String[] __T =
    {
	"UNKNOWN",
	"IDLE",
	"RUNNING",
	"ALMPAUSE",
	"ALMRESUME",
	"ABORTING",
	"ABORTED"
    };
}
