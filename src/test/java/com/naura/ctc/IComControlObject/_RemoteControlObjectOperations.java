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

public interface _RemoteControlObjectOperations
{
    RemoteServiceInfo[] getServiceInfos(Ice.Current __current);

    RemoteControlState getState(Ice.Current __current);

    void runService(String name, String params, RemoteServiceResultHolder ret, Ice.StringHolder err, Ice.Current __current);

    boolean reset(Ice.Current __current);

    void abortService(Ice.Current __current);
}
