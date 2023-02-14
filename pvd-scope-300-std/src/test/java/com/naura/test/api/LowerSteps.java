package com.naura.test.api;

import com.github.leeonky.jfactory.JFactory;
import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ice.IComInterlock.RemoteInterlockInfo;
import com.naura.test.api.api.LowerApi;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.Assertions.assertThat;

public class LowerSteps {
    @Autowired
    private LowerApi lowerApi;
    private Object result;
    private LowerException lowerException;

    @Autowired
    private LowerConnection pvd;

    @Autowired
    private LowerConnection etch1Pm2;

    @Autowired
    private LowerConnection etch1ref;

    @Before(value = "@deactivate-interlock", order = 1100)
    public void cleanInterlock() {
        lowerApi.deactivateAllInterlock();
    }

    @Before(value = "@clean-alarm", order = 1200)
    public void cleanAlarm() {
        lowerApi.cleanAlarm();
    }

    @Before(value = "@deactivate-allInterlock", order = 1300)
    public void deactivateAllInterlock() {
        for (RemoteInterlockInfo allInterlockInfo : lowerApi.interlockApi().getAllInterlockInfos()) {
            lowerApi.interlockApi().deactivate(allInterlockInfo.id);
        }
    }

    @Before(value = "@pvd-lower", order = 1000)
    public void connectPvd() {
        lowerApi.close();
        lowerApi.connect(pvd);
    }

    @Before(value = "@ETCH-PM2-lower", order = 1000)
    public void connectEtch1Pm2() {
        lowerApi.close();
        lowerApi.connect(etch1Pm2);
    }

    @Before(value = "@etch1ref-lower", order = 1000)
    public void connectetch1ref() {
        lowerApi.close();
        lowerApi.connect(etch1ref);
    }

    @After("@pvd-lower")
    public void disconnect() {
        lowerApi.close();
    }

    @Autowired
    private JFactory jFactory;

    @Before
    public void cleanJFactory() {
        jFactory.getDataRepository().clear();
    }

    @那么("返回如下:")
    public void 返回如下(String verification) {
        shouldPass();
        expect(result).should(verification);
    }

    @SneakyThrows
    @当("调用{string}的{string}接口时")
    public void callApi(String module, String api) {
        lowerException = null;
        try {
            switch (module) {
                case "recipe":
                    result = lowerApi.recipe().invoke(api);
                    break;
                case "setup":
                    result = lowerApi.setUp().invoke(api);
                    break;
                case "alarm":
                    result = lowerApi.alarmapi().invoke(api);
                    break;
                case "interlock":
                    result = lowerApi.interlockApi().invoke(api);
                    break;
                default:
                    throw new IllegalStateException("unknown module: " + module);
            }
        } catch (LowerException e) {
            lowerException = e;
        }
    }

    @当("调用{string}的{string}接口时:")
    public void callApi(String module, String api, Table table) {
        lowerException = null;
        try {
            switch (module) {
                case "recipe":
                    result = lowerApi.recipe().invoke(api, table);
                    break;
                case "setup":
                    result = lowerApi.setUp().invoke(api, table);
                    break;
                case "IO":
                    result = lowerApi.io().invoke(api, table);
                    break;
                case "interlock":
                    result = lowerApi.interlockApi().invoke(api, table);
                    break;
                case "alarm":
                    result = lowerApi.alarmapi().invoke(api, table);
                    break;
                default:
                    throw new IllegalStateException("unknown module: " + module);
            }
        } catch (LowerException e) {
            lowerException = e;
        }
    }

    @当("成功调用{string}的{string}接口时:")
    public void successCallApi(String module, String api, Table table) {
        lowerException = null;
        try {
            switch (module) {
                case "recipe":
                    result = lowerApi.recipe().invoke(api, table);
                    break;
                case "setup":
                    result = lowerApi.setUp().invoke(api, table);
                    break;
                case "IO":
                    result = lowerApi.io().invoke(api, table);
                    break;
                case "interlock":
                    result = lowerApi.interlockApi().invoke(api, table);
                    break;
                case "alarm":
                    result = lowerApi.alarmapi().invoke(api, table);
                    break;
                default:
                    throw new IllegalStateException("unknown module: " + module);
            }
        } catch (LowerException e) {
            lowerException = e;
        } finally {
            assertThat(lowerException).isNull();
        }
    }

    @那么("调用失败, 错误为:")
    public void 调用失败错误为(String verification) {
        expect(lowerException).should(verification);
    }

    @那么("调用成功")
    public void shouldPass() {
        assertThat(lowerException).isNull();
    }

    @并且("下位机文件应为:")
    public void 下位机文件应为(String verification) {
        expect(lowerApi.remoteFolder()).should(verification);
    }

    @那么("调用失败")
    public void 调用失败() {
        assertThat(lowerException).isNotNull();
    }

    @那么("Alarm已被恢复")
    public void alarm已被恢复() {
        expect(lowerApi.alarmapi().invoke("getAllPostedAlarms")).should(null);
    }

    @当("设置配置参数如下时:")
    public void 设置配置参数如下时(Table table) {
        callApi("setup", "setSetupValue", table);
    }

    @当("设置参数如下时:")
    public void 设置参数如下时(Table table) {
        callApi("IO", "setValue", table);
    }

    @那么("{string}的值为{string}")
    public void 的值为(String channel, String value) {
        callApi("IO", "getValue", Table.create(new HashMap<>() {{
            put("name", channel);
        }}));
        shouldPass();
        expect(result).should(String.format("value:%s", value));
    }

    @那么("{string}索引{string}的参数为:")
    public void 索引的参数为(String setup, String index, String verification) {
        callApi("setup", "getSetupOptionValues", Table.create(new HashMap<>() {{
            put("name", setup);
            put("index", index);
        }}));
        shouldPass();
        expect(result).should(verification);
    }
}