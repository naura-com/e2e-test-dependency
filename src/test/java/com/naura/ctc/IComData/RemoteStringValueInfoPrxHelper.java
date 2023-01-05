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

public final class RemoteStringValueInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteStringValueInfoPrx
{
    public static RemoteStringValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteStringValueInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteStringValueInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteStringValueInfo"))
		{
		    RemoteStringValueInfoPrxHelper __h = new RemoteStringValueInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteStringValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteStringValueInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteStringValueInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteStringValueInfo", __ctx))
		{
		    RemoteStringValueInfoPrxHelper __h = new RemoteStringValueInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteStringValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteStringValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteStringValueInfo"))
		{
		    RemoteStringValueInfoPrxHelper __h = new RemoteStringValueInfoPrxHelper();
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

    public static RemoteStringValueInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteStringValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteStringValueInfo", __ctx))
		{
		    RemoteStringValueInfoPrxHelper __h = new RemoteStringValueInfoPrxHelper();
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

    public static RemoteStringValueInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteStringValueInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteStringValueInfoPrxHelper __h = new RemoteStringValueInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteStringValueInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteStringValueInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteStringValueInfoPrxHelper __h = new RemoteStringValueInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteStringValueInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteStringValueInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteStringValueInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteStringValueInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteStringValueInfoPrxHelper result = new RemoteStringValueInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
