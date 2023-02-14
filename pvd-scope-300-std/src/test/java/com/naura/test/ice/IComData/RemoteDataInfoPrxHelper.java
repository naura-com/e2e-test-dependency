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

public final class RemoteDataInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteDataInfoPrx {
    public static RemoteDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj) {
        RemoteDataInfoPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RemoteDataInfoPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComData::RemoteDataInfo")) {
                    RemoteDataInfoPrxHelper __h = new RemoteDataInfoPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RemoteDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx) {
        RemoteDataInfoPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RemoteDataInfoPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComData::RemoteDataInfo", __ctx)) {
                    RemoteDataInfoPrxHelper __h = new RemoteDataInfoPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RemoteDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet) {
        RemoteDataInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComData::RemoteDataInfo")) {
                    RemoteDataInfoPrxHelper __h = new RemoteDataInfoPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RemoteDataInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx) {
        RemoteDataInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComData::RemoteDataInfo", __ctx)) {
                    RemoteDataInfoPrxHelper __h = new RemoteDataInfoPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RemoteDataInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj) {
        RemoteDataInfoPrx __d = null;
        if (__obj != null) {
            RemoteDataInfoPrxHelper __h = new RemoteDataInfoPrxHelper();
            __h.__copyFrom(__obj);
            __d = __h;
        }
        return __d;
    }

    public static RemoteDataInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet) {
        RemoteDataInfoPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            RemoteDataInfoPrxHelper __h = new RemoteDataInfoPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM() {
        return new _RemoteDataInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD() {
        return new _RemoteDataInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteDataInfoPrx v) {
        __os.writeProxy(v);
    }

    public static RemoteDataInfoPrx
    __read(IceInternal.BasicStream __is) {
        Ice.ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {
            RemoteDataInfoPrxHelper result = new RemoteDataInfoPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
