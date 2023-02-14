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

public final class RemoteObjectType {
    private static RemoteObjectType[] __values = new RemoteObjectType[5];
    private int __value;

    public static final int _NONE = 0;
    public static final RemoteObjectType NONE = new RemoteObjectType(_NONE);
    public static final int _CMDT = 1;
    public static final RemoteObjectType CMDT = new RemoteObjectType(_CMDT);
    public static final int _DATA = 2;
    public static final RemoteObjectType DATA = new RemoteObjectType(_DATA);
    public static final int _CTRL = 3;
    public static final RemoteObjectType CTRL = new RemoteObjectType(_CTRL);
    public static final int _OTHER = 4;
    public static final RemoteObjectType OTHER = new RemoteObjectType(_OTHER);

    public static RemoteObjectType
    convert(int val)
    {
	assert val < 5;
	return __values[val];
    }

    public static RemoteObjectType
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
    RemoteObjectType(int val)
    {
	__value = val;
	__values[val] = this;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
	__os.writeByte((byte)__value);
    }

    public static RemoteObjectType
    __read(IceInternal.BasicStream __is)
    {
	int __v = __is.readByte();
	if(__v < 0 || __v >= 5)
	{
	    throw new Ice.MarshalException();
	}
	return RemoteObjectType.convert(__v);
    }

    final static private String[] __T =
    {
	"NONE",
	"CMDT",
	"DATA",
	"CTRL",
	"OTHER"
    };
}
