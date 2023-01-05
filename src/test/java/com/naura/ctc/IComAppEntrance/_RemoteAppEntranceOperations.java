// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComAppEntrance;

import com.naura.ctc.IComAlarm.RemoteAlarmManagerPrx;
import com.naura.ctc.IComControlObject.RemoteControlObjectPrx;
import com.naura.ctc.IComData.RemoteBatchReaderPrx;
import com.naura.ctc.IComData.RemoteDataPrx;
import com.naura.ctc.IComDataLog.RemoteDataLogManagerPrx;
import com.naura.ctc.IComInterlock.RemoteInterlockManagerPrx;
import com.naura.ctc.IComRecipe.RemoteRecipeUserPrx;
import com.naura.ctc.IComSetup.RemoteSetupManagerPrx;
import com.naura.ctc.IComSysLog.RemoteLogFileManagerPrx;

public interface _RemoteAppEntranceOperations
{
    void shutdown(Ice.Current __current);

    RemoteDataPrx getData(String name, Ice.Current __current);

    boolean subData(Ice.Identity id, Ice.StringHolder err, Ice.Current __current);

    void unsubData(Ice.Identity id, Ice.Current __current);

    RemoteBatchReaderPrx getBatchReader(Ice.Current __current);

    RemoteCallbackManagerPrx getCallbackManager(Ice.Current __current);

    RemoteControlObjectPrx getControlObject(String name, Ice.Current __current);

    boolean subCtrlState(Ice.Identity id, Ice.StringHolder err, Ice.Current __current);

    void unsubCtrlState(Ice.Identity id, Ice.Current __current);

    void abortAllCtrlServices(Ice.Current __current);

    RemoteAlarmManagerPrx getAlarmManager(Ice.Current __current);

    RemoteInterlockManagerPrx getInterlockManager(Ice.Current __current);

    RemoteRecipeUserPrx createRecipeUser(Ice.Identity id, Ice.Current __current);

    void deleteRecipeUser(Ice.Identity id, Ice.Current __current);

    String[] getNamespaceNodesUnder(String parent, Ice.Current __current);

    RemoteObjectType objectRTTI(String name, Ice.Current __current);

    RemoteLogFileManagerPrx getLogFileManager(Ice.Current __current);

    RemoteDataLogManagerPrx getDataLogManager(Ice.Current __current);

    RemoteSetupManagerPrx getSetupManager(Ice.Current __current);

    String getInfo(Ice.Current __current);

    void clearDataCtrlSubs(String category, Ice.Current __current);
}
