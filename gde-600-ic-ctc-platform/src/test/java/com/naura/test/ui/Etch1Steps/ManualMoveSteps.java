package com.naura.test.ui.Etch1Steps;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;

public class ManualMoveSteps {

    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;

    @Before(value = "@etch1-clean-module", order = 40000)
    public void cleanModule() {
        mainPage.manualPage().waferSynchPage().allModuleSetAbsent();
    }

    @Before(value = "@etch1-init", order = 50000)
    public void init() {
        mainPage.Initialize();
    }

    @假如("{string}已装载所有wafer")
    public void 已装载所有wafer(String lp) {
        mainPage.manualPage().waferSynchPage().allSetCTCPresent(lp);
        mainPage.manualPage().waferSynchPage().synWithCTC();
    }

    @当("选择初始模块{string}模块")
    public void 选择初始模块模块(String module) {
        mainPage.manualPage().manualMovePage().selectModule(module, "Source");
    }

    @那么("初始模块{string}的Position列表如下:")
    public void 初始模块的position列表如下(String module, String verification) {
        mainPage.manualPage().manualMovePage().selectModule(module, "Source");
        expect(mainPage.manualPage().manualMovePage().getPositionList("Source")).should(verification);
    }

    @假如("{string}未装载晶圆")
    public void 未装载晶圆(String module) {
        mainPage.manualPage().waferSynchPage().allSetCTCAbsent(module);
    }

    @假如("模块里面装载了晶圆:")
    public void 模块里面装载了晶圆(DataTable table) {
        mainPage.manualPage().waferSynchPage().allModuleSetAbsent();
        for (int i = 0; i < table.height(); i++) {
            mainPage.manualPage().waferSynchPage().setWaferLoad(table.row(i).get(0), table.subTable(i, 1, table.height(), table.width()));
        }
    }

    @假如("所有模块均无晶圆存在")
    public void 所有模块均无晶圆存在() {
        mainPage.manualPage().waferSynchPage().allModuleSetAbsent();
    }

    @当("选择目的模块{string}模块")
    public void 选择目的模块模块(String module) {
        mainPage.manualPage().manualMovePage().selectModule(module, "Destination");
    }

    @那么("目的模块{string}的Position列表如下:")
    public void 目的模块的Position列表如下(String module, String verification) {
        mainPage.manualPage().manualMovePage().selectModule(module, "Destination");
        expect(mainPage.manualPage().manualMovePage().getPositionList("Destination")).should(verification);
    }

    @那么("初始模块Module文本框正确显示{string}模块名:")
    public void 初始模块module文本框正确显示模块名(String module, String verification) {
        expect(mainPage.manualPage().manualMovePage().getModuleInfo("Source")).should(verification);
    }

    @那么("目的模块Module文本框正确显示{string}模块名:")
    public void 目的模块module文本框正确显示模块名(String module, String verification) {
        expect(mainPage.manualPage().manualMovePage().getModuleInfo("Destination")).should(verification);
    }

    @当("选择初始模块{string}模块,目的模块{string}模块")
    public void 选择初始模块模块目的模块模块(String srcModule, String desModule) {
        mainPage.manualPage().manualMovePage().selectModule(srcModule, "Source");
        mainPage.manualPage().manualMovePage().selectModule(desModule, "Destination");
    }

    @当("选择初始模块{string},Position选择{string}")
    public void 选择初始模块Position选择(String srcModule, String position) {
        mainPage.manualPage().manualMovePage().selectModule(srcModule, "Source");
        mainPage.manualPage().manualMovePage().setPosition(position, "Source");
    }

    @当("选择目的模块{string}模块,Position选择{string}")
    public void 选择目的模块模块Position选择(String desModule, String position) {
        mainPage.manualPage().manualMovePage().selectModule(desModule, "Destination");
        mainPage.manualPage().manualMovePage().setPosition(position, "Destination");
    }

    @并且("执行Move操作")
    public void 执行move操作() {
        mainPage.manualPage().manualMovePage().clickAction("Move->");
    }

    @那么("操作失败，弹框提示为:")
    public void 操作失败弹框提示为(String verification) {
        expect(mainPage.verifyClickAction("OK"));
    }

    @那么("操作成功,初始模块{string}的Position列表如下:")
    public void 操作成功初始模块的Position列表如下(String module, String verification) {
        mainPage.manualPage().manualMovePage().selectModule(module, "Source");
        expect(mainPage.manualPage().manualMovePage().getPositionList("Source")).should(verification);
    }

    @那么("操作成功,弹框提示信息为:")
    public void 操作成功弹框提示信息为(String verification) {
        expect(mainPage.verifyClickActionQuestion("Cancel")).should(verification);
    }

    @并且("执行Move操作且二次确认")
    public void 执行move操作且二次确认() throws InterruptedException {
        mainPage.manualPage().manualMovePage().clickAction("Move->");
        mainPage.manualPage().manualMovePage().clickAction("Continue");
        Thread.sleep(20 * 1000);
    }

    @假如("以下模块已全部装载晶圆:")
    public void 以下模块已全部装载晶圆(DataTable dataTable) {
        mainPage.manualPage().waferSynchPage().moduleSetPresent(dataTable);
    }
}
