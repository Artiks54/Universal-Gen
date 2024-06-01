package com.ariks.universalgen.Register;

import com.ariks.universalgen.UniversalGen;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import static com.ariks.universalgen.Register.RegistryBlock.*;

public class RegistryReciep {
    public static void preInit() {
        //COBBLE_STONE
        String[] Cobble_CLevel = {"1C","2C","3C","4C","5C","6C","7C","8C","9C"};
        Block[] Cobble_CBlockInput = {Blocks.COBBLESTONE,C1,C2,C3,C4,C5,C6,C7,C8};
        Block[] Cobble_CBlockOutput = {C1,C2,C3,C4,C5,C6,C7,C8,C9};
        Block[] Cobble_CBlockInputRevers = {C9,C8,C7,C6,C5,C4,C3,C2,C1};
        Block[] Cobble_CBlockOutputRevers = {C8,C7,C6,C5,C4,C3,C2,C1,Blocks.COBBLESTONE};
        for (int i = 0; i < Cobble_CLevel.length; i++) {
            String level = Cobble_CLevel[i];
            Block input = Cobble_CBlockInput[i];
            Block output = Cobble_CBlockOutput[i];
            String recipeID = "Cobble_" + level;
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(UniversalGen.MOD_ID, recipeID), null,
                    new ItemStack(output),
                    "CCC",
                    "CCC",
                    "CCC",
                    'C', new ItemStack(input));
        }
        for (int i = 0; i < Cobble_CLevel.length; i++) {
            String level = Cobble_CLevel[i];
            Block input = Cobble_CBlockInputRevers[i];
            Block output = Cobble_CBlockOutputRevers[i];
            String recipeID = "Cobble_Reverse" + level;
            GameRegistry.addShapelessRecipe(
                    new ResourceLocation(UniversalGen.MOD_ID, recipeID), null,
                    new ItemStack(output, 9),
                    Ingredient.fromItems(Item.getItemFromBlock(input))
            );
        }


        //Sand
        String[] Sand_CLevel = {"1S","2S","3S","4S","5S","6S","7S","8S","9S"};
        Block[] Sand_CBlockInput = {Blocks.SAND,S1,S2,S3,S4,S5,S6,S7,S8};
        Block[] Sand_CBlockOutput = {S1,S2,S3,S4,S5,S6,S7,S8,S9};
        Block[] Sand_CBlockInputRevers = {S9,S8,S7,S6,S5,S4,S3,S2,S1};
        Block[] Sand_CBlockOutputRevers = {S8,S7,S6,S5,S4,S3,S2,S1,Blocks.SAND};
        for (int i = 0; i < Sand_CLevel.length; i++) {
            String level = Sand_CLevel[i];
            Block input = Sand_CBlockInput[i];
            Block output = Sand_CBlockOutput[i];
            String recipeID = "Sand_" + level;
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(UniversalGen.MOD_ID, recipeID), null,
                    new ItemStack(output),
                    "CCC",
                    "CCC",
                    "CCC",
                    'C', new ItemStack(input));
        }
        for (int i = 0; i < Sand_CLevel.length; i++) {
            String level = Sand_CLevel[i];
            Block input = Sand_CBlockInput[i];
            Block output = Sand_CBlockOutput[i];
            String recipeID = "Sand_Reverse" + level;
            GameRegistry.addShapelessRecipe(
                    new ResourceLocation(UniversalGen.MOD_ID, recipeID), null,
                    new ItemStack(output, 9),
                    Ingredient.fromItems(Item.getItemFromBlock(input))
            );
        }
        //SandGen_lvl1
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Sand_gen_lvl_1"), null,
                new ItemStack(SandGenLvl1),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(Blocks.SAND),
                'W', new ItemStack(Items.WATER_BUCKET),
                'P', new ItemStack(Blocks.IRON_BLOCK),
                'L', new ItemStack(Items.LAVA_BUCKET));
        //SandGen_lvl2
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Sand_gen_lvl_2"), null,
                new ItemStack(SandGenLvl2),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(S1),
                'W', new ItemStack(SandGenLvl1),
                'P', new ItemStack(Blocks.GOLD_BLOCK),
                'L', new ItemStack(SandGenLvl1));
        //SandGen_lvl3
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Sand_gen_lvl_3"), null,
                new ItemStack(SandGenLvl3),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(S2),
                'W', new ItemStack(SandGenLvl2),
                'P', new ItemStack(Blocks.DIAMOND_BLOCK),
                'L', new ItemStack(SandGenLvl2));
        //SandGen_lvl4
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Sand_gen_lvl_4"), null,
                new ItemStack(SandGenLvl4),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(S3),
                'W', new ItemStack(SandGenLvl3),
                'P', new ItemStack(Blocks.EMERALD_BLOCK),
                'L', new ItemStack(SandGenLvl3));
        //CobbleGen_Lvl_1
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Cobble_gen_lvl_1"), null,
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
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Cobble_gen_lvl_2"), null,
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
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Cobble_gen_lvl_3"), null,
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
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Cobble_gen_lvl_4"), null,
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