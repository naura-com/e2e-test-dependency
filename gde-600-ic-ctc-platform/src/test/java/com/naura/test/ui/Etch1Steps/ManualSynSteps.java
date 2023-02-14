package com.naura.test.ui.Etch1Steps;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualSynSteps {
    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;


    @当("修改{string}的第{int}个CTC为{string}状态")
    public void 修改的第个Slot为状态(String LP, int slot, String status) {
        mainPage.manualPage().waferSynchPage().clickLP(LP);
        mainPage.manualPage().waferSynchPage().setCTCByNum(status,String.valueOf(slot - 1));
    }

    @那么("{string}的第{int}个CTC状态变为{string}状态")
    public void 的第个CTC状态变为状态(String LP, int slot, String status) {
        mainPage.manualPage().waferSynchPage().clickLP(LP);
        assertThat(mainPage.manualPage().waferSynchPage().sureCTCStatus(String.valueOf(slot - 1)).equals(status)).isTrue();
    }

    @那么("{string}的第{int}个Tool状态变为{string}状态")
    public void 的第个Tool状态变为状态(String LP, int tool, String status) {
        mainPage.manualPage().waferSynchPage().clickLP(LP);
        assertThat(mainPage.manualPage().waferSynchPage().sureToolStatus(String.valueOf(tool - 1)).equals(status)).isTrue();
    }

    @那么("{string}的第{int}个晶圆状态变为{string}状态")
    public void 的第个晶圆状态变为状态(String LP, int wafer, String status) {
        mainPage.manualPage().waferSynchPage().clickLP(LP);
        if(status.equals("none")) status="";
        assertThat(mainPage.manualPage().waferSynchPage().sureWaferStatus(String.valueOf(wafer - 1)).equals(status)).isTrue();
    }

    @那么("所有CTC全部是{string}状态")
    public void 所有CTC全部是状态(String status) {
        mainPage.manualPage().waferSynchPage().sureAllCTCstatus(status);
    }

    @当("修改{string}的所有CTC为{string}状态")
    public void 修改的所有CTC为状态(String LP, String status) {
        switch (status) {
            case "WAFER_ABSENT":
                mainPage.manualPage().waferSynchPage().allSetCTCAbsent(LP);
                break;
        }
    }

    @假如("{string}的第{int}个CTC本来为{string}状态")
    public void 的第个CTC本来为状态(String LP, int tool, String status) {
        mainPage.manualPage().waferSynchPage().clickLP(LP);
        mainPage.manualPage().waferSynchPage().setCTCByNum(status,String.valueOf(tool - 1));
    }

    @当("选择状态同步到CTC")
    public void 选择状态同步到ctc() {
        mainPage.manualPage().waferSynchPage().synWithCTC();
    }

    @当("选择状态同步到Tool")
    public void 选择状态同步到tool() {
        mainPage.manualPage().waferSynchPage().synWithTool();
    }

    @当("修改{string}的第{int}个晶圆为{string}状态")
    public void 修改的第个晶圆为状态(String LP, int wafer, String status) {
        mainPage.manualPage().waferSynchPage().clickLP(LP);
        mainPage.manualPage().waferSynchPage().setWaferStatus(String.valueOf(wafer - 1), status);
    }

    @当("修改{string}的所有晶圆为{string}状态")
    public void 修改的所有晶圆为状态(String LP, String status) {
        mainPage.manualPage().waferSynchPage().allSetWaferStatus(LP, status);
    }

    @那么("所有晶圆全部是{string}状态")
    public void 所有晶圆全部是状态(String status) {
        mainPage.manualPage().waferSynchPage().sureAllWaferStatus(status);
    }

}
