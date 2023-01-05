package com.naura.test.ui.page.PVD;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class InterlockPage {

    private final Window.WindowOperation page;
    private final WinForm winForm;

    public InterlockPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public Set<Object> getTabControl() {
        return page.elementById("mSimpleTabCtrl_tb").getTablePage();
    }

    public List<Map<Object, Object>> getDgvValue() {
        return page.elementByName("DataGridView").getTableValue();
    }

    public void switchTo(String chamber, String interlockType) {
        page.elementByName("    " + chamber).click();
        page.elementByName("   " + interlockType + "   ").click();
    }

    public void activeAllInterlock() {
        page.elementById("mActive_btn").click();
    }

    public void deactivateAllInterlock() {
        page.elementById("mDeactive_btn").click();
    }

    public void clickInterlockName(String interlockName) {
        page.elementByName("DataGridView").selectCellByColumnName("互锁名称", interlockName);
    }

    public Object getInterlockName(String interlockType) {
        if (interlockType.equals("SetValue"))
            return page.elementById("mSetValueName_tb").getValue();
        if (interlockType.equals("OverRun"))
            return page.elementById("mOverRunName_tb").getValue();
        else
            return null;
    }

    public Object getDefenseObject() {
        return page.elementById("mProtectObj_tb").getValue();
    }

    public Object getTriggerCondition(String interlockType) {
        if (interlockType.equals("SetValue"))
            return page.elementById("mTriger_tb").getValue();
        if (interlockType.equals("OverRun"))
            return page.elementById("mOverRunTrigger_tb").getValue();
        else
            return null;
    }

    public List<Object> getCheckCondition() {
        return page.elementById("mChecker_lstb").getListValue();
    }

    public Object getAlarmInfo(String interlockType) {
        if (interlockType.equals("SetValue"))
            return page.elementById("mSetValueAlarm_tb").getValue();
        if (interlockType.equals("OverRun"))
            return page.elementById("mOverRunAlarm_tb").getValue();
        else
            return null;
    }

    public List<Object> getAction() {
        return page.elementById("mOverRunAction_lstb").getListValue();
    }

    public void activeInterlock(Table table) {
        List<Map<Object, Window.WindowOperation>> list = page.elementByName("DataGridView").asTable();
        for (Map<String, ?> map : table) {
            for (Map<Object, Window.WindowOperation> row : list) {
                if (row.get("互锁名称").getText().equals(map.get("name"))) {
                    if (row.get("状态").getText().equals("　屏蔽　")) {
                        row.get("操作").click();
                    }
                    break;
                }

            }
        }
    }

    public void deactivateInterlock(Table table) {
        List<Map<Object, Window.WindowOperation>> list = page.elementByName("DataGridView").asTable();
        for (Map<String, ?> map : table) {
            for (Map<Object, Window.WindowOperation> row : list) {
                if (row.get("互锁名称").getText().equals(map.get("name"))) {
                    if (row.get("状态").getText().equals("　激活　")) {
                        row.get("操作").click();
                    }
                    break;
                }

            }
        }
    }
}
