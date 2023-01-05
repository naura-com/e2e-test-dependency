package com.naura.test.specs.slice;

import com.github.leeonky.jfactory.Spec;
import com.naura.pvd.IComData.RemoteDataType;
import com.naura.pvd.IComRecipe.RemoteDoubleParamInfo;
import com.naura.pvd.IComRecipe.RemoteIntParamInfo;
import com.naura.pvd.IComRecipe.RemoteStringParamInfo;

public class RemoteParamInfos {
    public static class StringParam extends Spec<RemoteStringParamInfo> {

        @Override
        public void main() {
            property("type").value(RemoteDataType.STRINGDATA);
            property("typeInfo").is(RemoteDataTypeInfos.StringTypeInfo.class);
        }
    }

    public static class IntParam extends Spec<RemoteIntParamInfo> {

        @Override
        public void main() {
            property("type").value(RemoteDataType.INTDATA);
            property("typeInfo").is(RemoteDataTypeInfos.IntTypeInfo.class);
            property("defaultValue").value(0);
        }
    }

    public static class DoubleParam extends Spec<RemoteDoubleParamInfo> {

        @Override
        public void main() {
            property("type").value(RemoteDataType.DOUBLEDATA);
            property("typeInfo").is(RemoteDataTypeInfos.DoubleTypeInfo.class);
            property("defaultValue").value(0.1);
        }
    }
}
