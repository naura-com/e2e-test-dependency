// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComData;

public interface RemoteBatchReaderPrx extends Ice.ObjectPrx
{
    public boolean initialize(String[] dataNames);
    public boolean initialize(String[] dataNames, java.util.Map __ctx);

    public RemoteValueInfo[] read();
    public RemoteValueInfo[] read(java.util.Map __ctx);
}
