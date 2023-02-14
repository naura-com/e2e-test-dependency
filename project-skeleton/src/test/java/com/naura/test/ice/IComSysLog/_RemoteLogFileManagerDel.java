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

public interface _RemoteLogFileManagerDel extends Ice._ObjectDel {
    boolean getAllFilesIndex(LogDate fromDate, LogDate toDate, LogFilesIndexHolder filesIndex, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    int loadLogFile(String fileName, boolean refresh, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    int getLogFileSize(String fileName, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    int getPackageNum(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean getNextPackage(LogPackageHolder nextPackage, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean getPreviousPackage(LogPackageHolder prePackage, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    void getHeadPackage(LogPackageHolder headPackage, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    void getTailPackage(LogPackageHolder tailPackage, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean isTopmost(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean isEndmost(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    void freezeCursor(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    void releaseCursor(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;
}
