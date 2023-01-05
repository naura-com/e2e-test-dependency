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

public final class RemoteRcpClassInfo implements Cloneable
{
    public RemoteParamInfo[] params;

    public String[] recipes;

    public RemoteRcpClassInfo()
    {
    }

    public RemoteRcpClassInfo(RemoteParamInfo[] params, String[] recipes)
    {
	this.params = params;
	this.recipes = recipes;
    }

    public boolean
    equals(Object rhs)
    {
	if(this == rhs)
	{
	    return true;
	}
	RemoteRcpClassInfo _r = null;
	try
	{
	    _r = (RemoteRcpClassInfo)rhs;
	}
	catch(ClassCastException ex)
	{
	}

	if(_r != null)
	{
	    if(!java.util.Arrays.equals(params, _r.params))
	    {
		return false;
	    }
	    if(!java.util.Arrays.equals(recipes, _r.recipes))
	    {
		return false;
	    }

	    return true;
	}

	return false;
    }

    public int
    hashCode()
    {
	int __h = 0;
	if(params != null)
	{
	    for(int __i0 = 0; __i0 < params.length; __i0++)
	    {
		if(params[__i0] != null)
		{
		    __h = 5 * __h + params[__i0].hashCode();
		}
	    }
	}
	if(recipes != null)
	{
	    for(int __i1 = 0; __i1 < recipes.length; __i1++)
	    {
		if(recipes[__i1] != null)
		{
		    __h = 5 * __h + recipes[__i1].hashCode();
		}
	    }
	}
	return __h;
    }

    public Object
    clone()
    {
	Object o = null;
	try
	{
	    o = super.clone();
	}
	catch(CloneNotSupportedException ex)
	{
	    assert false; // impossible
	}
	return o;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
	RemoteParamInfoSeqHelper.write(__os, params);
	Ice.StringSeqHelper.write(__os, recipes);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
	params = RemoteParamInfoSeqHelper.read(__is);
	recipes = Ice.StringSeqHelper.read(__is);
    }
}
