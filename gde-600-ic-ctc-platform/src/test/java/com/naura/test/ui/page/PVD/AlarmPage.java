package com.naura.test.ui.page.PVD;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;

public class AlarmPage extends ParentPage {
    private final Window.WindowOperation page;

    private final WinForm winForm;

    public AlarmPage(Window.WindowOperation page, WinForm winForm) {
        super(new CurrentAlarmPage(winForm.elementById("FormCurrentAlarm"), winForm));
        this.page = page;
        this.winForm = winForm;
    }

    public CurrentAlarmPage currentAlarmPage() {
        return switchTo(CurrentAlarmPage.class, () -> page.elementById("mAlarmCur_navibtn").click(),
                () -> new CurrentAlarmPage(winForm.elementById("FormCurrentAlarm"), winForm));
    }

    public AlarmLogPage alarmLogPage() {
        return switchTo(AlarmLogPage.class, () -> page.elementById("mAlarmLog_navibtn").click(),
                () -> new AlarmLogPage(winForm.elementById("FormAlarmHistory"), winForm));
    }
}
