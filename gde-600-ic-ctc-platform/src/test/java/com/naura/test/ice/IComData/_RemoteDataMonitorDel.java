// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComData;

public interface _RemoteDataMonitorDel extends Ice._ObjectDel
{
    void update(RemoteValueInfo valueInfo, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;
}
