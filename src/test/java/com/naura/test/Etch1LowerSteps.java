package com.naura.test;

import Ice.*;
import com.naura.ctc.IComAlarm.*;
import com.naura.ctc.IComAppEntrance.*;
import com.naura.ctc.IComControlObject.*;
import com.naura.ctc.IComData.*;
import com.naura.ctc.IComDataLog.*;
import com.naura.ctc.IComInterlock.*;
import com.naura.ctc.IComRecipe.*;
import com.naura.ctc.IComSetup.RemoteSetupManager;
import com.naura.ctc.IComSetup.RemoteSetupManagerPrx;
import com.naura.ctc.IComSetup.RemoteSetupManagerPrxHelper;
import com.naura.ctc.IComSetup._RemoteSetupManagerDisp;
import com.naura.ctc.IComSysLog.*;
import com.naura.test.ui.driver.WinForm;
import io.cucumber.java.Before;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

import static org.mockito.Mockito.*;

public class Etch1LowerSteps {

    private Communicator communicator = Util.initialize();
    private static RemoteObjectType remoteObjectType = RemoteObjectType.DATA;
//    private static com.naura.ctc.IComData.RemoteDataInfo remoteValueInfo = new com.naura.ctc.IComData.RemoteDataInfo();
//    private static com.naura.ctc.IComData.RemoteIntValueInfo remoteIntValueInfo = new com.naura.ctc.IComData.RemoteIntValueInfo();
//    private static com.naura.ctc.IComData.RemoteStringValueInfo remoteStringValueInfo = new com.naura.ctc.IComData.RemoteStringValueInfo();
//    private static com.naura.ctc.IComData.RemoteDoubleValueInfo remoteDoubleValueInfo = new com.naura.ctc.IComData.RemoteDoubleValueInfo();

    @Autowired
    WinForm winForm;

    @SneakyThrows
    @Before("@etch1")
    public void startup() {
        new Thread(this::startIceMockServer).start();
        new Thread(this::startIceMockServerp).start();
        TimeUnit.DAYS.sleep(1);
//        winForm.clickByText("Next");
//        winForm.newPage();
//        winForm.clickById("btnLogin");
//        winForm.selectComboboxById("combUid","sa");
//        winForm.inputTextById("TxtPasswd","888888");
//        winForm.clickById("btnLogin");
//        winForm.clickById("Editor");
//        winForm.clickById("Process Recipe");
    }

    @SneakyThrows
    private void startIceMockServer() {
        //AppEntrance
        RemoteAppEntrance remoteAppEntrance = spy(new RemoteAppEntranceI());
        //Callback manager
        RemoteCallbackManager remoteCallbackManager = spy(new RemoteCallbackManagerI());
        //logfile
        RemoteLogFileManager remoteLogFileManager = spy(new RemoteLogFileManagerI());
        //datalog
        RemoteDataLogManager remoteDataLogManager = spy(new RemoteDataLogManagerI());
        //setup manager
        RemoteSetupManager remoteSetupManager = spy(new RemoteSetupManagerI());
        //interlock manager
        RemoteInterlockManager remoteInterlockManager = spy(new RemoteInterlockManagerI());
        //Alarm manager
        RemoteAlarmManager remoteAlarmManager = spy(new RemoteAlarmManagerI());
        //Batch reader
        RemoteBatchReader remoteBatchReader = spy(new RemoteBatchReaderI());
        //RecipeUser
        RemoteRecipeUser remoteRecipeUser = spy(new RemoteRecipeUserI());
        //ControlObject
        RemoteControlObject remoteControlObject = spy(new RemoteControlObjectI());
        //Data
        RemoteData remoteData = spy(new RemoteDataI());

        ObjectAdapter objectAdapter = communicator.createObjectAdapterWithEndpoints("Mock Server", "default -p 20001");

        objectAdapter.add(remoteAppEntrance, Util.stringToIdentity("RemoteAppEntrance"));
        objectAdapter.add(remoteCallbackManager, Util.stringToIdentity("RemoteCallbackManager"));
        objectAdapter.add(remoteLogFileManager, Util.stringToIdentity("RemoteLogFileManager"));
        objectAdapter.add(remoteDataLogManager, Util.stringToIdentity("RemoteDataLogManager"));
        objectAdapter.add(remoteSetupManager, Util.stringToIdentity("RemoteSetupManager"));
        objectAdapter.add(remoteInterlockManager, Util.stringToIdentity("RemoteInterlockManager"));
        objectAdapter.add(remoteAlarmManager, Util.stringToIdentity("RemoteAlarmManager"));
        objectAdapter.add(remoteBatchReader, Util.stringToIdentity("RemoteBatchReader"));
        objectAdapter.add(remoteRecipeUser, Util.stringToIdentity("RemoteRecipeUser"));
        objectAdapter.add(remoteControlObject, Util.stringToIdentity("RemoteControlObject"));
        objectAdapter.add(remoteData, Util.stringToIdentity("RemoteData"));

        doReturn(RemoteCallbackType.BIDIRECTION).when(remoteCallbackManager).getType();
        doReturn(new String[]{"LightTower_Red", "LightTower_Yellow", "LightTower_Green", "LightTower_Blue", "LightTower_White"}).when(remoteAppEntrance).getNamespaceNodesUnder(eq("/Control/TMCExports/Datas"), any(Current.class));

        doAnswer(invocationOnMock -> {
            Etch1LowerSteps.remoteObjectType = RemoteObjectType.DATA;
            return new String[0];
        }).when(remoteAppEntrance).getNamespaceNodesUnder(eq("LightTower_Red"), any(Current.class));
        doAnswer(invocationOnMock -> {
            Etch1LowerSteps.remoteObjectType = RemoteObjectType.DATA;
            return new String[0];
        }).when(remoteAppEntrance).getNamespaceNodesUnder(eq("LightTower_Yellow"), any(Current.class));
        doAnswer(invocationOnMock -> {
            Etch1LowerSteps.remoteObjectType = RemoteObjectType.DATA;
            return new String[0];
        }).when(remoteAppEntrance).getNamespaceNodesUnder(eq("LightTower_Green"), any(Current.class));
        doAnswer(invocationOnMock -> {
            Etch1LowerSteps.remoteObjectType = RemoteObjectType.DATA;
            return new String[0];
        }).when(remoteAppEntrance).getNamespaceNodesUnder(eq("LightRower_Blue"), any(Current.class));
        doAnswer(invocationOnMock -> {
            Etch1LowerSteps.remoteObjectType = RemoteObjectType.DATA;
            return new String[0];
        }).when(remoteAppEntrance).getNamespaceNodesUnder(eq("LightTower_White"), any(Current.class));

        objectAdapter.activate();
        communicator.waitForShutdown();
    }

    private void startIceMockServerp() {
        //AppEntrance
        RemoteAppEntrance remoteAppEntrance = spy(new RemoteAppEntranceI());
        //Callback manager
        RemoteCallbackManager remoteCallbackManager = spy(new RemoteCallbackManagerI());
        //logfile
        RemoteLogFileManager remoteLogFileManager = spy(new RemoteLogFileManagerI());
        //datalog
        RemoteDataLogManager remoteDataLogManager = spy(new RemoteDataLogManagerI());
        //setup manager
        RemoteSetupManager remoteSetupManager = spy(new RemoteSetupManagerI());
        //interlock manager
        RemoteInterlockManager remoteInterlockManager = spy(new RemoteInterlockManagerI());
        //Alarm manager
        RemoteAlarmManager remoteAlarmManager = spy(new RemoteAlarmManagerI());
        //Batch reader
        RemoteBatchReader remoteBatchReader = spy(new RemoteBatchReaderI());
        //RecipeUser
        RemoteRecipeUser remoteRecipeUser = spy(new RemoteRecipeUserI());
        //ControlObject
        RemoteControlObject remoteControlObject = spy(new RemoteControlObjectI());
        //Data
        RemoteData remoteData = spy(new RemoteDataI());

        ObjectAdapter objectAdapter = communicator.createObjectAdapterWithEndpoints("Mock Server PM", "default -p 20002");

        objectAdapter.add(remoteAppEntrance, Util.stringToIdentity("RemoteAppEntrance"));
        objectAdapter.add(remoteCallbackManager, Util.stringToIdentity("RemoteCallbackManager"));
        objectAdapter.add(remoteLogFileManager, Util.stringToIdentity("RemoteLogFileManager"));
        objectAdapter.add(remoteDataLogManager, Util.stringToIdentity("RemoteDataLogManager"));
        objectAdapter.add(remoteSetupManager, Util.stringToIdentity("RemoteSetupManager"));
        objectAdapter.add(remoteInterlockManager, Util.stringToIdentity("RemoteInterlockManager"));
        objectAdapter.add(remoteAlarmManager, Util.stringToIdentity("RemoteAlarmManager"));
        objectAdapter.add(remoteBatchReader, Util.stringToIdentity("RemoteBatchReader"));
        objectAdapter.add(remoteRecipeUser, Util.stringToIdentity("RemoteRecipeUser"));
        objectAdapter.add(remoteControlObject, Util.stringToIdentity("RemoteControlObject"));
        objectAdapter.add(remoteData, Util.stringToIdentity("RemoteData"));

        doReturn(RemoteCallbackType.BIDIRECTION).when(remoteCallbackManager).getType();

        doAnswer(invocationOnMock -> {
            Etch1LowerSteps.remoteObjectType = RemoteObjectType.DATA;
            return new String[]{"GasLineNum"};
        }).when(remoteAppEntrance).getNamespaceNodesUnder(eq("/Control/PMCExports/Datas"), any(Current.class));
        doAnswer(invocationOnMock -> {
            Etch1LowerSteps.remoteObjectType = RemoteObjectType.DATA;
            return new String[]{"CounterManager"};
        }).when(remoteAppEntrance).getNamespaceNodesUnder(eq("/Control/PMCExports/Controls"), any(Current.class));

        doAnswer(invocationOnMock -> {
            RemoteRecipeInfoHolder holder = invocationOnMock.getArgument(1);
            RemoteRecipeInfo remoteRecipeInfo = new RemoteRecipeInfo();
            StepInfo stepinfo = new StepInfo();
            stepinfo.name = "step01";
            stepinfo.values = new String[]{"10"};
            RemoteProcessRcpInfo rcpBodyInfo = new RemoteProcessRcpInfo(new StepInfo[]{stepinfo});
            remoteRecipeInfo.rcpClass = "/Process";
            remoteRecipeInfo.name = "test0";
            remoteRecipeInfo.body = rcpBodyInfo;
            remoteRecipeInfo.version = "1";
            remoteRecipeInfo.approvalLvl = 0;
            remoteRecipeInfo.bodyLength = 1;
            remoteRecipeInfo.comments = "comment#01";
            remoteRecipeInfo.editedBy = "ss";
            remoteRecipeInfo.attrChgTime = "20220101120000";
            remoteRecipeInfo.editTime = "20220101120000";
            holder.value = remoteRecipeInfo;
            return true;
        }).when(remoteRecipeUser).getRecipeInfo(eq("/Process/test0;1"), any(RemoteRecipeInfoHolder.class), any(Current.class));


        objectAdapter.activate();
        communicator.waitForShutdown();
    }

    public static class Server extends Ice.Application {

        @Override
        public int run(String[] strings) {
            return 0;
        }

        public static void main(String[] args) {
            Server app = new Server();
            int status = app.main("Mock Server", args);
            System.exit(status);
        }
    }

    public static class RemoteAppEntranceI extends _RemoteAppEntranceDisp {


        @Override
        public void shutdown(Current __current) {

        }

        @Override
        public RemoteDataPrx getData(String name, Current __current) {

            Identity identity = new Identity();
            identity.name = name;
            identity.category = "Data";

            if (__current.adapter.find(identity) == null) {
                return RemoteDataPrxHelper.uncheckedCast(__current.adapter.add(spy(new NamedRemoteDataI(name)), identity));
            }
            return RemoteDataPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public boolean subData(Identity id, StringHolder err, Current __current) {
            return true;
        }

        @Override
        public void unsubData(Identity id, Current __current) {

        }

        @Override
        public RemoteBatchReaderPrx getBatchReader(Current __current) {
            Identity identity = new Identity();
            identity.name = "RemoteBatchReader";
            return RemoteBatchReaderPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public RemoteCallbackManagerPrx getCallbackManager(Current __current) {
            Identity identity = new Identity();
            identity.name = "RemoteCallbackManager";
            return RemoteCallbackManagerPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public RemoteControlObjectPrx getControlObject(String name, Current __current) {
            Identity identity = new Identity();
            identity.name = "RemoteControlObject";
            return RemoteControlObjectPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public boolean subCtrlState(Identity id, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public void unsubCtrlState(Identity id, Current __current) {

        }

        @Override
        public void abortAllCtrlServices(Current __current) {

        }

        @Override
        public RemoteAlarmManagerPrx getAlarmManager(Current __current) {
            Identity identity = new Identity();
            identity.name = "RemoteAlarmManager";
            return RemoteAlarmManagerPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public RemoteInterlockManagerPrx getInterlockManager(Current __current) {
            Identity identity = new Identity();
            identity.name = "RemoteInterlockManager";
            return RemoteInterlockManagerPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public RemoteRecipeUserPrx createRecipeUser(Identity id, Current __current) {
            Identity identity = new Identity();
            identity.name = "RemoteRecipeUser";
            return RemoteRecipeUserPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public void deleteRecipeUser(Identity id, Current __current) {
        }

        @Override
        public String[] getNamespaceNodesUnder(String parent, Current __current) {
            return new String[]{};
        }

        @Override
        public RemoteObjectType objectRTTI(String name, Current __current) {
            return remoteObjectType;
        }

        @Override
        public RemoteLogFileManagerPrx getLogFileManager(Current __current) {
            Identity identity = new Identity();
            identity.name = "RemoteLogFileManager";
            return RemoteLogFileManagerPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public RemoteDataLogManagerPrx getDataLogManager(Current __current) {
            Identity identity = new Identity();
            identity.name = "RemoteDataLogManager";
            return RemoteDataLogManagerPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public RemoteSetupManagerPrx getSetupManager(Current __current) {
            Identity identity = new Identity();
            identity.name = "RemoteSetupManager";
            return RemoteSetupManagerPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public String getInfo(Current __current) {
            return null;
        }

        @Override
        public void clearDataCtrlSubs(String category, Current __current) {
        }
    }

    public static class RemoteCallbackManagerI extends _RemoteCallbackManagerDisp {

        @Override
        public boolean createCallback(Identity id, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean createCallbacks(Identity[] ids, Current __current) {
            return true;
        }

        @Override
        public boolean refreshCallbacks(String categroy, Current __current) {
            return false;
        }

        @Override
        public void deleteCallbacks(String category, Current __current) {
        }

        @Override
        public RemoteCallbackType getType(Current __current) {
            return RemoteCallbackType.BIDIRECTION;
        }
    }

    public static class RemoteLogFileManagerI extends _RemoteLogFileManagerDisp {
        @Override
        public boolean getAllFilesIndex(LogDate fromDate, LogDate toDate, LogFilesIndexHolder filesIndex, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public int loadLogFile(String fileName, boolean refresh, Current __current) {
            return 0;
        }

        @Override
        public int getLogFileSize(String fileName, Current __current) {
            return 0;
        }

        @Override
        public int getPackageNum(Current __current) {
            return 0;
        }

        @Override
        public boolean getNextPackage(LogPackageHolder nextPackage, Current __current) {
            return false;
        }

        @Override
        public boolean getPreviousPackage(LogPackageHolder prePackage, Current __current) {
            return false;
        }

        @Override
        public void getHeadPackage(LogPackageHolder headPackage, Current __current) {
        }

        @Override
        public void getTailPackage(LogPackageHolder tailPackage, Current __current) {
        }

        @Override
        public boolean isTopmost(Current __current) {
            return false;
        }

        @Override
        public boolean isEndmost(Current __current) {
            return false;
        }

        @Override
        public void freezeCursor(Current __current) {
        }

        @Override
        public void releaseCursor(Current __current) {
        }
    }

    public static class RemoteDataLogManagerI extends _RemoteDataLogManagerDisp {

        @Override
        public String[] getAllDataLoggerIDs(Current __current) {
            return new String[0];
        }

        @Override
        public boolean startDataLogger(String id, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public void stopDataLogger(String id, Current __current) {

        }

        @Override
        public RemoteDataLoggerInfo getDataLoggerInfo(String id, Current __current) {
            return null;
        }

        @Override
        public RemoteDataLoggerInfo[] getAllDataLoggerInfos(Current __current) {
            return new RemoteDataLoggerInfo[0];
        }

        @Override
        public RemoteDBType getDBType(Current __current) {
            return null;
        }
    }

    public static class RemoteSetupManagerI extends _RemoteSetupManagerDisp {
        @Override
        public String[] getAllSetupNames(Current __current) {
            return new String[0];
        }

        @Override
        public boolean loadAllSetups(int index, Current __current) {
            return false;
        }

        @Override
        public boolean saveAllSetups(int index, Current __current) {
            return false;
        }

        @Override
        public boolean addSetupDftOption(String name, Current __current) {
            return false;
        }

        @Override
        public boolean addSetupOption(String name, String[] values, Current __current) {
            return false;
        }

        @Override
        public void rmSetupOption(String name, int index, Current __current) {

        }

        @Override
        public boolean saveSetupToXML(String name, Current __current) {
            return false;
        }

        @Override
        public boolean loadFromSetup(String name, int index, Current __current) {
            return false;
        }

        @Override
        public boolean saveToSetup(String name, int index, Current __current) {
            return false;
        }

        @Override
        public int getSetupOptionNum(String name, Current __current) {
            return 0;
        }

        @Override
        public RemoteParamInfo[] getSetupAllParams(String name, Current __current) {
            return new RemoteParamInfo[0];
        }

        @Override
        public String[] getSetupOptionValues(String name, int index, Current __current) {
            return new String[0];
        }

        @Override
        public boolean setSetupValue(String name, int optIndex, String paramName, String value, Current __current) {
            return false;
        }

        @Override
        public boolean setSetupComment(String name, String comment, Current __current) {
            return false;
        }

        @Override
        public String getSetupComment(String name, Current __current) {
            return null;
        }
    }

    public static class RemoteInterlockManagerI extends _RemoteInterlockManagerDisp {

        @Override
        public RemoteInterlockInfo getInterlockInfo(String id, Current __current) {
            return null;
        }

        @Override
        public RemoteInterlockInfo[] getAllInterlockInfos(Current __current) {
            return new RemoteInterlockInfo[0];
        }

        @Override
        public boolean isActive(String id, Current __current) {
            return false;
        }

        @Override
        public boolean activate(String id, Current __current) {
            return false;
        }

        @Override
        public boolean deactivate(String id, Current __current) {
            return false;
        }
    }

    public static class RemoteAlarmManagerI extends _RemoteAlarmManagerDisp {

        @Override
        public RemoteAlarmInfo getAlarmInfo(String alarmId, Current __current) {
            return null;
        }

        @Override
        public RemoteAlarmInfo[] getAllAlarmInfos(Current __current) {
            return new RemoteAlarmInfo[0];
        }

        @Override
        public boolean recoverAlarm(String alarmId, int recoveryPos, Current __current) {
            return false;
        }

        @Override
        public String[] getAllPostedAlarms(Current __current) {
            return new String[0];
        }

        @Override
        public String[] getAllAlarms(Current __current) {
            return new String[0];
        }

        @Override
        public boolean subAlarmEvent(Identity id, RemoteAlarmSeverity severity, Current __current) {
            return false;
        }

        @Override
        public boolean subRecoveryEvent(Identity id, RemoteAlarmSeverity severity, Current __current) {
            return false;
        }

        @Override
        public boolean subAlarmAndRecovery(Identity id, RemoteAlarmSeverity severity, Current __current) {
            return false;
        }

        @Override
        public void unsubscribe(Identity id, Current __current) {

        }
    }

    public static class RemoteBatchReaderI extends _RemoteBatchReaderDisp {
        @Override
        public boolean initialize(String[] dataNames, Current __current) {
            return true;
        }

        @Override
        public RemoteValueInfo[] read(Current __current) {
            return new RemoteValueInfo[0];
        }
    }

    public static class RemoteRecipeUserI extends _RemoteRecipeUserDisp {

        @Override
        public String[] getAllRecipes(Current __current) {
            return new String[]{"/Process/test0;1"};
        }

        @Override
        public String[] getAllRcpClasses(Current __current) {
            return new String[]{"/DryClean", "/Process"};
        }

        @Override
        public boolean getRecipeInfo(String rcpID, RemoteRecipeInfoHolder rcpInfo, Current __current) {
            rcpInfo.value = new com.naura.ctc.IComRecipe.RemoteRecipeInfo();
            return true;
        }

        @Override
        public boolean getRcpClassInfo(String fullName, RemoteRcpClassInfoHolder clsInfo, Current __current) {
            com.naura.ctc.IComRecipe.RemoteDoubleParamInfo a = new com.naura.ctc.IComRecipe.RemoteDoubleParamInfo("ProcessTime", "", "0", RemoteDataType.DOUBLEDATA, new RemoteDoubleTypeInfo(0, 360000, "sec", 0.1));
            com.naura.ctc.IComRecipe.RemoteDoubleParamInfo[] params = new com.naura.ctc.IComRecipe.RemoteDoubleParamInfo[]{a};
            clsInfo.value = new com.naura.ctc.IComRecipe.RemoteRcpClassInfo(params, new String[]{"/Process/test0;1"});//newString-->>"/Process/test0;1"
            return true;
        }

        @Override
        public boolean registerRcpClass(String fullName, RemoteParamInfo[] params, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean removeRcpClass(String fullName, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean registerRecipe(RemoteRecipeInfo rcpInfo, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean removeRecipe(String rcpID, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean storeRcpBody(String rcpID, RemoteRcpBodyInfo body, boolean ow, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean setRcpApprovalLvl(String rcpID, int level, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean setRcpEditor(String rcpID, String editor, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean setRcpComments(String rcpID, String comments, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public int getNamespaceROLvl(Current __current) {
            return 0;
        }

        @Override
        public boolean subscribe(Current __current) {
            return false;
        }

        @Override
        public void unsubscribe(Current __current) {

        }

        @Override
        public boolean retrieveExclRcp(String rcpID, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean addExclRcpDeftStep(String rcpID, String name, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean addExclRcpStep(String rcpID, String name, String[] values, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean removeExclRcpStep(String rcpID, int index, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean setExclRcpStepValue(String rcpID, int stepIndex, String paramName, String value, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean setExclRcpStepName(String rcpID, int index, String name, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean setExclRcpEditor(String rcpID, String editor, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean setExclRcpComments(String rcpID, String comments, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean storeExclRcp(String rcpID, boolean ow, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public boolean releaseExclRcp(String rcpID, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public void clear(Current __current) {

        }

        @Override
        public boolean selectRecipe(String rcpID, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public void deselectRecipe(String rcpID, Current __current) {

        }
    }

    public static class RemoteControlObjectI extends _RemoteControlObjectDisp {

        @Override
        public RemoteServiceInfo[] getServiceInfos(Current __current) {
            return new RemoteServiceInfo[0];
        }

        @Override
        public RemoteControlState getState(Current __current) {
            return null;
        }

        @Override
        public void runService(String name, String params, RemoteServiceResultHolder ret, StringHolder err, Current __current) {

        }

        @Override
        public boolean reset(Current __current) {
            return false;
        }

        @Override
        public void abortService(Current __current) {

        }
    }

    public static class RemoteDataI extends _RemoteDataDisp {

        @Override
        public boolean setValue(String value, StringHolder err, Current __current) {
            return false;
        }

        @Override
        public RemoteValueInfo getValue(Current __current) {
            RemoteStringValueInfo remoteValueInfo = new RemoteStringValueInfo();
            remoteValueInfo.type = RemoteDataType.STRINGDATA;
            remoteValueInfo.validity = RemoteValidity.VALID;
            remoteValueInfo.value = "5";
            return remoteValueInfo;
        }

        @Override
        public RemoteDataInfo getInfo(Current __current) {
            return null;
        }
    }

    public static class NamedRemoteDataI extends RemoteDataI {
        private final String name;

        public NamedRemoteDataI(String name) {
            this.name = name;
        }

        @Override
        public RemoteValueInfo getValue(Current __current) {
            if ("/Control/PMCExports/Datas/ProcessMonitor_RecipeSetpointNumforCTC".equals(name)) {
                RemoteIntValueInfo remoteValueInfo = new RemoteIntValueInfo();
                remoteValueInfo.type = RemoteDataType.INTDATA;
                remoteValueInfo.value = 1;//代表参数模板规格，不包括Stepname
                return remoteValueInfo;
            }
            return super.getValue(__current);
        }
    }
}

