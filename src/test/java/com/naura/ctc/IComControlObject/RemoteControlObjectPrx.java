// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComControlObject;

public interface RemoteControlObjectPrx extends Ice.ObjectPrx
{
    public RemoteServiceInfo[] getServiceInfos();
    public RemoteServiceInfo[] getServiceInfos(java.util.Map __ctx);

    public RemoteControlState getState();
    public RemoteControlState getState(java.util.Map __ctx);

    public void runService(String name, String params, RemoteServiceResultHolder ret, Ice.StringHolder err);
    public void runService(String name, String params, RemoteServiceResultHolder ret, Ice.StringHolder err, java.util.Map __ctx);

    public void runService_async(AMI_RemoteControlObject_runService __cb, String name, String params);
    public void runService_async(AMI_RemoteControlObject_runService __cb, String name, String params, java.util.Map __ctx);

    public boolean reset();
    public boolean reset(java.util.Map __ctx);

    public void abortService();
    public void abortService(java.util.Map __ctx);
}
