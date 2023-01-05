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

public class RemoteAlarmInfo extends Ice.ObjectImpl
{
    public RemoteAlarmInfo()
    {
    }

    public RemoteAlarmInfo(RemoteAlarmType type, String name, int number, String message, String description, boolean isPosted, String poster, RemoteAlarmSeverity severity, boolean hasAutoRecovery, RemoteRecoveryInfo[] optRecoveryInfos)
    {
	this.type = type;
	this.name = name;
	this.number = number;
	this.message = message;
	this.description = description;
	this.isPosted = isPosted;
	this.poster = poster;
	this.severity = severity;
	this.hasAutoRecovery = hasAutoRecovery;
	this.optRecoveryInfos = optRecoveryInfos;
    }

    private static class __F extends Ice.LocalObjectImpl implements Ice.ObjectFactory
    {
	public Ice.Object
	create(String type)
	{
	    assert(type.equals(ice_staticId()));
	    return new RemoteAlarmInfo();
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
	"::IComAlarm::RemoteAlarmInfo",
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
	__os.writeString(name);
	__os.writeInt(number);
	__os.writeString(message);
	__os.writeString(description);
	__os.writeBool(isPosted);
	__os.writeString(poster);
	severity.__write(__os);
	__os.writeBool(hasAutoRecovery);
	RemoteRecoveryInfoSeqHelper.write(__os, optRecoveryInfos);
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
	type = RemoteAlarmType.__read(__is);
	name = __is.readString();
	number = __is.readInt();
	message = __is.readString();
	description = __is.readString();
	isPosted = __is.readBool();
	poster = __is.readString();
	severity = RemoteAlarmSeverity.__read(__is);
	hasAutoRecovery = __is.readBool();
	optRecoveryInfos = RemoteRecoveryInfoSeqHelper.read(__is);
	__is.endReadSlice();
	super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
	Ice.MarshalException ex = new Ice.MarshalException();
	ex.reason = "type IComAlarm::RemoteAlarmInfo was not generated with stream support";
	throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
	Ice.MarshalException ex = new Ice.MarshalException();
	ex.reason = "type IComAlarm::RemoteAlarmInfo was not generated with stream support";
	throw ex;
    }

    public RemoteAlarmType type;

    public String name;

    public int number;

    public String message;

    public String description;

    public boolean isPosted;

    public String poster;

    public RemoteAlarmSeverity severity;

    public boolean hasAutoRecovery;

    public RemoteRecoveryInfo[] optRecoveryInfos;
}
