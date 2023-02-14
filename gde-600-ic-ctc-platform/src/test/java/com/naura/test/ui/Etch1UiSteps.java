package com.naura.test.ui;

import com.naura.test.api.LowerConnection;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.StartupPage;
import com.naura.test.ui.page.PVD.LoginPage;
import com.naura.test.ui.page.PVD.MainPage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Etch1UiSteps {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private StartupPage startupPage;

    @Autowired
    private TestState testState;

    @Autowired
    private MockLower mockLower;

    @Autowired
    private LowerConnection etch1Pm2;

    @Value("${mock-lower.pvd.host}")
    private String mockHost;

    @Value("${mock-lower.pvd.port}")
    private String mockPort;

    @Autowired
    private WinForm winForm;

    @Autowired
    private MainPage mainPage;

    @Value("${app.path1}")
    private String appPath;

    @Value("${app.name1}")
    private String appName;

    @Value("${app.local-path1}")
    private String localPath;

    public Etch1UiSteps() {
    }

//    @Before
//    public void closeWinForm(Scenario scenario) {
//        testState.switchScenario(scenario);
//    }


    @Before(value = "@etch1-ui-mock", order = 2000)
    @SneakyThrows
    public void etchPeMock(Scenario scenario) {
        mockLower.reset();
        testState.checkAndLaunch("@etch1-ui-mock", scenario, () -> {
            mockLower.start();
            winForm.updateConfig(String.format("-p %s -h %s", mockPort, mockHost));
            WinForm.slowUIAction(() -> startupPage.launch());
        }, () -> {
            winForm.close();
            mockLower.stop();
        }, appPath, appName, localPath);
    }

    @Before(value = "@etch1-ui", order = 2000)
    @SneakyThrows
    public void etch1Pe(Scenario scenario) {
        testState.checkAndLaunch("@etch1-ui", scenario, () -> {
            WinForm.slowUIAction(() -> startupPage.next());
        }, () -> winForm.closeWithoutNID(), appPath, appName, localPath);
    }
}

