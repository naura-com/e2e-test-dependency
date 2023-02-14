// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComSysLog;

public abstract class _RemoteLogFileManagerDisp extends Ice.ObjectImpl implements RemoteLogFileManager
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
	throws CloneNotSupportedException
    {
	throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
	"::IComSysLog::RemoteLogFileManager",
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
    freezeCursor()
    {
	freezeCursor(null);
    }

    public final boolean
    getAllFilesIndex(LogDate fromDate, LogDate toDate, LogFilesIndexHolder filesIndex, Ice.StringHolder err)
    {
	return getAllFilesIndex(fromDate, toDate, filesIndex, err, null);
    }

    public final void
    getHeadPackage(LogPackageHolder headPackage)
    {
	getHeadPackage(headPackage, null);
    }

    public final int
    getLogFileSize(String fileName)
    {
	return getLogFileSize(fileName, null);
    }

    public final boolean
    getNextPackage(LogPackageHolder nextPackage)
    {
	return getNextPackage(nextPackage, null);
    }

    public final int
    getPackageNum()
    {
	return getPackageNum(null);
    }

    public final boolean
    getPreviousPackage(LogPackageHolder prePackage)
    {
	return getPreviousPackage(prePackage, null);
    }

    public final void
    getTailPackage(LogPackageHolder tailPackage)
    {
	getTailPackage(tailPackage, null);
    }

    public final boolean
    isEndmost()
    {
	return isEndmost(null);
    }

    public final boolean
    isTopmost()
    {
	return isTopmost(null);
    }

    public final int
    loadLogFile(String fileName, boolean refresh)
    {
	return loadLogFile(fileName, refresh, null);
    }

    public final void
    releaseCursor()
    {
	releaseCursor(null);
    }

    public static IceInternal.DispatchStatus
    ___getAllFilesIndex(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	LogDate fromDate;
	fromDate = new LogDate();
	fromDate.__read(__is);
	LogDate toDate;
	toDate = new LogDate();
	toDate.__read(__is);
	LogFilesIndexHolder filesIndex = new LogFilesIndexHolder();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.getAllFilesIndex(fromDate, toDate, filesIndex, err, __current);
	LogFilesIndexHelper.write(__os, filesIndex.value);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___loadLogFile(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String fileName;
	fileName = __is.readString();
	boolean refresh;
	refresh = __is.readBool();
	int __ret = __obj.loadLogFile(fileName, refresh, __current);
	__os.writeInt(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getLogFileSize(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String fileName;
	fileName = __is.readString();
	int __ret = __obj.getLogFileSize(fileName, __current);
	__os.writeInt(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getPackageNum(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	int __ret = __obj.getPackageNum(__current);
	__os.writeInt(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getNextPackage(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	LogPackageHolder nextPackage = new LogPackageHolder();
	boolean __ret = __obj.getNextPackage(nextPackage, __current);
	LogPackageHelper.write(__os, nextPackage.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getPreviousPackage(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	LogPackageHolder prePackage = new LogPackageHolder();
	boolean __ret = __obj.getPreviousPackage(prePackage, __current);
	LogPackageHelper.write(__os, prePackage.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getHeadPackage(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	LogPackageHolder headPackage = new LogPackageHolder();
	__obj.getHeadPackage(headPackage, __current);
	LogPackageHelper.write(__os, headPackage.value);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getTailPackage(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	LogPackageHolder tailPackage = new LogPackageHolder();
	__obj.getTailPackage(tailPackage, __current);
	LogPackageHelper.write(__os, tailPackage.value);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___isTopmost(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	boolean __ret = __obj.isTopmost(__current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___isEndmost(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	boolean __ret = __obj.isEndmost(__current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___freezeCursor(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	__obj.freezeCursor(__current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___releaseCursor(RemoteLogFileManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	__obj.releaseCursor(__current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
	"freezeCursor",
	"getAllFilesIndex",
	"getHeadPackage",
	"getLogFileSize",
	"getNextPackage",
	"getPackageNum",
	"getPreviousPackage",
	"getTailPackage",
	"ice_id",
	"ice_ids",
	"ice_isA",
	"ice_ping",
	"isEndmost",
	"isTopmost",
	"loadLogFile",
	"releaseCursor"
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
		return ___freezeCursor(this, in, __current);
	    }
	    case 1:
	    {
		return ___getAllFilesIndex(this, in, __current);
	    }
	    case 2:
	    {
		return ___getHeadPackage(this, in, __current);
	    }
	    case 3:
	    {
		return ___getLogFileSize(this, in, __current);
	    }
	    case 4:
	    {
		return ___getNextPackage(this, in, __current);
	    }
	    case 5:
	    {
		return ___getPackageNum(this, in, __current);
	    }
	    case 6:
	    {
		return ___getPreviousPackage(this, in, __current);
	    }
	    case 7:
	    {
		return ___getTailPackage(this, in, __current);
	    }
	    case 8:
	    {
		return ___ice_id(this, in, __current);
	    }
	    case 9:
	    {
		return ___ice_ids(this, in, __current);
	    }
	    case 10:
	    {
		return ___ice_isA(this, in, __current);
	    }
	    case 11:
	    {
		return ___ice_ping(this, in, __current);
	    }
	    case 12:
	    {
		return ___isEndmost(this, in, __current);
	    }
	    case 13:
	    {
		return ___isTopmost(this, in, __current);
	    }
	    case 14:
	    {
		return ___loadLogFile(this, in, __current);
	    }
	    case 15:
	    {
		return ___releaseCursor(this, in, __current);
	    }
	}

	assert(false);
	return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
