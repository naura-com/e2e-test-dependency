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

public final class RemoteDataMonitorPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteDataMonitorPrx {
    public void
    update(RemoteValueInfo valueInfo) {
        update(valueInfo, __defaultContext());
    }

    public void
    update(RemoteValueInfo valueInfo, java.util.Map __ctx) {
        int __cnt = 0;
        while (true) {
            try {
                Ice._ObjectDel __delBase = __getDelegate();
                _RemoteDataMonitorDel __del = (_RemoteDataMonitorDel) __delBase;
                __del.update(valueInfo, __ctx);
                return;
            } catch (IceInternal.LocalExceptionWrapper __ex) {
                __handleExceptionWrapper(__ex);
            } catch (Ice.LocalException __ex) {
                __cnt = __handleException(__ex, __cnt);
            }
        }
    }

    public static RemoteDataMonitorPrx
    checkedCast(Ice.ObjectPrx __obj) {
        RemoteDataMonitorPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RemoteDataMonitorPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComData::RemoteDataMonitor")) {
                    RemoteDataMonitorPrxHelper __h = new RemoteDataMonitorPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RemoteDataMonitorPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx) {
        RemoteDataMonitorPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RemoteDataMonitorPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComData::RemoteDataMonitor", __ctx)) {
                    RemoteDataMonitorPrxHelper __h = new RemoteDataMonitorPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RemoteDataMonitorPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet) {
        RemoteDataMonitorPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComData::RemoteDataMonitor")) {
                    RemoteDataMonitorPrxHelper __h = new RemoteDataMonitorPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RemoteDataMonitorPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx) {
        RemoteDataMonitorPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComData::RemoteDataMonitor", __ctx)) {
                    RemoteDataMonitorPrxHelper __h = new RemoteDataMonitorPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RemoteDataMonitorPrx
    uncheckedCast(Ice.ObjectPrx __obj) {
        RemoteDataMonitorPrx __d = null;
        if (__obj != null) {
            RemoteDataMonitorPrxHelper __h = new RemoteDataMonitorPrxHelper();
            __h.__copyFrom(__obj);
            __d = __h;
        }
        return __d;
    }

    public static RemoteDataMonitorPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet) {
        RemoteDataMonitorPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            RemoteDataMonitorPrxHelper __h = new RemoteDataMonitorPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM() {
        return new _RemoteDataMonitorDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD() {
        return new _RemoteDataMonitorDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteDataMonitorPrx v) {
        __os.writeProxy(v);
    }

    public static RemoteDataMonitorPrx
    __read(IceInternal.BasicStream __is) {
        Ice.ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {
            RemoteDataMonitorPrxHelper result = new RemoteDataMonitorPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
