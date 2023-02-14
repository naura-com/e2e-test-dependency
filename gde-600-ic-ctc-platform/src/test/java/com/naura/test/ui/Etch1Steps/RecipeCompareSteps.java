package com.naura.test.ui.Etch1Steps;

import com.naura.test.ui.TestState;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.Assertions.assertThat;

public class RecipeCompareSteps {
    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;

    @Autowired
    private TestState testState;

    @Before(value = "@etch1-clean-recipeCompare", order = 3000)
    public void cleanRcpCompare() {
        mainPage.editPage().recipeComparePage().cleanRecipe();
    }

    @那么("执行失败,弹出提示信息:")
    public void 执行失败弹出提示信息(String verification) {
        expect(mainPage.verifyClickAction("OK")).should(verification);
    }

    @当("直接点击{string}")
    public void 直接点击(String action) {
        mainPage.editPage().recipeComparePage().clickRecipe(action);
    }

    @假如("{string}选择{string}")
    public void 选择(String module, String value) {
        mainPage.editPage().recipeComparePage().chooseValue(module, value);
    }

    @假如("存在已保存配方如下:")
    public void 存在已保存配方如下(DataTable table) {
        if (!Arrays.asList(mainPage.editPage().recipePage().getAllLowerRcp()).contains(("/" + table.row(1).get(1) + "/" + table.row(1).get(2) + ";1"))) {
            mainPage.editPage().recipePage().createRecipeAndSave(table);
        }
    }

    @当("直接点击Compare")
    public void 直接点击compare() {
        mainPage.editPage().recipeComparePage().clickId("btnCmp");
    }

    @当("选中{string}")
    public void 选中(String action) {
        mainPage.editPage().recipeComparePage().clickCmb(action);
    }

    @那么("{string}被勾选,{string}未被勾选")
    public void 被勾选未被勾选(String checkViewAll, String checkViewDiff) {
        assertThat(winForm.elementByName(checkViewAll).isSelect()).isTrue();
        assertThat(winForm.elementByName(checkViewDiff).isSelect()).isFalse();
    }

    @假如("已比较{string}的{string}的{string}和{string}的{string}")
    public void 已比较的的和的(String pmVal, String rcpTypeVal, String rcp1Val, String rcp2Val, String type) {
        mainPage.editPage().recipeComparePage().compareRecipe(pmVal, rcpTypeVal, rcp1Val, rcp2Val, type);
    }

    @当("执行Clear操作")
    public void 执行clear操作() {
        mainPage.editPage().recipeComparePage().clickId("btnClear");
    }

    @那么("比较列表数据清空成功")
    public void 比较列表数据清空成功() {
        expect(winForm.elementById("lvRecipeCompare").getListValue().size()).should("0");
    }

    @假如("选择Recipe的比较条件:")
    public void 选择recipe的比较条件(DataTable dataTable) {
        dataTable.asMaps().forEach(map -> mainPage.editPage().recipeComparePage().chooseValue(map.get("condition"), map.get("value")));
    }

    @当("比较如下Recipe:")
    public void 比较如下recipe(DataTable dataTable) {
        mainPage.editPage().recipeComparePage().compare(dataTable);
    }

    @假如("Page以{string}方式比较如下Recipe:")
    public void page以方式比较如下Recipe(String page, DataTable dataTable) {
        mainPage.editPage().recipeComparePage().selectPageAndCompare(page, dataTable);
    }
}
