package com.naura.test.ui.page.PVD;

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

import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.*;

import static com.naura.test.ui.driver.Window.WindowOperation.FILL_BY_TEXT_BOX;

public class RecipePage extends ParentPage {

    @Autowired
    WinForm winForm;

    @Autowired
    FileOption fileOption = new FileOption();

    private final Window.WindowOperation page;

    public RecipePage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    @NotNull
    public Map<String, Object> queryRecipeInfo(String recipe) {
        String[] split = recipe.replaceFirst("/", "").split("/");
        page.elementById("mPM_cmb").selectByName(split[0]);
        page.elementById("mRcpTreeView_tv").selectByName(split);
        Window.WindowOperation editPanel = page.elementByName("Recipe编辑");
        return new LinkedHashMap<>() {{
            put("shutter", editPanel.elementById("mShutter_cmb").getValue());
            put("procType", editPanel.elementById("mRspType_cmb").getValue());
            put("increment", editPanel.elementById("mIncrement_tb").getValue());
            put("heaterTemp", editPanel.elementById("mHeaterTemp_tb").getValue());
            put("heaterTempST", editPanel.elementById("mHeaterTempST_tb").getValue());
            put("heaterTempHT", editPanel.elementById("mHeaterTempHT_tb").getValue());
            put("body", editPanel.elementById("mRcpDetail_dgv").getTableValue());
        }};
    }


    @Override
    public void reset() {
        page.elementById("mPM_cmb").select(-1);
    }

    public void createDefaultRecipe(String rcpClass, String rcpName) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
        page.elementById("mRcpNew_btn").click();
        winForm.elementById("mRcpName_tb").sendKeys(rcpName);
        winForm.elementById("mOK_btn").click();
        winForm.elementById("mYes_btn").click();
    }

    public void createDefaultStep(int count) {
        page.elementById("mEdit_btn").click();
        for (int i = 1; i < count; i++) {
            page.elementById("mStepNew_btn").click();
            winForm.elementByName("确定").click();
        }
    }

    public void createCycStep(int first, int second, int cycTime) {
        page.elementById("mEdit_btn").click();
        page.elementById("mStepNew_btn").click();
        winForm.elementById("mCycle_rbtn").click();
        transformCycSetting(Integer.toString(first), Integer.toString(second), Integer.toString(cycTime));
    }

    public void cleanCreateRcp() {
        page.elementById("mRcpDel_btn").click();
        winForm.elementById("mYes_btn").click();
        winForm.elementById("mYes_btn").click();
    }

    public void clickStepSetting(String rcpClass, String rcpName, String operation) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
        page.elementById("mRcpList_lb").selectByName(rcpName).click();
        clickOneSetting(operation);
    }

    public void clickStepSettingWithoutRcp(String rcpClass, String operation) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
        clickOneSetting(operation);
    }

    public void clickOneSetting(String operation) {
        switch (operation) {
            case "新建":
                page.elementById("mStepNew_btn").click();
                break;
            case "删除":
                page.elementById("mStepDel_btn").click();
                break;
            case "循环设定":
                page.elementById("mStepSetCycle_btn").click();
                break;
            case "复制":
                page.elementById("mStepCopy_btn").click();
                break;
            case "移动":
                page.elementById("mStepMove_btn").click();
                break;
            default:
                throw new IllegalStateException("unknown module: " + operation);
        }
    }

    public void insertStep(String step) {
        winForm.elementById("mNewCol_cmb").click().sendKeys(step);
    }

    public void deleteStep() {
        page.elementById("mStepDel_btn").click();
    }

    public void deleteSomeStep(String step) {
        page.elementById("mRcpDetail_dgv").selectColumn(step);
        page.elementById("mStepDel_btn").click();
    }

    public void makeSure() {
        winForm.elementByName("确定").click();
    }

    public void makeCancel() {
        winForm.elementByName("取消").click();
    }

    public void editRcp(String rcpClass, String rcpName, DataTable table) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
        page.elementById("mRcpList_lb").selectByName(rcpName).click();
        page.elementById("mEdit_btn").click();
        page.elementById("mRcpDetail_dgv").editTableByParam(table.asMaps(), anyColumn -> FILL_BY_TEXT_BOX);
    }

    public void editRcpPedTemp(int PedTemp, int PedTempTol) {
        page.elementById("mHeaterTemp_tb").sendKeys(Integer.toString(PedTemp));
        page.elementById("mHeaterTol_tb").sendKeys(Integer.toString(PedTempTol));
    }

    public void saveRcp() {
        saveToPopupMessagePage().clickOK();
    }

    public String getRcpCreateTime() {
        return page.elementById("mRcpCreateTime_stb").getText();
    }

    public String getRcpEditTime() {
        return page.elementById("mModifyTime_stb").getText();
    }

    public String getCreator() {
        return page.elementById("mRcpCreator_stb").getText();
    }

    public Map<Object, Object> getParameterValue(String colName, String parameterName) {
        List<Map<Object, Object>> table = page.elementById("mRcpDetail_dgv").getTableValue();
        Map<Object, Object> map = new HashMap<>();
        for (int row = 0; row < table.size(); row++) {
            if (table.get(row).get(colName).equals(parameterName)) {
                map = table.get(0);
                break;
            }
        }
        return map;
    }

    public List<Object> getMoveFirstStepCol() {
        page.elementById("mStepMove_btn").click();
        List<Object> list = winForm.elementById("mFrom_cmb").click().getListValue();
        winForm.elementByName("取消").click();
        return list;
    }

    public Object getCopyFirstStepCol() {
        page.elementById("mStepCopy_btn").click();
        Object object = winForm.elementById("mFrom_cmb").click().getListValue();
        winForm.elementByName("取消").click();
        return object;
    }

    public Object getCopySecondStepCol() {
        page.elementById("mStepCopy_btn").click();
        Object object = winForm.elementById("mTo_cmb").click().getListValue();
        winForm.elementByName("取消").click();
        return object;
    }

    public List<Object> getSecondCol() {
        List<Object> list = winForm.elementById("mTo_cmb").click().getListValue();
        winForm.elementByName("取消").click();
        return list;
    }

    public Set<Object> getHeaderName() {
        return page.elementById("mRcpDetail_dgv").getTableHeader();
    }

    public String getMessage() {
        String message = winForm.elementById("mMsg_lbl").getText();
        makeSure();
        return message;
    }

    public List<Object> getInsertCol() {
        List<Object> list = winForm.elementById("mNewCol_cmb").click().getListValue();
        makeCancel();
        return list;
    }

    public RemoteRecipeInfo getLowerRcp(String rcpid) {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        return api.recipe().getRecipeInfo(rcpid);
    }

    public String getMessageOnly() {
        String message = winForm.elementById("mMsg_lbl").getText();
        return message;
    }

    public List<Object> findRcp(String rcpClass, String str) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
        page.elementById("mRcpFilter_tb").sendKeys(str);
        return page.elementById("mRcpList_lb").getListValue();
    }

    public List<Object> showRcp(String rcpClass) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
        return page.elementById("mRcpList_lb").getListValue();
    }

    public void createStepRcp(String rcpClass, String rcpName, DataTable table) {
        createDefaultRecipe(rcpClass, rcpName);
        createDefaultStep(table.width() - 1);
        page.elementById("mRcpDetail_dgv").editTableCol(table.asMaps(), anyColumn -> FILL_BY_TEXT_BOX);
    }

    public void createCycStepRcp(String rcpClass, String rcpName, int cycStep, int first, int second,
                                 int cycTime, DataTable table) {
        createDefaultRecipe(rcpClass, rcpName);
        for (int i = 2; i < table.width(); i++) {
            if (i == cycStep) {
                createCycStep(first, second, cycTime);
            } else {
                createDefaultStep(2);
            }
        }
        page.elementById("mRcpDetail_dgv").editTableCol(table.asMaps(), anyColumn -> FILL_BY_TEXT_BOX);
    }

    public void createCycStepRcpWithoutName(String rcpClass, String rcpName, int cycStep, int first, int second,
                                            int cycTime, DataTable table) {
        createDefaultRecipe(rcpClass, rcpName);
        for (int i = 2; i < table.width(); i++) {
            if (i == cycStep) {
                createCycStep(first, second, cycTime);
            } else {
                createDefaultStep(2);
            }
        }
    }

    public void moveStep(int time, String first, String second) {
        for (int i = 0; i < time; i++) {
            page.elementById("mStepMove_btn").click();
            winForm.elementById("mFrom_cmb").click().sendKeys(first);
            winForm.elementById("mTo_cmb").click().sendKeys(second);
            winForm.elementById("mOK_btn").click();
        }
    }

    public void copyStep(int first, int second) {
        page.elementById("mStepCopy_btn").click();
        winForm.elementById("mFrom_cmb").click().sendKeys(Integer.toString(first));
        winForm.elementById("mTo_cmb").click().sendKeys(Integer.toString(second));
        winForm.elementById("mOK_btn").click();
    }

    public boolean verifyStep(int first, int second) {
        List<Map<Object, Object>> result = winForm.elementById("mRcpDetail_dgv").getTableValue();
        result.size();
        for (int i = 0; i < result.size(); i++) {
            if (!result.get(i).get(first).equals(result.get(i).get(second))) {
                return false;
            }
        }
        return true;
    }

    public void selectMoveFirstStep(int first) {
        page.elementById("mStepMove_btn").click();
        winForm.elementById("mFrom_cmb").click().sendKeys(Integer.toString(first));
    }

    public void selectCopyFirstStep(int first) {
        page.elementById("mStepCopy_btn").click();
        winForm.elementById("mFrom_cmb").click().sendKeys(Integer.toString(first));
    }

    public void selectStepCyc(String step) {
        page.elementById("mRcpDetail_dgv").selectColumn(step);
        page.elementById("mStepSetCycle_btn").click();
    }

    public void transformCycSetting(String first, String second, String cycTime) {
        winForm.elementById("mStart_cmb").click().sendKeys(first);
        winForm.elementById("mEnd_cmb").click().sendKeys(second);
        winForm.elementById("mLoopCount_tb").sendKeys(cycTime);
        winForm.elementById("mOK_btn").click();
    }

    public void cancel() {
        winForm.elementByName("取消").click();
    }

    public PopupNewRcpPage popupNewRcpPage() {
        return switchTo(PopupNewRcpPage.class, () -> page.elementById("mRcpNew_btn").click(),
                () -> new PopupNewRcpPage(winForm.elementById("PopupNewRcp"), winForm));
    }

    public PopupMessagePage saveToPopupMessagePage() {
        return switchTo(PopupMessagePage.class, () -> page.elementById("mRcpSave_btn").click(),
                () -> new PopupMessagePage(winForm.elementById("PopupMessage")));
    }

    public String getRcp(String rcpClass) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
        return page.elementById("mRcpList_lb").getListValue().toString();
    }

    public List<Map<Object, Object>> getParamInfo() {
        return page.elementById("mRcpDetail_dgv").getTableValue();
    }

    public void checkPedTempValue() {
        if (page.elementById("mHeaterTemp_tb").getText().isEmpty()) {
            page.elementById("mHeaterTemp_tb").clear();
            page.elementById("mHeaterTemp_tb").sendKeys(String.valueOf(11));
        }
        if (page.elementById("mHeaterTol_tb").getText().isEmpty()) {
            page.elementById("mHeaterTol_tb").clear();
            page.elementById("mHeaterTol_tb").sendKeys(String.valueOf(11));
        }
    }

    public String getErrorMsg() {
        return winForm.elementById("mMsg_lbl").getText();
    }

    public void clickOn(String btn) {
        switch (btn) {
            case "新建配方": {
                page.elementById("mRcpNew_btn").click();
                break;
            }
            case "新建步骤": {
                page.elementById("mStepNew_btn").click();
                break;
            }
            case "编辑": {
                page.elementById("mEdit_btn").click();
                break;
            }
            case "撤销编辑": {
                page.elementById("mRcpUndo_btn").click();
                break;
            }
            case "删除配方": {
                page.elementById("mRcpDel_btn").click();
                break;
            }
            case "保存配方": {
                page.elementById("mRcpSave_btn").click();
                break;
            }
            case "另存为": {
                page.elementById("mRcpSaveAs_btn").click();
                break;
            }
            case "确定": {
                winForm.elementByName("确定").click();
                break;
            }
            case "取消": {
                winForm.elementByName("取消").click();
                break;
            }
            case "导入": {
                page.elementById("mRcpImport_btn").click();
                break;
            }
            case "导出": {
                createNewFolder();
                page.elementById("mRcpExport_btn").click();
                break;
            }
            default:
                throw new IllegalStateException("unknown click: " + btn);
        }
    }

    public void createNewFolder() {
        File folder = new File("c:\\test\\testFiles");
        if (!folder.exists())
            folder.mkdirs();
        else {
            deleteFile(folder);
            folder.mkdirs();
        }
    }

    public void deleteFile(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory())
                deleteFile(f);
            else
                f.delete();
        }
        file.delete();
    }

    public void OnclickParam(String paramStep) {
        page.elementByName(paramStep).click();
    }

    public void deleteRcp(String rcpClass, String rcpName) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
        page.elementById("mRcpList_lb").selectByName(rcpName).click();
        page.elementById("mRcpDel_btn").click();
    }

    public void makeSureAndCheck() {
        winForm.elementByName("确定").click();
        winForm.elementByName("确定").click();
    }

    public void Undo() {
        page.elementById("mRcpUndo_btn").click();
        winForm.elementByName("确定").click();
    }

    public void setPedTempValue(String temp, String tol) {
        page.elementById("mHeaterTemp_tb").sendKeys(temp);
        page.elementById("mHeaterTol_tb").sendKeys(tol);
    }

    public void selectRcp(String rcpClass, String rcpName) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
        page.elementById("mRcpList_lb").selectByName(rcpName).click();
    }

    public void selectRecipe(String rcpName) {
        page.elementById("mRcpList_lb").selectByName(rcpName).click();
    }

    public void doPopMessage(String processMode) {
        winForm.elementById("PopupMessage").elementByName(processMode).click();
    }

    public void fillComments(String comments) {
        for (String comment : comments.split(",")) {
            String paramName = comment.split(":")[0];
            String paramValue = comment.split(":")[1];
            editComments(paramName, paramValue);
        }
    }

    public void fillComments(List<Map<String, String>> data) {
        for (int row = 0; row < data.size(); row++) {
            String paramName = data.get(row).get("name");
            String paramValue = data.get(row).get("value");
            editComments(paramName, paramValue);
        }
    }

    public void editComments(String paramName, String paramValue) {
        switch (paramName) {
            case "PedTemp":
                page.elementById("mHeaterTemp_tb").clear();
                page.elementById("mHeaterTemp_tb").sendKeys(paramValue);
                break;
            case "PedTempTol":
                page.elementById("mHeaterTol_tb").clear();
                page.elementById("mHeaterTol_tb").sendKeys(paramValue);
                break;
        }
    }

    public void cleanAllCreateRcp() {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        for (String recipe : api.recipe().getAllRecipes()
        ) {
            selectRcp(recipe.split(";")[0].split("/")[1], recipe.split(";")[0].split("/")[2]);
            cleanCreateRcp();
        }
    }

    public void saveRecipe() {
        page.elementById("mRcpSave_btn").click();
        winForm.elementById("PopupMessage").elementById("mYes_btn").click();
    }

    public void editRcpParam(String rcpClass, String rcpName, DataTable table) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
        page.elementById("mRcpList_lb").selectByName(rcpName).click();
        page.elementById("mEdit_btn").click();
        page.elementByName("Parameter 行 0").click(); //刷新选中框
        page.elementById("mRcpDetail_dgv").editTableCol(table.asMaps(), anyColumn -> FILL_BY_TEXT_BOX);
        page.elementByName("Parameter 行 0").click(); //刷新选中框
    }

    public void editRcpComment(String rcpClass, String rcpName, DataTable table) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
        page.elementById("mRcpList_lb").selectByName(rcpName).click();
        page.elementById("mEdit_btn").click();
        fillComments(table.asMaps());
    }

    public void selectRecipeClass(String rcpClass) {
        page.elementById("mPM_cmb").selectByName(rcpClass);
    }

    public Object getCurrentRecipeList() {
        Object object = page.elementById("mRcpList_lb").getListValue();
        return object;
    }

    public void cleanPedTemp() {
        page.elementById("mEdit_btn").click();
        page.elementById("mHeaterTemp_tb").clear();
        page.elementById("mHeaterTol_tb").clear();
    }

    public void restoreRcp(String newRcpName) {
        if (winForm.elementByName("保存确认") != null) {
            winForm.elementById("mYes_btn").click();
            winForm.elementByName("确定").click();
        }
        winForm.elementById("mRcpName_tb").sendKeys(newRcpName);
        winForm.elementByName("确定").click();
    }

    public String[] getAllLowerRcp() {
        LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
        return api.recipe().getAllRecipes();
    }

    public String checkPopUpMessage() {
        return winForm.elementById("mTitle_lab").getText();
    }

    public void exportRcpFile(String route, String rcpName) {
        winForm.elementByName("所有位置").click();
        winForm.elementById("41477").sendKeys(route).Keyboard(Keys.ENTER);//点击目标路径栏左侧的文件夹图标
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

    public void importRcpFile(String route, String fileName) {

    }

    public void createRouteRecipe(List<Map<String, String>> data) {
        for (int row = 0; row < data.size(); row++) {
            if (data.get(row).get("配方") != null) {
                creatDefaultRecipe(data.get(row).get("腔室"), data.get(row).get("配方"));
            }
        }
    }

    public void creatDefaultRecipe(String rcpClass, String rcpName) {
        createStepRcp(rcpClass, rcpName, null);
        fillComments();
        saveRecipe();
    }

    private void fillComments() {
        if (page.elementById("mHeaterTemp_tb") != null) {
            editComments("PedTemp", "100");
        }
        if (page.elementById("mHeaterTol_tb") != null) {
            editComments("PedTempTol", "0");
        }
    }

    public void createRouteRcp(DataTable table) {
        List<Map<String, String>> data = table.asMaps();
        for (int row = 0; row < data.size(); row++) {
            if (data.get(row).get("配方") != null) {
                createDefaultRecipe(data.get(row).get("腔室"), data.get(row).get("配方").substring(data.get(row).get("配方").lastIndexOf("/") + 1, data.get(row).get("配方").indexOf(";")));
                if (data.get(row).get("腔室").contains("Ch2") || data.get(row).get("腔室").contains("Ch3")) {
                    checkPedTempValue();//对存在PedTemp温度值rcp的检查
                }
                saveRecipe();
            }
        }
    }

    public void doCreateRcp(String rcpName) {
        if (!winForm.elementById("mRcpName_tb").getText().isEmpty()) {
            winForm.elementById("mRcpName_tb").clear();
        }
        winForm.elementById("mRcpName_tb").sendKeys(rcpName);
        if (winForm.elementById("mRcpName_tb").getText().isEmpty()) {
            winForm.elementByName("确定").click();
            try {
                Thread.sleep(500);//添加延迟进程解决ErrorProvider图标闪烁时鼠标点击无法获取到Info
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getErrorProvider(String errorType) {
        switch (errorType) {
            case ("recipe命名"): {
                new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("mRcpName_tb").getElement()).moveByOffset((winForm.elementById("mRcpName_tb").getElement().getSize().width / 2) + 5, 0).perform();
                break;
            }
            case ("HeaterTemp"): {
                new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("mHeaterTemp_tb").getElement()).moveByOffset((winForm.elementById("mHeaterTemp_tb").getElement().getSize().width / 2) + 5, 0).perform();
                break;
            }
            case ("HeaterTol"): {
                new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("mHeaterTol_tb").getElement()).moveByOffset((winForm.elementById("mHeaterTol_tb").getElement().getSize().width / 2) + 5, 0).perform();
                break;
            }
            default:
                throw new RuntimeException("Unknown ErrorType " + errorType);
        }
        return winForm.getErrorProviderInfo();
    }

    public void setHeaterTemp(String temp) {
        if (!page.elementById("mHeaterTemp_tb").getText().isEmpty()) {
            page.elementById("mHeaterTemp_tb").clear();
        }
        page.elementById("mHeaterTemp_tb").sendKeys(temp);
    }

    public void setHeaterTol(String tol) {
        if (!page.elementById("mHeaterTol_tb").getText().isEmpty()) {
            page.elementById("mHeaterTol_tb").clear();
        }
        page.elementById("mHeaterTol_tb").sendKeys(tol);
    }
}


