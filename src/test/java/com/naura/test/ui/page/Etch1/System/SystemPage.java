package com.naura.test.ui.page.Etch1.System;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;

public class SystemPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public SystemPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public ModuleStatusPage moduleStatusPage() {
        return switchTo(ModuleStatusPage.class, () -> winForm.elementById("Module Status").click(),
                () -> new ModuleStatusPage(winForm.elementById("frmModuleStatus"), winForm));
    }

    public ConfigPage configPage() {
        return switchTo(ConfigPage.class, () -> winForm.elementById("Config").click(),
                () -> new ConfigPage(winForm.elementById("frmConfiguration"), winForm));
    }
}
