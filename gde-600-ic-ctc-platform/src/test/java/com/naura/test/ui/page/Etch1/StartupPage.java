package com.naura.test.ui.page.Etch1;

import com.naura.test.ui.driver.WinForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartupPage {

    @Autowired
    private WinForm winForm;

    @Autowired
    private Etch1MainPage etch1mainPage;

    public void launch() {
        winForm.elementByName("chkTm").click();
        winForm.elementByName("chkPm2").click();
        winForm.elementByName("btnStart").click();
        winForm.newPage();
        etch1mainPage.reset();
    }

    public void next() {
        winForm.elementByName("Next").click();
        winForm.newPage();
        etch1mainPage.login();
        etch1mainPage.reset();
    }
}