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

public interface RemoteDataPrx extends Ice.ObjectPrx
{
    public boolean setValue(String value, Ice.StringHolder err);
    public boolean setValue(String value, Ice.StringHolder err, java.util.Map __ctx);

    public void setValue_async(AMI_RemoteData_setValue __cb, String value);
    public void setValue_async(AMI_RemoteData_setValue __cb, String value, java.util.Map __ctx);

    public RemoteValueInfo getValue();
    public RemoteValueInfo getValue(java.util.Map __ctx);

    public RemoteDataInfo getInfo();
    public RemoteDataInfo getInfo(java.util.Map __ctx);
}
