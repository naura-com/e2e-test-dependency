package com.naura.test.ui.page.PVD;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainPage extends ParentPage {

    @Autowired
    private WinForm winForm;

    public String getMessageAndDo(String operation) {
        String message = winForm.elementById("PopupMessage").elementById("mMsg_lbl").getText();
        doMessage(operation);
        return message;
    }

    public void doMessage(String operation) {
        winForm.elementById("PopupMessage").elementByName(operation).click();
    }

    public void clickAction(String action) {
        winForm.elementByName(action).click();
    }

    public String getMessage() {
        String message = winForm.elementById("mMsg_lbl").getText();
        makeSure();
        return message;
    }

    public void makeSure() {
        winForm.elementByName("确定").click();
    }

    public void makeCancel() {
        winForm.elementByName("取消").click();
    }

    public void clickYes() {
        //winForm.elementByName("是(Y)").click();
        winForm.elementById("CommandButton_6").click();
    }

    public EditPage editPage() {
        return switchTo(EditPage.class, () -> winForm.elementById("mEditor_navibtn").click(),
                () -> new EditPage(winForm.elementById("mRecipe_pnl"), winForm));
    }

    public MaintenancePage maintenancePage() {
        return switchTo(MaintenancePage.class, () -> winForm.elementById("mMaint_navibtn").click(),
                () -> new MaintenancePage(winForm.elementById("mMaint_pnl"), winForm));
    }

    public ConfigPage configPage() {
        return switchTo(ConfigPage.class, () -> winForm.elementById("mSetup_navibtn").click(),
                () -> new ConfigPage(winForm.elementById("mSetup_pnl"), winForm));
    }

    public AlarmPage alarmPage() {
        return switchTo(AlarmPage.class, () -> winForm.elementById("mAlarm_navibtn").click(),
                () -> new AlarmPage(winForm.elementById("mAlarm_pnl"), winForm));
    }

    public OverViewPage overViewPage() {
        return switchTo(OverViewPage.class, () -> winForm.elementById("mJobs_navibtn").click(),
                () -> new OverViewPage(winForm.elementById("mJobs_pnl"), winForm));
    }

    public DataPage dataPage() {
        return switchTo(DataPage.class, () -> winForm.elementById("mDataLog_navibtn").click(),
                () -> new DataPage(winForm.elementById("mDataLog_pnl"), winForm));
    }
}
