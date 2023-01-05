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

public final class _RemoteAppEntranceDelM extends Ice._ObjectDelM implements _RemoteAppEntranceDel
{
    public void
    abortAllCtrlServices(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "abortAllCtrlServices", Ice.OperationMode.Normal, __ctx, __compress);
	try
	{
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public void
    clearDataCtrlSubs(String category, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "clearDataCtrlSubs", Ice.OperationMode.Normal, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		__os.writeString(category);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__og.abort(__ex);
	    }
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public com.naura.pvd.IComRecipe.RemoteRecipeUserPrx
    createRecipeUser(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "createRecipeUser", Ice.OperationMode.Normal, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		id.__write(__os);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__og.abort(__ex);
	    }
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		com.naura.pvd.IComRecipe.RemoteRecipeUserPrx __ret;
		__ret = com.naura.pvd.IComRecipe.RemoteRecipeUserPrxHelper.__read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public void
    deleteRecipeUser(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "deleteRecipeUser", Ice.OperationMode.Normal, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		id.__write(__os);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__og.abort(__ex);
	    }
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public com.naura.pvd.IComAlarm.RemoteAlarmManagerPrx
    getAlarmManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getAlarmManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		com.naura.pvd.IComAlarm.RemoteAlarmManagerPrx __ret;
		__ret = com.naura.pvd.IComAlarm.RemoteAlarmManagerPrxHelper.__read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public com.naura.pvd.IComData.RemoteBatchReaderPrx
    getBatchReader(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getBatchReader", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		com.naura.pvd.IComData.RemoteBatchReaderPrx __ret;
		__ret = com.naura.pvd.IComData.RemoteBatchReaderPrxHelper.__read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public RemoteCallbackManagerPrx
    getCallbackManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getCallbackManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		RemoteCallbackManagerPrx __ret;
		__ret = RemoteCallbackManagerPrxHelper.__read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public com.naura.pvd.IComControlObject.RemoteControlObjectPrx
    getControlObject(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getControlObject", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		__os.writeString(name);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__og.abort(__ex);
	    }
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		com.naura.pvd.IComControlObject.RemoteControlObjectPrx __ret;
		__ret = com.naura.pvd.IComControlObject.RemoteControlObjectPrxHelper.__read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public com.naura.pvd.IComData.RemoteDataPrx
    getData(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getData", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		__os.writeString(name);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__og.abort(__ex);
	    }
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		com.naura.pvd.IComData.RemoteDataPrx __ret;
		__ret = com.naura.pvd.IComData.RemoteDataPrxHelper.__read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public com.naura.pvd.IComDataLog.RemoteDataLogManagerPrx
    getDataLogManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getDataLogManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		com.naura.pvd.IComDataLog.RemoteDataLogManagerPrx __ret;
		__ret = com.naura.pvd.IComDataLog.RemoteDataLogManagerPrxHelper.__read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public String
    getInfo(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getInfo", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		String __ret;
		__ret = __is.readString();
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public com.naura.pvd.IComInterlock.RemoteInterlockManagerPrx
    getInterlockManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getInterlockManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		com.naura.pvd.IComInterlock.RemoteInterlockManagerPrx __ret;
		__ret = com.naura.pvd.IComInterlock.RemoteInterlockManagerPrxHelper.__read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public com.naura.pvd.IComSysLog.RemoteLogFileManagerPrx
    getLogFileManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getLogFileManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		com.naura.pvd.IComSysLog.RemoteLogFileManagerPrx __ret;
		__ret = com.naura.pvd.IComSysLog.RemoteLogFileManagerPrxHelper.__read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public String[]
    getNamespaceNodesUnder(String parent, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getNamespaceNodesUnder", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		__os.writeString(parent);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__og.abort(__ex);
	    }
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		String[] __ret;
		__ret = Ice.StringSeqHelper.read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public com.naura.pvd.IComSetup.RemoteSetupManagerPrx
    getSetupManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getSetupManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		com.naura.pvd.IComSetup.RemoteSetupManagerPrx __ret;
		__ret = com.naura.pvd.IComSetup.RemoteSetupManagerPrxHelper.__read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public RemoteObjectType
    objectRTTI(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "objectRTTI", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		__os.writeString(name);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__og.abort(__ex);
	    }
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		RemoteObjectType __ret;
		__ret = RemoteObjectType.__read(__is);
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public void
    shutdown(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "shutdown", Ice.OperationMode.Normal, __ctx, __compress);
	try
	{
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public boolean
    subCtrlState(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "subCtrlState", Ice.OperationMode.Normal, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		id.__write(__os);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__og.abort(__ex);
	    }
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		err.value = __is.readString();
		boolean __ret;
		__ret = __is.readBool();
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public boolean
    subData(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "subData", Ice.OperationMode.Normal, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		id.__write(__os);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__og.abort(__ex);
	    }
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
		err.value = __is.readString();
		boolean __ret;
		__ret = __is.readBool();
		return __ret;
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public void
    unsubCtrlState(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "unsubCtrlState", Ice.OperationMode.Normal, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		id.__write(__os);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__og.abort(__ex);
	    }
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }

    public void
    unsubData(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "unsubData", Ice.OperationMode.Normal, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		id.__write(__os);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__og.abort(__ex);
	    }
	    boolean __ok = __og.invoke();
	    try
	    {
		IceInternal.BasicStream __is = __og.is();
		if(!__ok)
		{
		    try
		    {
			__is.throwException();
		    }
		    catch(Ice.UserException __ex)
		    {
			throw new Ice.UnknownUserException(__ex.ice_name());
		    }
		}
	    }
	    catch(Ice.LocalException __ex)
	    {
		throw new IceInternal.LocalExceptionWrapper(__ex, false);
	    }
	}
	finally
	{
	    __connection.reclaimOutgoing(__og);
	}
    }
}
