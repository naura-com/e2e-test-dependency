package com.naura.test.specs.slice;

import com.github.leeonky.jfactory.Spec;
import com.github.leeonky.jfactory.Trait;
import com.naura.test.ice.IComRecipe.RemoteProcessRcpInfo;
import com.naura.test.ice.IComRecipe.RemoteRcpClassInfo;
import com.naura.test.ice.IComRecipe.RemoteRecipeInfo;
import com.naura.test.ice.IComRecipe.StepInfo;
import com.naura.test.api.api.LowerApi;
import com.naura.test.config.ContextWrapper;
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
        public void defaultEtch1Rcp_step1() {
            property("body").dependsOn("rcpClass", input -> {
                String rcpClass = (String) input;
                return etchRecipe(new String[]{"step1"}, rcpClass);
            });
        }

        @Trait
        public void defaultEtch1Rcp() {
            property("body").dependsOn("rcpClass", input -> {
                String rcpClass = (String) input;
                return etchRecipe(new String[]{"dechuck"}, rcpClass);
            });
        }

        @Trait
        public void defaultEtch1Rcp_dechuck() {
            property("body").dependsOn("rcpClass", input -> {
                String rcpClass = (String) input;
                return etchRecipe(new String[]{"dechuck"}, rcpClass);
            });
        }

        @Trait
        public void defaultEtch1Rcp_step1_step2() {
            property("body").dependsOn("rcpClass", input -> {
                String rcpClass = (String) input;
                return etchRecipe(new String[]{"step1", "step2"}, rcpClass);
            });
        }

        private RemoteProcessRcpInfo etchRecipe(String[] stepNames, String rcpClass) {
            LowerApi api = ContextWrapper.getApplicationContext().getBean(LowerApi.class);
            RemoteRcpClassInfo remoteRcpClassInfo = api.recipe().getRcpClassInfo(rcpClass);
            StepInfo[] stepInfo = new StepInfo[stepNames.length];
            for (int i = 0; i < stepNames.length; i++) {
                stepInfo[i] = etchStep(stepNames[i], remoteRcpClassInfo, rcpClass);
            }
            RemoteProcessRcpInfo remoteProcessRcpInfo = new RemoteProcessRcpInfo();
            remoteProcessRcpInfo.steps = stepInfo;
            return remoteProcessRcpInfo;
        }

        private StepInfo etchStep(String stepName, RemoteRcpClassInfo remoteRcpClassInfo, String rcpClass) {
            StepInfo step = new StepInfo();
            step.name = stepName;
            step.values = stream(remoteRcpClassInfo.params).map(RemoteParamInfo -> RemoteParamInfo.defaultValue).toArray(String[]::new);

            if (rcpClass.equals("/Process")) {
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
            }

            return step;
        }
    }
}
