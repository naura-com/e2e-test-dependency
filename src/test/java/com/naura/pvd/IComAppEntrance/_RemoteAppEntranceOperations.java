// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComAppEntrance;

public interface _RemoteAppEntranceOperations
{
    void shutdown(Ice.Current __current);

    com.naura.pvd.IComData.RemoteDataPrx getData(String name, Ice.Current __current);

    boolean subData(Ice.Identity id, Ice.StringHolder err, Ice.Current __current);

    void unsubData(Ice.Identity id, Ice.Current __current);

    com.naura.pvd.IComData.RemoteBatchReaderPrx getBatchReader(Ice.Current __current);

    RemoteCallbackManagerPrx getCallbackManager(Ice.Current __current);

    com.naura.pvd.IComControlObject.RemoteControlObjectPrx getControlObject(String name, Ice.Current __current);

    boolean subCtrlState(Ice.Identity id, Ice.StringHolder err, Ice.Current __current);

    void unsubCtrlState(Ice.Identity id, Ice.Current __current);

    void abortAllCtrlServices(Ice.Current __current);

    com.naura.pvd.IComAlarm.RemoteAlarmManagerPrx getAlarmManager(Ice.Current __current);

    com.naura.pvd.IComInterlock.RemoteInterlockManagerPrx getInterlockManager(Ice.Current __current);

    com.naura.pvd.IComRecipe.RemoteRecipeUserPrx createRecipeUser(Ice.Identity id, Ice.Current __current);

    void deleteRecipeUser(Ice.Identity id, Ice.Current __current);

    String[] getNamespaceNodesUnder(String parent, Ice.Current __current);

    RemoteObjectType objectRTTI(String name, Ice.Current __current);

    com.naura.pvd.IComSysLog.RemoteLogFileManagerPrx getLogFileManager(Ice.Current __current);

    com.naura.pvd.IComDataLog.RemoteDataLogManagerPrx getDataLogManager(Ice.Current __current);

    com.naura.pvd.IComSetup.RemoteSetupManagerPrx getSetupManager(Ice.Current __current);

    String getInfo(Ice.Current __current);

    void clearDataCtrlSubs(String category, Ice.Current __current);
}
