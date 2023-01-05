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

public final class RemoteDoubleValueInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteDoubleValueInfoPrx
{
    public static RemoteDoubleValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteDoubleValueInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteDoubleValueInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteDoubleValueInfo"))
		{
		    RemoteDoubleValueInfoPrxHelper __h = new RemoteDoubleValueInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteDoubleValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteDoubleValueInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteDoubleValueInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteDoubleValueInfo", __ctx))
		{
		    RemoteDoubleValueInfoPrxHelper __h = new RemoteDoubleValueInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteDoubleValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteDoubleValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteDoubleValueInfo"))
		{
		    RemoteDoubleValueInfoPrxHelper __h = new RemoteDoubleValueInfoPrxHelper();
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

    public static RemoteDoubleValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteDoubleValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteDoubleValueInfo", __ctx))
		{
		    RemoteDoubleValueInfoPrxHelper __h = new RemoteDoubleValueInfoPrxHelper();
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

    public static RemoteDoubleValueInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteDoubleValueInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteDoubleValueInfoPrxHelper __h = new RemoteDoubleValueInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteDoubleValueInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteDoubleValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteDoubleValueInfoPrxHelper __h = new RemoteDoubleValueInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteDoubleValueInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteDoubleValueInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteDoubleValueInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteDoubleValueInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteDoubleValueInfoPrxHelper result = new RemoteDoubleValueInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
