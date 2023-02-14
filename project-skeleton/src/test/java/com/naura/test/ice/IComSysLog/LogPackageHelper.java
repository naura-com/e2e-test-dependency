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

public final class LogPackageHelper {
    public static void
    write(IceInternal.BasicStream __os, LogItem[] __v) {
        if (__v == null) {
            __os.writeSize(0);
        } else {
            __os.writeSize(__v.length);
            for (int __i0 = 0; __i0 < __v.length; __i0++) {
                __v[__i0].__write(__os);
            }
        }
    }

    public static LogItem[]
    read(IceInternal.BasicStream __is) {
        LogItem[] __v;
        final int __len0 = __is.readSize();
        __is.startSeq(__len0, 4);
        __v = new LogItem[__len0];
        for (int __i0 = 0; __i0 < __len0; __i0++) {
            __v[__i0] = new LogItem();
            __v[__i0].__read(__is);
            __is.checkSeq();
            __is.endElement();
        }
        __is.endSeq(__len0);
        return __v;
    }
}
