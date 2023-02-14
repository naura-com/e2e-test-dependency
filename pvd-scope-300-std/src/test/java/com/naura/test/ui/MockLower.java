package com.naura.test.ui;

import Ice.*;
import com.naura.test.ice.IComAlarm.*;
import com.naura.test.ice.IComAppEntrance.*;
import com.naura.test.ice.IComControlObject.RemoteControlObjectPrx;
import com.naura.test.ice.IComControlObject.RemoteControlObjectPrxHelper;
import com.naura.test.ice.IComControlObject._RemoteControlObjectDisp;
import com.naura.test.ice.IComData.*;
import com.naura.test.ice.IComDataLog.*;
import com.naura.test.ice.IComInterlock.*;
import com.naura.test.ice.IComRecipe.*;
import com.naura.test.ice.IComSetup.RemoteSetupManager;
import com.naura.test.ice.IComSetup.RemoteSetupManagerPrx;
import com.naura.test.ice.IComSetup.RemoteSetupManagerPrxHelper;
import com.naura.test.ice.IComSetup._RemoteSetupManagerDisp;
import com.naura.test.ice.IComSysLog.*;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

@Service
public class MockLower {
    @Deprecated
    public final RemoteRecipeUser remoteRecipeUser = Mockito.spy(new RemoteRecipeUserI());
    public Map<String, _RemoteControlObjectDisp> stubRemoteControlObject = new HashMap<>();
    Communicator communicator;
    Thread thread;

    @NotNull
    public static Communicator createCommunicator() {
        Properties properties = Util.createProperties();
        properties.setProperty("Ice.Default.Package", RemoteAppEntrancePrx.class.getName()
                .replace(".IComAppEntrance.RemoteAppEntrancePrx", ""));
        InitializationData initializationData = new InitializationData();
        initializationData.properties = properties;
        return Util.initialize(initializationData);
    }

    void startIceMockServer(String port) {
        RemoteAppEntrance remoteAppEntrance = spy(new RemoteAppEntranceI());
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
        //Data
        //RecipeUser
        communicator = createCommunicator();
        ObjectAdapter objectAdapter = communicator.createObjectAdapterWithEndpoints("Mock Server", "default -p " + port);

        objectAdapter.add(remoteAppEntrance, Util.stringToIdentity("RemoteAppEntrance"));
        objectAdapter.add(remoteCallbackManager, Util.stringToIdentity("RemoteCallbackManager"));
        objectAdapter.add(remoteLogFileManager, Util.stringToIdentity("RemoteLogFileManager"));
        objectAdapter.add(remoteDataLogManager, Util.stringToIdentity("RemoteDataLogManager"));
        objectAdapter.add(remoteSetupManager, Util.stringToIdentity("RemoteSetupManager"));
        objectAdapter.add(remoteInterlockManager, Util.stringToIdentity("RemoteInterlockManager"));
        objectAdapter.add(remoteAlarmManager, Util.stringToIdentity("RemoteAlarmManager"));
        objectAdapter.add(remoteBatchReader, Util.stringToIdentity("RemoteBatchReader"));
        objectAdapter.add(remoteRecipeUser, Util.stringToIdentity("RemoteRecipeUser"));

        doReturn(RemoteCallbackType.BIDIRECTION).when(remoteCallbackManager).getType();

        objectAdapter.activate();
        communicator.waitForShutdown();
        objectAdapter.deactivate();
        objectAdapter.waitForDeactivate();
    }

    public void start() {
        thread = new Thread(() -> startIceMockServer("10000"));
        thread.start();
    }

    public void reset() {
        Mockito.reset(remoteRecipeUser);
    }

    @SneakyThrows
    public void stop() {
        if (communicator != null) {
            communicator.shutdown();
            thread.join();
            communicator.waitForShutdown();
            communicator.destroy();
            communicator = null;
        }
    }

    public void mockRemoteValueInfo(String name, RemoteValueInfo value) {
        stubRemoteValueInfo.put(name, value);
    }

    public class RemoteAppEntranceI extends _RemoteAppEntranceDisp {

        @Override
        public void shutdown(Current __current) {

        }

        @Override
        public RemoteDataPrx getData(String name, Current __current) {
            Identity identity = new Identity();
            identity.name = name;
            identity.category = "Data";

            if (__current.adapter.find(identity) == null) {
                return RemoteDataPrxHelper.uncheckedCast(__current.adapter.add(new NamedRemoteDataI(name), identity));
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
            identity.name = "RemoteCallbackManager";
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
            identity.name = name;
            identity.category = "ControlObject";
            if (__current.adapter.find(identity) == null)
                return RemoteControlObjectPrxHelper.uncheckedCast(__current.adapter.add(
                        stubRemoteControlObject.computeIfAbsent(name, key -> spy(_RemoteControlObjectDisp.class)), identity));
            return RemoteControlObjectPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public boolean subCtrlState(Identity id, StringHolder err, Current __current) {
            return true;
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
            return new String[0];
        }

        @Override
        public RemoteObjectType objectRTTI(String name, Current __current) {
            return RemoteObjectType.CTRL;
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
            identity.name = "RemoteDataLogManager";
            return RemoteSetupManagerPrxHelper.uncheckedCast(__current.adapter.createProxy(identity));
        }

        @Override
        public String getInfo(Current __current) {
            return "a";
        }

        @Override
        public void clearDataCtrlSubs(String category, Current __current) {
        }
    }

    public static class RemoteCallbackManagerI extends _RemoteCallbackManagerDisp {

        @Override
        public boolean createCallback(Identity id, StringHolder err, Current __current) {
            return true;
        }

        @Override
        public boolean createCallbacks(Identity[] ids, Current __current) {
            return false;
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
            return false;
        }

        @Override
        public RemoteValueInfo[] read(Current __current) {
            return new RemoteValueInfo[0];
        }
    }

    public static class RemoteRecipeUserI extends _RemoteRecipeUserDisp {
        @Override
        public String[] getAllRecipes(Current __current) {
            return new String[0];
        }

        @Override
        public String[] getAllRcpClasses(Current __current) {
            return new String[]{"/Ch1"};
        }

        @Override
        public boolean getRecipeInfo(String rcpID, RemoteRecipeInfoHolder rcpInfo, Current __current) {
            rcpInfo.value = new RemoteRecipeInfo();
            return true;
        }

        @Override
        public boolean getRcpClassInfo(String fullName, RemoteRcpClassInfoHolder clsInfo, Current __current) {
            RemoteParamInfo a = new RemoteParamInfo("step", "dataObj", "1", RemoteDataType.STRINGDATA);
            RemoteParamInfo[] params = new RemoteParamInfo[]{a};
            clsInfo.value = new RemoteRcpClassInfo(params, new String[0]);
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
            return true;
        }

        @Override
        public boolean removeRecipe(String rcpID, StringHolder err, Current __current) {
            return true;
        }

        @Override
        public boolean storeRcpBody(String rcpID, RemoteRcpBodyInfo body, boolean ow, StringHolder err, Current __current) {
            return true;
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
            return true;
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

    public static class RemoteDataI extends _RemoteDataDisp {
        @Override
        public boolean setValue(String value, StringHolder err, Current __current) {
            return true;
        }

        @Override
        public RemoteValueInfo getValue(Current __current) {
            RemoteStringValueInfo remoteValueInfo = new RemoteStringValueInfo();
            remoteValueInfo.validity = RemoteValidity.VALID;
            remoteValueInfo.type = RemoteDataType.STRINGDATA;
            return remoteValueInfo;
        }

        @Override
        public RemoteDataInfo getInfo(Current __current) {
            RemoteDataInfo remoteDataInfo = new RemoteDataInfo();
            remoteDataInfo.accessMode = RemoteAccessMode.READONLY;
            remoteDataInfo.channelNum = 1;
            remoteDataInfo.nodeNum = 2;
            remoteDataInfo.isSimulated = true;
            remoteDataInfo.type = RemoteDataType.STRINGDATA;
            return remoteDataInfo;
        }
    }

    public Map<String, RemoteValueInfo> stubRemoteValueInfo = new HashMap<>();

    public class NamedRemoteDataI extends RemoteDataI {
        private final String name;

        public NamedRemoteDataI(String name) {
            this.name = name;
        }

        @Override
        public RemoteValueInfo getValue(Current __current) {
            if (stubRemoteValueInfo.containsKey(name))
                return stubRemoteValueInfo.get(name);
//            if ("/IO/Ch1Exports/Solenoid_V21DI".equals(name) || name.contains("/IO/LP1Exports/Slot") || name.contains("/IO/LP2Exports/Slot") || name.contains("/IO/LP3Exports/Slot")) {
//                RemoteIntValueInfo remoteValueInfo = new RemoteIntValueInfo();
//                remoteValueInfo.type = RemoteDataType.INTDATA;
//                remoteValueInfo.value = 1;//代表参数模板规格，不包括Stepname
//                remoteValueInfo.validity = RemoteValidity.VALID;
//                remoteValueInfo.descriptor = "PRESENT";
//                return remoteValueInfo;
//            }

            String reg = "/IO/.*Exports/Slot.*";
            Pattern p = Pattern.compile(reg);
            Matcher m = p.matcher(name);
            if (m.find()) {
                RemoteIntValueInfo remoteValueInfo = new RemoteIntValueInfo();
                remoteValueInfo.type = RemoteDataType.INTDATA;
                remoteValueInfo.value = 1;//代表参数模板规格，不包括Stepname
                remoteValueInfo.validity = RemoteValidity.VALID;
                remoteValueInfo.descriptor = "PRESENT";
                return remoteValueInfo;
            }

            return super.getValue(__current);
        }

        @Override
        public RemoteDataInfo getInfo(Current __current) {
            RemoteDataInfo remoteDataInfo = new RemoteDataInfo();
            remoteDataInfo.accessMode = RemoteAccessMode.READONLY;
            remoteDataInfo.channelNum = 1;
            remoteDataInfo.nodeNum = 2;
            remoteDataInfo.isSimulated = true;
            switch (name) {
                case "/IO/LP1Exports/PendingOffline":
                case "/IO/LP2Exports/PendingOffline":
                case "/IO/LP3Exports/PendingOffline":
                case "/IO/LAExports/PendingOffline":
                case "/IO/LBExports/PendingOffline":
                case "/IO/ChAExports/PendingOffline":
                case "/IO/ChBExports/PendingOffline":
                case "/IO/AlignerExports/PendingOffline":
                case "/IO/ChCExports/PendingOffline":
                case "/IO/ChEExports/PendingOffline":
                case "/IO/Ch2Exports/PendingOffline":
                case "/IO/Ch3Exports/PendingOffline":
                case "/IO/ATRExports/PendingOffline":
                case "/IO/VTR1Exports/PendingOffline":
                case "/IO/VTR2Exports/PendingOffline":
                case "/IO/LAExports/RcpStepCounter":
                case "/IO/LBExports/RcpStepCounter":
                case "/IO/ChAExports/RcpStepCounter":
                case "/IO/ChBExports/RcpStepCounter":
                case "/IO/ChCExports/RcpStepCounter":
                case "/IO/ChDExports/RcpStepCounter":
                case "/IO/ChEExports/RcpStepCounter":
                case "/IO/ChFExports/RcpStepCounter":
                case "/IO/Ch1Exports/RcpStepCounter":
                case "/IO/Ch2Exports/RcpStepCounter":
                case "/IO/Ch3Exports/RcpStepCounter":
                case "/IO/Ch4Exports/RcpStepCounter":
                case "/IO/Ch5Exports/RcpStepCounter":
                case "/IO/Ch6Exports/RcpStepCounter":
                    remoteDataInfo.type = RemoteDataType.INTDATA;
                    break;
                case "/IO/LAExports/RcpStepTimer":
                case "/IO/LBExports/RcpStepTimer":
                case "/IO/ChAExports/RcpStepTimer":
                case "/IO/ChBExports/RcpStepTimer":
                case "/IO/ChCExports/RcpStepTimer":
                case "/IO/ChDExports/RcpStepTimer":
                case "/IO/ChEExports/RcpStepTimer":
                case "/IO/ChFExports/RcpStepTimer":
                case "/IO/Ch1Exports/RcpStepTimer":
                case "/IO/Ch2Exports/RcpStepTimer":
                case "/IO/Ch3Exports/RcpStepTimer":
                case "/IO/Ch4Exports/RcpStepTimer":
                case "/IO/Ch5Exports/RcpStepTimer":
                case "/IO/Ch6Exports/RcpStepTimer":
                    remoteDataInfo.type = RemoteDataType.DOUBLEDATA;
                    break;
                default:
                    remoteDataInfo.type = RemoteDataType.STRINGDATA;
                    break;
            }
            return remoteDataInfo;
        }
    }
}