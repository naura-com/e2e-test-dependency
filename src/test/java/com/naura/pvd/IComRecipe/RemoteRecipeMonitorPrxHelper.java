// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComRecipe;

public final class RemoteRecipeMonitorPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteRecipeMonitorPrx
{
    public void
    update(RemoteRcpMgmtEvent event)
    {
	update(event, __defaultContext());
    }

    public void
    update(RemoteRcpMgmtEvent event, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeMonitorDel __del = (_RemoteRecipeMonitorDel)__delBase;
		__del.update(event, __ctx);
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

    public static RemoteRecipeMonitorPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteRecipeMonitorPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteRecipeMonitorPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteRecipeMonitor"))
		{
		    RemoteRecipeMonitorPrxHelper __h = new RemoteRecipeMonitorPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteRecipeMonitorPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteRecipeMonitorPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteRecipeMonitorPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteRecipeMonitor", __ctx))
		{
		    RemoteRecipeMonitorPrxHelper __h = new RemoteRecipeMonitorPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteRecipeMonitorPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteRecipeMonitorPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteRecipeMonitor"))
		{
		    RemoteRecipeMonitorPrxHelper __h = new RemoteRecipeMonitorPrxHelper();
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

    public static RemoteRecipeMonitorPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteRecipeMonitorPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteRecipeMonitor", __ctx))
		{
		    RemoteRecipeMonitorPrxHelper __h = new RemoteRecipeMonitorPrxHelper();
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

    public static RemoteRecipeMonitorPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteRecipeMonitorPrx __d = null;
	if(__obj != null)
	{
	    RemoteRecipeMonitorPrxHelper __h = new RemoteRecipeMonitorPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteRecipeMonitorPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteRecipeMonitorPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteRecipeMonitorPrxHelper __h = new RemoteRecipeMonitorPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteRecipeMonitorDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteRecipeMonitorDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteRecipeMonitorPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteRecipeMonitorPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteRecipeMonitorPrxHelper result = new RemoteRecipeMonitorPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
