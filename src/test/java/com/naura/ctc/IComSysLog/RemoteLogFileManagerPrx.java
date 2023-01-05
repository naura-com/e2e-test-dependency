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

public interface RemoteLogFileManagerPrx extends Ice.ObjectPrx
{
    public boolean getAllFilesIndex(LogDate fromDate, LogDate toDate, LogFilesIndexHolder filesIndex, Ice.StringHolder err);
    public boolean getAllFilesIndex(LogDate fromDate, LogDate toDate, LogFilesIndexHolder filesIndex, Ice.StringHolder err, java.util.Map __ctx);

    public int loadLogFile(String fileName, boolean refresh);
    public int loadLogFile(String fileName, boolean refresh, java.util.Map __ctx);

    public int getLogFileSize(String fileName);
    public int getLogFileSize(String fileName, java.util.Map __ctx);

    public int getPackageNum();
    public int getPackageNum(java.util.Map __ctx);

    public boolean getNextPackage(LogPackageHolder nextPackage);
    public boolean getNextPackage(LogPackageHolder nextPackage, java.util.Map __ctx);

    public boolean getPreviousPackage(LogPackageHolder prePackage);
    public boolean getPreviousPackage(LogPackageHolder prePackage, java.util.Map __ctx);

    public void getHeadPackage(LogPackageHolder headPackage);
    public void getHeadPackage(LogPackageHolder headPackage, java.util.Map __ctx);

    public void getTailPackage(LogPackageHolder tailPackage);
    public void getTailPackage(LogPackageHolder tailPackage, java.util.Map __ctx);

    public boolean isTopmost();
    public boolean isTopmost(java.util.Map __ctx);

    public boolean isEndmost();
    public boolean isEndmost(java.util.Map __ctx);

    public void freezeCursor();
    public void freezeCursor(java.util.Map __ctx);

    public void releaseCursor();
    public void releaseCursor(java.util.Map __ctx);
}
