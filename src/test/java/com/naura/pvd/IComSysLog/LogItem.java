// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComSysLog;

public final class LogItem implements Cloneable
{
    public String time;

    public String branch;

    public String level;

    public String info;

    public LogItem()
    {
    }

    public LogItem(String time, String branch, String level, String info)
    {
	this.time = time;
	this.branch = branch;
	this.level = level;
	this.info = info;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	LogItem _r = null;
	try
	{
	    _r = (LogItem)rhs;
	}
	catch(ClassCastException ex)
	{
	}

	if(_r != null)
	{
	    if(time != _r.time && time != null && !time.equals(_r.time))
	    {
		return false;
	    }
	    if(branch != _r.branch && branch != null && !branch.equals(_r.branch))
	    {
		return false;
	    }
	    if(level != _r.level && level != null && !level.equals(_r.level))
	    {
		return false;
	    }
	    if(info != _r.info && info != null && !info.equals(_r.info))
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
	if(time != null)
	{
	    __h = 5 * __h + time.hashCode();
	}
	if(branch != null)
	{
	    __h = 5 * __h + branch.hashCode();
	}
	if(level != null)
	{
	    __h = 5 * __h + level.hashCode();
	}
	if(info != null)
	{
	    __h = 5 * __h + info.hashCode();
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
	__os.writeString(time);
	__os.writeString(branch);
	__os.writeString(level);
	__os.writeString(info);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	time = __is.readString();
	branch = __is.readString();
	level = __is.readString();
	info = __is.readString();
    }
}
