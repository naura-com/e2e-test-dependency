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

public abstract class _RemoteControlObjectDisp extends Ice.ObjectImpl implements RemoteControlObject {
    protected void
    ice_copyStateFrom(Ice.Object __obj)
            throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
            {
                    "::IComControlObject::RemoteControlObject",
                    "::Ice::Object"
            };

    public boolean
    ice_isA(String s) {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current) {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids() {
        return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current) {
        return __ids;
    }

    public String
    ice_id() {
        return __ids[0];
    }

    public String
    ice_id(Ice.Current __current) {
        return __ids[0];
    }

    public static String
    ice_staticId() {
        return __ids[0];
    }

    public final void
    abortService() {
        abortService(null);
    }

    public final RemoteServiceInfo[]
    getServiceInfos() {
        return getServiceInfos(null);
    }

    public final RemoteControlState
    getState() {
        return getState(null);
    }

    public final boolean
    reset() {
        return reset(null);
    }

    public final void
    runService(String name, String params, RemoteServiceResultHolder ret, Ice.StringHolder err) {
        runService(name, params, ret, err, null);
    }

    public static IceInternal.DispatchStatus
    ___getServiceInfos(RemoteControlObject __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        RemoteServiceInfo[] __ret = __obj.getServiceInfos(__current);
        RemoteServiceInfoSeqHelper.write(__os, __ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getState(RemoteControlObject __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Nonmutating, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        RemoteControlState __ret = __obj.getState(__current);
        __ret.__write(__os);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___runService(RemoteControlObject __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.is();
        IceInternal.BasicStream __os = __inS.os();
        String name;
        name = __is.readString();
        String params;
        params = __is.readString();
        RemoteServiceResultHolder ret = new RemoteServiceResultHolder();
        Ice.StringHolder err = new Ice.StringHolder();
        __obj.runService(name, params, ret, err, __current);
        ret.value.__write(__os);
        __os.writeString(err.value);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___reset(RemoteControlObject __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __os = __inS.os();
        boolean __ret = __obj.reset(__current);
        __os.writeBool(__ret);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___abortService(RemoteControlObject __obj, IceInternal.Incoming __inS, Ice.Current __current) {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        __obj.abortService(__current);
        return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
            {
                    "abortService",
                    "getServiceInfos",
                    "getState",
                    "ice_id",
                    "ice_ids",
                    "ice_isA",
                    "ice_ping",
                    "reset",
                    "runService"
            };

    public IceInternal.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current) {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if (pos < 0) {
            return IceInternal.DispatchStatus.DispatchOperationNotExist;
        }

        switch (pos) {
            case 0: {
                return ___abortService(this, in, __current);
            }
            case 1: {
                return ___getServiceInfos(this, in, __current);
            }
            case 2: {
                return ___getState(this, in, __current);
            }
            case 3: {
                return ___ice_id(this, in, __current);
            }
            case 4: {
                return ___ice_ids(this, in, __current);
            }
            case 5: {
                return ___ice_isA(this, in, __current);
            }
            case 6: {
                return ___ice_ping(this, in, __current);
            }
            case 7: {
                return ___reset(this, in, __current);
            }
            case 8: {
                return ___runService(this, in, __current);
            }
        }

        assert (false);
        return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
