package com.naura.test.ui.page.Etch1.Edit;

import com.naura.test.api.api.LowerApi;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.FileOption;
import com.naura.test.ui.page.ParentPage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;

public class RecipeComparePage extends ParentPage {

    @Autowired
    WinForm winForm;

    @Autowired
    LowerApi lowerApi;

    @Autowired
    FileOption fileOption = new FileOption();

    private final Window.WindowOperation page;

    public RecipeComparePage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void clickAction(String action) {
        page.elementByName(action).click();
    }

    public void clickId(String id) {
        winForm.elementById(id).click();
    }

    public void chooseValue(String module, String value) {
        if (value == null) {
            value = "";
        }
        switch (module) {
            case "Choose PM A":
                setModuleValue("comboPMa", value);
                break;
            case "Choose RecipeType A":
                setModuleValue("cmbrcptypeA", value);
                break;
            case "Choose Recipe A":
                setModuleValue("cmbrcpA", value);
                break;
            case "Choose PM B":
                setModuleValue("comboPMb", value);
                break;
            case "Choose RecipeType B":
                setModuleValue("cmbrcptypeB", value);
                break;
            case "Choose Recipe B":
                setModuleValue("cmbrcpB", value);
                break;
            case "Page":
                setModuleValue("cmbpage", value);
                break;
        }
    }

    public void setModuleValue(String id, String value) {
        //TODO value.isEmpty()->value==null
        if (value.isEmpty()) {
            if (!winForm.elementById(id).getText().isEmpty()) {
                winForm.elementById(id).click().click();
            }
        } else {
            Window.WindowOperation chooseRcpA = winForm.elementById(id).elementByName("打开").click();
            while (true) {
                if (winForm.elementById(id).getText().equals(value)) {
                    break;
                } else {
                    (chooseRcpA.sendKeys(String.valueOf(Keys.DOWN))).sendKeys(String.valueOf(Keys.ENTER));
                }
            }
        }
    }

    public void clickCmb(String action) {
        if (!winForm.elementByName(action).isSelect()) {
            clickAction(action);
        }
    }

    public void clean(String id) {
        if (!winForm.elementById(id).getText().isEmpty()) {
            winForm.elementById(id).click().click();
        }
    }

    public void compareRecipe(String pmVal, String rcpTypeVal, String rcp1Val, String rcp2Val, String type) {
        chooseValue("Choose PM A", pmVal);
        chooseValue("Choose RecipeType A", rcpTypeVal);
        chooseValue("Choose Recipe A", rcp1Val);
        chooseValue("Choose PM B", pmVal);
        chooseValue("Choose RecipeType B", rcpTypeVal);
        chooseValue("Choose Recipe B", rcp2Val);
        chooseValue("Page", "SetPoint");
        clickCmb(type);
        clickId("btnCmp");
    }

    public void clickRecipe(String action) {
        if (action.equals("Choose Recipe A")) {
            clickId("cmbrcpA");
        } else if (action.equals("Choose Recipe B")) {
            clickId("cmbrcpB");
        } else {
            clickAction(action);
        }
    }

    public void cleanRecipe() {
        clean("cmbrcpA");
        clean("cmbrcptypeA");
        clean("comboPMa");
        clean("cmbrcpB");
        clean("cmbrcptypeB");
        clean("comboPMb");
        winForm.elementById("frmRecipeCompare").click();
    }

    public void compare(DataTable dataTable) {
        slectRcp(dataTable);
        clickId("btnCmp");
    }

    private void slectRcp(DataTable dataTable) {
        dataTable.asMaps().forEach(map ->
        {
            chooseValue(map.get("condition") + " A", map.get("A"));
            chooseValue(map.get("condition") + " B", map.get("B"));
        });
    }

    public void selectPageAndCompare(String page, DataTable dataTable) {
        slectRcp(dataTable);
        chooseValue("Page", page);
        clickId("btnCmp");
    }
}
