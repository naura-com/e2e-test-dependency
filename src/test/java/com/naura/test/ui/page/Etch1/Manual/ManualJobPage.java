package com.naura.test.ui.page.Etch1.Manual;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import io.cucumber.datatable.DataTable;
import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.Keys;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;

public class ManualJobPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public ManualJobPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void clickAction(String action) {
        winForm.elementByName(action).click();
    }

    public void clickId(String id) {
        winForm.elementById(id).click();
    }

    public List<Object> getSetWaferflowList() {
        return winForm.elementById("listBox1").getListValue();
    }

    public void clickSetWaferflow(String lp) {
        switch (lp) {
            case "LoadLock A":
                clickId("SetWfrFlowLeft");
                break;
            case "LoadLock B":
                clickId("btnSetWfrFlow2");
                break;
        }
    }

    public void clickDeleteWaferflow(String lp) {
        switch (lp) {
            case "LoadLock A":
                clickId("btnDeleteLeft");
                break;
            case "LoadLock B":
                clickId("btnDelete");
                break;
        }
    }

    public void clickSetMapWaferflow(String lp) {
        switch (lp) {
            case "LoadLock A":
                clickId("btn_setMapwafer1");
                break;
            case "LoadLock B":
                clickId("btn_setMapwafer2");
                break;
        }
    }

    public void setWaferflow(String lp, DataTable table) {
        for (int row = 1; row < table.height(); row++) {
            winForm.elementById(getEditJobWaferID(lp)).elementById("ListViewItem-" + (Integer.parseInt(table.row(row).get(0)) - 1)).click();
            clickSetWaferflow(lp);
            clickAction(table.row(row).get(1));
            clickAction("Set");
        }
    }

    public String getEditJobWaferID(String lp) {
        switch (lp) {
            case "LoadLock A":
                return "jobLsvLeft";
            case "LoadLock B":
                return "job1Lsv";
        }
        return null;
    }

    public Map<Object, Object> getEditJobWaferflow(String lp) {
        Map<Object, Object> routeList = new HashMap<>();
        Window.WindowOperation operationwafer = winForm.elementById(getEditJobWaferID(lp));
        for (int i = 0; i < 25; i++) {
            routeList.put(operationwafer.elementById("ListViewItem-" + i).elementById("ListViewSubItem-0").getText(),
                    operationwafer.elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").getText());
        }
        return routeList;
    }

    public void lpSetWaferflow(DataTable table) {
        for (int row = 1; row < table.height(); row++) {
            winForm.elementById(getEditJobWaferID(table.row(row).get(0))).elementById("ListViewItem-" + (Integer.parseInt(table.row(row).get(1)) - 1)).click();
            clickSetWaferflow(table.row(row).get(0));
            clickAction(table.row(row).get(2));
            clickAction("Set");
        }
    }

    public void lpDelWaferflow(DataTable table) {
        for (int row = 1; row < table.height(); row++) {
            winForm.elementById(getEditJobWaferID(table.row(row).get(0))).elementById("ListViewItem-" + (Integer.parseInt(table.row(row).get(1)) - 1)).click();
            clickDeleteWaferflow(table.row(row).get(0));
        }
    }

    public void setMapWfr(String arg0, String arg1) {
        clickSetMapWaferflow(arg0);
        clickAction(arg1);
        clickAction("Set");
    }

    public void clearAll(String lp) {
        clickClearAll(lp);
    }

    private void clickClearAll(String lp) {
        switch (lp) {
            case "LoadLock A":
                winForm.elementById("btnClearAllLeft").click();
                break;
            case "LoadLock B":
                winForm.elementById("pnlJob2").elementById("groupBox1").elementById("btnClearAll").click();
                break;
        }
    }

    public void setLotID(String lp, String lotid) {
        switch (lp) {
            case "LoadLock A":
                winForm.elementById("lotIDLeft").clear().sendKeys(lotid);
                break;
            case "LoadLock B":
                winForm.elementById("lotIDRight").clear().sendKeys(lotid);
                break;
        }
    }

    public void clickScheduleMode(String lp) {
        switch (lp) {
            case "LoadLock A":
                page.elementById("scheduleModeLeft").elementByName("打开").click();
                break;
            case "LoadLock B":
                page.elementById("scheduleMode").elementByName("打开").click();
                break;
        }
    }

    public List<Object> getScheduleModeList(String lp) {
        List<Object> scheduleModeList = new ArrayList<>();
        Window.WindowOperation schedulPage = page.elementById(getscheduleModeID(lp)).elementByName("打开").click();
        scheduleModeList.add(page.elementById(getscheduleModeID(lp)).getText());
        while (true) {
            schedulPage.sendKeys(String.valueOf(Keys.UP));
            Object value = page.elementById(getscheduleModeID(lp)).getText();
            if (scheduleModeList.contains(value)) {
                break;
            }
            scheduleModeList.add(value);
        }
        page.elementById("scheduleModeLeft").getText();
        return scheduleModeList;
    }

    String getscheduleModeID(String lp) {
        switch (lp) {
            case "LoadLock A":
                return "scheduleModeLeft";
            case "LoadLock B":
                return "scheduleMode";
        }
        return null;
    }

    @Nullable
    public Window.WindowOperation getLpWindowOperation(String lp) {
        switch (lp) {
            case "LoadLock A":
                return page.elementById("panel4");
            case "LoadLock B":
                return page.elementById("panel3");
        }
        return null;
    }


    public void setModuleValue(String lp, String module, String value) {
        //TODO 无法清空文本框内容
        getLpWindowOperation(lp).elementByName(module).clear().sendKeys(String.valueOf(Keys.ARROW_RIGHT)).sendKeys(value);
    }

    public List<Object> getModuleValue(String lp, String module) {
        List<Object> moduleValue = new ArrayList<>();
        moduleValue.add(getLpWindowOperation(lp).elementByName(module).getText());
        return moduleValue;
    }

    public void lpActionClick(String lp, String action) {
        getLpWindowOperation(lp).elementByName(action).click();
        switch (action) {
            case "Start":
                clickAction("OK");
                break;
            case "End":
                clickAction("Yes");
                break;
            case "Abort":
                clickAction("Yes");
                break;
        }
    }

    public void setCycleNum(String lp, String value) {
        ((getLpWindowOperation(lp).elementByName("Cycle Num").clear()).sendKeys(String.valueOf(Keys.RIGHT))).sendKeys(value);
    }

    public void setSingleWaferJob(DataTable table) {
        lpSetWaferflow(table);
        for (int i = 1; i < table.height(); i++) {
//            lpSetWaferflow(table.subTable(0, 0, table.height(), 3));
            setLotID(table.row(i).get(0), table.row(i).get(3));
            setCycleNum(table.row(i).get(0), table.row(i).get(4));
        }
    }

    public List<Object> getJobState(String lp, String action) {
        List<Object> jobInfos = new ArrayList<>();
        String lpindex = getJobComIndex(lp);
        boolean state = false;
        switch (action) {
            case "Start":
                state = waitJobRunning(lp);
                break;
            case "End":
                state = waitJobAborted(lp);
                break;
            case "Completed":
                state = waitJobCompleted(lp);
                break;
            case "Validated":
                state = waitJobValidated(lp);
                break;
            case "Abort":
                state = waitJobAborted(lp);
                break;
        }
        if (state) {
            jobInfos.add(page.elementById("txt_CurrentJobName" + lpindex).getText());
            jobInfos.add(page.elementById("txt_CurrentJobState" + lpindex).getText());
            jobInfos.add(page.elementById("txt_CurrentLotID" + lpindex).getText());
            jobInfos.add(page.elementById("txt_CurrentCycleLeft" + lpindex).getText());
        }
//        await().until(() -> page.elementById("txt_CurrentJobState" + lpindex).getText().equals("JobCompleted"));
        return jobInfos;
    }

    public String getJobComIndex(String lp) {
        if (lp.equals("LoadLock A")) {
            return "1";
        } else {
            return "2";
        }
    }

    public boolean waitJobCompleted(String lp) {
//        await().until(() -> page.elementById("txt_CurrentJobState" + getJobComIndex(lp)).getText().equals("JobCompleted"));
        while (true) {
            if (page.elementById("txt_CurrentJobState" + getJobComIndex(lp)).getText().equals("JobCompleted")) {
                return true;
            }
            if (page.elementById("txt_CurrentJobState" + getJobComIndex(lp)).getText().equals("Aborted")) {
                return false;
            }
        }
    }

    public boolean waitJobRunning(String lp) {
        await().timeout(Duration.ofSeconds(100)).untilAsserted(() -> assertThat(page.elementById("txt_CurrentJobState" + getJobComIndex(lp)).getText().equals("Running")).isTrue());
//        for (int i = 0; i < 20; i++) {
//            if (page.elementById("txt_CurrentJobState" + getJobComIndex(lp)).getText().equals("Running")) {
//                return true;
//            }
//        }
        return true;
    }

    public boolean waitJobAborted(String lp) {
//        for (int i = 0; i < 20; i++) {
//            if (page.elementById("txt_CurrentJobState" + getJobComIndex(lp)).getText().equals("Aborted")) {
//                return true;
//            }
//        }
//        return false;
        await().timeout(Duration.ofSeconds(200)).untilAsserted(() -> assertThat(page.elementById("txt_CurrentJobState" + getJobComIndex(lp)).getText().equals("Aborted")).isTrue());
        return true;
    }

    public boolean waitJobValidated(String lp) {
//        for (int i = 0; i < 20; i++) {
//            if (page.elementById("txt_CurrentJobState" + getJobComIndex(lp)).getText().equals("Validated")) {
//                return true;
//            }
//        }
//        return false;
        await().timeout(Duration.ofSeconds(200)).untilAsserted(() -> assertThat(page.elementById("txt_CurrentJobState" + getJobComIndex(lp)).getText().equals("Validated")).isTrue());
        return true;
    }

    public void setAllWaferJob(DataTable table) {
        for (int i = 1; i < table.height(); i++) {
            setMapWfr(table.row(i).get(0), table.row(i).get(1));
            setLotID(table.row(i).get(0), table.row(i).get(2));
            setCycleNum(table.row(i).get(0), table.row(i).get(3));
        }
    }
}
