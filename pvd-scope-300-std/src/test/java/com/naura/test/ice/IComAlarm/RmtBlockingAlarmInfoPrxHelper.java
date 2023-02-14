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

public final class RmtBlockingAlarmInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RmtBlockingAlarmInfoPrx {
    public static RmtBlockingAlarmInfoPrx
    checkedCast(Ice.ObjectPrx __obj) {
        RmtBlockingAlarmInfoPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RmtBlockingAlarmInfoPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComAlarm::RmtBlockingAlarmInfo")) {
                    RmtBlockingAlarmInfoPrxHelper __h = new RmtBlockingAlarmInfoPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RmtBlockingAlarmInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx) {
        RmtBlockingAlarmInfoPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RmtBlockingAlarmInfoPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComAlarm::RmtBlockingAlarmInfo", __ctx)) {
                    RmtBlockingAlarmInfoPrxHelper __h = new RmtBlockingAlarmInfoPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RmtBlockingAlarmInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet) {
        RmtBlockingAlarmInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComAlarm::RmtBlockingAlarmInfo")) {
                    RmtBlockingAlarmInfoPrxHelper __h = new RmtBlockingAlarmInfoPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RmtBlockingAlarmInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx) {
        RmtBlockingAlarmInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComAlarm::RmtBlockingAlarmInfo", __ctx)) {
                    RmtBlockingAlarmInfoPrxHelper __h = new RmtBlockingAlarmInfoPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RmtBlockingAlarmInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj) {
        RmtBlockingAlarmInfoPrx __d = null;
        if (__obj != null) {
            RmtBlockingAlarmInfoPrxHelper __h = new RmtBlockingAlarmInfoPrxHelper();
            __h.__copyFrom(__obj);
            __d = __h;
        }
        return __d;
    }

    public static RmtBlockingAlarmInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet) {
        RmtBlockingAlarmInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            RmtBlockingAlarmInfoPrxHelper __h = new RmtBlockingAlarmInfoPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM() {
        return new _RmtBlockingAlarmInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD() {
        return new _RmtBlockingAlarmInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RmtBlockingAlarmInfoPrx v) {
        __os.writeProxy(v);
    }

    public static RmtBlockingAlarmInfoPrx
    __read(IceInternal.BasicStream __is) {
        Ice.ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {
            RmtBlockingAlarmInfoPrxHelper result = new RmtBlockingAlarmInfoPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
