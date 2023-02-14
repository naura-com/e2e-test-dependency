// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComControlObject;

public final class RemoteControlObjectPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteControlObjectPrx {
    public void
    abortService() {
        abortService(__defaultContext());
    }

    public void
    abortService(java.util.Map __ctx) {
        int __cnt = 0;
        while (true) {
            try {
                Ice._ObjectDel __delBase = __getDelegate();
                _RemoteControlObjectDel __del = (_RemoteControlObjectDel) __delBase;
                __del.abortService(__ctx);
                return;
            } catch (IceInternal.LocalExceptionWrapper __ex) {
                __handleExceptionWrapper(__ex);
            } catch (Ice.LocalException __ex) {
                __cnt = __handleException(__ex, __cnt);
            }
        }
    }

    public RemoteServiceInfo[]
    getServiceInfos() {
        return getServiceInfos(__defaultContext());
    }

    public RemoteServiceInfo[]
    getServiceInfos(java.util.Map __ctx) {
        int __cnt = 0;
        while (true) {
            try {
                __checkTwowayOnly("getServiceInfos");
                Ice._ObjectDel __delBase = __getDelegate();
                _RemoteControlObjectDel __del = (_RemoteControlObjectDel) __delBase;
                return __del.getServiceInfos(__ctx);
            } catch (IceInternal.LocalExceptionWrapper __ex) {
                __cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
            } catch (Ice.LocalException __ex) {
                __cnt = __handleException(__ex, __cnt);
            }
        }
    }

    public RemoteControlState
    getState() {
        return getState(__defaultContext());
    }

    public RemoteControlState
    getState(java.util.Map __ctx) {
        int __cnt = 0;
        while (true) {
            try {
                __checkTwowayOnly("getState");
                Ice._ObjectDel __delBase = __getDelegate();
                _RemoteControlObjectDel __del = (_RemoteControlObjectDel) __delBase;
                return __del.getState(__ctx);
            } catch (IceInternal.LocalExceptionWrapper __ex) {
                __cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
            } catch (Ice.LocalException __ex) {
                __cnt = __handleException(__ex, __cnt);
            }
        }
    }

    public boolean
    reset() {
        return reset(__defaultContext());
    }

    public boolean
    reset(java.util.Map __ctx) {
        int __cnt = 0;
        while (true) {
            try {
                __checkTwowayOnly("reset");
                Ice._ObjectDel __delBase = __getDelegate();
                _RemoteControlObjectDel __del = (_RemoteControlObjectDel) __delBase;
                return __del.reset(__ctx);
            } catch (IceInternal.LocalExceptionWrapper __ex) {
                __handleExceptionWrapper(__ex);
            } catch (Ice.LocalException __ex) {
                __cnt = __handleException(__ex, __cnt);
            }
        }
    }

    public void
    runService(String name, String params, RemoteServiceResultHolder ret, Ice.StringHolder err) {
        runService(name, params, ret, err, __defaultContext());
    }

    public void
    runService(String name, String params, RemoteServiceResultHolder ret, Ice.StringHolder err, java.util.Map __ctx) {
        int __cnt = 0;
        while (true) {
            try {
                __checkTwowayOnly("runService");
                Ice._ObjectDel __delBase = __getDelegate();
                _RemoteControlObjectDel __del = (_RemoteControlObjectDel) __delBase;
                __del.runService(name, params, ret, err, __ctx);
                return;
            } catch (IceInternal.LocalExceptionWrapper __ex) {
                __handleExceptionWrapper(__ex);
            } catch (Ice.LocalException __ex) {
                __cnt = __handleException(__ex, __cnt);
            }
        }
    }

    public void
    runService_async(AMI_RemoteControlObject_runService __cb, String name, String params) {
        runService_async(__cb, name, params, __defaultContext());
    }

    public void
    runService_async(AMI_RemoteControlObject_runService __cb, String name, String params, java.util.Map __ctx) {
        __cb.__invoke(this, __cb, name, params, __ctx);
    }

    public static RemoteControlObjectPrx
    checkedCast(Ice.ObjectPrx __obj) {
        RemoteControlObjectPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RemoteControlObjectPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComControlObject::RemoteControlObject")) {
                    RemoteControlObjectPrxHelper __h = new RemoteControlObjectPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RemoteControlObjectPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx) {
        RemoteControlObjectPrx __d = null;
        if (__obj != null) {
            try {
                __d = (RemoteControlObjectPrx) __obj;
            } catch (ClassCastException ex) {
                if (__obj.ice_isA("::IComControlObject::RemoteControlObject", __ctx)) {
                    RemoteControlObjectPrxHelper __h = new RemoteControlObjectPrxHelper();
                    __h.__copyFrom(__obj);
                    __d = __h;
                }
            }
        }
        return __d;
    }

    public static RemoteControlObjectPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet) {
        RemoteControlObjectPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComControlObject::RemoteControlObject")) {
                    RemoteControlObjectPrxHelper __h = new RemoteControlObjectPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RemoteControlObjectPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx) {
        RemoteControlObjectPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            try {
                if (__bb.ice_isA("::IComControlObject::RemoteControlObject", __ctx)) {
                    RemoteControlObjectPrxHelper __h = new RemoteControlObjectPrxHelper();
                    __h.__copyFrom(__bb);
                    __d = __h;
                }
            } catch (Ice.FacetNotExistException ex) {
            }
        }
        return __d;
    }

    public static RemoteControlObjectPrx
    uncheckedCast(Ice.ObjectPrx __obj) {
        RemoteControlObjectPrx __d = null;
        if (__obj != null) {
            RemoteControlObjectPrxHelper __h = new RemoteControlObjectPrxHelper();
            __h.__copyFrom(__obj);
            __d = __h;
        }
        return __d;
    }

    public static RemoteControlObjectPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet) {
        RemoteControlObjectPrx __d = null;
        if (__obj != null) {
            Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
            RemoteControlObjectPrxHelper __h = new RemoteControlObjectPrxHelper();
            __h.__copyFrom(__bb);
            __d = __h;
        }
        return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM() {
        return new _RemoteControlObjectDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD() {
        return new _RemoteControlObjectDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteControlObjectPrx v) {
        __os.writeProxy(v);
    }

    public static RemoteControlObjectPrx
    __read(IceInternal.BasicStream __is) {
        Ice.ObjectPrx proxy = __is.readProxy();
        if (proxy != null) {
            RemoteControlObjectPrxHelper result = new RemoteControlObjectPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }
}
