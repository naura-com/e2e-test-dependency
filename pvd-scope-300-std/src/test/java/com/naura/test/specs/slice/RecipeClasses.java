package com.naura.test.specs.slice;

import com.github.leeonky.jfactory.Spec;
import com.naura.test.ice.IComRecipe.RemoteParamInfo;

public class RecipeClasses {
    public static class RecipeClass extends Spec<RecipeClassParam> {
        @Override
        public void main() {
            property("params[0]").is(RemoteParamInfos.StringParam.class);
        }
    }

    public static class RecipeClassParam {
        public String name;
        public RemoteParamInfo[] params;
    }
}
