package com.naura.test.ui.PVDSteps;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.config.ContextWrapper;
import com.naura.test.lower.api.LowerApi;
import com.naura.test.ui.page.PVD.MainPage;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.github.leeonky.dal.Assertions.expect;

public class InterlockStep {
    @Autowired
    private MainPage mainPage;

    @那么("标签页显示如下:")
    public void 标签页显示如下(String verification) {
        expect(mainPage.maintenancePage().interlockPage().getTabControl()).should(verification);
    }

    @当("获取{string}的{string}时")
    public void 获取的时(String chamber, String interlockType) {
        mainPage.maintenancePage().interlockPage().switchTo(chamber, interlockType);
    }

    @那么("返回结果如下:")
    public void 返回结果如下(String verification) {
        expect(mainPage.maintenancePage().interlockPage().getDgvValue()).should(verification);
    }

    @当("查看{string}的{string}{string}的详细信息时")
    public void 查看的的详细信息时(String chamber, String interlockType, String interlockName) {
        mainPage.maintenancePage().interlockPage().switchTo(chamber, interlockType);
        mainPage.maintenancePage().interlockPage().clickInterlockName(interlockName);
    }

    @那么("设置型互锁名称为:")
    public void 设置型互锁名称为(String verification) {
        expect(mainPage.maintenancePage().interlockPage().getInterlockName("SetValue")).should(verification);
    }

    @那么("监控型互锁名称为:")
    public void 监控型互锁名称为(String verification) {
        expect(mainPage.maintenancePage().interlockPage().getInterlockName("OverRun")).should(verification);
    }

    @那么("设置型防护对象为:")
    public void 设置型防护对象为(String verification) {
        expect(mainPage.maintenancePage().interlockPage().getDefenseObject()).should(verification);
    }

    @那么("设置型触发条件为:")
    public void 设置型触发条件为(String verification) {
        expect(mainPage.maintenancePage().interlockPage().getTriggerCondition("SetValue")).should(verification);
    }

    @那么("监控型触发条件为:")
    public void 监控型触发条件为(String verification) {
        expect(mainPage.maintenancePage().interlockPage().getTriggerCondition("OverRun")).should(verification);
    }

    @那么("设置型检测条件为:")
    public void 设置型检测条件为(String verification) {
        expect(mainPage.maintenancePage().interlockPage().getCheckCondition()).should(verification);
    }

    @那么("设置型报警为:")
    public void 设置型报警为(String verification) {
        expect(mainPage.maintenancePage().interlockPage().getAlarmInfo("SetValue")).should(verification);
    }

    @那么("监控型报警为:")
    public void 监控型报警为(String verification) {
        expect(mainPage.maintenancePage().interlockPage().getAlarmInfo("OverRun")).should(verification);
    }

    @那么("监控型动作为:")
    public void 监控型动作为(String verification) {
        expect(mainPage.maintenancePage().interlockPage().getAction()).should(verification);
    }

    @假如("屏蔽下位机互锁")
    public void 屏蔽下位机互锁(Table table) {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        for (Map<String, ?> map : table) {
            api.interlockApi().deactivate((String) map.get("name"));
        }
    }

    @那么("{string}的{string}结果如下:")
    public void 的结果如下(String chamber, String interlockType, String verification) {
        mainPage.maintenancePage().interlockPage().switchTo(chamber, interlockType);
        expect(mainPage.maintenancePage().interlockPage().getDgvValue()).should(verification);
    }

    @当("激活{string}的{string}:")
    public void 激活的(String chamber, String interlockType, Table table) {
        mainPage.maintenancePage().interlockPage().switchTo(chamber, interlockType);
        mainPage.maintenancePage().interlockPage().activeInterlock(table);
    }

    @当("屏蔽{string}的{string}:")
    public void 屏蔽的(String chamber, String interlockType, Table table) {
        mainPage.maintenancePage().interlockPage().switchTo(chamber, interlockType);
        mainPage.maintenancePage().interlockPage().deactivateInterlock(table);
    }

    @当("修改通道值:")
    public void 修改通道值(Table table) {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        for (Map<String, ?> map : table) {
            api.io().setValue_Async((String) map.get("name"), (String) map.get("value"));
        }
    }

    @那么("报警信息返回如下:")
    public void 报警信息返回如下(String verification) {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        expect(api.alarmapi().getAllPostedAlarms()).should(verification);
    }

    @SneakyThrows
    @那么("等待{int}秒后报警信息返回如下:")
    public void 等待秒后报警信息返回如下(int second, String verification) {
        TimeUnit.SECONDS.sleep(second);
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        expect(api.alarmapi().getAllPostedAlarms()).should(verification);
    }

    @当("激活所有{string}{string}")
    public void 激活所有(String chamber, String interlockType) {
        mainPage.maintenancePage().interlockPage().switchTo(chamber, interlockType);
        mainPage.maintenancePage().interlockPage().activeAllInterlock();
    }

    @当("屏蔽所有{string}{string}")
    public void 屏蔽所有(String chamber, String interlockType) {
        mainPage.maintenancePage().interlockPage().switchTo(chamber, interlockType);
        mainPage.maintenancePage().interlockPage().deactivateAllInterlock();
    }
}
