package com.ariks.universalgen.Integration.JEI;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import java.util.Collections;
import java.util.List;

public class GeneratorRecipe implements IRecipeWrapper {
    private final ItemStack output;

    public GeneratorRecipe(ItemStack output) {
        this.output = output;
    }
    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setOutput(ItemStack.class, getOutputs());
    }
    public List<ItemStack> getOutputs() {
        return Collections.singletonList(output);
    }
}