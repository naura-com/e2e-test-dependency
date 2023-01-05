package com.naura.test.ui.page.PVD;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;

public class ConfigPage extends ParentPage {
    private final Window.WindowOperation page;

    private final WinForm winForm;

    public ConfigPage(Window.WindowOperation page, WinForm winForm) {
        super(new SetupPage(winForm.elementById("FormSetup"), winForm));
        this.page = page;
        this.winForm = winForm;
    }

    public SetupPage setupPage() {
        return switchTo(SetupPage.class, () -> page.elementById("mSetupSetup_navibtn").click(),
                () -> new SetupPage(winForm.elementById("FormSetup"), winForm));
    }

    public CleanParameter cleanParameter() {
        return switchTo(CleanParameter.class, () -> page.elementById("mSetupClean_navibtn").click(),
                () -> new CleanParameter(winForm.elementById("FormAutoClean_12K_sim"), winForm));
    }
}
