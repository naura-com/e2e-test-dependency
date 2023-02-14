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

public final class RemoteInterlockInfoHolder
{
    public
    RemoteInterlockInfoHolder()
    {
    }

    public
    RemoteInterlockInfoHolder(RemoteInterlockInfo value)
    {
	this.value = value;
    }

    public class Patcher implements IceInternal.Patcher
    {
	public void
	patch(Ice.Object v)
	{
	    value = (RemoteInterlockInfo)v;
	}

	public String
	type()
	{
	    return "::IComInterlock::RemoteInterlockInfo";
	}
    }

    public Patcher
    getPatcher()
    {
	return new Patcher();
    }

    public RemoteInterlockInfo value;
}
