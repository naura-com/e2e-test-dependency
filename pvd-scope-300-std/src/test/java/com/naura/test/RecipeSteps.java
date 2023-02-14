package com.naura.test;

import Ice.Current;
import Ice.StringHolder;
import com.naura.test.ice.IComRecipe.RemoteProcessRcpInfo;
import com.naura.test.ice.IComRecipe.RemoteRecipeInfo;
import com.naura.test.ice.IComRecipe.RemoteRecipeInfoHolder;
import com.naura.test.ice.IComRecipe.StepInfo;
import com.naura.test.ui.MockLower;
import com.naura.test.ui.driver.WinForm;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class RecipeSteps {
    @Autowired
    private MockLower mockLower;

    @假如("存在pe的RecipeClass{string}的如下{string}")
    public void 存在pe的recipeclass的如下(String recipeName, String objName, DataTable dataTable) {
        doReturn(new String[]{"/Ch1/test1;1"}).when(mockLower.remoteRecipeUser).getAllRecipes(any(Current.class));
        doAnswer(invocationOnMock -> {
            RemoteRecipeInfoHolder holder = invocationOnMock.getArgument(1);
            RemoteRecipeInfo remoteRecipeInfo = new RemoteRecipeInfo();
            RemoteProcessRcpInfo rcpBodyInfo = new RemoteProcessRcpInfo();
            rcpBodyInfo.steps = dataTable.asMaps().stream().map(row -> new StepInfo("1", new String[]{row.get("defaultValue")})).collect(Collectors.toList()).toArray(new StepInfo[]{});
            remoteRecipeInfo.body = rcpBodyInfo;
            holder.value = remoteRecipeInfo;
            return true;
        }).when(mockLower.remoteRecipeUser).getRecipeInfo(anyString(), any(RemoteRecipeInfoHolder.class), any(Current.class));
    }

    @Autowired
    WinForm winForm;

    @那么("Recipe创建成功 \\/Process\\/Rcp{int};{int}")
    public void recipe创建成功ProcessRcp(int arg0, int arg1) {
    }

    @并且("创建了如下Recipe属性")
    public void 创建了如下recipe属性() {
    }

    @当("创建名称为{string}且Class为{string}的Recipe时")
    public void 创建名称为且Class为的Recipe时(String name, String recipeClass) {
        winForm.elementById("mEditor_navibtn").click();
        winForm.elementById("mPM_cmb").selectByName(recipeClass);
        winForm.elementById("mRcpNew_btn").click();
        winForm.elementById("mSaveAsCatalog_cmb").selectByName("/" + recipeClass);
        winForm.elementById("mRcpName_tb").sendKeys(name);
        winForm.elementByName("确定").click();
        winForm.elementByName("确定").click();
    }

    @那么("以如下的RemoteRecipeInfo注册Recipe成功")
    public void 以如下的remoterecipeinfo注册recipe成功(DataTable dataTable) {
        ArgumentCaptor<RemoteRecipeInfo> captor = ArgumentCaptor.forClass(RemoteRecipeInfo.class);
        verify(mockLower.remoteRecipeUser).registerRecipe(captor.capture(), any(StringHolder.class), any(Current.class));
        Map<String, String> expected = dataTable.asMaps().get(0);
        assertThat(captor.getValue().name).isEqualTo(expected.get("name"));
        winForm.elementByName("删除").click();
        winForm.elementByName("确定").click();
        winForm.elementByName("确定").click();
    }
}
