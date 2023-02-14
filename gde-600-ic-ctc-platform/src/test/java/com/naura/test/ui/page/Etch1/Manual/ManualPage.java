package com.naura.test.ui.page.Etch1.Manual;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;

public class ManualPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public ManualPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public ManualJobPage manualJobPage() {
        return switchTo(ManualJobPage.class, () -> winForm.elementById("Manual Job").click(),
                () -> new ManualJobPage(winForm.elementById("frmManualJob"), winForm));
    }

    public WaferSynchPage waferSynchPage() {
        return switchTo(WaferSynchPage.class, () -> winForm.elementById("Wafer Synchronization").click(),
                () -> new WaferSynchPage(winForm.elementById("frmWfrResync"), winForm));
    }

    public ManualMovePage manualMovePage() {
        return switchTo(ManualMovePage.class, () -> winForm.elementById("Manual Move").click(),
                () -> new ManualMovePage(winForm.elementById("frmManualMove"), winForm));
    }

    public ManualProcessPage manualProcessPage() {
        return switchTo(ManualProcessPage.class, () -> winForm.elementById("Manual Process").click(),
                () -> new ManualProcessPage(winForm.elementById("frmManualProcess"), winForm));
    }

}
