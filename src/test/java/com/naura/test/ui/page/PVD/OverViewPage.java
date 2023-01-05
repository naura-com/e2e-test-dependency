package com.naura.test.ui.page.PVD;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;

public class OverViewPage extends ParentPage {
    private final Window.WindowOperation page;
    private final WinForm winForm;

    public OverViewPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public FootprintPage footprintPage() {
        return switchTo(FootprintPage.class, () -> page.elementById("mSystemInit_navibtn").click(),
                () -> new FootprintPage(winForm.elementById("pnlFootprint"), winForm));
    }

    public ManualMovePage manualMovePage() {
        return switchTo(ManualMovePage.class, () -> winForm.elementById("mOverview_ctrl").elementByName("     手动传输     ").click(),
                () -> new ManualMovePage(winForm.elementById("mManualMove_tbp"), winForm));
    }

    public InitPage initPage() {
        return switchTo(InitPage.class, () -> winForm.elementById("mOverview_ctrl").elementByName("     初始化     ").click(),
                () -> new InitPage(winForm.elementById("mInit_tbp"), winForm));
    }
}
