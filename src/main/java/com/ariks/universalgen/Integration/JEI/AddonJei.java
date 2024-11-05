package com.ariks.universalgen.Integration.JEI;

import com.ariks.universalgen.Register.RegistryBlock;
import com.ariks.universalgen.UniversalGen;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import java.util.Collections;

@JEIPlugin
public class AddonJei implements IModPlugin {

    public void register(IModRegistry registry) {
        String idUniversal = UniversalGen.MOD_ID + "_universal";
        registry.handleRecipes(GeneratorRecipe.class, recipe -> recipe, idUniversal);
        registry.addRecipes(Collections.singletonList(new GeneratorRecipe(new ItemStack(Blocks.DIRT))), idUniversal);
        registry.addRecipes(Collections.singletonList(new GeneratorRecipe(new ItemStack(Blocks.COBBLESTONE))), idUniversal);
        registry.addRecipes(Collections.singletonList(new GeneratorRecipe(new ItemStack(Blocks.GRAVEL))), idUniversal);
        registry.addRecipes(Collections.singletonList(new GeneratorRecipe(new ItemStack(Blocks.SAND))), idUniversal);
        registry.addRecipes(Collections.singletonList(new GeneratorRecipe(new ItemStack(Blocks.NETHERRACK))), idUniversal);
        registry.addRecipes(Collections.singletonList(new GeneratorRecipe(new ItemStack(Blocks.END_STONE))), idUniversal);
        registry.addRecipeCatalyst(new ItemStack(RegistryBlock.Universal_Generator), idUniversal);
        registry.addRecipeCatalyst(new ItemStack(RegistryBlock.Universal_Generator_Advanced), idUniversal);
        registry.addRecipeCatalyst(new ItemStack(RegistryBlock.Universal_Generator_Ultimate), idUniversal);
        registry.addRecipeCatalyst(new ItemStack(RegistryBlock.Universal_Generator_Dragon), idUniversal);
    }
    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        registry.addRecipeCategories(new GeneratorRecipeCategory(registry.getJeiHelpers().getGuiHelper()));
    }
}