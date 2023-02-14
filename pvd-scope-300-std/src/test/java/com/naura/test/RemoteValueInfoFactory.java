package com.naura.test;

import com.naura.test.ice.IComData.RemoteDataType;
import com.naura.test.ice.IComData.RemoteIntValueInfo;
import com.naura.test.ice.IComData.RemoteStringValueInfo;
import com.naura.test.ice.IComData.RemoteValidity;

public class RemoteValueInfoFactory {

    public static RemoteIntValueInfo remoteIntValueInfo(int value) {
        RemoteIntValueInfo remoteValueInfo = new RemoteIntValueInfo();
        remoteValueInfo.type = RemoteDataType.INTDATA;
        remoteValueInfo.value = value;
        remoteValueInfo.validity = RemoteValidity.VALID;
        return remoteValueInfo;
    }

    public static RemoteStringValueInfo remoteStringValueInfo(String value) {
        RemoteStringValueInfo result = new RemoteStringValueInfo();
        result.type = RemoteDataType.STRINGDATA;
        result.value = value;
        result.validity = RemoteValidity.VALID;
        return result;
    }
}
