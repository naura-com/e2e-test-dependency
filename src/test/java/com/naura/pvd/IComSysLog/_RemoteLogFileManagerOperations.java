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

public interface _RemoteLogFileManagerOperations
{
    boolean getAllFilesIndex(LogDate fromDate, LogDate toDate, LogFilesIndexHolder filesIndex, Ice.StringHolder err, Ice.Current __current);

    int loadLogFile(String fileName, boolean refresh, Ice.Current __current);

    int getLogFileSize(String fileName, Ice.Current __current);

    int getPackageNum(Ice.Current __current);

    boolean getNextPackage(LogPackageHolder nextPackage, Ice.Current __current);

    boolean getPreviousPackage(LogPackageHolder prePackage, Ice.Current __current);

    void getHeadPackage(LogPackageHolder headPackage, Ice.Current __current);

    void getTailPackage(LogPackageHolder tailPackage, Ice.Current __current);

    boolean isTopmost(Ice.Current __current);

    boolean isEndmost(Ice.Current __current);

    void freezeCursor(Ice.Current __current);

    void releaseCursor(Ice.Current __current);
}
