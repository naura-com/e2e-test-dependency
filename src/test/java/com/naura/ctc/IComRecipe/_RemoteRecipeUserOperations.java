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

public interface _RemoteRecipeUserOperations
{
    String[] getAllRecipes(Ice.Current __current);

    String[] getAllRcpClasses(Ice.Current __current);

    boolean getRecipeInfo(String rcpID, RemoteRecipeInfoHolder rcpInfo, Ice.Current __current);

    boolean getRcpClassInfo(String fullName, RemoteRcpClassInfoHolder clsInfo, Ice.Current __current);

    boolean registerRcpClass(String fullName, RemoteParamInfo[] params, Ice.StringHolder err, Ice.Current __current);

    boolean removeRcpClass(String fullName, Ice.StringHolder err, Ice.Current __current);

    boolean registerRecipe(RemoteRecipeInfo rcpInfo, Ice.StringHolder err, Ice.Current __current);

    boolean removeRecipe(String rcpID, Ice.StringHolder err, Ice.Current __current);

    boolean storeRcpBody(String rcpID, RemoteRcpBodyInfo body, boolean ow, Ice.StringHolder err, Ice.Current __current);

    boolean setRcpApprovalLvl(String rcpID, int level, Ice.StringHolder err, Ice.Current __current);

    boolean setRcpEditor(String rcpID, String editor, Ice.StringHolder err, Ice.Current __current);

    boolean setRcpComments(String rcpID, String comments, Ice.StringHolder err, Ice.Current __current);

    int getNamespaceROLvl(Ice.Current __current);

    boolean subscribe(Ice.Current __current);

    void unsubscribe(Ice.Current __current);

    boolean retrieveExclRcp(String rcpID, Ice.StringHolder err, Ice.Current __current);

    boolean addExclRcpDeftStep(String rcpID, String name, Ice.StringHolder err, Ice.Current __current);

    boolean addExclRcpStep(String rcpID, String name, String[] values, Ice.StringHolder err, Ice.Current __current);

    boolean removeExclRcpStep(String rcpID, int index, Ice.StringHolder err, Ice.Current __current);

    boolean setExclRcpStepValue(String rcpID, int stepIndex, String paramName, String value, Ice.StringHolder err, Ice.Current __current);

    boolean setExclRcpStepName(String rcpID, int index, String name, Ice.StringHolder err, Ice.Current __current);

    boolean setExclRcpEditor(String rcpID, String editor, Ice.StringHolder err, Ice.Current __current);

    boolean setExclRcpComments(String rcpID, String comments, Ice.StringHolder err, Ice.Current __current);

    boolean storeExclRcp(String rcpID, boolean ow, Ice.StringHolder err, Ice.Current __current);

    boolean releaseExclRcp(String rcpID, Ice.StringHolder err, Ice.Current __current);

    void clear(Ice.Current __current);

    boolean selectRecipe(String rcpID, Ice.StringHolder err, Ice.Current __current);

    void deselectRecipe(String rcpID, Ice.Current __current);
}
