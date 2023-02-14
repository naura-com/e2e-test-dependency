package com.naura.test.api;

import com.naura.test.api.api.LowerApi;
import io.cucumber.java.zh_cn.并且;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Arrays.asList;
import static org.awaitility.Awaitility.await;

public class AlarmSteps {
    @Autowired
    LowerApi lowerApi;

    @并且("产生了报警{string}")
    public void 产生了报警(String name) {
        await().until(() -> asList(lowerApi.alarmapi().getAllPostedAlarms()).contains(name));
    }

    @并且("清除报警")
    public void 清除报警() {
        lowerApi.alarmapi().test().cleanAlarm();
    }
}
