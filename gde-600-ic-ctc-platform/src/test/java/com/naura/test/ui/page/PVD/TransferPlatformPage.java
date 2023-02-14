package com.naura.test.ui.page.PVD;

import com.naura.test.ui.driver.ImageValueMaps;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;

public class TransferPlatformPage {
    private final Window.WindowOperation page;
    private final WinForm winForm;

    public TransferPlatformPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void closeValve(String module, String valveName) {
        String valveId = transformToValveId(module, valveName);
        page.elementById(valveId).click();
        if (valveName.equals("门阀") || valveName.equals("隔离阀")) {
            winForm.elementByName("关闭").click();
        } else
            winForm.elementByName("关闭阀门").click();
        winForm.elementByName("确定").click();
    }

    public void openValve(String module, String valveName) {
        String valveId = transformToValveId(module, valveName);
        page.elementById(valveId).click();
        if (valveName.equals("门阀") || valveName.equals("隔离阀")) {
            winForm.elementByName("全开").click();
        } else
            winForm.elementByName("打开阀门").click();
        winForm.elementByName("确定").click();
    }

    private static String transformToValveId(String module, String valveName) {
        switch (module) {
            case "Transfer":
                switch (valveName) {
                    case "快充":
                        return "mTCFastVent_gv";
                    case "快抽":
                        return "mTCFastPump_gv";
                    case "门阀":
                        return "mTransfer_GateVlv";
                    default:
                        throw new RuntimeException("Unknown valve control id of: " + valveName);
                }
            case "ChA":
                switch (valveName) {
                    case "快充":
                        return "mChAFastVent_gv";
                    case "快抽":
                        return "mChAFastPump_gv";
                    case "Cooling Ar":
                        return "mChACooling_gv";
                    case "门阀":
                        return "mChADoor_sv";
                    case "隔离阀":
                        return "mChASlotValve_sv";
                    default:
                        throw new RuntimeException("Unknown valve control id of: " + valveName);
                }
            case "ChB":
                switch (valveName) {
                    case "快充":
                        return "mChBFastVent_gv";
                    case "快抽":
                        return "mChBFastPump_gv";
                    case "Cooling Ar":
                        return "mChBCooling_gv";
                    case "门阀":
                        return "mChBDoor_sv";
                    case "隔离阀":
                        return "mChBSlotValve_sv";
                    default:
                        throw new RuntimeException("Unknown valve control id of: " + valveName);
                }
            case "ChC":
                switch (valveName) {
                    case "隔离阀":
                        return "mChCSlotValve_sv";
                    default:
                        throw new RuntimeException("Unknown valve control id of: " + valveName);
                }
            case "ChE":
                switch (valveName) {
                    case "隔离阀":
                        return "mChESlotValve_sv";
                    default:
                        throw new RuntimeException("Unknown valve control id of: " + valveName);
                }
            case "Ch2":
                switch (valveName) {
                    case "隔离阀":
                        return "mCh2SlotValve_sv";
                    default:
                        throw new RuntimeException("Unknown valve control id of: " + valveName);
                }
            case "Ch3":
                switch (valveName) {
                    case "隔离阀":
                        return "mCh3SlotValve_sv";
                    default:
                        throw new RuntimeException("Unknown valve control id of: " + valveName);
                }
            case "Buffer":
                switch (valveName) {
                    case "快充":
                        return "mBuffFastVent_gv";
                    case "快抽":
                        return "mBuffFastPump_gv";
                    case "门阀":
                        return "mBuff_GateVlv";
                    default:
                        throw new RuntimeException("Unknown valve control id of: " + valveName);
                }
            case "LA":
                switch (valveName) {
                    case "慢充":
                        return "mLASlowVent_gv";
                    case "快充":
                        return "mLAFastVent_gv";
                    case "慢抽":
                        return "mLASlowPump_gv";
                    case "快抽":
                        return "mLAFastPump_gv";
                    case "门阀":
                        return "mLADoor_sv";
                    case "隔离阀":
                        return "mLASlotValve_sv";
                    default:
                        throw new RuntimeException("Unknown valve control id of: " + valveName);
                }
            case "LB":
                switch (valveName) {
                    case "慢充":
                        return "mLBSlowVent_gv";
                    case "快充":
                        return "mLBFastVent_gv";
                    case "慢抽":
                        return "mLBSlowPump_gv";
                    case "快抽":
                        return "mLBFastPump_gv";
                    case "门阀":
                        return "mLBDoor_sv";
                    case "隔离阀":
                        return "mLBSlotValve_sv";
                    default:
                        throw new RuntimeException("Unknown valve control id of: " + valveName);
                }
            default:
                throw new RuntimeException("Unknown module control id of: " + module);
        }
    }

    public String valveState(String module, String valveName) {
        return page.elementById(transformToValveId(module, valveName)).getImageValue(ImageValueMaps.PVDTransferPltVALVE);
    }

    public void selectChamber(String chamber) {
        switch (chamber) {
            case ("LA"): {
                page.elementByName("LA").click();
                break;
            }
            case ("LB"): {
                page.elementByName("LB").click();
                break;
            }
            case ("ChA"): {
                page.elementByName("ChA").click();
                break;
            }
            case ("ChB"): {
                page.elementByName("ChB").click();
                break;
            }
            case ("Transfer"): {
                page.elementByName("Transfer").click();
                break;
            }
            case ("Buffer"): {
                page.elementByName("Buffer").click();
                break;
            }
            case ("System"): {
                page.elementByName("System").click();
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
            case ("循环吹扫"): {
                page.elementById("mCyclePurge_bts").click();
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
            case ("温度控制"): {
                page.elementById("mSetTemp_bts").click();
                break;
            }
            case ("烘烤"): {
                page.elementById("mBakeout_bts").click();
                break;
            }
            case ("开关"): {
                page.elementById("mExchange_bts").click();
                break;
            }
            case ("打开"): {
                winForm.elementByName("打开").click();
                break;
            }
            case ("关闭"): {
                winForm.elementByName("关闭").click();
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
                try {
                    winForm.elementByName("确定").click();
                    Thread.sleep(5000);//修改Value时界面显示存在延迟问题，用此方法规避
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
            case ("LA当前压力"): {
                value = page.elementById("superTextBox5").getText();
                break;
            }
            case ("LB当前压力"): {
                value = page.elementById("superTextBox6").getText();
                break;
            }
            case ("ChA当前压力"): {
                value = page.elementById("superTextBox7").getText();
                break;
            }
            case ("ChB当前压力"): {
                value = page.elementById("superTextBox12").getText();
                break;
            }
            case ("Transfer当前压力"): {
                value = page.elementById("superTextBox2").getText();
                break;
            }
            case ("Transfer当前温度"): {
                value = page.elementById("superTextBox39").getText();
                break;
            }
            case ("Buffer当前压力"): {
                value = page.elementById("mBuffIG_stb").getText();
                break;
            }
            case ("Buffer当前温度"): {
                value = page.elementById("superTextBox40").getText();
                break;
            }
            case ("基座当前位置"): {
                try {
                    Thread.sleep(1000);//修改pressureValue时界面显示存在延迟问题，用此方法规避
                    value = page.elementById("mChuckCurPos_stb").getText();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case ("Heater当前温度"): {
                value = page.elementById("mReqTemp_stb").getText();
                break;
            }
            case ("Heater设定温度"): {
                value = page.elementById("mActTemp_stb").getText();
                break;
            }
            case ("耗时"): {
                try {
                    Thread.sleep(5000);
                    value = page.elementById("mPastTime_stb").getText();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case ("总时"): {
                try {
                    Thread.sleep(5000);
                    value = page.elementById("mTotalTime_stb").getText();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
            case ("开关状态"): {
                try {
                    Thread.sleep(1000);
                    value = page.elementById("superTextBox10").getText();
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

    public void setTempValue(String time_name, String time_value, String temp_name, String temp_value) {
        winForm.findElementByXpath("//Edit[@Name='时间(H)']").sendKeys(time_value);
        winForm.findElementByXpath("//Edit[@Name='温度(°C)']").sendKeys(temp_value);
    }
}
