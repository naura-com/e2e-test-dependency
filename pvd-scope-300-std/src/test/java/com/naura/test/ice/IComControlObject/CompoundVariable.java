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

public final class CompoundVariable implements Cloneable
{
    public boolean bValue;

    public int iValue;

    public double dValue;

    public String sValue;

    public CompoundVariable()
    {
    }

    public CompoundVariable(boolean bValue, int iValue, double dValue, String sValue)
    {
	this.bValue = bValue;
	this.iValue = iValue;
	this.dValue = dValue;
	this.sValue = sValue;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	CompoundVariable _r = null;
	try
	{
	    _r = (CompoundVariable)rhs;
	}
	catch(ClassCastException ex)
	{
	}

	if(_r != null)
	{
	    if(bValue != _r.bValue)
	    {
		return false;
	    }
	    if(iValue != _r.iValue)
	    {
		return false;
	    }
	    if(dValue != _r.dValue)
	    {
		return false;
	    }
	    if(sValue != _r.sValue && sValue != null && !sValue.equals(_r.sValue))
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
	__h = 5 * __h + (bValue ? 1 : 0);
	__h = 5 * __h + iValue;
	__h = 5 * __h + (int) Double.doubleToLongBits(dValue);
	if(sValue != null)
	{
	    __h = 5 * __h + sValue.hashCode();
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
	__os.writeBool(bValue);
	__os.writeInt(iValue);
	__os.writeDouble(dValue);
	__os.writeString(sValue);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	bValue = __is.readBool();
	iValue = __is.readInt();
	dValue = __is.readDouble();
	sValue = __is.readString();
    }
}
