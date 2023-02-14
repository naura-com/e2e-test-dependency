// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComAppEntrance;

public final class _RemoteCallbackManagerDelM extends Ice._ObjectDelM implements _RemoteCallbackManagerDel {
	public boolean
	createCallback(Ice.Identity id, Ice.StringHolder err, java.util.Map __ctx)
			throws IceInternal.LocalExceptionWrapper {
		IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "createCallback", Ice.OperationMode.Normal, __ctx, __compress);
		try {
			try {
				IceInternal.BasicStream __os = __og.os();
				id.__write(__os);
			} catch (Ice.LocalException __ex) {
				__og.abort(__ex);
			}
			boolean __ok = __og.invoke();
			try {
				IceInternal.BasicStream __is = __og.is();
				if (!__ok) {
					try {
						__is.throwException();
					} catch (Ice.UserException __ex) {
						throw new Ice.UnknownUserException(__ex.ice_name());
					}
				}
				err.value = __is.readString();
				boolean __ret;
				__ret = __is.readBool();
				return __ret;
			} catch (Ice.LocalException __ex) {
				throw new IceInternal.LocalExceptionWrapper(__ex, false);
			}
		} finally {
			__connection.reclaimOutgoing(__og);
		}
	}

	public boolean
	createCallbacks(Ice.Identity[] ids, java.util.Map __ctx)
			throws IceInternal.LocalExceptionWrapper {
		IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "createCallbacks", Ice.OperationMode.Normal, __ctx, __compress);
		try {
			try {
				IceInternal.BasicStream __os = __og.os();
				Ice.IdentitySeqHelper.write(__os, ids);
			} catch (Ice.LocalException __ex) {
				__og.abort(__ex);
			}
			boolean __ok = __og.invoke();
			try {
				IceInternal.BasicStream __is = __og.is();
				if (!__ok) {
					try {
						__is.throwException();
					} catch (Ice.UserException __ex) {
						throw new Ice.UnknownUserException(__ex.ice_name());
					}
				}
				boolean __ret;
				__ret = __is.readBool();
				return __ret;
			} catch (Ice.LocalException __ex) {
				throw new IceInternal.LocalExceptionWrapper(__ex, false);
			}
		} finally {
			__connection.reclaimOutgoing(__og);
		}
	}

	public void
	deleteCallbacks(String category, java.util.Map __ctx)
			throws IceInternal.LocalExceptionWrapper {
		IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "deleteCallbacks", Ice.OperationMode.Normal, __ctx, __compress);
		try {
			try {
				IceInternal.BasicStream __os = __og.os();
				__os.writeString(category);
			} catch (Ice.LocalException __ex) {
				__og.abort(__ex);
			}
			boolean __ok = __og.invoke();
			try {
				IceInternal.BasicStream __is = __og.is();
				if (!__ok) {
					try {
						__is.throwException();
					} catch (Ice.UserException __ex) {
						throw new Ice.UnknownUserException(__ex.ice_name());
					}
				}
			} catch (Ice.LocalException __ex) {
				throw new IceInternal.LocalExceptionWrapper(__ex, false);
			}
		} finally {
			__connection.reclaimOutgoing(__og);
		}
	}

	public RemoteCallbackType
	getType(java.util.Map __ctx)
			throws IceInternal.LocalExceptionWrapper {
		IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "getType", Ice.OperationMode.Nonmutating, __ctx, __compress);
		try {
			boolean __ok = __og.invoke();
			try {
				IceInternal.BasicStream __is = __og.is();
				if (!__ok) {
					try {
						__is.throwException();
					} catch (Ice.UserException __ex) {
						throw new Ice.UnknownUserException(__ex.ice_name());
					}
				}
				RemoteCallbackType __ret;
				__ret = RemoteCallbackType.__read(__is);
				return __ret;
			} catch (Ice.LocalException __ex) {
				throw new IceInternal.LocalExceptionWrapper(__ex, false);
			}
		} finally {
			__connection.reclaimOutgoing(__og);
		}
	}

	public boolean
	refreshCallbacks(String categroy, java.util.Map __ctx)
			throws IceInternal.LocalExceptionWrapper {
		IceInternal.Outgoing __og = __connection.getOutgoing(__reference, "refreshCallbacks", Ice.OperationMode.Normal, __ctx, __compress);
		try {
			try {
				IceInternal.BasicStream __os = __og.os();
				__os.writeString(categroy);
			} catch (Ice.LocalException __ex) {
				__og.abort(__ex);
			}
			boolean __ok = __og.invoke();
			try {
				IceInternal.BasicStream __is = __og.is();
				if (!__ok) {
					try {
						__is.throwException();
					} catch (Ice.UserException __ex) {
						throw new Ice.UnknownUserException(__ex.ice_name());
					}
				}
				boolean __ret;
				__ret = __is.readBool();
				return __ret;
			} catch (Ice.LocalException __ex) {
				throw new IceInternal.LocalExceptionWrapper(__ex, false);
			}
		} finally {
			__connection.reclaimOutgoing(__og);
		}
	}
}
