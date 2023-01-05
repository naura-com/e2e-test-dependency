package com.naura.test.lower;

import Ice.Identity;
import Ice.StringHolder;
import com.jcraft.jsch.*;
import com.naura.pvd.IComAppEntrance.RemoteAppEntrancePrx;
import com.naura.pvd.IComAppEntrance.RemoteAppEntrancePrxHelper;
import com.naura.pvd.IComRecipe.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Order;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

import static org.apache.commons.io.IOUtils.close;
import static org.assertj.core.api.Assertions.assertThat;

public class Group3RcpStep {


    public RemoteRecipeUserPrx remoteRecipeUserPrx;
    public RemoteRecipeUserPrx remoteRecipeUserPrx2;
    //public StringHolder stringHolder;

    public Ice.Communicator ic;

    public RemoteAppEntrancePrx remoteAppEntrancePrx;


    @SneakyThrows
    @Before(value = "@Recipe", order = 1)
    public void Connect() {
        try {
            ic = Ice.Util.initialize();
            Ice.ObjectPrx base = ic.stringToProxy("RemoteAppEntrance:default -p 20092 -h 172.21.49.112");
            remoteAppEntrancePrx = RemoteAppEntrancePrxHelper.checkedCast(base);
            remoteRecipeUserPrx = remoteAppEntrancePrx.createRecipeUser(new Identity("CTC_Recipe", "Communicator<0>::PM2"));
        } catch (Exception ex) {
            throw new Exception(ex);
        }

    }

    @SneakyThrows
    @Before(value = "@CleanEnv", order = 2)
    @Order(2)
    public void cleanEnv() {
        try {
            StringHolder stringHolder = new StringHolder();
            for (String recipe : remoteRecipeUserPrx.getAllRecipes()) {
                remoteRecipeUserPrx.setRcpApprovalLvl(recipe, 0, stringHolder);
                if (!remoteRecipeUserPrx.removeRecipe(recipe, stringHolder)) {
                    throw new RuntimeException(stringHolder.value);
                }
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }


    @那么("Recipe注册成功{string}_syx")
    public void recipe注册成功(String arg0) {
    }

    @当("注册Recipe时_syx")
    public void 注册recipe时(DataTable dataTable) {

        Map<String, String> recipeInfo = dataTable.asMaps().get(0);
        RemoteRecipeInfo rcpInfo = new RemoteRecipeInfo();
        rcpInfo.name = recipeInfo.get("name");
        rcpInfo.editedBy = recipeInfo.get("editedBy");
        rcpInfo.rcpClass = recipeInfo.get("rcpClass");
        rcpInfo.body = new RemoteProcessRcpInfo();
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.registerRecipe(rcpInfo, stringHolder);
        //System.out.println("stringHolder.value = " + stringHolder.value);
        if (stringHolder.value != "") {
            throw new RuntimeException(stringHolder.value);
        }
    }


    @假如("存在rcpID:")
    public void 存在rcpid为的配方(DataTable dataTable) {
        StringHolder stringHolder = new StringHolder();
        Map<String, String> rcpInfo = dataTable.asMaps().get(0);
        RemoteRecipeInfo recipeInfo = new RemoteRecipeInfo();
        recipeInfo.rcpClass = rcpInfo.get("rcpClass");
        ;
        recipeInfo.name = rcpInfo.get("rcpName");
        recipeInfo.version = rcpInfo.get("version");
        if (!remoteRecipeUserPrx.registerRecipe(recipeInfo, stringHolder)) {
            throw new RuntimeException(stringHolder.value);
        }
    }

    Boolean Result = false;
    Boolean Result2 = false;

    @当("用户{string}独占模式取出{string}_syx")
    public void 用户独占模式取出时(String arg0, String arg1) {
        remoteRecipeUserPrx = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg0), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.releaseExclRcp(arg1, stringHolder);
        Result = remoteRecipeUserPrx.retrieveExclRcp(arg1, stringHolder);
    }

    @那么("取出{string}成功_syx")
    public void 取出成功(String arg0) {
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.releaseExclRcp(arg0, stringHolder);
        assertThat(Result).isTrue();
    }


    @假如("rcpID为{string}的配方被用户{string}独占取出_syx")
    public void rcpid为的配方被独占取出(String arg0, String arg1) {
        remoteRecipeUserPrx = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg1), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.retrieveExclRcp(arg0, stringHolder);
    }

    @当("用户{string}释放{string}_syx")
    public void 用户释放(String arg1, String arg0) {
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.releaseExclRcp(arg0, stringHolder);
        if (stringHolder.value != "") {
            throw new RuntimeException(stringHolder.value);
        }
    }


    @那么("取出失败_syx")
    public void 取出失败() {

    }

    @After("@Recipe")
    public void ReleaseConnect() {
        ic.destroy();
    }

    @那么("释放{string}成功_syx")
    public void 释放成功(String arg0) {
        StringHolder stringHolder = new StringHolder();
        if (remoteRecipeUserPrx.retrieveExclRcp(arg0, stringHolder)) {
            assertThat(true).isTrue();
        } else {
            assertThat(false).isFalse();
        }
        remoteRecipeUserPrx.releaseExclRcp(arg0, stringHolder);
        if (stringHolder.value != "") {
            throw new RuntimeException(stringHolder.value);
        }
    }

    @同时("用户{string}再次独占模式取出{string}_syx")
    public void 用户再次独占模式取出(String arg0, String arg1) {
        StringHolder stringHolder = new StringHolder();
        Result = remoteRecipeUserPrx.retrieveExclRcp(arg1, stringHolder);
        remoteRecipeUserPrx.releaseExclRcp(arg1, stringHolder);
    }

    @那么("取出{string}失败_syx")
    public void 取出失败(String arg0) {
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.releaseExclRcp(arg0, stringHolder);
        assertThat(Result).isFalse();
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
    }

    @假如("存在rcpID为{string}的配方如下_syx")
    public void 存在rcpid为的配方如下(String arg0, DataTable dataTable) {
    }

    @并且("用户{string}修改{string}步骤为{string}的{string}值为{string}_syx")
    public void 用户修改步骤为的值为(String User, String RcpId, String Index, String Param, String Value) {
        remoteRecipeUserPrx = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", User), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        Result = remoteRecipeUserPrx.setExclRcpStepValue(RcpId, Integer.parseInt(Index), Param, Value, stringHolder);
    }

    @那么("用户{string}修改{string}成功_syx")
    public void 用户修改成功(String arg0, String arg1) {
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.releaseExclRcp(arg1, stringHolder);
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
        assertThat(Result).isTrue();
    }

    @那么("用户{string}修改{string}失败_syx")
    public void 用户修改失败(String arg0, String arg1) {
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.releaseExclRcp(arg1, stringHolder);
        assertThat(Result).isFalse();
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
    }

    @那么("修改{string}失败_syx")
    public void 修改失败(String arg0) {
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.releaseExclRcp(arg0, stringHolder);
        assertThat(Result).isFalse();
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/

    }

    @假如("只存在rcpID为{string}的配方_syx")
    public void 只存在rcpid为的配方(String arg0) {

    }

    @并且("修改执行态{string}的作者为{string}_syx")
    public void 修改执行态的作者为(String arg0, String arg1) {
        StringHolder stringHolder = new StringHolder();
        Result = remoteRecipeUserPrx.setExclRcpEditor(arg0, arg1, stringHolder);
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
    }

    @那么("修改{string}成功_syx")
    public void 修改成功(String arg0) {
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.releaseExclRcp(arg0, stringHolder);
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
        assertThat(Result).isTrue();
    }

    @当("修改{string}的注释为{string}_syx")
    public void 修改的注释为(String arg0, String arg1) {
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.setExclRcpComments(arg0, arg1, stringHolder);
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
    }


    @假如("存在用户{string}_syx")
    public void 存在用户(String arg0) {
    }

    int NameSpaceONLev;

    @当("用户{string}获取Recipe名字空间的只读级别_syx")
    public void 用户获取Recipe名字空间的只读级别(String arg0) {
        remoteRecipeUserPrx = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg0), "Communicator<0>::PM2"));
        NameSpaceONLev = remoteRecipeUserPrx.getNamespaceROLvl();
    }

    @那么("只读级别为默认值{int}_syx")
    public void 只读级别为默认值(int arg0) {
        assertThat(NameSpaceONLev).isEqualTo(2);
    }

    @假如("只存在用户{string}_syx")
    public void 只存在用户(String arg0) {
    }

    @当("用户{string}修改{string}的授权级别为{string}_syx")
    public void 用户修改的授权级别为(String User, String arg0, String arg1) {
        remoteRecipeUserPrx = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", User), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        Result = remoteRecipeUserPrx.setRcpApprovalLvl(arg0, Integer.parseInt(arg1), stringHolder);
    }

    @那么("修改{string}授权级别成功_syx")
    public void 修改授权级别成功(String arg0) {
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.releaseExclRcp(arg0, stringHolder);
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
        assertThat(Result).isTrue();
    }

    @那么("修改{string}授权级别失败_syx")
    public void 修改授权级别失败(String arg0) {
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.releaseExclRcp(arg0, stringHolder);
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
        assertThat(Result).isFalse();
    }


    @当("用户{string}修改执行态{string}的作者为{string}_syx")
    public void 用户修改执行态的作者为(String arg0, String arg1, String arg2) {
        remoteRecipeUserPrx = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg0), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        Result = remoteRecipeUserPrx.setExclRcpEditor(arg1, arg2, stringHolder);
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
    }

    @当("用户{string}修改{string}的注释为{string}_syx")
    public void 用户修改的注释为(String arg0, String arg1, String arg2) {
        remoteRecipeUserPrx = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg0), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.setExclRcpComments(arg1, arg2, stringHolder);
    }

    @同时("另一用户{string}独占模式取出{string}_syx")
    public void 另一用户独占模式取出(String arg0, String arg1) {
        remoteRecipeUserPrx2 = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg0), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        Result2 = remoteRecipeUserPrx2.retrieveExclRcp(arg1, stringHolder);
        remoteRecipeUserPrx2.releaseExclRcp(arg1, stringHolder);
    }

    @那么("用户{string}取出{string}成功,用户{string}取出{string}失败_syx")
    public void 用户取出成功用户取出失败(String arg0, String arg1, String arg2, String arg3) {
        StringHolder stringHolder = new StringHolder();
        remoteRecipeUserPrx.releaseExclRcp(arg1, stringHolder);
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
        remoteRecipeUserPrx2.releaseExclRcp(arg3, stringHolder);
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
        assertThat(Result).isTrue();
        assertThat(Result2).isFalse();
    }

    @同时("另一用户{string}修改{string}步骤为{string}的{string}值为{string}_syx")
    public void 另一用户修改步骤为的值为(String arg0, String arg1, String arg2, String arg3, String arg4) {
        remoteRecipeUserPrx2 = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg0), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        Result = remoteRecipeUserPrx2.setExclRcpStepValue(arg1, Integer.parseInt(arg2), arg3, arg4, stringHolder);
    }

    @同时("另一个用户{string}修改执行态{string}的作者为{string}_syx")
    public void 另一个用户修改执行态的作者为(String arg0, String arg1, String arg2) {
        remoteRecipeUserPrx2 = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg0), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        Result = remoteRecipeUserPrx2.setExclRcpEditor(arg0, arg1, stringHolder);
    }

    @同时("另一个用户{string}修改{string}的注释为{string}_syx")
    public void 另一个用户修改的注释为(String arg0, String arg1, String arg2) {
        remoteRecipeUserPrx2 = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg0), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        Result = remoteRecipeUserPrx2.setExclRcpComments(arg0, arg1, stringHolder);
    }

    @当("用户{string}修改{string}的作者为{string}_syx")
    public void 用户修改的作者为(String arg0, String arg1, String arg2) {
        remoteRecipeUserPrx = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg0), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        Result = remoteRecipeUserPrx.setRcpEditor(arg1, arg2, stringHolder);
    }

    @假如("存在RcpClass为{string}_syx")
    public void 存在rcpclass为(String arg0) {
    }

    @当("用户{string}在{string}下注册{string}_syx")
    public void 用户在下注册(String arg0, String arg1, String arg2) {
        remoteRecipeUserPrx = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg0), "Communicator<0>::PM2"));
        StringHolder stringHolder = new StringHolder();
        RemoteRcpClassInfoHolder remoteRcpClassInfoHolder = new RemoteRcpClassInfoHolder();
        remoteRecipeUserPrx.getRcpClassInfo(arg1, remoteRcpClassInfoHolder);
        Result = remoteRecipeUserPrx.registerRcpClass(arg2, remoteRcpClassInfoHolder.value.params, stringHolder);
        /*if(stringHolder.value!="")
        {
            throw new RuntimeException(stringHolder.value);
        }*/
    }

    @那么("用户{string}注册成功_syx")
    public void 用户注册成功(String arg0) {
        assertThat(Result).isTrue();
    }

    @当("用户{string}获取{string}的信息_syx")
    public void 用户获取的信息(String arg0, String arg1) {
        remoteRecipeUserPrx = remoteAppEntrancePrx.createRecipeUser(new Identity(String.format("%s_Recipe", arg0), "Communicator<0>::PM2"));
        RemoteRecipeInfo recipeInfo;
        RemoteRecipeInfoHolder remoteRecipeInfoHolder = new RemoteRecipeInfoHolder();
        Result = remoteRecipeUserPrx.getRecipeInfo(arg1, remoteRecipeInfoHolder);
        recipeInfo = remoteRecipeInfoHolder.value;
    }

    @那么("获取成功_syx")
    public void 获取成功() {
        assertThat(Result).isTrue();
    }

    @并且("{string}的步骤数为{int}")
    public void 的步骤数为(String arg0, int arg1) {
        /*String pattern = "/(.*?)/";
        Pattern r = Pattern.compile(pattern);
        Matcher matcher = r.matcher(arg0);
        while (matcher.find())
        {
            String rcpClass = matcher.group(1);
        }*/

        StringHolder stringHolder = new StringHolder();

        RemoteRcpClassInfoHolder remoteRcpClassInfoHolder = new RemoteRcpClassInfoHolder();
        remoteRecipeUserPrx.getRcpClassInfo("/Process", remoteRcpClassInfoHolder);
        ArrayList<String> temp = new ArrayList<>();
        for (RemoteParamInfo param : remoteRcpClassInfoHolder.value.params) {
            temp.add(param.defaultValue);
        }

        RemoteProcessRcpInfo remoteProcessRcpInfo = new RemoteProcessRcpInfo();
        StepInfo[] stepInfo = new StepInfo[1];
        StepInfo stepInfo1 = new StepInfo();
        stepInfo1.name = "1";
        stepInfo1.values = temp.toArray(new String[0]);
        stepInfo[0] = stepInfo1;
        remoteProcessRcpInfo.steps = stepInfo;

        remoteRecipeUserPrx.storeRcpBody(arg0, remoteProcessRcpInfo, true, stringHolder);
    }

    //    @SneakyThrows
    @并且("approvalLvl值为{int}")
    public void approvallvl值为(int arg0) {
        try {
            SshServer sshServer = new SshServer("172.21.49.112", "22", "root", "888888");
            String xml = sshServer.execCommand("cd /root/workspace/shaoyx/Etch1/IC_CTC_Platform_1.3.2_RC_05/6958/508Bv2_PM2_GDEC200_6958/Recipe/; cat RecipeNamespace.xml");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }


    }


    private class SshServer {
        public String host, port, user, password;

        SshServer(String host, String port, String user, String passowrd) {
            this.host = host;
            this.port = port;
            this.user = user;
            password = passowrd;
        }

        public String execCommand(String command) throws IOException {

            JSch jSch = new JSch();

            // 存放执行命令结果
            StringBuffer result = new StringBuffer();
            int exitStatus = 0;

            try {

                // 根据主机账号、ip、端口获取一个Session对象
                Session session = jSch.getSession(user, host, Integer.parseInt(port));

                // 存放主机密码
                session.setPassword(password);

                // 去掉首次连接确认
                Properties config = new Properties();
                config.put("StrictHostKeyChecking", "no");
                session.setConfig(config);

                // 超时连接时间为3秒
                session.setTimeout(3000);

                // 进行连接
                session.connect();

                Channel channel = session.openChannel("exec");
                ((ChannelExec) channel).setCommand(command);

                channel.setInputStream(null);
                // 错误信息输出流，用于输出错误的信息，当exitstatus<0的时候
                ((ChannelExec) channel).setErrStream(System.err);

                // 执行命令，等待执行结果
                channel.connect();

                // 获取命令执行结果
                InputStream in = channel.getInputStream();

                /**
                 * 通过channel获取信息的方式，采用官方Demo代码
                 */
                byte[] tmp = new byte[1024];
                while (true) {
                    while (in.available() > 0) {
                        int i = in.read(tmp, 0, 1024);
                        if (i < 0) {
                            break;
                        }
                        result.append(new String(tmp, 0, i));
                    }
                    // 从channel获取全部信息之后，channel会自动关闭
                    if (channel.isClosed()) {
                        if (in.available() > 0) {
                            continue;
                        }
                        exitStatus = channel.getExitStatus();
                        break;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ee) {
                    }
                }


            } catch (IOException e) {
                System.out.println(e.toString());

            } catch (JSchException e) {
                System.out.println(e.toString());
            } finally {
                close();
            }

            return result.toString();
        }
    }
}
