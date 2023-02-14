// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComSetup;

import com.naura.test.ice.IComRecipe.RemoteParamInfo;

public interface _RemoteSetupManagerOperations
{
    String[] getAllSetupNames(Ice.Current __current);

    boolean loadAllSetups(int index, Ice.Current __current);

    boolean saveAllSetups(int index, Ice.Current __current);

    boolean addSetupDftOption(String name, Ice.Current __current);

    boolean addSetupOption(String name, String[] values, Ice.Current __current);

    void rmSetupOption(String name, int index, Ice.Current __current);

    boolean saveSetupToXML(String name, Ice.Current __current);

    boolean loadFromSetup(String name, int index, Ice.Current __current);

    boolean saveToSetup(String name, int index, Ice.Current __current);

    int getSetupOptionNum(String name, Ice.Current __current);

    RemoteParamInfo[] getSetupAllParams(String name, Ice.Current __current);

    String[] getSetupOptionValues(String name, int index, Ice.Current __current);

    boolean setSetupValue(String name, int optIndex, String paramName, String value, Ice.Current __current);

    boolean setSetupComment(String name, String comment, Ice.Current __current);

    String getSetupComment(String name, Ice.Current __current);
}
