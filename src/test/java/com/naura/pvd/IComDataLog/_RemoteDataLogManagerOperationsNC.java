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

public interface _RemoteDataLogManagerOperationsNC
{
    String[] getAllDataLoggerIDs();

    boolean startDataLogger(String id, Ice.StringHolder err);

    void stopDataLogger(String id);

    RemoteDataLoggerInfo getDataLoggerInfo(String id);

    RemoteDataLoggerInfo[] getAllDataLoggerInfos();

    RemoteDBType getDBType();
}
