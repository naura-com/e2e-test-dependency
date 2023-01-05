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

public interface RemoteInterlockManagerPrx extends Ice.ObjectPrx
{
    public RemoteInterlockInfo getInterlockInfo(String id);
    public RemoteInterlockInfo getInterlockInfo(String id, java.util.Map __ctx);

    public RemoteInterlockInfo[] getAllInterlockInfos();
    public RemoteInterlockInfo[] getAllInterlockInfos(java.util.Map __ctx);

    public boolean isActive(String id);
    public boolean isActive(String id, java.util.Map __ctx);

    public boolean activate(String id);
    public boolean activate(String id, java.util.Map __ctx);

    public boolean deactivate(String id);
    public boolean deactivate(String id, java.util.Map __ctx);
}
