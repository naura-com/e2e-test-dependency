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

public final class RemoteIntDataInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteIntDataInfoPrx
{
    public static RemoteIntDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteIntDataInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteIntDataInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteIntDataInfo"))
		{
		    RemoteIntDataInfoPrxHelper __h = new RemoteIntDataInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteIntDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteIntDataInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteIntDataInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteIntDataInfo", __ctx))
		{
		    RemoteIntDataInfoPrxHelper __h = new RemoteIntDataInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteIntDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteIntDataInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteIntDataInfo"))
		{
		    RemoteIntDataInfoPrxHelper __h = new RemoteIntDataInfoPrxHelper();
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

    public static RemoteIntDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteIntDataInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteIntDataInfo", __ctx))
		{
		    RemoteIntDataInfoPrxHelper __h = new RemoteIntDataInfoPrxHelper();
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

    public static RemoteIntDataInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteIntDataInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteIntDataInfoPrxHelper __h = new RemoteIntDataInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteIntDataInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteIntDataInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteIntDataInfoPrxHelper __h = new RemoteIntDataInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteIntDataInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteIntDataInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteIntDataInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteIntDataInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteIntDataInfoPrxHelper result = new RemoteIntDataInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
