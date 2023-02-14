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

public interface _RemoteSetupManagerOperationsNC {
    String[] getAllSetupNames();

    boolean loadAllSetups(int index);

    boolean saveAllSetups(int index);

    boolean addSetupDftOption(String name);

    boolean addSetupOption(String name, String[] values);

    void rmSetupOption(String name, int index);

    boolean saveSetupToXML(String name);

    boolean loadFromSetup(String name, int index);

    boolean saveToSetup(String name, int index);

    int getSetupOptionNum(String name);

    RemoteParamInfo[] getSetupAllParams(String name);

    String[] getSetupOptionValues(String name, int index);

    boolean setSetupValue(String name, int optIndex, String paramName, String value);

    boolean setSetupComment(String name, String comment);

    String getSetupComment(String name);
}
