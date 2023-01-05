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

public interface RemoteAlarmMonitorPrx extends Ice.ObjectPrx
{
    public void update(RemoteAlarmInfo alarmInfo, RemoteRecoveryRole recoveryRole, String timeStamp);
    public void update(RemoteAlarmInfo alarmInfo, RemoteRecoveryRole recoveryRole, String timeStamp, java.util.Map __ctx);
}
