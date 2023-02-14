package com.naura.test.ui.page;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;

import java.util.List;
import java.util.Map;

public class AlarmLogPage {
    private final WinForm winForm;

    private final Window.WindowOperation page;

    public AlarmLogPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void executeAlarm(String startTime, String endTime) {
        seletQueryTime(startTime, endTime);
        clickButton("查询");
    }

    public void seletQueryTime(String fromTime, String toTime) {
        seleteQueryFromTime(fromTime);
        seleteQueryToTime(toTime);
    }

    public void seleteQueryFromTime(String fromTime) {
        winForm.elementById("mStartTime_date").sendKeys(fromTime);
        winForm.elementById("mStartTime_date").sendKeys("-");
    }

    public void seleteQueryToTime(String toTime) {
        winForm.elementById("mEndTime_date").sendKeys(toTime);
        winForm.elementById("mEndTime_date").sendKeys("-");
    }

    public void clickButton(String operation) {
        page.elementByName(operation).click();
    }

    public List<Map<Object, Object>> getAlarmInfo() {
        return page.elementById("mAlarm_dgv").getTableValue();
    }

    public void filterAlarm(String severity, String module) {
        page.elementById("mLevel_cmb").click().elementByName(severity).click();
        page.elementById("mModule_cmb").click().elementByName(module).click();
        page.elementById("mFilter_btn").click();
    }
}
