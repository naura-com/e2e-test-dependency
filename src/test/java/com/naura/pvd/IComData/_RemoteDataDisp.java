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

public abstract class _RemoteDataDisp extends Ice.ObjectImpl implements RemoteData
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
	throws CloneNotSupportedException
    {
	throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
	"::IComData::RemoteData",
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

    public final RemoteDataInfo
    getInfo()
    {
	return getInfo(null);
    }

    public final RemoteValueInfo
    getValue()
    {
	return getValue(null);
    }

    public final boolean
    setValue(String value, Ice.StringHolder err)
    {
	return setValue(value, err, null);
    }

    public static IceInternal.DispatchStatus
    ___setValue(RemoteData __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String value;
	value = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.setValue(value, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getValue(RemoteData __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	RemoteValueInfo __ret = __obj.getValue(__current);
	__os.writeObject(__ret);
	__os.writePendingObjects();
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getInfo(RemoteData __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	RemoteDataInfo __ret = __obj.getInfo(__current);
	__os.writeObject(__ret);
	__os.writePendingObjects();
	return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
	"getInfo",
	"getValue",
	"ice_id",
	"ice_ids",
	"ice_isA",
	"ice_ping",
	"setValue"
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
		return ___getInfo(this, in, __current);
	    }
	    case 1:
	    {
		return ___getValue(this, in, __current);
	    }
	    case 2:
	    {
		return ___ice_id(this, in, __current);
	    }
	    case 3:
	    {
		return ___ice_ids(this, in, __current);
	    }
	    case 4:
	    {
		return ___ice_isA(this, in, __current);
	    }
	    case 5:
	    {
		return ___ice_ping(this, in, __current);
	    }
	    case 6:
	    {
		return ___setValue(this, in, __current);
	    }
	}

	assert(false);
	return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
