package com.naura.test.ctclower.api;

import Ice.*;
import com.github.leeonky.dal.extensions.SFtp;
import com.naura.ctc.IComAppEntrance.RemoteAppEntrancePrx;
import com.naura.ctc.IComControlObject.RemoteControlObjectPrx;
import com.naura.ctc.IComData.RemoteDataPrx;
import com.naura.test.lower.LowerConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static com.naura.ctc.IComAppEntrance.RemoteAppEntrancePrxHelper.checkedCast;

@Service
public class CtcLowerApi {
    private Communicator ic;
    private RemoteAppEntrancePrx remoteAppEntrancePrx;
    private LowerConnection lowerConnection;
    @Value("${filedir.lower1}")
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

    public CtcRecipeApi recipe() {
        return new CtcRecipeApi(remoteAppEntrancePrx.createRecipeUser(new Identity("SCOPE_Recipe", "NID<PVD>::PVDEMC")));
    }

    public CtcSetUpApi setUp() {
        return new CtcSetUpApi(remoteAppEntrancePrx.getSetupManager());
    }

    public CtcIOApi io() {
        return new CtcIOApi(remoteAppEntrancePrx);
    }

    public CtcAlarmApi alarmapi() {
        return new CtcAlarmApi(remoteAppEntrancePrx.getAlarmManager());
    }

    public CtcInterlockApi interlockApi() {
        return new CtcInterlockApi(remoteAppEntrancePrx.getInterlockManager());
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
