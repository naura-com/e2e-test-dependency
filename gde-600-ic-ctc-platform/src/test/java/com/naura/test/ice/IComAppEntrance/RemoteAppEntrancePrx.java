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
import com.naura.test.ice.IComData.RemoteDataPrx;
import com.naura.test.ice.IComDataLog.RemoteDataLogManagerPrx;
import com.naura.test.ice.IComInterlock.RemoteInterlockManagerPrx;
import com.naura.test.ice.IComRecipe.RemoteRecipeUserPrx;
import com.naura.test.ice.IComSetup.RemoteSetupManagerPrx;
import com.naura.test.ice.IComSysLog.RemoteLogFileManagerPrx;

public interface RemoteAppEntrancePrx extends Ice.ObjectPrx
{
    public void shutdown();
    public void shutdown(java.util.Map __ctx);

    public RemoteDataPrx getData(String name);
    public RemoteDataPrx getData(String name, java.util.Map __ctx);

    public boolean subData(Ice.Identity id, Ice.StringHolder err);
    public boolean subData(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx);

    public void unsubData(Ice.Identity id);
    public void unsubData(Ice.Identity id, java.util.Map __ctx);

    public RemoteBatchReaderPrx getBatchReader();
    public RemoteBatchReaderPrx getBatchReader(java.util.Map __ctx);

    public RemoteCallbackManagerPrx getCallbackManager();
    public RemoteCallbackManagerPrx getCallbackManager(java.util.Map __ctx);

    public RemoteControlObjectPrx getControlObject(String name);
    public RemoteControlObjectPrx getControlObject(String name, java.util.Map __ctx);

    public boolean subCtrlState(Ice.Identity id, Ice.StringHolder err);
    public boolean subCtrlState(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx);

    public void unsubCtrlState(Ice.Identity id);
    public void unsubCtrlState(Ice.Identity id, java.util.Map __ctx);

    public void abortAllCtrlServices();
    public void abortAllCtrlServices(java.util.Map __ctx);

    public RemoteAlarmManagerPrx getAlarmManager();
    public RemoteAlarmManagerPrx getAlarmManager(java.util.Map __ctx);

    public RemoteInterlockManagerPrx getInterlockManager();
    public RemoteInterlockManagerPrx getInterlockManager(java.util.Map __ctx);

    public RemoteRecipeUserPrx createRecipeUser(Ice.Identity id);
    public RemoteRecipeUserPrx createRecipeUser(Ice.Identity id, java.util.Map __ctx);

    public void deleteRecipeUser(Ice.Identity id);
    public void deleteRecipeUser(Ice.Identity id, java.util.Map __ctx);

    public String[] getNamespaceNodesUnder(String parent);
    public String[] getNamespaceNodesUnder(String parent, java.util.Map __ctx);

    public RemoteObjectType objectRTTI(String name);
    public RemoteObjectType objectRTTI(String name, java.util.Map __ctx);

    public RemoteLogFileManagerPrx getLogFileManager();
    public RemoteLogFileManagerPrx getLogFileManager(java.util.Map __ctx);

    public RemoteDataLogManagerPrx getDataLogManager();
    public RemoteDataLogManagerPrx getDataLogManager(java.util.Map __ctx);

    public RemoteSetupManagerPrx getSetupManager();
    public RemoteSetupManagerPrx getSetupManager(java.util.Map __ctx);

    public String getInfo();
    public String getInfo(java.util.Map __ctx);

    public void clearDataCtrlSubs(String category);
    public void clearDataCtrlSubs(String category, java.util.Map __ctx);
}
