package com.naura.test.ui.page.Etch1.Maintain;

import com.naura.test.ui.driver.ImageValueMaps;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;

public class TMVacuumPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    private Window.WindowOperation desktopPage;

    public TMVacuumPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void newDesktopPage(String name, String id) {
        if (name.equals(""))
            desktopPage = new Window.WindowOperation(winForm.getDesktopDriver().findElementById(id));
        else
            desktopPage = new Window.WindowOperation(winForm.getDesktopDriver().findElementByName(name));
    }

    private String transformTextId(String elementName) {
        switch (elementName) {
            case "TC Slow Vent":
                return "gasValve11";
            case "TC Fast Vent":
                return "gasValve5";
            case "TC Slow Rough":
                return "gasValve12";
            case "TC Fast Rough":
                return "gasValve6";
            case "LA Slow Vent":
                return "gasValve9";
            case "LA Fast Vent":
                return "gasValve10";
            case "LA Slow Rough":
                return "gasValve2";
            case "LA Fast Rough":
                return "gasValve1";
            case "LB Slow Vent":
                return "gasValve7";
            case "LB Fast Vent":
                return "gasValve8";
            case "LB Slow Rough":
                return "gasValve3";
            case "LB Fast Rough":
                return "gasValve4";
            case "DryPump":
                return "roughPump2";
            default:
                throw new RuntimeException("未知控件名" + elementName);
        }
    }

    public void setValve(String valveName, String valveState) {
        setState(valveName, "TmValve", valveState);
    }

    private void setState(String elementName, String elementPage, String state) {
        page.elementById(transformTextId(elementName)).click();
        newDesktopPage(elementPage, "");
        desktopPage.elementByName(state).click();
        desktopPage.elementByName("Run").click();
    }

    public String serviceValveState() {
        return desktopPage.elementByName("gasValve1").getImageValue(ImageValueMaps.VALVEEtch1);
    }

    public void serviceOperation(String operation) {
        desktopPage.elementByName(operation).click();
    }

    public String controlState(String valveName) {
        return page.elementById(transformTextId(valveName)).getImageValue(ImageValueMaps.VALVEEtch1);
    }

    public void setMaintain(String module) {
        page.elementById("btn_Maintain" + module).click();
    }

    public void setDryPump(String pumpState) {
        setState("DryPump", "Chamber DryPump", pumpState);
    }

    public String serviceDryPumpState() {
        return desktopPage.elementByName("roughPump1").getImageValue(ImageValueMaps.VALVEEtch1);
    }

    public void runOperation(String module, String service) {
        if (module.equals("TC"))
            module = " " + module;
        page.elementByName(module + " Operation").elementByTag("ComboBox").click();
        winForm.getDesktopDriver().findElementByXPath(String.format("//ListItem[@Name='%s']", service)).click();
        page.elementByName(module + " Operation").elementByName("Run").click();
    }
}
