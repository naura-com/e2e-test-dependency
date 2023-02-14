package com.naura.test.ui.page;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DataProcessPage extends ParentPage {

    @Autowired
    WinForm winForm;

    private final Window.WindowOperation page;

    public DataProcessPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void executeDataProc(String startTime, String endTime) {
        seletQueryTime(startTime, endTime);
        clickButton("查询");
    }

    public void seletQueryTime(String fromTime, String toTime) {
        seleteQueryFromTime(fromTime);
        seleteQueryToTime(toTime);
    }

    public void seleteQueryFromTime(String fromTime) {
        page.elementById("mStart_date").sendKeys(fromTime);
        page.elementById("mStart_date").sendKeys("-");
    }

    public void seleteQueryToTime(String toTime) {
        page.elementById("mEnd_date").sendKeys(toTime);
        page.elementById("mEnd_date").sendKeys("-");
    }

    public void clickButton(String operation) {
        page.elementByName(operation).click();
    }

    public void switchSelection(String selection) {
        page.elementByName(selection).click();
    }

    public void sureSelect(String selection) {
        if (!page.elementByName(selection).isSelect()) {
            switchSelection(selection);
            winForm.elementById("PopupMessage").elementByName("确定").click();
        }
    }

    public Object getLotList() {
        return page.getElementListValue("//Tree[@AutomationId='mLotID_treeView']/TreeItem");
    }

    public Object getTotal() {
        return page.elementById("mTotal_lab").getText();
    }

    public Object getLotListInfo() {
        return page.elementById("mLotInfo_dgv").getTableValue();
    }

    public void selectLot(String lotId) {
        page.elementById("mLotID_treeView").elementByName(lotId).click();
    }

    public Object getLotInfo() {
        return page.elementById("mLotInfo_ltb").getListValue();
    }

    public Object lotWafers(String lotId) {
        expandLot(lotId);
        return page.getElementListValue(String.format("//Tree[@AutomationId='mLotID_treeView']/TreeItem[@Name='%s']/TreeItem", lotId));
    }

    public Object moduleWafers(String module) {
        expandLot(module);
        return page.getElementListValue(String.format("//Tree[@AutomationId='mLotID_treeView']/CheckBox[@Name='%s']/CheckBox", module));
    }

    public Object getMaterialTitle() {
        return page.elementById("mProcInfoList_gb").getText();
    }

    public void selectMaterial(String lotId, String materialName) {
        expandLot(lotId);
        page.elementById("mLotID_treeView").elementByName(materialName).click();
    }

    private void expandLot(String lotId) {
        page.elementById("mLotID_treeView").elementByName(lotId).click();
        page.elementById("mLotID_treeView").elementByName(lotId).sendKeys(String.valueOf(Keys.ARROW_RIGHT));
    }

    public Object getMtProcList() {
        switchMtInfo("ProcessList");
        return page.elementById("mProcInfoList_dgv").getTableValue();
    }

    public void switchMtInfo(String infoName) {
        page.elementByName(String.format("   %s    ", infoName)).click();
    }

    public Object getMtHistoryList() {
        switchMtInfo("History List");
        return page.elementById("mHistoryList_dgv").getTableValue();
    }

    public void selectProcess(int processIndex) {
        switchMtInfo("ProcessList");
        page.elementById("mProcInfoList_dgv").selectCell(processIndex - 1, "Process");
    }

    public Object getRcpTitle() {
        return page.elementById("mRcpInfoList_gb").getText();
    }

    public Object getRcpSteps() {
        return page.elementById("mProcessInfoList_dgv").getTableValue();
    }

    public Object getRcpStepInfo() {
        return page.elementById("mRcpInfoList_dgv").getTableValue();
    }

    public void selectRcpStep(String stepIndex) {
        page.elementById("mProcessInfoList_dgv").selectCellByColumnName("Step", stepIndex);
    }

    public void selectRcpParam(List<String> paramList) {
        for (String param :
                paramList) {
            page.elementById("mRcpInfoList_dgv").selectCell("Param", param, "Graph");
        }
    }

    public Object getWaferInfo() {
        return page.elementById("mWaferInfo_ltb").getListValue();
    }

    public void selectMaterials(String module, List<String> materials) {
        expandLot(module);
        for (String material :
                materials) {
            page.elementById("mLotID_treeView").elementByName(material).sendKeys(String.valueOf(Keys.SPACE));
        }
    }
}
