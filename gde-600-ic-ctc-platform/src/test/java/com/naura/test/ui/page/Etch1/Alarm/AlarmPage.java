package com.naura.test.ui.page.Etch1.Alarm;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;

public class AlarmPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public AlarmPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public StatusPage statusPage() {
        return switchTo(StatusPage.class, () -> winForm.elementById("Status").click(),
                () -> new StatusPage(winForm.elementById("frmAlarm"), winForm));
    }

    public QueryPage queryPage() {
        return switchTo(QueryPage.class, () -> winForm.elementById("Query").click(),
                () -> new QueryPage(winForm.elementById("frmAlarmQuery"), winForm));
    }
}
