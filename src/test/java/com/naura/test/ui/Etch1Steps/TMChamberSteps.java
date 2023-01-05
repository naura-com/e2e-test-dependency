package com.naura.test.ui.Etch1Steps;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TMChamberSteps {
    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;

    @当("查看{string}的下拉列表")
    public void 查看的下拉列表(String module) {
        mainPage.maintainPage().tmChamberPage().clickModule(module);
    }

    @那么("{string}下拉列表显示正确:")
    public void 下拉列表显示正确(String module, String verification) {
        expect(mainPage.maintainPage().tmChamberPage().getModuleList(module)).should(verification);
    }

    @假如("{string}模块状态为maintain")
    public void 模块状态为maintain(String module) {
        mainPage.maintainPage().tmChamberPage().clickModule(module);
        mainPage.maintainPage().tmChamberPage().setMaintain(module);
    }

    @当("查看{string}页面")
    public void 查看页面(String module) {
        mainPage.maintainPage().tmChamberPage().clickModule(module);
    }

    @那么("{string}的{string}按钮处于使能状态,{string}按钮处于非使能状态")
    public void 的按钮处于使能状态按钮处于非使能状态(String module, String isClick, String notClick) {
        assertThat(mainPage.maintainPage().tmChamberPage().getButtonStatus(module, isClick)).isTrue();
        assertThat(mainPage.maintainPage().tmChamberPage().getButtonStatus(module, notClick)).isFalse();
    }

    @假如("{string}模块状态为maintain:")
    public void 模块状态为maintain2(String module) {
        mainPage.maintainPage().tmChamberPage().setMaintain(module);
    }

    @那么("{string}的{string}按钮处于使能状态,{string}按钮处于使能状态,{string}按钮处于使能状态")
    public void 的按钮处于使能状态按钮处于使能状态按钮处于使能状态(String module, String isClick1, String isClick2, String isClick3) {
        assertThat(mainPage.maintainPage().tmChamberPage().getButtonStatus(module, isClick1)).isTrue();
        assertThat(mainPage.maintainPage().tmChamberPage().getButtonStatus(module, isClick2)).isTrue();
        assertThat(mainPage.maintainPage().tmChamberPage().getButtonStatus(module, isClick3)).isTrue();
    }

    @那么("{string}页面存在按钮:")
    public void 页面存在按钮(String module, String verification) {
        expect(mainPage.maintainPage().tmChamberPage().getCenteringButton()).should(verification);
    }

    @假如("centering模块状态为maintain")
    public void centering模块状态为maintain() {
        mainPage.maintainPage().tmChamberPage().setCenteringMaintain();
    }

    @当("centering执行{string}操作")
    public void centering执行操作(String action) {
        mainPage.maintainPage().tmChamberPage().clickAction(action);
    }

    @那么("操作成功,Pin status状态为:")
    public void 操作成功PinStatus状态为(String verification) {
        expect(mainPage.maintainPage().tmChamberPage().gePinStatus()).should(verification);
        expect(mainPage.maintainPage().tmChamberPage().getCenteringPinStatus()).should(verification);
    }
}
