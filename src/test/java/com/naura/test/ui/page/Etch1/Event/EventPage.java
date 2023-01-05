package com.naura.test.ui.page.Etch1.Event;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;

public class EventPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public EventPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public LotHistoryPage lotHistoryPage() {
        return switchTo(LotHistoryPage.class, () -> winForm.elementById("Lot History").click(),
                () -> new LotHistoryPage(winForm.elementById("frmHisLog"), winForm));
    }

}
