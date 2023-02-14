package com.naura.test.ui.page.Etch1.Maintain;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TMChamberPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public TMChamberPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public List<Object> getModuleList(String module) {
        switch (module) {
            case "LP1":
                return getCmbList("LP1Methods");
            case "LP2":
                return getCmbList("LP2Methods");
            case "LA":
                return getCmbList("LAMethods");
            case "LB":
                return getCmbList("LBMethods");
            case "PM2":
                return getCmbList("PM2Methods");
            case "VACRobot":
                return getCmbList("VACMethods");
            case "Aligner":
                return getCmbList("AlignerMethods");
            case "OLA":
                return getCmbList("OLAMethods");
            case "OLB":
                return getCmbList("OLBMethods");
            case "LPI1":
                return getCmbList("OLPI1Methods");
            case "LPI2":
                return getCmbList("OLPI2Methods");
            case "ATP":
                return getCmbList("ATPMethods");
        }
        return null;
    }

    private void clickTabByElementAndOffset(String element, int x, int y) {
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementByName(element).getElement(), x, y).click().click().perform();
    }

    private List<Object> getCmbList(String moduleid) {
        List<Object> list = new ArrayList<>();
        Window.WindowOperation moduleText = page.elementById(moduleid).click().click();
        while (true) {
            moduleText.sendKeys(String.valueOf(Keys.DOWN));
            if (list.contains(page.elementById(moduleid).getText())) {
                break;
            } else {
                list.add(page.elementById(moduleid).getText());
            }
        }
        return list;
    }

    public void clickModule(String module) {
        switch (module) {
            case "LP1":
                clickTabByElementAndOffset("LoadPort Operations", 140, 30);
                break;
            case "LP2":
                clickTabByElementAndOffset("LoadPort Operations", 180, 30);
                break;
            case "LA":
                clickTabByElementAndOffset("SlotValve Operations", 140, 30);
                break;
            case "LB":
                clickTabByElementAndOffset("SlotValve Operations", 170, 30);
                break;
            case "PM2":
                clickTabByElementAndOffset("SlotValve Operations", 210, 30);
                break;
            case "VACRobot":
                clickTabByElementAndOffset("Other Operations", 50, 30);
                break;
            case "Aligner":
                clickTabByElementAndOffset("Other Operations", 110, 30);
                break;
            case "OLA":
                clickTabByElementAndOffset("Other Operations", 160, 30);
                break;
            case "OLB":
                clickTabByElementAndOffset("Other Operations", 200, 30);
                break;
            case "LPI1":
                clickTabByElementAndOffset("Other Operations", 230, 30);
                break;
            case "LPI2":
                clickTabByElementAndOffset("Other Operations", 280, 30);
                break;
            case "ATP":
                clickTabByElementAndOffset("Other Operations", 320, 30);
                break;
            case "Centering":
                clickTabByElementAndOffset("simpleTabOthers", 420, 15);
                clickTabByElementAndOffset("Other Operations", 320, 30);
                break;
        }
    }

    public void setMaintain(String module) {
        switch (module) {
            case "LP1":
                page.elementById("btnLP1Maint").click();
                winForm.elementById("button_Yes").click();
                break;
            case "LP2":
                page.elementById("btnLP2Maint").click();
                winForm.elementById("button_Yes").click();
                break;
            case "VBE":
                page.elementById("btnTMMaint").click();
                winForm.elementById("button_Yes").click();
                break;
        }
    }

    public boolean getButtonStatus(String module, String button) {
        return isEnabled(getmoduleId(module), button);
    }

    private boolean isEnabled(String id, String button) {
        return page.elementById(id).elementByName(button).isEnabled();
    }

    public String getmoduleId(String module) {
        switch (module) {
            case "LP1":
                return "LP1_tab";
            case "LP2":
                return "LP2_tab";
            case "LA":
                return "Box1TabLA";
            case "LB":
                return "Box1TabLB";
            case "PM2":
                return "Box1TabPM2";
            case "VACRobot":
                return "Box4TabVAC";
            case "Aligner":
                return "Box4TabAligner";
            case "OLA":
                return "Box4TabLA";
            case "OLB":
                return "Box4TabLB";
            case "LPI1":
                return "Box4TabLPI1";
            case "LPI2":
                return "Box4TabLPI2";
            case "ATP":
                return "Box4TabATP";
            case "Centering":
                return "simpleTabPage_Centering";
        }
        return null;
    }

    public List<Object> getCenteringButton() {
        List<Object> buttons = new ArrayList<>();
        for (int i = 0; i < page.elementById("simpleTabPage_Centering").elementsByTag("Pane").size(); i++) {
            buttons.add(page.elementById("simpleTabPage_Centering").elementsByTag("Pane").get(i).getText());
        }
        return buttons;
    }

    public void setCenteringMaintain() {
        clickModule("Centering");
        page.elementById("button_Centering").click();
        winForm.elementById("button_Yes").click();
    }

    public Object gePinStatus() {
        return page.elementById("pinStatus").getText();
    }

    public Object getCenteringPinStatus() {
        return page.elementById("superTextBox_CenteringPinStatus").getText();
    }

    public void clickAction(String action) {
        page.elementByName(action).click();
    }
}
