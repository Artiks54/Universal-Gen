package com.ariks.universalgen.Integration.JEI;

import com.ariks.universalgen.Block.UniversalGen.GeneratorRecipes;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;
import org.jetbrains.annotations.NotNull;

public class GeneratorWrapper implements IRecipeWrapperFactory<GeneratorRecipes> {

    @Override
    public @NotNull IRecipeWrapper getRecipeWrapper(@NotNull GeneratorRecipes generatorRecipes) {
        return new GeneratorRecipeJei(generatorRecipes);
    }
}
