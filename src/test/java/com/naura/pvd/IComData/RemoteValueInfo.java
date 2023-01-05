// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComData;

public class RemoteValueInfo extends Ice.ObjectImpl
{
    public RemoteValueInfo()
    {
    }

    public RemoteValueInfo(RemoteDataType type, RemoteValidity validity, long timeStamp, String transTimeStamp)
    {
	this.type = type;
	this.validity = validity;
	this.timeStamp = timeStamp;
	this.transTimeStamp = transTimeStamp;
    }

    private static class __F extends Ice.LocalObjectImpl implements Ice.ObjectFactory
    {
	public Ice.Object
	create(String type)
	{
	    assert(type.equals(ice_staticId()));
	    return new RemoteValueInfo();
	}

	public void
	destroy()
	{
	}
    }
    private static Ice.ObjectFactory _factory = new __F();

    public static Ice.ObjectFactory
    ice_factory()
    {
	return _factory;
    }

    public static final String[] __ids =
    {
	"::IComData::RemoteValueInfo",
	"::Ice::Object"
    };

    public boolean
    ice_isA(String s)
    {
	return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
	return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
	return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
	return __ids;
    }

    public String
    ice_id()
    {
	return __ids[0];
    }

    public String
    ice_id(Ice.Current __current)
    {
	return __ids[0];
    }

    public static String
    ice_staticId()
    {
	return __ids[0];
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
	__os.writeTypeId(ice_staticId());
	__os.startWriteSlice();
	type.__write(__os);
	validity.__write(__os);
	__os.writeLong(timeStamp);
	__os.writeString(transTimeStamp);
	__os.endWriteSlice();
	super.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
	if(__rid)
	{
	    __is.readTypeId();
	}
	__is.startReadSlice();
	type = RemoteDataType.__read(__is);
	validity = RemoteValidity.__read(__is);
	timeStamp = __is.readLong();
	transTimeStamp = __is.readString();
	__is.endReadSlice();
	super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
	Ice.MarshalException ex = new Ice.MarshalException();
	ex.reason = "type IComData::RemoteValueInfo was not generated with stream support";
	throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
	Ice.MarshalException ex = new Ice.MarshalException();
	ex.reason = "type IComData::RemoteValueInfo was not generated with stream support";
	throw ex;
    }

    public RemoteDataType type;

    public RemoteValidity validity;

    public long timeStamp;

    public String transTimeStamp;
}
