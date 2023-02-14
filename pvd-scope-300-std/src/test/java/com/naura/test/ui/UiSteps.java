package com.naura.test.ui;

import com.naura.test.api.LowerConnection;
import com.naura.test.api.RecipeSteps;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.LoginPage;
import com.naura.test.ui.page.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.那么;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static com.github.leeonky.dal.Assertions.expect;

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

    @After(value = "@clean-allCreate-route", order = 11000)
    public void cleanAllCreateRoute() {
        mainPage.editPage().routePage().cleanAllCreateRoute();
    }

    @After(value = "@clean-all-job", order = 11000)
    public void cleanAllJobAndRoute() {
        mainPage.editPage().jobPage().cleanAllCreateJob();
        mainPage.editPage().routePage().cleanAllCreateRoute();
    }

    @那么("当前页面显示如下:")
    public void 当前页面显示如下(String verification) {
        expect(mainPage.currentPage()).should(verification);
    }
}

