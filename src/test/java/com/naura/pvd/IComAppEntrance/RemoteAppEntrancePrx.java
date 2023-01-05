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

public interface RemoteAppEntrancePrx extends Ice.ObjectPrx
{
    public void shutdown();
    public void shutdown(java.util.Map __ctx);

    public com.naura.pvd.IComData.RemoteDataPrx getData(String name);
    public com.naura.pvd.IComData.RemoteDataPrx getData(String name, java.util.Map __ctx);

    public boolean subData(Ice.Identity id, Ice.StringHolder err);
    public boolean subData(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx);

    public void unsubData(Ice.Identity id);
    public void unsubData(Ice.Identity id, java.util.Map __ctx);

    public com.naura.pvd.IComData.RemoteBatchReaderPrx getBatchReader();
    public com.naura.pvd.IComData.RemoteBatchReaderPrx getBatchReader(java.util.Map __ctx);

    public RemoteCallbackManagerPrx getCallbackManager();
    public RemoteCallbackManagerPrx getCallbackManager(java.util.Map __ctx);

    public com.naura.pvd.IComControlObject.RemoteControlObjectPrx getControlObject(String name);
    public com.naura.pvd.IComControlObject.RemoteControlObjectPrx getControlObject(String name, java.util.Map __ctx);

    public boolean subCtrlState(Ice.Identity id, Ice.StringHolder err);
    public boolean subCtrlState(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx);

    public void unsubCtrlState(Ice.Identity id);
    public void unsubCtrlState(Ice.Identity id, java.util.Map __ctx);

    public void abortAllCtrlServices();
    public void abortAllCtrlServices(java.util.Map __ctx);

    public com.naura.pvd.IComAlarm.RemoteAlarmManagerPrx getAlarmManager();
    public com.naura.pvd.IComAlarm.RemoteAlarmManagerPrx getAlarmManager(java.util.Map __ctx);

    public com.naura.pvd.IComInterlock.RemoteInterlockManagerPrx getInterlockManager();
    public com.naura.pvd.IComInterlock.RemoteInterlockManagerPrx getInterlockManager(java.util.Map __ctx);

    public com.naura.pvd.IComRecipe.RemoteRecipeUserPrx createRecipeUser(Ice.Identity id);
    public com.naura.pvd.IComRecipe.RemoteRecipeUserPrx createRecipeUser(Ice.Identity id, java.util.Map __ctx);

    public void deleteRecipeUser(Ice.Identity id);
    public void deleteRecipeUser(Ice.Identity id, java.util.Map __ctx);

    public String[] getNamespaceNodesUnder(String parent);
    public String[] getNamespaceNodesUnder(String parent, java.util.Map __ctx);

    public RemoteObjectType objectRTTI(String name);
    public RemoteObjectType objectRTTI(String name, java.util.Map __ctx);

    public com.naura.pvd.IComSysLog.RemoteLogFileManagerPrx getLogFileManager();
    public com.naura.pvd.IComSysLog.RemoteLogFileManagerPrx getLogFileManager(java.util.Map __ctx);

    public com.naura.pvd.IComDataLog.RemoteDataLogManagerPrx getDataLogManager();
    public com.naura.pvd.IComDataLog.RemoteDataLogManagerPrx getDataLogManager(java.util.Map __ctx);

    public com.naura.pvd.IComSetup.RemoteSetupManagerPrx getSetupManager();
    public com.naura.pvd.IComSetup.RemoteSetupManagerPrx getSetupManager(java.util.Map __ctx);

    public String getInfo();
    public String getInfo(java.util.Map __ctx);

    public void clearDataCtrlSubs(String category);
    public void clearDataCtrlSubs(String category, java.util.Map __ctx);
}
