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

public interface _RemoteAppEntranceDel extends Ice._ObjectDel
{
    void shutdown(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    com.naura.pvd.IComData.RemoteDataPrx getData(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean subData(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void unsubData(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    com.naura.pvd.IComData.RemoteBatchReaderPrx getBatchReader(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteCallbackManagerPrx getCallbackManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    com.naura.pvd.IComControlObject.RemoteControlObjectPrx getControlObject(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean subCtrlState(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void unsubCtrlState(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void abortAllCtrlServices(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    com.naura.pvd.IComAlarm.RemoteAlarmManagerPrx getAlarmManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    com.naura.pvd.IComInterlock.RemoteInterlockManagerPrx getInterlockManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    com.naura.pvd.IComRecipe.RemoteRecipeUserPrx createRecipeUser(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void deleteRecipeUser(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    String[] getNamespaceNodesUnder(String parent, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteObjectType objectRTTI(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    com.naura.pvd.IComSysLog.RemoteLogFileManagerPrx getLogFileManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    com.naura.pvd.IComDataLog.RemoteDataLogManagerPrx getDataLogManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    com.naura.pvd.IComSetup.RemoteSetupManagerPrx getSetupManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    String getInfo(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void clearDataCtrlSubs(String category, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;
}
