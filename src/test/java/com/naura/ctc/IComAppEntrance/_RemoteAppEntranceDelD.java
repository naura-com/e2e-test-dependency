// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComAppEntrance;

import com.naura.ctc.IComAlarm.RemoteAlarmManagerPrx;
import com.naura.ctc.IComControlObject.RemoteControlObjectPrx;
import com.naura.ctc.IComData.RemoteBatchReaderPrx;
import com.naura.ctc.IComData.RemoteDataPrx;
import com.naura.ctc.IComDataLog.RemoteDataLogManagerPrx;
import com.naura.ctc.IComInterlock.RemoteInterlockManagerPrx;
import com.naura.ctc.IComRecipe.RemoteRecipeUserPrx;
import com.naura.ctc.IComSetup.RemoteSetupManagerPrx;
import com.naura.ctc.IComSysLog.RemoteLogFileManagerPrx;

public final class _RemoteAppEntranceDelD extends Ice._ObjectDelD implements _RemoteAppEntranceDel
{
    public void
    abortAllCtrlServices(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "abortAllCtrlServices", Ice.OperationMode.Normal, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    __servant.abortAllCtrlServices(__current);
		    return;
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public void
    clearDataCtrlSubs(String category, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "clearDataCtrlSubs", Ice.OperationMode.Normal, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    __servant.clearDataCtrlSubs(category, __current);
		    return;
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public RemoteRecipeUserPrx
    createRecipeUser(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "createRecipeUser", Ice.OperationMode.Normal, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.createRecipeUser(id, __current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public void
    deleteRecipeUser(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "deleteRecipeUser", Ice.OperationMode.Normal, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    __servant.deleteRecipeUser(id, __current);
		    return;
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public RemoteAlarmManagerPrx
    getAlarmManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "getAlarmManager", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.getAlarmManager(__current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public RemoteBatchReaderPrx
    getBatchReader(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "getBatchReader", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.getBatchReader(__current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public RemoteCallbackManagerPrx
    getCallbackManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "getCallbackManager", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.getCallbackManager(__current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public RemoteControlObjectPrx
    getControlObject(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "getControlObject", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.getControlObject(name, __current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public RemoteDataPrx
    getData(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "getData", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.getData(name, __current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public RemoteDataLogManagerPrx
    getDataLogManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "getDataLogManager", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.getDataLogManager(__current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public String
    getInfo(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "getInfo", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.getInfo(__current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public RemoteInterlockManagerPrx
    getInterlockManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "getInterlockManager", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.getInterlockManager(__current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public RemoteLogFileManagerPrx
    getLogFileManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "getLogFileManager", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.getLogFileManager(__current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public String[]
    getNamespaceNodesUnder(String parent, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "getNamespaceNodesUnder", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.getNamespaceNodesUnder(parent, __current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public RemoteSetupManagerPrx
    getSetupManager(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "getSetupManager", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.getSetupManager(__current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public RemoteObjectType
    objectRTTI(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "objectRTTI", Ice.OperationMode.Nonmutating, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.objectRTTI(name, __current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public void
    shutdown(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "shutdown", Ice.OperationMode.Normal, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    __servant.shutdown(__current);
		    return;
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public boolean
    subCtrlState(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "subCtrlState", Ice.OperationMode.Normal, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.subCtrlState(id, err, __current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public boolean
    subData(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "subData", Ice.OperationMode.Normal, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    return __servant.subData(id, err, __current);
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public void
    unsubCtrlState(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "unsubCtrlState", Ice.OperationMode.Normal, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    __servant.unsubCtrlState(id, __current);
		    return;
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }

    public void
    unsubData(Ice.Identity id, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper
    {
	Ice.Current __current = new Ice.Current();
	__initCurrent(__current, "unsubData", Ice.OperationMode.Normal, __ctx);
	while(true)
	{
	    IceInternal.Direct __direct = new IceInternal.Direct(__current);
	    try
	    {
		RemoteAppEntrance __servant = null;
		try
		{
		    __servant = (RemoteAppEntrance)__direct.servant();
		}
		catch(ClassCastException __ex)
		{
		    Ice.OperationNotExistException __opEx = new Ice.OperationNotExistException();
		    __opEx.id = __current.id;
		    __opEx.facet = __current.facet;
		    __opEx.operation = __current.operation;
		    throw __opEx;
		}
		try
		{
		    __servant.unsubData(id, __current);
		    return;
		}
		catch(Ice.LocalException __ex)
		{
		    throw new IceInternal.LocalExceptionWrapper(__ex, false);
		}
	    }
	    finally
	    {
		__direct.destroy();
	    }
	}
    }
}
