package com.naura.test.ui;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static com.github.leeonky.dal.Assertions.expect;

public class SetupStep {

    @Autowired
    private MainPage mainPage;

    @Autowired
    private TestState testState;

    @Autowired
    private WinForm winForm;

    @Value("${app.path}")
    private String appPath;

    @Value("${app.name}")
    private String appName;

    @Value("${app.local-path}")
    private String localPath;

    @假如("在{string}的{string}中存在参数:")
    public void 在的中存在参数(String chamber, String parameter, DataTable table) {
        mainPage.configPage().setupPage().switchTo(chamber);
        mainPage.configPage().setupPage().switchTo(parameter);
        mainPage.configPage().setupPage().editParam(table);
        mainPage.configPage().setupPage().clickOperationButton("应用");
        mainPage.makeSure();
    }

    @当("修改{string}的当前数值为{string}")
    public void 修改的当前数值为(String paraName, String value) {
        mainPage.configPage().setupPage().modifyParam(paraName, value);
    }

    @那么("{string}的值为:")
    public void 的值为(String paraName, String verification) {
        expect(mainPage.configPage().setupPage().getCobData(paraName, "当前数值1(可编辑)")).should(verification);
    }

    @并且("执行{string}时")
    public void 执行时(String operation) {
        mainPage.configPage().setupPage().clickOperationButton(operation);
    }

    @那么("提示信息为:")
    public void 提示信息为(String verification) {
        expect(mainPage.getMessage()).should(verification);
    }

    @并且("{string}对应的通道值{string}为:")
    public void 对应的通道值为(String paraName, String channelName, String verification) {
        expect(mainPage.configPage().setupPage().getChannelData(channelName)).should(verification);
    }

    @并且("执行{string}并重启上位机后")
    public void 执行并重启上位机后(String operation) {
        mainPage.configPage().setupPage().clickOperationButton(operation);
        mainPage.makeSure();
        testState.restart("pe", "8888", () -> winForm.close(), appPath, appName, localPath);
    }

    @并且("执行{string}后执行{string}")
    public void 执行后执行(String operation1, String operation2) {
        mainPage.configPage().setupPage().clickOperationButton(operation1);
        mainPage.makeSure();
        mainPage.configPage().setupPage().clickOperationButton(operation2);
    }
}
