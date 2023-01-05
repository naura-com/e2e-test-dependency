package com.naura.test.ui.page.PVD;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;

import java.util.List;

public class CurrentAlarmPage {

    private final WinForm winForm;

    private final Window.WindowOperation page;

    public CurrentAlarmPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public List<List<Object>> getAlarmList() {
        return page.elementById("mListAlarm_lv").getAllListValue();
    }

    public List<Object> getAlarmOperation(String alarmName) {
        page.elementByName(alarmName).click();
        return page.elementById("mListRecovery_lv").getListValue();
    }

    public List<Object> getAlarmDetail(String alarmName) {
        return page.elementById("mlistDescription_lv").getListValue();
    }

    public void recoverAlarm(String alarmName, String recoverOption) {
        page.elementByName(alarmName).click();
        page.elementByName(recoverOption).click();
        page.elementByName("执行").click();
    }
}
