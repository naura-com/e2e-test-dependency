// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComAppEntrance;

public interface _RemoteCallbackManagerOperationsNC
{
    boolean createCallback(Ice.Identity id, Ice.StringHolder err);

    boolean createCallbacks(Ice.Identity[] ids);

    boolean refreshCallbacks(String categroy);

    void deleteCallbacks(String category);

    RemoteCallbackType getType();
}
