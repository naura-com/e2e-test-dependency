// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComInterlock;

public final class RemoteInterlockManagerPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteInterlockManagerPrx
{
    public boolean
    activate(String id)
    {
	return activate(id, __defaultContext());
    }

    public boolean
    activate(String id, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("activate");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteInterlockManagerDel __del = (_RemoteInterlockManagerDel)__delBase;
		return __del.activate(id, __ctx);
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

    public boolean
    deactivate(String id)
    {
	return deactivate(id, __defaultContext());
    }

    public boolean
    deactivate(String id, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("deactivate");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteInterlockManagerDel __del = (_RemoteInterlockManagerDel)__delBase;
		return __del.deactivate(id, __ctx);
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

    public RemoteInterlockInfo[]
    getAllInterlockInfos()
    {
	return getAllInterlockInfos(__defaultContext());
    }

    public RemoteInterlockInfo[]
    getAllInterlockInfos(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getAllInterlockInfos");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteInterlockManagerDel __del = (_RemoteInterlockManagerDel)__delBase;
		return __del.getAllInterlockInfos(__ctx);
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

    public RemoteInterlockInfo
    getInterlockInfo(String id)
    {
	return getInterlockInfo(id, __defaultContext());
    }

    public RemoteInterlockInfo
    getInterlockInfo(String id, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getInterlockInfo");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteInterlockManagerDel __del = (_RemoteInterlockManagerDel)__delBase;
		return __del.getInterlockInfo(id, __ctx);
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

    public boolean
    isActive(String id)
    {
	return isActive(id, __defaultContext());
    }

    public boolean
    isActive(String id, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("isActive");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteInterlockManagerDel __del = (_RemoteInterlockManagerDel)__delBase;
		return __del.isActive(id, __ctx);
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

    public static RemoteInterlockManagerPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteInterlockManagerPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteInterlockManagerPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComInterlock::RemoteInterlockManager"))
		{
		    RemoteInterlockManagerPrxHelper __h = new RemoteInterlockManagerPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteInterlockManagerPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteInterlockManagerPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteInterlockManagerPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComInterlock::RemoteInterlockManager", __ctx))
		{
		    RemoteInterlockManagerPrxHelper __h = new RemoteInterlockManagerPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteInterlockManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteInterlockManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComInterlock::RemoteInterlockManager"))
		{
		    RemoteInterlockManagerPrxHelper __h = new RemoteInterlockManagerPrxHelper();
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

    public static RemoteInterlockManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteInterlockManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComInterlock::RemoteInterlockManager", __ctx))
		{
		    RemoteInterlockManagerPrxHelper __h = new RemoteInterlockManagerPrxHelper();
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

    public static RemoteInterlockManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteInterlockManagerPrx __d = null;
	if(__obj != null)
	{
	    RemoteInterlockManagerPrxHelper __h = new RemoteInterlockManagerPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteInterlockManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteInterlockManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteInterlockManagerPrxHelper __h = new RemoteInterlockManagerPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteInterlockManagerDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteInterlockManagerDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteInterlockManagerPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteInterlockManagerPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteInterlockManagerPrxHelper result = new RemoteInterlockManagerPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
