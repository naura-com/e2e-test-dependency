package com.naura.test.ui.Etch1Steps;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import com.naura.test.ui.page.Etch1.FileOption;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class QuerySteps {
    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;

    @Value("${alarmfiledir.local}")
    private String localDir;

    @Value("${filedir.local}")
    private String fileLocalDir;

    @Value("${filedir.virtual}")
    private String fileVirtualDir;

    @After(value = "@etch1-clean-all-alarm", order = 1100)
    public void cleanAlarm() {
        FileOption fileOption = new FileOption();
        fileOption.writerFile(localDir, new String[]{});
    }

    @那么("查询失败,提示信息为:")
    public void 查询失败提示信息为(String verification) {
        expect(mainPage.verifyClickAction("OK")).should(verification);
    }

    @假如("{string}不存在{string}至{string}时间段的alarm历史记录")
    public void 不存在至时间段的alarm历史记录(String module, String startTime, String endTime) {
        cleanAlarm();
    }

//    @当("查询{string}所有类型{string}至{string}时间段的报警信息时")
//    public void 查询所有类型至时间段的报警信息时(String module, String startTime, String endTime) {
//        mainPage.alarmPage().queryPage().selectModules(module);
//        mainPage.alarmPage().queryPage().clickId("checkBox2");
//        mainPage.alarmPage().queryPage().seletQueryTime(startTime, endTime);
//        mainPage.alarmPage().queryPage().clickAction("Execute");
//    }

    @假如("存在报警记录:")
    public void 存在报警记录(DataTable table) {
        FileOption fileOption = new FileOption();
        fileOption.writerAlarmFile(localDir, table);
    }

    @那么("查询结果为:")
    public void 查询结果为(String verification) {
        expect(mainPage.alarmPage().queryPage().getAlarmInfos()).should(verification);
    }

    @当("查询{string}类型为{string}的{string}至{string}时间段的报警信息时")
    public void 查询类型为的至时间段的报警信息时(String module, String type, String fromTime, String toTime) {
        mainPage.alarmPage().queryPage().selectModules(module);
        mainPage.alarmPage().queryPage().clickAction(type);
        mainPage.alarmPage().queryPage().seletQueryTime(fromTime, toTime);
        mainPage.alarmPage().queryPage().clickAction("Execute");
    }

    @当("查询所有模块所有类型{string}至{string}时间段的报警信息时")
    public void 查询所有模块所有类型至时间段的报警信息时(String fromTime, String toTime) {
        mainPage.alarmPage().queryPage().clickId("checkBox1");
        mainPage.alarmPage().queryPage().clickId("checkBox2");
        mainPage.alarmPage().queryPage().seletQueryTime(fromTime, toTime);
        mainPage.alarmPage().queryPage().clickAction("Execute");
    }

    @当("查询所有模块{string}类型{string}至{string}时间段的报警信息时")
    public void 查询所有模块类型至时间段的报警信息时(String type, String fromTime, String toTime) {
        mainPage.alarmPage().queryPage().clickId("checkBox1");
        mainPage.alarmPage().queryPage().selectSeverity(type);
        mainPage.alarmPage().queryPage().seletQueryTime(fromTime, toTime);
        mainPage.alarmPage().queryPage().clickAction("Execute");
    }

    @当("查询{string}模块所有类型{string}至{string}时间段的报警信息时")
    public void 查询模块所有类型至时间段的报警信息时(String module, String fromTime, String toTime) {
        mainPage.alarmPage().queryPage().selectModules(module);
        mainPage.alarmPage().queryPage().clickId("checkBox2");
        mainPage.alarmPage().queryPage().seletQueryTime(fromTime, toTime);
        mainPage.alarmPage().queryPage().clickAction("Execute");
    }

    @假如("Query Result已显示查询结果")
    public void queryResult已显示查询结果() {
        mainPage.alarmPage().queryPage().clickId("checkBox1");
        mainPage.alarmPage().queryPage().clickId("checkBox2");
        mainPage.alarmPage().queryPage().seletQueryTime("2000-01-01", "2022-11-30");
        mainPage.alarmPage().queryPage().clickAction("Execute");
    }

    @那么("Query Result显示为空")
    public void queryResult显示为空() {
        expect(mainPage.alarmPage().queryPage().getAlarmInfos()).should(null);
    }

    @当("执行{string}操作")
    public void 执行操作(String action) {
        mainPage.alarmPage().queryPage().clickAction(action);
    }

    @那么("操作失败,当前提示信息为:")
    public void 操作失败当前提示信息为(String verification) {
        expect(mainPage.verifyClickAction("OK")).should(verification);
    }

    @假如("Query Result显示查询结果:")
    public void queryResult显示查询结果(DataTable table) {
        mainPage.alarmPage().queryPage().clickAction(table.row(1).get(6));
        mainPage.alarmPage().queryPage().selectSeverity(table.row(1).get(0));
        mainPage.alarmPage().queryPage().seletQueryTime(table.row(1).get(1), table.row(1).get(1));
        mainPage.alarmPage().queryPage().clickAction("Execute");
    }

    @那么("操作成功,当前提示信息为:")
    public void 操作成功当前提示信息为(String verification) {
        expect(mainPage.verifyClickAction("OK")).should(verification);
    }

    @当("执行{string}到{string}并二次确认时")
    public void 执行到并二次确认时(String action, String fileName) {
        mainPage.alarmPage().queryPage().exportOk(action, fileVirtualDir, fileName);
    }

    @那么("导出文件{string}成功")
    public void 导出文件成功(String fileName) {
        assertThat(mainPage.alarmPage().queryPage().getFilesList(fileLocalDir)).contains(fileName);
    }

    @并且("文件{string}的内容为:")
    public void 文件的内容为(String fileName, String verification) {
        expect(mainPage.alarmPage().queryPage().verifyFile(fileLocalDir, fileName)).should(verification);
    }

    @当("{string}点击SelectAll")
    public void 点击selectall(String type) {
        switch (type) {
            case "Modules":
                if (!mainPage.alarmPage().queryPage().isSelect("checkBox1")) {
                    mainPage.alarmPage().queryPage().clickId("checkBox1");
                }
                break;
            case "Severity":
                if (!mainPage.alarmPage().queryPage().isSelect("checkBox2")) {
                    mainPage.alarmPage().queryPage().clickId("checkBox2");
                }
                break;
        }
    }

    @那么("所有PM,TM被选中")
    public void 所有pmTM被选中() {
        assertThat(mainPage.alarmPage().queryPage().isSelectModules("PM1")).isTrue();
        assertThat(mainPage.alarmPage().queryPage().isSelectModules("PM2")).isTrue();
        assertThat(mainPage.alarmPage().queryPage().isSelectModules("PM3")).isTrue();
        assertThat(mainPage.alarmPage().queryPage().isSelectModules("PM4")).isTrue();
        assertThat(mainPage.alarmPage().queryPage().isSelectModules("TM")).isTrue();
        assertThat(mainPage.alarmPage().queryPage().isSelectModules("CTC")).isTrue();
    }

    @那么("所有报警级别被选中")
    public void 所有报警级别被选中() {
        assertThat(mainPage.alarmPage().queryPage().isSelectSeverity("UNKNOWN")).isTrue();
        assertThat(mainPage.alarmPage().queryPage().isSelectSeverity("FATAL")).isTrue();
        assertThat(mainPage.alarmPage().queryPage().isSelectSeverity("ERROR")).isTrue();
        assertThat(mainPage.alarmPage().queryPage().isSelectSeverity("PROBLEM")).isTrue();
        assertThat(mainPage.alarmPage().queryPage().isSelectSeverity("EVENT")).isTrue();
        assertThat(mainPage.alarmPage().queryPage().isSelectSeverity("NOTICE")).isTrue();
    }
}

