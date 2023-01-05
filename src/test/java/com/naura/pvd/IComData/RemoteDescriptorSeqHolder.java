// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComData;

public final class RemoteDescriptorSeqHolder
{
    public
    RemoteDescriptorSeqHolder()
    {
    }

    public
    RemoteDescriptorSeqHolder(RemoteNameValuePair[] value)
    {
	this.value = value;
    }

    public RemoteNameValuePair[] value;
}
