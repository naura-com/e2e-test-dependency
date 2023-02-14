package com.naura.test.ui;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ui.page.FileInfo;
import com.naura.test.ui.page.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RouteSteps {

    @Autowired
    private MainPage mainPage;

    @那么("能查询到路径{string}:")
    public void 能查询到路径_route(String routeName, String verification) {
        expect(mainPage.editPage().routePage().queryRouteInfo(routeName)).should(verification);
    }

    @当("新增如下路径{string}:")
    public void 新增如下路径(String name, DataTable table) {
        mainPage.editPage().routePage().createRoute(name, table);
    }

    @当("未选择路径执行{string}时")
    public void 未选择路径执行时(String btn) {
        mainPage.editPage().routePage().clickOn(btn);
    }

    @那么("执行失败，提示信息如下:")
    public void 执行失败提示信息如下(String verification) {
        expect(mainPage.editPage().routePage().getMessage()).should(verification);
    }

    @当("{string}处于{string}状态的{string}并二次{string}时")
    public void 处于状态的并二次时(String operation, String status, String routeName, String confirm) {
        mainPage.editPage().routePage().selectRoute(routeName);
        mainPage.editPage().routePage().clickOn(status);
        mainPage.editPage().routePage().clickOn(operation);
        mainPage.editPage().routePage().clickOn(confirm);
        mainPage.editPage().routePage().makeSure(confirm);
    }

    @并且("成功删除{string}")
    public void 成功删除(String routeName) {
        assertThat(mainPage.editPage().routePage().getAllRoute()).doesNotContain(routeName);
    }

    @假如("存在Route为{string}:")
    public void 存在route为(String routeName, DataTable table) {
        mainPage.editPage().recipePage().createRouteRcp(table);
        mainPage.editPage().routePage().createRoute(routeName, table);
    }

    @并且("查找{string}时,结果显示如下:")
    public void 查找时结果显示如下(String str, String verification) {
        expect(mainPage.editPage().routePage().findRoute(str)).should(verification);
        mainPage.editPage().routePage().cleanFilter();
    }

    @并且("清除查找框后,界面显示如下:")
    public void 清除查找框后界面显示如下(String verification) {
        expect(mainPage.editPage().routePage().getAllRoute()).should(verification);
    }

    @当("选择{string}并{string}路径参数如下:")
    public void 选择并路径参数如下(String routeName, String operation, DataTable table) {
        mainPage.editPage().routePage().selectRoute(routeName);
        mainPage.editPage().routePage().clickOn(operation);
        mainPage.editPage().routePage().editRouteParam(table);
    }

    @并且("{string}的路径参数如下:")
    public void 的路径参数如下(String routeName, String verification) {
        expect(mainPage.editPage().routePage().getRouteParamInfo(routeName).toArray()).should(verification);
    }

    @并且("选择Route{string}")
    public void 选择route(String routeName) {
        mainPage.editPage().routePage().selectRoute(routeName);
    }

    @当("创建路径{string}时")
    public void 创建路径时(String routeName) {
        mainPage.editPage().routePage().createNewRoute(routeName);
    }

    @那么("{string}创建成功，且参数列表为空")
    public void 创建成功且参数列表为空(String routeName) {
        assertThat(mainPage.editPage().routePage().getAllRoute()).contains(routeName);
        expect(mainPage.editPage().routePage().getRouteParamInfo(routeName)).should(null);
    }

    @并且("{string}路径{string}并执行{string}")
    public void 重新创建路径并执行(String action, String routeName, String operation) {
        mainPage.editPage().routePage().clickOn(action);
        mainPage.editPage().routePage().clickOn(operation);
    }

    @那么("未成功创建{string}")
    public void 未成功创建(String routeName) {
        assertThat(mainPage.editPage().routePage().getAllRoute()).doesNotContain(routeName);
    }

    @当("{string}{string}时")
    public void 新建时(String action, String routeName) {
        mainPage.editPage().routePage().clickOn(action);
    }

    @当("再次创建{string}时")
    public void 再次创建时(String routeName) {
        mainPage.editPage().routePage().createDefaultRoute(routeName);
    }

    @那么("抛出警告，{string}后并且二次确认，信息为:")
    public void 抛出警告选择操作并且二次确认信息为(String action, String verification) {
        expect(mainPage.editPage().routePage().getMessage()).should(verification);
        mainPage.editPage().routePage().makeSure(action);
    }

    @那么("抛出警告并且执行{string}，信息为:")
    public void 抛出警告并且执行信息为(String action, String verification) {
        expect(mainPage.editPage().routePage().getPopUpMessage()).should(verification);
        mainPage.editPage().routePage().makeSure(action);
    }

    @那么("抛出警告，信息如下:")
    public void 抛出警告信息如下(String verification) {
        expect(mainPage.editPage().routePage().getWhiteWindowPopUpMessage()).should(verification);
        mainPage.editPage().routePage().makeSureWhiteWindow();
    }

    @当("{string}处于{string}状态的{string}并{string}时")
    public void 处于状态的并时(String action, String status, String routeName, String confirm) {
        mainPage.editPage().routePage().selectRoute(routeName);
        mainPage.editPage().routePage().clickOn(status);
        mainPage.editPage().routePage().clickOn(action);
        mainPage.editPage().routePage().clickOn(confirm);
    }

    @当("{string}处于{string}状态的{string}时")
    public void 处于状态的时(String action, String status, String routeName) {
        mainPage.editPage().routePage().selectRoute(routeName);
        mainPage.editPage().routePage().clickOn(status);
        mainPage.editPage().routePage().clickOn(action);
    }

    @并且("{string}路径时")
    public void 路径时(String operation) {
        mainPage.editPage().routePage().clickButton(operation, true);
        mainPage.editPage().routePage().batchExport();
    }

    @那么("文件内容为:")
    public void 文件内容为(String verification) {
        expect(mainPage.editPage().routePage().getFiles()).should(verification);
    }

    @并且("{string}路径{string}时")
    public void 路径时(String operation, String route) {
        mainPage.editPage().routePage().selectRoute(route);
        mainPage.editPage().routePage().clickButton(operation, true);
        mainPage.editPage().routePage().ExportRoute();
    }

    @假如("在路径{string}存在文件{string}:")
    public void 在路径存在文件(String path, String file, DataTable table) throws IOException {
        List<List<String>> lists = table.asLists();
        String[] lines = new String[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            lines[i] = "";
            for (String str : lists.get(i)) {
                if (str == null)
                    lines[i] += ",";
                else
                    lines[i] += str + ",";
            }
            lines[i] = lines[i].substring(0, lines[i].length() - 1);
        }

        FileInfo fileInfo = new FileInfo();
        fileInfo.writeFile(path + "\\" + file, lines);
    }

    @并且("{string}路径{string}覆盖{string}时")
    public void 路径覆盖时(String operation, String route, String originalFile) {
        mainPage.editPage().routePage().selectRoute(route);
        mainPage.editPage().routePage().clickButton(operation, false);
        mainPage.editPage().routePage().ExportRoute();
        mainPage.clickYes();
        mainPage.makeSure();
    }

    @当("{string}另存为{string}时")
    public void 另存为时(String route, String saveAsRoute) {
        mainPage.editPage().routePage().selectRoute(route);
        mainPage.editPage().routePage().clickButton("另存为", false);
        mainPage.editPage().routePage().saveAsRoute(saveAsRoute);
        mainPage.makeSure();
    }

    @那么("{string}内容为:")
    public void 内容为(String route, String verification) {
        mainPage.editPage().routePage().selectRoute(route);
        expect(mainPage.editPage().routePage().getRouteShowInfo()).should(verification);
    }

    @并且("新建路径{string}")
    public void 新建路径(String route) {
        mainPage.editPage().routePage().clickButton("新建", false);
        mainPage.editPage().routePage().sendRouteName(route);
    }

    @当("另存为{string}时")
    public void 另存为时(String route) {
        mainPage.editPage().routePage().clickButton("另存为", false);
    }

    @那么("显示错误信息为:")
    public void 显示错误信息为(String verification) {
        expect(mainPage.editPage().routePage().getErrorMessage()).should(verification);
    }

    @当("保存路径{string}时")
    public void 保存路径时(String route) {
        mainPage.editPage().routePage().selectRoute(route);
        mainPage.editPage().routePage().clickButton("保存", false);
    }

    @当("保存路径时")
    public void 保存路径时() {
        mainPage.editPage().routePage().clickButton("保存", false);
    }

    @当("对路径{string}执行编辑的{string}操作时")
    public void 对路径执行编辑的操作时(String routeName, String editOperation) {
        mainPage.editPage().routePage().editOperate(routeName, editOperation);
    }

    @假如("存在Route{string}:")
    public void 存在route(String routeName, DataTable table) {
        mainPage.editPage().recipePage().createRouteRecipe(table.asMaps());
        mainPage.editPage().routePage().createRoute(routeName, table);
    }

    @并且("路径显示如下:")
    public void 路径显示如下(String verification) {
        expect(mainPage.editPage().routePage().getRouteShowInfo()).should(verification);
    }

    @那么("抛出对话框，信息为:")
    public void 抛出对话框信息为(String verification) {
        expect(mainPage.editPage().routePage().getPopMessage()).should(verification);
    }

    @当("选择单元格{string}后对路径{string}执行编辑的{string}操作时")
    public void 选择单元格后对路径执行编辑的操作时(String cellIndex, String routeName, String editOperation) {
        mainPage.editPage().routePage().editOperate(routeName, cellIndex, editOperation);
    }

    @当("选择第{string}行后对路径{string}执行编辑的{string}操作时")
    public void 选择第行后对路径执行编辑的操作时(String row, String routeName, String editOperation) {
        mainPage.editPage().routePage().editOperate(routeName, row + ",左上方标题单元格", editOperation);
    }

    @并且("编辑路径参数:")
    public void 编辑路径参数(DataTable table) {
        mainPage.editPage().routePage().editRouteParam(table);
    }

    @假如("新建Route{string}:")
    public void 新建route(String routeName, DataTable table) {
        mainPage.editPage().routePage().newRoute(routeName, table);
    }

    @那么("第{string}行的{string}返回如下:")
    public void 第行的返回如下(String rowIndex, String column, String verification) {
        expect(mainPage.editPage().routePage().getCellItems(rowIndex, column)).should(verification);
    }

    @并且("编辑路径参数并保存:")
    public void 编辑路径参数并保存(DataTable table) {
        mainPage.editPage().routePage().editRouteParam(table);
        mainPage.editPage().routePage().saveRoute();
    }

    @假如("存在如下defaultRoute")
    public void 存在如下defaultroute(Table table) {
        List<List<String>> raws = Arrays.asList(
                Arrays.asList("步骤", "腔室"),
                Arrays.asList("1", "LA"),
                Arrays.asList("2", "LB"));
        DataTable routeInfo = DataTable.create(raws);
        for (int row = 0; row < table.size(); row++) {
            mainPage.editPage().routePage().createRoute(table.get(row).get("name").toString(), routeInfo);
        }
    }
}
