package com.naura.test.ui.PVDSteps;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ice.IComRecipe.RemoteParamInfo;
import com.naura.test.config.ContextWrapper;
import com.naura.test.api.api.LowerApi;
import com.naura.test.api.api.RecipeApi;
import com.naura.test.ui.TestState;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.PVD.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.Map;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RecipeSteps {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private WinForm winForm;

    @Autowired
    private TestState testState;
    @Autowired
    private LowerApi lowerApi;

    @Value("${filedir.local}")
    private String localDir;

    @Value("${filedir.virtual}")
    private String virtualDir;

    @Value("${app.path}")
    private String appPath;

    @Value("${app.name}")
    private String appName;

    @Value("${app.local-path}")
    private String localPath;

    @Before(value = "@clean-lower-recipeOnly", order = 1100)
    public void clean() {
        lowerApi.recipe().test().cleanRecipes();
    }

    @那么("能查询到配方{string}:")
    public void verifyRecipe(String recipe, String verification) {
        expect(mainPage.editPage().recipePage().queryRecipeInfo(recipe)).should(verification);
    }

    @Before(value = "@reset-ui-recipe", order = 2100)
    public void cleanRecipe() {
        mainPage.editPage().recipePage().reset();
    }

    @假如("创建{string}的工艺配方{string}")
    public void 创建的工艺配方(String rcpClass, String rcpName) {
        mainPage.editPage().recipePage().createDefaultRecipe(rcpClass, rcpName);
    }

    @那么("能查询到配方{string}的创建时间为:")
    public void 能查询到配方的创建时间为(String rcpName, String verification) {
        expect(mainPage.editPage().recipePage().getRcpCreateTime()).should(verification);
    }

    @当("修改{string}的工艺配方{string}:")
    public void 修改的工艺配方(String rcpClass, String rcpName, DataTable table) {
        mainPage.editPage().recipePage().editRcp(rcpClass, rcpName, table);
    }

    @并且("保存后")
    public void 保存后() {
        mainPage.editPage().recipePage().saveRcp();
    }

    @那么("能查询到配方{string}的修改时间为:")
    public void 能查询到配方的修改时间为(String arg0, String verification) {
        expect(mainPage.editPage().recipePage().getRcpEditTime()).should(verification);
    }

    @假如("存在一个RecipeClass:")
    public void 存在一个RecipeClass(Table table) {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        api.recipe().registerRcpClass((String) table.get(0).get("name"), ((List<Map<String, ?>>) table.get(0).get("params")).stream().map(RecipeApi::buildParam).toArray(RemoteParamInfo[]::new));
    }

    @并且("用户{string}使用密码{string}启动上位机")
    public void 用户使用密码启动上位机(String userName, String passWord) {
        testState.restart(userName, passWord, () -> winForm.close(), appPath, appName, localPath);
    }

    @那么("能查询到创建者为{string}")
    public void 能查询到创建者为(String creator) {
        assertThat(mainPage.editPage().recipePage().getCreator()).isEqualTo(creator);
    }

    @当("在{string}中查找{string}时,结果显示如下:")
    public void 在中查找时(String rcpClass, String str, String verification) {
        expect(mainPage.editPage().recipePage().findRcp(rcpClass, str)).should(verification);
    }

    @当("移动{int}次步骤{string}和步骤{string}")
    public void 移动次步骤和步骤(int time, String firstStep, String secondStep) {
        mainPage.editPage().recipePage().moveStep(time, firstStep, secondStep);
    }

    @并且("在{string}存在配方{string}:")
    public void 在存在配方(String rcpClass, String rcpName, DataTable table) {
        mainPage.editPage().recipePage().createStepRcp(rcpClass, rcpName, table);
    }

    @那么("{string}的{string}参数返回如下:")
    public void 参数返回如下(String colName, String parameter, String verification) {
        expect(mainPage.editPage().recipePage().getParameterValue(colName, parameter)).should(verification);
    }

    @假如("在{string}存在配方{string},步骤{int}是步骤{int}和步骤{int}循环{int}次")
    public void 在存在配方步骤是步骤和步骤循环次(String rcpClass, String rcpName, int cycStep, int first, int second, int cycTime, DataTable table) {
        mainPage.editPage().recipePage().createCycStepRcp(rcpClass, rcpName, cycStep, first, second, cycTime, table);
    }

    @那么("移动Recipe步骤的起始位返回如下:")
    public void 移动recipe步骤的起始位返回如下(String verification) {
        expect(mainPage.editPage().recipePage().getMoveFirstStepCol()).should(verification);
    }

    @当("移动Recipe步骤的起始位选择步骤{int}时")
    public void 起始位选择步骤时(int fromStep) {
        mainPage.editPage().recipePage().selectMoveFirstStep(fromStep);
    }

    @那么("移动Recipe步骤的目的位返回如下:")
    public void 移动recipe步骤的目的位返回如下(String verification) {
        expect(mainPage.editPage().recipePage().getSecondCol()).should(verification);
    }

    @那么("步骤列名返回如下:")
    public void 步骤列名返回如下(String verification) {
        expect(mainPage.editPage().recipePage().getHeaderName()).should(verification);
    }

    @那么("复制Recipe步骤的起始位返回如下:")
    public void 复制recipe步骤的起始位返回如下(String verification) {
        expect(mainPage.editPage().recipePage().getCopyFirstStepCol()).should(verification);
    }

    @当("复制Recipe步骤的起始位选择步骤{int}时")
    public void 复制recipe步骤的起始位选择步骤时(int first) {
        mainPage.editPage().recipePage().selectCopyFirstStep(first);
    }

    @那么("复制Recipe步骤的目的位返回如下:")
    public void 复制recipe步骤的目的位返回如下(String verification) {
        expect(mainPage.editPage().recipePage().getCopySecondStepCol()).should(verification);
    }

    @当("复制Recipe步骤的步骤{int}到步骤{int}时")
    public void 复制recipe步骤的步骤到步骤时(int first, int second) {
        mainPage.editPage().recipePage().copyStep(first, second);
    }

    @那么("步骤{int}和步骤{int}参数相同")
    public void 步骤和步骤参数相同(int first, int second) {
        mainPage.editPage().recipePage().verifyStep(first, second);
    }

    @当("修改步骤{string}的循环设定")
    public void 修改步骤的循环设定(String step) {
        mainPage.editPage().recipePage().selectStepCyc(step);
    }

    @那么("抛出警告，信息为:")
    public void 抛出警告信息为(String verification) {
        expect(mainPage.getMessage()).should(verification);
    }

    @当("修改步骤{string}的循环设定为步骤{string}和步骤{string}的循环{int}次设定")
    public void 修改步骤的循环设定为步骤和步骤的循环次设定(String step, String first, String second, int time) {
        mainPage.editPage().recipePage().selectStepCyc(step);
        mainPage.editPage().recipePage().transformCycSetting(first, second, Integer.toString(time));
    }

    @当("对{string}的非编辑模式的工艺配方{string}{string}步骤时")
    public void 步骤时(String rcpClass, String rcpName, String operation) {
        mainPage.editPage().recipePage().clickStepSetting(rcpClass, rcpName, operation);
    }

    @当("执行删除步骤操作时")
    public void 执行删除步骤操作时() {
        mainPage.editPage().recipePage().deleteStep();
    }

    @当("删除步骤{string}并二次确定时")
    public void 删除步骤并二次确定时(String stepName) {
        mainPage.editPage().recipePage().deleteSomeStep(stepName);
        mainPage.editPage().recipePage().makeSure();
    }

    @当("选择{string}执行{string}步骤时")
    public void 选择执行步骤时(String rcpClass, String operation) {
        mainPage.editPage().recipePage().clickStepSettingWithoutRcp(rcpClass, operation);
    }

    @当("删除步骤{string}时")
    public void 删除步骤时(String stepName) {
        mainPage.editPage().recipePage().deleteSomeStep(stepName);
    }

    @那么("出现提示信息:")
    public void 出现提示信息(String verification) {
        expect(mainPage.editPage().recipePage().getMessage()).should(verification);
    }

    @当("执行{string}步骤时")
    public void 执行步骤时(String operation) {
        mainPage.editPage().recipePage().clickOneSetting(operation);
        mainPage.editPage().recipePage().makeSure();
    }

    @当("执行{string}步骤插入到第{int}步时")
    public void 执行步骤插入到第步时(String operation, int step) {
        mainPage.editPage().recipePage().clickOneSetting(operation);
        mainPage.editPage().recipePage().insertStep(Integer.toString(step));
        mainPage.editPage().recipePage().makeSure();
    }

    @那么("新建步骤中的插入步骤的结果显示如下:")
    public void 新建步骤中的插入步骤的结果显示如下(String verification) {
        mainPage.editPage().recipePage().clickOneSetting("新建");
        expect(mainPage.editPage().recipePage().getInsertCol()).should(verification);
    }

    @那么("查看{string}的配方时,配方显示如下:")
    public void 查看的配方时(String rcpClass, String verification) {
        expect(mainPage.editPage().recipePage().showRcp(rcpClass)).should(verification);
    }

    @当("{string}时")
    public void 时(String operation) {
        mainPage.editPage().recipePage().clickOn(operation);
        mainPage.editPage().recipePage().makeSure();
    }

    @当("设置PedTemp的值为{int},PedTempTol的值为{int}")
    public void 设置pedtemp的值为PedTempTol的值为(int PedTemp, int PedTempTol) {
        mainPage.editPage().recipePage().editRcpPedTemp(PedTemp, PedTempTol);
    }

    @那么("成功保存到下位机{string}中:")
    public void 成功保存到下位机中(String rcpid, String verification) {
        expect(mainPage.editPage().recipePage().getLowerRcp(rcpid)).should(verification);
    }

    @那么("抛出提示，信息为:")
    public void 抛出提示信息为(String verification) {
        expect(mainPage.editPage().recipePage().getMessage()).should(verification);
    }

    @假如("在{string}存在配方{string}，comments信息为{string}")
    public void 在存在配方Comments信息为(String rcpClass, String rcpName, String comments, DataTable table) {
        mainPage.editPage().recipePage().createStepRcp(rcpClass, rcpName, table);
        mainPage.editPage().recipePage().fillComments(comments);
        mainPage.editPage().recipePage().saveRecipe();
    }

    @当("在{string}新建配方{string}，comments信息为{string}")
    public void 在新建配方Comments信息为(String rcpClass, String rcpName, String comments) {
        mainPage.editPage().recipePage().createDefaultRecipe(rcpClass, rcpName);
        mainPage.editPage().recipePage().fillComments(comments);
    }

    @并且("切换recipe为{string}后选择{string}")
    public void 切换recipe为后选择(String rcpName, String processMode) {
        mainPage.editPage().recipePage().selectRecipe(rcpName);
        mainPage.editPage().recipePage().doPopMessage(processMode);
    }

    @并且("切换recipe为{string}")
    public void 切换recipe为(String rcpName) {
        mainPage.editPage().recipePage().selectRecipe(rcpName);
    }

    @那么("对报警选择{string}操作")
    public void 对报警选择操作(String processMode) {
        mainPage.editPage().recipePage().doPopMessage(processMode);
    }

    @那么("抛出警告，选择{string}操作，信息为:")
    public void 抛出警告选择操作信息为(String processMode, String verification) {
        expect(mainPage.editPage().recipePage().getMessageOnly()).should(verification);
        mainPage.editPage().recipePage().doPopMessage(processMode);
    }

    @并且("修改{string}的工艺配方{string}参数:")
    public void 修改的工艺配方参数(String rcpClass, String rcpName, DataTable table) {
        mainPage.editPage().recipePage().editRcpParam(rcpClass, rcpName, table);
    }

    @并且("修改{string}的工艺配方{string}comment信息:")
    public void 修改的工艺配方Comment信息(String rcpClass, String rcpName, DataTable table) {
        mainPage.editPage().recipePage().editRcpComment(rcpClass, rcpName, table);
    }

    @并且("切换腔室为{string}")
    public void 切换腔室为(String rcpClass) {
        mainPage.editPage().recipePage().selectRecipeClass(rcpClass);
    }

    @当("切换腔室为{string}后选择{string}")
    public void 切换腔室为后选择(String rcpName, String processMode) {
        mainPage.editPage().recipePage().selectRecipeClass(rcpName);
        mainPage.editPage().recipePage().doPopMessage(processMode);
    }

    @并且("此时recipe list包含")
    public void 此时recipeList包含(String verification) {
        expect(mainPage.editPage().recipePage().getCurrentRecipeList()).should(verification);
    }

    @那么("{string}的{string}创建成功")
    public void 创建成功(String rcpClass, String rcp) {
        assertThat(mainPage.editPage().recipePage().getRcp(rcpClass)).contains(rcp);
    }

    @那么("执行失败,返回错误信息如下:")
    public void 执行失败返回错误信息如下(String verification) {
        expect(mainPage.editPage().recipePage().getErrorMsg()).should(verification);
        mainPage.editPage().recipePage().clickOn("确定");
    }

    @并且("配方参数如下:")
    public void 配方参数如下(String verification) {
        expect(mainPage.editPage().recipePage().getParamInfo()).should(verification);
    }

    @当("删除{string}的配方{string}并二次确认后")
    public void 删除配方并二次确认后(String rcpClass, String rcpName) {
        mainPage.editPage().recipePage().deleteRcp(rcpClass, rcpName);
        mainPage.editPage().recipePage().makeSureAndCheck();
    }

    @那么("删除{string}的{string}成功")
    public void 删除成功(String rcpClass, String rcpName) {
        assertThat(mainPage.editPage().recipePage().getRcp(rcpClass)).doesNotContain(rcpName);
    }

    @当("未选择配方执行{string}时")
    public void 未选择配方执行时(String btn) {
        mainPage.editPage().recipePage().clickOn(btn);
    }

    @并且("撤销编辑")
    public void 撤销编辑() {
        mainPage.editPage().recipePage().Undo();
    }

    @当("执行{string}")
    public void 执行(String btn) {
        mainPage.editPage().recipePage().checkPedTempValue();
        mainPage.editPage().recipePage().clickOn(btn);
    }

    @当("修改{string}的{string}的PedTemp的温度值为{string}，余度值为{string}")
    public void 修改pedtemp的温度值为余度值为(String rcpClass, String rcpName, String temp, String tol) {
        mainPage.editPage().recipePage().selectRcp(rcpClass, rcpName);
        mainPage.editPage().recipePage().setPedTempValue(temp, tol);
    }

    @当("修改{string}的工艺配方{string}如下:")
    public void 修改的工艺配方如下(String rcpClass, String rcpName, DataTable table) {
        mainPage.editPage().recipePage().editRcpParam(rcpClass, rcpName, table);
    }

    @当("未设置PedTemp时执行{string}")
    public void 未设置pedtemp时执行(String btn) {
        mainPage.editPage().recipePage().clickOn(btn);
    }

    @当("未编辑{string}的{string}时{string}")
    public void 未编辑时(String rcpClass, String rcpName, String btn) {
        mainPage.editPage().recipePage().selectRcp(rcpClass, rcpName);
        mainPage.editPage().recipePage().clickOn(btn);
    }

    @当("选择{string}的{string}{string}{string}并且二次确认后")
    public void 选择的并且另存为(String rcpClass, String rcpName, String btn, String newRcpName) {
        mainPage.editPage().recipePage().selectRcp(rcpClass, rcpName);
        mainPage.editPage().recipePage().clickOn(btn);
        mainPage.editPage().recipePage().restoreRcp(newRcpName);
        mainPage.editPage().recipePage().makeSure();
    }

    @当("选择{string}的{string}并{string}时")
    public void 选择执行另存为时(String rcpClass, String rcpName, String btn) {
        mainPage.editPage().recipePage().selectRcp(rcpClass, rcpName);
        mainPage.editPage().recipePage().clickOn(btn);
    }

    @当("删除{string}的{string}的PedTemp后{string}")
    public void 删除pedtemp后(String rcpClass, String rcpName, String btn) {
        mainPage.editPage().recipePage().selectRcp(rcpClass, rcpName);
        mainPage.editPage().recipePage().cleanPedTemp();
        mainPage.editPage().recipePage().clickOn(btn);
    }

    @并且("下位机无法查找到{string}")
    public void 下位机无法查找到(String rcpId) {
        assertThat(mainPage.editPage().recipePage().getAllLowerRcp()).doesNotContain(rcpId);
    }

    @当("执行{string}并且{string}后")
    public void 执行并且后(String btn1, String btn2) {
        mainPage.editPage().recipePage().clickOn(btn1);
        mainPage.editPage().recipePage().clickOn(btn2);
        mainPage.editPage().recipePage().clickOn(btn2);
    }

    @那么("提示{string}")
    public void 提示(String title) {
        expect(mainPage.editPage().recipePage().checkPopUpMessage().equals(title));
    }

    @那么("下位机{string}应为:")
    public void 下位机应为(String rcpId, String verification) {
        expect(mainPage.editPage().recipePage().getLowerRcp(rcpId)).should(verification);
    }

    @那么("{string}后的{string}的{string}应恢复为先前的参数值如下:")
    public void 应恢复为先前的参数值如下(String btn, String rcpClass, String rcpName, String verification) {
        mainPage.editPage().recipePage().reset();
        mainPage.editPage().recipePage().clickOn(btn);
        mainPage.editPage().recipePage().selectRcp(rcpClass, rcpName);
        expect(mainPage.editPage().recipePage().getParamInfo()).should(verification);
    }

    @当("选择{string}的{string}并{string}名为{string}的文件时")
    public void 选择的并文件时(String rcpClass, String rcpName, String btn, String NewRcpName) {
        mainPage.editPage().recipePage().selectRcp(rcpClass, rcpName);
        mainPage.editPage().recipePage().clickOn(btn);
        mainPage.editPage().recipePage().exportRcpFile(virtualDir, NewRcpName);
    }

    @并且("导出路径存在文件{string}:")
    public void 导出路径存在文件(String fileName, String verification) {
        expect(mainPage.editPage().recipePage().verifyFile(localDir, fileName)).should(verification);
    }

    @当("选择{string}{string}到{string}时")
    public void 选择到时(String fileName, String btn, String rcpClass) {
        mainPage.editPage().recipePage().selectRecipeClass(rcpClass);
        mainPage.editPage().recipePage().clickOn(btn);
        mainPage.editPage().recipePage().importRcpFile(virtualDir, fileName);
    }

    @当("不设置监控值{string}时")
    public void 不设置监控值时(String operation) {
        mainPage.editPage().recipePage().clickOn(operation);
    }

    @当("选择{string}腔室且{string}{string}时")
    public void 选择腔室且配方时(String rcpClass, String action, String rcpName) {
        mainPage.editPage().recipePage().selectRecipeClass(rcpClass);
        mainPage.editPage().recipePage().selectRecipe(rcpName);
        mainPage.editPage().recipePage().clickOn(action);
        mainPage.editPage().recipePage().doCreateRcp(rcpName);
    }

    @那么("执行失败,{string}报错信息如下")
    public void 执行失败报错信息如下(String errorType, String verification) {
        expect(mainPage.editPage().recipePage().getErrorProvider(errorType)).should(verification);
    }

    @当("新建配方{string}时")
    public void 新建配方时(String rcpName) {
        mainPage.editPage().recipePage().doCreateRcp(rcpName);
    }

    @当("执行{string}操作修改{string}的{string}的PedTemp的值为{string}")
    public void 执行操作修改的的PedTemp的值为(String action, String rcpClass, String rcpName, String temp) {
        mainPage.editPage().recipePage().selectRcp(rcpClass, rcpName);
        mainPage.editPage().recipePage().clickOn(action);
        mainPage.editPage().recipePage().cleanPedTemp();
        mainPage.editPage().recipePage().setHeaterTemp(temp);
    }

    @当("执行{string}操作修改{string}的{string}的PedTemp余度的值为{string}")
    public void 执行操作修改的的PedTemp余度的值为(String action, String rcpClass, String rcpName, String tol) {
        mainPage.editPage().recipePage().selectRcp(rcpClass, rcpName);
        mainPage.editPage().recipePage().clickOn(action);
        mainPage.editPage().recipePage().cleanPedTemp();
        mainPage.editPage().recipePage().setHeaterTol(tol);
    }

    @当("移动步骤时:")
    public void 移动步骤时(DataTable table) {
        table.asMaps().forEach(map ->
                mainPage.editPage().recipePage().moveStep(Integer.parseInt(map.get("time")), map.get("step1"), map.get("step2")));
    }
}
