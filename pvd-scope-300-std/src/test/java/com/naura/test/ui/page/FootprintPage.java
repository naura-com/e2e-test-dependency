package com.naura.test.ui.page;

import Ice.StringHolder;
import com.naura.test.ice.IComControlObject.RemoteServiceResultHolder;
import com.naura.test.config.ContextWrapper;
import com.naura.test.api.api.LowerApi;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class FootprintPage {
    private final WinForm winForm;

    private final Window.WindowOperation page;

    @Autowired
    private LowerApi lowerApi;

    public FootprintPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
        lowerApi = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
    }

    public void Load() {
        Load("LP1");
        Load("LP2");
        Load("LP3");
    }

    public void Load(String LoadPort) {
        lowerApi.io().setValue("/IO/" + LoadPort + "Exports/CarrierPlacedDI", "Placed");
        page.elementById("mLoad" + LoadPort + "_Lpbtn").click();
        winForm.elementByName("确定").click();
        await().untilAsserted(() -> assertThat(winForm.elementById("mToolState_lb").getText()).isEqualTo("Idle"));
    }

    public void Init() {
        Init("/Control/LP1");
        Init("/Control/LP2");
        Init("/Control/LP3");
        Init("/Control/ATR");
        Init("/Control/AlignerExports/Aligner");
        Init("/Control/LA");
        Init("/Control/LB");
        Init("/Control/ChE");
        Init("/Control/ChC");
        Init("/Control/Buffer");
        Init("/Control/ChA");
        Init("/Control/ChB");
        Init("/Control/Transfer");
        Init("/Control/Ch2");
        Init("/Control/Ch3");
    }

    public void InitForMove() {
        Init("/Control/LA");
        Init("/Control/LB");
        Init("/Control/ChA");
        Init("/Control/ChB");
        Init("/Control/Ch2");
        Init("/Control/Ch3");
        Init("/Control/ChC");
//        Init("/Control/ChE");
    }

    public void Init(String module) {
        RemoteServiceResultHolder resultHolder = new RemoteServiceResultHolder();
        StringHolder errHolder = new StringHolder();
        lowerApi.remocteControlObject(module).runService("Init", "", resultHolder, errHolder);
    }

}
