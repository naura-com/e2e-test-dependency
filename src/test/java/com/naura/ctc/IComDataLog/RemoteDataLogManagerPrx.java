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

public interface RemoteDataLogManagerPrx extends Ice.ObjectPrx
{
    public String[] getAllDataLoggerIDs();
    public String[] getAllDataLoggerIDs(java.util.Map __ctx);

    public boolean startDataLogger(String id, Ice.StringHolder err);
    public boolean startDataLogger(String id, Ice.StringHolder err, java.util.Map __ctx);

    public void stopDataLogger(String id);
    public void stopDataLogger(String id, java.util.Map __ctx);

    public RemoteDataLoggerInfo getDataLoggerInfo(String id);
    public RemoteDataLoggerInfo getDataLoggerInfo(String id, java.util.Map __ctx);

    public RemoteDataLoggerInfo[] getAllDataLoggerInfos();
    public RemoteDataLoggerInfo[] getAllDataLoggerInfos(java.util.Map __ctx);

    public RemoteDBType getDBType();
    public RemoteDBType getDBType(java.util.Map __ctx);
}
