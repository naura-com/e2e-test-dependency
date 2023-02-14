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

public final class RemoteRcpEventType
{
    private static RemoteRcpEventType[] __values = new RemoteRcpEventType[6];
    private int __value;

    public static final int _UNKNOWN = 0;
    public static final RemoteRcpEventType UNKNOWN = new RemoteRcpEventType(_UNKNOWN);
    public static final int _CREATED = 1;
    public static final RemoteRcpEventType CREATED = new RemoteRcpEventType(_CREATED);
    public static final int _REMOVED = 2;
    public static final RemoteRcpEventType REMOVED = new RemoteRcpEventType(_REMOVED);
    public static final int _MODIFIED = 3;
    public static final RemoteRcpEventType MODIFIED = new RemoteRcpEventType(_MODIFIED);
    public static final int _SELECTED = 4;
    public static final RemoteRcpEventType SELECTED = new RemoteRcpEventType(_SELECTED);
    public static final int _DESELECTED = 5;
    public static final RemoteRcpEventType DESELECTED = new RemoteRcpEventType(_DESELECTED);

    public static RemoteRcpEventType
    convert(int val)
    {
	assert val < 6;
	return __values[val];
    }

    public static RemoteRcpEventType
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
    RemoteRcpEventType(int val)
    {
	__value = val;
	__values[val] = this;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
	__os.writeByte((byte)__value);
    }

    public static RemoteRcpEventType
    __read(IceInternal.BasicStream __is)
    {
	int __v = __is.readByte();
	if(__v < 0 || __v >= 6)
	{
	    throw new Ice.MarshalException();
	}
	return RemoteRcpEventType.convert(__v);
    }

    final static private String[] __T =
    {
	"UNKNOWN",
	"CREATED",
	"REMOVED",
	"MODIFIED",
	"SELECTED",
	"DESELECTED"
    };
}
