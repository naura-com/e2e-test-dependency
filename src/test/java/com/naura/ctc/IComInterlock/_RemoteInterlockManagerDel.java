// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComInterlock;

public interface _RemoteInterlockManagerDel extends Ice._ObjectDel
{
    RemoteInterlockInfo getInterlockInfo(String id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteInterlockInfo[] getAllInterlockInfos(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean isActive(String id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean activate(String id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean deactivate(String id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;
}
