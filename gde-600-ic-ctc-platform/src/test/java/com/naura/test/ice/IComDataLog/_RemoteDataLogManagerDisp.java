// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComDataLog;

public abstract class _RemoteDataLogManagerDisp extends Ice.ObjectImpl implements RemoteDataLogManager
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
	throws CloneNotSupportedException
    {
	throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
	"::IComDataLog::RemoteDataLogManager",
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

    public final String[]
    getAllDataLoggerIDs()
    {
	return getAllDataLoggerIDs(null);
    }

    public final RemoteDataLoggerInfo[]
    getAllDataLoggerInfos()
    {
	return getAllDataLoggerInfos(null);
    }

    public final RemoteDBType
    getDBType()
    {
	return getDBType(null);
    }

    public final RemoteDataLoggerInfo
    getDataLoggerInfo(String id)
    {
	return getDataLoggerInfo(id, null);
    }

    public final boolean
    startDataLogger(String id, Ice.StringHolder err)
    {
	return startDataLogger(id, err, null);
    }

    public final void
    stopDataLogger(String id)
    {
	stopDataLogger(id, null);
    }

    public static IceInternal.DispatchStatus
    ___getAllDataLoggerIDs(RemoteDataLogManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	String[] __ret = __obj.getAllDataLoggerIDs(__current);
	Ice.StringSeqHelper.write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___startDataLogger(RemoteDataLogManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String id;
	id = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.startDataLogger(id, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___stopDataLogger(RemoteDataLogManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	String id;
	id = __is.readString();
	__obj.stopDataLogger(id, __current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getDataLoggerInfo(RemoteDataLogManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String id;
	id = __is.readString();
	RemoteDataLoggerInfo __ret = __obj.getDataLoggerInfo(id, __current);
	__ret.__write(__os);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getAllDataLoggerInfos(RemoteDataLogManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	RemoteDataLoggerInfo[] __ret = __obj.getAllDataLoggerInfos(__current);
	RmtDataLoggerInfoSeqHelper.write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getDBType(RemoteDataLogManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	RemoteDBType __ret = __obj.getDBType(__current);
	__ret.__write(__os);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
	"getAllDataLoggerIDs",
	"getAllDataLoggerInfos",
	"getDBType",
	"getDataLoggerInfo",
	"ice_id",
	"ice_ids",
	"ice_isA",
	"ice_ping",
	"startDataLogger",
	"stopDataLogger"
    };

    public IceInternal.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
	int pos = java.util.Arrays.binarySearch(__all, __current.operation);
	if(pos < 0)
	{
	    return IceInternal.DispatchStatus.DispatchOperationNotExist;
	}

	switch(pos)
	{
	    case 0:
	    {
		return ___getAllDataLoggerIDs(this, in, __current);
	    }
	    case 1:
	    {
		return ___getAllDataLoggerInfos(this, in, __current);
	    }
	    case 2:
	    {
		return ___getDBType(this, in, __current);
	    }
	    case 3:
	    {
		return ___getDataLoggerInfo(this, in, __current);
	    }
	    case 4:
	    {
		return ___ice_id(this, in, __current);
	    }
	    case 5:
	    {
		return ___ice_ids(this, in, __current);
	    }
	    case 6:
	    {
		return ___ice_isA(this, in, __current);
	    }
	    case 7:
	    {
		return ___ice_ping(this, in, __current);
	    }
	    case 8:
	    {
		return ___startDataLogger(this, in, __current);
	    }
	    case 9:
	    {
		return ___stopDataLogger(this, in, __current);
	    }
	}

	assert(false);
	return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
