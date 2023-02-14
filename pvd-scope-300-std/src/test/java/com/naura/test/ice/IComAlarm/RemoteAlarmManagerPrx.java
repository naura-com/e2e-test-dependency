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

public interface RemoteAlarmManagerPrx extends Ice.ObjectPrx {
    public RemoteAlarmInfo getAlarmInfo(String alarmId);

    public RemoteAlarmInfo getAlarmInfo(String alarmId, java.util.Map __ctx);

    public RemoteAlarmInfo[] getAllAlarmInfos();

    public RemoteAlarmInfo[] getAllAlarmInfos(java.util.Map __ctx);

    public boolean recoverAlarm(String alarmId, int recoveryPos);

    public boolean recoverAlarm(String alarmId, int recoveryPos, java.util.Map __ctx);

    public String[] getAllPostedAlarms();

    public String[] getAllPostedAlarms(java.util.Map __ctx);

    public String[] getAllAlarms();

    public String[] getAllAlarms(java.util.Map __ctx);

    public boolean subAlarmEvent(Ice.Identity id, RemoteAlarmSeverity severity);

    public boolean subAlarmEvent(Ice.Identity id, RemoteAlarmSeverity severity, java.util.Map __ctx);

    public boolean subRecoveryEvent(Ice.Identity id, RemoteAlarmSeverity severity);

    public boolean subRecoveryEvent(Ice.Identity id, RemoteAlarmSeverity severity, java.util.Map __ctx);

    public boolean subAlarmAndRecovery(Ice.Identity id, RemoteAlarmSeverity severity);

    public boolean subAlarmAndRecovery(Ice.Identity id, RemoteAlarmSeverity severity, java.util.Map __ctx);

    public void unsubscribe(Ice.Identity id);

    public void unsubscribe(Ice.Identity id, java.util.Map __ctx);
}
