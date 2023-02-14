// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComDataLog;

public interface _RemoteDataLogManagerDel extends Ice._ObjectDel
{
    String[] getAllDataLoggerIDs(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean startDataLogger(String id, Ice.StringHolder err, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void stopDataLogger(String id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteDataLoggerInfo getDataLoggerInfo(String id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteDataLoggerInfo[] getAllDataLoggerInfos(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteDBType getDBType(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;
}
