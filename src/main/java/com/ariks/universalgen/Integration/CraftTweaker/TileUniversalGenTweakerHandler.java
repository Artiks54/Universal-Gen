package com.ariks.universalgen.Integration.CraftTweaker;

import com.ariks.universalgen.Block.UniversalGen.GeneratorRecipes;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenRegister
@ZenClass("mods.universalgen.TileUniversalGenerator")

public class TileUniversalGenTweakerHandler {

    @ZenMethod
    public static void addGeneratedItem(IItemStack itemStack, int generationTime) {
        ItemStack stack = CraftTweakerMC.getItemStack(itemStack);
        stack.setItemDamage(itemStack.getMetadata());
        stack.setTagCompound(CraftTweakerMC.getNBTCompound(itemStack.getTag()));
        GeneratorRecipes.addRecipe(new GeneratorRecipes(stack, generationTime));
    }
    @ZenMethod
    public static void removeGeneratedItem(IItemStack itemStack) {
        ItemStack stack = CraftTweakerMC.getItemStack(itemStack);
        GeneratorRecipes.removeRecipe(stack);
    }
}
