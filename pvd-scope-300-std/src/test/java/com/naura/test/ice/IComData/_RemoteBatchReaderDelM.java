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

public final class _RemoteBatchReaderDelM extends Ice._ObjectDelM implements _RemoteBatchReaderDel {
    public boolean
    initialize(String[] dataNames, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "initialize", Ice.OperationMode.Normal, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                Ice.StringSeqHelper.write(__os, dataNames);
            } catch (Ice.LocalException __ex) {
                __og.abort(__ex);
            }
            boolean __ok = __og.invoke();
            try {
                IceInternal.BasicStream __is = __og.is();
                if (!__ok) {
                    try {
                        __is.throwException();
                    } catch (Ice.UserException __ex) {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                boolean __ret;
                __ret = __is.readBool();
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    public RemoteValueInfo[]
    read(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "read", Ice.OperationMode.Nonmutating, __ctx, __compress);
        try {
            boolean __ok = __og.invoke();
            try {
                IceInternal.BasicStream __is = __og.is();
                if (!__ok) {
                    try {
                        __is.throwException();
                    } catch (Ice.UserException __ex) {
                        throw new Ice.UnknownUserException(__ex.ice_name());
                    }
                }
                RemoteValueInfo[] __ret;
                __ret = RmtValueInfoSeqHelper.read(__is);
                __is.readPendingObjects();
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }
}
