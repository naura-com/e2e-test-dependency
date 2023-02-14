package com.naura.test.ui.page.Etch1.Edit;

import com.naura.test.ui.driver.WinForm;
import com.naura.test.ui.driver.Window;
import com.naura.test.ui.page.ParentPage;
import org.springframework.beans.factory.annotation.Autowired;

public class EditPage extends ParentPage {
    @Autowired
    private WinForm winForm;
    @Autowired
    private final Window.WindowOperation page;

    public EditPage(Window.WindowOperation page, WinForm winForm) {
        this.page = page;
        this.winForm = winForm;
    }

    public RecipePage recipePage() {
        return switchTo(RecipePage.class, () -> winForm.elementById("Process Recipe").click(),
                () -> new RecipePage(winForm.elementById("frmProcessRecipe"), winForm));
    }

    public RoutePage routePage() {
        return switchTo(RoutePage.class, () -> winForm.elementById("Wafer Flow").click(),
                () -> new RoutePage(winForm.elementById("frmWaferFlow"), winForm));
    }

    public RecipeComparePage recipeComparePage() {
        return switchTo(RecipeComparePage.class, () -> winForm.elementById("Recipe Compare").click(),
                () -> new RecipeComparePage(winForm.elementById("frmRecipeCompare"), winForm));
    }
}
