package com.naura.test.ctclower.api;

import Ice.StringHolder;
import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ice.IComAlarm.RemoteAlarmInfo;
import com.naura.test.ice.IComAlarm.RemoteAlarmManagerPrx;
import com.naura.test.ice.IComAlarm.RemoteRecoveryInfo;
import com.naura.test.api.LowerException;

import java.util.ArrayList;
import java.util.function.Function;

public class CtcAlarmApi {
    final RemoteAlarmManagerPrx remoteAlarmManagerPrx;

    public CtcAlarmApi(RemoteAlarmManagerPrx remoteAlarmManagerPrx) {
        this.remoteAlarmManagerPrx = remoteAlarmManagerPrx;
    }


    public Object invoke(String api) {
        switch (api) {
            case "getAllAlarms":
                return getAllAlarms();
            case "getAllPostedAlarms":
                return getAllPostedAlarms();
            case "getAllAlarmInfos":
                return getAllAlarmInfos();
            default:
                throw new IllegalStateException("unknown api: " + api);
        }
    }

    private void shouldTrue(Function<StringHolder, Boolean> function) {
        StringHolder stringHolder = new StringHolder();
        if (!function.apply(stringHolder))
            throw new LowerException(stringHolder.value);
    }

    private RemoteAlarmInfo[] getAllAlarmInfos() {
        return remoteAlarmManagerPrx.getAllAlarmInfos();
    }

    public Object invoke(String api, Table table) {
        switch (api) {
            case "getAlarmInfo": {
                return getAlarmInfo((String) table.get(0).get("id"));
            }
            case "recoverAlarm": {
                recoverAlarm((String) table.get(0).get("id"), (Integer) table.get(0).get("pos"));
                return null;
            }
            default:
                throw new IllegalStateException("unknown api: " + api);
        }
    }

    private void recoverAlarm(String id, Integer pos) {
        shouldTrue(stringHolder -> remoteAlarmManagerPrx.recoverAlarm(id, pos));
    }

    public String[] getAllPostedAlarms() {
        return remoteAlarmManagerPrx.getAllPostedAlarms();
    }

    private RemoteAlarmInfo getAlarmInfo(String id) {
        return remoteAlarmManagerPrx.getAlarmInfo(id);
    }

    private String[] getAllAlarms() {
        return remoteAlarmManagerPrx.getAllAlarms();
    }

    public Test test() {
        return new Test();
    }

    public class Test {
        public String[] getPostedAlarms() {
            return getAllPostedAlarms();
        }

        public void cleanAlarm() {
            for (String postedAlarm : getPostedAlarms()) {
                int i = 0;
                for (RemoteRecoveryInfo optRecoveryInfo : getAlarmInfo(postedAlarm).optRecoveryInfos) {
                    if (optRecoveryInfo.type.value() == 1 || optRecoveryInfo.type.value() == 4) {
                        recoverAlarm(postedAlarm, i);
                    }
                    i++;
                }
            }
        }

        public String[] getAllPoster() {
            ArrayList<String> PosterList = new ArrayList<String>();
            for (String postedAlarm : getPostedAlarms()) {
                PosterList.add(getAlarmInfo(postedAlarm).poster);
            }
            String[] string = new String[PosterList.size()];
            return PosterList.toArray(string);
        }
    }
}
