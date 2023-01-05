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

public final class RemoteServiceResult implements Cloneable
{
    public String name;

    public CompoundVariable result;

    public RemoteServiceResult()
    {
    }

    public RemoteServiceResult(String name, CompoundVariable result)
    {
	this.name = name;
	this.result = result;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	RemoteServiceResult _r = null;
	try
	{
	    _r = (RemoteServiceResult)rhs;
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
	    if(result != _r.result && result != null && !result.equals(_r.result))
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
	__h = 5 * __h + result.hashCode();
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
	result.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	name = __is.readString();
	result = new CompoundVariable();
	result.__read(__is);
    }
}
