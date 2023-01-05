// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComAlarm;

public final class LongRmtRecoveryInfoDictHelper
{
    public static void
    write(IceInternal.BasicStream __os, java.util.Map __v)
    {
	if(__v == null)
	{
	    __os.writeSize(0);
	}
	else
	{
	    __os.writeSize(__v.size());
	    java.util.Iterator __i0 = __v.entrySet().iterator();
	    while(__i0.hasNext())
	    {
		java.util.Map.Entry __e = (java.util.Map.Entry)__i0.next();
		__os.writeLong(((Long)__e.getKey()).longValue());
		((RemoteRecoveryInfo)__e.getValue()).__write(__os);
	    }
	}
    }

    public static java.util.Map
    read(IceInternal.BasicStream __is)
    {
	java.util.Map __v = new java.util.HashMap();
	__v = new java.util.HashMap();
	int __sz0 = __is.readSize();
	for(int __i0 = 0; __i0 < __sz0; __i0++)
	{
	    Long __key = new Long(__is.readLong());
	    RemoteRecoveryInfo __value;
	    __value = new RemoteRecoveryInfo();
	    __value.__read(__is);
	    __v.put(__key, __value);
	}
	return __v;
    }
}
