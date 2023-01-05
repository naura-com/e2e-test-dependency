// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.ctc.IComSetup;

import com.naura.ctc.IComRecipe.RemoteParamInfo;

public interface _RemoteSetupManagerDel extends Ice._ObjectDel
{
    String[] getAllSetupNames(java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean loadAllSetups(int index, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean saveAllSetups(int index, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean addSetupDftOption(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean addSetupOption(String name, String[] values, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    void rmSetupOption(String name, int index, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean saveSetupToXML(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean loadFromSetup(String name, int index, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean saveToSetup(String name, int index, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    int getSetupOptionNum(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    RemoteParamInfo[] getSetupAllParams(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    String[] getSetupOptionValues(String name, int index, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean setSetupValue(String name, int optIndex, String paramName, String value, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    boolean setSetupComment(String name, String comment, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;

    String getSetupComment(String name, java.util.Map __ctx)
	throws IceInternal.LocalExceptionWrapper;
}
