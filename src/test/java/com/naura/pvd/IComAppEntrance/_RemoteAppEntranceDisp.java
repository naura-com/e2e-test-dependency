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

public abstract class _RemoteAppEntranceDisp extends Ice.ObjectImpl implements RemoteAppEntrance
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
	throws CloneNotSupportedException
    {
	throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
	"::IComAppEntrance::RemoteAppEntrance",
	"::Ice::Object"
    };

    public boolean
    ice_isA(String s)
    {
	return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
	return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
	return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
	return __ids;
    }

    public String
    ice_id()
    {
	return __ids[0];
    }

    public String
    ice_id(Ice.Current __current)
    {
	return __ids[0];
    }

    public static String
    ice_staticId()
    {
	return __ids[0];
    }

    public final void
    abortAllCtrlServices()
    {
	abortAllCtrlServices(null);
    }

    public final void
    clearDataCtrlSubs(String category)
    {
	clearDataCtrlSubs(category, null);
    }

    public final com.naura.pvd.IComRecipe.RemoteRecipeUserPrx
    createRecipeUser(Ice.Identity id)
    {
	return createRecipeUser(id, null);
    }

    public final void
    deleteRecipeUser(Ice.Identity id)
    {
	deleteRecipeUser(id, null);
    }

    public final com.naura.pvd.IComAlarm.RemoteAlarmManagerPrx
    getAlarmManager()
    {
	return getAlarmManager(null);
    }

    public final com.naura.pvd.IComData.RemoteBatchReaderPrx
    getBatchReader()
    {
	return getBatchReader(null);
    }

    public final RemoteCallbackManagerPrx
    getCallbackManager()
    {
	return getCallbackManager(null);
    }

    public final com.naura.pvd.IComControlObject.RemoteControlObjectPrx
    getControlObject(String name)
    {
	return getControlObject(name, null);
    }

    public final com.naura.pvd.IComData.RemoteDataPrx
    getData(String name)
    {
	return getData(name, null);
    }

    public final com.naura.pvd.IComDataLog.RemoteDataLogManagerPrx
    getDataLogManager()
    {
	return getDataLogManager(null);
    }

    public final String
    getInfo()
    {
	return getInfo(null);
    }

    public final com.naura.pvd.IComInterlock.RemoteInterlockManagerPrx
    getInterlockManager()
    {
	return getInterlockManager(null);
    }

    public final com.naura.pvd.IComSysLog.RemoteLogFileManagerPrx
    getLogFileManager()
    {
	return getLogFileManager(null);
    }

    public final String[]
    getNamespaceNodesUnder(String parent)
    {
	return getNamespaceNodesUnder(parent, null);
    }

    public final com.naura.pvd.IComSetup.RemoteSetupManagerPrx
    getSetupManager()
    {
	return getSetupManager(null);
    }

    public final RemoteObjectType
    objectRTTI(String name)
    {
	return objectRTTI(name, null);
    }

    public final void
    shutdown()
    {
	shutdown(null);
    }

    public final boolean
    subCtrlState(Ice.Identity id, Ice.StringHolder err)
    {
	return subCtrlState(id, err, null);
    }

    public final boolean
    subData(Ice.Identity id, Ice.StringHolder err)
    {
	return subData(id, err, null);
    }

    public final void
    unsubCtrlState(Ice.Identity id)
    {
	unsubCtrlState(id, null);
    }

    public final void
    unsubData(Ice.Identity id)
    {
	unsubData(id, null);
    }

    public static IceInternal.DispatchStatus
    ___shutdown(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	__obj.shutdown(__current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getData(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	com.naura.pvd.IComData.RemoteDataPrx __ret = __obj.getData(name, __current);
	com.naura.pvd.IComData.RemoteDataPrxHelper.__write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___subData(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
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
    ___unsubData(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	Ice.Identity id;
	id = new Ice.Identity();
	id.__read(__is);
	__obj.unsubData(id, __current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getBatchReader(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	com.naura.pvd.IComData.RemoteBatchReaderPrx __ret = __obj.getBatchReader(__current);
	com.naura.pvd.IComData.RemoteBatchReaderPrxHelper.__write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getCallbackManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	RemoteCallbackManagerPrx __ret = __obj.getCallbackManager(__current);
	RemoteCallbackManagerPrxHelper.__write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getControlObject(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	com.naura.pvd.IComControlObject.RemoteControlObjectPrx __ret = __obj.getControlObject(name, __current);
	com.naura.pvd.IComControlObject.RemoteControlObjectPrxHelper.__write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___subCtrlState(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
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
    ___unsubCtrlState(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	Ice.Identity id;
	id = new Ice.Identity();
	id.__read(__is);
	__obj.unsubCtrlState(id, __current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___abortAllCtrlServices(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	__obj.abortAllCtrlServices(__current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getAlarmManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	com.naura.pvd.IComAlarm.RemoteAlarmManagerPrx __ret = __obj.getAlarmManager(__current);
	com.naura.pvd.IComAlarm.RemoteAlarmManagerPrxHelper.__write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getInterlockManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	com.naura.pvd.IComInterlock.RemoteInterlockManagerPrx __ret = __obj.getInterlockManager(__current);
	com.naura.pvd.IComInterlock.RemoteInterlockManagerPrxHelper.__write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___createRecipeUser(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	Ice.Identity id;
	id = new Ice.Identity();
	id.__read(__is);
	com.naura.pvd.IComRecipe.RemoteRecipeUserPrx __ret = __obj.createRecipeUser(id, __current);
	com.naura.pvd.IComRecipe.RemoteRecipeUserPrxHelper.__write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___deleteRecipeUser(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	Ice.Identity id;
	id = new Ice.Identity();
	id.__read(__is);
	__obj.deleteRecipeUser(id, __current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getNamespaceNodesUnder(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
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
    ___objectRTTI(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
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
    ___getLogFileManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	com.naura.pvd.IComSysLog.RemoteLogFileManagerPrx __ret = __obj.getLogFileManager(__current);
	com.naura.pvd.IComSysLog.RemoteLogFileManagerPrxHelper.__write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getDataLogManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	com.naura.pvd.IComDataLog.RemoteDataLogManagerPrx __ret = __obj.getDataLogManager(__current);
	com.naura.pvd.IComDataLog.RemoteDataLogManagerPrxHelper.__write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getSetupManager(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	com.naura.pvd.IComSetup.RemoteSetupManagerPrx __ret = __obj.getSetupManager(__current);
	com.naura.pvd.IComSetup.RemoteSetupManagerPrxHelper.__write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getInfo(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	String __ret = __obj.getInfo(__current);
	__os.writeString(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___clearDataCtrlSubs(RemoteAppEntrance __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
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

    public IceInternal.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
	int pos = java.util.Arrays.binarySearch(__all, __current.operation);
	if(pos < 0)
	{
	    return IceInternal.DispatchStatus.DispatchOperationNotExist;
	}

	switch(pos)
	{
	    case 0:
	    {
		return ___abortAllCtrlServices(this, in, __current);
	    }
	    case 1:
	    {
		return ___clearDataCtrlSubs(this, in, __current);
	    }
	    case 2:
	    {
		return ___createRecipeUser(this, in, __current);
	    }
	    case 3:
	    {
		return ___deleteRecipeUser(this, in, __current);
	    }
	    case 4:
	    {
		return ___getAlarmManager(this, in, __current);
	    }
	    case 5:
	    {
		return ___getBatchReader(this, in, __current);
	    }
	    case 6:
	    {
		return ___getCallbackManager(this, in, __current);
	    }
	    case 7:
	    {
		return ___getControlObject(this, in, __current);
	    }
	    case 8:
	    {
		return ___getData(this, in, __current);
	    }
	    case 9:
	    {
		return ___getDataLogManager(this, in, __current);
	    }
	    case 10:
	    {
		return ___getInfo(this, in, __current);
	    }
	    case 11:
	    {
		return ___getInterlockManager(this, in, __current);
	    }
	    case 12:
	    {
		return ___getLogFileManager(this, in, __current);
	    }
	    case 13:
	    {
		return ___getNamespaceNodesUnder(this, in, __current);
	    }
	    case 14:
	    {
		return ___getSetupManager(this, in, __current);
	    }
	    case 15:
	    {
		return ___ice_id(this, in, __current);
	    }
	    case 16:
	    {
		return ___ice_ids(this, in, __current);
	    }
	    case 17:
	    {
		return ___ice_isA(this, in, __current);
	    }
	    case 18:
	    {
		return ___ice_ping(this, in, __current);
	    }
	    case 19:
	    {
		return ___objectRTTI(this, in, __current);
	    }
	    case 20:
	    {
		return ___shutdown(this, in, __current);
	    }
	    case 21:
	    {
		return ___subCtrlState(this, in, __current);
	    }
	    case 22:
	    {
		return ___subData(this, in, __current);
	    }
	    case 23:
	    {
		return ___unsubCtrlState(this, in, __current);
	    }
	    case 24:
	    {
		return ___unsubData(this, in, __current);
	    }
	}

	assert(false);
	return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
