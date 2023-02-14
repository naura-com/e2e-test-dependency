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

public interface RemoteSetupManagerPrx extends Ice.ObjectPrx
{
    public String[] getAllSetupNames();
    public String[] getAllSetupNames(java.util.Map __ctx);

    public boolean loadAllSetups(int index);
    public boolean loadAllSetups(int index, java.util.Map __ctx);

    public boolean saveAllSetups(int index);
    public boolean saveAllSetups(int index, java.util.Map __ctx);

    public boolean addSetupDftOption(String name);
    public boolean addSetupDftOption(String name, java.util.Map __ctx);

    public boolean addSetupOption(String name, String[] values);
    public boolean addSetupOption(String name, String[] values, java.util.Map __ctx);

    public void rmSetupOption(String name, int index);
    public void rmSetupOption(String name, int index, java.util.Map __ctx);

    public boolean saveSetupToXML(String name);
    public boolean saveSetupToXML(String name, java.util.Map __ctx);

    public boolean loadFromSetup(String name, int index);
    public boolean loadFromSetup(String name, int index, java.util.Map __ctx);

    public boolean saveToSetup(String name, int index);
    public boolean saveToSetup(String name, int index, java.util.Map __ctx);

    public int getSetupOptionNum(String name);
    public int getSetupOptionNum(String name, java.util.Map __ctx);

    public RemoteParamInfo[] getSetupAllParams(String name);
    public RemoteParamInfo[] getSetupAllParams(String name, java.util.Map __ctx);

    public String[] getSetupOptionValues(String name, int index);
    public String[] getSetupOptionValues(String name, int index, java.util.Map __ctx);

    public boolean setSetupValue(String name, int optIndex, String paramName, String value);
    public boolean setSetupValue(String name, int optIndex, String paramName, String value, java.util.Map __ctx);

    public boolean setSetupComment(String name, String comment);
    public boolean setSetupComment(String name, String comment, java.util.Map __ctx);

    public String getSetupComment(String name);
    public String getSetupComment(String name, java.util.Map __ctx);
}
