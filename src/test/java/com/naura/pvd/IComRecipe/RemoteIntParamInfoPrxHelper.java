// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComRecipe;

public final class RemoteIntParamInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteIntParamInfoPrx
{
    public static RemoteIntParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteIntParamInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteIntParamInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteIntParamInfo"))
		{
		    RemoteIntParamInfoPrxHelper __h = new RemoteIntParamInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteIntParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteIntParamInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteIntParamInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteIntParamInfo", __ctx))
		{
		    RemoteIntParamInfoPrxHelper __h = new RemoteIntParamInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteIntParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteIntParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteIntParamInfo"))
		{
		    RemoteIntParamInfoPrxHelper __h = new RemoteIntParamInfoPrxHelper();
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

    public static RemoteIntParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteIntParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteIntParamInfo", __ctx))
		{
		    RemoteIntParamInfoPrxHelper __h = new RemoteIntParamInfoPrxHelper();
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

    public static RemoteIntParamInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteIntParamInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteIntParamInfoPrxHelper __h = new RemoteIntParamInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteIntParamInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteIntParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteIntParamInfoPrxHelper __h = new RemoteIntParamInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteIntParamInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteIntParamInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteIntParamInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteIntParamInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteIntParamInfoPrxHelper result = new RemoteIntParamInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
