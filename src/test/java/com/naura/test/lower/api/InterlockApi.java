package com.naura.test.lower.api;

import Ice.StringHolder;
import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.pvd.IComInterlock.RemoteInterlockInfo;
import com.naura.pvd.IComInterlock.RemoteInterlockManagerPrx;
import com.naura.test.lower.LowerException;

import java.util.function.Function;

public class InterlockApi {
    final RemoteInterlockManagerPrx remoteInterlockManagerPrx;

    public InterlockApi(RemoteInterlockManagerPrx remoteInterlockManagerPrx) {
        this.remoteInterlockManagerPrx = remoteInterlockManagerPrx;
    }

    public RemoteInterlockInfo getInterlockInfo(String id) {
        return remoteInterlockManagerPrx.getInterlockInfo(id);
    }

    public RemoteInterlockInfo[] getAllInterlockInfos() {
        return remoteInterlockManagerPrx.getAllInterlockInfos();
    }

    public Boolean isActive(String id) {
        return remoteInterlockManagerPrx.isActive(id);
    }

    public void activate(String id) {
        shouldTrue(stringHolder -> remoteInterlockManagerPrx.activate(id));
    }

    public void deactivate(String id) {
        shouldTrue(stringHolder -> remoteInterlockManagerPrx.deactivate(id));
    }

    public void anywaydeactivate(String id) {
        remoteInterlockManagerPrx.deactivate(id);
    }

    public void shouldTrue(Function<StringHolder, Boolean> function) {
        StringHolder stringHolder = new StringHolder();
        if (!function.apply(stringHolder))
            throw new LowerException(stringHolder.value);
    }

    public Object invoke(String api) {
        switch (api) {
            case "getAllInterlockInfos": {
                return getAllInterlockInfos();
            }
            default:
                throw new IllegalStateException("unknown api: " + api);
        }
    }

    public Object invoke(String api, Table table) {
        switch (api) {
            case "getInterlockInfo": {
                return getInterlockInfo((String) table.get(0).get("id"));
            }
            case "isActive": {
                return isActive((String) table.get(0).get("id"));
            }
            case "activate": {
                activate((String) table.get(0).get("id"));
                return null;
            }
            case "deactivate": {
                deactivate((String) table.get(0).get("id"));
                return null;
            }
            default:
                throw new IllegalStateException("unknown api: " + api);
        }
    }

    public Test test() {
        return new Test();
    }

    public class Test {
        public void activateInterlock(String id) {
            activate(id);
        }

        public void deactivateInterlock(String id) {
            deactivate(id);
        }

    }
}
