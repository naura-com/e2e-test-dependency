// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComAlarm;

public final class RemoteRecoveryInfoSeqHelper
{
    public static void
    write(IceInternal.BasicStream __os, RemoteRecoveryInfo[] __v)
    {
	if(__v == null)
	{
	    __os.writeSize(0);
	}
	else
	{
	    __os.writeSize(__v.length);
	    for(int __i0 = 0; __i0 < __v.length; __i0++)
	    {
		__v[__i0].__write(__os);
	    }
	}
    }

    public static RemoteRecoveryInfo[]
    read(IceInternal.BasicStream __is)
    {
	RemoteRecoveryInfo[] __v;
	final int __len0 = __is.readSize();
	__is.startSeq(__len0, 2);
	__v = new RemoteRecoveryInfo[__len0];
	for(int __i0 = 0; __i0 < __len0; __i0++)
	{
	    __v[__i0] = new RemoteRecoveryInfo();
	    __v[__i0].__read(__is);
	    __is.checkSeq();
	    __is.endElement();
	}
	__is.endSeq(__len0);
	return __v;
    }
}
