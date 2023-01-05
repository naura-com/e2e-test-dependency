// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComAppEntrance;

public abstract class _RemoteCallbackManagerDisp extends Ice.ObjectImpl implements RemoteCallbackManager
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
	throws CloneNotSupportedException
    {
	throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
	"::IComAppEntrance::RemoteCallbackManager",
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
    createCallback(Ice.Identity id, Ice.StringHolder err)
    {
	return createCallback(id, err, null);
    }

    public final boolean
    createCallbacks(Ice.Identity[] ids)
    {
	return createCallbacks(ids, null);
    }

    public final void
    deleteCallbacks(String category)
    {
	deleteCallbacks(category, null);
    }

    public final RemoteCallbackType
    getType()
    {
	return getType(null);
    }

    public final boolean
    refreshCallbacks(String categroy)
    {
	return refreshCallbacks(categroy, null);
    }

    public static IceInternal.DispatchStatus
    ___createCallback(RemoteCallbackManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	Ice.Identity id;
	id = new Ice.Identity();
	id.__read(__is);
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.createCallback(id, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___createCallbacks(RemoteCallbackManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	Ice.Identity[] ids;
	ids = Ice.IdentitySeqHelper.read(__is);
	boolean __ret = __obj.createCallbacks(ids, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___refreshCallbacks(RemoteCallbackManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String categroy;
	categroy = __is.readString();
	boolean __ret = __obj.refreshCallbacks(categroy, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___deleteCallbacks(RemoteCallbackManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	String category;
	category = __is.readString();
	__obj.deleteCallbacks(category, __current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getType(RemoteCallbackManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	RemoteCallbackType __ret = __obj.getType(__current);
	__ret.__write(__os);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
	"createCallback",
	"createCallbacks",
	"deleteCallbacks",
	"getType",
	"ice_id",
	"ice_ids",
	"ice_isA",
	"ice_ping",
	"refreshCallbacks"
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
		return ___createCallback(this, in, __current);
	    }
	    case 1:
	    {
		return ___createCallbacks(this, in, __current);
	    }
	    case 2:
	    {
		return ___deleteCallbacks(this, in, __current);
	    }
	    case 3:
	    {
		return ___getType(this, in, __current);
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
		return ___refreshCallbacks(this, in, __current);
	    }
	}

	assert(false);
	return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
