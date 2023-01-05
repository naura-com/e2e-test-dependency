package com.naura.test.ui.page.Etch1.Alarm;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;

public class StatusPage extends ParentPage {

    @Autowired
    WinForm winForm;

    private final Window.WindowOperation page;

    public StatusPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public boolean alarmExist(String alarm) {
        try {
            winForm.elementById("ListAlarm").elementByName(alarm);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void alarmClear(String alarm) {
        winForm.elementById("ListAlarm").elementByName(alarm).click();
        winForm.elementById("ListRecovery").elementByName("Clear").click();
        winForm.elementByName("Run").click();
    }

    public boolean alarmUnExist(String alarm) {
        return !alarmExist(alarm);
    }

    public Object alarmInfo(String alarm) {
        winForm.elementById("ListAlarm").elementByName(alarm).click();
        return winForm.elementById("tb_AlarmDescription").getValue();
    }

    public void clearOtherAlarm() {
        while (true) {
            try {
                winForm.elementById("ListAlarm").elementById("ListViewItem-0").click();
                winForm.elementById("ListRecovery").elementById("ListViewItem-0").click();
                winForm.elementById("btnRecovey").click();
            } catch (Exception e) {
                return;
            }
        }
    }


    public boolean clickResyneAlarm() {
        try {
            winForm.elementById("ListAlarm").elementByName("ToolLocalDifferent").click();
            winForm.elementById("ListRecovery").elementByName("Resync").click();
            winForm.elementById("btnRecovey").click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean click500mTAlarm() {
        try {
            winForm.elementById("ListAlarm").elementByName("/Control/Util/StatusMonitor/ChamberPressAbove500mT/TriggeredAlarm").click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
