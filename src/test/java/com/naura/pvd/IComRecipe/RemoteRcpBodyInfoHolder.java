// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComRecipe;

public final class RemoteRcpBodyInfoHolder
{
    public
    RemoteRcpBodyInfoHolder()
    {
    }

    public
    RemoteRcpBodyInfoHolder(RemoteRcpBodyInfo value)
    {
	this.value = value;
    }

    public class Patcher implements IceInternal.Patcher
    {
	public void
	patch(Ice.Object v)
	{
	    value = (RemoteRcpBodyInfo)v;
	}

	public String
	type()
	{
	    return "::IComRecipe::RemoteRcpBodyInfo";
	}
    }

    public Patcher
    getPatcher()
    {
	return new Patcher();
    }

    public RemoteRcpBodyInfo value;
}
