package com.naura.test.ui.page.Etch1.System;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

public class ModuleStatusPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public ModuleStatusPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    //    PM_tab LoadModule_tab TM_tab Append_tab
    public void clickPM2GDETab() {

        clickTabByElementAndOffset("PM_tab", 40, 15);
    }

    public void clickLATab() {
        clickTabByElementAndOffset("LoadModule_tab", 20, 15);
    }

    public void clickLBTab() {
        clickTabByElementAndOffset("LoadModule_tab", 55, 15);
    }

    public void clickLP1Tab() {
        clickTabByElementAndOffset("LoadModule_tab", 90, 15);
    }

    public void clickLP2Tab() {
        clickTabByElementAndOffset("LoadModule_tab", 130, 15);
    }

    public void clickVBETab() {
        clickTabByElementAndOffset("TM_tab", 75, 15);
    }

    public void clickAlignerTab() {
        clickTabByElementAndOffset("Append_tab", 40, 15);
    }

    public void clickCenteringTab() {
        clickTabByElementAndOffset("Append_tab", 100, 15);
    }

    public void Initialize_1() {
        winForm.elementById("PM_tab").selectByName("Initialize");
    }

    public void Initialize_2() {
        winForm.elementById("LoadModule_tab").selectByName("Initialize");
    }

    public void Initialize_3() {
        winForm.elementById("TM_tab").selectByName("Initialize");
    }

    public void Initialize_4() {
        winForm.elementById("Append_tab").selectByName("Initialize");
    }

    private void clickTabByElementAndOffset(String element, int x, int y) {
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById(element).getElement(), x, y).click().click().perform();
    }

    public String pmStatus() {
        return winForm.elementById("PM_tab").elementByTag("Edit").getText().toString();
    }

    public String loadModuleStatus() {
        return winForm.elementById("LoadModule_tab").elementByTag("Edit").getText().toString();
    }

    public String tmStatus() {
        return winForm.elementById("TM_tab").elementByTag("Edit").getText().toString();
    }

    public String appendStatus() {
        return winForm.elementById("Append_tab").elementByTag("Edit").getText().toString();
    }

    public void initialize() {
        initModule();
        initComplete();
    }

    public void initModule() {
        clickPM2GDETab();
        if (!pmStatus().equals("standby"))
            Initialize_1();
        clickLATab();
        if (!loadModuleStatus().equals("standby"))
            Initialize_2();
        clickLBTab();
        if (!loadModuleStatus().equals("standby"))
            Initialize_2();
        clickLP1Tab();
        if (!loadModuleStatus().equals("standby"))
            Initialize_2();
        clickLP2Tab();
        if (!loadModuleStatus().equals("standby"))
            Initialize_2();
        clickVBETab();
        if (!tmStatus().equals("standby"))
            Initialize_3();
        clickAlignerTab();
        if (!appendStatus().equals("standby"))
            Initialize_4();
        clickCenteringTab();
        if (!appendStatus().equals("standby"))
            Initialize_4();
    }

    public void initComplete() {
        while (true) {
            if (pmStatus().equals("standby"))
                break;
        }
    }

}
