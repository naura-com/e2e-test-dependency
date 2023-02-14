// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComControlObject;

public final class RemoteServiceInfo implements Cloneable
{
    public String name;

    public String description;

    public RmtServiceParamInfo[] params;

    public RemoteServiceInfo()
    {
    }

    public RemoteServiceInfo(String name, String description, RmtServiceParamInfo[] params)
    {
	this.name = name;
	this.description = description;
	this.params = params;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	RemoteServiceInfo _r = null;
	try
	{
	    _r = (RemoteServiceInfo)rhs;
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
	    if(description != _r.description && description != null && !description.equals(_r.description))
	    {
		return false;
	    }
	    if(!java.util.Arrays.equals(params, _r.params))
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
	if(description != null)
	{
	    __h = 5 * __h + description.hashCode();
	}
	if(params != null)
	{
	    for(int __i0 = 0; __i0 < params.length; __i0++)
	    {
		__h = 5 * __h + params[__i0].hashCode();
	    }
	}
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
	__os.writeString(description);
	RmtServiceParamInfoSeqHelper.write(__os, params);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	name = __is.readString();
	description = __is.readString();
	params = RmtServiceParamInfoSeqHelper.read(__is);
    }
}
