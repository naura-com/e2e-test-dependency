// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComSysLog;

public final class RemoteLogFileManagerHolder
{
    public
    RemoteLogFileManagerHolder()
    {
    }

    public
    RemoteLogFileManagerHolder(RemoteLogFileManager value)
    {
	this.value = value;
    }

    public class Patcher implements IceInternal.Patcher
    {
	public void
	patch(Ice.Object v)
	{
	    value = (RemoteLogFileManager)v;
	}

	public String
	type()
	{
	    return "::IComSysLog::RemoteLogFileManager";
	}
    }

    public Patcher
    getPatcher()
    {
	return new Patcher();
    }

    public RemoteLogFileManager value;
}
