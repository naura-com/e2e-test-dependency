// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComControlObject;

public abstract class AMI_RemoteControlObject_runService extends IceInternal.OutgoingAsync
{
    public abstract void ice_response(RemoteServiceResult ret, String err);
    public abstract void ice_exception(Ice.LocalException ex);

    public final void
    __invoke(Ice.ObjectPrx __prx, AMI_RemoteControlObject_runService __cb, String name, String params, java.util.Map __ctx)
    {
	try
	{
	    __prepare(__prx, "runService", Ice.OperationMode.Normal, __ctx);
	    __os.writeString(name);
	    __os.writeString(params);
	    __os.endWriteEncaps();
	}
	catch(Ice.LocalException __ex)
	{
	    __finished(__ex);
	    return;
	}
	__send();
    }

    protected final void
    __response(boolean __ok)
    {
	RemoteServiceResult ret;
	String err;
	try
	{
	    if(!__ok)
	    {
		try
		{
		    __is.throwException();
		}
		catch(Ice.UserException __ex)
		{
		    throw new Ice.UnknownUserException(__ex.ice_name());
		}
	    }
	    ret = new RemoteServiceResult();
	    ret.__read(__is);
	    err = __is.readString();
	}
	catch(Ice.LocalException __ex)
	{
	    __finished(__ex);
	    return;
	}
	ice_response(ret, err);
    }
}
