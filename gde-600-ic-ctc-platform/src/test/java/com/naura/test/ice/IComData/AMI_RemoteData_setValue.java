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

public abstract class AMI_RemoteData_setValue extends IceInternal.OutgoingAsync
{
    public abstract void ice_response(boolean __ret, String err);
    public abstract void ice_exception(Ice.LocalException ex);

    public final void
    __invoke(Ice.ObjectPrx __prx, AMI_RemoteData_setValue __cb, String value, java.util.Map __ctx)
    {
	try
	{
	    __prepare(__prx, "setValue", Ice.OperationMode.Normal, __ctx);
	    __os.writeString(value);
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
	String err;
	boolean __ret;
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
	    err = __is.readString();
	    __ret = __is.readBool();
	}
	catch(Ice.LocalException __ex)
	{
	    __finished(__ex);
	    return;
	}
	ice_response(__ret, err);
    }
}
