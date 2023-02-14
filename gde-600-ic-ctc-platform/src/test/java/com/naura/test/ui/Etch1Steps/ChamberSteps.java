package com.naura.test.ui.Etch1Steps;

import Ice.StringHolder;
import com.naura.test.ice.IComControlObject.RemoteServiceResultHolder;
import com.naura.test.api.api.LowerApi;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import com.naura.test.ui.page.FileOption;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class ChamberSteps {
    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;

    String currentWindowStore = null;

    @Value("${app.local-path1}")
    private String appPath;

    @Autowired
    private LowerApi lowerApi;

    @当("执行{string}方法")
    public void 执行方法(String action) {
        mainPage.maintainPage().chamberPage().clickAction(action);
    }

    @那么("{string}操作成功,Module Status状态显示正确:")
    public void 操作成功ModuleStatus状态显示正确(String action, String verification) {
        expect(mainPage.maintainPage().chamberPage().getModuleStatus(action)).should(verification);
    }

    @那么("{string}操作成功,Run Service状态显示正确:")
    public void 操作成功RunService状态显示正确(String action, String verification) {
        expect(mainPage.maintainPage().chamberPage().getRunService(action)).should(verification);
    }

    @假如("{string}处于{string}模式")
    public void 处于模式(String arg0, String arg1) {
        mainPage.maintainPage().chamberPage().selectPM(arg0);
        if (!mainPage.maintainPage().chamberPage().getModuleStatus("Maintain").equals(arg1))
            mainPage.maintainPage().chamberPage().clickAction("Maintain");
    }

    @当("设置chiller温度为{int}度并确认")
    public void 设置chiller温度为度并确认(int arg0) {
        mainPage.maintainPage().chamberPage().setChillerTempSur(arg0);
    }

    @那么("设置chiller失败，提示信息为:")
    public void 设置chiller失败提示信息为(String verification) {
        mainPage.maintainPage().chamberPage().sureMessandOK(verification);
    }

    @并且("在Chamber chiller执行Run动作")
    public void 在chamberChiller执行Run动作() {
        mainPage.maintainPage().chamberPage().chillerRun();
    }

    @那么("chiller温度被设置为{int}度")
    public void chiller温度被设置为度(int arg0) {
        assertThat(arg0 == Double.parseDouble(mainPage.maintainPage().chamberPage().chillerTemp())).isTrue();
    }

    @当("设置chiller执行Pinup操作")
    public void 设置chiller执行pinup操作() {
        mainPage.maintainPage().chamberPage().pinUp();
    }


    @当("设置chiller执行Pindown操作")
    public void 设置chiller执行pindown操作() {
        mainPage.maintainPage().chamberPage().pinDown();
    }

    @那么("Pin针在动画中变为升起状态")
    public void pin针在动画中变为升起状态() {
        assertThat(mainPage.maintainPage().chamberPage().pin1Enable()).isTrue();
    }

    @那么("Pin针在动画中消失")
    public void pin针在动画中消失() {
        assertThat(mainPage.maintainPage().chamberPage().pin1Enable()).isFalse();
    }

    @当("点击{string}")
    public void 点击(String action) {
        mainPage.maintainPage().chamberPage().clickID("btnsetgasflow");
    }

    @并且("设置{string}的流量值为{string}")
    public void 设置的流量值为(String gasName, String value) {
        mainPage.maintainPage().chamberPage().setGas(gasName, value);
    }

    @那么("执行失败,异常提示为:")
    public void 执行失败异常提示为(String verification) {
        expect(mainPage.verifyClickAction("OK")).should(verification);
        mainPage.maintainPage().chamberPage().gasOperation("Close");
    }

    @当("设置He压力为{string}时")
    public void 设置he压力为时(String pressure) {
        mainPage.maintainPage().chamberPage().setHePressure(pressure);
    }

    @那么("设置He压力失败并提示")
    public void 设置he压力失败并提示(String verification) {
        expect(mainPage.maintainPage().chamberPage().getDigitalMessage("确定")).should(verification);
        mainPage.maintainPage().chamberPage().closeDigitalForm();
    }

    @那么("服务窗口显示值为")
    public void 服务窗口显示值为(String verification) {
        expect(mainPage.maintainPage().chamberPage().getServiceValue()).should(verification);
    }

    @那么("He压力值显示为")
    public void he压力值显示为(String verification) {
        expect(mainPage.maintainPage().chamberPage().getHePressure()).should(verification);
    }

    //TODO 合并
    @当("设置He压力为{string}并确定时")
    public void 设置he压力为并确定时(String pressure) {
        mainPage.maintainPage().chamberPage().setHePressure(pressure);
        mainPage.maintainPage().chamberPage().serviceOperation("OK");
    }

    @并且("在DigitalInput窗口执行{string}")
    public void 在digitalinput窗口执行(String operation) {
        mainPage.maintainPage().chamberPage().digitalOperation(operation);
    }

    @那么("DigitalInput窗口{string}显示为")
    public void digitalinput窗口显示为(String textName, String verification) {
        expect(mainPage.maintainPage().chamberPage().getDigitalText(textName)).should(verification);
        mainPage.maintainPage().chamberPage().closeDigitalForm();
    }

    @并且("在GasSetFlow窗口执行{string}")
    public void 在gassetflow窗口执行(String operation) {
        mainPage.maintainPage().chamberPage().gasOperation(operation);
    }

    @当("设置chiller执行RinUp操作")
    public void 设置chiller执行rinup操作() {
        mainPage.maintainPage().chamberPage().RingUp();
    }

    @当("设置chiller执行RinDown操作")
    public void 设置chiller执行rindown操作() {
        mainPage.maintainPage().chamberPage().RingDown();
    }

    @那么("Ring状态变为{string}")
    public void ring状态变为(String arg0) {
        assertThat(mainPage.maintainPage().chamberPage().ringStatus()).isEqualTo(arg0);
    }

    @当("设置ESC模块的DC值为{int}")
    public void 设置esc模块的dc值为(int arg0) {
        mainPage.maintainPage().chamberPage().setESCDC(arg0);
    }

    @那么("ESC模块的DC值变为{int}")
    public void esc模块的dc值变为(int arg0) {
        assertThat(arg0 == Double.parseDouble(mainPage.maintainPage().chamberPage().ESCDCvalue())).isTrue();
    }

    @当("设置SRF Center的Forward值为{int}")
    public void 设置srfCenter的Forward值为(int arg0) {
        mainPage.maintainPage().chamberPage().setSRFCenterPower(arg0);
    }

    @那么("SRF Center的Forward值变为{int}")
    public void srfCenter的Forward值变为(int arg0) {
        assertThat(arg0 == Double.parseDouble(mainPage.maintainPage().chamberPage().SRFCForwardvalue())).isTrue();
    }

    @当("设置SRF Edge的Forward值为{int}")
    public void 设置srfEdge的Forward值为(int arg0) {
        mainPage.maintainPage().chamberPage().setSRFEdgePower(arg0);
    }

    @那么("SRF Edge的Forward值变为{int}")
    public void srfEdge的Forward值变为(int arg0) {
        assertThat(arg0 == Double.parseDouble(mainPage.maintainPage().chamberPage().SRFEForwardValue())).isTrue();
    }

    @当("在SRF Center Match中初始化C1C2")
    public void 在srfCenterMatch中初始化C1C2() {
        mainPage.maintainPage().chamberPage().SRFCInit();
    }

    @当("在SRF Edge Match中初始化C1C2")
    public void 在srfEdgeMatch中初始化C1C2() {
        mainPage.maintainPage().chamberPage().SRFEInit();
    }

    @那么("SRF Center C1C2被初始化为{int}")
    public void srfCenterC1C2被初始化为(int arg0) {
        mainPage.maintainPage().chamberPage().SRFCSureInit(arg0);
    }

    @那么("SRF Edge C1C2被初始化为{int}")
    public void srfEdgeCC被初始化为(int arg0) {
        mainPage.maintainPage().chamberPage().SRFESureInit(arg0);
    }

    @当("设置SourceRF的Operate Mode为{string}")
    public void 设置sourcerf的operateMode为(String paramValue) {
        mainPage.maintainPage().chamberPage().setSRFMatchOperateMode(paramValue);
    }

    @那么("日志打印内容{string}")
    public void 日志打印内容(String logStr) {
        FileOption fileOption = new FileOption();
        assertThat(fileOption.checkLog(logStr, appPath + "//logs//log.txt")).isTrue();
    }

    @当("设置SourceRF的Run Mode为{string}")
    public void 设置sourcerf的runMode为(String paramValue) {
        mainPage.maintainPage().chamberPage().setSRFMatchRunMode(paramValue);
    }

    @并且("设置气体流量值如下")
    public void 设置气体流量值如下(DataTable table) {
        mainPage.maintainPage().chamberPage().setGasFlowsRun(table);
    }

    @当("在SRF Edge Match中设置C{int}值为{int}")
    public void 在srfEdgeMatch中设置C值为(int arg0, int arg1) {
        mainPage.maintainPage().chamberPage().setSRFEdgeC(arg0, arg1);
    }

    @那么("SRF Edge C{int}值变为{int}")
    public void srfEdgeC值变为(int arg0, int arg1) {
        assertThat(mainPage.maintainPage().chamberPage().SRFEdgeCValue(arg0)).isEqualTo(String.valueOf(arg1));
    }

    @当("在SRF Center Match中设置C{int}值为{int}")
    public void 在srfCenterMatch中设置C值为(int arg0, int arg1) {
        mainPage.maintainPage().chamberPage().setSRFCenterC(arg0, arg1);
    }

    @那么("SRF Certer C{int}值变为{int}")
    public void srfCerterC值变为(int arg0, int arg1) {
        assertThat(mainPage.maintainPage().chamberPage().SRFCenterCValue(arg0)).isEqualTo(String.valueOf(arg1));
    }

    @当("设置{string}温度为{string}")
    public void 设置温度为(String type, String value) {
        mainPage.maintainPage().chamberPage().setTemperature(type, value);
    }

    @那么("设置失败,弹出提示信息:")
    public void 设置失败弹出提示信息(String verification) {
        mainPage.maintainPage().chamberPage().sureMessandOK(verification);
    }

    @那么("设置成功,{string}的{string}显示为:")
    public void 设置成功的显示为(String pm, String type, String verification) {
        expect(mainPage.maintainPage().chamberPage().getTemperature(type)).should(verification);
    }

    @当("设置{string}温度为{string}并确认")
    public void 设置温度为并确认(String type, String value) {
        mainPage.maintainPage().chamberPage().setTemperatureSuc(type, value);
    }

    @当("设置BRF的Forward值为{int}")
    public void 设置brf的forward值为(int arg0) {
        mainPage.maintainPage().chamberPage().setBRFPower(arg0);
    }

    @那么("BRF的Forward值变为{int}")
    public void brf的forward值变为(int arg0) {
        assertThat(Double.parseDouble(mainPage.maintainPage().chamberPage().getBRFForward()) == arg0).isTrue();
    }

    @当("执行Vacuum中主要的{string}时")
    public void 执行vacuum中主要的时(String arg0) {
        mainPage.maintainPage().chamberPage().vacuumMainM(arg0);
    }

    //TODO 合并
    @那么("Run Service显示{string}")
    public void runService显示(String arg0) {
//        assertThat(mainPage.maintainPage().chamberPage().getRunService("Maintain").equals(arg0)).isTrue();
        assertThat(mainPage.maintainPage().chamberPage().getRunService("Maintain")).isEqualTo(arg0);
        mainPage.maintainPage().chamberPage().clickAction("Abort");
        mainPage.clearAllAlarm();
    }

    @那么("执行成功,{string}的Set Point显示正确:")
    public void 执行成功的SetPoint显示正确(String gas, String verification) {
        expect(mainPage.maintainPage().chamberPage().getSetPoin(gas)).should(verification);
    }

    //TODO 合并
    @并且("设置如下气体流量值执行{string}")
    public void 设置如下气体流量值执行(String action, DataTable table) {
        mainPage.maintainPage().chamberPage().setGasFlows(action, table);
    }

    @并且("所有气体流量值执行{string}")
    public void 所有气体流量值执行(String action) {
        mainPage.maintainPage().chamberPage().setAllGasFlows(action);
    }

    @那么("执行成功,Set Point显示正确:")
    public void 执行成功SetPoint显示正确(String verification) {
        expect(mainPage.maintainPage().chamberPage().getSetPoins()).should(verification);
    }

    @并且("设置气体流量值如下:")
    public void 设置气体流量值如下2(DataTable table) {
        mainPage.maintainPage().chamberPage().setGasFlowsRunAndClose(table);
    }

    @那么("{string}在服务窗口显示为{string}")
    public void 在服务窗口显示为(String pumpName, String pumpState) {
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().chamberPage().servicePumpState(pumpName))
                .isEqualTo(pumpName + pumpState));
    }

    @当("在服务窗口点击{string}")
    public void 在服务窗口点击(String operation) {
        mainPage.maintainPage().chamberPage().serviceOperation(operation);
    }

    @当("设置Pump{string}为{string}")
    public void 设置pump为(String pumpName, String pumpState) {
        mainPage.maintainPage().chamberPage().setPump(pumpName, "Pump " + pumpState);
    }

    @当("设置阀门{string}为{string}")
    public void 设置阀门为(String valveName, String valveState) {
        mainPage.maintainPage().chamberPage().setValve(valveName, valveState);
    }

    @那么("{string}显示为{string}")
    public void 显示为(String pumpName, String pumpState) {
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().chamberPage().controlState(pumpName))
                .isEqualTo(pumpName + pumpState));
    }

    @那么("阀门在服务窗口显示为{string}")
    public void 阀门在服务窗口显示为(String valveState) {
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().chamberPage().serviceValveState())
                .isEqualTo(valveState));
    }

    @那么("阀门{string}显示为{string}")
    public void 阀门显示为(String valveName, String valveState) {
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().chamberPage().controlState(valveName))
                .isEqualTo(valveState));
    }

    @当("设置SRF Edge 的SetMode为Forward")
    public void 设置srfEdge的SetMode为Forward() {
        mainPage.maintainPage().chamberPage().setSRFEdgeMode("f");
    }

    @当("设置SRF Edge 的SetMode为Load")
    public void 设置srfEdge的SetMode为Load() {
        mainPage.maintainPage().chamberPage().setSRFEdgeMode("l");
    }

    @当("SRF Edge 执行一次RF On")
    public void srfEdge执行一次RFOn() {
        mainPage.maintainPage().chamberPage().SRFEdgeRFOn();
    }

    @当("SRF Edge 执行一次RF Off")
    public void srfEdge执行一次RFOff() {
        mainPage.maintainPage().chamberPage().SRFEdgeRFOff();
    }

    @假如("设备{string}状态为{string}")
    public void 设备状态为(String name, String status) {
        RemoteServiceResultHolder resultHolder = new RemoteServiceResultHolder();
        StringHolder errHolder = new StringHolder();
        lowerApi.remocteControlObject("/Control/PMCExports/Controls/MPM").runService(status, name, resultHolder, errHolder);
    }

    @当("设置通道{string}为{string}")
    public void 设置通道为(String ioName, String value) {
        mainPage.setIO(ioName, value);
    }

    @那么("设置成功,Source RF Center的{string}显示为:")
    public void 设置成功SourceRFCenter的显示为(String name, String verification) {
        expect(mainPage.maintainPage().chamberPage().getSrcRFCenterValue(name)).should(verification);
    }

    @那么("Bias RF模块{string}值显示正确:")
    public void biasRF模块值显示正确(String name, String verification) {
        expect(mainPage.maintainPage().chamberPage().getBiasRFValue(name)).should(verification);
    }

    @那么("设置成功,Source RF Edge的{string}显示为:")
    public void 设置成功SourceRFEdge的显示为(String name, String verification) {
        expect(mainPage.maintainPage().chamberPage().getSrcRFEdgeValue(name)).should(verification);
    }

    @当("在Bias RF Match中初始化C1C2")
    public void 在biasRFMatch中初始化C1C2() {
        mainPage.maintainPage().chamberPage().BRFEInit();
    }

    @那么("Bias RF C1C2被初始化为{int}")
    public void biasRFC1C2被初始化为(int verification) {
        expect(mainPage.maintainPage().chamberPage().getBiasRFValue("C1")).should(String.valueOf(verification));
        expect(mainPage.maintainPage().chamberPage().getBiasRFValue("C2")).should(String.valueOf(verification));
    }

    @当("在Bias RF Match中设置C{int}值为{int}")
    public void 在biasRFMatch中设置C值为(int ci, int value) {
        mainPage.maintainPage().chamberPage().setBRFEdgeC(ci, value);
    }

    @那么("Bias RF的{string}值变为{int}")
    public void biasRF的值变为(String module, int verification) {
        expect(mainPage.maintainPage().chamberPage().getBiasRFValue(module)).should(String.valueOf(verification));
    }

    @当("设置BRF的{string}值为{int}")
    public void 设置brf的值为(String brfModule, int value) {
        mainPage.maintainPage().chamberPage().setBRF(brfModule, value);
    }

    @那么("设置成功,PM2 GDE的{string}显示为:")
    public void 设置成功PM2GDE的显示为(String module, String verification) {
        expect(mainPage.maintainPage().chamberPage().getPM2GDEValue(module)).should(verification);
    }

    @当("设置chiller温度为{int}度")
    public void 设置chiller温度为度(int arg0) {
        mainPage.maintainPage().chamberPage().setChillerTemp(arg0);
    }

    @并且("在服务窗口执行Run")
    public void 在服务窗口执行run() {
        mainPage.maintainPage().chamberPage().serviceRunAndClose();
    }

    @那么("阀门{string}在服务窗口和界面显示为{string}")
    public void 阀门在服务窗口和界面显示为(String valveName, String valveState) {
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().chamberPage().serviceValveState())
                .isEqualTo(valveState));
        mainPage.maintainPage().chamberPage().serviceOperation("Cancel");
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().chamberPage().controlState(valveName))
                .isEqualTo(valveState));
    }

    @那么("泵{string}在服务窗口在服务窗口和界面显示为{string}")
    public void 泵在服务窗口在服务窗口和界面显示为(String pumpName, String pumpState) {
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().chamberPage().servicePumpState(pumpName))
                .isEqualTo(pumpName + pumpState));
        mainPage.maintainPage().chamberPage().serviceOperation("Cancel");
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().chamberPage().controlState(pumpName))
                .isEqualTo(pumpName + pumpState));
    }
}
