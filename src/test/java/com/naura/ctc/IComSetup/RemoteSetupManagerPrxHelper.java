// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComSetup;

import com.naura.ctc.IComRecipe.RemoteParamInfo;

public final class RemoteSetupManagerPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteSetupManagerPrx
{
    public boolean
    addSetupDftOption(String name)
    {
	return addSetupDftOption(name, __defaultContext());
    }

    public boolean
    addSetupDftOption(String name, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("addSetupDftOption");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.addSetupDftOption(name, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public boolean
    addSetupOption(String name, String[] values)
    {
	return addSetupOption(name, values, __defaultContext());
    }

    public boolean
    addSetupOption(String name, String[] values, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("addSetupOption");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.addSetupOption(name, values, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public String[]
    getAllSetupNames()
    {
	return getAllSetupNames(__defaultContext());
    }

    public String[]
    getAllSetupNames(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getAllSetupNames");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.getAllSetupNames(__ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public RemoteParamInfo[]
    getSetupAllParams(String name)
    {
	return getSetupAllParams(name, __defaultContext());
    }

    public RemoteParamInfo[]
    getSetupAllParams(String name, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getSetupAllParams");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.getSetupAllParams(name, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public String
    getSetupComment(String name)
    {
	return getSetupComment(name, __defaultContext());
    }

    public String
    getSetupComment(String name, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getSetupComment");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.getSetupComment(name, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public int
    getSetupOptionNum(String name)
    {
	return getSetupOptionNum(name, __defaultContext());
    }

    public int
    getSetupOptionNum(String name, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getSetupOptionNum");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.getSetupOptionNum(name, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public String[]
    getSetupOptionValues(String name, int index)
    {
	return getSetupOptionValues(name, index, __defaultContext());
    }

    public String[]
    getSetupOptionValues(String name, int index, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getSetupOptionValues");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.getSetupOptionValues(name, index, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public boolean
    loadAllSetups(int index)
    {
	return loadAllSetups(index, __defaultContext());
    }

    public boolean
    loadAllSetups(int index, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("loadAllSetups");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.loadAllSetups(index, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public boolean
    loadFromSetup(String name, int index)
    {
	return loadFromSetup(name, index, __defaultContext());
    }

    public boolean
    loadFromSetup(String name, int index, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("loadFromSetup");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.loadFromSetup(name, index, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public void
    rmSetupOption(String name, int index)
    {
	rmSetupOption(name, index, __defaultContext());
    }

    public void
    rmSetupOption(String name, int index, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		__del.rmSetupOption(name, index, __ctx);
		return;
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public boolean
    saveAllSetups(int index)
    {
	return saveAllSetups(index, __defaultContext());
    }

    public boolean
    saveAllSetups(int index, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("saveAllSetups");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.saveAllSetups(index, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public boolean
    saveSetupToXML(String name)
    {
	return saveSetupToXML(name, __defaultContext());
    }

    public boolean
    saveSetupToXML(String name, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("saveSetupToXML");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.saveSetupToXML(name, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public boolean
    saveToSetup(String name, int index)
    {
	return saveToSetup(name, index, __defaultContext());
    }

    public boolean
    saveToSetup(String name, int index, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("saveToSetup");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.saveToSetup(name, index, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public boolean
    setSetupComment(String name, String comment)
    {
	return setSetupComment(name, comment, __defaultContext());
    }

    public boolean
    setSetupComment(String name, String comment, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("setSetupComment");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.setSetupComment(name, comment, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public boolean
    setSetupValue(String name, int optIndex, String paramName, String value)
    {
	return setSetupValue(name, optIndex, paramName, value, __defaultContext());
    }

    public boolean
    setSetupValue(String name, int optIndex, String paramName, String value, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("setSetupValue");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteSetupManagerDel __del = (_RemoteSetupManagerDel)__delBase;
		return __del.setSetupValue(name, optIndex, paramName, value, __ctx);
	    }
	    catch(IceInternal.LocalExceptionWrapper __ex)
	    {
		__handleExceptionWrapper(__ex);
	    }
	    catch(Ice.LocalException __ex)
	    {
		__cnt = __handleException(__ex, __cnt);
	    }
	}
    }

    public static RemoteSetupManagerPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteSetupManagerPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteSetupManagerPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComSetup::RemoteSetupManager"))
		{
		    RemoteSetupManagerPrxHelper __h = new RemoteSetupManagerPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteSetupManagerPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteSetupManagerPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteSetupManagerPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComSetup::RemoteSetupManager", __ctx))
		{
		    RemoteSetupManagerPrxHelper __h = new RemoteSetupManagerPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteSetupManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteSetupManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComSetup::RemoteSetupManager"))
		{
		    RemoteSetupManagerPrxHelper __h = new RemoteSetupManagerPrxHelper();
		    __h.__copyFrom(__bb);
		    __d = __h;
		}
	    }
	    catch(Ice.FacetNotExistException ex)
	    {
	    }
	}
	return __d;
    }

    public static RemoteSetupManagerPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteSetupManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComSetup::RemoteSetupManager", __ctx))
		{
		    RemoteSetupManagerPrxHelper __h = new RemoteSetupManagerPrxHelper();
		    __h.__copyFrom(__bb);
		    __d = __h;
		}
	    }
	    catch(Ice.FacetNotExistException ex)
	    {
	    }
	}
	return __d;
    }

    public static RemoteSetupManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteSetupManagerPrx __d = null;
	if(__obj != null)
	{
	    RemoteSetupManagerPrxHelper __h = new RemoteSetupManagerPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteSetupManagerPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteSetupManagerPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteSetupManagerPrxHelper __h = new RemoteSetupManagerPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteSetupManagerDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteSetupManagerDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteSetupManagerPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteSetupManagerPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteSetupManagerPrxHelper result = new RemoteSetupManagerPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
