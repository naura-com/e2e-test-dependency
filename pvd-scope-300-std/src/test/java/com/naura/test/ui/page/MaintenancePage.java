package com.naura.test.ui.page;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;

public class MaintenancePage extends ParentPage {
    private final Window.WindowOperation page;
    private final WinForm winForm;

    public MaintenancePage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public MaintChamberPage maintChamberPage() {
        return switchTo(MaintChamberPage.class, () -> page.elementById("mMaintChamber_navibtn").click(),
                () -> new MaintChamberPage(winForm.elementById("FormMaintChamber_CVDMOW_sim"), winForm));
    }

    public TransferPlatformPage transferPlatformPage() {
        return switchTo(TransferPlatformPage.class, () -> page.elementById("mMaintPlatform_navibtn").click(),
                () -> new TransferPlatformPage(winForm.elementById("FormPlatform_12K"), winForm));
    }

    public InterlockPage interlockPage() {
        return switchTo(InterlockPage.class, () -> page.elementById("mMaintIntlk_navibtn").click(),
                () -> new InterlockPage(winForm.elementById("FormInterlock"), winForm));
    }
}
