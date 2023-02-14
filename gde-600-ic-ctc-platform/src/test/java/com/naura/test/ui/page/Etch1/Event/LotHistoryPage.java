package com.naura.test.ui.page.Etch1.Event;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.FileOption;
import com.naura.test.ui.page.ParentPage;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class LotHistoryPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    @Autowired
    private Window.WindowOperation pageTable;

    @Autowired
    FileOption fileOption = new FileOption();

    public void cleanDir() {
        fileOption.cleanDir("C:\\test\\etch1\\Debug\\data\\history log");
        fileOption.createDir("C:\\test\\etch1\\Debug\\data\\history log\\2000-01-01");
    }


    public LotHistoryPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void manualProFilePrepare(Table table) {
        for (int num = 0; num < table.size(); num++) {
            fileOption.lotMProFile(table.get(num).get("Day").toString(), table.get(num).get("Time").toString(), table.get(num).get("LotID").toString(), String.valueOf(num + 1));
        }
    }

    public void exportJobs() {
        winForm.elementById("btnExportJob").click();
    }

    public void exportSlot() {
        winForm.elementById("btnExport").click();
    }

    public void queryHist(String arg0, String arg1) {
        winForm.elementById("dtStart").sendKeys(arg0 + "/");
        winForm.elementById("dtEnd").sendKeys(arg1 + "/");
        winForm.elementById("btnQuery").click();
    }

    public void selectManualMode() {
        winForm.elementById("radio_ManualMode").click();
    }

    public void selectAutoMode() {
        winForm.elementById("radio_AutoMode").click();
    }

    public List<Object> getManProTableInfo() {
        List<Object> alarmInfos = new ArrayList<>();
        pageTable = page.elementById("tableLayoutPanel2").elementById("groupBox2").elementById("tlLot");
        for (int i = 0; i < pageTable.elementsByTag("ListItem").size(); i++) {
            List<Object> alarm = new ArrayList<>();
            for (int j = 0; j < pageTable.elementById("ListViewItem-" + i).elementsByTag("Text").size(); j++) {
                if (j == 0 || j == 2 || j == 3 || j == 4)
                    alarm.add(pageTable.elementById("ListViewItem-" + i).elementsByTag("Text").get(j).getText());
            }
            alarmInfos.add(alarm);
        }
        return alarmInfos;
    }

    public void autoFilePrepareL(Table table) {
        fileOption.lotAutoFileL(table);
    }

    public void autoFilePrepareR(Table table) {
        fileOption.lotAutoFileR(table);
    }

    public void autoFilePrepareW(int fileid, Table table) {
        fileOption.lotAutoFileW(fileid, table);
    }

    public List<Object> getAutoTableInfo() {
        List<Object> alarmInfos = new ArrayList<>();
        pageTable = page.elementById("tableLayoutPanel2").elementById("groupBox2").elementById("tlLot");
        for (int i = 0; i < pageTable.elementsByTag("ListItem").size(); i++) {
            List<Object> alarm = new ArrayList<>();
            for (int j = 0; j < pageTable.elementById("ListViewItem-" + i).elementsByTag("Text").size(); j++) {
                if (j == 0 || j == 2 || j == 3 || j == 4 || j == 5 || j == 6)
                    alarm.add(pageTable.elementById("ListViewItem-" + i).elementsByTag("Text").get(j).getText());
            }
            alarmInfos.add(alarm);
        }
        return alarmInfos;
    }

    public List<Object> getSlotTableInfo() {
        List<Object> alarmInfos = new ArrayList<>();
        pageTable = page.elementById("splitContainer3").elementById("groupBox3").elementById("tlLog");
        for (int i = 0; i < pageTable.elementsByTag("ListItem").size(); i++) {
            List<Object> alarm = new ArrayList<>();
            for (int j = 0; j < pageTable.elementById("ListViewItem-" + i).elementsByTag("Text").size(); j++) {
                alarm.add(pageTable.elementById("ListViewItem-" + i).elementsByTag("Text").get(j).getText());
            }
            alarmInfos.add(alarm);
        }
        return alarmInfos;
    }

    public List<Object> getStepTableInfo() {
        List<Object> alarmInfos = new ArrayList<>();
        pageTable = page.elementById("splitContainer3").elementById("groupBox4").elementById("tlLogStep");
        for (int i = 0; i < pageTable.elementsByTag("ListItem").size(); i++) {
            List<Object> alarm = new ArrayList<>();
            for (int j = 0; j < pageTable.elementById("ListViewItem-" + i).elementsByTag("Text").size(); j++) {
                alarm.add(pageTable.elementById("ListViewItem-" + i).elementsByTag("Text").get(j).getText());
            }
            alarmInfos.add(alarm);
        }
        return alarmInfos;
    }

    public void selectFirstJobQuery() {
        new Actions(winForm.getWindowsDriver()).doubleClick(page.elementById("tableLayoutPanel2").elementById("groupBox2").elementById("ListViewItem-0").getElement()).perform();
    }

    public void selectFirstSlotDetails() {
        new Actions(winForm.getWindowsDriver()).doubleClick(page.elementById("splitContainer3").elementById("groupBox3").elementById("ListViewItem-0").getElement()).perform();
    }

    public List<Object> getFlowTableInfo() {
        List<Object> alarmInfos = new ArrayList<>();
        pageTable = page.elementById("tableLayoutPanel2").elementById("groupBox5").elementById("twaferop");
        for (int i = 0; i < pageTable.elementsByTag("ListItem").size(); i++) {
            List<Object> alarm = new ArrayList<>();
            for (int j = 0; j < pageTable.elementById("ListViewItem-" + i).elementsByTag("Text").size(); j++) {
                alarm.add(pageTable.elementById("ListViewItem-" + i).elementsByTag("Text").get(j).getText());
            }
            alarmInfos.add(alarm);
        }
        return alarmInfos;
    }
}
