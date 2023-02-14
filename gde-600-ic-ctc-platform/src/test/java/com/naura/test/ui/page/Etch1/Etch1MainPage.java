package com.naura.test.ui.page.Etch1;

import com.naura.test.config.ContextWrapper;
import com.naura.test.api.LowerSteps;
import com.naura.test.api.api.LowerApi;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Alarm.AlarmPage;
import com.naura.test.ui.page.Etch1.Edit.EditPage;
import com.naura.test.ui.page.Etch1.Event.EventPage;
import com.naura.test.ui.page.Etch1.Maintain.MaintainPage;
import com.naura.test.ui.page.Etch1.Manual.ManualPage;
import com.naura.test.ui.page.Etch1.Setup.SetupPage;
import com.naura.test.ui.page.Etch1.System.SystemPage;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.Duration;
import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;

@Component
public class Etch1MainPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    private StartupPage startupPage;

    public void login() {
        try {
            winForm.elementById("btnLogin").click();
        } catch (Exception e) {
            winForm.getWindowsDriver().findElementById("btnLogin").click();
        }
        winForm.elementById("combUid").sendKeys("sa");
        winForm.elementById("TxtPasswd").sendKeys("888888");
        winForm.elementByName("Log in").click();
    }

    public void login(String user, String password) {
        winForm.elementById("btnLogin").click();
        winForm.elementById("combUid").sendKeys(user);
        winForm.elementById("TxtPasswd").sendKeys(password);
        winForm.elementByName("Log in").click();
    }

    public SetupPage setupPage() {
        return switchTo(SetupPage.class, () -> winForm.elementById("Setup").click(),
                () -> new SetupPage(winForm.elementById("pnlSystem"), winForm));
    }

    public EditPage editPage() {
        return switchTo(EditPage.class, () -> winForm.elementById("Editor").click(),
                () -> new EditPage(winForm.elementById("pnlSystem"), winForm));
    }

    public ManualPage manualPage() {
        return switchTo(ManualPage.class, () -> winForm.elementById("Manual").click(),
                () -> new ManualPage(winForm.elementById("pnlSystem"), winForm));
    }

    public AlarmPage alarmPage() {
        return switchTo(AlarmPage.class, () -> winForm.elementById("Alarm").click(),
                () -> new AlarmPage(winForm.elementById("pnlSystem"), winForm));
    }

    public SystemPage systemPage() {
        return switchTo(SystemPage.class, () -> winForm.elementById("System").click(),
                () -> new SystemPage(winForm.elementById("pnlSystem"), winForm));

    }

    public EventPage eventPage() {
        return switchTo(EventPage.class, () -> winForm.elementById("Data").click(),//这里是Data而不是Event，开发部负大责
                () -> new EventPage(winForm.elementById("pnlSystem"), winForm));
    }

    public MaintainPage maintainPage() {
        return switchTo(MaintainPage.class, () -> winForm.elementById("Maintain").click(),
                () -> new MaintainPage(winForm.elementById("pnlSystem"), winForm));
    }

    public Object verifyClickAction(String action) {
        Object actionInfo = winForm.elementById("PopupNotice").elementById("panel_NoResult").getValue();
        if (!action.isEmpty()) {
            winForm.elementById("PopupNotice").elementById("panel_NoResult").elementByName(action).click();
        }
        return actionInfo;
    }

    public Object verifyClickActionQuestion(String action) {
        Object actionInfo = winForm.elementById("PopupNotice").elementById("panel_hasResult").getValue();
        if (!action.isEmpty()) {
            winForm.elementById("PopupNotice").elementById("panel_hasResult").elementByName(action).click();
        }
        return actionInfo;
    }

    public void logout() {
        winForm.elementById("btnLogout").click();
        winForm.elementByName("是(Y)").click();
    }

    public void clearAllAlarm() {
        setIO("/IO/PCI7433/ChamberPressureSW2DI", "Less125mT");
        setIO("/IO/PCI7433/ChamberPressureSWDI", "Less500mT");
        ContextWrapper.getApplicationContext().getBean(LowerApi.class).alarmapi().test().cleanAlarmEtch1();
        ContextWrapper.getApplicationContext().getBean(LowerSteps.class).disconnect();
        ContextWrapper.getApplicationContext().getBean(LowerSteps.class).connectetch1ref();
        ContextWrapper.getApplicationContext().getBean(LowerApi.class).alarmapi().test().cleanAlarmEtch1();
        ContextWrapper.getApplicationContext().getBean(LowerSteps.class).disconnect();
        ContextWrapper.getApplicationContext().getBean(LowerSteps.class).connectEtch1Pm2();
        if (!winForm.elementById("lblWarning").getText().equals("Alarm:")) {
            if (alarmPage().statusPage().clickResyneAlarm())
                manualPage().waferSynchPage().clearResyneAlarm();
            if (!winForm.elementById("lblWarning").getText().equals("Alarm:")) {
                alarmPage().statusPage().clearOtherAlarm();
            }
        }
    }

    //TODO 有的是初始化之前的alarm，有的是初始化后出现的alarm
    //TODO 有报警500mT 已添加清除条件
    public void Initialize() {
        clearAllAlarm();
        systemPage().moduleStatusPage().initModule();
        clearAllAlarm();
        systemPage().moduleStatusPage().initComplete();
        systemPage().configPage().setPostAlarmForExtraWafers();
    }

    public boolean hasRouteFile(String dir, String fileName) {
        File file = new File(dir);
        for (String name : Objects.requireNonNull(file.list())) {
            if (name.contains(fileName)) {
                return true;
            }
        }
        return false;
    }

    public void setIO(String ioname, String value) {
        ContextWrapper.getApplicationContext().getBean(LowerApi.class).io().setValue(ioname, value);
    }

    public void waitState(String state) {
        await().timeout(Duration.ofSeconds(500)).untilAsserted(() -> assertThat(winForm.elementById("txtToolSts").getText().equals(state)).isTrue());
    }
}
