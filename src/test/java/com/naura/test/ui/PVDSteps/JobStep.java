package com.naura.test.ui.PVDSteps;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ui.page.PVD.MainPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class JobStep {

    @Autowired
    private MainPage mainPage;

    @并且("新建名字为{string}的任务")
    public void 新建名字为的任务(String name) {
        mainPage.editPage().jobPage().clickButton("新建");
        mainPage.editPage().jobPage().getErrorProviderInCreateJob(name);
    }


    @并且("新建使用相同的槽位任务如下:")
    public void 新建使用相同的槽位任务如下(Table table) {
        mainPage.editPage().jobPage().createJobWithSameSlot(table);
    }

    @并且("新建任务如下:")
    public void 新建任务如下(Table table) {
        mainPage.editPage().jobPage().createNewJob(table);
    }

    @当("再次新建任务时")
    public void 再次新建任务时() {
        mainPage.editPage().jobPage().clickButton("新建");
    }

    @并且("不选择路径和槽位创建任务:")
    public void 不选择路径和槽位创建任务(Table table) {
        mainPage.editPage().jobPage().createJobWithoutJobDetail(table);
    }

    @并且("保存未保存的任务时")
    public void 保存未保存的任务时() {
        mainPage.makeSure();
    }

    @并且("不选择起始片盒和目的片盒创建任务:")
    public void 不选择起始片盒和目的片盒创建任务(Table table) {
        mainPage.editPage().jobPage().createJobWithoutSource(table);
    }

    @那么("新建任务{string}")
    public void 新建任务(String jobName) {
        mainPage.editPage().jobPage().createJobOnlyName(jobName);
    }

    @那么("任务名称列表返回如下:")
    public void 任务名称列表返回如下(String verification) {
        expect(mainPage.editPage().jobPage().getJobList()).should(verification);
    }

    @并且("不保存未保存的任务时")
    public void 不保存未保存的任务时() {
        mainPage.makeCancel();
    }

    @并且("不选择路径创建任务:")
    public void 不选择路径创建任务(Table table) {
        mainPage.editPage().jobPage().createJobWithoutRoute(table);
    }

    @并且("创建起始片盒和目的片盒不同的任务:")
    public void 创建起始片盒和目的片盒不同的任务(Table table) {
        mainPage.editPage().jobPage().createJobWithDiffPort(table);
    }

    @当("将起始片盒和目的片盒保持一致时")
    public void 将起始片盒和目的片盒保持一致时() {
        mainPage.makeSure();
    }

    @那么("起始片盒为:")
    public void 起始片盒为(String verification) {
        expect(mainPage.editPage().jobPage().getSourcePort()).should(verification);
    }

    @并且("目的片盒为:")
    public void 目的片盒为(String verification) {
        expect(mainPage.editPage().jobPage().getDestPort()).should(verification);
    }

    @当("将起始片盒和目的片盒不保持一致时")
    public void 将起始片盒和目的片盒不保持一致时() {
        mainPage.makeCancel();
    }

    @当("执行{string}时:")
    public void 执行时(String action) {
        mainPage.editPage().jobPage().clickButton(action);
    }

    @那么("{string}成功,提示信息如下:")
    public void 成功提示信息如下(String action, String verification) {
        expect(mainPage.editPage().jobPage().getPopMessage()).should(verification);
    }

    @并且("{string}的参数如下:")
    public void 的参数如下(String jobName, String verification) {
        mainPage.editPage().jobPage().selectJob(jobName);
        assertThat(mainPage.editPage().jobPage().getAllJob()).contains(jobName);
        expect(mainPage.editPage().jobPage().getJobInfo(jobName)).should(verification);
    }

    @并且("新建路径如下:")
    public void 新建路径如下(Table table) {
        mainPage.editPage().jobPage().createNewJob(table);
    }

    @当("修改{string}的参数如下:")
    public void 修改的参数如下(String jobName, Table table) {
        mainPage.editPage().jobPage().selectJob(jobName);
        mainPage.editPage().jobPage().editJob(table);
    }

    @那么("提示信息如下:")
    public void 提示信息如下(String verification) {
        expect(mainPage.editPage().jobPage().getPopMessage()).should(verification);
    }

    @并且("继续执行{string}操作时")
    public void 继续执行操作时(String action) {
        mainPage.editPage().jobPage().clickButton(action);
    }

    @那么("抛出以下提示信息:")
    public void 抛出以下提示信息(String verification) {
        expect(mainPage.editPage().jobPage().getConfirmMessage()).should(verification);
    }

    @当("新建job{string}:")
    public void 新建job(String jobName, Table table) {
        mainPage.editPage().jobPage().createNewJob(jobName, table);
    }

    @并且("存在如下Job")
    public void 存在如下job(Table table) {
        mainPage.editPage().jobPage().saveNewJob(table);
    }

    @当("编辑job{string}参数:")
    public void 编辑job参数(String jobName, DataTable table) {
        mainPage.editPage().jobPage().editJob(jobName, table.asMaps().get(0));
    }

    @那么("job信息显示如下:")
    public void job信息显示如下(Table table) {
        expect(mainPage.editPage().jobPage().CheckInfo(table)).should("= true");
    }

    @并且("选择job{string}")
    public void 选择job(String jobName) {
        mainPage.editPage().jobPage().selectOneJob(jobName);
    }

    @并且("job{string}信息显示如下:")
    public void job信息显示如下(String jobName, Table table) {
        mainPage.editPage().jobPage().selectOneJob(jobName);
        expect(mainPage.editPage().jobPage().CheckInfo(table)).should("= true");
    }

    @并且("选择job{string}后选择{string}操作")
    public void 选择job后选择操作(String jobName, String processMode) {
        mainPage.editPage().jobPage().selectOneJob(jobName);
        mainPage.editPage().recipePage().doPopMessage(processMode);
    }

    @当("未选择job执行{string}时")
    public void 未选择job执行时(String operation) {
        mainPage.editPage().jobPage().clickButton(operation);
    }

    @当("编辑job{string}的第{string}路径的槽位为全部")
    public void 编辑job的第路径的槽位为全部(String jobName, String routeIndex) {
        mainPage.editPage().jobPage().selectOneJob(jobName);
        mainPage.editPage().jobPage().editSlotAll(routeIndex);
    }

    @那么("第{string}行的路径返回如下:")
    public void 第行的路径返回如下(String rowIndex, String verification) {
        expect(mainPage.editPage().jobPage().getRouteItems(rowIndex)).should(verification);
    }

    @当("新建空job{string}:")
    public void 新建空job(String jobName) {
        mainPage.editPage().jobPage().createNewEmptyJob(jobName);
    }

    @那么("起始片盒可选项返回如下")
    public void 起始片盒可选项返回如下(String verification) {
        expect(mainPage.editPage().jobPage().getSoureLPItems()).should(verification);
    }

    @并且("目的片盒可选项返回如下")
    public void 目的片盒可选项返回如下(String verification) {
        expect(mainPage.editPage().jobPage().getDstLPItems()).should(verification);
    }

    @当("编辑job参数:")
    public void 编辑job参数(Table table) {
        mainPage.editPage().jobPage().editJobParam(table.get(0), false);
    }

    @当("执行{string}时并二次确认")
    public void 执行时并二次确认(String action) {
        mainPage.editPage().jobPage().clickButton(action);
        mainPage.editPage().jobPage().makeSure();
    }

    @当("选择{string}并且执行{string}时")
    public void 选择并且执行时(String jobName, String action) {
        mainPage.editPage().jobPage().selectJob(jobName);
        mainPage.editPage().jobPage().clickButton(action);
        mainPage.editPage().jobPage().makeSure();

    }
}
