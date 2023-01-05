// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComDataLog;

public final class RemoteDataLoggerInfo implements Cloneable
{
    public String id;

    public String startCond;

    public String stopCond;

    public String[] condTriggers;

    public long timeTrigger;

    public java.util.Map dataMap;

    public boolean isActive;

    public RemoteDataLoggerInfo()
    {
    }

    public RemoteDataLoggerInfo(String id, String startCond, String stopCond, String[] condTriggers, long timeTrigger, java.util.Map dataMap, boolean isActive)
    {
	this.id = id;
	this.startCond = startCond;
	this.stopCond = stopCond;
	this.condTriggers = condTriggers;
	this.timeTrigger = timeTrigger;
	this.dataMap = dataMap;
	this.isActive = isActive;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	RemoteDataLoggerInfo _r = null;
	try
	{
	    _r = (RemoteDataLoggerInfo)rhs;
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
	    if(startCond != _r.startCond && startCond != null && !startCond.equals(_r.startCond))
	    {
		return false;
	    }
	    if(stopCond != _r.stopCond && stopCond != null && !stopCond.equals(_r.stopCond))
	    {
		return false;
	    }
	    if(!java.util.Arrays.equals(condTriggers, _r.condTriggers))
	    {
		return false;
	    }
	    if(timeTrigger != _r.timeTrigger)
	    {
		return false;
	    }
	    if(dataMap != _r.dataMap && dataMap != null && !dataMap.equals(_r.dataMap))
	    {
		return false;
	    }
	    if(isActive != _r.isActive)
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
	if(startCond != null)
	{
	    __h = 5 * __h + startCond.hashCode();
	}
	if(stopCond != null)
	{
	    __h = 5 * __h + stopCond.hashCode();
	}
	if(condTriggers != null)
	{
	    for(int __i0 = 0; __i0 < condTriggers.length; __i0++)
	    {
		if(condTriggers[__i0] != null)
		{
		    __h = 5 * __h + condTriggers[__i0].hashCode();
		}
	    }
	}
	__h = 5 * __h + (int)timeTrigger;
	if(dataMap != null)
	{
	    __h = 5 * __h + dataMap.hashCode();
	}
	__h = 5 * __h + (isActive ? 1 : 0);
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
	__os.writeString(startCond);
	__os.writeString(stopCond);
	Ice.StringSeqHelper.write(__os, condTriggers);
	__os.writeLong(timeTrigger);
	StringStringDictHelper.write(__os, dataMap);
	__os.writeBool(isActive);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	id = __is.readString();
	startCond = __is.readString();
	stopCond = __is.readString();
	condTriggers = Ice.StringSeqHelper.read(__is);
	timeTrigger = __is.readLong();
	dataMap = StringStringDictHelper.read(__is);
	isActive = __is.readBool();
    }
}
