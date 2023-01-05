// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComInterlock;

public final class RmtSetValueInterlockInfoHolder
{
    public
    RmtSetValueInterlockInfoHolder()
    {
    }

    public
    RmtSetValueInterlockInfoHolder(RmtSetValueInterlockInfo value)
    {
	this.value = value;
    }

    public class Patcher implements IceInternal.Patcher
    {
	public void
	patch(Ice.Object v)
	{
	    value = (RmtSetValueInterlockInfo)v;
	}

	public String
	type()
	{
	    return "::IComInterlock::RmtSetValueInterlockInfo";
	}
    }

    public Patcher
    getPatcher()
    {
	return new Patcher();
    }

    public RmtSetValueInterlockInfo value;
}
