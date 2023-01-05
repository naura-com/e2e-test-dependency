// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComDataLog;

public final class RemoteDataLogManagerPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteDataLogManagerPrx
{
    public String[]
    getAllDataLoggerIDs()
    {
	return getAllDataLoggerIDs(__defaultContext());
    }

    public String[]
    getAllDataLoggerIDs(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getAllDataLoggerIDs");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteDataLogManagerDel __del = (_RemoteDataLogManagerDel)__delBase;
		return __del.getAllDataLoggerIDs(__ctx);
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

    public RemoteDataLoggerInfo[]
    getAllDataLoggerInfos()
    {
	return getAllDataLoggerInfos(__defaultContext());
    }

    public RemoteDataLoggerInfo[]
    getAllDataLoggerInfos(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getAllDataLoggerInfos");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteDataLogManagerDel __del = (_RemoteDataLogManagerDel)__delBase;
		return __del.getAllDataLoggerInfos(__ctx);
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

    public RemoteDBType
    getDBType()
    {
	return getDBType(__defaultContext());
    }

    public RemoteDBType
    getDBType(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getDBType");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteDataLogManagerDel __del = (_RemoteDataLogManagerDel)__delBase;
		return __del.getDBType(__ctx);
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

    public RemoteDataLoggerInfo
    getDataLoggerInfo(String id)
    {
	return getDataLoggerInfo(id, __defaultContext());
    }

    public RemoteDataLoggerInfo
    getDataLoggerInfo(String id, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getDataLoggerInfo");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteDataLogManagerDel __del = (_RemoteDataLogManagerDel)__delBase;
		return __del.getDataLoggerInfo(id, __ctx);
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

    public boolean
    startDataLogger(String id, Ice.StringHolder err)
    {
	return startDataLogger(id, err, __defaultContext());
    }

    public boolean
    startDataLogger(String id, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("startDataLogger");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteDataLogManagerDel __del = (_RemoteDataLogManagerDel)__delBase;
		return __del.startDataLogger(id, err, __ctx);
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
    stopDataLogger(String id)
    {
	stopDataLogger(id, __defaultContext());
    }

    public void
    stopDataLogger(String id, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteDataLogManagerDel __del = (_RemoteDataLogManagerDel)__delBase;
		__del.stopDataLogger(id, __ctx);
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

    public static RemoteDataLogManagerPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteDataLogManagerPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteDataLogManagerPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComDataLog::RemoteDataLogManager"))
		{
		    RemoteDataLogManagerPrxHelper __h = new RemoteDataLogManagerPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteDataLogManagerPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteDataLogManagerPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteDataLogManagerPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComDataLog::RemoteDataLogManager", __ctx))
		{
		    RemoteDataLogManagerPrxHelper __h = new RemoteDataLogManagerPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteDataLogManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteDataLogManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComDataLog::RemoteDataLogManager"))
		{
		    RemoteDataLogManagerPrxHelper __h = new RemoteDataLogManagerPrxHelper();
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

    public static RemoteDataLogManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteDataLogManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComDataLog::RemoteDataLogManager", __ctx))
		{
		    RemoteDataLogManagerPrxHelper __h = new RemoteDataLogManagerPrxHelper();
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

    public static RemoteDataLogManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteDataLogManagerPrx __d = null;
	if(__obj != null)
	{
	    RemoteDataLogManagerPrxHelper __h = new RemoteDataLogManagerPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteDataLogManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteDataLogManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteDataLogManagerPrxHelper __h = new RemoteDataLogManagerPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteDataLogManagerDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteDataLogManagerDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteDataLogManagerPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteDataLogManagerPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteDataLogManagerPrxHelper result = new RemoteDataLogManagerPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
