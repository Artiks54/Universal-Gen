package com.ariks.universalgen.Integration.JEI;

import com.ariks.universalgen.Register.RegistryBlock;
import com.ariks.universalgen.UniversalGen;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GeneratorRecipeCategory implements IRecipeCategory<GeneratorRecipeJei> {
    private final IDrawable background;
    private final String localizedName;
    private final IDrawableAnimated progressBar;

    public GeneratorRecipeCategory(IGuiHelper guiHelper) {
        ResourceLocation location = new ResourceLocation(UniversalGen.MOD_ID, "textures/gui/gui_jei.png");
        background = guiHelper.createDrawable(location, 0, 0, 124, 84);
        localizedName = RegistryBlock.Universal_Generator.getLocalizedName();

        IDrawableStatic progressDrawable = guiHelper.createDrawable(location, 0, 86, 26, 50);
        progressBar = guiHelper.createAnimatedDrawable(progressDrawable, 25, IDrawableAnimated.StartDirection.LEFT, false);
    }

    @Override
    public void drawExtras(@NotNull Minecraft minecraft) {
        progressBar.draw(minecraft,34,18);
    }

    @Override
    public @NotNull String getUid() {
        return UniversalGen.MOD_ID + "_universal";
    }
    @Override
    public @NotNull String getTitle() {
        return localizedName;
    }
    @Override
    public @NotNull String getModName() {
        return UniversalGen.MOD_NAME;
    }
    @Override
    public @NotNull IDrawable getBackground() {
        return background;
    }
    @Override
    public void setRecipe(IRecipeLayout recipeLayout, GeneratorRecipeJei GeneratorRecipeJei, @NotNull IIngredients ingredients) {
        recipeLayout.getItemStacks().init(1, false, 61 - 1, 17 - 1);
        recipeLayout.getItemStacks().set(1, GeneratorRecipeJei.getOut());
    }
}