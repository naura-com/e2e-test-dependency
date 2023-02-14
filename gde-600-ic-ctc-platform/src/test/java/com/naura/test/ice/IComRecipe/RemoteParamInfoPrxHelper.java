// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComRecipe;

public final class RemoteParamInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteParamInfoPrx
{
    public static RemoteParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteParamInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteParamInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteParamInfo"))
		{
		    RemoteParamInfoPrxHelper __h = new RemoteParamInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteParamInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteParamInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteParamInfo", __ctx))
		{
		    RemoteParamInfoPrxHelper __h = new RemoteParamInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteParamInfo"))
		{
		    RemoteParamInfoPrxHelper __h = new RemoteParamInfoPrxHelper();
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

    public static RemoteParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteParamInfo", __ctx))
		{
		    RemoteParamInfoPrxHelper __h = new RemoteParamInfoPrxHelper();
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

    public static RemoteParamInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteParamInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteParamInfoPrxHelper __h = new RemoteParamInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteParamInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteParamInfoPrxHelper __h = new RemoteParamInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteParamInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteParamInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteParamInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteParamInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteParamInfoPrxHelper result = new RemoteParamInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
