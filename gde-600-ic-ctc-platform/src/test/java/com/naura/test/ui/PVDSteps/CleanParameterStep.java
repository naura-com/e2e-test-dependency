package com.naura.test.ui.PVDSteps;

import com.naura.test.ui.page.PVD.MainPage;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class CleanParameterStep {
    @Autowired
    private MainPage mainPage;

    @当("选择{string}左移到大于等于空闲配方时")
    public void 选择左移到大于等于空闲配方时(String rcpName) {
        mainPage.configPage().cleanParameter().RefreshRcp();
        mainPage.configPage().cleanParameter().selectRcp(rcpName);
        mainPage.configPage().cleanParameter().moveToGreaterThanIdleRcp();
    }

    @那么("大于等于空闲配方栏显示配方如下")
    public void 大于等于空闲配方栏显示配方如下(String verification) {
        expect(mainPage.configPage().cleanParameter().getGreaterThanIdleRcp()).should(verification);
    }

    @当("选择{string}右移出大于等于空闲配方时")
    public void 选择右移出大于等于空闲配方时(String rcpName) {
        mainPage.configPage().cleanParameter().removeFromGreaterThanIdleRcp();
    }

    @并且("选择{string}下移到小于空闲时间配方时")
    public void 选择下移到小于空闲时间配方时(String rcpName) {
        mainPage.configPage().cleanParameter().downToLessThanIdleRcp();
    }

    @并且("小于空闲配方栏显示配方如下")
    public void 小于空闲配方栏显示配方如下(String verification) {
        expect(mainPage.configPage().cleanParameter().getLessThanIdleRcp()).should(verification);
    }

    @当("选择{string}上移到大于等于空闲配方时")
    public void 选择上移到大于等于空闲配方时(String rcpName) {
        mainPage.configPage().cleanParameter().upToGreaterThanIdleRcp();
    }

    @当("执行{string}后")
    public void 执行后(String action) {
        mainPage.configPage().cleanParameter().RefreshRcp();
    }

    @那么("配方显示如下")
    public void 配方显示如下(String verification) {
        expect(mainPage.configPage().cleanParameter().getAllRcp()).should(verification);
    }

    @当("设置空闲时间为{string}时")
    public void 设置空闲时间为时(String time) {
        mainPage.configPage().cleanParameter().setIdleTime(time);
    }

    @那么("设置成功，空闲时间为{int}秒")
    public void 设置成功空闲时间为秒(int time) {
        assertThat(mainPage.configPage().cleanParameter().getIdleTime()).isEqualTo(Integer.toString(time));
    }

    @当("设置周期晶片数为{string}时")
    public void 设置周期晶片数为时(String waferCount) {
        mainPage.configPage().cleanParameter().setWaferCount(waferCount);
    }

    @那么("设置成功，周期晶片数为{int}")
    public void 设置成功周期晶片数为(int waferCount) {
        assertThat(mainPage.configPage().cleanParameter().getWaferCount()).isEqualTo(Integer.toString(waferCount));
    }

    @那么("设置失败，提示信息如下")
    public void 设置失败提示信息如下(String verification) {
        expect(mainPage.configPage().cleanParameter().getErrorProvider()).should(verification);
    }

    @当("执行保存时")
    public void 执行保存时() {
        mainPage.configPage().cleanParameter().saveRcp();
    }
}
