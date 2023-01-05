package com.naura.test.ui.page.Etch1.Maintain;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;

public class MaintainPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public MaintainPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public ChamberPage chamberPage() {
        return switchTo(ChamberPage.class, () -> winForm.elementById("Chamber").click(),
                () -> new ChamberPage(winForm.elementById("frmChamberGDE"), winForm));
    }

    public TMChamberPage tmChamberPage() {
        return switchTo(TMChamberPage.class, () -> toTM("Chamber"),
                () -> new TMChamberPage(winForm.elementById("frmTMChamber"), winForm));
    }

    public TMVacuumPage tmVacuumPage() {
        return switchTo(TMVacuumPage.class, () -> toTM("Vacuum"),
                () -> new TMVacuumPage(winForm.elementById("frmTmcVaccum"), winForm));
    }

    private void toTM(String tabName) {
        winForm.elementById("TM Chamber").click();
        try {
            winForm.elementByName("To TM " + tabName).click();
        } catch (Exception e) {
        }
    }
}
