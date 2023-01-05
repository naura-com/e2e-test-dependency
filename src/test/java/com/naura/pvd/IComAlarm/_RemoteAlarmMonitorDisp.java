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

public abstract class _RemoteAlarmMonitorDisp extends Ice.ObjectImpl implements RemoteAlarmMonitor
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
	throws CloneNotSupportedException
    {
	throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
	"::IComAlarm::RemoteAlarmMonitor",
	"::Ice::Object"
    };

    public boolean
    ice_isA(String s)
    {
	return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
	return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
	return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
	return __ids;
    }

    public String
    ice_id()
    {
	return __ids[0];
    }

    public String
    ice_id(Ice.Current __current)
    {
	return __ids[0];
    }

    public static String
    ice_staticId()
    {
	return __ids[0];
    }

    public final void
    update(RemoteAlarmInfo alarmInfo, RemoteRecoveryRole recoveryRole, String timeStamp)
    {
	update(alarmInfo, recoveryRole, timeStamp, null);
    }

    public static IceInternal.DispatchStatus
    ___update(RemoteAlarmMonitor __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	RemoteAlarmInfoHolder alarmInfo = new RemoteAlarmInfoHolder();
	__is.readObject(alarmInfo.getPatcher());
	RemoteRecoveryRole recoveryRole;
	recoveryRole = new RemoteRecoveryRole();
	recoveryRole.__read(__is);
	String timeStamp;
	timeStamp = __is.readString();
	__is.readPendingObjects();
	__obj.update(alarmInfo.value, recoveryRole, timeStamp, __current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
	"ice_id",
	"ice_ids",
	"ice_isA",
	"ice_ping",
	"update"
    };

    public IceInternal.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
	int pos = java.util.Arrays.binarySearch(__all, __current.operation);
	if(pos < 0)
	{
	    return IceInternal.DispatchStatus.DispatchOperationNotExist;
	}

	switch(pos)
	{
	    case 0:
	    {
		return ___ice_id(this, in, __current);
	    }
	    case 1:
	    {
		return ___ice_ids(this, in, __current);
	    }
	    case 2:
	    {
		return ___ice_isA(this, in, __current);
	    }
	    case 3:
	    {
		return ___ice_ping(this, in, __current);
	    }
	    case 4:
	    {
		return ___update(this, in, __current);
	    }
	}

	assert(false);
	return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
