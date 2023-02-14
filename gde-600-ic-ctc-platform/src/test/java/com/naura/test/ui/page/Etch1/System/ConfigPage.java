package com.naura.test.ui.page.Etch1.System;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfigPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public ConfigPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void setPostAlarmForExtraWafers() {
        if (page.elementById("cbPostAlarmforExtraWfr").getText().equals("true")) {
            page.elementById("cbPostAlarmforExtraWfr").click().sendKeys(String.valueOf(Keys.UP)).sendKeys(String.valueOf(Keys.ENTER));
            page.elementById("btnSave").click();
            page.elementByName("OK").click();
        }
    }

}
