// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComRecipe;

public interface RemoteRecipeUserPrx extends Ice.ObjectPrx {
    public String[] getAllRecipes();

    public String[] getAllRecipes(java.util.Map __ctx);

    public String[] getAllRcpClasses();

    public String[] getAllRcpClasses(java.util.Map __ctx);

    public boolean getRecipeInfo(String rcpID, RemoteRecipeInfoHolder rcpInfo);

    public boolean getRecipeInfo(String rcpID, RemoteRecipeInfoHolder rcpInfo, java.util.Map __ctx);

    public boolean getRcpClassInfo(String fullName, RemoteRcpClassInfoHolder clsInfo);

    public boolean getRcpClassInfo(String fullName, RemoteRcpClassInfoHolder clsInfo, java.util.Map __ctx);

    public boolean registerRcpClass(String fullName, RemoteParamInfo[] params, Ice.StringHolder err);

    public boolean registerRcpClass(String fullName, RemoteParamInfo[] params, Ice.StringHolder err, java.util.Map __ctx);

    public boolean removeRcpClass(String fullName, Ice.StringHolder err);

    public boolean removeRcpClass(String fullName, Ice.StringHolder err, java.util.Map __ctx);

    public boolean registerRecipe(RemoteRecipeInfo rcpInfo, Ice.StringHolder err);

    public boolean registerRecipe(RemoteRecipeInfo rcpInfo, Ice.StringHolder err, java.util.Map __ctx);

    public boolean removeRecipe(String rcpID, Ice.StringHolder err);

    public boolean removeRecipe(String rcpID, Ice.StringHolder err, java.util.Map __ctx);

    public boolean storeRcpBody(String rcpID, RemoteRcpBodyInfo body, boolean ow, Ice.StringHolder err);

    public boolean storeRcpBody(String rcpID, RemoteRcpBodyInfo body, boolean ow, Ice.StringHolder err, java.util.Map __ctx);

    public boolean setRcpApprovalLvl(String rcpID, int level, Ice.StringHolder err);

    public boolean setRcpApprovalLvl(String rcpID, int level, Ice.StringHolder err, java.util.Map __ctx);

    public boolean setRcpEditor(String rcpID, String editor, Ice.StringHolder err);

    public boolean setRcpEditor(String rcpID, String editor, Ice.StringHolder err, java.util.Map __ctx);

    public boolean setRcpComments(String rcpID, String comments, Ice.StringHolder err);

    public boolean setRcpComments(String rcpID, String comments, Ice.StringHolder err, java.util.Map __ctx);

    public int getNamespaceROLvl();

    public int getNamespaceROLvl(java.util.Map __ctx);

    public boolean subscribe();

    public boolean subscribe(java.util.Map __ctx);

    public void unsubscribe();

    public void unsubscribe(java.util.Map __ctx);

    public boolean retrieveExclRcp(String rcpID, Ice.StringHolder err);

    public boolean retrieveExclRcp(String rcpID, Ice.StringHolder err, java.util.Map __ctx);

    public boolean addExclRcpDeftStep(String rcpID, String name, Ice.StringHolder err);

    public boolean addExclRcpDeftStep(String rcpID, String name, Ice.StringHolder err, java.util.Map __ctx);

    public boolean addExclRcpStep(String rcpID, String name, String[] values, Ice.StringHolder err);

    public boolean addExclRcpStep(String rcpID, String name, String[] values, Ice.StringHolder err, java.util.Map __ctx);

    public boolean removeExclRcpStep(String rcpID, int index, Ice.StringHolder err);

    public boolean removeExclRcpStep(String rcpID, int index, Ice.StringHolder err, java.util.Map __ctx);

    public boolean setExclRcpStepValue(String rcpID, int stepIndex, String paramName, String value, Ice.StringHolder err);

    public boolean setExclRcpStepValue(String rcpID, int stepIndex, String paramName, String value, Ice.StringHolder err, java.util.Map __ctx);

    public boolean setExclRcpStepName(String rcpID, int index, String name, Ice.StringHolder err);

    public boolean setExclRcpStepName(String rcpID, int index, String name, Ice.StringHolder err, java.util.Map __ctx);

    public boolean setExclRcpEditor(String rcpID, String editor, Ice.StringHolder err);

    public boolean setExclRcpEditor(String rcpID, String editor, Ice.StringHolder err, java.util.Map __ctx);

    public boolean setExclRcpComments(String rcpID, String comments, Ice.StringHolder err);

    public boolean setExclRcpComments(String rcpID, String comments, Ice.StringHolder err, java.util.Map __ctx);

    public boolean storeExclRcp(String rcpID, boolean ow, Ice.StringHolder err);

    public boolean storeExclRcp(String rcpID, boolean ow, Ice.StringHolder err, java.util.Map __ctx);

    public boolean releaseExclRcp(String rcpID, Ice.StringHolder err);

    public boolean releaseExclRcp(String rcpID, Ice.StringHolder err, java.util.Map __ctx);

    public void clear();

    public void clear(java.util.Map __ctx);

    public boolean selectRecipe(String rcpID, Ice.StringHolder err);

    public boolean selectRecipe(String rcpID, Ice.StringHolder err, java.util.Map __ctx);

    public void deselectRecipe(String rcpID);

    public void deselectRecipe(String rcpID, java.util.Map __ctx);
}
