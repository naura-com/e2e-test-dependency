package com.naura.test.ui.PVDSteps;

import com.naura.test.ui.page.PVD.MainPage;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

public class ManualMoveStep {
    @Autowired
    private MainPage mainPage;

    @Before(value = "@init-slot", order = 2100)
    public void initSlot() {
        mainPage.overViewPage().footprintPage().InitForMove();
        mainPage.overViewPage().initPage().setModuleSlot("ATR", "1", false);
        mainPage.overViewPage().initPage().setModuleSlot("Aligner", "1", false);
        mainPage.overViewPage().initPage().setModuleSlots("LA", false);
        mainPage.overViewPage().initPage().setModuleSlots("LB", false);
        mainPage.overViewPage().initPage().setModuleSlots("Buffer", false);
        mainPage.overViewPage().initPage().setModuleSlot("ChA", "1", false);
        mainPage.overViewPage().initPage().setModuleSlot("ChB", "1", false);
        mainPage.overViewPage().initPage().setModuleSlots("Transfer", false);
    }

    @当("起始端选择{string}模块")
    public void 起始端选择模块(String module) {
        mainPage.overViewPage().manualMovePage().selectStartModule(module);
    }

    @那么("可选槽位有")
    public void 可选槽位有(String verification) {
        expect(mainPage.overViewPage().manualMovePage().getSelectSlots()).should(verification);
    }

    @当("选择槽位{string}")
    public void 选择槽位(String slot) {
        mainPage.overViewPage().manualMovePage().selectSlot(slot);
    }

    @那么("起始模块显示为")
    public void 起始模块显示为(String verification) {
        expect(mainPage.overViewPage().manualMovePage().getStartModuleText()).should(verification);
    }

    @并且("起始位置显示为")
    public void 起始位置显示为(String verification) {
        expect(mainPage.overViewPage().manualMovePage().getStartPosText()).should(verification);
    }

    @当("目的端选择{string}模块")
    public void 目的端选择模块(String module) {
        mainPage.overViewPage().manualMovePage().selectEndModule(module);
    }

    @那么("目的模块显示为")
    public void 目的模块显示为(String verification) {
        expect(mainPage.overViewPage().manualMovePage().getDestModuleText()).should(verification);
    }

    @并且("目的位置显示为")
    public void 目的位置显示为(String verification) {
        expect(mainPage.overViewPage().manualMovePage().getDestPosText()).should(verification);
    }

    @假如("执行手动传输")
    public void 执行手动传输() {
        mainPage.overViewPage().manualMovePage().clickManualMove();
    }

    @当("手动传输选择从模块{string}的Slot{string}到模块{string}的slot{string}")
    public void 手动传输选择从模块的Slot到模块的slot(String srcModule, String srcSlot, String destModule, String destSlot) {
        mainPage.overViewPage().initPage().setModuleSlot(srcModule, srcSlot, true);
        mainPage.overViewPage().initPage().setModuleSlot(destModule, destSlot, false);
        mainPage.overViewPage().manualMovePage().selectStartModule(srcModule);
        mainPage.overViewPage().manualMovePage().selectSlot(srcSlot);
        mainPage.overViewPage().manualMovePage().selectEndModule(destModule);
        mainPage.overViewPage().manualMovePage().selectSlot(destSlot);
    }

    @当("手动传输选择从模块{string}到模块{string}")
    public void 手动传输选择从模块到模块(String srcModule, String destModule) {
        mainPage.overViewPage().initPage().setModuleSlot(srcModule, "1", true);
        mainPage.overViewPage().initPage().setModuleSlot(destModule, "1", false);
        mainPage.overViewPage().manualMovePage().selectStartModule(srcModule);
        mainPage.overViewPage().manualMovePage().selectEndModule(destModule);
    }

    @当("Buffer选择经过{string}")
    public void buffer选择经过(String module) {
        mainPage.overViewPage().manualMovePage().selectBuffer(module);
    }

    @并且("Transfer选择经过{string}")
    public void transfer选择经过(String module) {
        mainPage.overViewPage().manualMovePage().selectTransfer(module);
    }

    @那么("手动传输任务名称为")
    public void 手动传输任务名称为(String verification) {
        expect(mainPage.overViewPage().manualMovePage().getTaskName()).should(verification);
    }

    @并且("等待传输结束{string}")
    public void 等待传输结束(String timeout) {
        await().timeout(Duration.ofSeconds(Integer.parseInt(timeout))).untilAsserted(() -> assertThat(mainPage.overViewPage().manualMovePage().getTaskNum())
                .isEqualTo(0));
    }

    @假如("手动传输选择从模块{string}到模块{string}的Slot{string}")
    public void 手动传输选择从模块到模块的Slot(String srcModule, String destModule, String destSlot) {
        mainPage.overViewPage().initPage().setModuleSlot(srcModule, "1", true);
        mainPage.overViewPage().initPage().setModuleSlot(destModule, destSlot, false);
        mainPage.overViewPage().manualMovePage().selectStartModule(srcModule);
        mainPage.overViewPage().manualMovePage().selectEndModule(destModule);
        mainPage.overViewPage().manualMovePage().selectSlot(destSlot);
    }

    @那么("界面显示{string}的Slot{string}为")
    public void 界面显示的Slot为(String module, String slot, String verification) {
        expect(mainPage.overViewPage().manualMovePage().getSlotText(module, slot)).should(verification);
    }
}
