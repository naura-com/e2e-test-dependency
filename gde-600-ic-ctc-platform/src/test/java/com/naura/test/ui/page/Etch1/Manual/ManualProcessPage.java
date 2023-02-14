package com.naura.test.ui.page.Etch1.Manual;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;

public class ManualProcessPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public ManualProcessPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void clickAction(String action) {
        page.elementByName(action).click();
    }

    public void clickId(String id) {
        winForm.elementById(id).click();
    }

    public void selectRecipe(String recipe) {
        if (recipe.isEmpty()) {
            winForm.elementById("tipComboBoxRecipeList").click().click();
        } else {
            Window.WindowOperation recipeList = winForm.elementById("tipComboBoxRecipeList").elementByName("打开").click();
            while (true) {
                if (winForm.elementById("tipComboBoxRecipeList").getText().equals(recipe)) {
                    break;
                } else {
                    (recipeList.sendKeys(String.valueOf(Keys.DOWN))).sendKeys(String.valueOf(Keys.ENTER));
                }
            }
        }
    }

    public Map<Object, Object> getRecipInfo() {
        Map<Object, Object> map = new HashMap<>();
        try {
            await().timeout(Duration.ofSeconds(500)).untilAsserted(() -> assertThat(winForm.elementById("txtToolSts").getText().equals("Idle")).isTrue());
            map.put("RecipeName", page.elementById("textBox_RecipeName").getText());
            map.put("ProcessStatus", page.elementById("textBox_ProcessStatus").getText());
            map.put("ProcessTime", page.elementById("textbox_ProcessTime").getText());
        } catch (Exception e) {
        }
        return map;
    }

    public Map<Object, Object> getStepInfo() {
        Map<Object, Object> map = new HashMap<>();
        try {
            await().timeout(Duration.ofSeconds(100)).untilAsserted(() -> assertThat(winForm.elementById("txtToolSts").getText().equals("Idle")).isTrue());
            map.put("StepId", page.elementById("textBox_StepId").getText());
            map.put("StepName", page.elementById("textBox_StepName").getText());
            map.put("EndType", page.elementById("textBox_EndType").getText());
            map.put("StepTime", page.elementById("textBox_StepTime").getText());
            map.put("ElapseTime", page.elementById("textBox_ElapseTime").getText());
        } catch (Exception e) {
        }
        return map;
    }

    public List<Object> getRecipeList() {
        List<Object> recipeLists = new ArrayList<>();
        Window.WindowOperation recipeList = winForm.elementById("tipComboBoxRecipeList").elementByName("打开").click();
        while (true) {
            if (recipeLists.contains(winForm.elementById("tipComboBoxRecipeList").getText())) {
                break;
            } else if (winForm.elementById("tipComboBoxRecipeList").getText().isEmpty()) {
                (recipeList.sendKeys(String.valueOf(Keys.DOWN))).sendKeys(String.valueOf(Keys.ENTER));
            } else {
                recipeLists.add(winForm.elementById("tipComboBoxRecipeList").getText());
                (recipeList.sendKeys(String.valueOf(Keys.DOWN))).sendKeys(String.valueOf(Keys.ENTER));
            }
        }
        return recipeLists;
    }

    public void crateProcessSts(String recipe, String status) {
        selectRecipe(recipe);
        clickAction("Run Process");
        clickId("button_Yes");
        while (true) {
            if (page.elementById("textBox_ProcessStatus").getText().equals(status)) {
                break;
            }
        }
    }

    public Object getManualEndpointVer() {
        Object info = winForm.elementById("popupMaintManualEPD").elementById("label1").getText();
        clickId("btnClose");
        return info;
    }

    public boolean comElapseTimeAndStepTime() {
        return page.elementById("textBox_StepTime").getText().equals(page.elementById("textBox_ElapseTime").getText());
    }

    public void stepManualEndpoint(String step, String action) {
        try {
            await().timeout(Duration.ofSeconds(500)).untilAsserted(() -> assertThat(page.elementById("textBox_StepId").getText().equals(step)).isTrue());
            clickAction(action);
            clickId("btnRun");
        } catch (Exception e) {
            throw e;
        }
    }

    public void manualProcessOperation(String recipe, String action) {
        selectRecipe(recipe);
        clickAction(action);
    }

    public void statusRcpManualProcessOperationConfirm(String status, String recipe, String action) {
        crateProcessSts(recipe, status);
        confirmOperation(action, "button_Yes");
    }

    public void statusRcpManualProcessOperation(String status, String recipe, String action) {
        crateProcessSts(recipe, status);
        clickAction(action);
    }

    public void confirmOperation(String action, String button_Yes) {
        clickAction(action);
        clickId(button_Yes);
    }

    public void confirmManualProcessOperation(String recipe, String action) {
        manualProcessOperation(recipe, action);
        confirmOperation(action, "button_Yes");
    }

    public void statusStepManualProcessOperation(String status, String recipe, String step, String action) {
        crateProcessSts(recipe, status);
        stepManualEndpoint(step, action);
    }
}
