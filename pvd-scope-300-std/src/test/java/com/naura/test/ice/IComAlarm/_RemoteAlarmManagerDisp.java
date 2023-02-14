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

public abstract class _RemoteAlarmManagerDisp extends Ice.ObjectImpl implements RemoteAlarmManager {
    protected void
    ice_copyStateFrom(Ice.Object __obj)
            throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
            {
                    "::IComAlarm::RemoteAlarmManager",
                    "::Ice::Object"
            };

    public boolean
    ice_isA(String s) {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current) {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids() {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current) {
        return __ids;
    }

    public String
    ice_id() {
        return __ids[0];
    }

    public String
    ice_id(Ice.Current __current) {
        return __ids[0];
    }

    public static String
    ice_staticId() {
        return __ids[0];
    }

    public final RemoteAlarmInfo
    getAlarmInfo(String alarmId) {
        return getAlarmInfo(alarmId, null);
    }

    public final RemoteAlarmInfo[]
    getAllAlarmInfos() {
        return getAllAlarmInfos(null);
    }

    public final String[]
    getAllAlarms() {
        return getAllAlarms(null);
    }

    public final String[]
    getAllPostedAlarms() {
        return getAllPostedAlarms(null);
    }

    public final boolean
    recoverAlarm(String alarmId, int recoveryPos) {
        return recoverAlarm(alarmId, recoveryPos, null);
    }

    public final boolean
    subAlarmAndRecovery(Ice.Identity id, RemoteAlarmSeverity severity) {
        return subAlarmAndRecovery(id, severity, null);
    }

    public final boolean
    subAlarmEvent(Ice.Identity id, RemoteAlarmSeverity severity) {
        return subAlarmEvent(id, severity, null);
    }

    public final boolean
    subRecoveryEvent(Ice.Identity id, RemoteAlarmSeverity severity) {
        return subRecoveryEvent(id, severity, null);
    }

    public final void
    unsubscribe(Ice.Identity id) {
        unsubscribe(id, null);
    }

    public static IceInternal.DispatchStatus
    ___getAlarmInfo(RemoteAlarmManager __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String alarmId;
        alarmId = __is.readString();
        RemoteAlarmInfo __ret = __obj.getAlarmInfo(alarmId, __current);
        __os.writeObject(__ret);
        __os.writePendingObjects();
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getAllAlarmInfos(RemoteAlarmManager __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        RemoteAlarmInfo[] __ret = __obj.getAllAlarmInfos(__current);
        RemoteAlarmInfoSeqHelper.write(__os, __ret);
        __os.writePendingObjects();
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___recoverAlarm(RemoteAlarmManager __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String alarmId;
        alarmId = __is.readString();
        int recoveryPos;
        recoveryPos = __is.readInt();
        boolean __ret = __obj.recoverAlarm(alarmId, recoveryPos, __current);
        __os.writeBool(__ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getAllPostedAlarms(RemoteAlarmManager __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        String[] __ret = __obj.getAllPostedAlarms(__current);
        Ice.StringSeqHelper.write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getAllAlarms(RemoteAlarmManager __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        String[] __ret = __obj.getAllAlarms(__current);
        Ice.StringSeqHelper.write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___subAlarmEvent(RemoteAlarmManager __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        Ice.Identity id;
        id = new Ice.Identity();
        id.__read(__is);
        RemoteAlarmSeverity severity;
        severity = RemoteAlarmSeverity.__read(__is);
        boolean __ret = __obj.subAlarmEvent(id, severity, __current);
        __os.writeBool(__ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___subRecoveryEvent(RemoteAlarmManager __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        Ice.Identity id;
        id = new Ice.Identity();
        id.__read(__is);
        RemoteAlarmSeverity severity;
        severity = RemoteAlarmSeverity.__read(__is);
        boolean __ret = __obj.subRecoveryEvent(id, severity, __current);
        __os.writeBool(__ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___subAlarmAndRecovery(RemoteAlarmManager __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        Ice.Identity id;
        id = new Ice.Identity();
        id.__read(__is);
        RemoteAlarmSeverity severity;
        severity = RemoteAlarmSeverity.__read(__is);
        boolean __ret = __obj.subAlarmAndRecovery(id, severity, __current);
        __os.writeBool(__ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___unsubscribe(RemoteAlarmManager __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        Ice.Identity id;
        id = new Ice.Identity();
        id.__read(__is);
        __obj.unsubscribe(id, __current);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
            {
                    "getAlarmInfo",
                    "getAllAlarmInfos",
                    "getAllAlarms",
                    "getAllPostedAlarms",
                    "ice_id",
                    "ice_ids",
                    "ice_isA",
                    "ice_ping",
                    "recoverAlarm",
                    "subAlarmAndRecovery",
                    "subAlarmEvent",
                    "subRecoveryEvent",
                    "unsubscribe"
            };

    public IceInternal.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current) {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if (pos < 0) {
            return IceInternal.DispatchStatus.DispatchOperationNotExist;
        }

        switch (pos) {
            case 0: {
                return ___getAlarmInfo(this, in, __current);
            }
            case 1: {
                return ___getAllAlarmInfos(this, in, __current);
            }
            case 2: {
                return ___getAllAlarms(this, in, __current);
            }
            case 3: {
                return ___getAllPostedAlarms(this, in, __current);
            }
            case 4: {
                return ___ice_id(this, in, __current);
            }
            case 5: {
                return ___ice_ids(this, in, __current);
            }
            case 6: {
                return ___ice_isA(this, in, __current);
            }
            case 7: {
                return ___ice_ping(this, in, __current);
            }
            case 8: {
                return ___recoverAlarm(this, in, __current);
            }
            case 9: {
                return ___subAlarmAndRecovery(this, in, __current);
            }
            case 10: {
                return ___subAlarmEvent(this, in, __current);
            }
            case 11: {
                return ___subRecoveryEvent(this, in, __current);
            }
            case 12: {
                return ___unsubscribe(this, in, __current);
            }
        }

        assert (false);
        return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
