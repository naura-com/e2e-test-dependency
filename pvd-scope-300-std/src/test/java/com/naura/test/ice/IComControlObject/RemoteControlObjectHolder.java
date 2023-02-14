// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComControlObject;

public final class RemoteControlObjectHolder
{
    public
    RemoteControlObjectHolder()
    {
    }

    public
    RemoteControlObjectHolder(RemoteControlObject value)
    {
	this.value = value;
    }

    public class Patcher implements IceInternal.Patcher
    {
	public void
	patch(Ice.Object v)
	{
	    value = (RemoteControlObject)v;
	}

	public String
	type()
	{
	    return "::IComControlObject::RemoteControlObject";
	}
    }

    public Patcher
    getPatcher()
    {
	return new Patcher();
    }

    public RemoteControlObject value;
}
