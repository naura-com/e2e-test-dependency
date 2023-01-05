package com.naura.test.ui.driver;

import com.github.leeonky.util.Suppressor;
import com.google.common.collect.ImmutableList;
import io.appium.java_client.MobileElement;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.awaitility.Awaitility;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@Component
public class WinForm extends Window {

    private WindowsDriver<WindowsElement> windowsDriver = null;

    private WindowsDriver<WindowsElement> desktopDriver = null;

    private String currentWindow;

    private static String appPath;

    private static String localPath;

    private static String appName;

    @Value("${app.driver.host}")
    private String driverHost;

    public static void setWinForm(String path, String name, String localpath) {
        appPath = path;
        appName = name;
        localPath = localpath;
    }

    @Override
    protected WindowsElement findElementByName(String name) {
        return getWindowsDriver().findElementByName(name);
    }

    @Override
    protected WindowsElement findElement(By by) {
        return getWindowsDriver().findElement(by);
    }

    @Override
    protected WindowsElement findElementByTag(String tag) {
        return getWindowsDriver().findElementByTagName(tag);
    }

    @Override
    protected List<WindowsElement> findElementsByTag(String tag) {
        return getWindowsDriver().findElementsByTagName(tag);
    }

    @Override
    protected WindowsElement findElementById(String id) {
        return getWindowsDriver().findElementByAccessibilityId(id);
    }

    public static void slowUIAction(Runnable action) {
        Awaitility.setDefaultTimeout(300, TimeUnit.SECONDS);
        try {
            action.run();
        } finally {
            Awaitility.setDefaultTimeout(10, TimeUnit.SECONDS);
        }
    }

    @PreDestroy
    public void close() {
        if (windowsDriver != null) {
            windowsDriver.quit();
            windowsDriver = null;
            updateConfig(Collections::emptyList);
        }
    }

    public void closeWithoutNID() {
        if (windowsDriver != null) {
            windowsDriver.quit();
            windowsDriver = null;
        }
    }


    @SneakyThrows
    public WindowsDriver<WindowsElement> createWinDriver() {
        DesiredCapabilities desktopCapabilities = new DesiredCapabilities();
        desktopCapabilities.setCapability("platformName", "Windows");
        desktopCapabilities.setCapability("deviceName", "WindowsPC");
        desktopCapabilities.setCapability("app", appPath + "\\" + appName);
        desktopCapabilities.setCapability("appWorkingDir", appPath);
        return new WindowsDriver(new URL(driverHost), desktopCapabilities);
    }

    @SneakyThrows
    public WindowsDriver<WindowsElement> getWindowsDriver() {
        if (windowsDriver == null)
            windowsDriver = createWinDriver();
        currentWindow = getCurrentWindow();
        return windowsDriver;
    }

    @SneakyThrows
    public void newPage() {
        await().untilAsserted(() -> assertThat(currentWindow).isNotEqualTo(getCurrentWindow()));
        currentWindow = getCurrentWindow();
        windowsDriver.switchTo().window(currentWindow);
    }

    private String getCurrentWindow() {
        return await().ignoreExceptions().until(() -> windowsDriver.getWindowHandles().iterator().next(), Objects::nonNull);
    }

    public void updateConfig(String hostPort) {
        updateConfig(() -> ImmutableList.of(String.format("PVDMEC.Endpoints=tcp -t 20000 %s # automation-test", hostPort)));
    }

    private void updateConfig(Supplier<List<String>> configs) {
        File file = Paths.get(localPath, "..", "..", "config", "NID.config").toFile();
        List<String> lines = Suppressor.get(() -> FileUtils.readLines(file, UTF_8)).stream()
                .filter(line -> !line.contains("# automation-test"))
                .collect(Collectors.toCollection(ArrayList::new));
        lines.addAll(configs.get());
        Suppressor.run(() -> FileUtils.writeLines(file, lines));
    }

    public void submit(Runnable action) {
        action.run();
        elementByName("确定").click();
    }

    public String getPageSource() {
        return windowsDriver.getPageSource();
    }

    public MobileElement findElementByXpath(String xPath) {
        return windowsDriver.findElementByXPath(xPath);
    }

    public String getErrorProviderInfo() {
        return getWindowsDriver().findElementByTagName("ToolTip").getAttribute("Name");
    }

    @SneakyThrows
    public WindowsDriver<WindowsElement> createDesktopDriver() {
        DesiredCapabilities desktopCapabilities = new DesiredCapabilities();
        desktopCapabilities.setCapability("platformName", "Windows");
        desktopCapabilities.setCapability("deviceName", "WindowsPC");
        desktopCapabilities.setCapability("app", "Root");
        return new WindowsDriver(new URL(driverHost), desktopCapabilities);
    }

    @SneakyThrows
    public WindowsDriver<WindowsElement> getDesktopDriver() {
        if (desktopDriver == null)
            desktopDriver = createDesktopDriver();
        return desktopDriver;
    }
}

