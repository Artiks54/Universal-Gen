package com.ariks.universalgen.Integration.JEI;

import com.ariks.universalgen.Block.UniversalGen.GeneratorRecipes;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;

public class GeneratorRecipeJei implements IRecipeWrapper {
    GeneratorRecipes recipes;
    public GeneratorRecipeJei(GeneratorRecipes recipes) {
        this.recipes = recipes;
    }
    public ItemStack getOut() {
        return recipes.getRecipeOutput();
    }
    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setOutput(VanillaTypes.ITEM, recipes.getRecipeOutput());
    }
}

