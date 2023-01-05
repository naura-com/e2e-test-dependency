// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComData;

public interface _RemoteDataDel extends Ice._ObjectDel
{
    boolean setValue(String value, Ice.StringHolder err, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteValueInfo getValue(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteDataInfo getInfo(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;
}
