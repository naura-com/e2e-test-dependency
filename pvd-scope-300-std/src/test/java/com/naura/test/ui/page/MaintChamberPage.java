package com.naura.test.ui.page;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class MaintChamberPage extends ParentPage {
    private final Window.WindowOperation page;
    private final WinForm winForm;

    public MaintChamberPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    private static String transformToValveId(String valveName) {
        switch (valveName) {
            case "G0501":
                return "mG0501_gsv";
            case "G0601":
                return "mG0601_gsv";
            case "G0701":
                return "mG0701_gsv";
            case "G0801":
                return "mG0801_gsv";
            case "G0602":
                return "mG0602_gsv";
            case "G0503":
                return "mG0503_gsv";
            case "G0603":
                return "mG0603_gsv";
            case "G0703":
                return "mG0703_gsv";
            case "G0803":
                return "mG0803_gsv";
            case "G0504":
                return "mG0504_gsv";
            case "G0604":
                return "mG0604_gsv";
            case "G0704":
                return "mG0704_gsv";
            case "G0804":
                return "mG0804_gsv";
            case "C1":
                return "mC1_gsv";
            case "C2":
                return "mC2_gsv";
            case "C3":
                return "mC3_gsv";
            case "C4":
                return "mC4_gsv";
            case "C7":
                return "mC7_gsv";
            case "C9":
                return "mC9_gsv";
            case "C10":
                return "mC10_gsv";
            case "C11":
                return "mC11_gsv";
            case "C12":
                return "mC12_gsv";
            case "C15":
                return "mC15_gsv";
            case "P1":
                return "mP1_gsv";
            case "P2":
                return "mP2_gsv";
            case "P3":
                return "mP3_gsv";
            case "P4":
                return "mP4_gsv";
            case "P21_1":
                return "mP21_1_gsv";
            case "P21_2":
                return "mP21_2_gsv";
            case "P22_1":
                return "mP22_1_gsv";
            case "P22_2":
                return "mP22_2_gsv";
            case "P23_1":
                return "mP23_1_gsv";
            case "P23_2":
                return "mP23_2_gsv";
            case "P24":
                return "mP24_gsv";
            case "Heater水阀":
                return "mHeaterWaterVlv_gsv";
            case "腔室水阀":
                return "mChamberWaterVlv_gsv";
            case "TV":
                return "mButterflyVlv_bv";
            case "隔离阀":
                return "mSlitVlv_sv";
            case "门阀":
                return "mTPGateVlv_gtv";
            default:
                throw new RuntimeException("Unknown valve control id of: " + valveName);
        }
    }

    private static String transformToMfcLabelId(String mfcName) {
        switch (mfcName) {
            case "MFC5(2000)":
                return "mMFC05FlowAI_stb";
            case "MFC6(5000)":
                return "mMFC06FlowAI_stb";
            case "MFC7(6000)":
                return "mMFC07FlowAI_stb";
            case "MFC8(2000)":
                return "mMFC08FlowAI_stb";
            case "MFC23(5000)":
                return "mMFC23FlowAI_stb";
            case "MFC21(3000)":
                return "mMFC21FlowAI_stb";
            case "MFC22(3000)":
                return "mMFC22FlowAI_stb";
            case "PC01(100)":
                return "mPC1FlowAI_stb";
            default:
                throw new RuntimeException("Unknown MFC label id of: " + mfcName);
        }
    }

    private static String transformToMfcAOLabelId(String mfcName) {
        switch (mfcName) {
            case "PC01(100)":
                return "mPC1FlowAO_stb";
            default:
                throw new RuntimeException("Unknown MFC label id of: " + mfcName);
        }
    }

    public void openValve(String valveName) {
        String valveId = transformToValveId(valveName);
        page.elementById(valveId).click();
        switch (valveName) {
            case "TV":
                winForm.elementByName("打开").click();
                winForm.elementByName("确定").click();
                break;
            case "隔离阀":
            case "门阀":
                winForm.elementByName("全开").click();
                winForm.elementByName("确定").click();
                break;
            default:
                winForm.elementByName("打开阀门").click();
                winForm.elementByName("确定").click();
        }
    }

    public void closeValve(String valveName) {
        String valveId = transformToValveId(valveName);
        page.elementById(valveId).click();
        switch (valveName) {
            case "TV":
            case "隔离阀":
            case "门阀":
                winForm.elementByName("关闭").click();
                winForm.elementByName("确定").click();
                break;
            default:
                winForm.elementByName("关闭阀门").click();
                winForm.elementByName("确定").click();
        }
    }

    public String valveState(String valveName) {
        return page.elementById(transformToValveId(valveName)).getImageValue(ImageValueMaps.VALVE);
    }

    public void setMfcValue(String mfcName, String config, String value) {
        page.elementByName(mfcName).click();
        switch (mfcName) {
            case "PC01(100)":
                winForm.submit(() ->
                        {
                            winForm.elementByName(config).click();
                            winForm.elementById("tb_tmp").sendKeys(value);
                        }
                );
                break;
            default:
                winForm.submit(() ->
                        {
                            winForm.elementByName(config).click();
                            winForm.elementById("mFlowRate_tb").sendKeys(value);
                        }
                );
                break;
        }
    }

    public void setMfcValue(String mfcName, String value) {
        page.elementByName(mfcName).click();
        winForm.submit(() -> winForm.elementByName("流量(sccm)").sendKeys(value));
    }

    public void setMfcConfig(String mfcName, String config) {
        page.elementByName(mfcName).click();
        winForm.submit(() -> winForm.elementByName(config).click());
    }

    public String getMfcValue(String mfcName) {
        return page.elementById(transformToMfcLabelId(mfcName)).getText();
    }

    public String getMfcAOValue(String mfcName) {
        return page.elementById(transformToMfcAOLabelId(mfcName)).getText();
    }

    public void selectChamber(String chamber) {
        switch (chamber) {
            case ("Ch2"): {
                winForm.elementById("mCh2_rbtn").click();
                break;
            }
            case ("Ch3"): {
                winForm.elementById("mCh3_rbtn").click();
                break;
            }
            default:
                throw new RuntimeException("Unknown Chamber " + chamber);
        }
    }

    public void doOperate(String action) {
        switch (action) {
            case ("初始化"): {
                page.elementById("mInit_bts").click();
                break;
            }
            case ("充大气"): {
                page.elementById("mVent_bts").click();
                break;
            }
            case ("抽真空"): {
                page.elementById("mPumpDown_bts").click();
                break;
            }
            case ("压升率"): {
                page.elementById("mROR_bts").click();
                break;
            }
            case ("设置物料"): {
                page.elementById("mWaferCounter_bts").click();
                break;
            }
            case ("循环吹扫"): {
                page.elementById("mCyclePurge_bts").click();
                break;
            }
            case ("基座测试设定"): {
                page.elementById("mLifterCycle_bts").click();
                break;
            }
            case ("Home位置位"): {
                page.elementById("mHome_bts").click();
                break;
            }
            case ("工艺位置位"): {
                page.elementById("mProcessPos1_bts").click();
                break;
            }
            case ("传片位置位"): {
                page.elementById("mTransferLiftPos_bts").click();
                break;
            }
            case ("背吹压力设定"): {
                page.elementByName("设定压力").click();
                break;
            }
            case ("FullChuck"): {
                winForm.elementById("rbtn_FullChuck").click();
                break;
            }
            case ("Bypass"): {
                winForm.elementById("bts_Bypass").click();
                break;
            }
            case ("Off"): {
                winForm.elementById("bts_Off").click();
                break;
            }
            case ("压力设定"): {
                page.elementByName("设定压力").click();
                break;
            }
            case ("蝶阀压力设定"): {
                page.elementByName("压力设定").click();
                break;
            }
            case ("蝶阀位置设定"): {
                page.elementByName("位置设定").click();
                break;
            }
            case ("设定功率"): {
                page.elementById("mSetPower_bts").click();
                break;
            }
            case ("设定Match"): {
                page.elementById("mSetMatch_bts").click();
                break;
            }
            case ("关闭电源"): {
                page.elementById("mSetPowerZero_bts").click();
                break;
            }
            case ("预设C1/C2"): {
                winForm.elementById("mPreset_rbtn").click();
                break;
            }
            case ("手调C1/C2"): {
                winForm.elementById("mManualSet_rbtn").click();
                break;
            }
            default:
                throw new RuntimeException("Unknown Operation " + action);
        }
    }

    public void makeSure() {
        if (winForm.elementById("mTitle_lab").getText().equals("确认")) {
            if (winForm.elementById("mMsg_lbl").getText().equals("执行‘初始化’服务？")) {
                try {
                    winForm.elementByName("确定").click();
                    Thread.sleep(8000);//初始化动画加载时间延迟等待
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                winForm.elementByName("确定").click();
            }
        } else {
            try {
                winForm.elementByName("确定").click();
                Thread.sleep(5000);//修改Value时界面显示存在延迟问题，用此方法规避
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getValue(String name) {
        String value = null;
        switch (name) {
            case ("腔室当前压力"): {
                try {
                    Thread.sleep(1000);//修改pressureValue时界面显示存在延迟问题，用此方法规避
                    value = page.elementById("mChamberPressure_stb").getText();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case ("蝶阀当前压力"): {
                try {
                    Thread.sleep(1000);//修改pressureValue时界面显示存在延迟问题，用此方法规避
                    value = page.elementById("mPressureAI_stb").getText();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case ("蝶阀设定压力"): {
                try {
                    Thread.sleep(1000);//修改pressureValue时界面显示存在延迟问题，用此方法规避
                    value = page.elementById("mPressureAO_stb").getText();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case ("蝶阀当前位置"): {
                try {
                    Thread.sleep(1000);//修改pressureValue时界面显示存在延迟问题，用此方法规避
                    value = page.elementById("mPositionDI_stb").getText();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case ("蝶阀设定位置"): {
                try {
                    Thread.sleep(1000);//修改pressureValue时界面显示存在延迟问题，用此方法规避
                    value = page.elementById("mPositionDO_stb").getText();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case ("物料数量"): {
                value = page.elementById("mWaferCounter_stb").getText();
                break;
            }
            case ("基座当前位置"): {
                value = page.elementById("mChuckCurPos_stb").getText();
                break;
            }
            case ("测试总数"): {
                value = page.elementById("mChuckMarathonTotal_stb").getText();
                break;
            }
            case ("背吹设定压力"): {
                value = page.elementById("mSetPressure_stb").getText();
                break;
            }
            case ("背吹当前压力"): {
                value = page.elementById("mCurPressure_stb").getText();
                break;
            }
            case ("设定功率"): {
                value = page.elementById("mImpactPowerSp_stb").getText();
                break;
            }
            case ("前向功率"): {
                value = page.elementById("mImpactPowerVp_stb").getText();
                break;
            }
            case ("C1Match"): {
                try {
                    Thread.sleep(5000);
                    value = page.elementById("mMatchC1Pos_stb").getText();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case ("C2Match"): {
                try {
                    Thread.sleep(5000);
                    value = page.elementById("mMatchC2Pos_stb").getText();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            default:
                throw new RuntimeException("Unknown Parameter " + name);
        }
        return value;
    }

    public void setValue(String valueCount) {
        if (!winForm.elementById("mParam_tb").getText().isEmpty()) {
            winForm.elementById("mParam_tb").clear();
        }
        winForm.elementById("mParam_tb").sendKeys(valueCount);
        if (winForm.elementById("mParam_tb").getText().isEmpty()) {
            winForm.elementByName("确定").click();
            try {
                Thread.sleep(500);//添加延迟进程解决ErrorProvider图标闪烁时鼠标点击无法获取到Info
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getErrorProvider(String errorType) {
        switch (errorType) {
            case ("物料数量"): {
                new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("mParam_tb").getElement()).moveByOffset((winForm.elementById("mParam_tb").getElement().getSize().width / 2) + 5, 0).perform();
                break;
            }
            case ("吹扫次数"): {
                new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementById("mParam_tb").getElement()).moveByOffset((winForm.elementById("mParam_tb").getElement().getSize().width / 2) + 5, 0).perform();
                break;
            }
            default:
                throw new RuntimeException("Unknown ErrorType " + errorType);
        }
        return winForm.getErrorProviderInfo();
    }

    public void setPedestal(String startPos, String endPos, int testCount, int delayTime) {
        winForm.elementById("mStartPos_cmb").click();
        for (int i = 0; i <= winForm.elementById("mStartPos_cmb").getListValue().indexOf(startPos); i++) {
            winForm.elementById("mStartPos_cmb").Keyboard(Keys.ARROW_DOWN);//ComboBox下拉框select方法无法选中，改为此方法解决
        }
        winForm.elementById("mStartPos_cmb").Keyboard(Keys.ENTER);
        winForm.elementById("mEndPos_cmb").click();
        for (int i = 0; i <= winForm.elementById("mEndPos_cmb").getListValue().indexOf(endPos); i++) {
            winForm.elementById("mEndPos_cmb").Keyboard(Keys.ARROW_DOWN);//ComboBox下拉框select方法无法选中，改为此方法解决
        }
        winForm.elementById("mEndPos_cmb").Keyboard(Keys.ENTER);
        winForm.elementById("mChuckCycle_tb").sendKeys(Integer.toString(testCount));
        winForm.elementById("mBreak_tb").sendKeys(Integer.toString(delayTime));
    }

    public void setVacChuckValue(String mode, String pressureValue) {
        winForm.elementByName(mode).click();
        winForm.elementById("tb_tmp").sendKeys(pressureValue);
    }

    public String getMode(String name, String mode) {
        String text = null;
        switch (name) {
            case ("背吹当前模式"): {
                text = page.elementByName(mode).getText();
                break;
            }
            case ("蝶阀当前模式"): {
                text = page.elementByName(mode).getText();
                break;
            }
            default:
                throw new RuntimeException("Unknown Mode " + mode);
        }
        return text;
    }

    public void selectTag(String tag) {
        switch (tag) {
            case ("RF"): {
                page.elementByName("  RF").click();
                break;
            }
            default:
                throw new RuntimeException("Unknown Operation " + tag);
        }
    }

    public void setPowerValue(String p_name, String p_value, String a_name, String a_value) {
        winForm.findElementByXpath("//Edit[@Name='功率值(W)']").sendKeys(p_value);
        winForm.findElementByXpath("//Edit[@Name='加载速度(W/s)']").sendKeys(a_value);
    }

    public void setMatchValue(String mode1, String mode2, String c1, String c2) {
        if (!winForm.elementById("tb_c1").getText().isEmpty()) {
            winForm.elementById("tb_c1").clear();
        }
        winForm.elementById("tb_c1").click().sendKeys(c1);
        if (!winForm.elementById("tb_c2").getText().isEmpty()) {
            winForm.elementById("tb_c2").clear();
        }
        winForm.elementById("tb_c2").sendKeys(c2);
        winForm.elementByName(mode1 + "C1/C2").click();
        new Actions(winForm.getWindowsDriver()).moveToElement(winForm.elementByName("确定").getElement()).click().perform();//解决在设置value后当前选中变为自动模式的问题
    }
}
