package com.naura.test.ui.Etch1Steps;

import com.naura.test.ui.TestState;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.page.Etch1.Etch1MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RecipeSteps {
    @Autowired
    private Etch1MainPage mainPage;

    @Autowired
    private WinForm winForm;

    @Autowired
    private TestState testState;

    @Value("${filedir.local}")
    private String localDir;

    @Value("${filedir.virtual}")
    private String virtualDir;

    @假如("创建{string}的{string}的配方{string}")
    public void 创建的配方(String PM, String rcpClass, String rcpName) {
        mainPage.editPage().recipePage().createDefaultRecipe(PM, rcpClass, rcpName);
    }

    @那么("查询到配方{string}的创建时间为:")
    public void 查询到配方的创建时间为(String rcpName, String verification) {
        expect(mainPage.editPage().recipePage().getRcpCreateTime()).should(verification);
    }

    @当("移动步骤{string}到步骤{string}之{string}")
    public void 移动步骤到步骤之(String firstStep, String secondStep, String position) {
        mainPage.editPage().recipePage().moveStep(firstStep, secondStep, position);
    }

    @那么("{string}参数返回如下:")
    public void 参数返回如下(String colName, String parameter, String verification) {
        expect(mainPage.editPage().recipePage().getParameterValue(colName, parameter)).should(verification);
    }

//    @并且("密码为{string}的用户{string}重新启动上位机")
//    public void 密码为的用户重新启动上位机(String userName, String passWord) {
//        testState.restart(userName, passWord, () -> winForm.close());
//    }

    @假如("在{string}的{string}存在配方{string}:")
    public void 在的存在配方(String PM, String rcpClass, String rcpName, DataTable table) {
        mainPage.editPage().recipePage().createStepRcp(PM, rcpClass, rcpName, table);
    }

    @那么("复制Recipe步骤的第一步返回如下:")
    public void 复制recipe步骤的第一步返回如下(String verification) {
        expect(mainPage.editPage().recipePage().getCopyFirstStepCol()).should(verification);
    }

    @当("复制Recipe步骤的步骤{string}到步骤{string}时")
    public void 复制recipe步骤的步骤到步骤时(String copyStep, String copyToStep) {
        mainPage.editPage().recipePage().copyStep(copyStep, copyToStep);
    }

    @那么("步骤{string}和步骤{string}内容一致")
    public void 步骤和步骤内容一致(String copyStep, String copyToStep) {
        mainPage.editPage().recipePage().verifyStep(Integer.parseInt(copyStep), Integer.parseInt(copyToStep));
    }

    @当("未选中步骤执行步骤{string}操作")
    public void 未选中步骤执行步骤操作(String stepAction) {
        mainPage.editPage().recipePage().actionStep("", stepAction);
    }

    @那么("执行失败,异常信息为:")
    public void 执行失败异常信息为(String verifyInfo) {
        expect(mainPage.verifyClickAction("OK")).should(verifyInfo);
    }

    @当("删除步骤{string}并二次确定")
    public void 删除步骤并二次确定(String stepIndex) {
        mainPage.editPage().recipePage().actionStep(stepIndex, "Delete Step");//Do you want to delete the step ?
        expect(mainPage.editPage().recipePage().verifyInformation("是(Y)")).should("'Do you want to delete the step ?'");
    }

    @那么("步骤列名返回如下")
    public void 步骤列名返回如下(String verification) {
        expect(mainPage.editPage().recipePage().getHeaderName()).should(verification);
    }

    @当("删除步骤{string}时:")
    public void 删除步骤时(String stepIndex) {
        mainPage.editPage().recipePage().actionStep(stepIndex, "Delete Step");
    }

    @那么("执行成功,提示信息为:")
    public void 执行成功提示信息为(String verifyInfo) {
        expect(mainPage.editPage().recipePage().verifyInformation("是(Y)")).should(verifyInfo);
    }

    @当("新建步骤{string}时")
    public void 新建步骤时(String stepName) {
        mainPage.editPage().recipePage().createSingleStep(stepName);
    }

    @那么("{string}的StepName参数如下:")
    public void StepName参数如下(String colName, String verification) {
        expect(mainPage.editPage().recipePage().getParameterValue(colName, "StepName")).should(verification);
    }

    @那么("查看{string}的{string}的配方列表如下:")
    public void 查看的配方列表如下(String PM, String rcpClass, String verification) {
        mainPage.editPage().recipePage().selectClass(PM, rcpClass, false);
        expect(mainPage.editPage().recipePage().getRcpList()).should(verification);
    }

    @当("切换RecipeType为{string}")
    public void 切换recipetype为(String rcpType) {
        mainPage.editPage().recipePage().selectRcpType(rcpType, false);
    }

    @假如("密码为{string}的用户{string}重新登录")
    public void 密码为的用户重新登录(String password, String user) {
        try {
            mainPage.logout();
        } catch (Exception e) {
        }
        mainPage.login(user, password);
    }

    @那么("能查询到配方创建者为{string}")
    public void 能查询到配方创建者为(String txtAuthor) {
        assertThat(mainPage.editPage().recipePage().getAuthor()).isEqualTo(txtAuthor);
    }

    @假如("在{string}的{string}存在已保存配方{string}:")
    public void 在的存在已保存配方(String pmName, String rcpClass, String rcpName, DataTable table) {
        mainPage.editPage().recipePage().hasSavedRcp(pmName, rcpClass, rcpName, table);
    }

    @假如("存在已保存配方:")
    public void 存在已保存配方(DataTable table) {
        mainPage.editPage().recipePage().createRecipeAndSave(table);
    }

    @当("切换Recipe为{string}")
    public void 切换recipe为(String rcpName) {
        mainPage.editPage().recipePage().selectRcp(rcpName);
    }

    @那么("配方{string}创建成功")
    public void 配方创建成功(String rcp) {
        assertThat(mainPage.editPage().recipePage().getRcpList().contains(rcp)).isTrue();
    }

    @并且("配方{string}参数如下:")
    public void 配方参数如下(String rcp, String verification) {
        mainPage.editPage().recipePage().selectRcp(rcp);
        expect(mainPage.editPage().recipePage().getParamInfo()).should(verification);
    }

    @并且("修改{string}的步骤{int}的{string}为{string}")
    public void 修改的步骤的为(String rcp, int step, String parameter, String value) {
        mainPage.editPage().recipePage().modifyPar(rcp, step, parameter, value);
    }

    @并且("执行Recipe的{string}操作")
    public void 执行recipe的操作(String operation) {
        mainPage.editPage().recipePage().executeOperation(operation);
    }

    @那么("保存配方成功,提示:")
    public void 保存配方成功提示(String verificatino) {
        expect(mainPage.editPage().recipePage().getmessage()).should(verificatino);
        //TODO:之前是Yes
        mainPage.editPage().recipePage().clickOkOrCancel("OK");
    }

    @假如("存在未保存配方:")
    public void 存在未保存配方(DataTable table) {
        mainPage.editPage().recipePage().createRecipeAndNotSave(table);
    }

    @那么("执行失败,异常信息为")
    public void 执行失败异常信息为2(String verifyInfo) {
        expect(mainPage.verifyClickActionQuestion("Yes")).should(verifyInfo);
    }

    @并且("切换RecipeType为{string}不保存")
    public void 切换recipetype为不保存(String rcpClass) {
        mainPage.editPage().recipePage().selectRcpType(rcpClass, false);
        expect(mainPage.verifyClickActionQuestion("No")).should("'rcpNot-saved is not saved.Do you want to save first?'");
    }

    @并且("切换Recipe为{string}不保存")
    public void 切换recipe为不保存(String rcpName) {
        mainPage.editPage().recipePage().selectRcp(rcpName);
        expect(mainPage.verifyClickActionQuestion("No")).should("'rcpNot-saved is not saved.Do you want to save first?'");

    }

    @当("修改{string}的步骤{int}的{string}为{string}:")
    public void 修改的未保存步骤的为(String rcp, int step, String parameter, String value) {
        mainPage.editPage().recipePage().modifyStepName(step, parameter, value, "double");
    }

    //TODO:不确定是不是没有用
//    @并且("执行Recipe的{string}操作,不保存")
//    public void 执行recipe的操作不保存(String action) {
//        mainPage.editPage().recipePage().clickAction("Save");
//        mainPage.editPage().recipePage().clickOkOrCancel("Ok");
//    }

    @当("选择{string}的{string}另存为{string}{string}并且二次确认后")
    public void 选择的另存为并且二次确认后(String preRcpClass, String preRcp, String pmClass, String rcp) {
        mainPage.editPage().recipePage().confirmSaveAs(preRcpClass, preRcp, pmClass, rcp);
    }

    @那么("{string}的配方{string}创建成功")
    public void 的配方创建成功(String rcpClass, String rcp) {
        mainPage.editPage().recipePage().selectRcpType(rcpClass, false);
        assertThat(mainPage.editPage().recipePage().getRcpList().toString()).contains(rcp);
    }

    @并且("成功保存到下位机{string}:")
    public void 成功保存到下位机(String rcpid, String verification) {
        expect(mainPage.editPage().recipePage().getLowerRcp(rcpid)).should(verification);
    }

    @当("选择{string}的{string}另存为")
    public void 选择的另存为(String rcpClass, String rcp) {
        mainPage.editPage().recipePage().saveAs(rcpClass, rcp);
    }

    @当("选择当前配方另存为{string}{string}并且二次确认后:")
    public void 选择当前配方另存为并且二次确认后(String pmClass, String rcp) {
        mainPage.editPage().recipePage().saveAsRcp(pmClass, rcp);
    }

    @那么("新建前弹出框提示信息:")
    public void 新建前弹出框提示信息(String vetifyInfo) {
        expect(mainPage.editPage().recipePage().getmessage()).should(vetifyInfo);
        mainPage.editPage().recipePage().clear();
    }

    @并且("修改comments为{string}")
    public void 修改comments为(String comment) {
        mainPage.editPage().recipePage().editComment(comment);
    }

    @并且("确认保存后再新建Recipe{string}")
    public void 确认保存后再新建recipe(String rcp) {
        mainPage.editPage().recipePage().confimSaveAndCreate(rcp);
    }

    @并且("确认不保存后再新建Recipe{string}")
    public void 确认不保存后再新建recipe(String rcp) {
        mainPage.editPage().recipePage().noSaveAndCreate(rcp);
    }

    @那么("确认{string}的步骤{int}的{string}为{string}")
    public void 确认的步骤的为(String rcp, int step, String param, String value) {
        mainPage.editPage().recipePage().selectRcp(rcp);
        assertThat(mainPage.editPage().recipePage().sureStepName(step, param).equals(value)).isTrue();
    }

    @当("删除{string}的{string}")
    public void 删除的(String rcpClass, String rcp) {
        mainPage.editPage().recipePage().deleteRcp(rcpClass, rcp);
    }

    @当("删除{string}的{string}并二次确认")
    public void 删除的并二次确认(String rcpClass, String rcp) {
        mainPage.editPage().recipePage().confirmDelete(rcpClass, rcp);
    }

    @那么("{string}的{string}删除成功")
    public void 的删除成功(String rcpClass, String rcp) {
        mainPage.editPage().recipePage().selectRcpType(rcpClass, false);
        assertThat(mainPage.editPage().recipePage().getRcpList().toString()).doesNotContain(rcp);
    }

    @并且("下位机无法查询到{string}")
    public void 下位机无法查询到(String rcpId) {
        assertThat(mainPage.editPage().recipePage().getAllLowerRcp()).doesNotContain(rcpId);
    }

    @那么("弹出框提示信息:")
    public void 弹出框提示信息(String verifyInfo) {
        expect(mainPage.verifyClickActionQuestion("Yes")).should(verifyInfo);
    }

    @当("删除{string}的{string}并二次确认:")
    public void 删除的并二次确认2(String arg0, String arg1) {
        mainPage.editPage().recipePage().confirmDeleteYes();
    }

    @那么("保存配方失败,提示")
    public void 保存配方失败提示(String verificatino) {
        expect(mainPage.editPage().recipePage().getmessage()).should(verificatino);
        mainPage.editPage().recipePage().clickOkOrCancel("OK");
    }

    @当("导出{string}的{string}的所有步骤并二次确认")
    public void 导出的的所有步骤并二次确认(String rcpClass, String rcp) {
        mainPage.editPage().recipePage().confirmExport(rcpClass, rcp);
    }

    @当("导出{string}的{string}为{string}文件")
    public void 导出的为文件(String rcpClass, String rcp, String exportFile) {
        mainPage.editPage().recipePage().confirmExport(rcpClass, rcp);
        mainPage.editPage().recipePage().exportRcpFile(virtualDir, exportFile);
    }

    @当("导出{string}的{string}为{string}文件:")
    public void 导出的为文件2(String rcpClass, String rcp, String exportFile) {
        mainPage.editPage().recipePage().export("Full Steps", "", "");
        mainPage.editPage().recipePage().exportRcpFile(virtualDir, exportFile);
    }

    @那么("导出成功,提示信息为:")
    public void 导出成功提示信息为(String verifyInfo) {
        expect(mainPage.verifyClickAction("OK")).should(verifyInfo);
    }

    @并且("导出路径存在{string}:")
    public void 导出路径存在(String fileName, String verification) {
        expect(mainPage.editPage().recipePage().verifyFile(localDir, fileName)).should(verification);
    }

    @那么("导出失败,提示信息为:")
    public void 导出失败提示信息为(String verification) {
        expect(mainPage.verifyClickAction("OK")).should(verification);
    }

    @当("执行导出操作时")
    public void 执行导出操作时() {
        mainPage.editPage().recipePage().clickAction("Export");
    }

    @当("选择{string}的{string}重命名为{string}并且二次确认后")
    public void 选择的重命名为并且二次确认后(String rcpClass, String preRcp, String renameRcp) {
        mainPage.editPage().recipePage().confirmSaveAs(rcpClass, preRcp, renameRcp);
    }

    @那么("执行成功,提示信息:")
    public void 执行成功提示信息(String verification) {
        expect(mainPage.verifyClickAction("")).should(verification);
    }

    @当("选择{string}的{string}重命名")
    public void 选择的重命名(String rcpClass, String preRcp) {
        mainPage.editPage().recipePage().selectAndsaveAs(rcpClass, preRcp);
    }

    @当("导出{string}的{string}的步骤{string}到步骤{string}为{string}文件")
    public void 导出的的步骤到步骤为文件(String rcpClass, String rcp, String startStep, String endStep, String exportFile) {
        mainPage.editPage().recipePage().exportSubStep(rcpClass, rcp, startStep, endStep);
        mainPage.editPage().recipePage().exportRcpFile(virtualDir, exportFile);
    }

    @当("导出{string}的{string}的步骤{string}到步骤{string}")
    public void 导出的的步骤到步骤(String rcpClass, String rcp, String startStep, String endStep) {
        mainPage.editPage().recipePage().exportSubStep(rcpClass, rcp, startStep, endStep);
    }

    @那么("执行新建失败,异常信息为:")
    public void 执行新建失败异常信息为(String verifyInfo) {
        expect(mainPage.verifyClickAction("OK")).should(verifyInfo);
        mainPage.editPage().recipePage().clickOkOrCancel("Cancel");
    }

    @当("复制Recipe步骤的第一步")
    public void 复制recipe步骤的第一步() {
        mainPage.editPage().recipePage().actionStep("1", "Copy To..");
    }

    @那么("复制目的步骤返回如下:")
    public void 复制目的步骤返回如下(String verifications) {
        expect(mainPage.editPage().recipePage().getSecondStep(3)).should(verifications);
    }

    @那么("执行成功,提示信息为")
    public void 执行成功提示信息为2(String verification) {
        expect(mainPage.verifyClickActionQuestion("Yes")).should(verification);
    }

    @当("修改当前配方并保存:")
    public void 修改当前配方并保存(DataTable table) {
        mainPage.editPage().recipePage().modifyAndSave(table);
    }

    @假如("存在如下已保存配方:")
    public void 存在如下已保存配方(DataTable table) {
        if (!Arrays.asList(mainPage.editPage().recipePage().getAllLowerRcp()).contains(("/Process/" + table.row(1).get(2) + ";1"))) {
            mainPage.editPage().recipePage().createRecipeAndSave(table.subTable(0, 0, table.height(), 3));
            mainPage.editPage().recipePage().storeNewRcp(table.subTable(0, 3, table.height(), table.width()), table.row(1).get(2));
        } else {
//            mainPage.editPage().recipePage().selectClass("PM2 GDE", "Process", true);
//            mainPage.editPage().recipePage().selectRcp(table.row(1).get(2));
        }
    }

    @假如("存在未保存配方")
    public void 存在未保存配方2(DataTable table) {
        mainPage.editPage().recipePage().createRecipeAndNotSaveNoDechuck(table);
    }

    @那么("执行成功,提示信息")
    public void 执行成功提示信息2(String verifyInfo) {
        expect(mainPage.verifyClickAction("OK")).should(verifyInfo);
    }

    @当("向前移动指定步骤:")
    public void 向前移动指定步骤(DataTable dataTable) {
        dataTable.asMaps().forEach(map -> mainPage.editPage().recipePage().moveStep(map.get("startStep"), map.get("desStepNum"), "前"));
    }

    @当("向后移动指定步骤:")
    public void 向后移动指定步骤(DataTable dataTable) {
        dataTable.asMaps().forEach(map -> mainPage.editPage().recipePage().moveStep(map.get("startStep"), map.get("desStepNum"), "后"));
    }
}
