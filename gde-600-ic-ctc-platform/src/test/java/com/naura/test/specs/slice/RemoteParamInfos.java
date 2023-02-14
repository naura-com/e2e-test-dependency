package com.naura.test.specs.slice;

import com.github.leeonky.jfactory.Spec;
import com.naura.test.ice.IComData.RemoteDataType;
import com.naura.test.ice.IComRecipe.RemoteDoubleParamInfo;
import com.naura.test.ice.IComRecipe.RemoteIntParamInfo;
import com.naura.test.ice.IComRecipe.RemoteStringParamInfo;

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
