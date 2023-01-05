package com.naura.test.ui;

import com.naura.test.lower.LowerConnection;
import com.naura.test.lower.RecipeSteps;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import com.naura.test.ui.page.PVD.LoginPage;
import com.naura.test.ui.page.PVD.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.zh_cn.并且;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class UiSteps {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private TestState testState;

    @Autowired
    private MockLower mockLower;

    @Autowired
    private LowerConnection pvd;

    @Value("${mock-lower.pvd.host}")
    private String mockHost;

    @Value("${mock-lower.pvd.port}")
    private String mockPort;

    @Value("${app.path}")
    private String appPath;

    @Value("${app.name}")
    private String appName;

    @Value("${app.local-path}")
    private String localPath;

    @Autowired
    private WinForm winForm;

    @Autowired
    private MainPage mainPage;

    @Autowired
    private Etch1MainPage etch1MainPage;

    @Before
    public void closeWinForm(Scenario scenario) {
        testState.switchScenario(scenario);
    }

    @Before(value = "@pvd-ui-mock", order = 2000)
    @SneakyThrows
    public void pvdPeMock(Scenario scenario) {
        mockLower.reset();
        testState.checkAndLaunch("@pvd-ui-mock", scenario, () -> {
            mockLower.start();
            winForm.updateConfig(String.format("-p %s -h %s", mockPort, mockHost));
            WinForm.slowUIAction(() -> loginPage.login("pe", "8888"));
        }, () -> {
            winForm.close();
            mockLower.stop();
        }, appPath, appName, localPath);
    }

    @Autowired
    private RecipeSteps recipeSteps;

    @Before(value = "@pvd-ui", order = 2000)
    @SneakyThrows
    public void pvdPe(Scenario scenario) {
        //recipeSteps.clean();
        testState.checkAndLaunch("@pvd-ui", scenario, () -> {
            winForm.updateConfig(pvd.hostPort());
            WinForm.slowUIAction(() -> loginPage.login("pe", "8888"));
        }, () -> winForm.close(), appPath, appName, localPath);
    }

    @After(value = "@clean-create-recipe", order = 8000)
    public void cleanCreateRcp() {
        mainPage.editPage().recipePage().cleanCreateRcp();
    }


    @After(value = "@clean-allCreate-recipe", order = 11000)
    public void cleanAllCreateRcp() {
        mainPage.editPage().recipePage().cleanAllCreateRcp();
    }

    @After(value = "@click-cancel", order = 9000)
    public void clickCancel() {
        mainPage.editPage().recipePage().cancel();
    }

    @并且("重新启动上位机")
    public void 重新启动上位机() {
        testState.restart("pe", "8888", () -> winForm.close(), appPath, appName, localPath);
    }

    @After(value = "@Etch1-clean-allCreate-recipe", order = 8000)
    public void cleanAllEtch1CreateRcp() {
        etch1MainPage.editPage().recipePage().cleanAllCreateRcp();
    }

    @After(value = "@clean-allCreate-route", order = 11000)
    public void cleanAllCreateRoute() {
        mainPage.editPage().routePage().cleanAllCreateRoute();
    }

    @After(value = "@clean-all-job", order = 11000)
    public void cleanAllJobAndRoute() {
        mainPage.editPage().jobPage().cleanAllCreateJob();
        mainPage.editPage().routePage().cleanAllCreateRoute();
    }
}

