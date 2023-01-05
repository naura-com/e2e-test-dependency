package com.naura.test.ui.page.PVD;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InitPage {
    private final WinForm winForm;

    private final Window.WindowOperation page;

    public InitPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    private String moduleNameSwitch(String module) {
        switch (module) {
            case "Buffer":
                return "VTR1A";
            case "Transfer":
                return "VTR2A";
            case "Aligner":
                return "ALG";
        }
        return module;
    }

    public void setModuleSlot(String module, String slot, boolean isExits) {
        module = moduleNameSwitch(module);
        page.elementById(String.format("m%sEditWfr_bts", module)).click();
        winForm.elementById("PopupMaterialEdit").elementByName("  物料同步  ").click();
        winForm.elementById("PopupMaterialEdit").elementById(String.format("mSlot%s_cb", slot)).click();
        winForm.elementById("PopupMaterialEdit").elementById(String.format("mSlot%s_cb", slot)).select(isExits);
        winForm.elementById("PopupMaterialEdit").elementById("mSync_bts").click();
        winForm.elementById("mYes_btn").click();
        winForm.elementById("PopupMaterialEdit").elementById("mQuit_btn").click();
    }

    public void setModuleSlots(String module, List<String> slots) {
        Map<Integer, Boolean> slotState = null;
        module = moduleNameSwitch(module);
        Integer num = 2;
        if (module.startsWith("LP")) {
            num = 25;
        }
        slotState = getSlotState(num, slots);

        page.elementById(String.format("m%sEditWfr_bts", module)).click();
        winForm.elementById("PopupMaterialEdit").elementByName("  物料同步  ").click();
        slotState.forEach((key, value) -> {
            winForm.elementById("PopupMaterialEdit").elementById(String.format("mSlot%d_cb", key)).select(value);
        });
        winForm.elementById("PopupMaterialEdit").elementById("mSync_bts").click();
        winForm.elementById("mYes_btn").click();
        winForm.elementById("PopupMaterialEdit").elementById("mQuit_btn").click();
    }

    private Map<Integer, Boolean> getSlotState(int num, List<String> slots) {
        Map<Integer, Boolean> slotState = new HashMap<>();
        for (int i = 1; i <= num; i++) {
            if (slots.contains(String.valueOf(i)))
                slotState.put(i, true);
            else
                slotState.put(i, false);
        }
        return slotState;
    }

    public void setModuleSlots(String module, boolean isExit) {
        module = moduleNameSwitch(module);
        page.elementById(String.format("m%sEditWfr_bts", module)).click();
        winForm.elementById("PopupMaterialEdit").elementByName("  物料同步  ").click();
        winForm.elementById("PopupMaterialEdit").elementById("mSlotAll_cb").select(true);
        winForm.elementById("PopupMaterialEdit").elementById("mSlotAll_cb").select(isExit);
        winForm.elementById("PopupMaterialEdit").elementById("mSync_bts").click();
        winForm.elementById("mYes_btn").click();
        winForm.elementById("PopupMaterialEdit").elementById("mQuit_btn").click();
    }

    public void editMaterial(String module) {
        module = moduleNameSwitch(module);
        page.elementById(String.format("m%sEditWfr_bts", module)).click();
        winForm.elementById("PopupMaterialEdit").elementByName("  物料同步  ").click();
    }

    public void slotAll(boolean isSelect) {
        winForm.elementById("PopupMaterialEdit").elementById("mSlotAll_cb").select(true);
        winForm.elementById("PopupMaterialEdit").elementById("mSlotAll_cb").select(isSelect);
    }

    public Object getSelectSlot(String module) {
        changeModule(module);
        List<Integer> slots = new ArrayList<>();
        Integer num = 2;
        if (module.startsWith("LP")) {
            num = 25;
        }
        for (int i = 1; i <= num; i++) {
            if (winForm.elementById("PopupMaterialEdit").elementById(String.format("mSlot%d_cb", i)).isSelect()) {
                slots.add(i);
            }
        }
        return slots;
    }

    public void clickMaterialsOn(String name) {
        winForm.elementById("PopupMaterialEdit").elementByName(name).click();
    }

    public void editModuleSlots(String module, List<String> slots) {
        Map<Integer, Boolean> slotState = null;
        module = moduleNameSwitch(module);
        Integer num = 2;
        if (module.startsWith("LP")) {
            num = 25;
        }
        slotState = getSlotState(num, slots);

        slotState.forEach((key, value) -> {
            winForm.elementById("PopupMaterialEdit").elementById(String.format("mSlot%d_cb", key)).select(value);
        });
    }

    public void changeModule(String module) {
        while (true) {
            if (winForm.elementById("PopupMaterialEdit").elementById("mCurModule_btn").getText().equals(module)) {
                break;
            } else if (winForm.elementById("PopupMaterialEdit").elementById("mPreModuleSelect_btn").getText().equals(module)) {
                winForm.elementById("PopupMaterialEdit").elementById("mPreModuleSelect_btn").click();
                break;
            } else if (winForm.elementById("PopupMaterialEdit").elementById("mPostModuleSelect_btn").getText().equals(module)) {
                winForm.elementById("PopupMaterialEdit").elementById("mPostModuleSelect_btn").click();
                break;
            } else {
                winForm.elementById("PopupMaterialEdit").elementById("mPostModuleSelect_btn").click();
            }
        }
    }
}
