package com.naura.test.ui.Etch1Steps;

import Ice.StringHolder;
import com.naura.test.ice.IComControlObject.RemoteServiceResultHolder;
import com.naura.test.api.api.LowerApi;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class TMVacuumSteps {
    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;

    @Autowired
    private LowerApi lowerApi;

    @假如("TM设备{string}状态为{string}")
    public void tm设备状态为(String name, String status) {
        RemoteServiceResultHolder resultHolder = new RemoteServiceResultHolder();
        StringHolder errHolder = new StringHolder();
        lowerApi.remocteControlObject("/Control/TMCExports/Controls/" + name).runService(status, "", resultHolder, errHolder);
    }

    @当("设置TM阀门{string}为{string}")
    public void 设置tm阀门为(String valveName, String valveState) {
        mainPage.maintainPage().tmVacuumPage().setValve(valveName, valveState);
    }

    @假如("TM的{string}处于Maintain模式")
    public void tm的处于Maintain模式(String module) {
        mainPage.maintainPage().tmVacuumPage().setMaintain(module);
        mainPage.verifyClickActionQuestion("Yes");
    }

    @假如("TM处于Maintain模式")
    public void tm处于maintain模式() {
        tm的处于Maintain模式("TC");
        tm的处于Maintain模式("LA");
        tm的处于Maintain模式("LB");
    }

    @当("设置TM的DryPump为{string}")
    public void 设置tm的drypump为(String pumpState) {
        mainPage.maintainPage().tmVacuumPage().setDryPump(pumpState);
    }

    @当("{string}执行{string}")
    public void 执行(String module, String service) {
        mainPage.maintainPage().tmVacuumPage().runOperation(module, service);
    }

    @那么("TM阀门{string}在服务窗口和界面显示为{string}")
    public void tm阀门在服务窗口和界面显示为(String valveName, String valveState) {
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().tmVacuumPage().serviceValveState())
                .isEqualTo(valveState));
        mainPage.maintainPage().tmVacuumPage().serviceOperation("Cancel");
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().tmVacuumPage().controlState(valveName))
                .isEqualTo(valveState));
    }

    @那么("TM的DryPump在服务窗口和界面显示为{string}")
    public void tm的drypump在服务窗口和界面显示为(String pumpState) {
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().tmVacuumPage().serviceDryPumpState())
                .isEqualTo("DryPump" + pumpState));
        mainPage.maintainPage().tmVacuumPage().serviceOperation("Cancel");
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().tmVacuumPage().controlState("DryPump"))
                .isEqualTo("DryPump" + pumpState));
    }

    @那么("TM阀门{string}显示为{string}")
    public void tm阀门显示为(String valveName, String valveState) {
        await().untilAsserted(() -> assertThat(mainPage.maintainPage().tmVacuumPage().controlState(valveName))
                .isEqualTo(valveState));
    }
}
