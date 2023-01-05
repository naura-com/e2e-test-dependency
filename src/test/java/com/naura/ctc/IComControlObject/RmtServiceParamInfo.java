// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComControlObject;

public final class RmtServiceParamInfo implements Cloneable
{
    public String id;

    public String type;

    public String description;

    public RmtServiceParamInfo()
    {
    }

    public RmtServiceParamInfo(String id, String type, String description)
    {
	this.id = id;
	this.type = type;
	this.description = description;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	RmtServiceParamInfo _r = null;
	try
	{
	    _r = (RmtServiceParamInfo)rhs;
	}
	catch(ClassCastException ex)
	{
	}

	if(_r != null)
	{
	    if(id != _r.id && id != null && !id.equals(_r.id))
	    {
		return false;
	    }
	    if(type != _r.type && type != null && !type.equals(_r.type))
	    {
		return false;
	    }
	    if(description != _r.description && description != null && !description.equals(_r.description))
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
	if(id != null)
	{
	    __h = 5 * __h + id.hashCode();
	}
	if(type != null)
	{
	    __h = 5 * __h + type.hashCode();
	}
	if(description != null)
	{
	    __h = 5 * __h + description.hashCode();
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
	__os.writeString(id);
	__os.writeString(type);
	__os.writeString(description);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	id = __is.readString();
	type = __is.readString();
	description = __is.readString();
    }
}
