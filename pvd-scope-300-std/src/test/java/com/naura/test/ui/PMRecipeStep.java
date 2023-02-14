package com.naura.test.ui;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ui.page.MainPage;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;

public class PMRecipeStep {
    @Autowired
    private MainPage mainPage;

    @当("在{string}新建维护配方时")
    public void 在新建维护配方时(String chamber) {
        mainPage.editPage().pmRecipePage().selectChamber(chamber);
        mainPage.editPage().pmRecipePage().clickButton("新建");
    }

    @当("在{string}新建维护配方{string}时")
    public void 在新建维护配方时(String chamber, String recipeName) {
        mainPage.editPage().pmRecipePage().selectChamber(chamber);
        mainPage.editPage().pmRecipePage().clickButton("新建");
        mainPage.editPage().pmRecipePage().sendRecipeName(recipeName);
    }

    @那么("配方列表如下:")
    public void 配方列表如下(String verification) {
        expect(mainPage.editPage().pmRecipePage().getPMRcpList()).should(verification);
    }

    @那么("工艺腔室为:")
    public void 工艺腔室为(String verification) {
        expect(mainPage.editPage().pmRecipePage().getChamber()).should(verification);
    }

    @并且("保存时")
    public void 保存时() {
        mainPage.editPage().pmRecipePage().clickButton("保存");
    }


    @当("添加步骤{string}且不输入参数时")
    public void 添加步骤且不输入参数时(String stepName) {
        mainPage.editPage().pmRecipePage().addOneStepWithoutParam(stepName);
    }

    @当("添加步骤如下时:")
    public void 添加步骤如下时(Table table) {
        mainPage.editPage().pmRecipePage().addSteps(table);
    }

    @并且("切换到{string}时")
    public void 切换到时(String chamber) {
        mainPage.editPage().pmRecipePage().selectChamber(chamber);
    }

    @并且("将步骤{string}上移{int}次")
    public void 将步骤上移次(String stepName, int time) {
        mainPage.editPage().pmRecipePage().upStep(stepName, time);
    }

    @那么("步骤列表内容为:")
    public void 步骤列表内容为(String verification) {
        expect(mainPage.editPage().pmRecipePage().getParamList()).should(verification);
    }

    @并且("将步骤{string}下移{int}次")
    public void 将步骤下移次(String stepName, int time) {
        mainPage.editPage().pmRecipePage().downStep(stepName, time);
    }

    @并且("将步骤{string}删除")
    public void 将步骤删除(String stepName) {
        mainPage.editPage().pmRecipePage().deleteStep(stepName);
        mainPage.editPage().pmRecipePage().clickYes();
    }

    @当("删除{string}时")
    public void 删除时(String pmRecipe) {
        mainPage.editPage().pmRecipePage().selectRecipe(pmRecipe);
        mainPage.editPage().pmRecipePage().clickButton("删除");
        mainPage.makeSure();
    }

    @当("把{string}另存为时")
    public void 把另存为时(String pmRecipe) {
        mainPage.editPage().pmRecipePage().selectRecipe(pmRecipe);
        mainPage.editPage().pmRecipePage().clickButton("另存为");
    }

    @当("把{string}另存为{string}时")
    public void 把另存为时(String pmRecipe, String saveToRecipe) {
        mainPage.editPage().pmRecipePage().selectRecipe(pmRecipe);
        mainPage.editPage().pmRecipePage().clickButton("保存");
        mainPage.makeSure();
        mainPage.editPage().pmRecipePage().clickButton("另存为");
        mainPage.editPage().pmRecipePage().sendRecipeName(saveToRecipe);
    }

    @并且("在{string}新建命名不合法的维护配方{string}时")
    public void 在新建命名不合法的维护配方时(String chamber, String pmRecipe) {
        mainPage.editPage().pmRecipePage().selectChamber(chamber);
        mainPage.editPage().pmRecipePage().clickButton("新建");
        mainPage.editPage().pmRecipePage().sendRecipeName(pmRecipe);
    }

    @那么("错误提示为:")
    public void 错误提示为(String verification) {
        expect(mainPage.editPage().pmRecipePage().getErrorProvider()).should(verification);
    }

    @当("命名不合法的维护配方{string}时")
    public void 命名不合法的维护配方时(String rcpName) {
        mainPage.editPage().pmRecipePage().sendErrorName(rcpName);
    }

    @并且("在{string}存在维护配方{string}:")
    public void 在存在维护配方(String chamber, String rcpName, Table table) {
        mainPage.editPage().pmRecipePage().selectChamber(chamber);
        mainPage.editPage().pmRecipePage().clickButton("新建");
        mainPage.editPage().pmRecipePage().sendRecipeName(rcpName);
        mainPage.editPage().pmRecipePage().addSteps(table);
        mainPage.editPage().pmRecipePage().clickButton("保存");
        mainPage.makeSure();
    }

    @当("在{string}新建重名维护配方{string}时")
    public void 在新建重名维护配方时(String chamber, String rcpName) {
        mainPage.editPage().pmRecipePage().selectChamber(chamber);
        mainPage.editPage().pmRecipePage().clickButton("新建");
        mainPage.editPage().pmRecipePage().sendErrorName(rcpName);
    }

    @当("修改{string}中的维护配方{string}新增步骤:")
    public void 修改中的维护配方新增步骤(String chamber, String pmRecipe, Table table) {
        mainPage.editPage().pmRecipePage().selectChamber(chamber);
        mainPage.editPage().pmRecipePage().selectRecipe(pmRecipe);
        mainPage.editPage().pmRecipePage().clickButton("修改");
        mainPage.editPage().pmRecipePage().addSteps(table);
    }

    @当("修改{string}中的维护配方{string}删除步骤{string}时")
    public void 修改中的维护配方删除步骤时(String chamber, String rcpName, String stepName) {
        mainPage.editPage().pmRecipePage().selectChamber(chamber);
        mainPage.editPage().pmRecipePage().selectRecipe(rcpName);
        mainPage.editPage().pmRecipePage().clickButton("修改");
        mainPage.editPage().pmRecipePage().deleteStep(stepName);
        mainPage.editPage().pmRecipePage().clickYes();
    }
}
