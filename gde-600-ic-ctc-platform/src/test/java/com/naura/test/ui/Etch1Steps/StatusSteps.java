package com.naura.test.ui.Etch1Steps;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import com.naura.test.ui.page.FileOption;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.Assertions.assertThat;

public class StatusSteps {
    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;

    private FileOption fileOption = new FileOption();

    @那么("界面出现报警项目{string}")
    public void 界面出现报警项目(String alarmName) {
        assertThat(mainPage.alarmPage().statusPage().alarmExist(alarmName)).isTrue();
    }

    @并且("清除界面上{string}的报警项目")
    public void 清除界面上的报警项目(String alarmName) {
        mainPage.alarmPage().statusPage().alarmClear(alarmName);
    }

    @那么("界面上没有报警项目{string}")
    public void 界面上没有报警项目(String alarmName) {
        assertThat(mainPage.alarmPage().statusPage().alarmUnExist(alarmName)).isTrue();
    }

    @那么("报警{string}的信息描述部分如下:")
    public void 报警的信息描述部分如下(String alarmName, String ver) {
        expect(mainPage.alarmPage().statusPage().alarmInfo(alarmName)).should(ver);
    }

    @假如("存在可导入文件{string}包含内容:")
    public void 存在可导入文件包含内容(String path, Table table) {
        fileOption.alarmImportFile(path, table);
    }

    @当("导入Alarm文件{string}时")
    public void 导入alarm文件时(String path) {
        mainPage.alarmPage().queryPage().findFile(path);
    }

    @假如("存在可导入非法文件{string}")
    public void 存在可导入非法文件(String path) {
        fileOption.alarmImportUselessFile(path);
    }
}
