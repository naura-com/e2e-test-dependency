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

public interface _RemoteCallbackManagerDel extends Ice._ObjectDel {
    boolean createCallback(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean createCallbacks(Ice.Identity[] ids, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean refreshCallbacks(String categroy, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    void deleteCallbacks(String category, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    RemoteCallbackType getType(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;
}
