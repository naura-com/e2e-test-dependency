package com.naura.test.ui.PVDSteps;

import com.naura.test.ui.page.PVD.MainPage;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaintainStep {

    @Autowired
    private MainPage mainPage;

    @假如("啥也不干")
    public void doNothing() throws InterruptedException {
        TimeUnit.DAYS.sleep(1);
    }

    @当("选择{string}腔室并执行{string}操作并确认时")
    public void 选择腔室并执行操作并确认时(String chamber, String action) {
        mainPage.maintenancePage().maintChamberPage().selectChamber(chamber);
        mainPage.maintenancePage().maintChamberPage().doOperate(action);
        mainPage.maintenancePage().maintChamberPage().makeSure();
    }

    @那么("{string}为{string}")
    public void 为(String name, String value) {
        assertThat(mainPage.maintenancePage().maintChamberPage().getValue(name)).isEqualTo(value);
    }

    @当("设置为{string}并确认时")
    public void 设置为并确认时(String valueCount) {
        mainPage.maintenancePage().maintChamberPage().setValue(valueCount);
        mainPage.maintenancePage().maintChamberPage().makeSure();
    }

    @那么("设置成功,且{string}为{string}")
    public void 设置成功且物料数量为(String name, String valueCount) {
        assertThat(mainPage.maintenancePage().maintChamberPage().getValue(name)).isEqualTo(valueCount);
    }

    @当("设置为{string}时")
    public void 设置为时(String valueCount) {
        mainPage.maintenancePage().maintChamberPage().setValue(valueCount);
    }

    @那么("{string}设定失败，提示信息如下")
    public void 设定失败提示信息如下(String errorType, String verification) {
        expect(mainPage.maintenancePage().maintChamberPage().getErrorProvider(errorType)).should(verification);
    }

    @假如("选择{string}腔室并执行{string}操作时")
    public void 选择腔室并执行操作时(String chamber, String action) {
        mainPage.maintenancePage().maintChamberPage().selectChamber(chamber);
        mainPage.maintenancePage().maintChamberPage().doOperate(action);
    }

    @并且("设置开始位置为{string},结束位置为{string},测试次数为{int},延迟为{int}s且确认")
    public void 设置开始位置为结束位置为测试次数为延迟为S且确认(String startPos, String endPos, int testCount, int delayTime) {
        mainPage.maintenancePage().maintChamberPage().setPedestal(startPos, endPos, testCount, delayTime);
        mainPage.maintenancePage().maintChamberPage().makeSure();
    }

    @并且("结束后{string}为{int}")
    public void 结束后为(String name, int total) {
        assertThat(mainPage.maintenancePage().maintChamberPage().getValue(name)).isEqualTo(Integer.toString(total));
    }

    @并且("设定{string}的压力值为{string}并确认")
    public void 设定的压力值为并确认(String mode, String pressureValue) {
        mainPage.maintenancePage().maintChamberPage().setVacChuckValue(mode, pressureValue);
        mainPage.maintenancePage().maintChamberPage().makeSure();
    }

    @并且("设定为{string}并确认")
    public void 设定为并确认(String mode) {
        mainPage.maintenancePage().maintChamberPage().doOperate(mode);
        mainPage.maintenancePage().maintChamberPage().makeSure();
    }

    @并且("{string}变为{string}")
    public void 变为(String name, String mode) {
        assertThat(mainPage.maintenancePage().maintChamberPage().getMode(name, mode)).isEqualTo(mode);
    }

    @假如("选择{string}腔室并进入{string}界面时")
    public void 选择腔室并进入界面时(String chamber, String tag) {
        mainPage.maintenancePage().maintChamberPage().selectChamber(chamber);
        mainPage.maintenancePage().maintChamberPage().selectTag(tag);
    }

    @当("执行{string}操作后")
    public void 执行操作后(String action) {
        mainPage.maintenancePage().maintChamberPage().doOperate(action);
    }

    @并且("设置{string}为{string},{string}为{string}")
    public void 设置为为(String p_Name, String p_Value, String a_Name, String a_Value) {
        mainPage.maintenancePage().maintChamberPage().setPowerValue(p_Name, p_Value, a_Name, a_Value);
        mainPage.maintenancePage().maintChamberPage().makeSure();
    }

    @并且("{string}C1为{string},{string}C2为{string}")
    public void 设置C1为C2为(String mode1, String c1_value, String mode2, String c2_value) {
        mainPage.maintenancePage().maintChamberPage().setMatchValue(mode1, mode2, c1_value, c2_value);
    }

    @并且("关闭{string}服务")
    public void 关闭服务(String action) {
        mainPage.maintenancePage().maintChamberPage().doOperate(action);
        mainPage.maintenancePage().maintChamberPage().makeSure();
    }
}
