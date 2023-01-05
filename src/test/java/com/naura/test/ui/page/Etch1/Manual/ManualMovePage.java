package com.naura.test.ui.page.Etch1.Manual;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ManualMovePage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public ManualMovePage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void clickAction(String action) {
        winForm.elementByName(action).click();
    }

    public void clickId(String id) {
        winForm.elementById(id).click();
    }

    private void clickByOffset(int x, int y, String eleName) {
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementByName(eleName).getElement(), x, y).click().click().perform();
    }

    public void seleteModule(String module, String name) {
        switch (module) {
            case "PM2":
                clickByOffset(70, 90, name);
                break;
            case "TM":
                clickByOffset(120, 130, name);
                break;
            case "AL":
                clickByOffset(105, 170, name);
                break;
            case "Center":
                clickByOffset(180, 130, name);
                break;
            case "LA":
                clickByOffset(80, 190, name);
                break;
            case "LB":
                clickByOffset(130, 190, name);
                break;
        }
    }

    public List<Object> getPositionList(String type) {
        List<Object> positionList = new ArrayList<>();
        Window.WindowOperation windowOperation = page.elementById(getPositionId(type)).elementByName("打开").click();
        for (int i = 0; i < 30; i++) {
            Object value = page.elementById(getPositionId(type)).getText();
            if (positionList.contains(value)) {
                break;
            }
            positionList.add(value);
            windowOperation.sendKeys(String.valueOf(Keys.DOWN));
        }
        page.elementById(getPositionId(type)).elementByName("关闭").click();
        return positionList;
    }

    public Object getModuleInfo(String type) {
        switch (type) {
            case "Source":
                return page.elementById("txtSrcMod").getText();
            case "Destination":
                return page.elementById("txtDestMod").getText();
        }
        return null;
    }

    public void setPosition(String position, String type) {
        Window.WindowOperation windowOperation = page.elementById(getPositionId(type)).elementByName("打开").click();
        if (position.isEmpty()) {
            page.elementById(getPositionId(type)).clear().sendKeys(String.valueOf(Keys.ENTER));
        } else {
            for (int i = 0; i < 30; i++) {
                if (page.elementById(getPositionId(type)).getText().equals(position)) {
                    break;
                }
                (windowOperation.sendKeys(String.valueOf(Keys.DOWN))).sendKeys(String.valueOf(Keys.ENTER));
            }
        }
    }

    private String getPositionId(String type) {
        if (type.equals("Source")) {
            return "combSrcPos";
        } else if (type.equals("Destination")) {
            return "combDestPos";
        }
        return null;
    }
}
