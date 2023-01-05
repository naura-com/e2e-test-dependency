package com.naura.test.specs.slice;

import com.github.leeonky.jfactory.Spec;
import com.naura.pvd.IComData.RemoteDoubleTypeInfo;
import com.naura.pvd.IComData.RemoteIntTypeInfo;
import com.naura.pvd.IComData.RemoteStringTypeInfo;

public class RemoteDataTypeInfos {
    public static class StringTypeInfo extends Spec<RemoteStringTypeInfo> {

        @Override
        public void main() {
            property("maxLength").value(100);
        }
    }

    public static class IntTypeInfo extends Spec<RemoteIntTypeInfo> {
        @Override
        public void main() {
            property("min").value(Integer.MIN_VALUE);
            property("max").value(Integer.MAX_VALUE);
        }
    }

    public static class DoubleTypeInfo extends Spec<RemoteDoubleTypeInfo> {
        @Override
        public void main() {
            property("min").value(Double.MIN_VALUE);
            property("max").value(Double.MAX_VALUE);
            property("accuracy").value(0.1);
            property("unit").value("sccm");
        }
    }
}
