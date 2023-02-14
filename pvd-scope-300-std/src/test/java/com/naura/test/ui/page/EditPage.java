package com.naura.test.ui.page;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;

public class EditPage extends ParentPage {
    private final Window.WindowOperation page;
    private final WinForm winForm;

    public EditPage(Window.WindowOperation page, WinForm winForm) {
        super(new RecipePage(winForm.elementById("FormRecipe"), winForm));
        this.page = page;
        this.winForm = winForm;
    }

    public RecipePage recipePage() {
        return switchTo(RecipePage.class, () -> page.elementById("mEditorRcp_navibtn").click(),
                () -> new RecipePage(winForm.elementById("FormRecipe"), winForm));
    }

    public RoutePage routePage() {
        return switchTo(RoutePage.class, () -> page.elementById("mEditorRoute_navibtn").click(),
                () -> new RoutePage(winForm.elementById("FormRoute"), winForm));
    }

    public JobPage jobPage() {
        return switchTo(JobPage.class, () -> page.elementById("mEditorJob_navibtn").click(),
                () -> new JobPage(winForm.elementById("FormJob"), winForm));
    }

    public PMRecipePage pmRecipePage() {
        return switchTo(PMRecipePage.class, () -> page.elementById("mMaintPMacro_navibtn").click(),
                () -> new PMRecipePage(winForm.elementById("FormPMRecipe"), winForm));
    }

}
