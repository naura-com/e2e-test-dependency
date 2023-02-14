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

public final class RemoteDoubleDataInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteDoubleDataInfoPrx {
    public static RemoteDoubleDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj) {
        RemoteDoubleDataInfoPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RemoteDoubleDataInfoPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComData::RemoteDoubleDataInfo")) {
                    RemoteDoubleDataInfoPrxHelper __h = new RemoteDoubleDataInfoPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RemoteDoubleDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx) {
        RemoteDoubleDataInfoPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RemoteDoubleDataInfoPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComData::RemoteDoubleDataInfo", __ctx)) {
                    RemoteDoubleDataInfoPrxHelper __h = new RemoteDoubleDataInfoPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RemoteDoubleDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet) {
        RemoteDoubleDataInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComData::RemoteDoubleDataInfo")) {
                    RemoteDoubleDataInfoPrxHelper __h = new RemoteDoubleDataInfoPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RemoteDoubleDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx) {
        RemoteDoubleDataInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComData::RemoteDoubleDataInfo", __ctx)) {
                    RemoteDoubleDataInfoPrxHelper __h = new RemoteDoubleDataInfoPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RemoteDoubleDataInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj) {
        RemoteDoubleDataInfoPrx __d = null;
        if (__obj != null) {
            RemoteDoubleDataInfoPrxHelper __h = new RemoteDoubleDataInfoPrxHelper();
            __h.__copyFrom(__obj);
            __d = __h;
        }
        return __d;
    }

    public static RemoteDoubleDataInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet) {
        RemoteDoubleDataInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            RemoteDoubleDataInfoPrxHelper __h = new RemoteDoubleDataInfoPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM() {
        return new _RemoteDoubleDataInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD() {
        return new _RemoteDoubleDataInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteDoubleDataInfoPrx v) {
        __os.writeProxy(v);
    }

    public static RemoteDoubleDataInfoPrx
    __read(IceInternal.BasicStream __is) {
        Ice.ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {
            RemoteDoubleDataInfoPrxHelper result = new RemoteDoubleDataInfoPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
