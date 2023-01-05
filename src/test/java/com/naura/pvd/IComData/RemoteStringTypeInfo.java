// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComData;

public final class RemoteStringTypeInfo implements Cloneable
{
    public long maxLength;

    public RemoteStringTypeInfo()
    {
    }

    public RemoteStringTypeInfo(long maxLength)
    {
	this.maxLength = maxLength;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	RemoteStringTypeInfo _r = null;
	try
	{
	    _r = (RemoteStringTypeInfo)rhs;
	}
	catch(ClassCastException ex)
	{
	}

	if(_r != null)
	{
	    if(maxLength != _r.maxLength)
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
	__h = 5 * __h + (int)maxLength;
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
	__os.writeLong(maxLength);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	maxLength = __is.readLong();
    }
}
