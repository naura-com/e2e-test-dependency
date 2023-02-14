// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComAppEntrance;

import com.naura.test.ice.IComAlarm.RemoteAlarmManagerPrx;
import com.naura.test.ice.IComControlObject.RemoteControlObjectPrx;
import com.naura.test.ice.IComData.RemoteBatchReaderPrx;
import com.naura.test.ice.IComData.RemoteBatchReaderPrxHelper;
import com.naura.test.ice.IComData.RemoteDataPrx;
import com.naura.test.ice.IComData.RemoteDataPrxHelper;
import com.naura.test.ice.IComDataLog.RemoteDataLogManagerPrx;
import com.naura.test.ice.IComInterlock.RemoteInterlockManagerPrx;
import com.naura.test.ice.IComInterlock.RemoteInterlockManagerPrxHelper;
import com.naura.test.ice.IComSetup.RemoteSetupManagerPrx;
import com.naura.test.ice.IComSetup.RemoteSetupManagerPrxHelper;
import com.naura.test.ice.IComSysLog.RemoteLogFileManagerPrx;
import com.naura.test.ice.IComSysLog.RemoteLogFileManagerPrxHelper;
import com.naura.test.ice.IComAlarm.RemoteAlarmManagerPrxHelper;
import com.naura.test.ice.IComControlObject.RemoteControlObjectPrxHelper;
import com.naura.test.ice.IComDataLog.RemoteDataLogManagerPrxHelper;
import com.naura.test.ice.IComRecipe.RemoteRecipeUserPrx;
import com.naura.test.ice.IComRecipe.RemoteRecipeUserPrxHelper;

public abstract class _RemoteAppEntranceDisp extends Ice.ObjectImpl implements RemoteAppEntrance {
    protected void
    ice_copyStateFrom(Ice.Object __obj)
            throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
            {
                    "::IComAppEntrance::RemoteAppEntrance",
                    "::Ice::Object"
            };

    @Override
    public boolean
    ice_isA(String s) {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    @Override
    public boolean
    ice_isA(String s, Ice.Current __current) {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    @Override
    public String[]
    ice_ids() {
        return __ids;
    }

    @Override
    public String[]
    ice_ids(Ice.Current __current) {
        return __ids;
    }

    @Override
    public String
    ice_id() {
        return __ids[0];
    }

    @Override
    public String
    ice_id(Ice.Current __current) {
        return __ids[0];
    }

    public static String
    ice_staticId() {
        return __ids[0];
    }

    @Override
    public final void
    abortAllCtrlServices() {
        abortAllCtrlServices(null);
    }

    @Override
    public final void
    clearDataCtrlSubs(String category) {
        clearDataCtrlSubs(category, null);
    }

    @Override
    public final RemoteRecipeUserPrx
    createRecipeUser(Ice.Identity id) {
        return createRecipeUser(id, null);
    }

    @Override
    public final void
    deleteRecipeUser(Ice.Identity id) {
        deleteRecipeUser(id, null);
    }

    @Override
    public final RemoteAlarmManagerPrx
    getAlarmManager() {
        return getAlarmManager(null);
    }

    @Override
    public final RemoteBatchReaderPrx
    getBatchReader() {
        return getBatchReader(null);
    }

    @Override
    public final RemoteCallbackManagerPrx
    getCallbackManager() {
        return getCallbackManager(null);
    }

    @Override
    public final RemoteControlObjectPrx
    getControlObject(String name) {
        return getControlObject(name, null);
    }

    @Override
    public final RemoteDataPrx
    getData(String name) {
        return getData(name, null);
    }

    @Override
    public final RemoteDataLogManagerPrx
    getDataLogManager() {
        return getDataLogManager(null);
    }

    @Override
    public final String
    getInfo() {
        return getInfo(null);
    }

    @Override
    public final RemoteInterlockManagerPrx
    getInterlockManager() {
        return getInterlockManager(null);
    }

    @Override
    public final RemoteLogFileManagerPrx
    getLogFileManager() {
        return getLogFileManager(null);
    }

    @Override
    public final String[]
    getNamespaceNodesUnder(String parent) {
        return getNamespaceNodesUnder(parent, null);
    }

    @Override
    public final RemoteSetupManagerPrx
    getSetupManager() {
        return getSetupManager(null);
    }

    @Override
    public final RemoteObjectType
    objectRTTI(String name) {
        return objectRTTI(name, null);
    }

    @Override
    public final void
    shutdown() {
        shutdown(null);
    }

    @Override
    public final boolean
    subCtrlState(Ice.Identity id, Ice.StringHolder err) {
        return subCtrlState(id, err, null);
    }

    @Override
    public final boolean
    subData(Ice.Identity id, Ice.StringHolder err) {
        return subData(id, err, null);
    }

    @Override
    public final void
    unsubCtrlState(Ice.Identity id) {
        unsubCtrlState(id, null);
    }

    @Override
    public final void
    unsubData(Ice.Identity id) {
        unsubData(id, null);
    }

    public static IceInternal.DispatchStatus
    ___shutdown(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __obj.shutdown(__current);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getData(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String name;
        name = __is.readString();
        RemoteDataPrx __ret = __obj.getData(name, __current);
        RemoteDataPrxHelper.__write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___subData(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        Ice.Identity id;
        id = new Ice.Identity();
        id.__read(__is);
        Ice.StringHolder err = new Ice.StringHolder();
        boolean __ret = __obj.subData(id, err, __current);
        __os.writeString(err.value);
        __os.writeBool(__ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___unsubData(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        Ice.Identity id;
        id = new Ice.Identity();
        id.__read(__is);
        __obj.unsubData(id, __current);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getBatchReader(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        RemoteBatchReaderPrx __ret = __obj.getBatchReader(__current);
        RemoteBatchReaderPrxHelper.__write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getCallbackManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        RemoteCallbackManagerPrx __ret = __obj.getCallbackManager(__current);
        RemoteCallbackManagerPrxHelper.__write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getControlObject(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String name;
        name = __is.readString();
        RemoteControlObjectPrx __ret = __obj.getControlObject(name, __current);
        RemoteControlObjectPrxHelper.__write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___subCtrlState(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        Ice.Identity id;
        id = new Ice.Identity();
        id.__read(__is);
        Ice.StringHolder err = new Ice.StringHolder();
        boolean __ret = __obj.subCtrlState(id, err, __current);
        __os.writeString(err.value);
        __os.writeBool(__ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___unsubCtrlState(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        Ice.Identity id;
        id = new Ice.Identity();
        id.__read(__is);
        __obj.unsubCtrlState(id, __current);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___abortAllCtrlServices(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __obj.abortAllCtrlServices(__current);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getAlarmManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        RemoteAlarmManagerPrx __ret = __obj.getAlarmManager(__current);
        RemoteAlarmManagerPrxHelper.__write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getInterlockManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        RemoteInterlockManagerPrx __ret = __obj.getInterlockManager(__current);
        RemoteInterlockManagerPrxHelper.__write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___createRecipeUser(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        Ice.Identity id;
        id = new Ice.Identity();
        id.__read(__is);
        RemoteRecipeUserPrx __ret = __obj.createRecipeUser(id, __current);
        RemoteRecipeUserPrxHelper.__write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___deleteRecipeUser(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        Ice.Identity id;
        id = new Ice.Identity();
        id.__read(__is);
        __obj.deleteRecipeUser(id, __current);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getNamespaceNodesUnder(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String parent;
        parent = __is.readString();
        String[] __ret = __obj.getNamespaceNodesUnder(parent, __current);
        Ice.StringSeqHelper.write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___objectRTTI(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String name;
        name = __is.readString();
        RemoteObjectType __ret = __obj.objectRTTI(name, __current);
        __ret.__write(__os);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getLogFileManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        RemoteLogFileManagerPrx __ret = __obj.getLogFileManager(__current);
        RemoteLogFileManagerPrxHelper.__write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getDataLogManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        RemoteDataLogManagerPrx __ret = __obj.getDataLogManager(__current);
        RemoteDataLogManagerPrxHelper.__write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getSetupManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        RemoteSetupManagerPrx __ret = __obj.getSetupManager(__current);
        RemoteSetupManagerPrxHelper.__write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getInfo(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        String __ret = __obj.getInfo(__current);
        __os.writeString(__ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___clearDataCtrlSubs(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        String category;
        category = __is.readString();
        __obj.clearDataCtrlSubs(category, __current);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
            {
                    "abortAllCtrlServices",
                    "clearDataCtrlSubs",
                    "createRecipeUser",
                    "deleteRecipeUser",
                    "getAlarmManager",
                    "getBatchReader",
                    "getCallbackManager",
                    "getControlObject",
                    "getData",
                    "getDataLogManager",
                    "getInfo",
                    "getInterlockManager",
                    "getLogFileManager",
                    "getNamespaceNodesUnder",
                    "getSetupManager",
                    "ice_id",
                    "ice_ids",
                    "ice_isA",
                    "ice_ping",
                    "objectRTTI",
                    "shutdown",
                    "subCtrlState",
                    "subData",
                    "unsubCtrlState",
                    "unsubData"
            };

    @Override
    public IceInternal.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current) {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if (pos < 0) {
            return IceInternal.DispatchStatus.DispatchOperationNotExist;
        }

        switch (pos) {
            case 0: {
                return ___abortAllCtrlServices(this, in, __current);
            }
            case 1: {
                return ___clearDataCtrlSubs(this, in, __current);
            }
            case 2: {
                return ___createRecipeUser(this, in, __current);
            }
            case 3: {
                return ___deleteRecipeUser(this, in, __current);
            }
            case 4: {
                return ___getAlarmManager(this, in, __current);
            }
            case 5: {
                return ___getBatchReader(this, in, __current);
            }
            case 6: {
                return ___getCallbackManager(this, in, __current);
            }
            case 7: {
                return ___getControlObject(this, in, __current);
            }
            case 8: {
                return ___getData(this, in, __current);
            }
            case 9: {
                return ___getDataLogManager(this, in, __current);
            }
            case 10: {
                return ___getInfo(this, in, __current);
            }
            case 11: {
                return ___getInterlockManager(this, in, __current);
            }
            case 12: {
                return ___getLogFileManager(this, in, __current);
            }
            case 13: {
                return ___getNamespaceNodesUnder(this, in, __current);
            }
            case 14: {
                return ___getSetupManager(this, in, __current);
            }
            case 15: {
                return ___ice_id(this, in, __current);
            }
            case 16: {
                return ___ice_ids(this, in, __current);
            }
            case 17: {
                return ___ice_isA(this, in, __current);
            }
            case 18: {
                return ___ice_ping(this, in, __current);
            }
            case 19: {
                return ___objectRTTI(this, in, __current);
            }
            case 20: {
                return ___shutdown(this, in, __current);
            }
            case 21: {
                return ___subCtrlState(this, in, __current);
            }
            case 22: {
                return ___subData(this, in, __current);
            }
            case 23: {
                return ___unsubCtrlState(this, in, __current);
            }
            case 24: {
                return ___unsubData(this, in, __current);
            }
        }

        assert (false);
        return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
