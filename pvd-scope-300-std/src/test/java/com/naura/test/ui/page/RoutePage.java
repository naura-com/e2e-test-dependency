package com.naura.test.ui.page;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.Keys;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.naura.test.ui.driver.Window.WindowOperation.FILL_BY_COMBO_BOX;

public class RoutePage {
    private final Window.WindowOperation page;
    private final WinForm winForm;

    public RoutePage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public List<Map<Object, Object>> queryRouteInfo(String routeName) {
        page.elementById("mAllRt_lb").elementByName(routeName).click();
        return page.elementByName("Route编辑").elementById("mRouteEditor_rt").getTableValue();
    }

    public void createRoute(String name, DataTable table) {
        Window.WindowOperation editRoute = page.elementByName("路径编辑");
        editRoute.elementByName("新建").click();

        winForm.elementById("mRtName_tb").sendKeys(name);
        winForm.elementByName("确定").click();

        page.elementById("mRouteDgv").fillTable(table.asMaps(), anyColumn -> FILL_BY_COMBO_BOX);

        editRoute.elementByName("保存").click();
        winForm.elementByName("确定").click();
    }

    public void clickOn(String btn) {
        switch (btn) {
            case "新建": {
                page.elementById("mNew_btn").click();
                break;
            }
            case "编辑": {
                page.elementById("mEdit_btn").click();
                break;
            }
            case "删除": {
                page.elementById("mDel_btn").click();
                break;
            }
            case "保存": {
                page.elementById("mSave_btn").click();
                break;
            }
            case "另存为": {
                page.elementById("mSaveAs_btn").click();
                break;
            }
            case "确定": {
                winForm.elementByName("确定").click();
                break;
            }
            case "取消": {
                winForm.elementByName("取消").click();
                break;
            }
            case "导入": {
                page.elementById("mRcpImport_btn").click();
                break;
            }
            case "导出": {
                page.elementById("mRcpExport_btn").click();
                break;
            }
            case "批量导出": {
                page.elementById("mRcpBatchExport_btn").click();
            }
            default:
                throw new IllegalStateException("unknown click: " + btn);
        }
    }

    public String getMessage() {
        String message = winForm.elementById("mMsg_lbl").getText();
        winForm.elementById("mYes_btn").click();
        return message;
    }

    public String getErrorMessage() {
        String error = winForm.elementById("65535").getText();
        winForm.elementByName("确定").click();
        return error;
    }

    public void selectRoute(String route) {
        page.elementById("mAllRt_lb").selectByName(route).click();
    }

    public void saveAsRoute(String routeName) {
        winForm.elementById("mRtName_tb").sendKeys(routeName);
    }

    public void sendRouteName(String routeName) {
        winForm.elementById("mRtName_tb").sendKeys(routeName);
        winForm.elementByName("确定").click();
    }

    public void clickButton(String operation, Boolean clean) {
        switch (operation) {
            case "新建":
                page.elementById("mNew_btn").click();
                break;
            case "保存":
                page.elementById("mSave_btn").click();
                break;
            case "导出":
                if (clean)
                    createFolder();
                page.elementById("mRcpExport_btn").click();
                break;
            case "批量导出":
                if (clean)
                    createFolder();
                page.elementById("mRcpBatchExport_btn").click();
                break;
            case "删除":
                page.elementById("mDel_btn").click();
                break;
            case "另存为":
                page.elementById("mSaveAs_btn").click();
                break;
            case "导入":
                page.elementById("mRcpImport_btn").click();
                break;
            case "编辑":
                page.elementById("mEdit_btn").click();
                break;
            case "删除行":
                page.elementById("mDelete_btn").click();
                break;
            case "插入行":
                page.elementById("mInsertRow_btn").click();
                break;
            case "清除":
                page.elementById("mClearBtn").click();
                break;
            default:
                throw new RuntimeException("unknown operation:" + operation);
        }
    }

    public void batchExport() {
        winForm.elementByName("此电脑").click();
        winForm.elementByName("test (\\\\VBoxSvr) (Z:)").click();
        winForm.elementByName("Route").click();
        winForm.elementByName("确定").click();
    }

    public void ExportRoute() {
        winForm.elementByName("此电脑").click();
        winForm.elementByName("所有位置").click();
        winForm.elementById("41477").sendKeys("Z:\\Route").Keyboard(Keys.ENTER);//点击目标路径栏左侧的文件夹图标
        winForm.elementById("1").click();
    }

    public void createFolder() {
        File folder = new File("c:\\test\\Route");
        if (!folder.exists())
            folder.mkdirs();
        else {
            deleteFile(folder);
            folder.mkdirs();
        }
    }

    public void deleteFile(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory())
                deleteFile(f);
            else
                f.delete();
        }
        file.delete();
    }

    public List<FileInfo> getFiles() {
        FileOption fileOption = new FileOption();
        File file = new File("c:\\test\\Route");
        List<FileInfo> result = new ArrayList<>();
        for (String name : Objects.requireNonNull(file.list())) {
            FileInfo files = new FileInfo(name, fileOption.readFile("c:\\test\\Route\\" + name));
            result.add(files);
        }
        return result;
    }

    public void editOperate(String routeName, String editOperation) {
        selectRoute(routeName);
        clickButton("编辑", false);
        clickButton(editOperation, false);
    }

    public void cleanAllCreateRoute() {
        for (Object route : page.elementById("mAllRt_lb").getListValue()
        ) {
            deleteRoute(route.toString());
        }
    }

    public void deleteRoute(String routeName) {
        selectRoute(routeName);
        clickButton("删除", false);
        winForm.elementById("mYes_btn").click();
        winForm.elementById("mYes_btn").click();
    }

    public Object getRouteShowInfo() {
        return page.elementById("mRouteDgv").getTableValue();
    }

    public Object getPopMessage() {
        String message = winForm.elementById("65535").getText();
        winForm.elementByName("确定").click();
        return message;
    }

    public void clickCell(String cellIndex) {
        int row = Integer.parseInt(cellIndex.split(",")[0]);
        String column = cellIndex.split(",")[1];
        page.elementById("mRouteDgv").selectCell(row, column);
    }

    public void editOperate(String routeName, String cellIndex, String editOperation) {
        selectRoute(routeName);
        clickButton("编辑", false);
        clickCell(cellIndex);
        clickButton(editOperation, false);
    }

    public void editRouteParam(DataTable table) {
        page.elementById("mRouteDgv").editTableCol(table.asMaps(), anyColumn -> FILL_BY_COMBO_BOX);
    }

    public void saveRoute() {
        clickButton("保存", false);
        winForm.elementById("PopupMessage").elementById("mYes_btn").click();
    }

    public void newRoute(String routeName, DataTable table) {
        Window.WindowOperation editRoute = page.elementByName("路径编辑");
        editRoute.elementByName("新建").click();

        winForm.elementById("mRtName_tb").sendKeys(routeName);
        winForm.elementByName("确定").click();

        page.elementById("mRouteDgv").fillTable(table.asMaps(), anyColumn -> FILL_BY_COMBO_BOX);
    }

    public List<Object> getCellItems(String row, String column) {
        page.elementById("mRouteDgv").selectCell(Integer.parseInt(row), column);
        List<Object> list = page.elementByName("编辑控件").click().getListValue();
        return list;
    }

    public Object[] getAllRoute() {
        return page.elementById("mAllRt_lb").getListValue().toArray();
    }

    public List<Object> findRoute(String str) {
        page.elementById("mRtFilter_tb").sendKeys(str);
        return page.elementById("mAllRt_lb").getListValue();
    }

    public void cleanFilter() {
        page.elementById("mRtFilter_tb").clear();

    }

    public List<Map<Object, Object>> getRouteParamInfo(String routeName) {
        page.elementByName(routeName).click();
        return page.elementById("mRouteDgv").getTableValue();
    }

    public void createNewRoute(String routeName) {
        page.elementById("mNew_btn").click();
        winForm.elementById("mRtName_tb").sendKeys(routeName);
        winForm.elementById("mOK_btn").click();
    }

    public void makeSure(String operation) {
        winForm.elementByName(operation).click();
    }

    public void createDefaultRoute(String routeName) {
        winForm.elementById("mRtName_tb").sendKeys(routeName);
        winForm.elementById("mOK_btn").click();
    }

    public Object getPopUpMessage() {
        String message = winForm.elementById("mMsg_lbl").getText();
        return message;
    }

    public Object getWhiteWindowPopUpMessage() {
        String message = winForm.elementById("65535").getText();
        return message;
    }

    public void makeSureWhiteWindow() {
        winForm.elementById("2").click();
    }

}
