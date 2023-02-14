package com.naura.test.ui.Etch1Steps;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.api.api.LowerApi;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import com.naura.test.ui.page.FileOption;
import io.cucumber.java.After;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.github.leeonky.dal.Assertions.expect;

public class SetupSteps {
    @Autowired
    private Etch1MainPage etchMainPage;
    @Autowired
    private LowerApi lowerApi;
    private WinForm winForm;
    @Value("${filedir.local}")
    private String localDir;
    @Value("${filedir.virtual}")
    private String virtualDir;

    @After(value = "@CleanDir")
    public void cleanDir() {
        FileOption fileOption = new FileOption();
        fileOption.cleanDir(localDir);
    }

    @假如("存在{string}类型的参数:")
    public void 假如存在(String type, Table table) {
        for (Map<String, ?> row : table) {
            setSetupValue("", row);
            saveSetupToXML("", row);
            etchMainPage.setupPage().setupPage2().pm2Page().switchPage((String) row.get("Name"));
        }
    }

    @假如("存在被修改的{string}类型的参数:")
    public void 假如存在被修改(String type, Table table) {
        modifyCurrentValue(type, table);
    }

    public void modifyCurrentValue(String type, Table table) {
        for (Map<String, ?> row : table) {
            setSetupValue("", row);
            saveSetupToXML("", row);
            etchMainPage.setupPage().setupPage2().pm2Page().switchPage((String) row.get("Name"));
            etchMainPage.setupPage().setupPage2().pm2Page().setValue(type, (String) row.get("Parameter"),
                    (String) row.get("ModifiedCurrentValue"));
        }

    }

    public void setSetupValue(String pageName, Map<String, ?> row) {
        Table setSetupTable = new Table();
        Map<String, String> setSetupMap = new HashMap<String, String>();
        if (pageName.isEmpty()) {
            setSetupMap.put("name", (String) row.get("Name"));
        } else {
            setSetupMap.put("name", pageName);
        }
        setSetupMap.put("index", "1");
        setSetupMap.put("paramName", (String) row.get("Parameter"));
        setSetupMap.put("value", (String) row.get("CurrentValue"));
        setSetupTable.add(setSetupMap);
        lowerApi.setUp().invoke("setSetupValue", setSetupTable);
    }

    public void saveSetupToXML(String pageName, Map<String, ?> row) {
        Table setSaveupTable = new Table();
        Map<String, String> saveSetupMap = new HashMap<String, String>();
        if (pageName.isEmpty()) {
            saveSetupMap.put("name", (String) row.get("Name"));
        } else {
            saveSetupMap.put("name", pageName);
        }
        setSaveupTable.add(saveSetupMap);
        lowerApi.setUp().invoke("saveSetupToXML", setSaveupTable);
    }

    @当("修改{string}的当前值为{string}")
    public void 修改的当前值为(String name, String value) {
        etchMainPage.setupPage().setupPage2().pm2Page().setCobData(name, value);
    }

    @当("修改{string}的当前值为{string}:")
    public void 修改的当前值为2(String name, String value) {
        etchMainPage.setupPage().setupPage2().pm2Page().setTxtData(name, value);
    }

    @当("修改{string}的当前值为非法值{string}:")
    public void 修改的当前值为非法值(String name, String norValue) {
        etchMainPage.setupPage().setupPage2().pm2Page().setTxtData(name, norValue);
        etchMainPage.setupPage().setupPage2().pm2Page().switchPosition();
    }

    @并且("{string}的当前值为")
    public void 的当前值为(String name, String verifyValue) {
        expect(etchMainPage.setupPage().setupPage2().pm2Page().getCobData(name, "CurrentValue")).should(verifyValue);
    }

    @那么("操作成功,{string}的当前值为")
    public void 操作成功的当前值为(String name, String verifyValue) {
        expect(etchMainPage.setupPage().setupPage2().pm2Page().getCobData(name, "CurrentValue")).should(verifyValue);
    }

    @并且("切换到任意位置")
    public void 切换到任意位置() {
        etchMainPage.setupPage().setupPage2().pm2Page().switchPosition();
    }

    @那么("操作失败,提示信息为:")
    public void 操作失败提示信息为(String arg0) {
        expect(etchMainPage.setupPage().setupPage2().pm2Page().verifyClickAction()).should(arg0);
    }

    @当("执行setup的{string}操作")
    public void 执行setup的操作(String action) {
        etchMainPage.setupPage().setupPage2().pm2Page().clickAction(action);
    }

    @那么("操作成功,提示信息为:")
    public void 操作成功提示信息为(String info) {
        expect(etchMainPage.setupPage().setupPage2().pm2Page().verifyClickAction()).should(info);
    }

    @假如("存在被{string}的{string}类型的参数:")
    public void 存在被的类型的参数(String action, String type, Table table) {
        modifyCurrentValue(type, table);
        saveAndApply(action);
    }

    private void saveAndApply(String action) {
        etchMainPage.setupPage().setupPage2().pm2Page().clickAction(action);
        if (Objects.equals(action, "Save") || Objects.equals(action, "Apply")) {
            etchMainPage.setupPage().setupPage2().pm2Page().clickOK();
        }
    }

    @假如("setup的{string}存在如下配置:")
    public void setup的存在如下配置(String pageName, Table table) {
        dataPrepare(pageName, table);
    }

    private void dataPrepare(String pageName, Table table) {
        for (Map<String, ?> row : table) {
            setSetupValue(pageName, row);
            saveSetupToXML(pageName, row);
        }
        etchMainPage.setupPage().setupPage2().pm2Page().switchPage(pageName);
    }

    public void modifyTable(String pageName, Table table) {
        dataPrepare(pageName, table);
        for (Map<String, ?> row : table) {
            etchMainPage.setupPage().setupPage2().pm2Page().setValue((String) row.get("Type"), (String) row.get("Parameter"),
                    (String) row.get("ModifiedCurrentValue"));
        }
    }

    @并且("存在文件{string}:")
    public void 存在文件(String fileName, String verifyInfos) {
        expect(etchMainPage.setupPage().setupPage2().pm2Page().verifyFile(localDir, fileName)).should(verifyInfos);
    }

    @并且("存在有效参数的配置文件{string}:")
    public void 存在有效参数的配置文件(String fileName, Table table) {
        createValidFile(fileName, table);
    }

    public void createValidFile(String fileName, Table table) {
        FileOption fileOption = new FileOption();
        etchMainPage.setupPage().setupPage2().pm2Page().selectTab("RF");
        String[] fileString = fileOption.createSetupFile(etchMainPage.setupPage().setupPage2().pm2Page().tabpage);
        fileOption.changeFileLine(fileString, table.get(0).get("Parameter").toString(), table.get(0).get("CurrentValue").toString());
        fileOption.writerFile(localDir + "\\" + fileName, fileString);
    }

    public void createSpecifiedValidFile(String fileName, Table table) {
        FileOption fileOption = new FileOption();
        String[] fileString = fileOption.createSetupFileLly(table);
        fileOption.writerFile(localDir + "\\" + fileName, fileString);
    }

    @并且("存在无效参数的配置文件{string}:")
    public void 存在无效参数的配置文件(String fileName, Table table) {
        FileOption fileOption = new FileOption();
        etchMainPage.setupPage().setupPage2().pm2Page().selectTab("RF");
        String[] fileString = fileOption.createSetupFile(etchMainPage.setupPage().setupPage2().pm2Page().tabpage);
        fileOption.changeFileLine(fileString, table.get(0).get("Parameter").toString(), table.get(0).get("CurrentValue").toString());
        fileOption.writerFile(localDir + "\\" + fileName, fileString);
    }

    @并且("选择导入文件为{string}")
    public void 选择导入文件为(String fileName) {
        etchMainPage.setupPage().setupPage2().pm2Page().importFile(virtualDir + "\\" + fileName.substring(0, fileName.length() - 4));
    }

    @并且("选择导入非法文件为{string}")
    public void 选择导入非法文件为(String fileName) {
        etchMainPage.setupPage().setupPage2().pm2Page().importFile(virtualDir + "\\" + fileName);
    }


    @假如("存在无效格式的配置文件:")
    public void 存在无效格式的配置文件(Table table) {
        FileOption fileOption = new FileOption();
        for (int i = 0; i < table.size(); i++) {
            fileOption.filecreate(localDir + "\\" + table.get(i).get("configName"));
        }
    }

    @当("执行{string}操作:")
    public void 执行操作2(String actionName) {
        etchMainPage.setupPage().setupPage2().pm2Page().exportOk(actionName);
    }

    @假如("存在{string}后的setup的{string}:")
    public void 存在操作后的setup的(String actionName, String pageName, Table table) {
        modifyTable(pageName, table);
        saveAndApply(actionName);
    }

    @当("{string}有效参数的配置文件{string}:")
    public void 有效参数的配置文件(String action, String fileName, Table table) {
//        createValidFile(fileName, table);
        createSpecifiedValidFile(fileName, table);
        etchMainPage.setupPage().setupPage2().pm2Page().clickAction(action);
        etchMainPage.setupPage().setupPage2().pm2Page().importFile(virtualDir + "\\" + fileName.substring(0, fileName.length() - 4));
    }

    @当("{string}和界面参数不同的配置文件{string}:")
    public void 和界面参数不同的配置文件(String action, String fileName, Table table) {
//        createValidFile(fileName, table);
        createSpecifiedValidFile(fileName, table);
        etchMainPage.setupPage().setupPage2().pm2Page().clickAction(action);
        etchMainPage.setupPage().setupPage2().pm2Page().importFile(virtualDir + "\\" + fileName.substring(0, fileName.length() - 4));
    }

    @并且("{string}对应的通道值{string}为")
    public void 对应的通道值为(String paraName, String channelName, String verification) {
        expect(etchMainPage.setupPage().setupPage2().pm2Page().getChannelData(channelName)).should(verification);
    }

    @当("{string}有效参数的配置文件{string}")
    public void 有效参数的配置文件2(String action, String fileName, Table table) {
        createValidFile(fileName, table);
        etchMainPage.setupPage().setupPage2().pm2Page().clickAction(action);
        etchMainPage.setupPage().setupPage2().pm2Page().importFile(virtualDir + "\\" + fileName.substring(0, fileName.length() - 4));
    }
}
