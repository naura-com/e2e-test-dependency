package com.naura.test.specs.slice;

import com.github.leeonky.jfactory.Spec;
import com.github.leeonky.jfactory.Trait;
import com.naura.pvd.IComRecipe.RemoteProcessRcpInfo;
import com.naura.pvd.IComRecipe.RemoteRcpClassInfo;
import com.naura.pvd.IComRecipe.RemoteRecipeInfo;
import com.naura.pvd.IComRecipe.StepInfo;
import com.naura.test.config.ContextWrapper;
import com.naura.test.lower.api.LowerApi;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.Arrays.stream;

public class Recipes {
    public static class Recipe extends Spec<RemoteRecipeInfo> {

        @Autowired
        private LowerApi lowerApi;

        @Override
        public void main() {
            property("approvalLvl").value(0);
        }

        @Trait
        public void defaultRcp() {
            property("body").dependsOn("rcpClass", input -> {
                String rcpClass = (String) input;
                LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
                RemoteRcpClassInfo remoteRcpClassInfo = api.recipe().getRcpClassInfo(rcpClass);
                RemoteProcessRcpInfo remoteProcessRcpInfo = new RemoteProcessRcpInfo();
                StepInfo[] stepInfo = new StepInfo[1];
                StepInfo step = new StepInfo();
                step.name = "1";
                step.values = stream(remoteRcpClassInfo.params).map(RemoteParamInfo -> RemoteParamInfo.defaultValue).toArray(String[]::new);
                stepInfo[0] = step;
                remoteProcessRcpInfo.steps = stepInfo;
                return remoteProcessRcpInfo;
            });
        }

        @Trait
        public void defaultEtch1Rcp() {
            property("body").dependsOn("rcpClass", input -> {
                String rcpClass = (String) input;
                LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
                RemoteRcpClassInfo remoteRcpClassInfo = api.recipe().getRcpClassInfo(rcpClass);
                RemoteProcessRcpInfo remoteProcessRcpInfo = new RemoteProcessRcpInfo();
                StepInfo[] stepInfo = new StepInfo[1];
                StepInfo step = new StepInfo();
                step.name = "dechuck";
                step.values = stream(remoteRcpClassInfo.params).map(RemoteParamInfo -> RemoteParamInfo.defaultValue).toArray(String[]::new);

                int processTimeIndex = 0;
                int waferTypeIndex = 0;
                int pressureIndex = 0;
                for (int i = 0; i < remoteRcpClassInfo.params.length; i++) {
                    int j = 0;
                    String pName = remoteRcpClassInfo.params[i].name;
                    if (pName.equals("ProcessTime")) {
                        processTimeIndex = i;
                        j++;
                        if (j == 3) {
                            break;
                        }
                    } else if (pName.equals("WaferType")) {
                        waferTypeIndex = i;
                        j++;
                        if (j == 3) {
                            break;
                        }
                    } else if (pName.equals("Pressure(mT)")) {
                        pressureIndex = i;
                        j++;
                        if (j == 3) {
                            break;
                        }
                    }
                }
                step.values[processTimeIndex] = "2";
                step.values[waferTypeIndex] = "Si";
                step.values[pressureIndex] = "1";

                stepInfo[0] = step;
                remoteProcessRcpInfo.steps = stepInfo;
                return remoteProcessRcpInfo;
            });
        }
    }
}
