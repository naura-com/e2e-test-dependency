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

public final class _RemoteInterlockManagerDelD extends Ice._ObjectDelD implements _RemoteInterlockManagerDel {
    public boolean
    activate(String id, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "activate", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteInterlockManager __servant = null;
                try {
                    __servant = (RemoteInterlockManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.activate(id, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    public boolean
    deactivate(String id, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "deactivate", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteInterlockManager __servant = null;
                try {
                    __servant = (RemoteInterlockManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.deactivate(id, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    public RemoteInterlockInfo[]
    getAllInterlockInfos(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "getAllInterlockInfos", Ice.OperationMode.Nonmutating, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteInterlockManager __servant = null;
                try {
                    __servant = (RemoteInterlockManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.getAllInterlockInfos(__current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    public RemoteInterlockInfo
    getInterlockInfo(String id, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "getInterlockInfo", Ice.OperationMode.Nonmutating, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteInterlockManager __servant = null;
                try {
                    __servant = (RemoteInterlockManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.getInterlockInfo(id, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    public boolean
    isActive(String id, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "isActive", Ice.OperationMode.Nonmutating, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteInterlockManager __servant = null;
                try {
                    __servant = (RemoteInterlockManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.isActive(id, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }
}
