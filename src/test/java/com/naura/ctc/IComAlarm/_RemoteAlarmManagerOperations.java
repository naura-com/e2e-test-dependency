// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComAlarm;

public interface _RemoteAlarmManagerOperations
{
    RemoteAlarmInfo getAlarmInfo(String alarmId, Ice.Current __current);

    RemoteAlarmInfo[] getAllAlarmInfos(Ice.Current __current);

    boolean recoverAlarm(String alarmId, int recoveryPos, Ice.Current __current);

    String[] getAllPostedAlarms(Ice.Current __current);

    String[] getAllAlarms(Ice.Current __current);

    boolean subAlarmEvent(Ice.Identity id, RemoteAlarmSeverity severity, Ice.Current __current);

    boolean subRecoveryEvent(Ice.Identity id, RemoteAlarmSeverity severity, Ice.Current __current);

    boolean subAlarmAndRecovery(Ice.Identity id, RemoteAlarmSeverity severity, Ice.Current __current);

    void unsubscribe(Ice.Identity id, Ice.Current __current);
}
