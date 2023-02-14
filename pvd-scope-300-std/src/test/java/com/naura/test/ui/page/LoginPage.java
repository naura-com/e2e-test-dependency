package com.naura.test.ui.page;

import com.naura.test.ui.driver.WinForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

    @Autowired
    private WinForm winForm;

    @Autowired
    private MainPage mainPage;

    public void login(String user, String password) {
        winForm.elementById("mUser_tb").sendKeys(user);
        winForm.elementById("mPassword_tb").sendKeys(password);
        winForm.elementByName("登录").click();
        winForm.newPage();
        winForm.newPage();
        mainPage.reset();
    }
}