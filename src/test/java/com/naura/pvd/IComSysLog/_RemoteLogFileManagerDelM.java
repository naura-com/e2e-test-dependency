// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComSysLog;

public final class _RemoteLogFileManagerDelM extends Ice._ObjectDelM implements _RemoteLogFileManagerDel
{
    public void
    freezeCursor(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "freezeCursor", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
    getAllFilesIndex(LogDate fromDate, LogDate toDate, LogFilesIndexHolder filesIndex, Ice.StringHolder err, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getAllFilesIndex", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		fromDate.__write(__os);
		toDate.__write(__os);
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
		filesIndex.value = LogFilesIndexHelper.read(__is);
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
    getHeadPackage(LogPackageHolder headPackage, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getHeadPackage", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
		headPackage.value = LogPackageHelper.read(__is);
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

    public int
    getLogFileSize(String fileName, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getLogFileSize", Ice.OperationMode.Nonmutating, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		__os.writeString(fileName);
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
		int __ret;
		__ret = __is.readInt();
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
    getNextPackage(LogPackageHolder nextPackage, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getNextPackage", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
		nextPackage.value = LogPackageHelper.read(__is);
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

    public int
    getPackageNum(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getPackageNum", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
		int __ret;
		__ret = __is.readInt();
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
    getPreviousPackage(LogPackageHolder prePackage, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getPreviousPackage", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
		prePackage.value = LogPackageHelper.read(__is);
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
    getTailPackage(LogPackageHolder tailPackage, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getTailPackage", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
		tailPackage.value = LogPackageHelper.read(__is);
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
    isEndmost(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "isEndmost", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
    isTopmost(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "isTopmost", Ice.OperationMode.Nonmutating, __ctx, __compress);
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

    public int
    loadLogFile(String fileName, boolean refresh, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "loadLogFile", Ice.OperationMode.Normal, __ctx, __compress);
	try
	{
	    try
	    {
		IceInternal.BasicStream __os = __og.os();
		__os.writeString(fileName);
		__os.writeBool(refresh);
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
		int __ret;
		__ret = __is.readInt();
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
    releaseCursor(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "releaseCursor", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
}
