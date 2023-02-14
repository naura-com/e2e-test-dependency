package com.naura.test.ui.page.Etch1.Maintain;

import com.naura.test.ui.driver.ImageValueMaps;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.awaitility.Awaitility.await;

public class ChamberPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

//    private RemoteWebElement secendPage = null;

    private Window.WindowOperation desktopPage;

    public ChamberPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void newDesktopPage(String name, String id) {
        if (name.equals(""))
            desktopPage = new Window.WindowOperation(winForm.getDesktopDriver().findElementById(id));
        else
            desktopPage = new Window.WindowOperation(winForm.getDesktopDriver().findElementByName(name));
    }

//    public void newSecendPage(String name) {
//        secendPage = getChildPage(name);
//    }

    public RemoteWebElement getChildPage(String name) {
        return winForm.getDesktopDriver().findElementByName(name);
    }

    public void clickAction(String action) {
        page.elementByName(action).click();
    }

    public void clickID(String id) {
        page.elementById(id).click();
    }

    public Object getModuleStatus(String action) {
        await().timeout(Duration.ofSeconds(100)).untilAsserted(() -> assertThat(page.elementByName(action).isEnabled()).isTrue());
        return page.elementById("PM_State").getText();
    }

    public Object getRunService(String action) {
        await().timeout(Duration.ofSeconds(100)).untilAsserted(() -> assertThat(page.elementByName(action).isEnabled()).isFalse());
        return page.elementById("superTextBox105").getText();
    }

    public void selectPM(String arg0) {
        switch (arg0) {
            case "PM2 GDE":
                winForm.elementById("bitbtnPM2").click();
        }
    }

    public String chillerTemp() {
        return page.elementById("frmChamberGDE").elementByName("Other").elementById("superTextBox75").getText();
    }

    public boolean pin1Enable() {
        try {
            page.elementById("frmChamberGDE").elementById("panel1").elementById("pin1");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setChillerTempSur(int arg0) {
        clickAction("Chiller");
        newDesktopPage("Chamber Chiller", "");
        desktopPage.elementByName("Set Temperature").click();
//        desktopPage.findElementByXPath("//Button[contains(@AutomationId,\"digitalPicker1\")]").click();
//        desktopPage.findElementByXPath("//Edit[contains(@AutomationId,\"txtInput\")]").sendKeys(String.valueOf(arg0));
        desktopPage.elementById("digitalPicker1").click();
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(arg0));
        desktopPage.elementByName("OK").click();
        RFRun();
    }

    public void pinUp() {
        clickAction("Pin");
        newDesktopPage("Chamber Pin", "");
        desktopPage.elementByName("Pin Up").click();
        RFRun();
    }

    public void pinDown() {
        clickAction("Pin");
        newDesktopPage("Chamber Pin", "");
        desktopPage.elementByName("Pin Down").click();
        RFRun();
    }

    public void sureMessandOK(String verification) {
        desktopPage.elementByName(verification);
        desktopPage.elementByName("确定").click();
        desktopPage.elementByName("Cancel").click();
        desktopPage.elementByName("Close").click();
    }

    public void chillerRun() {
        RFRun();
    }

    public void setGas(String gas, String value) {
        newDesktopPage("table1", "");
        winForm.elementById("tblGasFlow").sendKeys("");
    }

    public void setHePressure(String pressure) {
        page.elementById("btnHePressSet").click();
        newDesktopPage("Set He Pressure", null);
        desktopPage.elementById("btnSetPress").click();
        desktopPage.elementById("digitalPicker1").click();
        desktopPage.elementById("txtInput").sendKeys(pressure);
    }

    public String getDigitalMessage(String operation) {
        String message = desktopPage.elementById("DigitalInput").elementById("65535").getText();
        desktopPage.elementById("DigitalInput").elementByName(operation).click();
        return message;
    }

    public void RingUp() {
        clickAction("Ring");
        newDesktopPage("Chamber Ring", "");
        desktopPage.elementByName("Ring Up").click();
        RFRun();
    }

    public void RingDown() {
        clickAction("Ring");
        newDesktopPage("Chamber Ring", "");
        desktopPage.elementByName("Ring Down").click();
        RFRun();
    }

    public String ringStatus() {
        return page.elementById("frmChamberGDE").elementByName("Other").elementById("superTextBox103").getText();
    }

    public void setESCDC(int arg0) {
        page.elementByName("ESC").elementById("btnEsc").click();
        newDesktopPage("ESC", "");
        desktopPage.elementByName("Set Voltage").click();
//        desktopPage.findElementByXPath("//Button[contains(@AutomationId,\"digitalPicker1\")]").click();
//        desktopPage.findElementByXPath("//Edit[contains(@AutomationId,\"txtInput\")]").sendKeys(String.valueOf(arg0));
        desktopPage.elementById("digitalPicker1").click();
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(arg0));
        desktopPage.elementByName("OK").click();
        RFRun();
    }

    public String ESCDCvalue() {
        return page.elementById("frmChamberGDE").elementByName("ESC").elementById("superTextBox10").getText();
    }

    public void RFRun() {
        desktopPage.elementByName("Run").click();
        desktopPage.elementByName("Close").click();
    }

    public void setSRFCenterPower(int arg0) {
        page.elementByName("Source RF Center").elementByName("SRF").click();
        newDesktopPage("SRFCenter", "");
        desktopPage.elementByName("Set Power").click();
//        desktopPage.findElementByXPath("//Button[contains(@AutomationId,\"digitalSetPower\")]").click();
//        desktopPage.findElementByXPath("//Edit[contains(@AutomationId,\"txtInput\")]").sendKeys(String.valueOf(arg0));
        desktopPage.elementById("digitalSetPower").click();
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(arg0));
        desktopPage.elementByName("OK").click();
        RFRun();
    }

    public String SRFCForwardvalue() {
        return page.elementById("frmChamberGDE").elementByName("Source RF Center").elementById("superTextBox11").getText();
    }

    public void setSRFEdgePower(int arg0) {
        page.elementByName("Source RF Edge").elementByName("SRF").click();
        newDesktopPage("SRFEdge", "");
        desktopPage.elementByName("Set Power").click();
//        desktopPage.findElementByXPath("//Button[contains(@AutomationId,\"digitalSetPower\")]").click();
//        desktopPage.findElementByXPath("//Edit[contains(@AutomationId,\"txtInput\")]").sendKeys(String.valueOf(arg0));
        desktopPage.elementById("digitalSetPower").click();
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(arg0));
        desktopPage.elementByName("OK").click();
        RFRun();
    }

    public String SRFEForwardValue() {
        return page.elementById("frmChamberGDE").elementByName("Source RF Edge").elementById("superTextBox95").getText();
    }

    public void SRFCInit() {
        page.elementByName("Source RF Center").elementByName("Match").click();
        newDesktopPage("SRFCenterMatch", "");
        desktopPage.elementByName("InitC1C2").click();
        RFRun();
    }

    public void SRFEInit() {
        page.elementByName("Source RF Edge").elementByName("Match").click();
        newDesktopPage("SRFEdgeMatch", "");
        desktopPage.elementByName("InitC1C2").click();
        RFRun();
    }

    public void SRFCSureInit(int arg0) {
        assertThat(page.elementByName("Source RF Center").elementById("superTextBox13").getText().equals(String.valueOf(arg0))).isTrue();
        assertThat(page.elementByName("Source RF Center").elementById("superTextBox14").getText().equals(String.valueOf(arg0))).isTrue();
    }

    public void SRFESureInit(int arg0) {
        assertThat(page.elementByName("Source RF Edge").elementById("superTextBox93").getText().equals(String.valueOf(arg0))).isTrue();
        assertThat(page.elementByName("Source RF Edge").elementById("superTextBox92").getText().equals(String.valueOf(arg0))).isTrue();
    }

    public void setSRFEdgeC(int arg0, int arg1) {
        page.elementByName("Source RF Edge").elementByName("Match").click();
        newDesktopPage("SRFEdgeMatch", "");
        desktopPage.elementByName("PreSet").click();
        desktopPage.elementById("digitalPicker" + arg0).click();
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(arg1));
        desktopPage.elementByName("OK").click();
        RFRun();
    }

    public Object SRFEdgeCValue(int arg0) {
        return page.elementByName("Source RF Edge").elementById("superTextBox" + (94 - arg0)).getText();
    }

    public void setSRFCenterC(int arg0, int arg1) {
        page.elementByName("Source RF Center").elementByName("Match").click();
        newDesktopPage("SRFCenterMatch", "");
        desktopPage.elementByName("PreSet").click();
        desktopPage.elementById("digitalPicker" + arg0).click();
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(arg1));
        desktopPage.elementByName("OK").click();
        RFRun();
    }

    public Object SRFCenterCValue(int arg0) {
        return page.elementByName("Source RF Center").elementById("superTextBox" + (12 + arg0)).getText();
    }

    public void closeDigitalForm() {
        desktopPage.elementByName("Cancel").click();
        desktopPage.elementByName("Close").click();
    }

    public void serviceOperation(String operation) {
        desktopPage.elementByName(operation).click();
    }

    public Object getServiceValue() {
        return desktopPage.elementById("digitalPicker1").getText();
    }

    public Object getHePressure() {
        return page.elementById("btnHePressSet").getText();
    }

    public void digitalOperation(String operation) {
        desktopPage.elementById("DigitalInput").elementByName(operation).click();
    }

    public Object getDigitalText(String textName) {
        switch (textName) {
            case "Selected":
                return desktopPage.elementById("DigitalInput").elementById("txtInput").getText();
            default:
                throw new RuntimeException("未知操作" + textName);
        }
    }

    public void gasOperation(String operation) {
        winForm.elementById("popupMaintGasSetFlow").elementByName(operation).click();
    }

    public void setSRFMatch(String paramName, String editName, String paramValue) {
        page.elementByName("Source RF Center").elementByName("Match").click();
        newDesktopPage("SRFCenterMatch", null);
        desktopPage.elementByName(paramName).click();
        desktopPage.elementById(editName).elementByTag("Edit").clear().sendKeys(paramValue);
    }

    public void setSRFMatchOperateMode(String paramValue) {
        setSRFMatch("Operate Mode", "cmbOprMode", paramValue);
        serviceRunAndClose();
    }

    public void setSRFMatchRunMode(String paramValue) {
        setSRFMatch("Run Mode", "cmbRunMode", paramValue);
        serviceRunAndClose();
    }

    public void serviceRunAndClose() {
        serviceOperation("Run");
        serviceOperation("Close");
    }

    public void setGasFlows(DataTable table) {
        if (table.height() == 1) {
            return;
        }
        table.asMaps().get(0).forEach((key, value) -> {
            switch (key) {
                case "Ar":
                    setGasFlow(210, 29, 10, 29, value);
                    break;
                case "O2":
                    setGasFlow(210, 52, 10, 52, value);
                    break;
                case "He":
                    setGasFlow(210, 69, 10, 69, value);
                    break;
                case "N2":
                    setGasFlow(210, 91, 10, 91, value);
                    break;
                case "SF6":
                    setGasFlow(210, 112, 10, 112, value);
                    break;
                case "CF4":
                    setGasFlow(210, 130, 10, 130, value);
                    break;
                case "Cl2":
                    setGasFlow(210, 150, 10, 150, value);
                    break;
                case "Bcl3":
                    setGasFlow(210, 170, 10, 170, value);
                    break;
                case "Spare9":
                    setGasFlow(210, 191, 10, 191, value);
                    break;
                case "Spare10":
                    setGasFlow(210, 212, 10, 212, value);
                    break;
            }
        });
    }

    public void setTemperature(String type, String value) {
        clickID("btnTemperature");
        newDesktopPage("Chamber Temperature", "");
        desktopPage.elementById("cmbNum").sendKeys(type);
        desktopPage.elementById("digitalPicker1").click();
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(value));
        desktopPage.elementByName("OK").click();
    }

    public void setTemperatureSuc(String type, String value) {
        setTemperature(type, value);
        desktopPage.elementByName("Run").click();
    }

    public Object getTemperature(String type) {
        switch (type) {
            case "Top(°C)":
                return page.elementById("superTextBox89").getText();
            case "Middle(°C)":
                return page.elementById("superTextBox73").getText();
            case "Rear(°C)":
                return page.elementById("superTextBox74").getText();
        }
        return null;
    }

    public void setGasFlow(int editX, int editY, int checkX, int cheCKy, String value) {
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("popupMaintGasSetFlow").elementById("tblGasFlow").getElement(), checkX, cheCKy).click().perform();
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("popupMaintGasSetFlow").elementById("tblGasFlow").getElement(), editX, editY).doubleClick().perform();
        if (value == null)
            value = "";
        winForm.elementById("popupMaintGasSetFlow").elementById("tblGasFlow").elementByTag("Edit").clear().sendKeys(value);
    }

    public Map<Object, Object> getSetPoins() {
        Map<Object, Object> setPoints = new HashMap<>();
        setPoints.put("Ar", getSetPoin("Ar"));
        setPoints.put("O2", getSetPoin("O2"));
        setPoints.put("He", getSetPoin("He"));
        setPoints.put("N2", getSetPoin("N2"));
        setPoints.put("SF6", getSetPoin("SF6"));
        setPoints.put("CF4", getSetPoin("CF4"));
        setPoints.put("Cl2", getSetPoin("Cl2"));
        setPoints.put("Bcl3", getSetPoin("Bcl3"));
        return setPoints;
    }

    public Object getSetPoin(String gas) {
        switch (gas) {
            case "Ar":
                return page.elementById("superTextBox52").getText();
            case "O2":
                return page.elementById("superTextBox51").getText();
            case "He":
                return page.elementById("superTextBox54").getText();
            case "N2":
                return page.elementById("superTextBox43").getText();
            case "SF6":
                return page.elementById("superTextBox42").getText();
            case "CF4":
                return page.elementById("superTextBox50").getText();
            case "Cl2":
                return page.elementById("superTextBox44").getText();
            case "Bcl3":
                return page.elementById("superTextBox41").getText();
            case "Spare9":
                return page.elementById("superTextBox82").getText();
            case "Spare10":
                return page.elementById("superTextBox83").getText();
        }
        return null;
    }

    public void selectGasFlow(int checkX, int cheCKy) {
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("popupMaintGasSetFlow").elementById("tblGasFlow").getElement(), checkX, cheCKy).click().perform();
    }

    public void setBRFPower(int arg0) {
        page.elementByName("Bias RF").elementByName("BRF").click();
        newDesktopPage("BRF", "");
        desktopPage.elementByName("Set Power").click();
        desktopPage.elementById("digitalSetPower").click();
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(arg0));
        desktopPage.elementByName("OK").click();
        RFRun();
    }

    public String getBRFForward() {
        return page.elementByName("Bias RF").elementById("superTextBox15").getText();
    }

    public void vacuumMainM(String arg0) {
        page.elementByName("Vacuum").elementById("btnVcm").click();
        newDesktopPage("Vacuum", "");
        desktopPage.elementByName(arg0).click();
        RFRun();
    }

    public void selectGasFlows(DataTable table) {
        for (String key : table.column(0)) {
            switch (key) {
                case "Ar":
                    selectGasFlow(10, 29);
                    break;
                case "O2":
                    selectGasFlow(10, 52);
                    break;
                case "He":
                    selectGasFlow(10, 69);
                    break;
                case "N2":
                    selectGasFlow(10, 91);
                    break;
                case "SF6":
                    selectGasFlow(10, 112);
                    break;
                case "CF4":
                    selectGasFlow(10, 130);
                    break;
                case "Cl2":
                    selectGasFlow(10, 150);
                    break;
                case "Bcl3":
                    selectGasFlow(10, 170);
                    break;
                case "Spare9":
                    selectGasFlow(10, 191);
                    break;
                case "Spare10":
                    selectGasFlow(10, 212);
                    break;
            }
        }
    }

    public void setMaxMinGasFlows(DataTable table, String action) {
        selectGasFlows(table);
        if (action.equals("Select All")) {
            if (!winForm.elementById("popupMaintGasSetFlow").elementByName("Select All").isSelect()) {
                new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("popupMaintGasSetFlow").
                        elementByName("Select All").getElement()).click().perform();
            }
        } else {
            new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("popupMaintGasSetFlow").elementByName(action).getElement()).click().perform();
        }
    }

    public void setAllMaxMinGasFlows(String action) {
        if (!winForm.elementById("popupMaintGasSetFlow").elementByName("Select All").isSelect()) {
            new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("popupMaintGasSetFlow").
                    elementByName("Select All").getElement()).click().perform();
        }
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("popupMaintGasSetFlow").elementByName(action).getElement()).click().perform();
    }

    private String transformTextName(String elementName) {
        switch (elementName) {
            case "DryPump":
                return "roughPump1";
            case "TurboPump":
                return "turboPump1";
            case "TPN2":
                return "gasValve7";
            case "ISO":
                return "gasValve19";
            case "fast":
                return "gasValve26";
            case "slow":
                return "gasValve13";
            case "HePrimary":
                return "gasValve3";
            case "HeStabilize":
                return "gasValve4";
            case "HeForelineEVAC":
                return "gasValve1";
            case "HeSecondary":
                return "gasValve2";
            case "Final":
                return "gasValve8";
            default:
                throw new RuntimeException("未知控件名" + elementName);
        }
    }

    private void setState(String elementName, String elementPage, String state) {
        page.elementByName(transformTextName(elementName)).click();
        newDesktopPage(elementPage, "");
        desktopPage.elementByName(state).click();
        desktopPage.elementByName("Run").click();
    }

    public void setPump(String pumpName, String pumpState) {
        setState(pumpName, "Chamber " + pumpName, pumpState);
    }

    public void setValve(String valveName, String valveState) {
        setState(valveName, "Valve Operations", valveState);
    }

    public String servicePumpState(String pumpName) {
        return desktopPage.elementByName(transformTextName(pumpName)).getImageValue(ImageValueMaps.VALVEEtch1);
    }

    public String controlState(String pumpName) {
        return page.elementByName(transformTextName(pumpName)).getImageValue(ImageValueMaps.VALVEEtch1);
    }

    public String serviceValveState() {
        return desktopPage.elementByName("gasValve1").getImageValue(ImageValueMaps.VALVEEtch1);
    }

    public void setSRFEdgeMode(String f) {
        page.elementByName("Source RF Edge").elementByName("SRF").click();
        newDesktopPage("SRFEdge", "");
        desktopPage.elementByName("Set Mode").click();
        desktopPage.elementById("cmbSetMode").click().click().sendKeys(f);
        RFRun();
    }

    public void SRFEdgeRFOn() {
        page.elementByName("Source RF Edge").elementByName("SRF").click();
        newDesktopPage("SRFEdge", "");
        desktopPage.elementByName("RF On").click();
        RFRun();
    }

    public void SRFEdgeRFOff() {
        page.elementByName("Source RF Edge").elementByName("SRF").click();
        newDesktopPage("SRFEdge", "");
        desktopPage.elementByName("RF Off").click();
        RFRun();
    }

    public Object getSrcRFCenterValue(String name) {
        switch (name) {
            case "Forward(W)":
                return page.elementById("superTextBox11").getText();
            case "Reflected(W)":
                return page.elementById("superTextBox12").getText();
            case "C1":
                return page.elementById("superTextBox13").getText();
            case "C2":
                return page.elementById("superTextBox14").getText();
        }
        return null;
    }

    public Object getBiasRFValue(String name) {
        switch (name) {
            case "Forward(W)":
                return page.elementById("superTextBox15").getText();
            case "Reflected(W)":
                return page.elementById("superTextBox16").getText();
            case "C1":
                return page.elementById("superTextBox17").getText();
            case "C2":
                return page.elementById("superTextBox18").getText();
            case "DC Bias(V)":
                return page.elementById("superTextBox19").getText();
            case "DutyCycle(%)":
                return page.elementById("superTextBox87").getText();
            case "Frequency(Hz)":
                return page.elementById("superTextBox86").getText();
            case "WaveMode":
                return page.elementById("superTextBox107").getText();
        }
        return null;
    }

    public Object getSrcRFEdgeValue(String name) {
        switch (name) {
            case "Forward(W)":
                return page.elementById("superTextBox95").getText();
            case "Reflected(W)":
                return page.elementById("superTextBox94").getText();
            case "C1":
                return page.elementById("superTextBox93").getText();
            case "C2":
                return page.elementById("superTextBox92").getText();
        }
        return null;
    }

    public void BRFEInit() {
        page.elementByName("Bias RF").elementByName("Match").click();
        newDesktopPage("BMatch", "");
        desktopPage.elementByName("InitC1C2").click();
        RFRun();
    }

    public void setBRFEdgeC(int arg0, int arg1) {
        page.elementByName("Bias RF").elementByName("Match").click();
        newDesktopPage("BMatch", "");
        desktopPage.elementByName("PreSet").click();
        desktopPage.elementById("digitalPicker" + arg0).click();
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(arg1));
        desktopPage.elementByName("OK").click();
        setBRFEdgeC(arg0);
        RFRun();
    }

    private void setBRFEdgeC(int cNum) {
        if (cNum == 1)
            desktopPage.elementById("digitalPicker" + 2).click();
        else
            desktopPage.elementById("digitalPicker" + 1).click();
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(0));
        desktopPage.elementByName("OK").click();
    }

    public void setBRF(String module, int value) {
        page.elementByName("Bias RF").elementByName("BRF").click();
        newDesktopPage("BRF", "");
        switch (module) {
            case "DutyCycle(%)":
                desktopPage.elementByName("Set DutyCycle").click();
                desktopPage.elementById("digitalPicker1").click();
                break;
            case "Frequency(Hz)":
                desktopPage.elementByName("Set Frequency").click();
                desktopPage.elementById("digitalPicker2").click();
                break;
        }
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(value));
        desktopPage.elementByName("OK").click();
        desktopPage.elementByName("Close").click();
    }

    public Object getPM2GDEValue(String name) {
        switch (name) {
            case "Pre(mTorr)":
                return page.elementById("superTextBox77").getText();
            case "Lr(mT/min)":
                return page.elementById("superTextBox76").getText();
        }
        return null;
    }

    public void setChillerTemp(int arg0) {
        clickAction("Chiller");
        newDesktopPage("Chamber Chiller", "");
        desktopPage.elementByName("Set Temperature").click();
        desktopPage.elementById("digitalPicker1").click();
        desktopPage.elementById("txtInput").sendKeys(String.valueOf(arg0));
        desktopPage.elementByName("OK").click();
    }

    public void setGasFlows(String action, DataTable table) {
        clickID("btnsetgasflow");
        setMaxMinGasFlows(table, action);
        gasOperation("Run");
        gasOperation("Close");
    }

    public void setAllGasFlows(String action) {
        clickID("btnsetgasflow");
        setAllMaxMinGasFlows(action);
        gasOperation("Run");
        gasOperation("Close");
    }

    public void setGasFlowsRun(DataTable table) {
        clickID("btnsetgasflow");
        setGasFlows(table);
        gasOperation("Run");
    }

    public void setGasFlowsRunAndClose(DataTable table) {
        setGasFlowsRun(table);
        gasOperation("Close");
    }
}
