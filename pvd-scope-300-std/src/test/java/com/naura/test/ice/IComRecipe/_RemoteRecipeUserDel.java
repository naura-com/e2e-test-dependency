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

public interface _RemoteRecipeUserDel extends Ice._ObjectDel {
    String[] getAllRecipes(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    String[] getAllRcpClasses(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean getRecipeInfo(String rcpID, RemoteRecipeInfoHolder rcpInfo, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean getRcpClassInfo(String fullName, RemoteRcpClassInfoHolder clsInfo, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean registerRcpClass(String fullName, RemoteParamInfo[] params, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean removeRcpClass(String fullName, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean registerRecipe(RemoteRecipeInfo rcpInfo, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean removeRecipe(String rcpID, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean storeRcpBody(String rcpID, RemoteRcpBodyInfo body, boolean ow, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean setRcpApprovalLvl(String rcpID, int level, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean setRcpEditor(String rcpID, String editor, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean setRcpComments(String rcpID, String comments, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    int getNamespaceROLvl(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean subscribe(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    void unsubscribe(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean retrieveExclRcp(String rcpID, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean addExclRcpDeftStep(String rcpID, String name, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean addExclRcpStep(String rcpID, String name, String[] values, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean removeExclRcpStep(String rcpID, int index, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean setExclRcpStepValue(String rcpID, int stepIndex, String paramName, String value, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean setExclRcpStepName(String rcpID, int index, String name, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean setExclRcpEditor(String rcpID, String editor, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean setExclRcpComments(String rcpID, String comments, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean storeExclRcp(String rcpID, boolean ow, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean releaseExclRcp(String rcpID, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    void clear(java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    boolean selectRecipe(String rcpID, Ice.StringHolder err, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;

    void deselectRecipe(String rcpID, java.util.Map __ctx)
            throws IceInternal.LocalExceptionWrapper;
}
