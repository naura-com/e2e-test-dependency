// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComRecipe;

public final class RemoteRcpMgmtEvent implements Cloneable
{
    public RemoteRcpEventType type;

    public String changedItem;

    public RemoteRcpMgmtEvent()
    {
    }

    public RemoteRcpMgmtEvent(RemoteRcpEventType type, String changedItem)
    {
	this.type = type;
	this.changedItem = changedItem;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	RemoteRcpMgmtEvent _r = null;
	try
	{
	    _r = (RemoteRcpMgmtEvent)rhs;
	}
	catch(ClassCastException ex)
	{
	}

	if(_r != null)
	{
	    if(type != _r.type && type != null && !type.equals(_r.type))
	    {
		return false;
	    }
	    if(changedItem != _r.changedItem && changedItem != null && !changedItem.equals(_r.changedItem))
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
	__h = 5 * __h + type.hashCode();
	if(changedItem != null)
	{
	    __h = 5 * __h + changedItem.hashCode();
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
	type.__write(__os);
	__os.writeString(changedItem);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	type = RemoteRcpEventType.__read(__is);
	changedItem = __is.readString();
    }
}
