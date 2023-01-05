package com.naura.test.ui.page.PVD;

import com.naura.pvd.IComData.RemoteDoubleValueInfo;
import com.naura.pvd.IComData.RemoteIntValueInfo;
import com.naura.pvd.IComData.RemoteStringValueInfo;
import com.naura.pvd.IComData.RemoteValueInfo;
import com.naura.test.config.ContextWrapper;
import com.naura.test.lower.api.LowerApi;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static com.naura.test.ui.driver.Window.WindowOperation.CLICK_ONE_BY_TEXT_BOX;

public class SetupPage {

    @Autowired
    WinForm winForm;

    private final Window.WindowOperation page;

    public SetupPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void clickOperationButton(String operation) {
        switch (operation) {
            case "应用":
                page.elementByName("应用").click();
                break;
            case "取消操作":
                page.elementByName("取消操作").click();
                break;
            case "保存":
                page.elementByName("保存").click();
                break;
            default:
                throw new RuntimeException("未知操作" + operation);
        }
    }

    public void editParam(DataTable table) {
        page.elementById("mSetupInfo_dgv").editTableCol(table.asMaps(), anyColumn -> CLICK_ONE_BY_TEXT_BOX);
        winForm.elementByName("单位 行 1").click();
    }

    public Object getCobData(String line, String name) {
        winForm.elementByName("单位 行 1").click();
        for (Map<Object, ?> value : page.elementById("mSetupInfo_dgv").getTableValue()) {
            if (value.get("参数名称").equals(line)) {
                switch (name) {
                    case "当前数值1(可编辑)":
                        return value.get("当前数值1(可编辑)");
                }
            }
        }
        return null;
    }

    public Object getChannelData(String channelName) {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        RemoteValueInfo dataValue = api.io().getData(channelName).getValue();
        switch (dataValue.type.value()) {
            case 0:
                RemoteIntValueInfo intValue = (RemoteIntValueInfo) dataValue;
                return intValue.value;
            case 1:
                RemoteStringValueInfo stringValue = (RemoteStringValueInfo) dataValue;
                return stringValue.value;
            case 2:
                RemoteDoubleValueInfo doubleValue = (RemoteDoubleValueInfo) dataValue;
                return doubleValue.value;
            default:
                return null;
        }
    }

    public void modifyParam(String paraName, String value) {
        List<Map<Object, Window.WindowOperation>> list = page.elementById("mSetupInfo_dgv").asTable();
        for (int row = 0; row < list.size(); row++) {
            if (row > 15)
                page.elementByName("下一行").click();
            if (list.get(row).get("参数名称").getValue().equals(paraName)) {
                page.elementByName("当前数值1(可编辑) 行 " + row).click().sendKeys(value);
                winForm.elementByName("单位 行 1").click();
                break;
            }
        }
    }

    public void switchTo(String destination) {
        page.elementByName(destination).click();
    }
}
