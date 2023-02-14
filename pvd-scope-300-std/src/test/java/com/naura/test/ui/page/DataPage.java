package com.naura.test.ui.page;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;

public class DataPage extends ParentPage {
    private final Window.WindowOperation page;
    private final WinForm winForm;

    public DataPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public DataProcessPage dataProcessPage() {
        return switchTo(DataProcessPage.class, () -> page.elementById("mDataLogProc_navibtn").click(),
                () -> new DataProcessPage(winForm.elementById("FormMaterialLog"), winForm));
    }
}
