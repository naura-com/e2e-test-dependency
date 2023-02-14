package com.naura.test.ui;

import com.naura.test.ui.page.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;

public class InitStep {
    @Autowired
    private MainPage mainPage;

    @假如("多槽位模块{string}的以下槽位有片")
    public void 多槽位模块的以下槽位有片(String module, DataTable table) {
        mainPage.overViewPage().initPage().setModuleSlots(module, table.asList());
    }

    @假如("单槽位模块{string}有片")
    public void 单槽位模块有片(String module) {
        mainPage.overViewPage().initPage().setModuleSlot(module, "1", true);
    }

    @假如("单槽位模块{string}无片")
    public void 单槽位模块无片(String module) {
        mainPage.overViewPage().initPage().setModuleSlot(module, "1", false);
    }

    @假如("多槽位模块{string}满片")
    public void 多槽位模块满片(String module) {
        mainPage.overViewPage().initPage().setModuleSlots(module, true);
    }

    @假如("多槽位模块{string}无片")
    public void 多槽位模块无片(String module) {
        mainPage.overViewPage().initPage().setModuleSlots(module, false);
    }

    @假如("编辑{string}物料选择全部")
    public void 编辑物料选择全部(String module) {
        mainPage.overViewPage().initPage().editMaterial(module);
        mainPage.overViewPage().initPage().slotAll(true);
    }

    @那么("{string}被选择的槽位有")
    public void 被选择的槽位有(String module, String verification) {
        expect(mainPage.overViewPage().initPage().getSelectSlot(module)).should(verification);
        mainPage.overViewPage().initPage().clickMaterialsOn("退出");
    }

    @假如("编辑{string}物料取消选择全部")
    public void 编辑物料取消选择全部(String module) {
        mainPage.overViewPage().initPage().editMaterial(module);
        mainPage.overViewPage().initPage().slotAll(false);
    }

    @那么("抛出以下信息，同时执行{string}")
    public void 抛出以下信息同时执行(String operation, String verification) {
        expect(mainPage.getMessageAndDo(operation)).should(verification);
    }

    @并且("同步物料")
    public void 同步物料() {
        mainPage.overViewPage().initPage().clickMaterialsOn("同步");
    }

    @当("编辑{string}物料选择slot如下")
    public void 编辑物料选择slot如下(String module, DataTable table) {
        mainPage.overViewPage().initPage().editMaterial(module);
        mainPage.overViewPage().initPage().editModuleSlots(module, table.asList());
    }

    @并且("退出物料编辑")
    public void 退出物料编辑() {
        mainPage.overViewPage().initPage().clickMaterialsOn("退出");
    }

    @并且("同步物料并确定")
    public void 同步物料并确定() {
        mainPage.overViewPage().initPage().clickMaterialsOn("同步");
        mainPage.doMessage("是");
    }

    @当("切换模块{string}")
    public void 切换模块(String module) {
        mainPage.overViewPage().initPage().changeModule(module);
    }

    @并且("执行界面的{string}操作时")
    public void 执行界面的操作时(String action) {
        mainPage.clickAction(action);
    }
}
