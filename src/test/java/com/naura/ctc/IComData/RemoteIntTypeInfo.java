// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComData;

public final class RemoteIntTypeInfo implements Cloneable
{
    public int min;

    public int max;

    public String unit;

    public RemoteNameValuePair[] descriptors;

    public RemoteIntTypeInfo()
    {
    }

    public RemoteIntTypeInfo(int min, int max, String unit, RemoteNameValuePair[] descriptors)
    {
	this.min = min;
	this.max = max;
	this.unit = unit;
	this.descriptors = descriptors;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	RemoteIntTypeInfo _r = null;
	try
	{
	    _r = (RemoteIntTypeInfo)rhs;
	}
	catch(ClassCastException ex)
	{
	}

	if(_r != null)
	{
	    if(min != _r.min)
	    {
		return false;
	    }
	    if(max != _r.max)
	    {
		return false;
	    }
	    if(unit != _r.unit && unit != null && !unit.equals(_r.unit))
	    {
		return false;
	    }
	    if(!java.util.Arrays.equals(descriptors, _r.descriptors))
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
	__h = 5 * __h + min;
	__h = 5 * __h + max;
	if(unit != null)
	{
	    __h = 5 * __h + unit.hashCode();
	}
	if(descriptors != null)
	{
	    for(int __i0 = 0; __i0 < descriptors.length; __i0++)
	    {
		__h = 5 * __h + descriptors[__i0].hashCode();
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
	__os.writeInt(min);
	__os.writeInt(max);
	__os.writeString(unit);
	RemoteDescriptorSeqHelper.write(__os, descriptors);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	min = __is.readInt();
	max = __is.readInt();
	unit = __is.readString();
	descriptors = RemoteDescriptorSeqHelper.read(__is);
    }
}
