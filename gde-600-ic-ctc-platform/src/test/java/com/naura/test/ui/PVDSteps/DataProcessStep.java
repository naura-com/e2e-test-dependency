package com.naura.test.ui.PVDSteps;

import com.naura.test.config.DataBase;
import com.naura.test.ui.page.PVD.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

import static com.github.leeonky.dal.Assertions.expect;

public class DataProcessStep {
    @Autowired
    private MainPage mainPage;

    @Autowired
    private DataBase dataBase;

    @Before(value = "@create-table-chc", order = 1100)
    public void createChc() {
        dataBase.executeDB(entityManager -> {
            entityManager.createNativeQuery("DROP TABLE IF EXISTS `chc`").executeUpdate();
            entityManager.createNativeQuery("CREATE TABLE `chc` (" +
                    "  `num` bigint(20) unsigned NOT NULL AUTO_INCREMENT," +
                    "  `trigger_` text," +
                    "  `trigger_time` datetime DEFAULT NULL," +
                    "  `trigger_time_ms` smallint(6) DEFAULT NULL," +
                    "  `collect_time` datetime DEFAULT NULL," +
                    "  `collect_time_ms` smallint(6) DEFAULT NULL," +
                    "  `LotID` text," +
                    "  `MaterialName` text," +
                    "  `RecipeName` text," +
                    "  `RcpTotalStep` int(11) DEFAULT NULL," +
                    "  `RcpStepCounter` int(11) DEFAULT NULL," +
                    "  `RcpStepName` text," +
                    "  `RcpStepTime` double DEFAULT NULL," +
                    "  `RcpStepElapsedTime` double DEFAULT NULL," +
                    "  `RcpStepStartTime` text," +
                    "  `InnerPowerMin` double DEFAULT NULL," +
                    "  `InnerPowerMax` double DEFAULT NULL," +
                    "  `InnerPowerAvg` double DEFAULT NULL," +
                    "  `InnerPowerStd` double DEFAULT NULL," +
                    "  `InnerPower` text," +
                    "  `InnerPowerTimes` text," +
                    "  `InnerPowerTSN` int(11) DEFAULT NULL," +
                    "  `InnerPowerBSN` int(11) DEFAULT NULL," +
                    "  `InnerCurrentMin` double DEFAULT NULL," +
                    "  `InnerCurrentMax` double DEFAULT NULL," +
                    "  `InnerCurrentAvg` double DEFAULT NULL," +
                    "  `InnerCurrentStd` double DEFAULT NULL," +
                    "  `InnerCurrent` text," +
                    "  `InnerCurrentTimes` text," +
                    "  `InnerCurrentTSN` int(11) DEFAULT NULL," +
                    "  `InnerCurrentBSN` int(11) DEFAULT NULL," +
                    "  `OuterPowerMin` double DEFAULT NULL," +
                    "  `OuterPowerMax` double DEFAULT NULL," +
                    "  `OuterPowerAvg` double DEFAULT NULL," +
                    "  `OuterPowerStd` double DEFAULT NULL," +
                    "  `OuterPower` text," +
                    "  `OuterPowerTimes` text," +
                    "  `OuterPowerTSN` int(11) DEFAULT NULL," +
                    "  `OuterPowerBSN` int(11) DEFAULT NULL," +
                    "  `OuterCurrentMin` double DEFAULT NULL," +
                    "  `OuterCurrentMax` double DEFAULT NULL," +
                    "  `OuterCurrentAvg` double DEFAULT NULL," +
                    "  `OuterCurrentStd` double DEFAULT NULL," +
                    "  `OuterCurrent` text," +
                    "  `OuterCurrentTimes` text," +
                    "  `OuterCurrentTSN` int(11) DEFAULT NULL," +
                    "  `OuterCurrentBSN` int(11) DEFAULT NULL," +
                    "  `HeaterTempMin` double DEFAULT NULL," +
                    "  `HeaterTempMax` double DEFAULT NULL," +
                    "  `HeaterTempAvg` double DEFAULT NULL," +
                    "  `HeaterTempStd` double DEFAULT NULL," +
                    "  `HeaterTemp` text," +
                    "  `HeaterTempTimes` text," +
                    "  `HeaterTempTSN` int(11) DEFAULT NULL," +
                    "  `HeaterTempBSN` int(11) DEFAULT NULL," +
                    "  `HeaterPowerMin` double DEFAULT NULL," +
                    "  `HeaterPowerMax` double DEFAULT NULL," +
                    "  `HeaterPowerAvg` double DEFAULT NULL," +
                    "  `HeaterPowerStd` double DEFAULT NULL," +
                    "  `HeaterPower` text," +
                    "  `HeaterPowerTimes` text," +
                    "  `HeaterPowerTSN` int(11) DEFAULT NULL," +
                    "  `HeaterPowerBSN` int(11) DEFAULT NULL," +
                    "  `CGMin` double DEFAULT NULL," +
                    "  `CGMax` double DEFAULT NULL," +
                    "  `CGAvg` double DEFAULT NULL," +
                    "  `CGStd` double DEFAULT NULL," +
                    "  `CG` text," +
                    "  `CGTimes` text," +
                    "  `CGTSN` int(11) DEFAULT NULL," +
                    "  `CGBSN` int(11) DEFAULT NULL," +
                    "  `PressureMin` double DEFAULT NULL," +
                    "  `PressureMax` double DEFAULT NULL," +
                    "  `PressureAvg` double DEFAULT NULL," +
                    "  `PressureStd` double DEFAULT NULL," +
                    "  `Pressure` text," +
                    "  `PressureTimes` text," +
                    "  `PressureTSN` int(11) DEFAULT NULL," +
                    "  `PressureBSN` int(11) DEFAULT NULL," +
                    "  `StepLogSegmentID` int(11) DEFAULT NULL," +
                    "  PRIMARY KEY (`num`)" +
                    ") ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;").executeUpdate();
        });
    }

    @当("切换{string}查询")
    public void 切换查询(String selection) {
        mainPage.dataPage().dataProcessPage().switchSelection(selection);
    }

    @假如("现在是{string}查询")
    public void 现在是查询(String selection) {
        mainPage.dataPage().dataProcessPage().sureSelect(selection);
    }

    @当("查询{string}至{string}时间段内{string}的工艺数据时")
    public void 查询至时间段内的工艺数据时(String startTime, String endTime, String selection) {
        mainPage.dataPage().dataProcessPage().sureSelect(selection);
        mainPage.dataPage().dataProcessPage().executeDataProc(startTime, endTime);
    }

    @那么("批次列表显示为")
    public void 批次列表显示为(String verification) {
        expect(mainPage.dataPage().dataProcessPage().getLotList()).should(verification);
    }

    @并且("批次总数显示为")
    public void 批次总数显示为(String verification) {
        expect(mainPage.dataPage().dataProcessPage().getTotal()).should(verification);
    }

    @并且("批次信息表显示为")
    public void 批次信息表显示为(String verification) {
        expect(mainPage.dataPage().dataProcessPage().getLotListInfo()).should(verification);
    }

    @并且("选择批次{string}时")
    public void 选择批次时(String lotId) {
        mainPage.dataPage().dataProcessPage().selectLot(lotId);
    }

    @那么("批次信息显示为")
    public void 批次信息显示为(String verification) {
        expect(mainPage.dataPage().dataProcessPage().getLotInfo()).should(verification);
    }

    @那么("批次{string}显示的物料有")
    public void 批次显示的物料有(String lotId, String verification) {
        expect(mainPage.dataPage().dataProcessPage().getLotWafers(lotId)).should(verification);
    }

    @那么("物料信息标题显示为")
    public void 物料信息标题显示为(String verification) {
        expect(mainPage.dataPage().dataProcessPage().getMaterialTitle()).should(verification);
    }

    @并且("选择批次{string}的物料{string}时")
    public void 选择批次的物料时(String lotId, String materialName) {
        mainPage.dataPage().dataProcessPage().selectMaterial(lotId, materialName);
    }

    @那么("物料的HistoryList显示为")
    public void 物料的historylist显示为(String verification) {
        mainPage.dataPage().dataProcessPage().switchMtInfo("History List");
        expect(mainPage.dataPage().dataProcessPage().getMtHistoryList()).should(verification);
    }

    @那么("物料的ProcessList显示为")
    public void 物料的processlist显示为(String verification) {
        mainPage.dataPage().dataProcessPage().switchMtInfo("ProcessList");
        expect(mainPage.dataPage().dataProcessPage().getMtProcList()).should(verification);
    }

    @那么("物料工艺信息标题显示为")
    public void 物料工艺信息标题显示为(String verification) {
        expect(mainPage.dataPage().dataProcessPage().getRcpTitle()).should(verification);
    }

    @并且("物料工艺步骤列表显示为")
    public void 物料工艺步骤列表显示为(String verification) {
        expect(mainPage.dataPage().dataProcessPage().getRcpSteps()).should(verification);
    }

    @并且("物料步骤信息显示为")
    public void 物料步骤信息显示为(String verification) {
        expect(mainPage.dataPage().dataProcessPage().getRcpStepInfo()).should(verification);
    }

    @并且("选择批次{string}的物料{string}的第{int}个Process时")
    public void 选择批次的物料的第个Process时(String lotId, String materialName, int processIndex) {
        mainPage.dataPage().dataProcessPage().selectMaterial(lotId, materialName);
        mainPage.dataPage().dataProcessPage().selectProcess(processIndex);
    }

    @当("选择工艺的步骤{string}时")
    public void 选择工艺的步骤时(String stepIndex) {
        mainPage.dataPage().dataProcessPage().selectRcpStep(stepIndex);
    }

    @当("选择以下工艺参数")
    public void 选择以下工艺参数(DataTable table) {
        mainPage.dataPage().dataProcessPage().selectRcpParam(table.asList());
    }

    @那么("腔室{string}显示的物料有")
    public void 腔室显示的物料有(String module, String verification) {
        expect(mainPage.dataPage().dataProcessPage().getModuleWafers(module)).should(verification);
    }

    @那么("物料信息显示为")
    public void 物料信息显示为(String verification) {
        expect(mainPage.dataPage().dataProcessPage().getWaferInfo()).should(verification);

    }

    @当("对比腔室{string}以下物料的参数{string}时")
    public void 对比腔室以下物料的参数时(String module, String param, DataTable table) {
        mainPage.dataPage().dataProcessPage().selectMaterials(module, table.asList());
        mainPage.dataPage().dataProcessPage().selectProcess(1);
        mainPage.dataPage().dataProcessPage().selectRcpParam(Arrays.asList(param));
        mainPage.clickAction("对比");
    }

    @那么("抛出提示")
    public void 抛出提示(String verification) {
        expect(mainPage.getMessageAndDo("确定")).should(verification);
    }
}
