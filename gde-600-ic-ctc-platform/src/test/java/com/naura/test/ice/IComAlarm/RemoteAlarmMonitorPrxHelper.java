// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComAlarm;

public final class RemoteAlarmMonitorPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteAlarmMonitorPrx
{
    public void
    update(RemoteAlarmInfo alarmInfo, RemoteRecoveryRole recoveryRole, String timeStamp)
    {
	update(alarmInfo, recoveryRole, timeStamp, __defaultContext());
    }

    public void
    update(RemoteAlarmInfo alarmInfo, RemoteRecoveryRole recoveryRole, String timeStamp, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAlarmMonitorDel __del = (_RemoteAlarmMonitorDel)__delBase;
		__del.update(alarmInfo, recoveryRole, timeStamp, __ctx);
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

    public static RemoteAlarmMonitorPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteAlarmMonitorPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteAlarmMonitorPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComAlarm::RemoteAlarmMonitor"))
		{
		    RemoteAlarmMonitorPrxHelper __h = new RemoteAlarmMonitorPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteAlarmMonitorPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteAlarmMonitorPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteAlarmMonitorPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComAlarm::RemoteAlarmMonitor", __ctx))
		{
		    RemoteAlarmMonitorPrxHelper __h = new RemoteAlarmMonitorPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteAlarmMonitorPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteAlarmMonitorPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComAlarm::RemoteAlarmMonitor"))
		{
		    RemoteAlarmMonitorPrxHelper __h = new RemoteAlarmMonitorPrxHelper();
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

    public static RemoteAlarmMonitorPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteAlarmMonitorPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComAlarm::RemoteAlarmMonitor", __ctx))
		{
		    RemoteAlarmMonitorPrxHelper __h = new RemoteAlarmMonitorPrxHelper();
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

    public static RemoteAlarmMonitorPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteAlarmMonitorPrx __d = null;
	if(__obj != null)
	{
	    RemoteAlarmMonitorPrxHelper __h = new RemoteAlarmMonitorPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteAlarmMonitorPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteAlarmMonitorPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteAlarmMonitorPrxHelper __h = new RemoteAlarmMonitorPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteAlarmMonitorDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteAlarmMonitorDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteAlarmMonitorPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteAlarmMonitorPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteAlarmMonitorPrxHelper result = new RemoteAlarmMonitorPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
