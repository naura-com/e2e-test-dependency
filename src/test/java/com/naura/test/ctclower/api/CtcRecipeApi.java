package com.naura.test.ctclower.api;

import Ice.StringHolder;
import com.github.leeonky.jfactory.cucumber.Table;
import com.github.leeonky.util.BeanClass;
import com.naura.ctc.IComData.*;
import com.naura.ctc.IComRecipe.*;
import com.naura.test.lower.LowerException;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.Arrays.stream;

public class CtcRecipeApi {
    final RemoteRecipeUserPrx remoteRecipeUserPrx;

    public CtcRecipeApi(RemoteRecipeUserPrx remoteRecipeUserPrx) {
        this.remoteRecipeUserPrx = remoteRecipeUserPrx;
    }

    private void shouldTrue(Function<StringHolder, Boolean> function) {
        StringHolder stringHolder = new StringHolder();
        if (!function.apply(stringHolder)) throw new LowerException(stringHolder.value);
    }

    public Test test() {
        return new Test();
    }

    public void registerRecipe(RemoteRecipeInfo recipeInfo) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.registerRecipe(recipeInfo, stringHolder));
    }

    public void deleteRecipe(String recipe) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.removeRecipe(recipe, stringHolder));
    }

    public void setExclRcpStepValue(String recipe, String index, String paramName, String value) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.setExclRcpStepValue(recipe, Integer.parseInt(index), paramName, value, stringHolder));
    }

    public void setExclRcpEditor(String recipe, String editor) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.setExclRcpEditor(recipe, editor, stringHolder));
    }

    public void setExclRcpComments(String recipe, String comments) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.setExclRcpComments(recipe, comments, stringHolder));
    }

    public void setRcpApprovalLvl(String recipe, String level) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.setRcpApprovalLvl(recipe, Integer.parseInt(level), stringHolder));
    }

    public void selectRecipe(String recipe) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.selectRecipe(recipe, stringHolder));
    }

    public void deselectRecipe(String recipe) {
        remoteRecipeUserPrx.deselectRecipe(recipe);
    }

    public void retrieveExclRcp(String recipe) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.retrieveExclRcp(recipe, stringHolder));
    }


    public String[] getAllRecipes() {
        return remoteRecipeUserPrx.getAllRecipes();
    }

    public RemoteRecipeInfo getRecipeInfo(String id) {
        RemoteRecipeInfoHolder recipeInfoHolder = new RemoteRecipeInfoHolder();
        shouldTrue(stringHolder -> remoteRecipeUserPrx.getRecipeInfo(id, recipeInfoHolder));
        return recipeInfoHolder.value;
    }

    public RemoteRcpClassInfo getRcpClassInfo(String name) {
        RemoteRcpClassInfoHolder infoHolder = new RemoteRcpClassInfoHolder();
        shouldTrue(stringHolder -> remoteRecipeUserPrx.getRcpClassInfo(name, infoHolder));
        return infoHolder.value;
    }

    public Object invoke(String api) {
        switch (api) {
            case "getAllRecipe":
                return getAllRecipes();
            case "getAllRcpClass":
                return getAllRcpClasses();
            case "getNamespaceROLvl":
                return getNamespaceROLvl();
            default:
                throw new IllegalStateException("unknown api: " + api);
        }
    }

    @SuppressWarnings("unchecked")
    public Object invoke(String api, Table table) {
        switch (api) {
            case "registerRecipe": {
                registerRecipe(parseToRemoteRecipeInfo(table));
                return null;
            }
            case "retrieveExclRcp": {
                retrieveExclRcp((String) table.get(0).get("recipe"));
                return null;
            }
            case "registerRcpClass": {
                registerRcpClass((String) table.get(0).get("name"), ((List<Map<String, ?>>) table.get(0).get("params")).stream().map(CtcRecipeApi::buildParam).toArray(RemoteParamInfo[]::new));
                return null;
            }
            case "storeRcpBody": {
                storeRcpBody((String) table.get(0).get("recipe"), (Boolean) table.get(0).get("override"), parseRcpBody(table));
                return null;
            }
            case "getRecipeInfo": {
                return getRecipeInfo((String) table.get(0).get("recipe"));
            }
            case "getRcpClassInfo": {
                return getRcpClassInfo((String) table.get(0).get("recipeClass"));
            }
            case "removeRcpClass": {
                removeRcpClass((String) table.get(0).get("name"));
                return null;
            }
            case "removeRecipe": {
                removeRecipe((String) table.get(0).get("recipe"));
                return null;
            }
            case "setRcpComments": {
                setRcpComments((String) table.get(0).get("recipe"), (String) table.get(0).get("comments"));
                return null;
            }
            case "setRcpEditor": {
                setRcpEditor((String) table.get(0).get("recipe"), (String) table.get(0).get("edit"));
                return null;
            }
            case "selectRecipe": {
                selectRecipe((String) table.get(0).get("name"));
                return null;
            }
            case "deselectRecipe": {
                deselectRecipe((String) table.get(0).get("name"));
                return null;
            }
            case "deleteRecipe": {
                deleteRecipe((String) table.get(0).get("name"));
                return null;
            }
            case "releaseExclRcp": {
                releaseExclRcp((String) table.get(0).get("recipe"));
                return null;
            }
            case "setExclRcpStepValue": {
                setExclRcpStepValue((String) table.get(0).get("recipe"), (String) table.get(0).get("index"), (String) table.get(0).get("paramName"), (String) table.get(0).get("value"));
                return null;
            }
            case "setExclRcpEditor": {
                setExclRcpEditor((String) table.get(0).get("recipe"), (String) table.get(0).get("editor"));
                return null;
            }
            case "setExclRcpComments": {
                setExclRcpComments((String) table.get(0).get("recipe"), (String) table.get(0).get("comments"));
                return null;
            }
            case "setRcpApprovalLvl": {
                setRcpApprovalLvl((String) table.get(0).get("recipe"), (String) table.get(0).get("level"));
                return null;
            }
            default:
                throw new IllegalStateException("unknown api: " + api);
        }
    }

    @NotNull
    @SuppressWarnings("unchecked")
    private static RemoteProcessRcpInfo parseRcpBody(Table table) {
        RemoteProcessRcpInfo storeRcpBody = new RemoteProcessRcpInfo();
        storeRcpBody.steps = ((List<Map<String, Object>>) table.get(0).get("body")).stream().map(map -> new StepInfo((String) map.get("name"), ((List<String>) map.get("value")).toArray(new String[0]))).toArray(StepInfo[]::new);
        return storeRcpBody;
    }

    public void storeRcpBody(String recipe, boolean override, RemoteProcessRcpInfo storeRcpBody) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.storeRcpBody(recipe, storeRcpBody, override, stringHolder));
    }

    public void removeRecipe(String fullName) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.removeRecipe(fullName, stringHolder));
    }

    public void setRcpComments(String fullName, String comments) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.setRcpComments(fullName, comments, stringHolder));
    }

    public void setRcpEditor(String fullName, String edit) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.setRcpEditor(fullName, edit, stringHolder));
    }


    public void registerRcpClass(String fullName, RemoteParamInfo[] params) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.registerRcpClass(fullName, params, stringHolder));
    }

    @NotNull
    public static RemoteParamInfo buildParam(Map<String, ?> map) {
        if (map.get("type").equals("I")) {
            return buildIntParam(map);
        } else if (map.get("type").equals("D")) {
            return buildDoubleParam(map);
        } else {
            return buildStringParam(map);
        }
    }

    @NotNull
    private static RemoteIntParamInfo buildIntParam(Map<String, ?> map) {
        RemoteIntParamInfo remoteIntParamInfo = assignBaseParam(map, new RemoteIntParamInfo(), RemoteDataType.INTDATA);
        RemoteIntTypeInfo typeInfo = new RemoteIntTypeInfo();
        typeInfo.max = (Integer) map.get("max");
        typeInfo.min = (Integer) map.get("min");
        typeInfo.unit = (String) map.get("unit");
        typeInfo.descriptors = ((Map<String, Integer>) map.get("descriptors")).entrySet().stream().map(entry -> new RemoteNameValuePair(entry.getKey(), entry.getValue())).toArray(RemoteNameValuePair[]::new);
        remoteIntParamInfo.typeInfo = typeInfo;
        return remoteIntParamInfo;
    }

    @NotNull
    private static RemoteStringParamInfo buildStringParam(Map<String, ?> map) {
        RemoteStringParamInfo remoteStringParamInfo = assignBaseParam(map, new RemoteStringParamInfo(), RemoteDataType.STRINGDATA);
        RemoteStringTypeInfo typeInfo = new RemoteStringTypeInfo();
        typeInfo.maxLength = ((Integer) map.get("maxLength")).longValue();
        remoteStringParamInfo.typeInfo = typeInfo;
        return remoteStringParamInfo;
    }

    @NotNull
    private static RemoteDoubleParamInfo buildDoubleParam(Map<String, ?> map) {
        RemoteDoubleParamInfo remoteDoubleParamInfo = assignBaseParam(map, new RemoteDoubleParamInfo(), RemoteDataType.DOUBLEDATA);
        RemoteDoubleTypeInfo typeInfo = new RemoteDoubleTypeInfo();
        typeInfo.max = (Double) map.get("max");
        typeInfo.min = (Double) map.get("min");
        typeInfo.unit = (String) map.get("unit");
        typeInfo.accuracy = (Double) map.get("accuracy");
        remoteDoubleParamInfo.typeInfo = typeInfo;
        return remoteDoubleParamInfo;
    }

    private static <T extends RemoteParamInfo> T assignBaseParam(Map<String, ?> map, T remoteParamInfo, RemoteDataType type) {
        remoteParamInfo.name = (String) map.get("name");
        remoteParamInfo.dataObj = (String) map.get("dataObj");
        remoteParamInfo.defaultValue = (String) map.get("defaultValue");
        remoteParamInfo.type = type;
        return remoteParamInfo;
    }

    @NotNull
    private RemoteRecipeInfo parseToRemoteRecipeInfo(Table table) {
        RemoteRecipeInfo recipeInfo = new RemoteRecipeInfo();
        BeanClass<RemoteRecipeInfo> recipeInfoBeanClass = BeanClass.create(RemoteRecipeInfo.class);
        table.get(0).forEach((key, value) -> recipeInfoBeanClass.setPropertyValue(recipeInfo, key, value));
        return recipeInfo;
    }

    public void releaseExclRcp(String recipe) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.releaseExclRcp(recipe, stringHolder));
    }

    public String[] getAllRcpClasses() {
        return remoteRecipeUserPrx.getAllRcpClasses();
    }

    public int getNamespaceROLvl() {
        return remoteRecipeUserPrx.getNamespaceROLvl();
    }

    public void removeRcpClass(String cls) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.removeRcpClass(cls, stringHolder));
    }

    //TODO remoteRecipeUserPrx.storeRcpBody返回的是false，抛异常 Wrong size of input step-value array
    public void storercpForEtch1justOneStep(String[] strings) {
        shouldTrue(stringHolder -> remoteRecipeUserPrx.storeRcpBody("/Process/test3;1", rcpProForEtch1JustOneStep(strings), true, stringHolder));
    }

    public RemoteProcessRcpInfo rcpProForEtch1JustOneStep(String[] strings) {
        RemoteProcessRcpInfo storeRcpBody = new RemoteProcessRcpInfo();
//        storeRcpBody.steps[0].name = "dechuck";
//        storeRcpBody.steps[0].values = strings;
//        return storeRcpBody;
        StepInfo[] stepInfo = new StepInfo[1];
        StepInfo step = new StepInfo();
        step.name = "dechuck";
        step.values = Arrays.copyOfRange(strings,1,64);
        stepInfo[0] = step;
        storeRcpBody.steps = stepInfo;
        return storeRcpBody;
    }

    public class Test {

        public void given(RemoteRecipeInfo recipeInfo) {
            registerRecipe(recipeInfo);
        }

        public void givencls(String ClsName, RemoteParamInfo[] params) {
            registerRcpClass(ClsName, params);
        }

        public void cleanRecipes() {
            for (String recipe : getAllRecipes()) {
                try {
                    releaseExclRcp(recipe);

                } catch (Exception ignore) {
                }
                deselectRecipe(recipe);
                setRcpApprovalLvl(recipe, "0");
                deleteRecipe(recipe);
            }
        }

        public void cleanRecipeClass() {
            stream(getAllRcpClasses()).filter(this::isSubClass).sorted(Comparator.comparing(String::length).reversed()).forEach(CtcRecipeApi.this::removeRcpClass);
        }

        public void alldeselect() {
            for (String recipe : getAllRecipes()) {
                deselectRecipe(recipe);
            }
        }

        private boolean isSubClass(String rcpClass) {
            return rcpClass.chars().filter(c -> c == '/').count() > 1;
        }
    }


}