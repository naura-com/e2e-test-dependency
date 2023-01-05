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

public final class RemoteProcessRcpInfoPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteProcessRcpInfoPrx
{
    public static RemoteProcessRcpInfoPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteProcessRcpInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteProcessRcpInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteProcessRcpInfo"))
		{
		    RemoteProcessRcpInfoPrxHelper __h = new RemoteProcessRcpInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteProcessRcpInfoPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteProcessRcpInfoPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteProcessRcpInfoPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComRecipe::RemoteProcessRcpInfo", __ctx))
		{
		    RemoteProcessRcpInfoPrxHelper __h = new RemoteProcessRcpInfoPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteProcessRcpInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteProcessRcpInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteProcessRcpInfo"))
		{
		    RemoteProcessRcpInfoPrxHelper __h = new RemoteProcessRcpInfoPrxHelper();
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

    public static RemoteProcessRcpInfoPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteProcessRcpInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComRecipe::RemoteProcessRcpInfo", __ctx))
		{
		    RemoteProcessRcpInfoPrxHelper __h = new RemoteProcessRcpInfoPrxHelper();
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

    public static RemoteProcessRcpInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteProcessRcpInfoPrx __d = null;
	if(__obj != null)
	{
	    RemoteProcessRcpInfoPrxHelper __h = new RemoteProcessRcpInfoPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteProcessRcpInfoPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteProcessRcpInfoPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteProcessRcpInfoPrxHelper __h = new RemoteProcessRcpInfoPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteProcessRcpInfoDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteProcessRcpInfoDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteProcessRcpInfoPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteProcessRcpInfoPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteProcessRcpInfoPrxHelper result = new RemoteProcessRcpInfoPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
