// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComInterlock;

public interface _RemoteInterlockManagerOperationsNC {
    RemoteInterlockInfo getInterlockInfo(String id);

    RemoteInterlockInfo[] getAllInterlockInfos();

    boolean isActive(String id);

    boolean activate(String id);

    boolean deactivate(String id);
}
