package com.naura.test.lower;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.lower.api.LowerApi;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.Assertions.assertThat;

public class InterlockSteps {
    @Autowired
    private LowerApi lowerApi;

    @假如("激活互锁:")
    public void activeInterLock(Table table) {
        try {
            lowerApi.interlockApi().test().activateInterlock((String) table.get(0).get("id"));
        } catch (LowerException e) {

        }
    }

    @假如("激活互锁{string}")
    public void activeInterLock(String lockName) {
        lowerApi.interlockApi().test().activateInterlock(lockName);
    }

    @假如("取消激活互锁:")
    public void 取消激活互锁(Table table) {
        lowerApi.interlockApi().test().deactivateInterlock((String) table.get(0).get("id"));
    }

    @那么("抛出报警:")
    public void 抛出报警(String verification) throws InterruptedException {
        Thread.sleep(1000);
        expect(lowerApi.alarmapi().test().getPostedAlarms()).should(verification);
    }

    @那么("不会抛出报警:")
    public void 不会抛出报警(String verification) {
        for (String Alarm : lowerApi.alarmapi().test().getPostedAlarms()) {
            if (Alarm.equals(verification))
                assertThat(true).isFalse();
        }
    }

    @并且("触发锁{string}")
    public void trigger(String lockName) {
        switch (lockName) {
            case "/Control/Ch1/SInterlocks/ChangeToShuttered":
                lowerApi.io().setValue("/IO/Ch1Exports/DiskInGarage", "Present");
                break;
            case "/Control/Ch3/VInterlocks/PlcSafeFBError/Alarm":
                lowerApi.io().setValue("/IO/Ch3/Plc/FBErrorDI","Error");
                break;
            case "/Control/OverrunInterlocks/TMAbnormal":
                lowerApi.io().setValue("/IO/SlaveNode/LID_CLSD_ISO_TC","Not_Closed");
                break;
            case "/Control/OverrunInterlocks/Scrubber1Failed":
                lowerApi.io().setValue("/IO/SlaveNode/SCRUBBER1_STATUS","0");
        }
    }

    @假如("激活并触发互锁{string}")
    public void 激活并触发互锁(String lockName) {
        activeInterLock(lockName);
        trigger(lockName);
    }

    @当("消除互锁{string}的触发条件")
    public void WontTrigger(String lockName) {
        switch (lockName) {
            case "/Control/Ch3/VInterlocks/PlcSafeFBError/Alarm":
                lowerApi.io().setValue("/IO/Ch3/Plc/FBErrorDI","Normal");
                break;
            case "/Control/OverrunInterlocks/TMAbnormal":
                lowerApi.io().setValue("/IO/SlaveNode/LID_CLSD_ISO_TC","Closed");
                break;
            case "/Control/OverrunInterlocks/Scrubber1Failed":
                lowerApi.io().setValue("/IO/SlaveNode/SCRUBBER1_STATUS","1");
        }
    }
}
