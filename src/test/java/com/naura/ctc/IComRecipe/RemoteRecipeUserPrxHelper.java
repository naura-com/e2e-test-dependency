// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComRecipe;

public final class RemoteRecipeUserPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteRecipeUserPrx
{
    public boolean
    addExclRcpDeftStep(String rcpID, String name, Ice.StringHolder err)
    {
	return addExclRcpDeftStep(rcpID, name, err, __defaultContext());
    }

    public boolean
    addExclRcpDeftStep(String rcpID, String name, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("addExclRcpDeftStep");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.addExclRcpDeftStep(rcpID, name, err, __ctx);
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
    addExclRcpStep(String rcpID, String name, String[] values, Ice.StringHolder err)
    {
	return addExclRcpStep(rcpID, name, values, err, __defaultContext());
    }

    public boolean
    addExclRcpStep(String rcpID, String name, String[] values, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("addExclRcpStep");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.addExclRcpStep(rcpID, name, values, err, __ctx);
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
    clear()
    {
	clear(__defaultContext());
    }

    public void
    clear(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		__del.clear(__ctx);
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

    public void
    deselectRecipe(String rcpID)
    {
	deselectRecipe(rcpID, __defaultContext());
    }

    public void
    deselectRecipe(String rcpID, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		__del.deselectRecipe(rcpID, __ctx);
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

    public String[]
    getAllRcpClasses()
    {
	return getAllRcpClasses(__defaultContext());
    }

    public String[]
    getAllRcpClasses(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getAllRcpClasses");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.getAllRcpClasses(__ctx);
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
    getAllRecipes()
    {
	return getAllRecipes(__defaultContext());
    }

    public String[]
    getAllRecipes(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getAllRecipes");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.getAllRecipes(__ctx);
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
    getNamespaceROLvl()
    {
	return getNamespaceROLvl(__defaultContext());
    }

    public int
    getNamespaceROLvl(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getNamespaceROLvl");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.getNamespaceROLvl(__ctx);
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
    getRcpClassInfo(String fullName, RemoteRcpClassInfoHolder clsInfo)
    {
	return getRcpClassInfo(fullName, clsInfo, __defaultContext());
    }

    public boolean
    getRcpClassInfo(String fullName, RemoteRcpClassInfoHolder clsInfo, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getRcpClassInfo");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.getRcpClassInfo(fullName, clsInfo, __ctx);
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
    getRecipeInfo(String rcpID, RemoteRecipeInfoHolder rcpInfo)
    {
	return getRecipeInfo(rcpID, rcpInfo, __defaultContext());
    }

    public boolean
    getRecipeInfo(String rcpID, RemoteRecipeInfoHolder rcpInfo, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getRecipeInfo");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.getRecipeInfo(rcpID, rcpInfo, __ctx);
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
    registerRcpClass(String fullName, RemoteParamInfo[] params, Ice.StringHolder err)
    {
	return registerRcpClass(fullName, params, err, __defaultContext());
    }

    public boolean
    registerRcpClass(String fullName, RemoteParamInfo[] params, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("registerRcpClass");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.registerRcpClass(fullName, params, err, __ctx);
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
    registerRecipe(RemoteRecipeInfo rcpInfo, Ice.StringHolder err)
    {
	return registerRecipe(rcpInfo, err, __defaultContext());
    }

    public boolean
    registerRecipe(RemoteRecipeInfo rcpInfo, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("registerRecipe");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.registerRecipe(rcpInfo, err, __ctx);
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
    releaseExclRcp(String rcpID, Ice.StringHolder err)
    {
	return releaseExclRcp(rcpID, err, __defaultContext());
    }

    public boolean
    releaseExclRcp(String rcpID, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("releaseExclRcp");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.releaseExclRcp(rcpID, err, __ctx);
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
    removeExclRcpStep(String rcpID, int index, Ice.StringHolder err)
    {
	return removeExclRcpStep(rcpID, index, err, __defaultContext());
    }

    public boolean
    removeExclRcpStep(String rcpID, int index, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("removeExclRcpStep");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.removeExclRcpStep(rcpID, index, err, __ctx);
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
    removeRcpClass(String fullName, Ice.StringHolder err)
    {
	return removeRcpClass(fullName, err, __defaultContext());
    }

    public boolean
    removeRcpClass(String fullName, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("removeRcpClass");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.removeRcpClass(fullName, err, __ctx);
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
    removeRecipe(String rcpID, Ice.StringHolder err)
    {
	return removeRecipe(rcpID, err, __defaultContext());
    }

    public boolean
    removeRecipe(String rcpID, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("removeRecipe");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.removeRecipe(rcpID, err, __ctx);
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
    retrieveExclRcp(String rcpID, Ice.StringHolder err)
    {
	return retrieveExclRcp(rcpID, err, __defaultContext());
    }

    public boolean
    retrieveExclRcp(String rcpID, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("retrieveExclRcp");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.retrieveExclRcp(rcpID, err, __ctx);
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
    selectRecipe(String rcpID, Ice.StringHolder err)
    {
	return selectRecipe(rcpID, err, __defaultContext());
    }

    public boolean
    selectRecipe(String rcpID, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("selectRecipe");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.selectRecipe(rcpID, err, __ctx);
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
    setExclRcpComments(String rcpID, String comments, Ice.StringHolder err)
    {
	return setExclRcpComments(rcpID, comments, err, __defaultContext());
    }

    public boolean
    setExclRcpComments(String rcpID, String comments, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("setExclRcpComments");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.setExclRcpComments(rcpID, comments, err, __ctx);
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
    setExclRcpEditor(String rcpID, String editor, Ice.StringHolder err)
    {
	return setExclRcpEditor(rcpID, editor, err, __defaultContext());
    }

    public boolean
    setExclRcpEditor(String rcpID, String editor, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("setExclRcpEditor");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.setExclRcpEditor(rcpID, editor, err, __ctx);
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
    setExclRcpStepName(String rcpID, int index, String name, Ice.StringHolder err)
    {
	return setExclRcpStepName(rcpID, index, name, err, __defaultContext());
    }

    public boolean
    setExclRcpStepName(String rcpID, int index, String name, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("setExclRcpStepName");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.setExclRcpStepName(rcpID, index, name, err, __ctx);
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
    setExclRcpStepValue(String rcpID, int stepIndex, String paramName, String value, Ice.StringHolder err)
    {
	return setExclRcpStepValue(rcpID, stepIndex, paramName, value, err, __defaultContext());
    }

    public boolean
    setExclRcpStepValue(String rcpID, int stepIndex, String paramName, String value, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("setExclRcpStepValue");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.setExclRcpStepValue(rcpID, stepIndex, paramName, value, err, __ctx);
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
    setRcpApprovalLvl(String rcpID, int level, Ice.StringHolder err)
    {
	return setRcpApprovalLvl(rcpID, level, err, __defaultContext());
    }

    public boolean
    setRcpApprovalLvl(String rcpID, int level, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("setRcpApprovalLvl");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.setRcpApprovalLvl(rcpID, level, err, __ctx);
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
    setRcpComments(String rcpID, String comments, Ice.StringHolder err)
    {
	return setRcpComments(rcpID, comments, err, __defaultContext());
    }

    public boolean
    setRcpComments(String rcpID, String comments, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("setRcpComments");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.setRcpComments(rcpID, comments, err, __ctx);
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
    setRcpEditor(String rcpID, String editor, Ice.StringHolder err)
    {
	return setRcpEditor(rcpID, editor, err, __defaultContext());
    }

    public boolean
    setRcpEditor(String rcpID, String editor, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("setRcpEditor");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.setRcpEditor(rcpID, editor, err, __ctx);
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
    storeExclRcp(String rcpID, boolean ow, Ice.StringHolder err)
    {
	return storeExclRcp(rcpID, ow, err, __defaultContext());
    }

    public boolean
    storeExclRcp(String rcpID, boolean ow, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("storeExclRcp");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.storeExclRcp(rcpID, ow, err, __ctx);
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
    storeRcpBody(String rcpID, RemoteRcpBodyInfo body, boolean ow, Ice.StringHolder err)
    {
	return storeRcpBody(rcpID, body, ow, err, __defaultContext());
    }

    public boolean
    storeRcpBody(String rcpID, RemoteRcpBodyInfo body, boolean ow, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("storeRcpBody");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.storeRcpBody(rcpID, body, ow, err, __ctx);
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
    subscribe()
    {
	return subscribe(__defaultContext());
    }

    public boolean
    subscribe(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("subscribe");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		return __del.subscribe(__ctx);
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
    unsubscribe()
    {
	unsubscribe(__defaultContext());
    }

    public void
    unsubscribe(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteRecipeUserDel __del = (_RemoteRecipeUserDel)__delBase;
		__del.unsubscribe(__ctx);
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

    public static RemoteRecipeUserPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteRecipeUserPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteRecipeUserPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteRecipeUser"))
		{
		    RemoteRecipeUserPrxHelper __h = new RemoteRecipeUserPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteRecipeUserPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteRecipeUserPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteRecipeUserPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteRecipeUser", __ctx))
		{
		    RemoteRecipeUserPrxHelper __h = new RemoteRecipeUserPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteRecipeUserPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteRecipeUserPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteRecipeUser"))
		{
		    RemoteRecipeUserPrxHelper __h = new RemoteRecipeUserPrxHelper();
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

    public static RemoteRecipeUserPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteRecipeUserPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteRecipeUser", __ctx))
		{
		    RemoteRecipeUserPrxHelper __h = new RemoteRecipeUserPrxHelper();
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

    public static RemoteRecipeUserPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteRecipeUserPrx __d = null;
	if(__obj != null)
	{
	    RemoteRecipeUserPrxHelper __h = new RemoteRecipeUserPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteRecipeUserPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteRecipeUserPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteRecipeUserPrxHelper __h = new RemoteRecipeUserPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteRecipeUserDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteRecipeUserDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteRecipeUserPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteRecipeUserPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteRecipeUserPrxHelper result = new RemoteRecipeUserPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
