// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComAlarm;

public final class RemoteAlarmSeverity
{
    private static RemoteAlarmSeverity[] __values = new RemoteAlarmSeverity[6];
    private int __value;

    public static final int _UNKNOWN = 0;
    public static final RemoteAlarmSeverity UNKNOWN = new RemoteAlarmSeverity(_UNKNOWN);
    public static final int _FATAL = 1;
    public static final RemoteAlarmSeverity FATAL = new RemoteAlarmSeverity(_FATAL);
    public static final int _ERROR = 2;
    public static final RemoteAlarmSeverity ERROR = new RemoteAlarmSeverity(_ERROR);
    public static final int _PROBLEM = 3;
    public static final RemoteAlarmSeverity PROBLEM = new RemoteAlarmSeverity(_PROBLEM);
    public static final int _EVENT = 4;
    public static final RemoteAlarmSeverity EVENT = new RemoteAlarmSeverity(_EVENT);
    public static final int _NOTICE = 5;
    public static final RemoteAlarmSeverity NOTICE = new RemoteAlarmSeverity(_NOTICE);

    public static RemoteAlarmSeverity
    convert(int val)
    {
	assert val < 6;
	return __values[val];
    }

    public static RemoteAlarmSeverity
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
    RemoteAlarmSeverity(int val)
    {
	__value = val;
	__values[val] = this;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
	__os.writeByte((byte)__value);
    }

    public static RemoteAlarmSeverity
    __read(IceInternal.BasicStream __is)
    {
	int __v = __is.readByte();
	if(__v < 0 || __v >= 6)
	{
	    throw new Ice.MarshalException();
	}
	return RemoteAlarmSeverity.convert(__v);
    }

    final static private String[] __T =
    {
	"UNKNOWN",
	"FATAL",
	"ERROR",
	"PROBLEM",
	"EVENT",
	"NOTICE"
    };
}
