package com.naura.test.api.api;

import Ice.*;
import com.github.leeonky.dal.extensions.SFtp;
import com.naura.test.ice.IComAppEntrance.RemoteAppEntrancePrx;
import com.naura.test.ice.IComControlObject.RemoteControlObjectPrx;
import com.naura.test.ice.IComData.RemoteDataPrx;
import com.naura.test.api.LowerConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.naura.test.ice.IComAppEntrance.RemoteAppEntrancePrxHelper.checkedCast;

@Service
public class LowerApi {
    private Communicator ic;
    private RemoteAppEntrancePrx remoteAppEntrancePrx;
    private LowerConnection lowerConnection;
    @Value("${filedir.lower}")
    private String lowerDir;

    public void connect(LowerConnection lowerConnection) {
        this.lowerConnection = lowerConnection;
        Properties properties = Util.createProperties();
        properties.setProperty("Ice.Default.Package", RemoteAppEntrancePrx.class.getName()
                .replace(".IComAppEntrance.RemoteAppEntrancePrx", ""));
        InitializationData initializationData = new InitializationData();
        initializationData.properties = properties;
        ic = Util.initialize(initializationData);
        remoteAppEntrancePrx = checkedCast(ic.stringToProxy(lowerConnection.remoteAppEntrance()));
    }

    public void cleanAlarm() {
        alarmapi().test().cleanAlarm();
    }

    public void deactivateAllInterlock() {
        for (String poster : alarmapi().test().getAllPoster()) {
            interlockApi().anywaydeactivate(poster);
        }
    }

    public void close() {
        if (ic != null) {
            ic.destroy();
            ic = null;
        }
    }

    public RecipeApi recipe() {
        return new RecipeApi(remoteAppEntrancePrx.createRecipeUser(new Identity("SCOPE_Recipe", "NID<PVD>::PVDEMC")));
    }

    public SetUpApi setUp() {
        return new SetUpApi(remoteAppEntrancePrx.getSetupManager());
    }

    public IOApi io() {
        return new IOApi(remoteAppEntrancePrx);
    }

    public AlarmApi alarmapi() {
        return new AlarmApi(remoteAppEntrancePrx.getAlarmManager());
    }

    public InterlockApi interlockApi() {
        return new InterlockApi(remoteAppEntrancePrx.getInterlockManager());
    }

    public SFtp remoteFolder() {
        return new SFtp(lowerConnection.getHost(), "22", "root", "888888", lowerDir);
    }

    public RemoteControlObjectPrx remocteControlObject(String name) {
        return remoteAppEntrancePrx.getControlObject(name);
    }

    public RemoteDataPrx remoteData(String name) {
        return remoteAppEntrancePrx.getData(name);
    }
}
