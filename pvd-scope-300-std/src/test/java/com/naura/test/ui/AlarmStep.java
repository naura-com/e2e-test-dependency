package com.naura.test.ui;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.config.ContextWrapper;
import com.naura.test.api.api.LowerApi;
import com.naura.test.ui.page.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static com.github.leeonky.dal.Assertions.expect;

public class AlarmStep {
    @Autowired
    private MainPage mainPage;

    @After(value = "@clean-structure-alarm", order = 11000)
    public void cleanInterlock() {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        api.cleanAlarm();
    }

    @那么("报警列表信息如下:")
    public void 报警列表信息如下(String verification) {
        expect(mainPage.alarmPage().currentAlarmPage().getAlarmList()).should(verification);
    }

    @假如("激活下位机互锁:")
    public void 激活下位机互锁(Table table) {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        for (Map<String, ?> map : table) {
            api.interlockApi().activate((String) map.get("name"));
        }
    }

    @那么("{string}报警操作信息如下:")
    public void 报警操作信息如下(String alarmName, String verification) {
        expect(mainPage.alarmPage().currentAlarmPage().getAlarmOperation(alarmName)).should(verification);
    }

    @那么("{string}报警详细信息如下:")
    public void 报警详细信息如下(String alarmName, String verification) {
        expect(mainPage.alarmPage().currentAlarmPage().getAlarmDetail(alarmName)).should(verification);
    }

    @当("执行{string}的{string}选项")
    public void 执行的选项(String alarmName, String recoverOption) {
        mainPage.alarmPage().currentAlarmPage().recoverAlarm(alarmName, recoverOption);
    }

    @并且("切换到当前报警界面")
    public void 切换到当前报警界面() {
        mainPage.alarmPage().currentAlarmPage();
    }
}
