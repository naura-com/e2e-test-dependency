package com.naura.test.ui.page.Etch1.Setup;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;

public class SetupPage2 extends ParentPage {

    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public SetupPage2(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public PM2Page pm2Page() {
        return switchTo(PM2Page.class,()->winForm.elementById("bitbtnPM2").click(),
                ()->new PM2Page(winForm.elementById("tableLayoutPanel1"),winForm));
    }
}
