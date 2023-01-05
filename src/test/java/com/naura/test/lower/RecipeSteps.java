package com.naura.test.lower;

import com.naura.test.lower.api.LowerApi;
import io.cucumber.java.Before;
import io.cucumber.java.zh_cn.并且;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static com.github.leeonky.dal.Assertions.expect;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RecipeSteps {

    @Autowired
    private LowerApi lowerApi;

    @Before(value = "@clean-lower-recipe", order = 1100)
    public void clean() {
        lowerApi.recipe().test().cleanRecipes();
        lowerApi.recipe().test().cleanRecipeClass();
    }

    @那么("无法再独占取出Recipe{string}")
    public void 无法再独占取出recipe(String recipe) {
        assertThatThrownBy(() -> lowerApi.recipe().retrieveExclRcp(recipe))
                .hasMessageContaining("Failed! Recipe is already owned by this session.");
    }

    @那么("无法再删除Recipe{string}")
    public void 无法再删除recipe(String recipe) {
        assertThatThrownBy(() -> lowerApi.recipe().removeRecipe(recipe))
                .hasMessageContaining("Failed! Recipe is in use.");
    }

    @那么("Recipe{string}的Info为:")
    public void recipe的Info为(String id, String verification) {
        expect(lowerApi.recipe().getRecipeInfo(id)).should(verification);
    }

    @并且("RecipeClass{string}为:")
    public void recipeclass为(String name, String verification) {
        expect(lowerApi.recipe().getRcpClassInfo(name)).should(verification);
    }

    @并且("recipe{string}已被删除")
    public void recipe已被删除(String recipe) {
        assertThatThrownBy(() -> lowerApi.recipe().getRecipeInfo(recipe));
    }
}
