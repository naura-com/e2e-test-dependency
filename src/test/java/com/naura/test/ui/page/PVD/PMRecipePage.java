package com.naura.test.ui.page.PVD;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class PMRecipePage {
    @Autowired
    WinForm winForm;

    private final Window.WindowOperation page;

    public PMRecipePage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void clickButton(String operation) {
        switch (operation) {
            case "新建":
                page.elementByName("新建").click();
                break;
            case "删除":
                page.elementByName("删除").click();
                break;
            case "保存":
                page.elementByName("保存").click();
                break;
            case "另存为":
                page.elementByName("另存为").click();
                break;
            case "修改":
                page.elementById("mPMRcpModify_btn").click();
                break;
            default:
                throw new IllegalStateException("unknown module: " + operation);
        }
    }

    public void selectChamber(String chamber) {
        page.elementById("mPMChamber_cmb").selectByName(chamber);
    }

    public void selectRecipe(String pmRecipe) {
        page.elementByName(pmRecipe).click();
    }

    public void upStep(String stepNum, int time) {
        for (int i = 1; i <= time; i++) {
            page.getXpathElement(String.format("//Text[@Name='%s']/../Button[@Name='↑']", stepNum)).click();
            stepNum = Integer.toString(Integer.parseInt(stepNum) - i);
        }
    }

    public void downStep(String stepNum, int time) {
        for (int i = 1; i <= time; i++) {
            page.getXpathElement(String.format("//Text[@Name='%s']/../Button[@Name='↓']", stepNum)).click();
            stepNum = Integer.toString(Integer.parseInt(stepNum) + i);
        }
    }

    public void deleteStep(String stepNum) {
        page.getXpathElement(String.format("//Text[@Name='%s']/../Button[@Name='X']", stepNum)).click();
    }

    public void clickYes() {
        winForm.elementByName("是").click();
    }

    public void sendRecipeName(String rcpName) {
        winForm.elementById("mPMRcpName_tb").sendKeys(rcpName);
        winForm.elementByName("确定").click();
        winForm.elementByName("确定").click();
    }

    public void sendErrorName(String rcpName) {
        winForm.elementById("mPMRcpName_tb").sendKeys(rcpName);
    }

    public List<Object> getPMRcpList() {
        return page.elementById("mPMRcpList_lb").getListValue();
    }

    public String getChamber() {
        return winForm.elementById("mChamber_cmb").getText();
    }

    public List<Object> getParamList() {
        return page.elementById("flowLayoutPanel1").getPanelValue();
    }

    public void addOneStepWithoutParam(String stepName) {
        page.elementByName(stepName).click();
        page.elementByName("添加步骤").click();
    }

    public void addSteps(Table table) {
        for (int j = 0; j < table.size(); j++) {
            page.elementByName((String) table.get(j).get("name")).click();
            page.elementByName("添加步骤").click();
            if (table.get(j).get("param") != null) {
                List<Map<String, Object>> param = (List<Map<String, Object>>) table.get(j).get("param");
                for (int i = 0; i < param.size(); i++) {
                    for (String key : param.get(i).keySet()) {
                        page.elementByName(key).sendKeys((String) param.get(i).get(key));
                        //TODO:下拉框输入不了
//                        if (page.elementByName(key).getAttribute("LocalizedControlType").equals("编辑")) {
//                            page.elementByName(key).sendKeys((String) param.get(i).get(key));
//                        } else if (page.elementByName(key).getAttribute("LocalizedControlType").equals("组合框")) {
//                            page.elementByName(key).click().elementByName((String) param.get(i).get(key)).click();
//                        }
                    }
                }
            }
        }
    }

    public String getErrorProvider() {
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("mPMRcpName_tb").getElement()).moveByOffset((winForm.elementById("mPMRcpName_tb").getElement().getSize().width / 2) + 5, 0).perform();
        return winForm.getErrorProviderInfo();
    }
}
