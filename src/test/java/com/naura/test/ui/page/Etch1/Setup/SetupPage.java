package com.naura.test.ui.page.Etch1.Setup;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;

public class SetupPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public SetupPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public SetupPage2 setupPage2() {
        return switchTo(SetupPage2.class,()->winForm.elementById("Setup").click(),
                ()->new SetupPage2(winForm.elementById("panel4"),winForm));
    }
}
