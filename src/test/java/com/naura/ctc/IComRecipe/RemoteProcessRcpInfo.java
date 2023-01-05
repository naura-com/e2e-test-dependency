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

public class RemoteProcessRcpInfo extends RemoteRcpBodyInfo
{
    public RemoteProcessRcpInfo()
    {
	super();
    }

    public RemoteProcessRcpInfo(StepInfo[] steps)
    {
	this.steps = steps;
    }

    private static class __F extends Ice.LocalObjectImpl implements Ice.ObjectFactory
    {
	public Ice.Object
	create(String type)
	{
	    assert(type.equals(ice_staticId()));
	    return new RemoteProcessRcpInfo();
	}

	public void
	destroy()
	{
	}
    }
    private static Ice.ObjectFactory _factory = new __F();

    public static Ice.ObjectFactory
    ice_factory()
    {
	return _factory;
    }

    public static final String[] __ids =
    {
	"::IComRecipe::RemoteProcessRcpInfo",
	"::IComRecipe::RemoteRcpBodyInfo",
	"::Ice::Object"
    };

    public boolean
    ice_isA(String s)
    {
	return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean
    ice_isA(String s, Ice.Current __current)
    {
	return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[]
    ice_ids()
    {
	return __ids;
    }

    public String[]
    ice_ids(Ice.Current __current)
    {
	return __ids;
    }

    public String
    ice_id()
    {
	return __ids[0];
    }

    public String
    ice_id(Ice.Current __current)
    {
	return __ids[0];
    }

    public static String
    ice_staticId()
    {
	return __ids[0];
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
	__os.writeTypeId(ice_staticId());
	__os.startWriteSlice();
	StepSeqHelper.write(__os, steps);
	__os.endWriteSlice();
	super.__write(__os);
    }

    public void
    __read(IceInternal.BasicStream __is, boolean __rid)
    {
	if(__rid)
	{
	    __is.readTypeId();
	}
	__is.startReadSlice();
	steps = StepSeqHelper.read(__is);
	__is.endReadSlice();
	super.__read(__is, true);
    }

    public void
    __write(Ice.OutputStream __outS)
    {
	Ice.MarshalException ex = new Ice.MarshalException();
	ex.reason = "type IComRecipe::RemoteProcessRcpInfo was not generated with stream support";
	throw ex;
    }

    public void
    __read(Ice.InputStream __inS, boolean __rid)
    {
	Ice.MarshalException ex = new Ice.MarshalException();
	ex.reason = "type IComRecipe::RemoteProcessRcpInfo was not generated with stream support";
	throw ex;
    }

    public StepInfo[] steps;
}
