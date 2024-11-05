package com.ariks.universalgen.Integration.CraftTweaker;

import com.ariks.universalgen.Block.UniversalGen.GeneratedItem;
import com.ariks.universalgen.Block.UniversalGen.TileUniversalGenItems;
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
        TileUniversalGenItems.getItemsToGenerate().add(new GeneratedItem(stack, generationTime));
    }
    @ZenMethod
    public static void removeGeneratedItem(IItemStack itemStack) {
        ItemStack stack = CraftTweakerMC.getItemStack(itemStack);
        TileUniversalGenItems.getItemsToGenerate().removeIf(item -> ItemStack.areItemStacksEqual(item.getItemStack(), stack));
    }
}