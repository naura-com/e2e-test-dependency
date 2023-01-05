// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComRecipe;

public final class RemoteRecipeMonitorHolder
{
    public
    RemoteRecipeMonitorHolder()
    {
    }

    public
    RemoteRecipeMonitorHolder(RemoteRecipeMonitor value)
    {
	this.value = value;
    }

    public class Patcher implements IceInternal.Patcher
    {
	public void
	patch(Ice.Object v)
	{
	    value = (RemoteRecipeMonitor)v;
	}

	public String
	type()
	{
	    return "::IComRecipe::RemoteRecipeMonitor";
	}
    }

    public Patcher
    getPatcher()
    {
	return new Patcher();
    }

    public RemoteRecipeMonitor value;
}
