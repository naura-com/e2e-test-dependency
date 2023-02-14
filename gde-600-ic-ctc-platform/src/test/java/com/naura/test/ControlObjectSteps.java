package com.naura.test;

import Ice.StringHolder;
import com.naura.test.api.api.LowerApi;
import com.naura.test.ice.IComControlObject.RemoteServiceResultHolder;
import com.naura.test.ui.MockLower;
import com.naura.test.ui.page.PVD.MainPage;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;
import static com.naura.test.RemoteValueInfoFactory.remoteIntValueInfo;
import static com.naura.test.RemoteValueInfoFactory.remoteStringValueInfo;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

public class ControlObjectSteps {
    @Autowired
    private LowerApi lowerApi;

    @Autowired
    private MockLower mockLower;

    @Autowired
    private ApplicationSteps applicationSteps;

    @假如("设备{string}为{string}状态")
    public void 设备为状态(String name, String status) {
        if (applicationSteps.getScenario().getSourceTagNames().contains("@pvd-ui-mock")) {
//            TODO hardcode /IO/Ch1Exports/State now, should transformed from name
            mockLower.mockRemoteValueInfo("/IO/Ch1Exports/State", remoteStringValueInfo("Offline"), this);

//            TODO hardcode /IO/Ch1Exports/Solenoid_V21DI now, should transformed from name
            mockLower.mockRemoteValueInfo("/IO/Ch1Exports/Solenoid_V21DI", remoteIntValueInfo(status.equals("Open") ? 1 : 0), this);
        } else {
            RemoteServiceResultHolder resultHolder = new RemoteServiceResultHolder();
            StringHolder errHolder = new StringHolder();
            lowerApi.remocteControlObject(name).runService(status, "", resultHolder, errHolder);
        }
    }

    @当("改变设备{string}为{string}")
    public void 改变设备为(String name, String status) {
        RemoteServiceResultHolder resultHolder = new RemoteServiceResultHolder();
        StringHolder errHolder = new StringHolder();
        lowerApi.remocteControlObject(name).runService(status, "", resultHolder, errHolder);
    }

    @那么("IO状态为:")
    public void io状态为(String verification) {
        expect(lowerApi).should(verification);
    }

    @Autowired
    private MainPage mainPage;

    @当("打开工艺腔室{string}阀门")
    public void 打开工艺腔室v阀门(String valveName) {
        mainPage.maintenancePage().maintChamberPage().openValve(valveName);
    }

    @那么("工艺腔室{string}阀门被打开")
    public void 工艺腔室v阀门被打开(String valveName) {
        await().untilAsserted(() -> assertThat(mainPage.maintenancePage().maintChamberPage().valveState(valveName))
                .isEqualTo("Opened"));
    }

    @当("设置MFC{string}的{string}的流量为{string}")
    public void 设置流量为(String mfcName, String config, String value) {
        mainPage.maintenancePage().maintChamberPage().setMfcValue(mfcName, config, value);
    }

    @当("设置MFC{string}的流量为{string}")
    public void 设置流量为(String mfcName, String value) {
        mainPage.maintenancePage().maintChamberPage().setMfcValue(mfcName, value);
    }

    @那么("MFC{string}流量为{string}")
    public void mfc流量为(String mfcName, String value) {
        await().untilAsserted(() -> assertThat(mainPage.maintenancePage().maintChamberPage().getMfcValue(mfcName)).isEqualTo(value));
    }

    @那么("控制对象{string}接受到命令{string}")
    public void 控制对象接受到异步命令(String name, String command) {
        verify(mockLower.stubRemoteControlObject.get(name)).runService(eq(command), eq(""), any(), any(), any());
    }

    @当("关闭工艺腔室{string}阀门")
    public void 关闭工艺腔室阀门(String valveName) {
        mainPage.maintenancePage().maintChamberPage().closeValve(valveName);
    }

    @那么("工艺腔室{string}阀门被关闭")
    public void 工艺腔室阀门被关闭(String valveName) {
        await().untilAsserted(() -> assertThat(mainPage.maintenancePage().maintChamberPage().valveState(valveName))
                .isEqualTo("Closed"));
    }

    @并且("{string}的AI流量为{string}")
    public void 的ai流量为(String mfcName, String value) {
        await().untilAsserted(() -> assertThat(mainPage.maintenancePage().maintChamberPage().getMfcValue(mfcName)).isEqualTo(value));
    }

    @并且("{string}的AO流量为{string}")
    public void 的ao流量为(String mfcName, String value) {
        await().untilAsserted(() -> assertThat(mainPage.maintenancePage().maintChamberPage().getMfcAOValue(mfcName)).isEqualTo(value));
    }

    @当("设置MFC{string}为{string}")
    public void 设置mfc为(String mfcName, String config) {
        mainPage.maintenancePage().maintChamberPage().setMfcConfig(mfcName, config);
    }

    @当("设置IO{string}状态为{string}")
    public void 设置io状态为(String name, String value) {
        lowerApi.io().setValue(name, value);
    }
}
