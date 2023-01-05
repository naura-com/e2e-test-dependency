package com.naura.test.ui.page.Etch1.Edit;

import com.naura.pvd.IComRecipe.RemoteRecipeInfo;
import com.naura.test.config.ContextWrapper;
import com.naura.test.lower.api.LowerApi;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.Etch1.FileOption;
import com.naura.test.ui.page.ParentPage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.*;

import static com.naura.test.ui.driver.Window.WindowOperation.FILL_BY_TEXT_BOX;

public class RecipePage extends ParentPage {

    @Autowired
    WinForm winForm;

    @Autowired
    LowerApi lowerApi;

    @Autowired
    FileOption fileOption = new FileOption();

    private final Window.WindowOperation page;

    public RecipePage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void createDefaultRecipe(String PM, String rcpClass, String rcpName) {
//        page.elementById("cmbSelPm").click().sendKeys(rcpClass);
//        winForm.elementById("button_OK").click();
        selectClass(PM, rcpClass, true);
        page.elementById("btnNew").click();
        winForm.elementById("txtProRcpName").sendKeys(rcpName);
        clickOkOrCancel("Ok");
    }

    public String getRcpCreateTime() {
        return page.elementById("txtCreatedTime").getText();
    }

    public void createStepRcp(String PM, String rcpClass, String rcpName, DataTable table) {
        createDefaultRecipe(PM, rcpClass, rcpName);
        createDefaultStep(table.width() - 1, table);
        page.elementById("dgvRecipe").editTableCol(table.asMaps(), anyColumn -> FILL_BY_TEXT_BOX);
    }

    public void createDefaultStep(int count, DataTable table) {
        for (int i = 2; i < count + 1; i++) {
            createSingleStep(table.column(i).get(1));
        }
    }

    public void createSingleStep(String stepName) {
        clickAction("New Step");
        winForm.elementById("txtProRcpName").sendKeys(stepName);
        clickOkOrCancel("Ok");
    }

    //TODO 无法找到下拉框中的内容
    public Object getCopyFirstStepCol() {
        actionStep("1", "Copy To..");
        Object object = winForm.elementById("stepNameAvilable").click().getListValue();
        clickOkOrCancel("Cancel");
        return object;
    }

    public void clickOkOrCancel(String action) {
        winForm.elementByName(action).click();
    }

    public void clickAction(String action) {
        page.elementByName(action).click();
    }

    public void copyStep(String first, String second) {
        actionStep(first, "Copy To..");
//        for (int i = 0; i < Integer.parseInt(second); i++) {
//            winForm.elementById("stepNameAvilable").sendKeys("step" + second);
//        }
        winForm.elementById("stepNameAvilable").sendKeys(second);
//        winForm.elementByName("Ok").click();
//        TODO: to add a method
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementByName("Ok").getElement()).click().perform();
    }

    public boolean verifyStep(int first, int second) {
        List<Map<Object, Object>> result = winForm.elementById("dgvRecipe").getTableValue();
        result.size();
        for (Map<Object, Object> objectObjectMap : result) {
            if (!objectObjectMap.get(first).equals(objectObjectMap.get(second))) {
                return false;
            }
        }
        return true;
    }

    public Object verifyInformation(String action) {
        Object informationInfo = winForm.elementByName("Information").elementById("65535").getValue();
        if (!action.isEmpty()) {
            winForm.elementByName("Information").elementByName(action).click();
        }
        return informationInfo;
    }

    public void actionStep(String stepIndex, String action) {
        if (!stepIndex.isEmpty()) {
            selectStep(stepIndex);
        }
        clickAction(action);
    }

    private void selectStep(String stepIndex) {
        page.elementByName(stepIndex).click();
    }

    public Set<Object> getHeaderName() {
        return page.elementById("dgvRecipe").getTableHeader();
    }

    public void createCycStepRcp(String PM, String rcpClass, String rcpName, int cycStep, int first, int second, int cycTime, DataTable table) {
        createDefaultRecipe(PM, rcpClass, rcpName);
        for (int i = 2; i < table.width(); i++) {
            if (i == cycStep) {
                createCycStep(first, second, cycTime);
            } else {
                createDefaultStep(2);
            }
        }
        page.elementById("mRcpDetail_dgv").editTableCol(table.asMaps(), anyColumn -> FILL_BY_TEXT_BOX);
    }

    public void createCycStep(int first, int second, int cycTime) {
        page.elementById("mEdit_btn").click();
        page.elementById("mStepNew_btn").click();
        winForm.elementById("mCycle_rbtn").click();
        transformCycSetting(Integer.toString(first), Integer.toString(second), Integer.toString(cycTime));
    }

    public void createDefaultStep(int count) {
        for (int i = 1; i < count; i++) {
            page.elementById("btnNewStep").click();
            winForm.elementById("txtProRcpName").sendKeys("Step" + String.valueOf(i + 1));
            clickOkOrCancel("Ok");
        }
    }

    public void transformCycSetting(String first, String second, String cycTime) {
        winForm.elementById("mStart_cmb").click().sendKeys(first);
        winForm.elementById("mEnd_cmb").click().sendKeys(second);
        winForm.elementById("mLoopCount_tb").sendKeys(cycTime);
        winForm.elementById("mOK_btn").click();
    }

    //    public void moveStep(String first, String second, String position) {
//        selectStep(first);
//        page.elementById("move").click();
//        for (int i = 0; i < Integer.parseInt(second); i++) {//String.valueOf(Keys.DOWN)
//            winForm.elementById("stepNameAvilable").click().select(Integer.parseInt(second) - 1);
//        }
////        winForm.elementById("stepNameAvilable").click().select(Integer.parseInt(second) - 1);
//        if (position == "前") {
//            winForm.elementById("radioButton1").click();
//        } else {
//            winForm.elementById("radioButton2").click();
//        }
//        clickOkOrCancel("Ok");
//    }
    public void moveStep(String first, String second, String position) {
        selectStep(first);
        page.elementById("move").click();
        Window.WindowOperation click = winForm.elementById("stepNameAvilable").elementByName("打开").click();
        while (true) {
            click.sendKeys(String.valueOf(Keys.DOWN));
            if (winForm.elementById("stepNameAvilable").getText().contains("step" + second)) {
                break;
            }
        }
        if (position.equals("前")) {
            ((winForm.elementById("frmMoveTo").sendKeys(String.valueOf(Keys.TAB))).
                    sendKeys(String.valueOf(Keys.RIGHT))).sendKeys(String.valueOf(Keys.RIGHT));
            (((winForm.elementById("frmMoveTo").sendKeys(String.valueOf(Keys.TAB))).sendKeys(String.valueOf(Keys.TAB))).
                    sendKeys(String.valueOf(Keys.TAB))).sendKeys(String.valueOf(Keys.ENTER));
        } else {
//            winForm.elementById("radioButton2").click();
            (((winForm.elementById("frmMoveTo").sendKeys(String.valueOf(Keys.TAB))).sendKeys(String.valueOf(Keys.RIGHT))).
                    sendKeys(String.valueOf(Keys.RIGHT))).sendKeys(String.valueOf(Keys.RIGHT));
            ((winForm.elementById("frmMoveTo").sendKeys(String.valueOf(Keys.TAB))).
                    sendKeys(String.valueOf(Keys.TAB))).sendKeys(String.valueOf(Keys.ENTER));
        }
    }

    public Map<Object, Object> getParameterValue(String colName, String parameterName) {
        List<Map<Object, Object>> table = page.elementById("dgvRecipe").getTableValue();
        Map<Object, Object> map = new HashMap<>();
        for (int row = 0; row < table.size(); row++) {
            if (table.get(row).get(colName).equals(parameterName)) {
                map = table.get(row);
                break;
            }
        }
        return map;
    }

    public void selectClass(String PM, String rcpClass, boolean hasAlarm) {
        selectPM(PM, hasAlarm);
        selectRcpType(rcpClass, hasAlarm);
    }

    public void selectPM(String PM, boolean hasAlarm) {
        page.elementById("cmbSelPm").click().sendKeys(PM.substring(0, 1));
        if (hasAlarm) {
            try {
                clickOkOrCancel("OK");
            } catch (Exception ignored) {
            }
        }
    }

    public void selectRcpType(String rcpClass, boolean hasAlarm) {
        page.elementById("cmbtype").click().sendKeys(rcpClass.substring(0, 1)).sendKeys(String.valueOf(Keys.ENTER));
        if (hasAlarm) {
            try {
                clickOkOrCancel("OK");
                clickOkOrCancel("OK");
            } catch (Exception ignored) {
            }
        }
    }

    public List<Object> getRcpList() {
        return page.selectByName("Recipes In Buffer").getListValue();
    }

    public Object getAuthor() {
        return winForm.elementById("txtAuthor").getValue();
    }

    public DataTable GetRcpDataTable(DataTable table, int rowIndex, int colIndex) {
        return table.subTable(rowIndex, colIndex, table.height(), table.width());
    }

    public void selectRcp(String rcpName) {
        winForm.elementByName("Recipes In Buffer").elementByName(rcpName).click().click();
    }

    public void createRecipeAndSave(DataTable table) {
        for (int i = 1; i < table.height(); i++) {
            createRcp(table, i);
//            page.elementById("dgvRecipe").editTableCol(table.asMaps(), anyColumn -> FILL_BY_TEXT_BOX);
            clickAction("Save");
            clickOkOrCancel("OK");
        }
    }

    public List<Map<Object, Object>> getParamInfo() {
        return page.elementById("dgvRecipe").getTableValue();
    }

    public void setValue(String s, String v) {
        winForm.elementByName(s).click().sendKeys(v).sendKeys(String.valueOf(Keys.ENTER));
    }

    public void setComboxValue(String s, String v) {
        if (!winForm.elementByName(s).getText().equals(v)) {
            winForm.elementByName(s).click();
            Window.WindowOperation openPage = page.elementById("cb").elementByName("打开").click();
            switch (winForm.elementByName(s).getText()) {
                case "Si":
                    openPage.sendKeys(String.valueOf(Keys.UP));
                    break;
                case "SiC":
                    openPage.sendKeys(String.valueOf(Keys.UP)).sendKeys(String.valueOf(Keys.UP));
                    break;
            }
            while (true) {
                if (winForm.elementByName(s).getText().equals(v)) {
//                    openPage.sendKeys(String.valueOf(Keys.ENTER));
                    break;
                }
                openPage.sendKeys(String.valueOf(Keys.DOWN)).sendKeys(String.valueOf(Keys.ENTER));
            }
        }
    }

    public Object getmessage() {
        return winForm.elementById("PopupNotice").elementById("label_msg").getText();
    }

    public void enterAndSave() {
        winForm.elementByName("Parameter 行 0").click();
        clickAction("Save");
    }

    public void createRcp(DataTable table, int i) {
        createDefaultRecipe(table.cell(i, 0), table.cell(i, 1), table.cell(i, 2));
        if (table.cell(i, 1).contains("Process")) {
            winForm.elementById("dgvRecipe").elementByName("1 行 0").click().sendKeys("dechuck").sendKeys(String.valueOf(Keys.ENTER));
        }
        for (int stepnum = 5; stepnum < table.width(); stepnum++) {
            clickAction("New Step");
            winForm.elementById("txtProRcpName").sendKeys(table.cell(i, stepnum));
            clickOkOrCancel("Ok");
        }
    }

    public void createRecipeAndNotSave(DataTable table) {
        for (int i = 1; i < table.height(); i++) {
            createRcp(table, i);
        }
    }

    public void cleanAllCreateRcp() {
//        clickAction("Save");
//        clickOkOrCancel("OK");
        clickAction("Restore");
        for (String rcpClass : ContextWrapper.getApplicationContext().getBean(LowerApi.class).recipe().getAllRcpClasses()) {
            selectRcpType(rcpClass.substring(1, rcpClass.length()), true);
            for (Object recipe : page.elementByName("Recipes In Buffer").getListValue()) {
                selectRcp(recipe.toString());
                deleteRcp();
            }
        }
    }


    public void deleteRcp() {
        clickAction("Delete");
        winForm.elementById("panel_hasResult").elementByName("Yes").click();
    }

    public void modifyStepName(int step, String parameter, String value, String type) {
        List<Map<Object, Object>> view = getParamInfo();
        modifyPar(step, parameter, value, type, view);
    }

    private void modifyPar(int step, String parameter, String value, String type, List<Map<Object, Object>> view) {
        for (int i = 0; i < view.size(); i++) {
            if (view.get(i).get("Parameter").equals(parameter)) {
                switch (type) {
                    case "double":
                        setValue(step + " 行 " + i, value);
                        break;
                    case "intlist":
                        setComboxValue(step + " 行 " + i, value);
                        break;
                }
                break;
            }
        }
    }

    public void saveAsRcp(String rcpClass, String rcp) {
        clickAction("Save as");
        winForm.elementByName("Select PM").sendKeys(rcpClass);
        winForm.elementByName("Select PM").sendKeys(rcpClass);
        winForm.elementById("txtProRcpName").sendKeys(rcp);
        clickOkOrCancel("Ok");
    }

    public RemoteRecipeInfo getLowerRcp(String rcpid) {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        return api.recipe().getRecipeInfo(rcpid);
    }

    public Object sureStepName(int step, String parameter) {
        List<Map<Object, Object>> view = getParamInfo();
        for (int i = 0; i < view.size(); i++) {
            if (view.get(i).get("Parameter").equals(parameter)) {
                return winForm.elementByName(step + " 行 " + i).getValue();
            }
        }
        return null;
    }

    public void editComment(String comment) {
        winForm.elementById("txtComments").sendKeys(comment);
    }

    public void sendNewRcpName(String rcp) {
        winForm.elementById("txtProRcpName").sendKeys(rcp);
    }

    public void enterAndRestore() {
        winForm.elementByName("Parameter 行 0").click();
        clickAction("Restore");
    }

    public String[] getAllLowerRcp() {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        return api.recipe().getAllRecipes();
    }

    public void export(String type, String startStep, String endStep) {
        clickAction("Export");
        switch (type) {
            case "Full Steps":
                winForm.elementByName("Full Steps").click();
                winForm.elementByName("Ok").click();
                break;
            case "Sub Steps":
                winForm.elementByName("Sub Steps").click();
                winForm.elementById("cmbStepFromNum").sendKeys(startStep);
                winForm.elementById("cmbStepToNum").sendKeys(endStep);
                winForm.elementByName("Ok").click();
                break;
        }
    }

    public void exportRcpFile(String route, String rcpName) {
        winForm.elementByName("所有位置").click();
        winForm.elementById("41477").sendKeys(route).click();
        winForm.elementById("1001").sendKeys(rcpName);
        winForm.elementById("1").click();
    }

    public String[] verifyFile(String dir, String fileName) {
        File file = new File(dir);
        for (String name : Objects.requireNonNull(file.list())) {
            if (name.contains(fileName)) {
                return fileOption.readFile(dir + "\\" + name);
            }
        }
        return null;
    }

    public void rename(String renameRcp) {
        clickAction("Rename");
        clickOkOrCancel("Yes");
        winForm.elementById("frmProcessRecipeNewname").elementById("txtProRcpName").sendKeys(renameRcp);
        clickOkOrCancel("Ok");
    }

    public void cleanAllRcp() {//接口删除rcp
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        for (String rcp : api.recipe().getAllRecipes()) {
            api.recipe().deleteRecipe(rcp);
        }
    }

    public List<Object> getSecondStep(int stepnum) {
        List<Object> stepInfos = new ArrayList<>();
        for (int i = 0; i < stepnum; i++) {
            winForm.elementById("stepNameAvilable").elementByName("打开").sendKeys(String.valueOf(Keys.DOWN));
            stepInfos.add(winForm.elementById("stepNameAvilable").getText());
        }
        return stepInfos;
    }

    public void modifyRcpPara(DataTable table) {
        for (int i = 1; i < table.height(); i++) {
            modifyStepName(Integer.parseInt(table.row(i).get(0)), table.row(i).get(1),
                    table.row(i).get(2), table.row(i).get(3));
        }
    }

    public String[] getNewListParam(List<Map<Object, Object>> view) {
        ArrayList<String> parameter = new ArrayList<String>();
        for (int i = 0; i < view.size(); i++) {
            parameter.add(view.get(i).get("Parameter").toString());
        }
        return parameter.toArray(new String[0]);
    }

    public String[] getNewListValue(List<Map<Object, Object>> view) {
        ArrayList<String> value = new ArrayList<String>();
        for (int i = 0; i < view.size(); i++) {
            value.add(view.get(i).get(1).toString());
        }
        return value.toArray(new String[0]);
    }

    public void storeNewRcp(DataTable table, String rcp) {
        List<Map<Object, Object>> view = getParamInfo();
        String[] paramList = getNewListParam(view);
        String[] valueList = getNewListValue(view);
        for (int j = 0; j < table.width(); j++) {
            for (int i = 0; i < paramList.length; i++) {
                if (table.row(0).get(j).equals(paramList[i]))
                    valueList[i] = table.row(1).get(j);
            }
        }
        ContextWrapper.getApplicationContext().getBean(LowerApi.class).recipe().storercpForEtch1justOneStep(valueList, rcp);
//        lowerApi.recipe().storercpForEtch1justOneStep(valueList);
    }

    public void modifyRcpParas(DataTable table) {
        List<Map<Object, Object>> view = getParamInfo();
        for (int i = 1; i < table.height(); i++) {
            modifyPar(Integer.parseInt(table.row(i).get(0)), table.row(i).get(1),
                    table.row(i).get(2), table.row(i).get(3), view);
        }
    }

    public void createRcpNoDechuck(DataTable table, int i) {
        createDefaultRecipe(table.cell(i, 0), table.cell(i, 1), table.cell(i, 2));
        for (int stepnum = 5; stepnum < table.width(); stepnum++) {
            clickAction("New Step");
            winForm.elementById("txtProRcpName").sendKeys(table.cell(i, stepnum));
            clickOkOrCancel("Ok");
        }
    }

    public void createRecipeAndNotSaveNoDechuck(DataTable table) {
        for (int i = 1; i < table.height(); i++) {
            createRcpNoDechuck(table, i);
        }
    }
}
