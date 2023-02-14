// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComSetup;

import com.naura.test.ice.IComRecipe.RemoteParamInfo;

public final class _RemoteSetupManagerDelD extends Ice._ObjectDelD implements _RemoteSetupManagerDel {
    @Override
    public boolean
    addSetupDftOption(String name, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "addSetupDftOption", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.addSetupDftOption(name, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public boolean
    addSetupOption(String name, String[] values, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "addSetupOption", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.addSetupOption(name, values, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public String[]
    getAllSetupNames(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "getAllSetupNames", Ice.OperationMode.Nonmutating, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.getAllSetupNames(__current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public RemoteParamInfo[]
    getSetupAllParams(String name, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "getSetupAllParams", Ice.OperationMode.Nonmutating, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.getSetupAllParams(name, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public String
    getSetupComment(String name, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "getSetupComment", Ice.OperationMode.Nonmutating, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.getSetupComment(name, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public int
    getSetupOptionNum(String name, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "getSetupOptionNum", Ice.OperationMode.Nonmutating, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.getSetupOptionNum(name, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public String[]
    getSetupOptionValues(String name, int index, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "getSetupOptionValues", Ice.OperationMode.Nonmutating, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.getSetupOptionValues(name, index, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public boolean
    loadAllSetups(int index, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "loadAllSetups", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.loadAllSetups(index, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public boolean
    loadFromSetup(String name, int index, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "loadFromSetup", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.loadFromSetup(name, index, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public void
    rmSetupOption(String name, int index, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "rmSetupOption", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    __servant.rmSetupOption(name, index, __current);
                    return;
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public boolean
    saveAllSetups(int index, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "saveAllSetups", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.saveAllSetups(index, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public boolean
    saveSetupToXML(String name, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "saveSetupToXML", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.saveSetupToXML(name, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public boolean
    saveToSetup(String name, int index, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "saveToSetup", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.saveToSetup(name, index, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public boolean
    setSetupComment(String name, String comment, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "setSetupComment", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.setSetupComment(name, comment, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }

    @Override
    public boolean
    setSetupValue(String name, int optIndex, String paramName, String value, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper {
        Ice.Current __current = new Ice.Current();
        __initCurrent(__current, "setSetupValue", Ice.OperationMode.Normal, __ctx);
        while (true) {
            IceInternal.Direct __direct = new IceInternal.Direct(__current);
            try {
                RemoteSetupManager __servant = null;
                try {
                    __servant = (RemoteSetupManager) __direct.servant();
                } catch (ClassCastException __ex) {
                    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
                    __opEx.id = __current.id;
                    __opEx.facet = __current.facet;
                    __opEx.operation = __current.operation;
                    throw __opEx;
                }
                try {
                    return __servant.setSetupValue(name, optIndex, paramName, value, __current);
                } catch (Ice.LocalException __ex) {
                    throw new IceInternal.LocalExceptionWrapper(__ex, false);
                }
            } finally {
                __direct.destroy();
            }
        }
    }
}
