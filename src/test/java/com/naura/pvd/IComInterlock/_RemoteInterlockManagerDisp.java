// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComInterlock;

public abstract class _RemoteInterlockManagerDisp extends Ice.ObjectImpl implements RemoteInterlockManager
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
	throws CloneNotSupportedException
    {
	throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
	"::IComInterlock::RemoteInterlockManager",
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

    public final boolean
    activate(String id)
    {
	return activate(id, null);
    }

    public final boolean
    deactivate(String id)
    {
	return deactivate(id, null);
    }

    public final RemoteInterlockInfo[]
    getAllInterlockInfos()
    {
	return getAllInterlockInfos(null);
    }

    public final RemoteInterlockInfo
    getInterlockInfo(String id)
    {
	return getInterlockInfo(id, null);
    }

    public final boolean
    isActive(String id)
    {
	return isActive(id, null);
    }

    public static IceInternal.DispatchStatus
    ___getInterlockInfo(RemoteInterlockManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String id;
	id = __is.readString();
	RemoteInterlockInfo __ret = __obj.getInterlockInfo(id, __current);
	__os.writeObject(__ret);
	__os.writePendingObjects();
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getAllInterlockInfos(RemoteInterlockManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	RemoteInterlockInfo[] __ret = __obj.getAllInterlockInfos(__current);
	RemoteInterlockInfoSeqHelper.write(__os, __ret);
	__os.writePendingObjects();
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___isActive(RemoteInterlockManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String id;
	id = __is.readString();
	boolean __ret = __obj.isActive(id, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___activate(RemoteInterlockManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String id;
	id = __is.readString();
	boolean __ret = __obj.activate(id, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___deactivate(RemoteInterlockManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String id;
	id = __is.readString();
	boolean __ret = __obj.deactivate(id, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
	"activate",
	"deactivate",
	"getAllInterlockInfos",
	"getInterlockInfo",
	"ice_id",
	"ice_ids",
	"ice_isA",
	"ice_ping",
	"isActive"
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
		return ___activate(this, in, __current);
	    }
	    case 1:
	    {
		return ___deactivate(this, in, __current);
	    }
	    case 2:
	    {
		return ___getAllInterlockInfos(this, in, __current);
	    }
	    case 3:
	    {
		return ___getInterlockInfo(this, in, __current);
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
		return ___isActive(this, in, __current);
	    }
	}

	assert(false);
	return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
