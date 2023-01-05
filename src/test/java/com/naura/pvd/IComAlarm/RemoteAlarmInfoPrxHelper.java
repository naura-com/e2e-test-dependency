// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComAlarm;

public final class RemoteAlarmInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteAlarmInfoPrx
{
    public static RemoteAlarmInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteAlarmInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteAlarmInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComAlarm::RemoteAlarmInfo"))
		{
		    RemoteAlarmInfoPrxHelper __h = new RemoteAlarmInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteAlarmInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteAlarmInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteAlarmInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComAlarm::RemoteAlarmInfo", __ctx))
		{
		    RemoteAlarmInfoPrxHelper __h = new RemoteAlarmInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteAlarmInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteAlarmInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComAlarm::RemoteAlarmInfo"))
		{
		    RemoteAlarmInfoPrxHelper __h = new RemoteAlarmInfoPrxHelper();
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

    public static RemoteAlarmInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteAlarmInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComAlarm::RemoteAlarmInfo", __ctx))
		{
		    RemoteAlarmInfoPrxHelper __h = new RemoteAlarmInfoPrxHelper();
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

    public static RemoteAlarmInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteAlarmInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteAlarmInfoPrxHelper __h = new RemoteAlarmInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteAlarmInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteAlarmInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteAlarmInfoPrxHelper __h = new RemoteAlarmInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteAlarmInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteAlarmInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteAlarmInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteAlarmInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteAlarmInfoPrxHelper result = new RemoteAlarmInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
