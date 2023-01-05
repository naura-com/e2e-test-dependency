// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComSysLog;

public final class RemoteLogFileManagerPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteLogFileManagerPrx
{
    public void
    freezeCursor()
    {
	freezeCursor(__defaultContext());
    }

    public void
    freezeCursor(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		__del.freezeCursor(__ctx);
		return;
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
    getAllFilesIndex(LogDate fromDate, LogDate toDate, LogFilesIndexHolder filesIndex, Ice.StringHolder err)
    {
	return getAllFilesIndex(fromDate, toDate, filesIndex, err, __defaultContext());
    }

    public boolean
    getAllFilesIndex(LogDate fromDate, LogDate toDate, LogFilesIndexHolder filesIndex, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getAllFilesIndex");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		return __del.getAllFilesIndex(fromDate, toDate, filesIndex, err, __ctx);
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
    getHeadPackage(LogPackageHolder headPackage)
    {
	getHeadPackage(headPackage, __defaultContext());
    }

    public void
    getHeadPackage(LogPackageHolder headPackage, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getHeadPackage");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		__del.getHeadPackage(headPackage, __ctx);
		return;
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

    public int
    getLogFileSize(String fileName)
    {
	return getLogFileSize(fileName, __defaultContext());
    }

    public int
    getLogFileSize(String fileName, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getLogFileSize");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		return __del.getLogFileSize(fileName, __ctx);
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
    getNextPackage(LogPackageHolder nextPackage)
    {
	return getNextPackage(nextPackage, __defaultContext());
    }

    public boolean
    getNextPackage(LogPackageHolder nextPackage, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getNextPackage");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		return __del.getNextPackage(nextPackage, __ctx);
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

    public int
    getPackageNum()
    {
	return getPackageNum(__defaultContext());
    }

    public int
    getPackageNum(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getPackageNum");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		return __del.getPackageNum(__ctx);
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
    getPreviousPackage(LogPackageHolder prePackage)
    {
	return getPreviousPackage(prePackage, __defaultContext());
    }

    public boolean
    getPreviousPackage(LogPackageHolder prePackage, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getPreviousPackage");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		return __del.getPreviousPackage(prePackage, __ctx);
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
    getTailPackage(LogPackageHolder tailPackage)
    {
	getTailPackage(tailPackage, __defaultContext());
    }

    public void
    getTailPackage(LogPackageHolder tailPackage, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getTailPackage");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		__del.getTailPackage(tailPackage, __ctx);
		return;
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
    isEndmost()
    {
	return isEndmost(__defaultContext());
    }

    public boolean
    isEndmost(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("isEndmost");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		return __del.isEndmost(__ctx);
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
    isTopmost()
    {
	return isTopmost(__defaultContext());
    }

    public boolean
    isTopmost(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("isTopmost");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		return __del.isTopmost(__ctx);
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

    public int
    loadLogFile(String fileName, boolean refresh)
    {
	return loadLogFile(fileName, refresh, __defaultContext());
    }

    public int
    loadLogFile(String fileName, boolean refresh, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("loadLogFile");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		return __del.loadLogFile(fileName, refresh, __ctx);
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
    releaseCursor()
    {
	releaseCursor(__defaultContext());
    }

    public void
    releaseCursor(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteLogFileManagerDel __del = (_RemoteLogFileManagerDel)__delBase;
		__del.releaseCursor(__ctx);
		return;
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

    public static RemoteLogFileManagerPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteLogFileManagerPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteLogFileManagerPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComSysLog::RemoteLogFileManager"))
		{
		    RemoteLogFileManagerPrxHelper __h = new RemoteLogFileManagerPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteLogFileManagerPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteLogFileManagerPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteLogFileManagerPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComSysLog::RemoteLogFileManager", __ctx))
		{
		    RemoteLogFileManagerPrxHelper __h = new RemoteLogFileManagerPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteLogFileManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteLogFileManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComSysLog::RemoteLogFileManager"))
		{
		    RemoteLogFileManagerPrxHelper __h = new RemoteLogFileManagerPrxHelper();
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

    public static RemoteLogFileManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteLogFileManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComSysLog::RemoteLogFileManager", __ctx))
		{
		    RemoteLogFileManagerPrxHelper __h = new RemoteLogFileManagerPrxHelper();
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

    public static RemoteLogFileManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteLogFileManagerPrx __d = null;
	if(__obj != null)
	{
	    RemoteLogFileManagerPrxHelper __h = new RemoteLogFileManagerPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteLogFileManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteLogFileManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteLogFileManagerPrxHelper __h = new RemoteLogFileManagerPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteLogFileManagerDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteLogFileManagerDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteLogFileManagerPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteLogFileManagerPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteLogFileManagerPrxHelper result = new RemoteLogFileManagerPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
