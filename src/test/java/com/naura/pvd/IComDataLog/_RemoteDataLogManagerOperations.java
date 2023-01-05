// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComDataLog;

public interface _RemoteDataLogManagerOperations
{
    String[] getAllDataLoggerIDs(Ice.Current __current);

    boolean startDataLogger(String id, Ice.StringHolder err, Ice.Current __current);

    void stopDataLogger(String id, Ice.Current __current);

    RemoteDataLoggerInfo getDataLoggerInfo(String id, Ice.Current __current);

    RemoteDataLoggerInfo[] getAllDataLoggerInfos(Ice.Current __current);

    RemoteDBType getDBType(Ice.Current __current);
}
