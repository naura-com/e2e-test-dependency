package com.naura.test.ui.PVDSteps;

import com.naura.test.config.DataBase;
import com.naura.test.ui.page.PVD.MainPage;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import org.springframework.beans.factory.annotation.Autowired;

public class AlarmLogStep {
    @Autowired
    private MainPage mainPage;

    @Autowired
    private DataBase dataBase;

    @Before(value = "@clean-alarm-log", order = 2100)
    public void cleanAlarmLog() {
        dataBase.cleanTable("alarmlog");
    }

    @当("查询{string}至{string}时间段的报警信息时")
    public void 查询至时间段的报警信息时(String startTime, String endTime) {
        mainPage.alarmPage().alarmLogPage().executeAlarm(startTime, endTime);
    }

    @并且("过滤报警级别{string}和抛出模块{string}的记录")
    public void 过滤报警级别和抛出模块的记录(String severity, String module) {
        mainPage.alarmPage().alarmLogPage().filterAlarm(severity, module);
    }
}
