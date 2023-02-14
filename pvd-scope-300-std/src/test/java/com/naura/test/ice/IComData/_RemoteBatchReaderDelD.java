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

public final class _RemoteBatchReaderDelD extends Ice._ObjectDelD implements _RemoteBatchReaderDel {
    public boolean
    initialize(String[] dataNames, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "initialize", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteBatchReader __servant = null;
                try {
                    __servant = (RemoteBatchReader) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.initialize(dataNames, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    public RemoteValueInfo[]
    read(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "read", Ice.OperationMode.Nonmutating, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteBatchReader __servant = null;
                try {
                    __servant = (RemoteBatchReader) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.read(__current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }
}
