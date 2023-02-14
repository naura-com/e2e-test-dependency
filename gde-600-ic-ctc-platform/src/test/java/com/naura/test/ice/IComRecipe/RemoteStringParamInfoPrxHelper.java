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

public final class RemoteStringParamInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteStringParamInfoPrx
{
    public static RemoteStringParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteStringParamInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteStringParamInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteStringParamInfo"))
		{
		    RemoteStringParamInfoPrxHelper __h = new RemoteStringParamInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteStringParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteStringParamInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteStringParamInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteStringParamInfo", __ctx))
		{
		    RemoteStringParamInfoPrxHelper __h = new RemoteStringParamInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteStringParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteStringParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteStringParamInfo"))
		{
		    RemoteStringParamInfoPrxHelper __h = new RemoteStringParamInfoPrxHelper();
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

    public static RemoteStringParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteStringParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteStringParamInfo", __ctx))
		{
		    RemoteStringParamInfoPrxHelper __h = new RemoteStringParamInfoPrxHelper();
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

    public static RemoteStringParamInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteStringParamInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteStringParamInfoPrxHelper __h = new RemoteStringParamInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteStringParamInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteStringParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteStringParamInfoPrxHelper __h = new RemoteStringParamInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteStringParamInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteStringParamInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteStringParamInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteStringParamInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteStringParamInfoPrxHelper result = new RemoteStringParamInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
