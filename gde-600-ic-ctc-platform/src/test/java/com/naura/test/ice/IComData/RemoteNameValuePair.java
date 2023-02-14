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

public final class RemoteNameValuePair implements Cloneable
{
    public String name;

    public int value;

    public RemoteNameValuePair()
    {
    }

    public RemoteNameValuePair(String name, int value)
    {
	this.name = name;
	this.value = value;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	RemoteNameValuePair _r = null;
	try
	{
	    _r = (RemoteNameValuePair)rhs;
	}
	catch(ClassCastException ex)
	{
	}

	if(_r != null)
	{
	    if(name != _r.name && name != null && !name.equals(_r.name))
	    {
		return false;
	    }
	    if(value != _r.value)
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
	if(name != null)
	{
	    __h = 5 * __h + name.hashCode();
	}
	__h = 5 * __h + value;
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
	__os.writeString(name);
	__os.writeInt(value);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	name = __is.readString();
	value = __is.readInt();
    }
}
