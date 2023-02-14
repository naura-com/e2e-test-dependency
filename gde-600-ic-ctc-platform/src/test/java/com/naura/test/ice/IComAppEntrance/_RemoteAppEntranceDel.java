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

public interface _RemoteAppEntranceDel extends Ice._ObjectDel
{
    void shutdown(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteDataPrx getData(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean subData(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void unsubData(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteBatchReaderPrx getBatchReader(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteCallbackManagerPrx getCallbackManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteControlObjectPrx getControlObject(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean subCtrlState(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void unsubCtrlState(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void abortAllCtrlServices(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteAlarmManagerPrx getAlarmManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteInterlockManagerPrx getInterlockManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteRecipeUserPrx createRecipeUser(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void deleteRecipeUser(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    String[] getNamespaceNodesUnder(String parent, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteObjectType objectRTTI(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteLogFileManagerPrx getLogFileManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteDataLogManagerPrx getDataLogManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteSetupManagerPrx getSetupManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    String getInfo(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void clearDataCtrlSubs(String category, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;
}
