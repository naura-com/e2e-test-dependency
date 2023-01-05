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

public final class RemoteDoubleDataInfoHolder
{
    public
    RemoteDoubleDataInfoHolder()
    {
    }

    public
    RemoteDoubleDataInfoHolder(RemoteDoubleDataInfo value)
    {
	this.value = value;
    }

    public class Patcher implements IceInternal.Patcher
    {
	public void
	patch(Ice.Object v)
	{
	    value = (RemoteDoubleDataInfo)v;
	}

	public String
	type()
	{
	    return "::IComData::RemoteDoubleDataInfo";
	}
    }

    public Patcher
    getPatcher()
    {
	return new Patcher();
    }

    public RemoteDoubleDataInfo value;
}
