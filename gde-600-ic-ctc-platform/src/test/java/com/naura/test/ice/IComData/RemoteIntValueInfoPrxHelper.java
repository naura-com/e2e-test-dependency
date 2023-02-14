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

public final class RemoteIntValueInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteIntValueInfoPrx
{
    public static RemoteIntValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteIntValueInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteIntValueInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteIntValueInfo"))
		{
		    RemoteIntValueInfoPrxHelper __h = new RemoteIntValueInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteIntValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteIntValueInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteIntValueInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteIntValueInfo", __ctx))
		{
		    RemoteIntValueInfoPrxHelper __h = new RemoteIntValueInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteIntValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteIntValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteIntValueInfo"))
		{
		    RemoteIntValueInfoPrxHelper __h = new RemoteIntValueInfoPrxHelper();
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

    public static RemoteIntValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteIntValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteIntValueInfo", __ctx))
		{
		    RemoteIntValueInfoPrxHelper __h = new RemoteIntValueInfoPrxHelper();
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

    public static RemoteIntValueInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteIntValueInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteIntValueInfoPrxHelper __h = new RemoteIntValueInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteIntValueInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteIntValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteIntValueInfoPrxHelper __h = new RemoteIntValueInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteIntValueInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteIntValueInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteIntValueInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteIntValueInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteIntValueInfoPrxHelper result = new RemoteIntValueInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
