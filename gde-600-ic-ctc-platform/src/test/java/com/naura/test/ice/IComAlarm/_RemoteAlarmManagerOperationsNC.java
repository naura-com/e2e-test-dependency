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

public interface _RemoteAlarmManagerOperationsNC
{
    RemoteAlarmInfo getAlarmInfo(String alarmId);

    RemoteAlarmInfo[] getAllAlarmInfos();

    boolean recoverAlarm(String alarmId, int recoveryPos);

    String[] getAllPostedAlarms();

    String[] getAllAlarms();

    boolean subAlarmEvent(Ice.Identity id, RemoteAlarmSeverity severity);

    boolean subRecoveryEvent(Ice.Identity id, RemoteAlarmSeverity severity);

    boolean subAlarmAndRecovery(Ice.Identity id, RemoteAlarmSeverity severity);

    void unsubscribe(Ice.Identity id);
}
