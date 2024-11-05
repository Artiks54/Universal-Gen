package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Integration.JEI.GeneratorRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import java.util.List;

public class TileUniversalGenItems {
    private static final List<GeneratedItem> itemsToGenerate = new ArrayList<>();

    static {
        itemsToGenerate.add(new GeneratedItem(new ItemStack(Blocks.COBBLESTONE), 20));
        itemsToGenerate.add(new GeneratedItem(new ItemStack(Blocks.GRAVEL), 40));
        itemsToGenerate.add(new GeneratedItem(new ItemStack(Blocks.SAND), 40));
        itemsToGenerate.add(new GeneratedItem(new ItemStack(Blocks.NETHERRACK), 80));
        itemsToGenerate.add(new GeneratedItem(new ItemStack(Blocks.END_STONE), 80));
        itemsToGenerate.add(new GeneratedItem(new ItemStack(Blocks.DIRT), 20));
        System.out.println("Initializing TileUniversalGenerator recipes");
    }

    public static List<GeneratedItem> getItemsToGenerate() {
        return itemsToGenerate;
    }
    public static List<GeneratorRecipe> getRecipes() {
        List<GeneratorRecipe> recipes = new ArrayList<>();
        for (GeneratedItem item : itemsToGenerate) {
            recipes.add(new GeneratorRecipe(item.getItemStack()));
        }
        return recipes;
    }
}