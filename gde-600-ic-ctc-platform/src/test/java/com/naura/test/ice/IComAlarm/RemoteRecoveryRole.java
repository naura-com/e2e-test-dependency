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

public final class RemoteRecoveryRole implements Cloneable
{
    public int type;

    public long referItem;

    public boolean isRunning;

    public RemoteRecoveryRole()
    {
    }

    public RemoteRecoveryRole(int type, long referItem, boolean isRunning)
    {
	this.type = type;
	this.referItem = referItem;
	this.isRunning = isRunning;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	RemoteRecoveryRole _r = null;
	try
	{
	    _r = (RemoteRecoveryRole)rhs;
	}
	catch(ClassCastException ex)
	{
	}

	if(_r != null)
	{
	    if(type != _r.type)
	    {
		return false;
	    }
	    if(referItem != _r.referItem)
	    {
		return false;
	    }
	    if(isRunning != _r.isRunning)
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
	__h = 5 * __h + type;
	__h = 5 * __h + (int)referItem;
	__h = 5 * __h + (isRunning ? 1 : 0);
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
	__os.writeInt(type);
	__os.writeLong(referItem);
	__os.writeBool(isRunning);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	type = __is.readInt();
	referItem = __is.readLong();
	isRunning = __is.readBool();
    }
}
