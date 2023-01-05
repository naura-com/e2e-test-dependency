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

public final class RemoteDoubleParamInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteDoubleParamInfoPrx
{
    public static RemoteDoubleParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteDoubleParamInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteDoubleParamInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteDoubleParamInfo"))
		{
		    RemoteDoubleParamInfoPrxHelper __h = new RemoteDoubleParamInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteDoubleParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteDoubleParamInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteDoubleParamInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteDoubleParamInfo", __ctx))
		{
		    RemoteDoubleParamInfoPrxHelper __h = new RemoteDoubleParamInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteDoubleParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteDoubleParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteDoubleParamInfo"))
		{
		    RemoteDoubleParamInfoPrxHelper __h = new RemoteDoubleParamInfoPrxHelper();
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

    public static RemoteDoubleParamInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteDoubleParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteDoubleParamInfo", __ctx))
		{
		    RemoteDoubleParamInfoPrxHelper __h = new RemoteDoubleParamInfoPrxHelper();
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

    public static RemoteDoubleParamInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteDoubleParamInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteDoubleParamInfoPrxHelper __h = new RemoteDoubleParamInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteDoubleParamInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteDoubleParamInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteDoubleParamInfoPrxHelper __h = new RemoteDoubleParamInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteDoubleParamInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteDoubleParamInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteDoubleParamInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteDoubleParamInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteDoubleParamInfoPrxHelper result = new RemoteDoubleParamInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
