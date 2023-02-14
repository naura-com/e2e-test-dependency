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

public final class RemoteRecipeInfo implements Cloneable {
    public String name;

    public String rcpClass;

    public String version;

    public String attrChgTime;

    public String editTime;

    public boolean verified;

    public boolean linked;

    public String editedBy;

    public String comments;

    public int approvalLvl;

    public long attrLength;

    public long bodyLength;

    public RemoteRcpBodyInfo body;

    public RemoteRecipeInfo() {
    }

    public RemoteRecipeInfo(String name, String rcpClass, String version, String attrChgTime, String editTime, boolean verified, boolean linked, String editedBy, String comments, int approvalLvl, long attrLength, long bodyLength, RemoteRcpBodyInfo body) {
        this.name = name;
        this.rcpClass = rcpClass;
        this.version = version;
        this.attrChgTime = attrChgTime;
        this.editTime = editTime;
        this.verified = verified;
        this.linked = linked;
        this.editedBy = editedBy;
        this.comments = comments;
        this.approvalLvl = approvalLvl;
        this.attrLength = attrLength;
        this.bodyLength = bodyLength;
        this.body = body;
    }

    @Override
    public boolean
    equals(Object rhs) {
        if (this == rhs) {
            return true;
        }
        RemoteRecipeInfo _r = null;
        try {
            _r = (RemoteRecipeInfo) rhs;
        } catch (ClassCastException ex) {
        }

        if (_r != null) {
            if (name != _r.name && name != null && !name.equals(_r.name)) {
                return false;
            }
            if (rcpClass != _r.rcpClass && rcpClass != null && !rcpClass.equals(_r.rcpClass)) {
                return false;
            }
            if (version != _r.version && version != null && !version.equals(_r.version)) {
                return false;
            }
            if (attrChgTime != _r.attrChgTime && attrChgTime != null && !attrChgTime.equals(_r.attrChgTime)) {
                return false;
            }
            if (editTime != _r.editTime && editTime != null && !editTime.equals(_r.editTime)) {
                return false;
            }
            if (verified != _r.verified) {
                return false;
            }
            if (linked != _r.linked) {
                return false;
            }
            if (editedBy != _r.editedBy && editedBy != null && !editedBy.equals(_r.editedBy)) {
                return false;
            }
            if (comments != _r.comments && comments != null && !comments.equals(_r.comments)) {
                return false;
            }
            if (approvalLvl != _r.approvalLvl) {
                return false;
            }
            if (attrLength != _r.attrLength) {
                return false;
            }
            if (bodyLength != _r.bodyLength) {
                return false;
            }
            if (body != _r.body && body != null && !body.equals(_r.body)) {
                return false;
            }

            return true;
        }

        return false;
    }

    @Override
    public int
    hashCode() {
        int __h = 0;
        if (name != null) {
            __h = 5 * __h + name.hashCode();
        }
        if (rcpClass != null) {
            __h = 5 * __h + rcpClass.hashCode();
        }
        if (version != null) {
            __h = 5 * __h + version.hashCode();
        }
        if (attrChgTime != null) {
            __h = 5 * __h + attrChgTime.hashCode();
        }
        if (editTime != null) {
            __h = 5 * __h + editTime.hashCode();
        }
        __h = 5 * __h + (verified ? 1 : 0);
        __h = 5 * __h + (linked ? 1 : 0);
        if (editedBy != null) {
            __h = 5 * __h + editedBy.hashCode();
        }
        if (comments != null) {
            __h = 5 * __h + comments.hashCode();
        }
        __h = 5 * __h + approvalLvl;
        __h = 5 * __h + (int) attrLength;
        __h = 5 * __h + (int) bodyLength;
        if (body != null) {
            __h = 5 * __h + body.hashCode();
        }
        return __h;
    }

    @Override
    public Object
    clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException ex) {
            assert false; // impossible
        }
        return o;
    }

    public void
    __write(IceInternal.BasicStream __os) {
        __os.writeString(name);
        __os.writeString(rcpClass);
        __os.writeString(version);
        __os.writeString(attrChgTime);
        __os.writeString(editTime);
        __os.writeBool(verified);
        __os.writeBool(linked);
        __os.writeString(editedBy);
        __os.writeString(comments);
        __os.writeInt(approvalLvl);
        __os.writeLong(attrLength);
        __os.writeLong(bodyLength);
        __os.writeObject(body);
    }

    private class Patcher implements IceInternal.Patcher {
        @Override
        public void
        patch(Ice.Object v) {
            body = (RemoteRcpBodyInfo) v;
        }

        @Override
        public String
        type() {
            return "::IComRecipe::RemoteRcpBodyInfo";
        }
    }

    public void
    __read(IceInternal.BasicStream __is) {
        name = __is.readString();
        rcpClass = __is.readString();
        version = __is.readString();
        attrChgTime = __is.readString();
        editTime = __is.readString();
        verified = __is.readBool();
        linked = __is.readBool();
        editedBy = __is.readString();
        comments = __is.readString();
        approvalLvl = __is.readInt();
        attrLength = __is.readLong();
        bodyLength = __is.readLong();
        __is.readObject(new Patcher());
    }
}
