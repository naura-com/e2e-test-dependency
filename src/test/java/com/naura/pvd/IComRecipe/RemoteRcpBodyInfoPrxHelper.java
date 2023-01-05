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

public final class RemoteRcpBodyInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteRcpBodyInfoPrx
{
    public static RemoteRcpBodyInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteRcpBodyInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteRcpBodyInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteRcpBodyInfo"))
		{
		    RemoteRcpBodyInfoPrxHelper __h = new RemoteRcpBodyInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteRcpBodyInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteRcpBodyInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteRcpBodyInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteRcpBodyInfo", __ctx))
		{
		    RemoteRcpBodyInfoPrxHelper __h = new RemoteRcpBodyInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteRcpBodyInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteRcpBodyInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteRcpBodyInfo"))
		{
		    RemoteRcpBodyInfoPrxHelper __h = new RemoteRcpBodyInfoPrxHelper();
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

    public static RemoteRcpBodyInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteRcpBodyInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteRcpBodyInfo", __ctx))
		{
		    RemoteRcpBodyInfoPrxHelper __h = new RemoteRcpBodyInfoPrxHelper();
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

    public static RemoteRcpBodyInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteRcpBodyInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteRcpBodyInfoPrxHelper __h = new RemoteRcpBodyInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteRcpBodyInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteRcpBodyInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteRcpBodyInfoPrxHelper __h = new RemoteRcpBodyInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteRcpBodyInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteRcpBodyInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteRcpBodyInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteRcpBodyInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteRcpBodyInfoPrxHelper result = new RemoteRcpBodyInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
