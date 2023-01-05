// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComAlarm;

public final class RemoteAlarmManagerHolder
{
    public
    RemoteAlarmManagerHolder()
    {
    }

    public
    RemoteAlarmManagerHolder(RemoteAlarmManager value)
    {
	this.value = value;
    }

    public class Patcher implements IceInternal.Patcher
    {
	public void
	patch(Ice.Object v)
	{
	    value = (RemoteAlarmManager)v;
	}

	public String
	type()
	{
	    return "::IComAlarm::RemoteAlarmManager";
	}
    }

    public Patcher
    getPatcher()
    {
	return new Patcher();
    }

    public RemoteAlarmManager value;
}
