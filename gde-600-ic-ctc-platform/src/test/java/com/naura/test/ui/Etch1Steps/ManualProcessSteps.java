package com.naura.test.ui.Etch1Steps;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ManualProcessSteps {

    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;

    @当("选择执行{string}")
    public void 选择执行(String action) {
        mainPage.manualPage().manualProcessPage().clickAction(action);
    }

    @那么("执行成功,弹框提示为:")
    public void 执行成功弹框提示为(String verification) {
        expect(mainPage.verifyClickActionQuestion("No")).should(verification);
    }

    @那么("执行失败,弹框提示为:")
    public void 执行失败弹框提示为(String verification) {
        expect(mainPage.verifyClickActionQuestion("No")).should(verification);
    }

    @那么("执行成功,Recipe Info列表信息为:")
    public void 执行成功RecipeInfo列表信息为(String recipeinfo) {
        expect(mainPage.manualPage().manualProcessPage().getRecipInfo()).should(recipeinfo);
    }

    @并且("Step Info列表信息为:")
    public void stepInfo列表信息为(String stepinfo) {
        expect(mainPage.manualPage().manualProcessPage().getStepInfo()).should(stepinfo);
    }

    @假如("{string}存在晶圆")
    public void 存在晶圆(String module) {
        mainPage.manualPage().waferSynchPage().allSetCTCPresent("PM");
    }

    @当("查询RecipeList")
    public void 查询recipelist() {
    }

    @那么("RecipeList查询成功:")
    public void recipelist查询成功(String recipelist) {
        expect(mainPage.manualPage().manualProcessPage().getRecipeList()).should(recipelist);
    }

    @假如("存在{string}状态的{string}")
    public void 存在状态的(String status, String recipe) {
        mainPage.manualPage().waferSynchPage().allSetCTCPresent("PM");
        mainPage.manualPage().manualProcessPage().crateProcessSts(recipe, status);
    }

    @那么("执行成功,弹框提示为")
    public void 执行成功弹框提示为2(String verification) {
        expect(mainPage.manualPage().manualProcessPage().getManualEndpointVer()).should(verification);
    }

    @并且("ElapseTime不等于StepTime")
    public void elapsetime不等于steptime() {
        assertThat(mainPage.manualPage().manualProcessPage().comElapseTimeAndStepTime()).isFalse();
    }

//    @当("第{string}步选择执行{string}")
//    public void 第步选择执行(String step, String action) {
//        mainPage.manualPage().manualProcessPage().stepManualEndpoint(step, action);
//    }

//    @当("选择执行{string}并二次确认")
//    public void 选择执行并二次确认(String action) {
//        mainPage.manualPage().manualProcessPage().confirmOperation(action, "btnRun");
//    }

    @假如("存在未保存配方如下:")
    public void 存在未保存配方如下(DataTable table) {
        if (!Arrays.asList(mainPage.editPage().recipePage().getAllLowerRcp()).contains(("/Process/" + table.row(1).get(2) + ";1"))) {
            mainPage.editPage().recipePage().createRecipeAndNotSave(table);
        } else {
            mainPage.editPage().recipePage().selectClass("PM2 GDE", "Process", true);
            mainPage.editPage().recipePage().selectRcp(table.row(1).get(2));
        }
    }

    @假如("修改当前配方并保存")
    public void 修改当前配方并保存(DataTable table) {
        mainPage.editPage().recipePage().modifyRcpParas(table);
        try {
            mainPage.editPage().recipePage().clickAction("Save");
            mainPage.editPage().recipePage().clickOkOrCancel("OK");
        } catch (Exception e) {
        }
    }

    @并且("等待机台状态为{string}")
    public void 等待机台状态为(String state) {
        mainPage.waitState(state);
    }

    @当("Recipe{string}执行{string}")
    public void recipe执行(String recipe, String action) {
        mainPage.manualPage().manualProcessPage().manualProcessOperation(recipe, action);
    }

    @当("Recipe{string}执行{string}并二次确认")
    public void recipe执行并二次确认(String recipe, String action) {
        mainPage.manualPage().manualProcessPage().confirmManualProcessOperation(recipe, action);
    }

    @当("{string}状态的{string}执行{string}并二次确认")
    public void 状态的执行并二次确认(String status, String recipe, String action) {
        mainPage.manualPage().manualProcessPage().statusRcpManualProcessOperationConfirm(status, recipe, action);
    }

    @当("{string}状态的{string}执行{string}")
    public void 状态的执行(String status, String recipe, String action) {
        mainPage.manualPage().manualProcessPage().statusRcpManualProcessOperation(status, recipe, action);
    }

    @当("{string}状态的{string}的第{string}步执行{string}")
    public void 状态的的第步执行(String status, String recipe, String step, String action) {
        mainPage.manualPage().manualProcessPage().statusStepManualProcessOperation(status, recipe, step, action);
    }

}
