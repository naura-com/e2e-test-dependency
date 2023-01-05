package com.naura.test.ui.page.Etch1.Alarm;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.Etch1.FileOption;
import com.naura.test.ui.page.ParentPage;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QueryPage extends ParentPage {

    @Autowired
    WinForm winForm;

    private final Window.WindowOperation page;

    @Autowired
    FileOption fileOption = new FileOption();

    public QueryPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void clickAction(String action) {
        winForm.elementByName(action).click();
    }

    public void selectModules(String modules){
        winForm.elementByName("Modules").elementByName("Select All").click().click();
        winForm.elementByName("Modules").elementByName(modules).click();
    }

    public void seletQueryTime(String fromTime, String toTime) {
        seleteQueryFromTime(fromTime);
        seleteQueryToTime(toTime);
    }

    public void seleteQueryFromTime(String fromTime) {
        winForm.elementById("dateTimePicker1").sendKeys(fromTime);
    }

    public void seleteQueryToTime(String toTime) {
        winForm.elementById("dateTimePicker2").sendKeys(toTime);
    }

    public void selectSeverity(String severity) {
        winForm.elementById("chkListSeverity").elementByName(severity).click();
    }

    public void clickId(String id) {
        winForm.elementById(id).click();
    }

    public List<Object> getAlarmInfos() {
        List<Object> alarmInfos = new ArrayList<>();
        for (int i = 0; i < page.elementById("listAlarm").elementsByTag("ListItem").size(); i++) {
            List<Object> alarm = new ArrayList<>();
            for (int j = 0; j < page.elementById("ListViewItem-" + i).elementsByTag("Text").size(); j++) {
                alarm.add(page.elementById("ListViewItem-" + i).elementsByTag("Text").get(j).getText());
            }
            alarmInfos.add(alarm);
        }
        return alarmInfos;
    }

    public void findFile(String path) {
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementByName("文件名(N):").getElement(), 100, 10).click().sendKeys(path).perform();
        winForm.elementByName("打开(O)").click();
    }

    public void exportOk(String action, String path, String fileName) {
        clickAction(action);
        winForm.elementById("FileNameControlHost").elementById("1001").sendKeys(path + "\\" + fileName);
        clickAction("保存(S)");
//        clickAction("OK");
    }

    public String[] getFilesList(String dir) {
        File file = new File(dir);
        return Objects.requireNonNull(file.list());
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

    public boolean isSelectModules(String module) {
        if (module.equals("CTC")) {
            page.elementById("chkListModName").elementByName("下一行").click();
        }
        return page.elementByName(module).isSelect();
    }

    public boolean isSelectSeverity(String module) {
        if (module.equals("NOTICE")) {
            page.elementById("chkListSeverity").elementByName("下一行").click();
        }
        return page.elementByName(module).isSelect();
    }

    public boolean isSelect(String id) {
        return page.elementById("checkBox1").isSelect();
    }
}
