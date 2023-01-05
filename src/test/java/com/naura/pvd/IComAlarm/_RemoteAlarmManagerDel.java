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

public interface _RemoteAlarmManagerDel extends Ice._ObjectDel
{
    RemoteAlarmInfo getAlarmInfo(String alarmId, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteAlarmInfo[] getAllAlarmInfos(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean recoverAlarm(String alarmId, int recoveryPos, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    String[] getAllPostedAlarms(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    String[] getAllAlarms(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean subAlarmEvent(Ice.Identity id, RemoteAlarmSeverity severity, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean subRecoveryEvent(Ice.Identity id, RemoteAlarmSeverity severity, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean subAlarmAndRecovery(Ice.Identity id, RemoteAlarmSeverity severity, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void unsubscribe(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;
}
