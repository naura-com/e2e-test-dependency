// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComData;

public abstract class _RemoteBatchReaderDisp extends Ice.ObjectImpl implements RemoteBatchReader
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
	throws CloneNotSupportedException
    {
	throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
	"::IComData::RemoteBatchReader",
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
    initialize(String[] dataNames)
    {
	return initialize(dataNames, null);
    }

    public final RemoteValueInfo[]
    read()
    {
	return read(null);
    }

    public static IceInternal.DispatchStatus
    ___initialize(RemoteBatchReader __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String[] dataNames;
	dataNames = Ice.StringSeqHelper.read(__is);
	boolean __ret = __obj.initialize(dataNames, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___read(RemoteBatchReader __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	RemoteValueInfo[] __ret = __obj.read(__current);
	RmtValueInfoSeqHelper.write(__os, __ret);
	__os.writePendingObjects();
	return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
	"ice_id",
	"ice_ids",
	"ice_isA",
	"ice_ping",
	"initialize",
	"read"
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
		return ___ice_id(this, in, __current);
	    }
	    case 1:
	    {
		return ___ice_ids(this, in, __current);
	    }
	    case 2:
	    {
		return ___ice_isA(this, in, __current);
	    }
	    case 3:
	    {
		return ___ice_ping(this, in, __current);
	    }
	    case 4:
	    {
		return ___initialize(this, in, __current);
	    }
	    case 5:
	    {
		return ___read(this, in, __current);
	    }
	}

	assert(false);
	return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
