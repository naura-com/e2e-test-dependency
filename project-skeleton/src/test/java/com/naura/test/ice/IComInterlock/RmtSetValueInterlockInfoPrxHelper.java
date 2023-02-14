// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComInterlock;

public final class RmtSetValueInterlockInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RmtSetValueInterlockInfoPrx {
    public static RmtSetValueInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj) {
        RmtSetValueInterlockInfoPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RmtSetValueInterlockInfoPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComInterlock::RmtSetValueInterlockInfo")) {
                    RmtSetValueInterlockInfoPrxHelper __h = new RmtSetValueInterlockInfoPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RmtSetValueInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx) {
        RmtSetValueInterlockInfoPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RmtSetValueInterlockInfoPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComInterlock::RmtSetValueInterlockInfo", __ctx)) {
                    RmtSetValueInterlockInfoPrxHelper __h = new RmtSetValueInterlockInfoPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RmtSetValueInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet) {
        RmtSetValueInterlockInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComInterlock::RmtSetValueInterlockInfo")) {
                    RmtSetValueInterlockInfoPrxHelper __h = new RmtSetValueInterlockInfoPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RmtSetValueInterlockInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx) {
        RmtSetValueInterlockInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComInterlock::RmtSetValueInterlockInfo", __ctx)) {
                    RmtSetValueInterlockInfoPrxHelper __h = new RmtSetValueInterlockInfoPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RmtSetValueInterlockInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj) {
        RmtSetValueInterlockInfoPrx __d = null;
        if (__obj != null) {
            RmtSetValueInterlockInfoPrxHelper __h = new RmtSetValueInterlockInfoPrxHelper();
            __h.__copyFrom(__obj);
            __d = __h;
        }
        return __d;
    }

    public static RmtSetValueInterlockInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet) {
        RmtSetValueInterlockInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            RmtSetValueInterlockInfoPrxHelper __h = new RmtSetValueInterlockInfoPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM() {
        return new _RmtSetValueInterlockInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD() {
        return new _RmtSetValueInterlockInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RmtSetValueInterlockInfoPrx v) {
        __os.writeProxy(v);
    }

    public static RmtSetValueInterlockInfoPrx
    __read(IceInternal.BasicStream __is) {
        Ice.ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {
            RmtSetValueInterlockInfoPrxHelper result = new RmtSetValueInterlockInfoPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
