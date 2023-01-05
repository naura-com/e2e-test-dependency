// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComInterlock;

public interface _RemoteInterlockManagerOperations
{
    RemoteInterlockInfo getInterlockInfo(String id, Ice.Current __current);

    RemoteInterlockInfo[] getAllInterlockInfos(Ice.Current __current);

    boolean isActive(String id, Ice.Current __current);

    boolean activate(String id, Ice.Current __current);

    boolean deactivate(String id, Ice.Current __current);
}
