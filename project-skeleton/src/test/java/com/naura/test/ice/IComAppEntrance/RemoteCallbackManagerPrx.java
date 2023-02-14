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

public interface RemoteCallbackManagerPrx extends Ice.ObjectPrx {
    public boolean createCallback(Ice.Identity id, Ice.StringHolder err);

    public boolean createCallback(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx);

    public boolean createCallbacks(Ice.Identity[] ids);

    public boolean createCallbacks(Ice.Identity[] ids, java.util.Map __ctx);

    public boolean refreshCallbacks(String categroy);

    public boolean refreshCallbacks(String categroy, java.util.Map __ctx);

    public void deleteCallbacks(String category);

    public void deleteCallbacks(String category, java.util.Map __ctx);

    public RemoteCallbackType getType();

    public RemoteCallbackType getType(java.util.Map __ctx);
}
