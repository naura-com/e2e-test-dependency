package com.naura.test.ui.page;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import org.springframework.beans.factory.annotation.Autowired;

public class PopupNewRcpPage extends ParentPage {

    @Autowired
    WinForm winForm;

    private final Window.WindowOperation page;

    public PopupNewRcpPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void sendKey(String name) {
        page.elementById("mRcpName_tb").sendKeys(name);
        popupMessagePageSendKeyOk().clickOK();
    }

    public PopupMessagePage popupMessagePageSendKeyOk() {
        return switchTo(PopupMessagePage.class, () -> page.elementById("mOK_btn").click(),
                () -> new PopupMessagePage(winForm.elementById("PopupMessage")));
    }
}
