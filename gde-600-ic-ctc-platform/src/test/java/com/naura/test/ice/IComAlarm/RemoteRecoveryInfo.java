// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComAlarm;

public final class RemoteRecoveryInfo implements Cloneable
{
    public String message;

    public RemoteRecoveryType type;

    public RemoteRecoveryInfo()
    {
    }

    public RemoteRecoveryInfo(String message, RemoteRecoveryType type)
    {
	this.message = message;
	this.type = type;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	RemoteRecoveryInfo _r = null;
	try
	{
	    _r = (RemoteRecoveryInfo)rhs;
	}
	catch(ClassCastException ex)
	{
	}

	if(_r != null)
	{
	    if(message != _r.message && message != null && !message.equals(_r.message))
	    {
		return false;
	    }
	    if(type != _r.type && type != null && !type.equals(_r.type))
	    {
		return false;
	    }

	    return true;
	}

	return false;
    }

    public int
    hashCode()
    {
	int __h = 0;
	if(message != null)
	{
	    __h = 5 * __h + message.hashCode();
	}
	__h = 5 * __h + type.hashCode();
	return __h;
    }

    public Object
    clone()
    {
	Object o = null;
	try
	{
	    o = super.clone();
	}
	catch(CloneNotSupportedException ex)
	{
	    assert false; // impossible
	}
	return o;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
	__os.writeString(message);
	type.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	message = __is.readString();
	type = RemoteRecoveryType.__read(__is);
    }
}
