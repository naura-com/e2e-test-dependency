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

public interface _RemoteRecipeUserOperationsNC
{
    String[] getAllRecipes();

    String[] getAllRcpClasses();

    boolean getRecipeInfo(String rcpID, RemoteRecipeInfoHolder rcpInfo);

    boolean getRcpClassInfo(String fullName, RemoteRcpClassInfoHolder clsInfo);

    boolean registerRcpClass(String fullName, RemoteParamInfo[] params, Ice.StringHolder err);

    boolean removeRcpClass(String fullName, Ice.StringHolder err);

    boolean registerRecipe(RemoteRecipeInfo rcpInfo, Ice.StringHolder err);

    boolean removeRecipe(String rcpID, Ice.StringHolder err);

    boolean storeRcpBody(String rcpID, RemoteRcpBodyInfo body, boolean ow, Ice.StringHolder err);

    boolean setRcpApprovalLvl(String rcpID, int level, Ice.StringHolder err);

    boolean setRcpEditor(String rcpID, String editor, Ice.StringHolder err);

    boolean setRcpComments(String rcpID, String comments, Ice.StringHolder err);

    int getNamespaceROLvl();

    boolean subscribe();

    void unsubscribe();

    boolean retrieveExclRcp(String rcpID, Ice.StringHolder err);

    boolean addExclRcpDeftStep(String rcpID, String name, Ice.StringHolder err);

    boolean addExclRcpStep(String rcpID, String name, String[] values, Ice.StringHolder err);

    boolean removeExclRcpStep(String rcpID, int index, Ice.StringHolder err);

    boolean setExclRcpStepValue(String rcpID, int stepIndex, String paramName, String value, Ice.StringHolder err);

    boolean setExclRcpStepName(String rcpID, int index, String name, Ice.StringHolder err);

    boolean setExclRcpEditor(String rcpID, String editor, Ice.StringHolder err);

    boolean setExclRcpComments(String rcpID, String comments, Ice.StringHolder err);

    boolean storeExclRcp(String rcpID, boolean ow, Ice.StringHolder err);

    boolean releaseExclRcp(String rcpID, Ice.StringHolder err);

    void clear();

    boolean selectRecipe(String rcpID, Ice.StringHolder err);

    void deselectRecipe(String rcpID);
}
