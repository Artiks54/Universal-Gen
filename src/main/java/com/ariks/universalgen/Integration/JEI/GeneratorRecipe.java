package com.ariks.universalgen.Integration.JEI;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.item.ItemStack;
import java.util.Collections;
import java.util.List;

public class GeneratorRecipe implements IRecipeWrapper {
    private final ItemStack output;
    private final int generationTime;

    public GeneratorRecipe(ItemStack output, int generationTime) {
        this.output = output;
        this.generationTime = generationTime;
    }
    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setOutput(ItemStack.class, getOutputs());
    }
    public List<ItemStack> getOutputs() {
        return Collections.singletonList(output);
    }
    public int getGenerationTime() {
        return generationTime;
    }
}