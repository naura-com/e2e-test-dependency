package com.naura.test.ui.page;

import com.github.leeonky.jfactory.cucumber.Table;
import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JobPage {
    private final Window.WindowOperation page;
    private final WinForm winForm;

    public JobPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public void clickButton(String operation) {
        switch (operation) {
            case "新建":
                page.elementById("mNewJob_btn").click();
                break;
            case "删除":
                page.elementById("mDelJob_btn").click();
                break;
            case "修改":
                page.elementById("mModifyJob_btn").click();
                break;
            case "保存":
                page.elementById("mSaveJob_btn").click();
                break;
            case "是":
                winForm.elementByName("是").click();
                break;
            case "否":
                winForm.elementByName("否").click();
                break;
            default:
                throw new RuntimeException("unknown operation:" + operation);
        }
    }

    public void getErrorProviderInCreateJob(String name) {
        winForm.elementById("mJobName_tb").sendKeys(name);
        winForm.elementByName("确定").click();
    }

    public void createJobOnlyName(String name) {
        clickButton("新建");
        winForm.elementById("mJobName_tb").sendKeys(name);
        winForm.elementByName("确定").click();
    }

    public void createNewJob(Table table) {
        for (Map<String, ?> map : table) {
            clickButton("新建");
            winForm.elementById("mJobName_tb").sendKeys((String) map.get("name"));
            winForm.elementByName("确定").click();
            List<Map<String, ?>> list = (List<Map<String, ?>>) table.get(0).get("jobDetail");
            for (int j = 0; j < list.size(); j++) {
                page.elementByName("路径 行 " + Integer.toString(j)).click().sendKeys((String) list.get(j).get("route"));
                page.elementByName("槽位 行 " + Integer.toString(j)).click();
                String[] slots = ((String) list.get(j).get("slots")).split(",");
                for (String str : slots) {
                    winForm.elementByName("位置" + str).click();
                }
                winForm.elementByName("确定").click();
            }

            page.elementById("mSrc_cmb").click().elementByName((String) map.get("src")).click();
            page.elementById("mDst_cmb").click().elementByName((String) map.get("dest")).click();
            if (map.get("mode").equals("串行模式")) {
                page.elementByName(" 串 行 模 式").click();
            } else if (map.get("mode").equals("并行模式")) {
                page.elementByName(" 并 行 模 式").click();
            } else if (map.get("mode").equals("管道模式")) {
                page.elementByName(" 管 道 模 式").click();
            }
            if (map.get("action") != null && map.get("action").equals("卸载片盒"))
                page.elementByName(" 卸 载 片 盒").click();
            page.elementById("mCycleNum_tb").sendKeys((String) map.get("cyctime"));
        }
    }

    public void createJobWithSameSlot(Table table) {
        for (Map<String, ?> map : table) {
            clickButton("新建");
            winForm.elementById("mJobName_tb").sendKeys((String) map.get("name"));
            winForm.elementByName("确定").click();
            List<Map<String, ?>> list = (List<Map<String, ?>>) table.get(0).get("jobDetail");
            for (int j = 0; j < list.size(); j++) {
                page.elementByName("路径 行 " + Integer.toString(j)).click().sendKeys((String) list.get(j).get("route"));
                page.elementByName("槽位 行 " + Integer.toString(j)).click();
                String[] slots = ((String) list.get(j).get("slots")).split(",");
                for (String str : slots) {
                    winForm.elementByName("位置" + str).click();
                }
                winForm.elementByName("确定").click();
            }
        }
    }


    public void createJobWithoutJobDetail(Table table) {
        for (Map<String, ?> map : table) {
            clickButton("新建");
            winForm.elementById("mJobName_tb").sendKeys((String) map.get("name"));
            winForm.elementByName("确定").click();
            page.elementById("mSrc_cmb").click().elementByName((String) map.get("src")).click();
            page.elementById("mDst_cmb").click().elementByName((String) map.get("dest")).click();
            if (map.get("mode").equals("串行模式")) {
                page.elementByName(" 串 行 模 式").click();
            } else if (map.get("mode").equals("并行模式")) {
                page.elementByName(" 并 行 模 式").click();
            } else if (map.get("mode").equals("管道模式")) {
                page.elementByName(" 管 道 模 式").click();
            }
            if (map.get("action") != null && map.get("action").equals("卸载片盒"))
                page.elementByName(" 卸 载 片 盒").click();
            page.elementById("mCycleNum_tb").sendKeys((String) map.get("cyctime"));
        }
    }

    public void createJobWithoutSource(Table table) {
        for (Map<String, ?> map : table) {
            clickButton("新建");
            winForm.elementById("mJobName_tb").sendKeys((String) map.get("name"));
            winForm.elementByName("确定").click();

            List<Map<String, ?>> list = (List<Map<String, ?>>) table.get(0).get("jobDetail");
            for (int j = 0; j < list.size(); j++) {
                page.elementByName("路径 行 " + Integer.toString(j)).click().sendKeys((String) list.get(j).get("route"));
                page.elementByName("槽位 行 " + Integer.toString(j)).click();
                String[] slots = ((String) list.get(j).get("slots")).split(",");
                for (String str : slots) {
                    winForm.elementByName("位置" + str).click();
                }
                winForm.elementByName("确定").click();
            }

            if (map.get("mode").equals("串行模式")) {
                page.elementByName(" 串 行 模 式").click();
            } else if (map.get("mode").equals("并行模式")) {
                page.elementByName(" 并 行 模 式").click();
            } else if (map.get("mode").equals("管道模式")) {
                page.elementByName(" 管 道 模 式").click();
            }
            if (map.get("action") != null && map.get("action").equals("卸载片盒"))
                page.elementByName(" 卸 载 片 盒").click();
            page.elementById("mCycleNum_tb").sendKeys((String) map.get("cyctime"));
        }
    }

    public void createJobWithoutRoute(Table table) {
        clickButton("新建");
        winForm.elementById("mJobName_tb").sendKeys((String) table.get(0).get("name"));
        winForm.elementByName("确定").click();
        page.elementByName("槽位 行 0").click();
    }

    public void createJobWithDiffPort(Table table) {
        clickButton("新建");
        winForm.elementById("mJobName_tb").sendKeys((String) table.get(0).get("name"));
        winForm.elementByName("确定").click();
        page.elementById("mSrc_cmb").click().elementByName((String) table.get(0).get("src")).click();
        page.elementById("mDst_cmb").click().elementByName((String) table.get(0).get("dest")).click();

    }

    public List<Map<Object, Object>> getJobList() {
        return page.elementById("mJobList_dgv").getTableValue();
    }

    public String getSourcePort() {
        return page.elementById("mSrc_cmb").getText();
    }

    public String getDestPort() {
        return page.elementById("mDst_cmb").getText();
    }

    public void makeSure() {
        winForm.elementByName("确定").click();
    }

    public Object getPopMessage() {
        String message = winForm.elementById("mMsg_lbl").getText();
        winForm.elementByName("确定").click();
        return message;
    }

    public String[] getAllJob() {
        List<Map<Object, Object>> jobList = page.elementById("mJobList_dgv").getTableValue();
        List<String> allJobs = new ArrayList<>();
        for (int i = 0; i < jobList.size(); i++) {
            allJobs.add((String) jobList.get(i).get("任务名称"));
        }
        String[] jobs = (String[]) allJobs.toArray(new String[0]);
        return jobs;
    }

    public Object getJobInfo(String jobName) {
        selectJob(jobName);
        return page.elementByName("mRtList_dgv").getTableValue();
    }

    public void selectJob(String jobName) {
        List<String> jobs = Arrays.asList(getAllJob());
        page.elementByName("任务名称 行 " + jobs.indexOf(jobName)).click();
    }

    public void cleanAllCreateJob() {
        int n = page.elementById("mJobList_dgv").getTableValue().size();
        for (int i = 0; i < n; i++) {
            page.elementById("mJobList_dgv").selectCell(0, "任务名称");
            deleteJob();
        }
    }

    private void deleteJob(String jobName) {
        selectOneJob(jobName);
        deleteJob();
    }

    public void selectOneJob(String jobName) {
        page.elementById("mJobList_dgv").selectCellByColumnName("任务名称", jobName);
    }

    public void deleteJob() {
        clickButton("删除");
        winForm.elementById("mYes_btn").click();
        winForm.elementById("mYes_btn").click();
    }

    public void saveNewJob(Table table) {
        for (int i = 0; i < table.size(); i++) {
            String jobName = (String) table.get(i).get("name");
            createNewEmptyJob(jobName);
            editJobParam(table.get(i), false);
            saveJob();
        }
    }

    public void createNewJob(String jobName, Table table) {
        createNewEmptyJob(jobName);
        editJobParam(table.get(0), false);
    }

    private void saveJob() {
        clickButton("保存");
        winForm.elementById("mYes_btn").click();
    }

    public void createNewEmptyJob(String jobName) {
        clickButton("新建");
        winForm.elementById("mJobName_tb").sendKeys(jobName);
        winForm.elementByName("确定").click();
    }

    public void editJob(String jobName, Map<String, String> paramInfos) {
        selectOneJob(jobName);
        clickButton("修改");
        editJobParam(paramInfos, true);
    }

    public void editJobParam(Map<String, ?> paramInfos, boolean isClear) {
        for (Map.Entry<String, ?> paramInfo :
                paramInfos.entrySet()) {
            switch (paramInfo.getKey()) {
                case "路径和槽位":
                    editJobRoutes((String) paramInfo.getValue(), isClear);
                    break;
                case "起始片盒":
                    page.elementById("mSrc_cmb").click().elementByName((String) paramInfo.getValue()).click();
                    break;
                case "目的片盒":
                    page.elementById("mDst_cmb").click().elementByName((String) paramInfo.getValue()).click();
                    break;
                case "调度模式":
                    editJobMode((String) paramInfo.getValue());
                    break;
                case "卸载片盒":
                    editUnload((String) paramInfo.getValue());
                    break;
                case "循环次数":
                    page.elementById("mCycleNum_tb").clear();
                    page.elementById("mCycleNum_tb").sendKeys((String) paramInfo.getValue());
                    break;
                case "路径":
                    String rinfo = (String) paramInfo.getValue();
                    editJobRoute(Integer.parseInt(rinfo.split(":")[0]), rinfo.split(":")[1]);
                    break;
                case "槽位":
                    String sinfo = (String) paramInfo.getValue();
                    ediJobSlot(Integer.parseInt(sinfo.split(":")[0]), sinfo.split(":")[1], isClear);
                    break;
            }
        }
    }

    private void editUnload(String value) {
        if (!String.valueOf(page.elementByName(" 卸 载 片 盒").isSelect()).equals(value))
            page.elementByName(" 卸 载 片 盒").click();
    }

    private void editJobMode(String value) {
        if (value.equals("串行模式")) {
            page.elementByName(" 串 行 模 式").click();
        } else if (value.equals("并行模式")) {
            page.elementByName(" 并 行 模 式").click();
        } else if (value.equals("管道模式")) {
            page.elementByName(" 管 道 模 式").click();
        }
    }

    private void editJobRoutes(String routesInfo, boolean isClear) {
        int i = 0;
        for (String routeInfo :
                routesInfo.split(";")) {
            editJobRoute(i, routeInfo.split(":")[0]);
            ediJobSlot(i, routeInfo.split(":")[1], isClear);
            i++;
        }
    }

    private void ediJobSlot(int i, String slots, boolean isClear) {
        page.elementById("mRtList_dgv").selectCell(i, "槽位");
        if (isClear) {
            for (int slot = 1; i < 26; i++) {
                if (winForm.elementById("PopupSetSlot").elementById("Slot" + slot).isSelect()) {
                    winForm.elementById("PopupSetSlot").elementById("Slot" + slot).click();
                }
            }
        }
        for (String slot :
                slots.split(",")) {
            winForm.elementById("PopupSetSlot").elementById("Slot" + slot).click();
        }
        winForm.elementById("PopupSetSlot").elementByName("确定").click();
    }

    private void editJobRoute(int row, String routeName) {
        page.elementById("mRtList_dgv").selectCell(row, "路径").click();
        page.elementByName("编辑控件").click().elementByName(routeName).click();
        page.elementById("mRtList_dgv").selectCell(row + 1, "路径").click();
    }

    public boolean CheckInfo(Table table) {
        for (Map.Entry<String, ?> paramInfo :
                table.get(0).entrySet()) {
            switch (paramInfo.getKey()) {
                case "起始片盒":
                    if (!page.elementById("mSrc_cmb").getValue().equals(paramInfo.getValue()))
                        return false;
                    break;
                case "目的片盒":
                    if (!page.elementById("mDst_cmb").getValue().equals(paramInfo.getValue()))
                        return false;
                    break;
                case "调度模式":
                    if (!checkJobMode((String) paramInfo.getValue()))
                        return false;
                    break;
                case "卸载片盒":
                    if (!String.valueOf(page.elementByName(" 卸 载 片 盒").isSelect()).equals(paramInfo.getValue()))
                        return false;
                    break;
                case "循环次数":
                    if (!String.valueOf(page.elementById("mCycleNum_tb").getValue()).equals(paramInfo.getValue()))
                        return false;
                    break;
                case "路径":
                    String rinfo = (String) paramInfo.getValue();
                    if (!page.elementById("mRtList_dgv").getCellValue(Integer.parseInt(rinfo.split(":")[0]),
                            "路径").equals(rinfo.split(":")[1]))
                        return false;
                    break;
                case "槽位":
                    String sinfo = (String) paramInfo.getValue();
                    if (!page.elementById("mRtList_dgv").getCellValue(Integer.parseInt(sinfo.split(":")[0]),
                            "槽位").equals(sinfo.split(":")[1]))
                        return false;
                    break;
            }
        }
        return true;
    }

    private boolean checkJobMode(String value) {
        if (value.equals("串行模式")) {
            return page.elementByName(" 串 行 模 式").isSelect();
        } else if (value.equals("并行模式")) {
            return page.elementByName(" 并 行 模 式").isSelect();
        } else if (value.equals("管道模式")) {
            return page.elementByName(" 管 道 模 式").isSelect();
        }
        return false;
    }

    public void editJob(Table table) {
        Map<String, ?> map = table.get(0);
        clickButton("修改");
        List<Map<String, ?>> list = (List<Map<String, ?>>) table.get(0).get("jobDetail");
        for (int j = 0; j < list.size(); j++) {
            page.elementByName("路径 行 " + Integer.toString(j)).click().sendKeys((String) list.get(j).get("route"));
            page.elementByName("槽位 行 " + Integer.toString(j)).click();
            winForm.elementById("mSlotAll_cb").click().click();//清空已选位置
            String[] slots = ((String) list.get(j).get("slots")).split(",");
            if (!slots.toString().isEmpty()) {
                for (String str : slots) {
                    winForm.elementByName("位置" + str).click();
                }
            }
            winForm.elementByName("确定").click();
        }
        if (!map.get("src").equals(map.get("dest"))) {
            page.elementById("mSrc_cmb").click().elementByName((String) map.get("src")).click();
            page.elementById("mDst_cmb").click().elementByName((String) map.get("dest")).click();
            winForm.elementByName("取消").click();
        } else {
            page.elementById("mSrc_cmb").click().elementByName((String) map.get("src")).click();
            page.elementById("mDst_cmb").click().elementByName((String) map.get("dest")).click();
        }
        if (map.get("mode").equals("串行模式")) {
            page.elementByName(" 串 行 模 式").click();
        } else if (map.get("mode").equals("并行模式")) {
            page.elementByName(" 并 行 模 式").click();
        } else if (map.get("mode").equals("管道模式")) {
            page.elementByName(" 管 道 模 式").click();
        }
        if (map.get("action") != null && map.get("action").equals("卸载片盒")) {
            page.elementByName(" 卸 载 片 盒").click();
        }
        page.elementById("mCycleNum_tb").sendKeys((String) map.get("cyctime"));
    }

    public Object getConfirmMessage() {
        String message = winForm.elementById("mMsg_lbl").getText();
        return message;
    }

    public void editSlotAll(String routeIndex) {
        int i = Integer.parseInt(routeIndex);
        page.elementById("mRtList_dgv").selectCell(i, "槽位");
        winForm.elementById("PopupSetSlot").elementById("mSlotAll_cb").click();
        winForm.elementById("PopupSetSlot").elementByName("确定").click();
    }

    public List<Object> getRouteItems(String rowIndex) {
        page.elementById("mRtList_dgv").selectCell(Integer.parseInt(rowIndex), "路径").click();
        List<Object> list = page.elementByName("编辑控件").click().getListValue();
        return list;
    }

    public List<Object> getSoureLPItems() {
        List<Object> items = page.elementById("mSrc_cmb").click().getListValue();
        page.elementById("mSrc_cmb").click();
        return items;
    }

    public List<Object> getDstLPItems() {
        List<Object> items = page.elementById("mDst_cmb").click().getListValue();
        page.elementById("mDst_cmb").click();
        return items;
    }
}
