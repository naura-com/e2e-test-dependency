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

import com.naura.test.ice.IComControlObject.RemoteControlObjectPrx;
import com.naura.test.ice.IComData.RemoteBatchReaderPrx;
import com.naura.test.ice.IComDataLog.RemoteDataLogManagerPrx;
import com.naura.test.ice.IComInterlock.RemoteInterlockManagerPrx;
import com.naura.test.ice.IComSysLog.RemoteLogFileManagerPrx;
import com.naura.test.ice.IComAlarm.RemoteAlarmManagerPrx;
import com.naura.test.ice.IComData.RemoteDataPrx;
import com.naura.test.ice.IComRecipe.RemoteRecipeUserPrx;
import com.naura.test.ice.IComSetup.RemoteSetupManagerPrx;

public interface _RemoteAppEntranceOperationsNC {
    void shutdown();

    RemoteDataPrx getData(String name);

    boolean subData(Ice.Identity id, Ice.StringHolder err);

    void unsubData(Ice.Identity id);

    RemoteBatchReaderPrx getBatchReader();

    RemoteCallbackManagerPrx getCallbackManager();

    RemoteControlObjectPrx getControlObject(String name);

    boolean subCtrlState(Ice.Identity id, Ice.StringHolder err);

    void unsubCtrlState(Ice.Identity id);

    void abortAllCtrlServices();

    RemoteAlarmManagerPrx getAlarmManager();

    RemoteInterlockManagerPrx getInterlockManager();

    RemoteRecipeUserPrx createRecipeUser(Ice.Identity id);

    void deleteRecipeUser(Ice.Identity id);

    String[] getNamespaceNodesUnder(String parent);

    RemoteObjectType objectRTTI(String name);

    RemoteLogFileManagerPrx getLogFileManager();

    RemoteDataLogManagerPrx getDataLogManager();

    RemoteSetupManagerPrx getSetupManager();

    String getInfo();

    void clearDataCtrlSubs(String category);
}
