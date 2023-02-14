// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComData;

public final class RemoteDataHolder
{
    public
    RemoteDataHolder()
    {
    }

    public
    RemoteDataHolder(RemoteData value)
    {
	this.value = value;
    }

    public class Patcher implements IceInternal.Patcher
    {
	public void
	patch(Ice.Object v)
	{
	    value = (RemoteData)v;
	}

	public String
	type()
	{
	    return "::IComData::RemoteData";
	}
    }

    public Patcher
    getPatcher()
    {
	return new Patcher();
    }

    public RemoteData value;
}
