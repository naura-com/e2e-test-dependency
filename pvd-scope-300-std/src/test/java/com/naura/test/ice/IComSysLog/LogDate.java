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

public final class LogDate implements Cloneable {
    public int day;

    public int month;

    public int year;

    public LogDate() {
    }

    public LogDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean
    equals(Object rhs) {
        if (this == rhs) {
            return true;
        }
        LogDate _r = null;
        try {
            _r = (LogDate) rhs;
        } catch (ClassCastException ex) {
        }

        if (_r != null) {
            if (day != _r.day) {
                return false;
            }
            if (month != _r.month) {
                return false;
            }
            if (year != _r.year) {
                return false;
            }

            return true;
        }

        return false;
    }

    public int
    hashCode() {
        int __h = 0;
        __h = 5 * __h + day;
        __h = 5 * __h + month;
        __h = 5 * __h + year;
        return __h;
    }

    public Object
    clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException ex) {
            assert false; // impossible
        }
        return o;
    }

    public void
    __write(IceInternal.BasicStream __os) {
        __os.writeInt(day);
        __os.writeInt(month);
        __os.writeInt(year);
    }

    public void
    __read(IceInternal.BasicStream __is) {
        day = __is.readInt();
        month = __is.readInt();
        year = __is.readInt();
    }
}
