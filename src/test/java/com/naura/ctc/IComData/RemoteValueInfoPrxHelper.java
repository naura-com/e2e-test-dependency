// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComData;

public final class RemoteValueInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteValueInfoPrx
{
    public static RemoteValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteValueInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteValueInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteValueInfo"))
		{
		    RemoteValueInfoPrxHelper __h = new RemoteValueInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteValueInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteValueInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteValueInfo", __ctx))
		{
		    RemoteValueInfoPrxHelper __h = new RemoteValueInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteValueInfo"))
		{
		    RemoteValueInfoPrxHelper __h = new RemoteValueInfoPrxHelper();
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

    public static RemoteValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteValueInfo", __ctx))
		{
		    RemoteValueInfoPrxHelper __h = new RemoteValueInfoPrxHelper();
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

    public static RemoteValueInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteValueInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteValueInfoPrxHelper __h = new RemoteValueInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteValueInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteValueInfoPrxHelper __h = new RemoteValueInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteValueInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteValueInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteValueInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteValueInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteValueInfoPrxHelper result = new RemoteValueInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
