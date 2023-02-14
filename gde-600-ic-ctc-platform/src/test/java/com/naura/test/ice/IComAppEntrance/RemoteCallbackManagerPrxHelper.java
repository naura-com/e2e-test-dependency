// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComAppEntrance;

public final class RemoteCallbackManagerPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteCallbackManagerPrx
{
    public boolean
    createCallback(Ice.Identity id, Ice.StringHolder err)
    {
	return createCallback(id, err, __defaultContext());
    }

    public boolean
    createCallback(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("createCallback");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteCallbackManagerDel __del = (_RemoteCallbackManagerDel)__delBase;
		return __del.createCallback(id, err, __ctx);
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
    createCallbacks(Ice.Identity[] ids)
    {
	return createCallbacks(ids, __defaultContext());
    }

    public boolean
    createCallbacks(Ice.Identity[] ids, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("createCallbacks");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteCallbackManagerDel __del = (_RemoteCallbackManagerDel)__delBase;
		return __del.createCallbacks(ids, __ctx);
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

    public void
    deleteCallbacks(String category)
    {
	deleteCallbacks(category, __defaultContext());
    }

    public void
    deleteCallbacks(String category, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteCallbackManagerDel __del = (_RemoteCallbackManagerDel)__delBase;
		__del.deleteCallbacks(category, __ctx);
		return;
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

    public RemoteCallbackType
    getType()
    {
	return getType(__defaultContext());
    }

    public RemoteCallbackType
    getType(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getType");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteCallbackManagerDel __del = (_RemoteCallbackManagerDel)__delBase;
		return __del.getType(__ctx);
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
    refreshCallbacks(String categroy)
    {
	return refreshCallbacks(categroy, __defaultContext());
    }

    public boolean
    refreshCallbacks(String categroy, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("refreshCallbacks");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteCallbackManagerDel __del = (_RemoteCallbackManagerDel)__delBase;
		return __del.refreshCallbacks(categroy, __ctx);
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

    public static RemoteCallbackManagerPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteCallbackManagerPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteCallbackManagerPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComAppEntrance::RemoteCallbackManager"))
		{
		    RemoteCallbackManagerPrxHelper __h = new RemoteCallbackManagerPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteCallbackManagerPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteCallbackManagerPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteCallbackManagerPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComAppEntrance::RemoteCallbackManager", __ctx))
		{
		    RemoteCallbackManagerPrxHelper __h = new RemoteCallbackManagerPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteCallbackManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteCallbackManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComAppEntrance::RemoteCallbackManager"))
		{
		    RemoteCallbackManagerPrxHelper __h = new RemoteCallbackManagerPrxHelper();
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

    public static RemoteCallbackManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteCallbackManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComAppEntrance::RemoteCallbackManager", __ctx))
		{
		    RemoteCallbackManagerPrxHelper __h = new RemoteCallbackManagerPrxHelper();
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

    public static RemoteCallbackManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteCallbackManagerPrx __d = null;
	if(__obj != null)
	{
	    RemoteCallbackManagerPrxHelper __h = new RemoteCallbackManagerPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteCallbackManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteCallbackManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteCallbackManagerPrxHelper __h = new RemoteCallbackManagerPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteCallbackManagerDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteCallbackManagerDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteCallbackManagerPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteCallbackManagerPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteCallbackManagerPrxHelper result = new RemoteCallbackManagerPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
