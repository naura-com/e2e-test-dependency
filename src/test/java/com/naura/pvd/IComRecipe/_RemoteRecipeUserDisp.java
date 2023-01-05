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

public abstract class _RemoteRecipeUserDisp extends Ice.ObjectImpl implements RemoteRecipeUser
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
	throws CloneNotSupportedException
    {
	throw new CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
	"::IComRecipe::RemoteRecipeUser",
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
    addExclRcpDeftStep(String rcpID, String name, Ice.StringHolder err)
    {
	return addExclRcpDeftStep(rcpID, name, err, null);
    }

    public final boolean
    addExclRcpStep(String rcpID, String name, String[] values, Ice.StringHolder err)
    {
	return addExclRcpStep(rcpID, name, values, err, null);
    }

    public final void
    clear()
    {
	clear(null);
    }

    public final void
    deselectRecipe(String rcpID)
    {
	deselectRecipe(rcpID, null);
    }

    public final String[]
    getAllRcpClasses()
    {
	return getAllRcpClasses(null);
    }

    public final String[]
    getAllRecipes()
    {
	return getAllRecipes(null);
    }

    public final int
    getNamespaceROLvl()
    {
	return getNamespaceROLvl(null);
    }

    public final boolean
    getRcpClassInfo(String fullName, RemoteRcpClassInfoHolder clsInfo)
    {
	return getRcpClassInfo(fullName, clsInfo, null);
    }

    public final boolean
    getRecipeInfo(String rcpID, RemoteRecipeInfoHolder rcpInfo)
    {
	return getRecipeInfo(rcpID, rcpInfo, null);
    }

    public final boolean
    registerRcpClass(String fullName, RemoteParamInfo[] params, Ice.StringHolder err)
    {
	return registerRcpClass(fullName, params, err, null);
    }

    public final boolean
    registerRecipe(RemoteRecipeInfo rcpInfo, Ice.StringHolder err)
    {
	return registerRecipe(rcpInfo, err, null);
    }

    public final boolean
    releaseExclRcp(String rcpID, Ice.StringHolder err)
    {
	return releaseExclRcp(rcpID, err, null);
    }

    public final boolean
    removeExclRcpStep(String rcpID, int index, Ice.StringHolder err)
    {
	return removeExclRcpStep(rcpID, index, err, null);
    }

    public final boolean
    removeRcpClass(String fullName, Ice.StringHolder err)
    {
	return removeRcpClass(fullName, err, null);
    }

    public final boolean
    removeRecipe(String rcpID, Ice.StringHolder err)
    {
	return removeRecipe(rcpID, err, null);
    }

    public final boolean
    retrieveExclRcp(String rcpID, Ice.StringHolder err)
    {
	return retrieveExclRcp(rcpID, err, null);
    }

    public final boolean
    selectRecipe(String rcpID, Ice.StringHolder err)
    {
	return selectRecipe(rcpID, err, null);
    }

    public final boolean
    setExclRcpComments(String rcpID, String comments, Ice.StringHolder err)
    {
	return setExclRcpComments(rcpID, comments, err, null);
    }

    public final boolean
    setExclRcpEditor(String rcpID, String editor, Ice.StringHolder err)
    {
	return setExclRcpEditor(rcpID, editor, err, null);
    }

    public final boolean
    setExclRcpStepName(String rcpID, int index, String name, Ice.StringHolder err)
    {
	return setExclRcpStepName(rcpID, index, name, err, null);
    }

    public final boolean
    setExclRcpStepValue(String rcpID, int stepIndex, String paramName, String value, Ice.StringHolder err)
    {
	return setExclRcpStepValue(rcpID, stepIndex, paramName, value, err, null);
    }

    public final boolean
    setRcpApprovalLvl(String rcpID, int level, Ice.StringHolder err)
    {
	return setRcpApprovalLvl(rcpID, level, err, null);
    }

    public final boolean
    setRcpComments(String rcpID, String comments, Ice.StringHolder err)
    {
	return setRcpComments(rcpID, comments, err, null);
    }

    public final boolean
    setRcpEditor(String rcpID, String editor, Ice.StringHolder err)
    {
	return setRcpEditor(rcpID, editor, err, null);
    }

    public final boolean
    storeExclRcp(String rcpID, boolean ow, Ice.StringHolder err)
    {
	return storeExclRcp(rcpID, ow, err, null);
    }

    public final boolean
    storeRcpBody(String rcpID, RemoteRcpBodyInfo body, boolean ow, Ice.StringHolder err)
    {
	return storeRcpBody(rcpID, body, ow, err, null);
    }

    public final boolean
    subscribe()
    {
	return subscribe(null);
    }

    public final void
    unsubscribe()
    {
	unsubscribe(null);
    }

    public static IceInternal.DispatchStatus
    ___getAllRecipes(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	String[] __ret = __obj.getAllRecipes(__current);
	Ice.StringSeqHelper.write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getAllRcpClasses(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	String[] __ret = __obj.getAllRcpClasses(__current);
	Ice.StringSeqHelper.write(__os, __ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getRecipeInfo(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	RemoteRecipeInfoHolder rcpInfo = new RemoteRecipeInfoHolder();
	boolean __ret = __obj.getRecipeInfo(rcpID, rcpInfo, __current);
	rcpInfo.value.__write(__os);
	__os.writeBool(__ret);
	__os.writePendingObjects();
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getRcpClassInfo(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String fullName;
	fullName = __is.readString();
	RemoteRcpClassInfoHolder clsInfo = new RemoteRcpClassInfoHolder();
	boolean __ret = __obj.getRcpClassInfo(fullName, clsInfo, __current);
	clsInfo.value.__write(__os);
	__os.writeBool(__ret);
	__os.writePendingObjects();
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___registerRcpClass(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String fullName;
	fullName = __is.readString();
	RemoteParamInfo[] params;
	params = RemoteParamInfoSeqHelper.read(__is);
	__is.readPendingObjects();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.registerRcpClass(fullName, params, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___removeRcpClass(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String fullName;
	fullName = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.removeRcpClass(fullName, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___registerRecipe(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	RemoteRecipeInfo rcpInfo;
	rcpInfo = new RemoteRecipeInfo();
	rcpInfo.__read(__is);
	__is.readPendingObjects();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.registerRecipe(rcpInfo, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___removeRecipe(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.removeRecipe(rcpID, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___storeRcpBody(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	RemoteRcpBodyInfoHolder body = new RemoteRcpBodyInfoHolder();
	__is.readObject(body.getPatcher());
	boolean ow;
	ow = __is.readBool();
	__is.readPendingObjects();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.storeRcpBody(rcpID, body.value, ow, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___setRcpApprovalLvl(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	int level;
	level = __is.readInt();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.setRcpApprovalLvl(rcpID, level, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___setRcpEditor(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	String editor;
	editor = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.setRcpEditor(rcpID, editor, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___setRcpComments(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	String comments;
	comments = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.setRcpComments(rcpID, comments, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___getNamespaceROLvl(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Nonmutating, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	int __ret = __obj.getNamespaceROLvl(__current);
	__os.writeInt(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___subscribe(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __os = __inS.os();
	boolean __ret = __obj.subscribe(__current);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___unsubscribe(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	__obj.unsubscribe(__current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___retrieveExclRcp(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.retrieveExclRcp(rcpID, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___addExclRcpDeftStep(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	String name;
	name = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.addExclRcpDeftStep(rcpID, name, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___addExclRcpStep(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	String name;
	name = __is.readString();
	String[] values;
	values = Ice.StringSeqHelper.read(__is);
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.addExclRcpStep(rcpID, name, values, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___removeExclRcpStep(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	int index;
	index = __is.readInt();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.removeExclRcpStep(rcpID, index, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___setExclRcpStepValue(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	int stepIndex;
	stepIndex = __is.readInt();
	String paramName;
	paramName = __is.readString();
	String value;
	value = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.setExclRcpStepValue(rcpID, stepIndex, paramName, value, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___setExclRcpStepName(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	int index;
	index = __is.readInt();
	String name;
	name = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.setExclRcpStepName(rcpID, index, name, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___setExclRcpEditor(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	String editor;
	editor = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.setExclRcpEditor(rcpID, editor, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___setExclRcpComments(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	String comments;
	comments = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.setExclRcpComments(rcpID, comments, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___storeExclRcp(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	boolean ow;
	ow = __is.readBool();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.storeExclRcp(rcpID, ow, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___releaseExclRcp(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.releaseExclRcp(rcpID, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___clear(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	__obj.clear(__current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___selectRecipe(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	IceInternal.BasicStream __os = __inS.os();
	String rcpID;
	rcpID = __is.readString();
	Ice.StringHolder err = new Ice.StringHolder();
	boolean __ret = __obj.selectRecipe(rcpID, err, __current);
	__os.writeString(err.value);
	__os.writeBool(__ret);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    public static IceInternal.DispatchStatus
    ___deselectRecipe(RemoteRecipeUser __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
	__checkMode(Ice.OperationMode.Normal, __current.mode);
	IceInternal.BasicStream __is = __inS.is();
	String rcpID;
	rcpID = __is.readString();
	__obj.deselectRecipe(rcpID, __current);
	return IceInternal.DispatchStatus.DispatchOK;
    }

    private final static String[] __all =
    {
	"addExclRcpDeftStep",
	"addExclRcpStep",
	"clear",
	"deselectRecipe",
	"getAllRcpClasses",
	"getAllRecipes",
	"getNamespaceROLvl",
	"getRcpClassInfo",
	"getRecipeInfo",
	"ice_id",
	"ice_ids",
	"ice_isA",
	"ice_ping",
	"registerRcpClass",
	"registerRecipe",
	"releaseExclRcp",
	"removeExclRcpStep",
	"removeRcpClass",
	"removeRecipe",
	"retrieveExclRcp",
	"selectRecipe",
	"setExclRcpComments",
	"setExclRcpEditor",
	"setExclRcpStepName",
	"setExclRcpStepValue",
	"setRcpApprovalLvl",
	"setRcpComments",
	"setRcpEditor",
	"storeExclRcp",
	"storeRcpBody",
	"subscribe",
	"unsubscribe"
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
		return ___addExclRcpDeftStep(this, in, __current);
	    }
	    case 1:
	    {
		return ___addExclRcpStep(this, in, __current);
	    }
	    case 2:
	    {
		return ___clear(this, in, __current);
	    }
	    case 3:
	    {
		return ___deselectRecipe(this, in, __current);
	    }
	    case 4:
	    {
		return ___getAllRcpClasses(this, in, __current);
	    }
	    case 5:
	    {
		return ___getAllRecipes(this, in, __current);
	    }
	    case 6:
	    {
		return ___getNamespaceROLvl(this, in, __current);
	    }
	    case 7:
	    {
		return ___getRcpClassInfo(this, in, __current);
	    }
	    case 8:
	    {
		return ___getRecipeInfo(this, in, __current);
	    }
	    case 9:
	    {
		return ___ice_id(this, in, __current);
	    }
	    case 10:
	    {
		return ___ice_ids(this, in, __current);
	    }
	    case 11:
	    {
		return ___ice_isA(this, in, __current);
	    }
	    case 12:
	    {
		return ___ice_ping(this, in, __current);
	    }
	    case 13:
	    {
		return ___registerRcpClass(this, in, __current);
	    }
	    case 14:
	    {
		return ___registerRecipe(this, in, __current);
	    }
	    case 15:
	    {
		return ___releaseExclRcp(this, in, __current);
	    }
	    case 16:
	    {
		return ___removeExclRcpStep(this, in, __current);
	    }
	    case 17:
	    {
		return ___removeRcpClass(this, in, __current);
	    }
	    case 18:
	    {
		return ___removeRecipe(this, in, __current);
	    }
	    case 19:
	    {
		return ___retrieveExclRcp(this, in, __current);
	    }
	    case 20:
	    {
		return ___selectRecipe(this, in, __current);
	    }
	    case 21:
	    {
		return ___setExclRcpComments(this, in, __current);
	    }
	    case 22:
	    {
		return ___setExclRcpEditor(this, in, __current);
	    }
	    case 23:
	    {
		return ___setExclRcpStepName(this, in, __current);
	    }
	    case 24:
	    {
		return ___setExclRcpStepValue(this, in, __current);
	    }
	    case 25:
	    {
		return ___setRcpApprovalLvl(this, in, __current);
	    }
	    case 26:
	    {
		return ___setRcpComments(this, in, __current);
	    }
	    case 27:
	    {
		return ___setRcpEditor(this, in, __current);
	    }
	    case 28:
	    {
		return ___storeExclRcp(this, in, __current);
	    }
	    case 29:
	    {
		return ___storeRcpBody(this, in, __current);
	    }
	    case 30:
	    {
		return ___subscribe(this, in, __current);
	    }
	    case 31:
	    {
		return ___unsubscribe(this, in, __current);
	    }
	}

	assert(false);
	return IceInternal.DispatchStatus.DispatchOperationNotExist;
    }
}
