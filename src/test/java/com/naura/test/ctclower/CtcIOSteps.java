package com.naura.test.ctclower;

import com.naura.test.ctclower.api.CtcLowerApi;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.Assertions.assertThat;

public class CtcIOSteps {
    @Autowired
    private CtcLowerApi ctcLowerApi;

    @假如("一刻通道{string}的值为{string}")
    public void 的值为(String name, String value) {
        ctcLowerApi.io().setValue(name, value);
    }

    @并且("一刻通道{string}的值为:")
    public void 通道的值为(String name, String verification) {
        expect(ctcLowerApi.io().getValue(name)).should(verification);
    }

    @假如("一刻远程Data对象{string}为空")
    public void 远程_data对象_not_exist_为空(String name) {
        assertThat(ctcLowerApi.io().getData(name)).isNull();
    }

}
