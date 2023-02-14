package com.naura.test.api;

import com.naura.test.api.api.LowerApi;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.Assertions.assertThat;

public class IOSteps {
    @Autowired
    private LowerApi lowerApi;

    @假如("通道{string}的值为{string}")
    public void 的值为(String name, String value) {
        lowerApi.io().setValue(name, value);
    }

    @并且("通道{string}的值为:")
    public void 通道的值为(String name, String verification) {
        expect(lowerApi.io().getValue(name)).should(verification);
    }

    @假如("远程Data对象{string}为空")
    public void 远程_data对象_not_exist_为空(String name) {
        assertThat(lowerApi.io().getData(name)).isNull();
    }

}
