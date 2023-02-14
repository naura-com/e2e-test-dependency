// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComSysLog;

public final class DailyLogIndex implements Cloneable
{
    public String date;

    public String[] fileNames;

    public DailyLogIndex()
    {
    }

    public DailyLogIndex(String date, String[] fileNames)
    {
	this.date = date;
	this.fileNames = fileNames;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	DailyLogIndex _r = null;
	try
	{
	    _r = (DailyLogIndex)rhs;
	}
	catch(ClassCastException ex)
	{
	}

	if(_r != null)
	{
	    if(date != _r.date && date != null && !date.equals(_r.date))
	    {
		return false;
	    }
	    if(!java.util.Arrays.equals(fileNames, _r.fileNames))
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
	if(date != null)
	{
	    __h = 5 * __h + date.hashCode();
	}
	if(fileNames != null)
	{
	    for(int __i0 = 0; __i0 < fileNames.length; __i0++)
	    {
		if(fileNames[__i0] != null)
		{
		    __h = 5 * __h + fileNames[__i0].hashCode();
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
	__os.writeString(date);
	Ice.StringSeqHelper.write(__os, fileNames);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	date = __is.readString();
	fileNames = Ice.StringSeqHelper.read(__is);
    }
}
