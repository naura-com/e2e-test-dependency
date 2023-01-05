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

public interface _RemoteAppEntranceOperationsNC
{
    void shutdown();

    com.naura.pvd.IComData.RemoteDataPrx getData(String name);

    boolean subData(Ice.Identity id, Ice.StringHolder err);

    void unsubData(Ice.Identity id);

    com.naura.pvd.IComData.RemoteBatchReaderPrx getBatchReader();

    RemoteCallbackManagerPrx getCallbackManager();

    com.naura.pvd.IComControlObject.RemoteControlObjectPrx getControlObject(String name);

    boolean subCtrlState(Ice.Identity id, Ice.StringHolder err);

    void unsubCtrlState(Ice.Identity id);

    void abortAllCtrlServices();

    com.naura.pvd.IComAlarm.RemoteAlarmManagerPrx getAlarmManager();

    com.naura.pvd.IComInterlock.RemoteInterlockManagerPrx getInterlockManager();

    com.naura.pvd.IComRecipe.RemoteRecipeUserPrx createRecipeUser(Ice.Identity id);

    void deleteRecipeUser(Ice.Identity id);

    String[] getNamespaceNodesUnder(String parent);

    RemoteObjectType objectRTTI(String name);

    com.naura.pvd.IComSysLog.RemoteLogFileManagerPrx getLogFileManager();

    com.naura.pvd.IComDataLog.RemoteDataLogManagerPrx getDataLogManager();

    com.naura.pvd.IComSetup.RemoteSetupManagerPrx getSetupManager();

    String getInfo();

    void clearDataCtrlSubs(String category);
}
