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

public final class RemoteInterlockInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteInterlockInfoPrx
{
    public static RemoteInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteInterlockInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComInterlock::RemoteInterlockInfo"))
		{
		    RemoteInterlockInfoPrxHelper __h = new RemoteInterlockInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteInterlockInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComInterlock::RemoteInterlockInfo", __ctx))
		{
		    RemoteInterlockInfoPrxHelper __h = new RemoteInterlockInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComInterlock::RemoteInterlockInfo"))
		{
		    RemoteInterlockInfoPrxHelper __h = new RemoteInterlockInfoPrxHelper();
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

    public static RemoteInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComInterlock::RemoteInterlockInfo", __ctx))
		{
		    RemoteInterlockInfoPrxHelper __h = new RemoteInterlockInfoPrxHelper();
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

    public static RemoteInterlockInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteInterlockInfoPrxHelper __h = new RemoteInterlockInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteInterlockInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteInterlockInfoPrxHelper __h = new RemoteInterlockInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteInterlockInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteInterlockInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteInterlockInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteInterlockInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteInterlockInfoPrxHelper result = new RemoteInterlockInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
