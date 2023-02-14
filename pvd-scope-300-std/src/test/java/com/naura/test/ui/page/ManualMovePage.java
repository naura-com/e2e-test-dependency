package com.naura.test.ui.page;

import com.github.leeonky.util.NumberParser;
import com.naura.test.config.ContextWrapper;
import com.naura.test.api.api.LowerApi;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import lombok.SneakyThrows;

import java.util.List;
import java.util.stream.Collectors;

public class ManualMovePage {
    private final WinForm winForm;

    private final Window.WindowOperation page;

    private LowerApi lowerApi;

    private final NumberParser numberParser = new NumberParser();

    public ManualMovePage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
        lowerApi = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
    }

    private String moduleNameSwitch(String module) {
        switch (module) {
            case "Buffer":
                return "VTR1";
            case "Transfer":
                return "VTR2";
            case "LP1":
                return "LP3";
            case "LP3":
                return "LP1";
        }
        return module;
    }

    public void selectStartModule(String module) {
        module = moduleNameSwitch(module);
        page.elementById("mSrcNavi_12k").elementById(String.format("m%s_chamber", module)).click();
    }

    @SneakyThrows
    public List<Object> getSelectSlots() {
        return winForm.getDesktopDriver().findElementByName("上下文").findElementsByTagName("MenuItem").stream()
                .map(item -> parseValue(item.getText())).collect(Collectors.toList());
    }

    private Object parseValue(String text) {
        Number number = numberParser.parse(text);
        return number == null ? text : number;
    }

    @SneakyThrows
    public void selectSlot(String slot) {
        winForm.getDesktopDriver().findElementByName("上下文").findElementByName(slot).click();
    }

    public String getStartModuleText() {
        return page.elementById("mSrcMod_tb").getText();
    }

    public Object getStartPosText() {
        return page.elementById("mSrcPos_tb").getText();
    }

    public void selectEndModule(String module) {
        module = moduleNameSwitch(module);
        page.elementById("mDestNavi_12k").elementById(String.format("m%s_chamber", module)).click();
    }

    public Object getDestModuleText() {
        return page.elementById("mDestMod_tb").getText();
    }

    public Object getDestPosText() {
        return page.elementById("mDestPos_tb").getText();
    }

    public void clickManualMove() {
        page.elementById("mManualMove_btn").click();
    }

    public void selectBuffer(String module) {
        page.elementById("mLoadLock_cmb").click().elementByName(module).click();
    }

    public void selectTransfer(String module) {
        page.elementById("mBuffer_cmb").click().elementByName(module).click();
    }

    public Object getTaskName() {
        return page.elementById("mManualMove_dgv").getTableValue();
    }

    public Integer getTaskNum() {
        return page.elementById("mManualMove_dgv").getTableValue().size();
    }

    public Object getSlotText(String module, String slot) {
        return page.elementById(String.format("m%sSlot%sID_tb", module, slot)).getText();
    }
}
