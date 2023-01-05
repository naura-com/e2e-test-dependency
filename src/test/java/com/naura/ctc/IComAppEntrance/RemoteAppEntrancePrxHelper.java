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

public final class RemoteAppEntrancePrxHelper extends Ice.ObjectPrxHelperBase implements RemoteAppEntrancePrx
{
    public void
    abortAllCtrlServices()
    {
	abortAllCtrlServices(__defaultContext());
    }

    public void
    abortAllCtrlServices(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		__del.abortAllCtrlServices(__ctx);
		return;
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public void
    clearDataCtrlSubs(String category)
    {
	clearDataCtrlSubs(category, __defaultContext());
    }

    public void
    clearDataCtrlSubs(String category, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		__del.clearDataCtrlSubs(category, __ctx);
		return;
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteRecipeUserPrx
    createRecipeUser(Ice.Identity id)
    {
	return createRecipeUser(id, __defaultContext());
    }

    public RemoteRecipeUserPrx
    createRecipeUser(Ice.Identity id, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("createRecipeUser");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.createRecipeUser(id, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public void
    deleteRecipeUser(Ice.Identity id)
    {
	deleteRecipeUser(id, __defaultContext());
    }

    public void
    deleteRecipeUser(Ice.Identity id, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		__del.deleteRecipeUser(id, __ctx);
		return;
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteAlarmManagerPrx
    getAlarmManager()
    {
	return getAlarmManager(__defaultContext());
    }

    public RemoteAlarmManagerPrx
    getAlarmManager(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getAlarmManager");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.getAlarmManager(__ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteBatchReaderPrx
    getBatchReader()
    {
	return getBatchReader(__defaultContext());
    }

    public RemoteBatchReaderPrx
    getBatchReader(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getBatchReader");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.getBatchReader(__ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteCallbackManagerPrx
    getCallbackManager()
    {
	return getCallbackManager(__defaultContext());
    }

    public RemoteCallbackManagerPrx
    getCallbackManager(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getCallbackManager");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.getCallbackManager(__ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteControlObjectPrx
    getControlObject(String name)
    {
	return getControlObject(name, __defaultContext());
    }

    public RemoteControlObjectPrx
    getControlObject(String name, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getControlObject");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.getControlObject(name, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteDataPrx
    getData(String name)
    {
	return getData(name, __defaultContext());
    }

    public RemoteDataPrx
    getData(String name, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getData");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.getData(name, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteDataLogManagerPrx
    getDataLogManager()
    {
	return getDataLogManager(__defaultContext());
    }

    public RemoteDataLogManagerPrx
    getDataLogManager(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getDataLogManager");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.getDataLogManager(__ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public String
    getInfo()
    {
	return getInfo(__defaultContext());
    }

    public String
    getInfo(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getInfo");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.getInfo(__ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteInterlockManagerPrx
    getInterlockManager()
    {
	return getInterlockManager(__defaultContext());
    }

    public RemoteInterlockManagerPrx
    getInterlockManager(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getInterlockManager");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.getInterlockManager(__ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteLogFileManagerPrx
    getLogFileManager()
    {
	return getLogFileManager(__defaultContext());
    }

    public RemoteLogFileManagerPrx
    getLogFileManager(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getLogFileManager");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.getLogFileManager(__ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public String[]
    getNamespaceNodesUnder(String parent)
    {
	return getNamespaceNodesUnder(parent, __defaultContext());
    }

    public String[]
    getNamespaceNodesUnder(String parent, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getNamespaceNodesUnder");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.getNamespaceNodesUnder(parent, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteSetupManagerPrx
    getSetupManager()
    {
	return getSetupManager(__defaultContext());
    }

    public RemoteSetupManagerPrx
    getSetupManager(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getSetupManager");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.getSetupManager(__ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteObjectType
    objectRTTI(String name)
    {
	return objectRTTI(name, __defaultContext());
    }

    public RemoteObjectType
    objectRTTI(String name, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("objectRTTI");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.objectRTTI(name, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public void
    shutdown()
    {
	shutdown(__defaultContext());
    }

    public void
    shutdown(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		__del.shutdown(__ctx);
		return;
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public boolean
    subCtrlState(Ice.Identity id, Ice.StringHolder err)
    {
	return subCtrlState(id, err, __defaultContext());
    }

    public boolean
    subCtrlState(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("subCtrlState");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.subCtrlState(id, err, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public boolean
    subData(Ice.Identity id, Ice.StringHolder err)
    {
	return subData(id, err, __defaultContext());
    }

    public boolean
    subData(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("subData");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		return __del.subData(id, err, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public void
    unsubCtrlState(Ice.Identity id)
    {
	unsubCtrlState(id, __defaultContext());
    }

    public void
    unsubCtrlState(Ice.Identity id, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		__del.unsubCtrlState(id, __ctx);
		return;
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public void
    unsubData(Ice.Identity id)
    {
	unsubData(id, __defaultContext());
    }

    public void
    unsubData(Ice.Identity id, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteAppEntranceDel __del = (_RemoteAppEntranceDel)__delBase;
		__del.unsubData(id, __ctx);
		return;
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public static RemoteAppEntrancePrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteAppEntrancePrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteAppEntrancePrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComAppEntrance::RemoteAppEntrance"))
		{
		    RemoteAppEntrancePrxHelper __h = new RemoteAppEntrancePrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteAppEntrancePrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteAppEntrancePrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteAppEntrancePrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComAppEntrance::RemoteAppEntrance", __ctx))
		{
		    RemoteAppEntrancePrxHelper __h = new RemoteAppEntrancePrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteAppEntrancePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteAppEntrancePrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComAppEntrance::RemoteAppEntrance"))
		{
		    RemoteAppEntrancePrxHelper __h = new RemoteAppEntrancePrxHelper();
		    __h.__copyFrom(__bb);
		    __d = __h;
		}
	    }
	    catch(Ice.FacetNotExistException ex)
	    {
	    }
	}
	return __d;
    }

    public static RemoteAppEntrancePrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteAppEntrancePrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComAppEntrance::RemoteAppEntrance", __ctx))
		{
		    RemoteAppEntrancePrxHelper __h = new RemoteAppEntrancePrxHelper();
		    __h.__copyFrom(__bb);
		    __d = __h;
		}
	    }
	    catch(Ice.FacetNotExistException ex)
	    {
	    }
	}
	return __d;
    }

    public static RemoteAppEntrancePrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteAppEntrancePrx __d = null;
	if(__obj != null)
	{
	    RemoteAppEntrancePrxHelper __h = new RemoteAppEntrancePrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteAppEntrancePrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteAppEntrancePrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteAppEntrancePrxHelper __h = new RemoteAppEntrancePrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteAppEntranceDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteAppEntranceDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteAppEntrancePrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteAppEntrancePrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteAppEntrancePrxHelper result = new RemoteAppEntrancePrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
