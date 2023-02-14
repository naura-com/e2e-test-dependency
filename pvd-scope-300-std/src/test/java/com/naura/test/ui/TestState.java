package com.naura.test.ui;

import com.naura.test.api.LowerConnection;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.LoginPage;
import io.cucumber.java.Scenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Objects;

@Service
public class TestState {

    @Autowired
    private WinForm winForm;
    @Autowired
    private LoginPage loginPage;

    @Autowired
    private LowerConnection pvd;

    private URI feature;
    private String uiTag;
    private Runnable close;
    private Runnable open;

    public void checkAndLaunch(String tag, Scenario scenario, Runnable open, Runnable close, String appPath, String appName, String localPath) {
        if (differentTag(tag) || containsTag(scenario, "@reset-scenario-ui")
                || (differentFeature(scenario) && containsTag(scenario, "@reset-feature-ui"))
                || containsTag(scenario, "@etch-reset")) {
            close();
            WinForm.setWinForm(appPath, appName, localPath);
            feature = scenario.getUri();
            uiTag = tag;
            this.close = close;
            this.open = open;
            open.run();
        }
    }

    private boolean differentFeature(Scenario scenario) {
        return !scenario.getUri().equals(feature);
    }

    private boolean differentTag(String tag) {
        return !Objects.equals(uiTag, tag);
    }

    public void switchScenario(Scenario scenario) {
        if (!containsTag(scenario, uiTag)) {
            close();
        }
    }

    private boolean containsTag(Scenario scenario, String tag) {
        return scenario.getSourceTagNames().contains(tag);
    }

    private void close() {
        uiTag = null;
        feature = null;
        if (close != null)
            close.run();
        close = null;
    }

    public void restart(String userName, String passWord, Runnable runnable, String appPath, String appName, String localPath) {
        close = runnable;
        close.run();
        WinForm.setWinForm(appPath, appName, localPath);
        winForm.updateConfig(pvd.hostPort());
        WinForm.slowUIAction(() -> loginPage.login(userName, passWord));
    }
}