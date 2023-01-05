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

public final class RemoteStringDataInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteStringDataInfoPrx
{
    public static RemoteStringDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteStringDataInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteStringDataInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteStringDataInfo"))
		{
		    RemoteStringDataInfoPrxHelper __h = new RemoteStringDataInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteStringDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteStringDataInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteStringDataInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteStringDataInfo", __ctx))
		{
		    RemoteStringDataInfoPrxHelper __h = new RemoteStringDataInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteStringDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteStringDataInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteStringDataInfo"))
		{
		    RemoteStringDataInfoPrxHelper __h = new RemoteStringDataInfoPrxHelper();
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

    public static RemoteStringDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteStringDataInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteStringDataInfo", __ctx))
		{
		    RemoteStringDataInfoPrxHelper __h = new RemoteStringDataInfoPrxHelper();
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

    public static RemoteStringDataInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteStringDataInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteStringDataInfoPrxHelper __h = new RemoteStringDataInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteStringDataInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteStringDataInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteStringDataInfoPrxHelper __h = new RemoteStringDataInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteStringDataInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteStringDataInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteStringDataInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteStringDataInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteStringDataInfoPrxHelper result = new RemoteStringDataInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
