// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComControlObject;

public interface _RemoteControlObjectOperationsNC
{
    RemoteServiceInfo[] getServiceInfos();

    RemoteControlState getState();

    void runService(String name, String params, RemoteServiceResultHolder ret, Ice.StringHolder err);

    boolean reset();

    void abortService();
}
