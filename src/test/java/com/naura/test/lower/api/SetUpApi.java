package com.naura.test.lower.api;

import Ice.StringHolder;
import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.pvd.IComRecipe.RemoteParamInfo;
import com.naura.pvd.IComSetup.RemoteSetupManagerPrx;
import com.naura.test.lower.LowerException;

import java.util.function.Function;

import static java.util.Arrays.stream;

public class SetUpApi {
    final RemoteSetupManagerPrx remoteSetupManagerPrx;

    public SetUpApi(RemoteSetupManagerPrx remoteSetupManagerPrx) {
        this.remoteSetupManagerPrx = remoteSetupManagerPrx;
    }

    public int getSetupOptionNum(String name) {
        return remoteSetupManagerPrx.getSetupOptionNum(name);
    }

    public RemoteParamInfo[] getSetupAllParams(String name) {
        return remoteSetupManagerPrx.getSetupAllParams(name);
    }

    public String[] getAllSetupNames() {
        return remoteSetupManagerPrx.getAllSetupNames();
    }

    public void saveSetupToXML(String name) {
        shouldTrue(stringHolder -> remoteSetupManagerPrx.saveSetupToXML(name));
    }

    public void loadFromSetup(String name, String optIndex) {
        shouldTrue(stringHolder -> remoteSetupManagerPrx.loadFromSetup(name, Integer.parseInt(optIndex)));
    }

    public void setSetupValue(String name, String optIndex, String paramName, String value) {
        shouldTrue(stringHolder -> remoteSetupManagerPrx.setSetupValue(name, Integer.parseInt(optIndex), paramName, value));
    }

    public String[] getSetupOptionValues(String name, String optIndex) {
        return remoteSetupManagerPrx.getSetupOptionValues(name, Integer.parseInt(optIndex));
    }

    public void saveToSetup(String name, String optIndex) {
        shouldTrue(stringHolder -> remoteSetupManagerPrx.saveToSetup(name, Integer.parseInt(optIndex)));
    }

    public Object invoke(String api) {
        switch (api) {

            default:
                throw new IllegalStateException("unknown api: " + api);
        }
    }

    public Object invoke(String api, Table table) {
        switch (api) {
            case "loadFromSetup": {
                loadFromSetup((String) table.get(0).get("name"), (String) table.get(0).get("index"));
                return null;
            }
            case "getSetupOptionValues": {
                return getSetupOptionValues((String) table.get(0).get("name"), (String) table.get(0).get("index"));
            }
            case "setSetupValue": {
                for (int row = 0; row < table.size(); row++) {
                    setSetupValue((String) table.get(row).get("name"), (String) table.get(row).get("index"), (String) table.get(row).get("paramName"), (String) table.get(row).get("value"));
                }
                return null;
            }
            case "getSetupOptionNum": {
                return getSetupOptionNum((String) table.get(0).get("name"));
            }
            case "getSetupAllParams": {
                return getSetupAllParams((String) table.get(0).get("name"));
            }
            case "saveToSetup": {
                saveToSetup((String) table.get(0).get("name"), (String) table.get(0).get("index"));
                return null;
            }
            case "saveSetupToXML": {
                saveSetupToXML((String) table.get(0).get("name"));
                return null;
            }
            default:
                throw new IllegalStateException("unknown api: " + api);
        }
    }

    public void shouldTrue(Function<StringHolder, Boolean> function) {
        StringHolder stringHolder = new StringHolder();
        if (!function.apply(stringHolder))
            throw new LowerException(stringHolder.value);
    }

    public Test test() {
        return new Test();
    }

    public class Test {
        public void recoverValue() {
            for (String name : getAllSetupNames()) {

            }
            stream(getAllSetupNames()).forEach(SetUpApi.this::getSetupAllParams);
        }
    }
}
