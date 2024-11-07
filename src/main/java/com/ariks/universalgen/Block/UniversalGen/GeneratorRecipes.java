package com.ariks.universalgen.Block.UniversalGen;

import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import java.util.List;

public class GeneratorRecipes implements  IRecipeWrapper {
    private final ItemStack output;
    private final int generationTime;
    public static final List<GeneratorRecipes> recipes = new ArrayList<>();

    public GeneratorRecipes(ItemStack output, int generationTime) {
        this.output = output;
        this.generationTime = generationTime;
    }
    public ItemStack getRecipeOutput() {
        return output;
    }
    public int getGenerationTime() {
        return generationTime;
    }
    public static void addRecipe(GeneratorRecipes recipe) {
        recipes.add(recipe);
    }
    public static void removeRecipe(ItemStack stack) {
        recipes.removeIf(recipe -> ItemStack.areItemStacksEqual(recipe.getRecipeOutput(), stack));
    }
    public static List<GeneratorRecipes> getRecipes() {
        return recipes;
    }
    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setOutput(ItemStack.class, getRecipeOutput());
    }
    public static void preInit() {
        GeneratorRecipes.addRecipe(new GeneratorRecipes(new ItemStack(Blocks.COBBLESTONE), 20));
        GeneratorRecipes.addRecipe(new GeneratorRecipes(new ItemStack(Blocks.GRAVEL), 40));
        GeneratorRecipes.addRecipe(new GeneratorRecipes(new ItemStack(Blocks.SAND), 40));
        GeneratorRecipes.addRecipe(new GeneratorRecipes(new ItemStack(Blocks.NETHERRACK), 80));
        GeneratorRecipes.addRecipe(new GeneratorRecipes(new ItemStack(Blocks.END_STONE), 80));
        GeneratorRecipes.addRecipe(new GeneratorRecipes(new ItemStack(Blocks.DIRT), 60));
    }
}