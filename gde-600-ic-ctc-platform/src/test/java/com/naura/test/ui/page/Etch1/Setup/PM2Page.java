package com.naura.test.ui.page.Etch1.Setup;

import com.naura.test.ice.IComData.RemoteDoubleValueInfo;
import com.naura.test.ice.IComData.RemoteIntValueInfo;
import com.naura.test.ice.IComData.RemoteStringValueInfo;
import com.naura.test.ice.IComData.RemoteValueInfo;
import com.naura.test.config.ContextWrapper;
import com.naura.test.ctclower.api.CtcLowerApi;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.FileOption;
import com.naura.test.ui.page.ParentPage;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PM2Page extends ParentPage {
    @Autowired
    private WinForm winForm;

    @Autowired
    private final Window.WindowOperation page;

    @Autowired
    public Window.WindowOperation tabpage;

    @Autowired
    List<Map<Object, Window.WindowOperation>> view;

    @Autowired
    FileOption fileOption = new FileOption();

    public PM2Page(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void selectTab(String tabName) {
        switch (tabName) {
            case "RF":
                clickTabByElementAndOffset("Setup_tabControl", 20, 15);
                break;
            case "Gas":
                clickTabByElementAndOffset("Setup_tabControl", 55, 15);
                break;
            case "Chuck":
                clickTabByElementAndOffset("Setup_tabControl", 100, 15);
                break;
            case "Vacuum":
                clickTabByElementAndOffset("Setup_tabControl", 165, 15);
                break;
            case "Temperature":
                clickTabByElementAndOffset("Setup_tabControl", 240, 15);
                break;
            case "Recipe":
                clickTabByElementAndOffset("Setup_tabControl", 310, 15);
                break;
        }
        tabpage = selectView(tabName);
    }

    private void clickTabByElementAndOffset(String element, int x, int y) {
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById(element).getElement(), x, y).click().click().perform();
    }

    public void setCobData(String line, String data) {
        view = tabpage.asTable();
        for (int i = 0; i < 100; i++) {
            if (i > 15) {
                tabpage.elementByName("下一行").click();
            }
            if (view.get(i).get("Parameter").getValue().equals(line)) {
                tabpage.elementByName("CurrentValue 行 " + i).click();
                winForm.elementById("cb").sendKeys(data);
                break;
            }
        }
    }

    public void setTxtData(String line, String data) {
        view = tabpage.asTable();
        for (int i = 0; i < 100; i++) {
            if (i > 15) {
                tabpage.elementByName("下一行").click();
            }
            if (view.get(i).get("Parameter").getValue().equals(line)) {
                page.elementByName("CurrentValue 行 " + i).click().sendKeys(data);
                break;
            }
        }
    }

    private Window.WindowOperation selectView(String tabName) {
        switch (tabName) {
            case "RF":
                return winForm.elementById("dataGridView1");
            case "Gas":
                return winForm.elementById("dataGridView2");
            case "Chuck":
                return winForm.elementById("dataGridView3");
            case "Vacuum":
                return winForm.elementById("dataGridView4");
            case "Temperature":
                return winForm.elementById("dataGridView5");
            case "Recipe":
                return winForm.elementById("dataGridView6");
        }
        return null;
    }

    public void setValue(String type, String line, String data) {
        switch (type) {
            case "OnlyReadInt":
                setCobData(line, data);
                break;
            case "Double":
                setTxtData(line, data);
                break;
            case "Int":
                setTxtData(line, data);
                break;
        }
    }

    public Object getCobData(String line, String name) {
        tabpage.elementByName("DefaultValue 行 0").click();
        for (Map<Object, ?> value : tabpage.getTableValue()) {
            if (value.get("Parameter").equals(line)) {
                switch (name) {
                    case "CurrentValue":
                        return value.get("CurrentValue");
                    case "DefaultValue":
                        return value.get("DefaultValue");
                }
            }
        }
        return null;
    }

    public void clickAction(String name) {
        winForm.elementByName(name).click();
    }

    public void exportOk(String name) {
        clickAction(name);
        winForm.elementByName("testFiles").click();
        winForm.elementByName("浏览文件夹").elementByName("确定").click();
    }

    public Object verifyClickAction() {
        Object actionInfo = winForm.elementById("PopupNotice").elementById("panel_NoResult").getValue();
        winForm.elementById("PopupNotice").elementById("panel_NoResult").elementByName("OK").click();
        return actionInfo;
    }

    public void clickOK() {
        winForm.elementById("PopupNotice").elementById("panel_NoResult").elementByName("OK").click();
    }

    public void switchPage(String pageName) {
        selectTab("Temperature");
        selectTab(pageName.substring(0, pageName.indexOf('C')));
    }

    public void switchPosition() {
        winForm.elementByName("DefaultValue 行 1").click();
    }

    public void importFile(String filePathName) {
        winForm.getWindowsDriver().findElementByName("打开").findElementByClassName("Edit").sendKeys(filePathName);
        winForm.getWindowsDriver().findElementByName("打开(O)").click();
    }

    public String[] verifyFile(String dir, String fileName) {
        File file = new File(dir);
        for (String name : Objects.requireNonNull(file.list())) {
            if (name.contains(fileName)) {
                return fileOption.readFile(dir + "\\" + name);
            }
        }
        return null;
    }

    public Object getChannelData(String channelName) {
        CtcLowerApi api = ContextWrapper.getApplicationContext().getBean(CtcLowerApi.class);
        RemoteValueInfo dataValue = api.io().getData(channelName).getValue();
        switch (dataValue.type.value()) {
            case 0:
                RemoteIntValueInfo intValue = (RemoteIntValueInfo) dataValue;
                return intValue.value;
            case 1:
                RemoteStringValueInfo stringValue = (RemoteStringValueInfo) dataValue;
                return stringValue.value;
            case 2:
                RemoteDoubleValueInfo doubleValue = (RemoteDoubleValueInfo) dataValue;
                return doubleValue.value;
            default:
                return null;
        }
    }
}
