// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComData;

public interface _RemoteDataOperations
{
    boolean setValue(String value, Ice.StringHolder err, Ice.Current __current);

    RemoteValueInfo getValue(Ice.Current __current);

    RemoteDataInfo getInfo(Ice.Current __current);
}
