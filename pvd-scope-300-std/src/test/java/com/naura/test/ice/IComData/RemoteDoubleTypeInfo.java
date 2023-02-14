// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComData;

public final class RemoteDoubleTypeInfo implements Cloneable {
    public double min;

    public double max;

    public String unit;

    public double accuracy;

    public RemoteDoubleTypeInfo() {
    }

    public RemoteDoubleTypeInfo(double min, double max, String unit, double accuracy) {
        this.min = min;
        this.max = max;
        this.unit = unit;
        this.accuracy = accuracy;
    }

    public boolean
    equals(Object rhs) {
        if (this == rhs) {
            return true;
        }
        RemoteDoubleTypeInfo _r = null;
        try {
            _r = (RemoteDoubleTypeInfo) rhs;
        } catch (ClassCastException ex) {
        }

        if (_r != null) {
            if (min != _r.min) {
                return false;
            }
            if (max != _r.max) {
                return false;
            }
            if (unit != _r.unit && unit != null && !unit.equals(_r.unit)) {
                return false;
            }
            if (accuracy != _r.accuracy) {
                return false;
            }

            return true;
        }

        return false;
    }

    public int
    hashCode() {
        int __h = 0;
        __h = 5 * __h + (int) Double.doubleToLongBits(min);
        __h = 5 * __h + (int) Double.doubleToLongBits(max);
        if (unit != null) {
            __h = 5 * __h + unit.hashCode();
        }
        __h = 5 * __h + (int) Double.doubleToLongBits(accuracy);
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
        __os.writeDouble(min);
        __os.writeDouble(max);
        __os.writeString(unit);
        __os.writeDouble(accuracy);
    }

    public void
    __read(IceInternal.BasicStream __is) {
        min = __is.readDouble();
        max = __is.readDouble();
        unit = __is.readString();
        accuracy = __is.readDouble();
    }
}
