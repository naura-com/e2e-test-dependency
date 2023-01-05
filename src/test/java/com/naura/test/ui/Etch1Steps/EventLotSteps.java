package com.naura.test.ui.Etch1Steps;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;

public class EventLotSteps {
    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;

    @Before(value = "@cleanLogDir")
    public void cleanLogDir(){
        mainPage.eventPage().lotHistoryPage().cleanDir();
    }

    @假如("有事件日志包括:")
    public void 假如存在事件日志(Table table){
        mainPage.eventPage().lotHistoryPage().manualProFilePrepare(table);
    }

    @当("执行Jobs导出")
    public void 执行jobs导出() {
        mainPage.eventPage().lotHistoryPage().exportJobs();
    }

    @当("执行Slot导出")
    public void 执行slot导出() {
        mainPage.eventPage().lotHistoryPage().exportSlot();
    }

    @当("查询{string}至{string}的手动事件日志时")
    public void 查询至的手动事件日志时(String arg0, String arg1) {
        mainPage.eventPage().lotHistoryPage().selectManualMode();
        mainPage.eventPage().lotHistoryPage().queryHist(arg0, arg1);
    }

    @当("查询{string}至{string}的自动事件日志时")
    public void 查询至的自动事件日志时(String arg0, String arg1) {
        mainPage.eventPage().lotHistoryPage().selectAutoMode();
        mainPage.eventPage().lotHistoryPage().queryHist(arg0, arg1);
    }

    @那么("查询手动事件日志结果为:")
    public void 查询手动事件日志结果为(String verification) {
        expect(mainPage.eventPage().lotHistoryPage().getManProTableInfo()).should(verification);
    }

    @那么("查询自动事件日志结果为")
    public void 查询自动事件日志结果为(String verification) {
        expect(mainPage.eventPage().lotHistoryPage().getAutoTableInfo()).should(verification);
    }

    @假如("有单个晶圆被执行的自动工作日志:")
    public void 有单个晶圆被执行的自动工作日志(Table table) {
        mainPage.eventPage().lotHistoryPage().autoFilePrepareL(table);
    }

    @并且("有晶圆单步工艺步骤记录:")
    public void 有晶圆单步工艺步骤记录(Table table) {
        mainPage.eventPage().lotHistoryPage().autoFilePrepareR(table);
    }

    @并且("有FileID为{int}的晶圆流动路径记录:")
    public void 有fileid为的晶圆流动路径记录(int arg0, Table table) {
        mainPage.eventPage().lotHistoryPage().autoFilePrepareW(arg0, table);
    }

    @当("打开日志Job信息时")
    public void 打开日志job信息时() {
        mainPage.eventPage().lotHistoryPage().selectFirstJobQuery();
    }

    @当("打开日志Job晶圆信息时")
    public void 打开日志job晶圆信息时() {
        mainPage.eventPage().lotHistoryPage().selectFirstSlotDetails();
    }

    @那么("日志Job晶圆信息为:")
    public void 日志job晶圆信息为(String verification) {
        expect(mainPage.eventPage().lotHistoryPage().getSlotTableInfo()).should(verification);
    }

    @那么("日志Job晶圆步骤信息为:")
    public void 日志job晶圆步骤信息为(String verification) {
        expect(mainPage.eventPage().lotHistoryPage().getStepTableInfo()).should(verification);
    }

    @那么("日志Job晶圆流动路径信息为:")
    public void 日志job晶圆流动路径信息为(String verification) {
        expect(mainPage.eventPage().lotHistoryPage().getFlowTableInfo()).should(verification);
    }
}
