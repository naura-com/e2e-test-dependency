// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComRecipe;

public final class StepInfo implements Cloneable
{
    public String name;

    public String[] values;

    public StepInfo()
    {
    }

    public StepInfo(String name, String[] values)
    {
	this.name = name;
	this.values = values;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	StepInfo _r = null;
	try
	{
	    _r = (StepInfo)rhs;
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
	    if(!java.util.Arrays.equals(values, _r.values))
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
	if(values != null)
	{
	    for(int __i0 = 0; __i0 < values.length; __i0++)
	    {
		if(values[__i0] != null)
		{
		    __h = 5 * __h + values[__i0].hashCode();
		}
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
	Ice.StringSeqHelper.write(__os, values);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	name = __is.readString();
	values = Ice.StringSeqHelper.read(__is);
    }
}
