package com.naura.test.api.api;

import Ice.LocalException;
import Ice.StringHolder;
import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ice.IComAppEntrance.RemoteAppEntrancePrx;
import com.naura.test.ice.IComData.AMI_RemoteData_setValue;
import com.naura.test.ice.IComData.RemoteDataInfo;
import com.naura.test.ice.IComData.RemoteDataPrx;
import com.naura.test.ice.IComData.RemoteValueInfo;
import com.naura.test.api.LowerException;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class IOApi {
    final RemoteAppEntrancePrx remoteAppEntrancePrx;

    public IOApi(RemoteAppEntrancePrx remoteAppEntrancePrx) {
        this.remoteAppEntrancePrx = remoteAppEntrancePrx;
    }

    public RemoteValueInfo getValue(String name) {
        return remoteAppEntrancePrx.getData(name).getValue();
    }

    public RemoteDataInfo getInfo(String name) {
        return remoteAppEntrancePrx.getData(name).getInfo();
    }

    public RemoteDataPrx getData(String name) {
        return remoteAppEntrancePrx.getData(name);
    }

    public void setValue(String name, String value) {
        shouldTrue(stringHolder -> remoteAppEntrancePrx.getData(name).setValue(value, stringHolder));
    }

    public void setValue_Async(String name, String value) {
        AMI_RemoteData_setValue AMI = new AMI_RemoteData_setValue() {
            @Override
            public void ice_response(boolean __ret, String err) {

            }

            @Override
            public void ice_exception(LocalException ex) {
                throw new LowerException(ex.getMessage());
            }
        };
        remoteAppEntrancePrx.getData(name).setValue_async(AMI, value);
    }

    private void shouldTrue(Function<StringHolder, Boolean> function) {
        StringHolder stringHolder = new StringHolder();
        if (!function.apply(stringHolder))
            throw new LowerException(stringHolder.value);
    }

    @SneakyThrows
    public Object invoke(String api, Table table) {
        switch (api) {
            case "getValue": {
                if (table.size() == 1) {
                    return getValue((String) table.get(0).get("name"));
                } else {
                    List<RemoteValueInfo> remoteValue = new ArrayList<>();
                    for (Map<String, ?> row : table) {
                        remoteValue.add(getValue((String) row.get("name")));
                    }
                    return remoteValue;
                }
            }
            case "setValue": {
                for (Map<String, ?> row : table) {
                    setValue((String) row.get("name"), (String) row.get("value"));
                }
                return null;
            }
            case "getInfo": {
                return getInfo((String) table.get(0).get("name"));
            }
            case "setValue_Async": {
                setValue_Async((String) table.get(0).get("name"), (String) table.get(0).get("value"));
                return null;
            }
            default:
                throw new IllegalStateException("unknown api: " + api);
        }
    }
}
