package com.naura.test.ui.Etch1Steps;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static com.github.leeonky.dal.Assertions.expect;

public class ManualJobSteps {

    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;

    @Before(value = "@etch1-synWithCTC", order = 3000)
    public void synWithCTC() {
        mainPage.manualPage().waferSynchPage().synWithCTC();
    }

    @Before(value = "@etch1-load-synWithCTC", order = 4000)
    public void loadAndsynWithCTC() {
//        mainPage.manualPage().waferSynchPage().allSetAbsent("LoadLock A");
//        mainPage.manualPage().waferSynchPage().allSetAbsent("LoadLock B");
        mainPage.manualPage().waferSynchPage().allSetCTCPresent("LoadLock A");
        mainPage.manualPage().waferSynchPage().allSetCTCPresent("LoadLock B");
        mainPage.manualPage().waferSynchPage().allSetCTCAbsent("PM");
        mainPage.manualPage().waferSynchPage().allSetCTCAbsent("AL");
        mainPage.manualPage().waferSynchPage().allSetCTCAbsent("TM");
        mainPage.manualPage().waferSynchPage().allSetCTCAbsent("Center");
        mainPage.manualPage().waferSynchPage().synWithCTC();
        mainPage.systemPage().configPage().setPostAlarmForExtraWafers();
    }

    @Before(value = "@etch1-load-initialize", order = 4000)
    public void initialize() {
        mainPage.systemPage().moduleStatusPage().initialize();
    }

    @After(value = "@etch1-clean-LPA-job1", order = 8000)
    public void cleanJob() {
        for (int i = 0; i < 120; i++) {
            if (mainPage.manualPage().manualJobPage().waitJobAborted("LoadLoack A") ||
                    mainPage.manualPage().manualJobPage().waitJobCompleted("LoadLoack A")) {
                break;
            }
        }
    }

    @After(value = "@etch1-clean-LPB-job2", order = 9000)
    public void cleanJoblpb() {
        for (int i = 0; i < 120; i++) {
            if (mainPage.manualPage().manualJobPage().waitJobAborted("LoadLoack B") ||
                    mainPage.manualPage().manualJobPage().waitJobCompleted("LoadLoack B")) {
                break;
            }
        }
    }

    @Before(value = "@etch1-PostAlarmForExtraWafers", order = 6000)
    public void setPostAlarmForExtraWafer() {
        mainPage.systemPage().configPage().setPostAlarmForExtraWafers();
    }

    @After(value = "@etch1-cleanall-setwaferflow", order = 11000)
    public void cleanAll() {
        mainPage.manualPage().manualJobPage().clearAll("LoadLock A");
        mainPage.manualPage().manualJobPage().clearAll("LoadLock B");
    }

    @那么("列表显示为:")
    public void 列表显示为(String verification) {
        expect(mainPage.manualPage().manualJobPage().getSetWaferflowList()).should(verification);
        mainPage.manualPage().manualJobPage().clickAction("Cancel");
    }

    @当("{string}执行Set Waferflow操作后")
    public void 执行setWaferflow操作后(String lp) {
        mainPage.manualPage().manualJobPage().clickSetWaferflow(lp);
    }

    @那么("{string}执行Set Waferflow操作成功:")
    public void 执行setWaferflow操作成功(String lp, String verification) {
        expect(mainPage.manualPage().manualJobPage().getEditJobWaferflow(lp)).should(verification);
    }

    @当("LoadLock执行Set Waferflow操作:")
    public void loadlock执行setWaferflow操作(DataTable table) {
        mainPage.manualPage().manualJobPage().lpSetWaferflow(table);
    }

    @当("LoadLock执行Del Waferflow操作:")
    public void loadlock执行delWaferflow操作(DataTable table) {
        mainPage.manualPage().manualJobPage().lpDelWaferflow(table);
    }

    @那么("{string}执行Del Waferflow操作成功:")
    public void 执行delWaferflow操作成功(String lp, String verification) {
        expect(mainPage.manualPage().manualJobPage().getEditJobWaferflow(lp)).should(verification);
    }

    @当("执行Set Waferflow操作后")
    public void 执行setWaferflow操作后2(String lp) {
        mainPage.manualPage().manualJobPage().clickSetWaferflow(lp);
    }

    @当("{string}执行Set Map Waferflow操作后")
    public void 执行setMapWaferflow操作后(String lp) {
        mainPage.manualPage().manualJobPage().clickSetMapWaferflow(lp);
    }

    @当("{string}选中{string}执行Set Map Waferflow操作")
    public void 选中执行SetMapWaferflow操作(String arg0, String arg1) {
        mainPage.manualPage().manualJobPage().setMapWfr(arg0, arg1);
    }

    @那么("{string}执行Set Map Waferflow操作成功:")
    public void 执行setMapWaferflow操作成功(String lp, String verification) {
        执行setWaferflow操作成功(lp, verification);
    }

    @当("{string}执行Clear All操作")
    public void 执行clearAll操作(String lp) {
        mainPage.manualPage().manualJobPage().clearAll(lp);
    }

    @那么("{string}执行Clear All操作成功:")
    public void 执行clearAll操作成功(String arg0, String verification) {
        执行setWaferflow操作成功(arg0, verification);
    }

    @当("设置{string}的Lot ID为{string}")
    public void 设置的LotID为(String lp, String lotid) {
        mainPage.manualPage().manualJobPage().setLotID(lp, lotid);
    }

    @那么("{string}的Lot ID设置成功:")
    public void 的lotID设置成功(String lp, String verification) {
        switch (lp) {
            case "LoadLock A":
                expect(winForm.elementById("lotIDLeft").getText()).should(verification);
                break;
            case "LoadLock B":
                expect(winForm.elementById("lotIDRight").getText()).should(verification);
                break;
        }
    }

    @假如("{string}里面装载了晶圆:")
    public void 里面装载了晶圆(String arg0, DataTable datatable) {
        mainPage.manualPage().waferSynchPage().setWaferLoad(arg0, datatable);
    }

    @那么("{string}Schedule Mode下拉框显示内容为:")
    public void scheduleMode下拉框显示内容为(String lp, String verification) {
        expect(mainPage.manualPage().manualJobPage().getScheduleModeList(lp)).should(verification);
    }

    @当("查看{string}的Schedule Mode")
    public void 查看的ScheduleMode(String lp) {
    }

    @当("{string}设置{string}为{string}")
    public void 设置为(String lp, String module, String value) {
        mainPage.manualPage().manualJobPage().setModuleValue(lp, module, value);
    }

    @那么("{string}的{string}设置成功:")
    public void 的设置成功(String lp, String module, String verification) {
        expect(mainPage.manualPage().manualJobPage().getModuleValue(lp, module)).should(verification);
    }

    @当("{string}执行{string}操作")
    public void 执行操作(String lp, String action) {
        mainPage.manualPage().manualJobPage().lpActionClick(lp, action);
    }

    @那么("操作失败,失败信息为:")
    public void 操作失败失败信息为(String verification) {
//        mainPage.manualPage().manualJobPage().clickAction("OK");
        expect(mainPage.verifyClickAction("OK")).should(verification);
    }

    @假如("{string}全部晶圆装载")
    public void 全部晶圆装载(String arg0) {
        mainPage.manualPage().waferSynchPage().allSetCTCPresent(arg0);
    }

    @假如("LoadLock存在单片job:")
    public void loadlock存在单片job(DataTable table) {
        mainPage.manualPage().waferSynchPage().setLpWaferPresent(table.row(1).get(0), table.row(1).get(1));
        mainPage.manualPage().manualJobPage().setSingleWaferJob(table);
    }

    @假如("LoadLock存在Running状态的job:")
    public void loadlock存在running状态的job(DataTable table) {
        mainPage.manualPage().manualJobPage().setSingleWaferJob(table);
        mainPage.manualPage().manualJobPage().lpActionClick(table.row(1).get(0), "Start");
        mainPage.manualPage().manualJobPage().waitJobRunning(table.row(1).get(0));
    }

    @那么("操作成功,成功提示信息为:")
    public void 操作成功成功提示信息为(String verification) {
        expect(mainPage.verifyClickActionQuestion("")).should(verification);
    }

    @那么("{string}执行{string}操作成功:")
    public void 执行操作成功(String lp, String action, String verification) {
        expect(mainPage.manualPage().manualJobPage().getJobState(lp, action)).should(verification);
    }

    @当("{string}执行{string}操作:")
    public void 执行操作2(String lp, String action) {
//        mainPage.manualPage().manualJobPage().lpActionClick(lp, "");
        mainPage.manualPage().manualJobPage().getLpWindowOperation(lp).elementByName(action).click();
    }

    @那么("{string}执行{string}操作成功")
    public void 执行操作成功2(String lp, String action, String verification) {
        expect(mainPage.manualPage().manualJobPage().getJobState(lp, "Validated")).should(verification);
    }

    @并且("{string}的job正常执行结束:")
    public void 的job正常执行结束(String lp, String verification) {
        expect(mainPage.manualPage().manualJobPage().getJobState(lp, "Completed")).should(verification);
    }

    @假如("LoadLock存在满片job:")
    public void loadlock存在满片job(DataTable table) {
        mainPage.manualPage().manualJobPage().setAllWaferJob(table);
    }

//    @假如("修改当前配方并进行保存:")
//    public void 修改当前配方并进行保存(DataTable table) {
//        mainPage.editPage().recipePage().storeNewRcp(table);
//    }

    @假如("修改配方{string}并进行保存:")
    public void 修改配方并进行保存(String rcp, DataTable table) {
        if (!Arrays.asList(mainPage.editPage().recipePage().getAllLowerRcp()).contains(("/Process/" + rcp + ";1"))) {
            mainPage.editPage().recipePage().storeNewRcp(table, rcp);
        }
    }

    @假如("设置{string}的Lot ID为{string},未设置waferflow")
    public void 设置的LotID为未设置waferflow(String lp, String lotid) {
        mainPage.manualPage().manualJobPage().setLotID(lp, lotid);
        mainPage.manualPage().manualJobPage().clearAll(lp);
    }
}
