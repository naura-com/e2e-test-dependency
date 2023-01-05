// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComData;

public final class RemoteDataPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteDataPrx
{
    public RemoteDataInfo
    getInfo()
    {
	return getInfo(__defaultContext());
    }

    public RemoteDataInfo
    getInfo(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getInfo");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteDataDel __del = (_RemoteDataDel)__delBase;
		return __del.getInfo(__ctx);
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

    public RemoteValueInfo
    getValue()
    {
	return getValue(__defaultContext());
    }

    public RemoteValueInfo
    getValue(java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("getValue");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteDataDel __del = (_RemoteDataDel)__delBase;
		return __del.getValue(__ctx);
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
    setValue(String value, Ice.StringHolder err)
    {
	return setValue(value, err, __defaultContext());
    }

    public boolean
    setValue(String value, Ice.StringHolder err, java.util.Map __ctx)
    {
	int __cnt = 0;
	while(true)
	{
	    try
	    {
		__checkTwowayOnly("setValue");
		Ice._ObjectDel __delBase = __getDelegate();
		_RemoteDataDel __del = (_RemoteDataDel)__delBase;
		return __del.setValue(value, err, __ctx);
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
    setValue_async(AMI_RemoteData_setValue __cb, String value)
    {
	setValue_async(__cb, value, __defaultContext());
    }

    public void
    setValue_async(AMI_RemoteData_setValue __cb, String value, java.util.Map __ctx)
    {
	__cb.__invoke(this, __cb, value, __ctx);
    }

    public static RemoteDataPrx
    checkedCast(Ice.ObjectPrx __obj)
    {
	RemoteDataPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteDataPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteData"))
		{
		    RemoteDataPrxHelper __h = new RemoteDataPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteDataPrx
    checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx)
    {
	RemoteDataPrx __d = null;
	if(__obj != null)
	{
	    try
	    {
		__d = (RemoteDataPrx)__obj;
	    }
	    catch(ClassCastException ex)
	    {
		if(__obj.ice_isA("::IComData::RemoteData", __ctx))
		{
		    RemoteDataPrxHelper __h = new RemoteDataPrxHelper();
		    __h.__copyFrom(__obj);
		    __d = __h;
		}
	    }
	}
	return __d;
    }

    public static RemoteDataPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteDataPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteData"))
		{
		    RemoteDataPrxHelper __h = new RemoteDataPrxHelper();
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

    public static RemoteDataPrx
    checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx)
    {
	RemoteDataPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    try
	    {
		if(__bb.ice_isA("::IComData::RemoteData", __ctx))
		{
		    RemoteDataPrxHelper __h = new RemoteDataPrxHelper();
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

    public static RemoteDataPrx
    uncheckedCast(Ice.ObjectPrx __obj)
    {
	RemoteDataPrx __d = null;
	if(__obj != null)
	{
	    RemoteDataPrxHelper __h = new RemoteDataPrxHelper();
	    __h.__copyFrom(__obj);
	    __d = __h;
	}
	return __d;
    }

    public static RemoteDataPrx
    uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
	RemoteDataPrx __d = null;
	if(__obj != null)
	{
	    Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
	    RemoteDataPrxHelper __h = new RemoteDataPrxHelper();
	    __h.__copyFrom(__bb);
	    __d = __h;
	}
	return __d;
    }

    protected Ice._ObjectDelM
    __createDelegateM()
    {
	return new _RemoteDataDelM();
    }

    protected Ice._ObjectDelD
    __createDelegateD()
    {
	return new _RemoteDataDelD();
    }

    public static void
    __write(IceInternal.BasicStream __os, RemoteDataPrx v)
    {
	__os.writeProxy(v);
    }

    public static RemoteDataPrx
    __read(IceInternal.BasicStream __is)
    {
	Ice.ObjectPrx proxy = __is.readProxy();
	if(proxy != null)
	{
	    RemoteDataPrxHelper result = new RemoteDataPrxHelper();
	    result.__copyFrom(proxy);
	    return result;
	}
	return null;
    }
}
