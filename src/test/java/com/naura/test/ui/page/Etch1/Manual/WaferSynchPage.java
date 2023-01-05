package com.naura.test.ui.page.Etch1.Manual;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WaferSynchPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public WaferSynchPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void clickAll() {
        winForm.elementById("chkAll").click();
    }

    public void clickLP(String lp) {
        switch (lp) {
            case "LoadLock A":
                clickByOffset(100, 200);
                break;
            case "LoadLock B":
                clickByOffset(175, 200);
                break;
            case "PM":
                clickByOffset(100, 60);
                break;
            case "AL":
                clickByOffset(120, 165);
                break;
            case "TM":
                clickByOffset(135, 135);
                break;
            case "Center":
                clickByOffset(225, 135);
                break;
        }
    }

    private void clickByOffset(int x, int y) {
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("NavigationOfWfrResync").getElement(), x, y).
                click().click().perform();
    }


    public void setCTCUnknown(String i) {
        String a = sureCTCStatus(i);
        switch (a) {
            case "WAFER_UNKNOWN":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_ABSENT":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("wwww").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_PRESENT":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("www").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_XSLOTTED":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("ww").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_DOUBLED":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("w").sendKeys(String.valueOf(Keys.ENTER));
        }
    }

    public void setCTCAbsent(String i) {
        String a = sureCTCStatus(i);
        switch (a) {
            case "WAFER_UNKNOWN":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("w").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_ABSENT":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_PRESENT":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("wwww").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_XSLOTTED":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("www").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_DOUBLED":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("ww").sendKeys(String.valueOf(Keys.ENTER));
                break;
        }
    }

    public void setCTCPresent(String i) {
        String a = sureCTCStatus(i);
        switch (a) {
            case "WAFER_UNKNOWN":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("ww").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_ABSENT":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("w").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_PRESENT":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_XSLOTTED":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("wwww").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_DOUBLED":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("www").sendKeys(String.valueOf(Keys.ENTER));
        }
    }

    public void setCTCXslotted(String i) {
        String a = sureCTCStatus(i);
        switch (a) {
            case "WAFER_UNKNOWN":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("www").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_ABSENT":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("ww").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_PRESENT":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("w").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_XSLOTTED":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_DOUBLED":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("wwww").sendKeys(String.valueOf(Keys.ENTER));
        }
    }

    public void setCTCDoubled(String i) {
        String a = sureCTCStatus(i);
        switch (a) {
            case "WAFER_UNKNOWN":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("wwww").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_ABSENT":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("www").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_PRESENT":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("ww").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_XSLOTTED":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("w").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "WAFER_DOUBLED":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys(String.valueOf(Keys.ENTER));
        }
    }

    public String sureCTCStatus(String i) {
        return winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").getText();
    }

    public String sureToolStatus(String i) {
        return winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-2").getText();
    }

    public String sureWaferStatus(String i) {
        return winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-3").getText();
    }

    public void synWithCTC() {
        winForm.elementById("btnSynWithCTC").click();
    }

    public void synWithTool() {
        winForm.elementById("btnSynWithTool").click();
    }

    public void allSetCTCPresent(String lp) {
        clickLP(lp);
        clickAll();
        setCTCPresent("0");
        synWithCTC();
        clickAll();
    }

    public void allSetCTCAbsent(String lp) {
        clickLP(lp);
        clickAll();
        setCTCAbsent("0");
        synWithCTC();
        clickAll();
    }

    public void setWaferLoad(String arg0, DataTable datatable) {
        allSetCTCAbsent(arg0);
        for (int i = 0; i < datatable.row(0).size(); i++) {
            setCTCPresent(String.valueOf(Integer.parseInt(datatable.row(0).get(i)) - 1));
        }
        synWithCTC();
    }

    public void clearResyneAlarm() {
        synWithCTC();
        synWithTool();
        synWithCTC();
    }

    public void allModuleSetPresent() {
        allSetCTCPresent("LoadLock A");
        allSetCTCPresent("LoadLock B");
        allSetCTCPresent("PM");
        allSetCTCPresent("AL");
        allSetCTCPresent("TM");
        allSetCTCPresent("Center");
        synWithCTC();
    }

    public void allModuleSetAbsent() {
        allSetCTCAbsent("LoadLock A");
        allSetCTCAbsent("LoadLock B");
        allSetCTCAbsent("PM");
        allSetCTCAbsent("AL");
        allSetCTCAbsent("TM");
        allSetCTCAbsent("Center");
        synWithCTC();
    }

    public void sureAllCTCstatus(String status) {
        List<Object> view = winForm.elementById("listViewExDetail").getListValue();
        for (int i = 0; i < view.size(); i++) {
            assertThat(winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-1").getText().equals(status));
        }
    }

    public void setWaferStatus(String wafer, String status) {
        switch (status) {
            case "processing":
            case "processed":
                while (!sureWaferStatus(wafer).equals(status)) {
                    winForm.elementById("listViewExDetail").elementById("ListViewItem-" + wafer).elementById("ListViewSubItem-3").click().click();
                    winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("p").sendKeys(String.valueOf(Keys.ENTER));
                }
                break;
            case "unknown":
            case "unprocessed":
                while (!sureWaferStatus(wafer).equals(status)) {
                    winForm.elementById("listViewExDetail").elementById("ListViewItem-" + wafer).elementById("ListViewSubItem-3").click().click();
                    winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("u").sendKeys(String.valueOf(Keys.ENTER));
                }
                break;
            case "doubled":
            case "done":
                while (!sureWaferStatus(wafer).equals(status)) {
                    winForm.elementById("listViewExDetail").elementById("ListViewItem-" + wafer).elementById("ListViewSubItem-3").click().click();
                    winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("d").sendKeys(String.valueOf(Keys.ENTER));
                }
                break;
            case "xslotted":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + wafer).elementById("ListViewSubItem-3").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("x").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "bad":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + wafer).elementById("ListViewSubItem-3").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("b").sendKeys(String.valueOf(Keys.ENTER));
                break;
            case "none":
                winForm.elementById("listViewExDetail").elementById("ListViewItem-" + wafer).elementById("ListViewSubItem-3").click().click();
                winForm.elementById("listViewExDetail").elementByTag("ComboBox").sendKeys("n").sendKeys(String.valueOf(Keys.ENTER));
        }
    }

    public void allSetWaferStatus(String LP, String status) {
        clickLP(LP);
        clickAll();
        setWaferStatus("0", status);
        clickAll();
    }

    public void sureAllWaferStatus(String status) {
        List<Object> view = winForm.elementById("listViewExDetail").getListValue();
        for (int i = 0; i < view.size(); i++) {
            assertThat(winForm.elementById("listViewExDetail").elementById("ListViewItem-" + i).elementById("ListViewSubItem-3").getText().equals(status));
        }
    }

    public void setLpWaferPresent(String lp, String wafer) {
        clickLP(lp);
        setCTCPresent(String.valueOf(Integer.parseInt(wafer) - 1));
        synWithCTC();
    }
}
