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

public interface _RemoteLogFileManagerOperationsNC
{
    boolean getAllFilesIndex(LogDate fromDate, LogDate toDate, LogFilesIndexHolder filesIndex, Ice.StringHolder err);

    int loadLogFile(String fileName, boolean refresh);

    int getLogFileSize(String fileName);

    int getPackageNum();

    boolean getNextPackage(LogPackageHolder nextPackage);

    boolean getPreviousPackage(LogPackageHolder prePackage);

    void getHeadPackage(LogPackageHolder headPackage);

    void getTailPackage(LogPackageHolder tailPackage);

    boolean isTopmost();

    boolean isEndmost();

    void freezeCursor();

    void releaseCursor();
}
