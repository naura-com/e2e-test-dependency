package com.naura.test.ui.page;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CleanParameter {

    private final WinForm winForm;

    private final Window.WindowOperation page;

    public CleanParameter(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void RefreshRcp() {
        page.elementByName("刷新配方").click();
    }

    public void selectRcp(String rcpName) {
        page.elementByName(rcpName).click();
    }

    public void moveToGreaterThanIdleRcp() {
        page.elementById("mIdleRcpAdd11_btn").click();
    }

    public void removeFromGreaterThanIdleRcp() {
        page.elementById("mIdleRcpRmv11_btn").click();
    }

    public void moveToLessThanIdleRcp() {
        page.elementById("mShortIdleRcpAdd11_btn").click();
    }

    public void removeFromLessThanIdleRcp() {
        page.elementById("mShortIdleRcpRmv11_btn").click();
    }

    public void moveToPeriodRcp() {
        page.elementById("mPeriodicRcpAdd11_btn").click();
    }

    public void removeFromPeriodRcp() {
        page.elementById("mPeriodicRcpRmv11_btn").click();
    }

    public void downToLessThanIdleRcp() {
        page.elementById("mIdle2Short11_btn").click();
    }

    public void downToPeriodRcp() {
        page.elementById("mShort2Periodic11_btn").click();
    }

    public void upToLessThanIdleRcp() {
        page.elementById("mPeriodic2Short11_btn").click();
    }

    public void upToGreaterThanIdleRcp() {
        page.elementById("mShort2Idle11_btn").click();
    }

    public List<Object> getGreaterThanIdleRcp() {
        return page.elementById("mIdleRcpList11_lb").getListValue();
    }

    public List<Object> getLessThanIdleRcp() {
        return page.elementById("mShortIdleRcpList11_lb").getListValue();
    }

    public List<Object> getPeriodRcp() {
        return page.elementById("mPeriodicRcpList11_lb").getListValue();
    }

    public String[] getAllRcp() {
        return page.elementById("mRcpList11_lb").getListValue().toArray(new String[0]);
    }

    public void setIdleTime(String time) {
        page.elementById("mIdleTime_stb").click();
        if (!winForm.elementById("mParam_tb").getText().isEmpty()) {
            winForm.elementById("mParam_tb").clear();
        }
        winForm.elementById("mParam_tb").sendKeys(time);
        winForm.elementByName("确定").click();
    }

    public String getIdleTime() {
        return page.elementById("mIdleTime_stb").getText();
    }

    public void setWaferCount(String waferCount) {
        page.elementById("mCycMatCount_stb").click();
        if (!winForm.elementById("mParam_tb").getText().isEmpty()) {
            winForm.elementById("mParam_tb").clear();
        }
        winForm.elementById("mParam_tb").sendKeys(waferCount);
        winForm.elementByName("确定").click();
    }

    public String getWaferCount() {
        return page.elementById("mCycMatCount_stb").getText();

    }

    public String getErrorProvider() {
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("mParam_tb").getElement()).moveByOffset((winForm.elementById("mParam_tb").getElement().getSize().width / 2) + 5, 0).perform();
        return winForm.getErrorProviderInfo();
    }

    public void saveRcp() {
        page.elementById("mSave11_btn").click();
        winForm.elementByName("确定").click();
    }
}