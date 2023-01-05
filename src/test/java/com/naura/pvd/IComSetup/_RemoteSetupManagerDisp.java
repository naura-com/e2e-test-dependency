// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.pvd.IComSetup;

public abstract class _RemoteSetupManagerDisp extends Ice.ObjectImpl implements RemoteSetupManager
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
	throws CloneNotSupportedException
    {
	throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
	"::IComSetup::RemoteSetupManager",
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

    public final boolean
    addSetupDftOption(String name)
    {
	return addSetupDftOption(name, null);
    }

    public final boolean
    addSetupOption(String name, String[] values)
    {
	return addSetupOption(name, values, null);
    }

    public final String[]
    getAllSetupNames()
    {
	return getAllSetupNames(null);
    }

    public final com.naura.pvd.IComRecipe.RemoteParamInfo[]
    getSetupAllParams(String name)
    {
	return getSetupAllParams(name, null);
    }

    public final String
    getSetupComment(String name)
    {
	return getSetupComment(name, null);
    }

    public final int
    getSetupOptionNum(String name)
    {
	return getSetupOptionNum(name, null);
    }

    public final String[]
    getSetupOptionValues(String name, int index)
    {
	return getSetupOptionValues(name, index, null);
    }

    public final boolean
    loadAllSetups(int index)
    {
	return loadAllSetups(index, null);
    }

    public final boolean
    loadFromSetup(String name, int index)
    {
	return loadFromSetup(name, index, null);
    }

    public final void
    rmSetupOption(String name, int index)
    {
	rmSetupOption(name, index, null);
    }

    public final boolean
    saveAllSetups(int index)
    {
	return saveAllSetups(index, null);
    }

    public final boolean
    saveSetupToXML(String name)
    {
	return saveSetupToXML(name, null);
    }

    public final boolean
    saveToSetup(String name, int index)
    {
	return saveToSetup(name, index, null);
    }

    public final boolean
    setSetupComment(String name, String comment)
    {
	return setSetupComment(name, comment, null);
    }

    public final boolean
    setSetupValue(String name, int optIndex, String paramName, String value)
    {
	return setSetupValue(name, optIndex, paramName, value, null);
    }

    public static IceInternal.DispatchStatus
    ___getAllSetupNames(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	String[] __ret = __obj.getAllSetupNames(__current);
	Ice.StringSeqHelper.write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___loadAllSetups(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	int index;
	index = __is.readInt();
	boolean __ret = __obj.loadAllSetups(index, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___saveAllSetups(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	int index;
	index = __is.readInt();
	boolean __ret = __obj.saveAllSetups(index, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___addSetupDftOption(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	boolean __ret = __obj.addSetupDftOption(name, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___addSetupOption(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	String[] values;
	values = Ice.StringSeqHelper.read(__is);
	boolean __ret = __obj.addSetupOption(name, values, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___rmSetupOption(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	String name;
	name = __is.readString();
	int index;
	index = __is.readInt();
	__obj.rmSetupOption(name, index, __current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___saveSetupToXML(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	boolean __ret = __obj.saveSetupToXML(name, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___loadFromSetup(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	int index;
	index = __is.readInt();
	boolean __ret = __obj.loadFromSetup(name, index, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___saveToSetup(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	int index;
	index = __is.readInt();
	boolean __ret = __obj.saveToSetup(name, index, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getSetupOptionNum(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	int __ret = __obj.getSetupOptionNum(name, __current);
	__os.writeInt(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getSetupAllParams(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	com.naura.pvd.IComRecipe.RemoteParamInfo[] __ret = __obj.getSetupAllParams(name, __current);
	com.naura.pvd.IComRecipe.RemoteParamInfoSeqHelper.write(__os, __ret);
	__os.writePendingObjects();
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getSetupOptionValues(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	int index;
	index = __is.readInt();
	String[] __ret = __obj.getSetupOptionValues(name, index, __current);
	Ice.StringSeqHelper.write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___setSetupValue(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	int optIndex;
	optIndex = __is.readInt();
	String paramName;
	paramName = __is.readString();
	String value;
	value = __is.readString();
	boolean __ret = __obj.setSetupValue(name, optIndex, paramName, value, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___setSetupComment(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	String comment;
	comment = __is.readString();
	boolean __ret = __obj.setSetupComment(name, comment, __current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getSetupComment(RemoteSetupManager __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String name;
	name = __is.readString();
	String __ret = __obj.getSetupComment(name, __current);
	__os.writeString(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
	"addSetupDftOption",
	"addSetupOption",
	"getAllSetupNames",
	"getSetupAllParams",
	"getSetupComment",
	"getSetupOptionNum",
	"getSetupOptionValues",
	"ice_id",
	"ice_ids",
	"ice_isA",
	"ice_ping",
	"loadAllSetups",
	"loadFromSetup",
	"rmSetupOption",
	"saveAllSetups",
	"saveSetupToXML",
	"saveToSetup",
	"setSetupComment",
	"setSetupValue"
    };

    public IceInternal.DispatchStatus
    __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
	int pos = java.util.Arrays.binarySearch(__all, __current.operation);
	if(pos < 0)
	{
	    return IceInternal.DispatchStatus.DispatchOperationNotExist;
	}

	switch(pos)
	{
	    case 0:
	    {
		return ___addSetupDftOption(this, in, __current);
	    }
	    case 1:
	    {
		return ___addSetupOption(this, in, __current);
	    }
	    case 2:
	    {
		return ___getAllSetupNames(this, in, __current);
	    }
	    case 3:
	    {
		return ___getSetupAllParams(this, in, __current);
	    }
	    case 4:
	    {
		return ___getSetupComment(this, in, __current);
	    }
	    case 5:
	    {
		return ___getSetupOptionNum(this, in, __current);
	    }
	    case 6:
	    {
		return ___getSetupOptionValues(this, in, __current);
	    }
	    case 7:
	    {
		return ___ice_id(this, in, __current);
	    }
	    case 8:
	    {
		return ___ice_ids(this, in, __current);
	    }
	    case 9:
	    {
		return ___ice_isA(this, in, __current);
	    }
	    case 10:
	    {
		return ___ice_ping(this, in, __current);
	    }
	    case 11:
	    {
		return ___loadAllSetups(this, in, __current);
	    }
	    case 12:
	    {
		return ___loadFromSetup(this, in, __current);
	    }
	    case 13:
	    {
		return ___rmSetupOption(this, in, __current);
	    }
	    case 14:
	    {
		return ___saveAllSetups(this, in, __current);
	    }
	    case 15:
	    {
		return ___saveSetupToXML(this, in, __current);
	    }
	    case 16:
	    {
		return ___saveToSetup(this, in, __current);
	    }
	    case 17:
	    {
		return ___setSetupComment(this, in, __current);
	    }
	    case 18:
	    {
		return ___setSetupValue(this, in, __current);
	    }
	}

	assert(false);
	return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
