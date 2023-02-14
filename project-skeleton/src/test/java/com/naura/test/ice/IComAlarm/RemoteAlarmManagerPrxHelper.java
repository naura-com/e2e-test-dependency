// **********************************************************************
//
// Copyright (c) 2003-2006 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

// Ice version 3.1.1

package com.naura.test.ice.IComAlarm;

public final class RemoteAlarmManagerPrxHelper extends Ice.ObjectPrxHelperBase implements RemoteAlarmManagerPrx {
	public RemoteAlarmInfo
	getAlarmInfo(String alarmId) {
		return getAlarmInfo(alarmId, __defaultContext());
	}

	public RemoteAlarmInfo
	getAlarmInfo(String alarmId, java.util.Map __ctx) {
		int __cnt = 0;
		while (true) {
			try {
				__checkTwowayOnly("getAlarmInfo");
				Ice._ObjectDel __delBase = __getDelegate();
				_RemoteAlarmManagerDel __del = (_RemoteAlarmManagerDel) __delBase;
				return __del.getAlarmInfo(alarmId, __ctx);
			} catch (IceInternal.LocalExceptionWrapper __ex) {
				__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
			} catch (Ice.LocalException __ex) {
				__cnt = __handleException(__ex, __cnt);
			}
		}
	}

	public RemoteAlarmInfo[]
	getAllAlarmInfos() {
		return getAllAlarmInfos(__defaultContext());
	}

	public RemoteAlarmInfo[]
	getAllAlarmInfos(java.util.Map __ctx) {
		int __cnt = 0;
		while (true) {
			try {
				__checkTwowayOnly("getAllAlarmInfos");
				Ice._ObjectDel __delBase = __getDelegate();
				_RemoteAlarmManagerDel __del = (_RemoteAlarmManagerDel) __delBase;
				return __del.getAllAlarmInfos(__ctx);
			} catch (IceInternal.LocalExceptionWrapper __ex) {
				__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
			} catch (Ice.LocalException __ex) {
				__cnt = __handleException(__ex, __cnt);
			}
		}
	}

	public String[]
	getAllAlarms() {
		return getAllAlarms(__defaultContext());
	}

	public String[]
	getAllAlarms(java.util.Map __ctx) {
		int __cnt = 0;
		while (true) {
			try {
				__checkTwowayOnly("getAllAlarms");
				Ice._ObjectDel __delBase = __getDelegate();
				_RemoteAlarmManagerDel __del = (_RemoteAlarmManagerDel) __delBase;
				return __del.getAllAlarms(__ctx);
			} catch (IceInternal.LocalExceptionWrapper __ex) {
				__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
			} catch (Ice.LocalException __ex) {
				__cnt = __handleException(__ex, __cnt);
			}
		}
	}

	public String[]
	getAllPostedAlarms() {
		return getAllPostedAlarms(__defaultContext());
	}

	public String[]
	getAllPostedAlarms(java.util.Map __ctx) {
		int __cnt = 0;
		while (true) {
			try {
				__checkTwowayOnly("getAllPostedAlarms");
				Ice._ObjectDel __delBase = __getDelegate();
				_RemoteAlarmManagerDel __del = (_RemoteAlarmManagerDel) __delBase;
				return __del.getAllPostedAlarms(__ctx);
			} catch (IceInternal.LocalExceptionWrapper __ex) {
				__cnt = __handleExceptionWrapperRelaxed(__ex, __cnt);
			} catch (Ice.LocalException __ex) {
				__cnt = __handleException(__ex, __cnt);
			}
		}
	}

	public boolean
	recoverAlarm(String alarmId, int recoveryPos) {
		return recoverAlarm(alarmId, recoveryPos, __defaultContext());
	}

	public boolean
	recoverAlarm(String alarmId, int recoveryPos, java.util.Map __ctx) {
		int __cnt = 0;
		while (true) {
			try {
				__checkTwowayOnly("recoverAlarm");
				Ice._ObjectDel __delBase = __getDelegate();
				_RemoteAlarmManagerDel __del = (_RemoteAlarmManagerDel) __delBase;
				return __del.recoverAlarm(alarmId, recoveryPos, __ctx);
			} catch (IceInternal.LocalExceptionWrapper __ex) {
				__handleExceptionWrapper(__ex);
			} catch (Ice.LocalException __ex) {
				__cnt = __handleException(__ex, __cnt);
			}
		}
	}

	public boolean
	subAlarmAndRecovery(Ice.Identity id, RemoteAlarmSeverity severity) {
		return subAlarmAndRecovery(id, severity, __defaultContext());
	}

	public boolean
	subAlarmAndRecovery(Ice.Identity id, RemoteAlarmSeverity severity, java.util.Map __ctx) {
		int __cnt = 0;
		while (true) {
			try {
				__checkTwowayOnly("subAlarmAndRecovery");
				Ice._ObjectDel __delBase = __getDelegate();
				_RemoteAlarmManagerDel __del = (_RemoteAlarmManagerDel) __delBase;
				return __del.subAlarmAndRecovery(id, severity, __ctx);
			} catch (IceInternal.LocalExceptionWrapper __ex) {
				__handleExceptionWrapper(__ex);
			} catch (Ice.LocalException __ex) {
				__cnt = __handleException(__ex, __cnt);
			}
		}
	}

	public boolean
	subAlarmEvent(Ice.Identity id, RemoteAlarmSeverity severity) {
		return subAlarmEvent(id, severity, __defaultContext());
	}

	public boolean
	subAlarmEvent(Ice.Identity id, RemoteAlarmSeverity severity, java.util.Map __ctx) {
		int __cnt = 0;
		while (true) {
			try {
				__checkTwowayOnly("subAlarmEvent");
				Ice._ObjectDel __delBase = __getDelegate();
				_RemoteAlarmManagerDel __del = (_RemoteAlarmManagerDel) __delBase;
				return __del.subAlarmEvent(id, severity, __ctx);
			} catch (IceInternal.LocalExceptionWrapper __ex) {
				__handleExceptionWrapper(__ex);
			} catch (Ice.LocalException __ex) {
				__cnt = __handleException(__ex, __cnt);
			}
		}
	}

	public boolean
	subRecoveryEvent(Ice.Identity id, RemoteAlarmSeverity severity) {
		return subRecoveryEvent(id, severity, __defaultContext());
	}

	public boolean
	subRecoveryEvent(Ice.Identity id, RemoteAlarmSeverity severity, java.util.Map __ctx) {
		int __cnt = 0;
		while (true) {
			try {
				__checkTwowayOnly("subRecoveryEvent");
				Ice._ObjectDel __delBase = __getDelegate();
				_RemoteAlarmManagerDel __del = (_RemoteAlarmManagerDel) __delBase;
				return __del.subRecoveryEvent(id, severity, __ctx);
			} catch (IceInternal.LocalExceptionWrapper __ex) {
				__handleExceptionWrapper(__ex);
			} catch (Ice.LocalException __ex) {
				__cnt = __handleException(__ex, __cnt);
			}
		}
	}

	public void
	unsubscribe(Ice.Identity id) {
		unsubscribe(id, __defaultContext());
	}

	public void
	unsubscribe(Ice.Identity id, java.util.Map __ctx) {
		int __cnt = 0;
		while (true) {
			try {
				Ice._ObjectDel __delBase = __getDelegate();
				_RemoteAlarmManagerDel __del = (_RemoteAlarmManagerDel) __delBase;
				__del.unsubscribe(id, __ctx);
				return;
			} catch (IceInternal.LocalExceptionWrapper __ex) {
				__handleExceptionWrapper(__ex);
			} catch (Ice.LocalException __ex) {
				__cnt = __handleException(__ex, __cnt);
			}
		}
	}

	public static RemoteAlarmManagerPrx
	checkedCast(Ice.ObjectPrx __obj) {
		RemoteAlarmManagerPrx __d = null;
		if (__obj != null) {
			try {
				__d = (RemoteAlarmManagerPrx) __obj;
			} catch (ClassCastException ex) {
				if (__obj.ice_isA("::IComAlarm::RemoteAlarmManager")) {
					RemoteAlarmManagerPrxHelper __h = new RemoteAlarmManagerPrxHelper();
					__h.__copyFrom(__obj);
					__d = __h;
				}
			}
		}
		return __d;
	}

	public static RemoteAlarmManagerPrx
	checkedCast(Ice.ObjectPrx __obj, java.util.Map __ctx) {
		RemoteAlarmManagerPrx __d = null;
		if (__obj != null) {
			try {
				__d = (RemoteAlarmManagerPrx) __obj;
			} catch (ClassCastException ex) {
				if (__obj.ice_isA("::IComAlarm::RemoteAlarmManager", __ctx)) {
					RemoteAlarmManagerPrxHelper __h = new RemoteAlarmManagerPrxHelper();
					__h.__copyFrom(__obj);
					__d = __h;
				}
			}
		}
		return __d;
	}

	public static RemoteAlarmManagerPrx
	checkedCast(Ice.ObjectPrx __obj, String __facet) {
		RemoteAlarmManagerPrx __d = null;
		if (__obj != null) {
			Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
			try {
				if (__bb.ice_isA("::IComAlarm::RemoteAlarmManager")) {
					RemoteAlarmManagerPrxHelper __h = new RemoteAlarmManagerPrxHelper();
					__h.__copyFrom(__bb);
					__d = __h;
				}
			} catch (Ice.FacetNotExistException ex) {
			}
		}
		return __d;
	}

	public static RemoteAlarmManagerPrx
	checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map __ctx) {
		RemoteAlarmManagerPrx __d = null;
		if (__obj != null) {
			Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
			try {
				if (__bb.ice_isA("::IComAlarm::RemoteAlarmManager", __ctx)) {
					RemoteAlarmManagerPrxHelper __h = new RemoteAlarmManagerPrxHelper();
					__h.__copyFrom(__bb);
					__d = __h;
				}
			} catch (Ice.FacetNotExistException ex) {
			}
		}
		return __d;
	}

	public static RemoteAlarmManagerPrx
	uncheckedCast(Ice.ObjectPrx __obj) {
		RemoteAlarmManagerPrx __d = null;
		if (__obj != null) {
			RemoteAlarmManagerPrxHelper __h = new RemoteAlarmManagerPrxHelper();
			__h.__copyFrom(__obj);
			__d = __h;
		}
		return __d;
	}

	public static RemoteAlarmManagerPrx
	uncheckedCast(Ice.ObjectPrx __obj, String __facet) {
		RemoteAlarmManagerPrx __d = null;
		if (__obj != null) {
			Ice.ObjectPrx __bb = __obj.ice_facet(__facet);
			RemoteAlarmManagerPrxHelper __h = new RemoteAlarmManagerPrxHelper();
			__h.__copyFrom(__bb);
			__d = __h;
		}
		return __d;
	}

	protected Ice._ObjectDelM
	__createDelegateM() {
		return new _RemoteAlarmManagerDelM();
	}

	protected Ice._ObjectDelD
	__createDelegateD() {
		return new _RemoteAlarmManagerDelD();
	}

	public static void
	__write(IceInternal.BasicStream __os, RemoteAlarmManagerPrx v) {
		__os.writeProxy(v);
	}

	public static RemoteAlarmManagerPrx
	__read(IceInternal.BasicStream __is) {
		Ice.ObjectPrx proxy = __is.readProxy();
		if (proxy != null) {
			RemoteAlarmManagerPrxHelper result = new RemoteAlarmManagerPrxHelper();
			result.__copyFrom(proxy);
			return result;
		}
		return null;
	}
}
