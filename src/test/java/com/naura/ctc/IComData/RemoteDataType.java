// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComData;

public final class RemoteDataType
{
    private static RemoteDataType[] __values = new RemoteDataType[3];
    private int __value;

    public static final int _INTDATA = 0;
    public static final RemoteDataType INTDATA = new RemoteDataType(_INTDATA);
    public static final int _STRINGDATA = 1;
    public static final RemoteDataType STRINGDATA = new RemoteDataType(_STRINGDATA);
    public static final int _DOUBLEDATA = 2;
    public static final RemoteDataType DOUBLEDATA = new RemoteDataType(_DOUBLEDATA);

    public static RemoteDataType
    convert(int val)
    {
	assert val < 3;
	return __values[val];
    }

    public static RemoteDataType
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
    RemoteDataType(int val)
    {
	__value = val;
	__values[val] = this;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
	__os.writeByte((byte)__value);
    }

    public static RemoteDataType
    __read(IceInternal.BasicStream __is)
    {
	int __v = __is.readByte();
	if(__v < 0 || __v >= 3)
	{
	    throw new Ice.MarshalException();
	}
	return RemoteDataType.convert(__v);
    }

    final static private String[] __T =
    {
	"INTDATA",
	"STRINGDATA",
	"DOUBLEDATA"
    };
}
