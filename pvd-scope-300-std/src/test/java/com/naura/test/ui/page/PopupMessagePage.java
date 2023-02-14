package com.naura.test.ui.page;

import com.naura.test.ui.driver.Window;

public class PopupMessagePage {
    private final Window.WindowOperation page;

    public PopupMessagePage(Window.WindowOperation page) {
        this.page = page;
    }

    public void clickOK() {
        page.elementById("mYes_btn").click();
    }

}
