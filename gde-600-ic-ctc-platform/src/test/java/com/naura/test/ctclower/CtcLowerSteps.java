package com.naura.test.ctclower;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ctclower.api.CtcLowerApi;
import com.naura.test.api.LowerConnection;
import com.naura.test.api.LowerException;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.Assertions.assertThat;

public class CtcLowerSteps {
    @Autowired
    private CtcLowerApi ctcLowerApi;
    private Object result;
    private LowerException lowerException;

    @Autowired
    private LowerConnection pvd;

    @Autowired
    private LowerConnection etch1Pm2;

    @Autowired
    private LowerConnection etch1ref;

    @Before(value = "@ETCH-PM2-lower", order = 1000)
    public void connectEtch1Pm2() {
        ctcLowerApi.close();
        ctcLowerApi.connect(etch1Pm2);
    }

    @Before(value = "@etch1ref-lower", order = 1000)
    public void connectetch1ref() {
        ctcLowerApi.close();
        ctcLowerApi.connect(etch1ref);
    }

    @那么("一刻返回如下:")
    public void 返回如下(String verification) {
        shouldPass();
        expect(result).should(verification);
    }

    @那么("一刻{string}的值为{string}")
    public void 的值为(String channel, String value) {
        callApi("IO", "getValue", Table.create(new HashMap<>() {{
            put("name", channel);
        }}));
        shouldPass();
        expect(result).should(String.format("value:%s", value));
    }

    @SneakyThrows
    @当("一刻调用{string}的{string}接口时")
    public void callApi(String module, String api) {
        lowerException = null;
        try {
            switch (module) {
                case "recipe":
                    result = ctcLowerApi.recipe().invoke(api);
                    break;
                case "setup":
                    result = ctcLowerApi.setUp().invoke(api);
                    break;
                case "alarm":
                    result = ctcLowerApi.alarmapi().invoke(api);
                    break;
                case "interlock":
                    result = ctcLowerApi.interlockApi().invoke(api);
                    break;
                default:
                    throw new IllegalStateException("unknown module: " + module);
            }
        } catch (LowerException e) {
            lowerException = e;
        }
    }

    @当("一刻调用{string}的{string}接口时:")
    public void callApi(String module, String api, Table table) {
        lowerException = null;
        try {
            switch (module) {
                case "recipe":
                    result = ctcLowerApi.recipe().invoke(api, table);
                    break;
                case "setup":
                    result = ctcLowerApi.setUp().invoke(api, table);
                    break;
                case "IO":
                    result = ctcLowerApi.io().invoke(api, table);
                    break;
                case "interlock":
                    result = ctcLowerApi.interlockApi().invoke(api, table);
                    break;
                case "alarm":
                    result = ctcLowerApi.alarmapi().invoke(api, table);
                    break;
                default:
                    throw new IllegalStateException("unknown module: " + module);
            }
        } catch (LowerException e) {
            lowerException = e;
        }
    }

    @那么("一刻调用失败, 错误为:")
    public void 调用失败错误为(String verification) {
        expect(lowerException).should(verification);
    }

    @那么("一刻调用成功")
    public void shouldPass() {
        assertThat(lowerException).isNull();
    }

    @并且("一刻下位机文件应为:")
    public void 下位机文件应为(String verification) {
        expect(ctcLowerApi.remoteFolder()).should(verification);
    }

    @那么("一刻调用失败")
    public void 调用失败() {
        assertThat(lowerException).isNotNull();
    }

    @那么("一刻Alarm已被恢复")
    public void alarm已被恢复() {
        expect(ctcLowerApi.alarmapi().invoke("getAllPostedAlarms")).should(null);
    }

}