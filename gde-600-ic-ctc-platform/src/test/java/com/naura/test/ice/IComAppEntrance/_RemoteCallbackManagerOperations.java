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

public interface _RemoteCallbackManagerOperations
{
    boolean createCallback(Ice.Identity id, Ice.StringHolder err, Ice.Current __current);

    boolean createCallbacks(Ice.Identity[] ids, Ice.Current __current);

    boolean refreshCallbacks(String categroy, Ice.Current __current);

    void deleteCallbacks(String category, Ice.Current __current);

    RemoteCallbackType getType(Ice.Current __current);
}
