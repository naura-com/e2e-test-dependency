package com.naura.test.ui.page.Etch1.Edit;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.FileOption;
import com.naura.test.ui.page.ParentPage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoutePage extends ParentPage {

    @Autowired
    WinForm winForm;

    private final Window.WindowOperation page;
    @Autowired
    FileOption fileOption = new FileOption();

    public RoutePage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    private void clickTabByElementAndOffset(int x, int y) {
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("Navigation").getElement(), x, y).
                click().click().perform();
    }

    public void clickAction(String action) {
        winForm.elementByName(action).click();
    }

    public void createRoute(DataTable table, String module) {
        int rowindex = 0;
        if (table.height() > 1) {
            rowindex = 1;
        }
        clickAction("New");
        winForm.elementByName("Add Node").click();
        if (table.cell(rowindex, 1) != null) {
            clickTabByElementAndOffset(70, 30);
            winForm.elementByName("PM2").click();
        }
        if (table.cell(rowindex, 2) != null) {
            winForm.elementById("cmbProRecipe").elementByName("打开").sendKeys(String.valueOf(Keys.DOWN));
            switch (module) {
                case "Align":
//                clickAction("UseAligner");
                    break;
                case "Center":
                    clickAction("UseCentering");
                    break;
            }
        }
    }

    public void saveRoute(String route) {
//        clickAction("Save");
        page.elementByName("Save").click();
        winForm.elementById("txtRouteRcpName").sendKeys(route);
        clickAction("Ok");
    }

    public void createAndSaveRoute(String route, DataTable table) {
        for (int i = 1; i < table.height(); i++) {
            createRoute(table.subTable(i, 0, i + 1, table.width()), "");
        }
        saveRoute(route);
        clickAction("OK");
    }

    public String getRouteList() {
        return page.elementById("lstWaferFlow").getListValue().toString();
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

    public String[] getFilesList(String dir) {
        File file = new File(dir);
        return Objects.requireNonNull(file.list());
    }

    public void selectRoute(String route) {
        winForm.elementByName(route).click();
    }

    public List<Object> getRoutePMInfos(String route) {
        List<Object> pmInfo = new ArrayList<>();
        for (int i = 0; i < winForm.elementById("PmNode").elementsByTag("Button").size(); i++) {
            pmInfo.add(winForm.elementById("PmNode").elementsByTag("Button").get(i).getText());
        }
        return pmInfo;
    }

    public Object verifyClickAction() {
        Object actionInfo = winForm.elementById("PopupNotice").elementById("panel_NoResult").getValue();
        return actionInfo;
    }

    public void editProessTime(String pm, String time) {
        winForm.elementByName(pm).click();
        winForm.elementById("txtIdletime").click().click().sendKeys(time);
    }

    public void clickOKOrYes(String Op) {
        winForm.elementByName(Op).click();
    }

    public void deleteOrClearAllRoute(String action, String route) {
        selectRoute(route);
        clickAction(action);
        clickAction("Yes");
    }

    private void editNewName(String nameafter) {
        winForm.elementById("txtRouteRcpName").sendKeys(nameafter);
    }

    public void beRenamed(String nameago, String nameafter) {
        assert (getRouteList().contains(nameafter) && !(getRouteList().contains(nameago)));
    }

    public void beSaveAs(String nameago, String nameafter) {
        assert (getRouteList().contains(nameafter) && getRouteList().contains(nameago));
    }

    public void renameRoute(String preRoute, String renameRoute) {
        selectRoute(preRoute);
        clickAction("Rename");
        winForm.elementByName("Yes").click();
        winForm.elementById("txtRouteRcpName").sendKeys(renameRoute);
        clickAction("Ok");
    }

    public void saveAsRoute(String preRoute, String saveAsRoute) {
        selectRoute(preRoute);
        clickAction("Save As");
        winForm.elementById("txtRouteRcpName").sendKeys(saveAsRoute);
        clickAction("Ok");
    }

    public int getNodes() {
        return winForm.elementById("pnlEdit").elementsByTag("Button").size();
    }

    public void selectItem(int i) {
        Window.WindowOperation windowOperation = (Window.WindowOperation) winForm.elementById("pnlEdit").elementsByTag("Button").toArray()[i];
        windowOperation.click();
    }

    public void selectItem(String item) {
        winForm.elementById("pnlEdit").selectByName(item);
    }

    public void deleteAllRoute() {
        for (Object route : page.elementById("lstWaferFlow").getListValue()) {
            selectRoute(route.toString());
            deleteOrClearAllRoute("Delete", route.toString());
        }
    }

    public void createCleanRoute(DataTable table, String module) {
        clickAction("New");
        winForm.elementByName("Add Node").click();
        if (table.cell(1, 1) != null) {
            clickTabByElementAndOffset(70, 30);
            winForm.elementByName("PM2").click();
        }
        if (table.cell(1, 2) != null) {
            winForm.elementById("cmbProRecipe").elementByName("打开").sendKeys(String.valueOf(Keys.DOWN));
            switch (module) {
                case "Align":
//                clickAction("UseAligner");
                    break;
                case "Center":
                    clickAction("UseCentering");
                    break;
            }
        }
        winForm.elementById("cmbWac").elementByName("打开").sendKeys(String.valueOf(Keys.DOWN)).sendKeys(String.valueOf(Keys.DOWN));
    }

    public void clickCmb(String module) {
        switch (module) {
            case "Align":
                if (!winForm.elementByName("UseAligner").isSelect()) {
                    clickAction("UseAligner");
                }
                break;
            case "Center":
                if (!winForm.elementByName("UseCentering").isSelect()) {
                    clickAction("UseCentering");
                }
                break;
        }
    }

    public boolean isSelect(String module) {
        switch (module) {
            case "Align":
                return winForm.elementByName("UseAligner").isSelect();
            case "Center":
                return winForm.elementByName("UseCentering").isSelect();
        }
        return false;
    }

}
