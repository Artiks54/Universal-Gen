package com.ariks.cobblegen.util;

import com.ariks.cobblegen.CobbleGen;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import static com.ariks.cobblegen.util.RegistryBlock.*;
public class RegistryReciep {
    public static void preInit() {
        String[] Level = {"1","2","3","4","5","6","7","8","9"};
        Block[] CBlockInput = {Blocks.COBBLESTONE,C1,C2,C3,C4,C5,C6,C7,C8};
        Block[] CBlockOutput = {C1,C2,C3,C4,C5,C6,C7,C8,C9};
        Block[] CBlockInputRevers = {C9,C8,C7,C6,C5,C4,C3,C2,C1};
        Block[] CBlockOutputRevers = {C8,C7,C6,C5,C4,C3,C2,C1,Blocks.COBBLESTONE};
        //Block to block
        for (int i = 0; i < Level.length; i++) {
            String level = Level[i];
            Block input = CBlockInput[i];
            Block output = CBlockOutput[i];
            String recipeID = "Compressed_" + level;
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(CobbleGen.MOD_ID, recipeID), null,
                    new ItemStack(output),
                    "CCC",
                    "CCC",
                    "CCC",
                    'C', new ItemStack(input));
        }
        //Block to block reverse
        for (int i = 0; i < Level.length; i++) {
            String level = Level[i];
            Block input = CBlockInputRevers[i];
            Block output = CBlockOutputRevers[i];
            String recipeID = "Compressed_reverse_" + level;
            GameRegistry.addShapelessRecipe(
                    new ResourceLocation(CobbleGen.MOD_ID, recipeID), null,
                    new ItemStack(output, 9),
                    Ingredient.fromItems(Item.getItemFromBlock(input))
            );
        }
        //CobbleGen_Lvl_1
        GameRegistry.addShapedRecipe(
                new ResourceLocation(CobbleGen.MOD_ID + ":" + "Cobble_gen_lvl_1"), null,
                new ItemStack(RegistryBlock.CobbleGenLvl1),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(Blocks.COBBLESTONE),
                'W', new ItemStack(Items.WATER_BUCKET),
                'P', new ItemStack(Blocks.IRON_BLOCK),
                'L', new ItemStack(Items.LAVA_BUCKET));
        //CobbleGen_Lvl_2
        GameRegistry.addShapedRecipe(
                new ResourceLocation(CobbleGen.MOD_ID + ":" + "Cobble_gen_lvl_2"), null,
                new ItemStack(RegistryBlock.CobbleGenLvl2),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(C1),
                'W', new ItemStack(RegistryBlock.CobbleGenLvl1),
                'P', new ItemStack(Blocks.GOLD_BLOCK),
                'L', new ItemStack(RegistryBlock.CobbleGenLvl1));
        //CobbleGen_Lvl_3
        GameRegistry.addShapedRecipe(
                new ResourceLocation(CobbleGen.MOD_ID + ":" + "Cobble_gen_lvl_3"), null,
                new ItemStack(RegistryBlock.CobbleGenLvl3),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(C2),
                'W', new ItemStack(RegistryBlock.CobbleGenLvl2),
                'P', new ItemStack(Blocks.DIAMOND_BLOCK),
                'L', new ItemStack(RegistryBlock.CobbleGenLvl2));
        //CobbleGen_Lvl_4
        GameRegistry.addShapedRecipe(
                new ResourceLocation(CobbleGen.MOD_ID + ":" + "Cobble_gen_lvl_4"), null,
                new ItemStack(RegistryBlock.CobbleGenLvl4),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(C3),
                'W', new ItemStack(RegistryBlock.CobbleGenLvl3),
                'P', new ItemStack(Blocks.EMERALD_BLOCK),
                'L', new ItemStack(RegistryBlock.CobbleGenLvl3));
    }
}