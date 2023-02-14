package com.naura.test.ui;

import com.naura.test.ui.page.MainPage;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class TransferPlatform {

    @Autowired
    private MainPage mainPage;

    @当("打开{string}的{string}阀门")
    public void 打开的阀门(String module, String valve) {
        mainPage.maintenancePage().transferPlatformPage().openValve(module, valve);
    }

    @那么("{string}的{string}阀门被打开")
    public void 的阀门被打开(String module, String valveName) {
        await().untilAsserted(() -> assertThat(mainPage.maintenancePage().transferPlatformPage().valveState(module, valveName))
                .isEqualTo("Opened"));
    }

    @当("关闭{string}的{string}阀门")
    public void 关闭的阀门(String module, String valve) {
        mainPage.maintenancePage().transferPlatformPage().closeValve(module, valve);
    }

    @那么("{string}的{string}阀门被关闭")
    public void 的阀门被关闭(String module, String valveName) {
        await().untilAsserted(() -> assertThat(mainPage.maintenancePage().transferPlatformPage().valveState(module, valveName))
                .isEqualTo("Closed"));
    }

    @当("选择{string}腔室并且执行{string}操作并确认时")
    public void 选择腔室并且执行操作并确认时(String chamber, String action) {
        mainPage.maintenancePage().transferPlatformPage().selectChamber(chamber);
        mainPage.maintenancePage().transferPlatformPage().doOperate(action);
        mainPage.maintenancePage().transferPlatformPage().makeSure();
    }

    @那么("{string}应为{string}")
    public void 应为(String name, String value) {
        assertThat(mainPage.maintenancePage().transferPlatformPage().getValue(name)).isEqualTo(value);
    }

    @当("选择{string}腔室并且执行{string}操作时")
    public void 选择腔室并且执行操作时(String chamber, String action) {
        mainPage.maintenancePage().transferPlatformPage().selectChamber(chamber);
        mainPage.maintenancePage().transferPlatformPage().doOperate(action);
    }

    @并且("设定为{string}且确认时")
    public void 设定为且确认时(String valueCount) {
        mainPage.maintenancePage().transferPlatformPage().setValue(valueCount);
        mainPage.maintenancePage().transferPlatformPage().makeSure();
    }

    @并且("设定{string}为{string},{string}为{string}")
    public void 设定为为(String time_name, String time_value, String temp_name, String temp_value) {
        mainPage.maintenancePage().transferPlatformPage().setTempValue(time_name, time_value, temp_name, temp_value);
        mainPage.maintenancePage().transferPlatformPage().makeSure();
    }

    @当("设定为{string}并且确认")
    public void 设定为并且确认(String mode) {
        mainPage.maintenancePage().transferPlatformPage().doOperate(mode);
        mainPage.maintenancePage().transferPlatformPage().makeSure();
    }
}
