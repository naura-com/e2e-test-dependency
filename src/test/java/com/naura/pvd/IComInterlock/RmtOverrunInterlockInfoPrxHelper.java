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

public final class RmtOverrunInterlockInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RmtOverrunInterlockInfoPrx
{
    public static RmtOverrunInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RmtOverrunInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RmtOverrunInterlockInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComInterlock::RmtOverrunInterlockInfo"))
		{
		    RmtOverrunInterlockInfoPrxHelper __h = new RmtOverrunInterlockInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RmtOverrunInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RmtOverrunInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RmtOverrunInterlockInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComInterlock::RmtOverrunInterlockInfo", __ctx))
		{
		    RmtOverrunInterlockInfoPrxHelper __h = new RmtOverrunInterlockInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RmtOverrunInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RmtOverrunInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComInterlock::RmtOverrunInterlockInfo"))
		{
		    RmtOverrunInterlockInfoPrxHelper __h = new RmtOverrunInterlockInfoPrxHelper();
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

    public static RmtOverrunInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RmtOverrunInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComInterlock::RmtOverrunInterlockInfo", __ctx))
		{
		    RmtOverrunInterlockInfoPrxHelper __h = new RmtOverrunInterlockInfoPrxHelper();
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

    public static RmtOverrunInterlockInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RmtOverrunInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    RmtOverrunInterlockInfoPrxHelper __h = new RmtOverrunInterlockInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RmtOverrunInterlockInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RmtOverrunInterlockInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RmtOverrunInterlockInfoPrxHelper __h = new RmtOverrunInterlockInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RmtOverrunInterlockInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RmtOverrunInterlockInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RmtOverrunInterlockInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RmtOverrunInterlockInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RmtOverrunInterlockInfoPrxHelper result = new RmtOverrunInterlockInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
