package com.naura.test.ui.Etch1Steps;

import com.naura.test.ui.TestState;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import com.naura.test.ui.page.FileOption;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RouteSteps {
    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private TestState testState;

    @Value("${waferflowfiledir.local}")
    private String localDir;

    @Before(value = "@etch1-clean-lower-route", order = 1000)
    public void cleanRoute() {
        FileOption fileOption = new FileOption();
        try {
            fileOption.cleanDir(localDir);
        } catch (Exception e) {

        }
    }

    @After(value = "@etch1-clean-all-route", order = 8000)
    public void cleanAllRoute() {
        mainPage.editPage().routePage().deleteAllRoute();
    }

    @假如("存在新建路径{string}:")
    public void 存在新建路径(String routeName, DataTable table) {
        mainPage.editPage().routePage().createRoute(table, "");
    }

    @当("执行保存{string}操作时")
    public void 执行保存操作时(String route) {
        mainPage.editPage().routePage().saveRoute(route);
    }

    @那么("操作成功,提示信息:")
    public void 操作成功提示信息(String verification) {
        expect(mainPage.verifyClickAction("OK")).should(verification);
    }

    @当("执行保存{string}操作并二次确认时")
    public void 执行保存操作并二次确认时(String route) {
        mainPage.editPage().routePage().saveRoute(route);
        mainPage.editPage().routePage().clickAction("OK");
    }

    @那么("{string}保存成功")
    public void 保存成功(String route) {
        assertThat(mainPage.editPage().routePage().getRouteList()).contains(route);
    }

    @并且("配置文件中可查询到{string}文件:")
    public void 配置文件中可查询到文件(String fileName, String verifications) {
        expect(mainPage.editPage().routePage().verifyFile(localDir, fileName)).should(verifications);
    }

    @假如("存在已保存路径{string}:")
    public void 存在已保存路径(String route, DataTable table) {
        mainPage.editPage().routePage().createAndSaveRoute(route, table);
    }

    @当("查询{string}时")
    public void 查询时(String route) {
        mainPage.editPage().routePage().selectRoute(route);
    }

    @那么("{string}查询成功:")
    public void 查询成功(String route, String verification) {
        expect(mainPage.editPage().routePage().getRoutePMInfos(route)).should(verification);
    }

    @假如("存在新建带有{string}模块路径{string}:")
    public void 存在新建带有模块路径(String moudle, String route, DataTable table) {
        mainPage.editPage().routePage().createRoute(table, moudle);
    }

    @那么("操作失败,提示信息:")
    public void 操作失败提示信息(String verification) {
        expect(mainPage.verifyClickAction("OK")).should(verification);
    }

    @当("新建模块路径{string}:")
    public void 新建模块路径(String route, DataTable table) {
        mainPage.editPage().routePage().createRoute(table, "");
    }

    @当("修改路径{string}在腔室{string}的执行时间为{string}")
    public void 修改路径在腔室的执行时间为(String route, String PM, String time) {
        mainPage.editPage().routePage().selectRoute(route);
        mainPage.editPage().routePage().editProessTime(PM, time);
    }

    @并且("选择路径{string}")
    public void 选择路径(String route) {
        mainPage.editPage().routePage().selectRoute(route);
    }

    @那么("操作提示信息为:")
    public void 操作提示信息为(String verification) {
        expect(mainPage.editPage().routePage().verifyClickAction()).should(verification);
        mainPage.editPage().routePage().clickOKOrYes("OK");
    }

    @当("新建路径输入路径名为{string}")
    public void 新建路径输入路径名为(String name) {
    }

    @那么("{string}删除成功")
    public void 删除成功(String route) {
        assertThat(mainPage.editPage().routePage().getRouteList()).doesNotContain(route);
    }

    @并且("配置文件中无法查询到{string}文件")
    public void 配置文件中无法查询到文件(String route) {
        assertThat(mainPage.editPage().routePage().getFilesList(localDir)).doesNotContain(route);
    }

    @当("执行{string}{string}操作时")
    public void 执行操作时(String action, String route) {
        mainPage.editPage().routePage().selectRoute(route);
        mainPage.editPage().routePage().clickAction(action);
    }

    @那么("操作成功,提示信息")
    public void 操作成功提示信息2(String verification) {
        expect(mainPage.verifyClickActionQuestion("Yes")).should(verification);
    }

    @当("执行删除操作时")
    public void 执行删除操作时() {
        mainPage.editPage().routePage().clickAction("Delete");
    }

    @当("将路径{string}重命名为{string}")
    public void 将路径重命名为(String nameago, String nameafter) {
        mainPage.editPage().routePage().renameRoute(nameago, nameafter);
    }

    @那么("操作成功，路径列表中{string}变为{string}")
    public void 操作成功路径列表中变为(String nameago, String nameafter) {
        mainPage.editPage().routePage().beRenamed(nameago, nameafter);
    }

    @当("将路径{string}另存为{string}")
    public void 将路径另存为(String nameago, String nameafter) {
        mainPage.editPage().routePage().saveAsRoute(nameago, nameafter);
    }

    @那么("操作成功，路径列表中{string}另存为{string}")
    public void 操作成功路径列表中另存为(String nameago, String nameafter) {
        mainPage.editPage().routePage().beSaveAs(nameago, nameafter);
    }

    @当("否认想要对路径{string}进行重命名操作")
    public void 否认想要进行重命名操作(String route) {
        mainPage.editPage().routePage().selectRoute(route);
        mainPage.editPage().routePage().clickAction("Rename");
        mainPage.editPage().routePage().clickOKOrYes("No");
    }

    @那么("否认重命名成功，无异常发生")
    public void 否认重命名成功无异常发生() {
    }

    @当("重命名{string}为{string}")
    public void 重命名为(String preRoute, String renameRoute) {
        mainPage.editPage().routePage().renameRoute(preRoute, renameRoute);
    }

    @当("重命名{string}为{string}并二次确认")
    public void 重命名为并二次确认(String preRoute, String renameRoute) {
        mainPage.editPage().routePage().renameRoute(preRoute, renameRoute);
    }

    @当("执行重命名{string}操作时")
    public void 执行重命名操作时(String route) {
        mainPage.editPage().routePage().selectRoute(route);
        mainPage.editPage().routePage().clickAction("Rename");
    }

    @当("不选中Route执行{string}操作时")
    public void 不选中route执行操作时(String action) {
        mainPage.editPage().routePage().clickAction(action);
    }

    @当("{string}另存为{string}并二次确认")
    public void 另存为并二次确认(String preRoute, String saveAsRoute) {
        mainPage.editPage().routePage().saveAsRoute(preRoute, saveAsRoute);
    }

    @当("新添加一个空结点时")
    public void 新添加一个空结点时() {
        mainPage.editPage().routePage().clickAction("Add Node");
    }

    @那么("新添加结点成功")
    public void 新添加结点成功() {
        expect(mainPage.editPage().routePage().getNodes()).should("1");
    }

    @假如("当前存在一个空结点")
    public void 当前存在一个空结点() {
        mainPage.editPage().routePage().clickAction("Add Node");
    }

    @那么("当前界面存在{int}个结点")
    public void 当前界面存在个结点(int nodeNum) {
        assertThat(mainPage.editPage().routePage().getNodes()).isEqualTo(nodeNum);
    }

    @当("选中唯一的空结点")
    public void 选中唯一的空结点() {
        mainPage.editPage().routePage().selectItem(0);
    }

    @并且("执行删除结点操作时")
    public void 执行删除结点操作时() {
        mainPage.editPage().routePage().clickAction("Delete Item");
    }

    @当("选中{string}的路径结点")
    public void 选中的路径结点(String item) {
        mainPage.editPage().routePage().selectItem(item);
    }

    @当("选中第{int}个结点时")
    public void 选中第个结点时(int arg0) {
        mainPage.editPage().routePage().selectItem(2 * (arg0 - 1));
    }

    @当("执行撤销路径编辑操作")
    public void 执行撤销路径编辑操作() {
        mainPage.editPage().routePage().clickAction("Undo");
    }

    @当("执行{string}{string}操作并二次确认时")
    public void 执行操作并二次确认时(String action, String route) {
        mainPage.editPage().routePage().deleteOrClearAllRoute(action, route);
    }

    @当("执行{string}{string}操作并不保存时")
    public void 执行操作并不保存时(String action, String route) {
        mainPage.editPage().routePage().deleteOrClearAllRoute(action, route);
        mainPage.editPage().routePage().clickAction("Save");

    }

    @当("执行{string}操作时")
    public void 执行操作时(String action) {
        mainPage.editPage().routePage().clickAction(action);
    }

    @假如("存在已保存路径{string}执行{string}操作:")
    public void 存在已保存路径执行操作(String route, String action, DataTable table) {
        mainPage.editPage().routePage().createAndSaveRoute(route, table);
        mainPage.editPage().routePage().selectRoute(route);
        mainPage.editPage().routePage().clickAction(action);
        mainPage.editPage().routePage().clickOKOrYes("Yes");
    }

    @当("切换至{string}")
    public void 切换至(String route) {
        mainPage.editPage().routePage().selectRoute(route);
    }

    @那么("操作失败,提示信息")
    public void 操作失败提示信息2(String verification) {
        expect(mainPage.verifyClickActionQuestion("Yes")).should(verification);
    }

    @当("执行保存{string}操作")
    public void 执行保存操作(String route) {
        mainPage.editPage().routePage().clickAction("Save");
    }

    @那么("执行重命名失败，异常信息为")
    public void 执行重命名失败异常信息为(String verifyInfo) {
        expect(mainPage.verifyClickActionQuestion("Yes")).should(verifyInfo);
        mainPage.editPage().routePage().clickOKOrYes("OK");
    }

    @当("执行删除当前结点操作时")
    public void 执行删除当前结点操作时() {
        mainPage.editPage().routePage().selectItem(0);
        mainPage.editPage().routePage().clickAction("Delete Item");
    }

    @当("执行删除当前腔室操作时")
    public void 执行删除当前腔室操作时() {
        mainPage.editPage().routePage().selectItem(1);
        mainPage.editPage().routePage().clickAction("Delete Item");
    }

    @假如("存在新建带有清洁配方路径{string}:")
    public void 存在新建带有清洁配方路径(String route, DataTable table) {
        mainPage.editPage().routePage().createCleanRoute(table, "");
    }

    @当("勾选{string}")
    public void 勾选(String type) {
        mainPage.editPage().routePage().clickCmb(type);
    }

    @那么("{string}处于勾选状态,{string}处于非勾选状态")
    public void 处于勾选状态处于非勾选状态(String click, String notClick) {
        assertThat(mainPage.editPage().routePage().isSelect(click)).isTrue();
        assertThat(mainPage.editPage().routePage().isSelect(notClick)).isFalse();
    }

    @假如("存在如下已保存路径{string}:")
    public void 存在如下已保存路径(String route, DataTable table) {
        if (!(mainPage.hasRouteFile(localDir, route))) {
            mainPage.editPage().routePage().createAndSaveRoute(route, table);
        }
    }
}
