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

public final class RemoteBatchReaderPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteBatchReaderPrx
{
    public boolean
    initialize(String[] dataNames)
    {
	return initialize(dataNames, __defaultContext());
    }

    public boolean
    initialize(String[] dataNames, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("initialize");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteBatchReaderDel __del = (_RemoteBatchReaderDel)__delBase;
		return __del.initialize(dataNames, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteValueInfo[]
    read()
    {
	return read(__defaultContext());
    }

    public RemoteValueInfo[]
    read(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("read");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteBatchReaderDel __del = (_RemoteBatchReaderDel)__delBase;
		return __del.read(__ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public static RemoteBatchReaderPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteBatchReaderPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteBatchReaderPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteBatchReader"))
		{
		    RemoteBatchReaderPrxHelper __h = new RemoteBatchReaderPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteBatchReaderPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteBatchReaderPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteBatchReaderPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteBatchReader", __ctx))
		{
		    RemoteBatchReaderPrxHelper __h = new RemoteBatchReaderPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteBatchReaderPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteBatchReaderPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteBatchReader"))
		{
		    RemoteBatchReaderPrxHelper __h = new RemoteBatchReaderPrxHelper();
		    __h.__copyFrom(__bb);
		    __d = __h;
		}
	    }
	    catch(Ice.FacetNotExistException ex)
	    {
	    }
	}
	return __d;
    }

    public static RemoteBatchReaderPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteBatchReaderPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteBatchReader", __ctx))
		{
		    RemoteBatchReaderPrxHelper __h = new RemoteBatchReaderPrxHelper();
		    __h.__copyFrom(__bb);
		    __d = __h;
		}
	    }
	    catch(Ice.FacetNotExistException ex)
	    {
	    }
	}
	return __d;
    }

    public static RemoteBatchReaderPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteBatchReaderPrx __d = null;
	if(__obj != null)
	{
	    RemoteBatchReaderPrxHelper __h = new RemoteBatchReaderPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteBatchReaderPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteBatchReaderPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteBatchReaderPrxHelper __h = new RemoteBatchReaderPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteBatchReaderDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteBatchReaderDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteBatchReaderPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteBatchReaderPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteBatchReaderPrxHelper result = new RemoteBatchReaderPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
