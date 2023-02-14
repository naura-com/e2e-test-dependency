// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComAppEntrance;

import com.naura.test.ice.IComControlObject.RemoteControlObjectPrx;
import com.naura.test.ice.IComData.RemoteBatchReaderPrx;
import com.naura.test.ice.IComData.RemoteBatchReaderPrxHelper;
import com.naura.test.ice.IComData.RemoteDataPrx;
import com.naura.test.ice.IComData.RemoteDataPrxHelper;
import com.naura.test.ice.IComDataLog.RemoteDataLogManagerPrx;
import com.naura.test.ice.IComInterlock.RemoteInterlockManagerPrx;
import com.naura.test.ice.IComInterlock.RemoteInterlockManagerPrxHelper;
import com.naura.test.ice.IComSysLog.RemoteLogFileManagerPrx;
import com.naura.test.ice.IComSysLog.RemoteLogFileManagerPrxHelper;
import com.naura.test.ice.IComAlarm.RemoteAlarmManagerPrx;
import com.naura.test.ice.IComAlarm.RemoteAlarmManagerPrxHelper;
import com.naura.test.ice.IComControlObject.RemoteControlObjectPrxHelper;
import com.naura.test.ice.IComDataLog.RemoteDataLogManagerPrxHelper;
import com.naura.test.ice.IComRecipe.RemoteRecipeUserPrx;
import com.naura.test.ice.IComRecipe.RemoteRecipeUserPrxHelper;
import com.naura.test.ice.IComSetup.RemoteSetupManagerPrx;
import com.naura.test.ice.IComSetup.RemoteSetupManagerPrxHelper;

public final class _RemoteAppEntranceDelM extends Ice._ObjectDelM implements _RemoteAppEntranceDel {
    @Override
    public void
    abortAllCtrlServices(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "abortAllCtrlServices", Ice.OperationMode.Normal, __ctx, __compress);
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
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public void
    clearDataCtrlSubs(String category, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "clearDataCtrlSubs", Ice.OperationMode.Normal, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(category);
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
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public RemoteRecipeUserPrx
    createRecipeUser(Ice.Identity id, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "createRecipeUser", Ice.OperationMode.Normal, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                id.__write(__os);
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
                RemoteRecipeUserPrx __ret;
                __ret = RemoteRecipeUserPrxHelper.__read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public void
    deleteRecipeUser(Ice.Identity id, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "deleteRecipeUser", Ice.OperationMode.Normal, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                id.__write(__os);
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
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public RemoteAlarmManagerPrx
    getAlarmManager(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getAlarmManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
                RemoteAlarmManagerPrx __ret;
                __ret = RemoteAlarmManagerPrxHelper.__read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public RemoteBatchReaderPrx
    getBatchReader(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getBatchReader", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
                RemoteBatchReaderPrx __ret;
                __ret = RemoteBatchReaderPrxHelper.__read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public RemoteCallbackManagerPrx
    getCallbackManager(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getCallbackManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
                RemoteCallbackManagerPrx __ret;
                __ret = RemoteCallbackManagerPrxHelper.__read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public RemoteControlObjectPrx
    getControlObject(String name, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getControlObject", Ice.OperationMode.Nonmutating, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(name);
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
                RemoteControlObjectPrx __ret;
                __ret = RemoteControlObjectPrxHelper.__read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public RemoteDataPrx
    getData(String name, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getData", Ice.OperationMode.Nonmutating, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(name);
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
                RemoteDataPrx __ret;
                __ret = RemoteDataPrxHelper.__read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public RemoteDataLogManagerPrx
    getDataLogManager(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getDataLogManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
                RemoteDataLogManagerPrx __ret;
                __ret = RemoteDataLogManagerPrxHelper.__read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public String
    getInfo(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getInfo", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
                String __ret;
                __ret = __is.readString();
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public RemoteInterlockManagerPrx
    getInterlockManager(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getInterlockManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
                RemoteInterlockManagerPrx __ret;
                __ret = RemoteInterlockManagerPrxHelper.__read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public RemoteLogFileManagerPrx
    getLogFileManager(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getLogFileManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
                RemoteLogFileManagerPrx __ret;
                __ret = RemoteLogFileManagerPrxHelper.__read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public String[]
    getNamespaceNodesUnder(String parent, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getNamespaceNodesUnder", Ice.OperationMode.Nonmutating, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(parent);
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
                String[] __ret;
                __ret = Ice.StringSeqHelper.read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public RemoteSetupManagerPrx
    getSetupManager(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getSetupManager", Ice.OperationMode.Nonmutating, __ctx, __compress);
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
                RemoteSetupManagerPrx __ret;
                __ret = RemoteSetupManagerPrxHelper.__read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public RemoteObjectType
    objectRTTI(String name, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "objectRTTI", Ice.OperationMode.Nonmutating, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                __os.writeString(name);
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
                RemoteObjectType __ret;
                __ret = RemoteObjectType.__read(__is);
                return __ret;
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public void
    shutdown(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "shutdown", Ice.OperationMode.Normal, __ctx, __compress);
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
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public boolean
    subCtrlState(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "subCtrlState", Ice.OperationMode.Normal, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                id.__write(__os);
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
                err.value = __is.readString();
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

    @Override
    public boolean
    subData(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "subData", Ice.OperationMode.Normal, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                id.__write(__os);
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
                err.value = __is.readString();
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

    @Override
    public void
    unsubCtrlState(Ice.Identity id, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "unsubCtrlState", Ice.OperationMode.Normal, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                id.__write(__os);
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
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }

    @Override
    public void
    unsubData(Ice.Identity id, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "unsubData", Ice.OperationMode.Normal, __ctx, __compress);
        try {
            try {
                IceInternal.BasicStream __os = __og.os();
                id.__write(__os);
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
            } catch (Ice.LocalException __ex) {
                throw new IceInternal.LocalExceptionWrapper(__ex, false);
            }
        } finally {
            __connection.reclaimOutgoing(__og);
        }
    }
}
