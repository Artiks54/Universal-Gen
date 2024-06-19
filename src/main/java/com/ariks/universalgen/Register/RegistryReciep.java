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
import static com.ariks.universalgen.Register.RegistryItems.*;

public class RegistryReciep {
    public static void preInit() {
        //COBBLE_STONE
        String[] Cobble_CLevel = {"1C", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C"};
        Block[] Cobble_CBlockInput = {Blocks.COBBLESTONE, C1, C2, C3, C4, C5, C6, C7, C8};
        Block[] Cobble_CBlockOutput = {C1, C2, C3, C4, C5, C6, C7, C8, C9};
        Block[] Cobble_CBlockInputRevers = {C9, C8, C7, C6, C5, C4, C3, C2, C1};
        Block[] Cobble_CBlockOutputRevers = {C8, C7, C6, C5, C4, C3, C2, C1, Blocks.COBBLESTONE};
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
        String[] Sand_CLevel = {"1S", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S"};
        Block[] Sand_CBlockInput = {Blocks.SAND, S1, S2, S3, S4, S5, S6, S7, S8};
        Block[] Sand_CBlockOutput = {S1, S2, S3, S4, S5, S6, S7, S8, S9};
        Block[] Sand_CBlockInputRevers = {S9, S8, S7, S6, S5, S4, S3, S2, S1};
        Block[] Sand_CBlockOutputRevers = {S8, S7, S6, S5, S4, S3, S2, S1, Blocks.SAND};
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
        //Gravel
        String[] Gravel_CLevel = {"1G", "2G", "3G", "4G", "5G", "6G", "7G", "8G", "9G"};
        Block[] Gravel_CBlockInput = {Blocks.GRAVEL, G1, G2, G3, G4, G5, G6, G7, G8};
        Block[] Gravel_CBlockOutput = {G1, G2, G3, G4, G5, G6, G7, G8, G9};
        Block[] Gravel_CBlockInputRevers = {G9, G8, G7, G6, G5, G4, G3, G2, G1};
        Block[] Gravel_CBlockOutputRevers = {G8, G7, G6, G5, G4, G3, G2, G1, Blocks.GRAVEL};
        for (int i = 0; i < Gravel_CLevel.length; i++) {
            String level = Gravel_CLevel[i];
            Block input = Gravel_CBlockInput[i];
            Block output = Gravel_CBlockOutput[i];
            String recipeID = "Gravel_" + level;
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(UniversalGen.MOD_ID, recipeID), null,
                    new ItemStack(output),
                    "CCC",
                    "CCC",
                    "CCC",
                    'C', new ItemStack(input));
        }
        for (int i = 0; i < Gravel_CLevel.length; i++) {
            String level = Gravel_CLevel[i];
            Block input = Gravel_CBlockInput[i];
            Block output = Gravel_CBlockOutput[i];
            String recipeID = "Gravel_Reverse" + level;
            GameRegistry.addShapelessRecipe(
                    new ResourceLocation(UniversalGen.MOD_ID, recipeID), null,
                    new ItemStack(output, 9),
                    Ingredient.fromItems(Item.getItemFromBlock(input))
            );
        }
        //Count_lvl_6
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Count_lvl_6"), null,
                new ItemStack(upgrade_count_lvl6),
                "FLF",
                "BFB",
                "FLF",
                'L', new ItemStack(Items.DYE,1,4),
                'F', new ItemStack(Items.FLINT),
                'B', new ItemStack(upgrade_count_lvl5));
        //Count_lvl_5
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Count_lvl_5"), null,
                new ItemStack(upgrade_count_lvl5),
                "FLF",
                "BFB",
                "FLF",
                'L', new ItemStack(Items.DYE,1,4),
                'F', new ItemStack(Items.FLINT),
                'B', new ItemStack(upgrade_count_lvl4));
        //Count_lvl_4
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Count_lvl_4"), null,
                new ItemStack(upgrade_count_lvl4),
                "FLF",
                "BFB",
                "FLF",
                'L', new ItemStack(Items.DYE,1,4),
                'F', new ItemStack(Items.FLINT),
                'B', new ItemStack(upgrade_count_lvl3));
        //Count_lvl_3
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Count_lvl_3"), null,
                new ItemStack(upgrade_count_lvl3),
                "FLF",
                "BFB",
                "FLF",
                'L', new ItemStack(Items.DYE,1,4),
                'F', new ItemStack(Items.FLINT),
                'B', new ItemStack(upgrade_count_lvl2));
        //Count_lvl_2
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Count_lvl_2"), null,
                new ItemStack(upgrade_count_lvl2),
                "FLF",
                "BFB",
                "FLF",
                'L', new ItemStack(Items.DYE,1,4),
                'F', new ItemStack(Items.FLINT),
                'B', new ItemStack(upgrade_count_lvl1));
        //Count_lvl_1
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Count_lvl_1"), null,
                new ItemStack(upgrade_count_lvl1),
                "LPL",
                "WBU",
                "LPL",
                'L', new ItemStack(Items.DYE,1,4),
                'P', new ItemStack(Blocks.PISTON),
                'B', new ItemStack(upgrade_blank),
                'U', new ItemStack(Items.LAVA_BUCKET),
                'W', new ItemStack(Items.WATER_BUCKET));
        //Speed_lvl_6
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Speed_lvl_6"), null,
                new ItemStack(upgrade_speed_lvl6),
                "IRI",
                "RBR",
                "IRI",
                'B', new ItemStack(upgrade_speed_lvl5),
                'R', new ItemStack(Items.REDSTONE),
                'I', new ItemStack(Items.DRAGON_BREATH));
        //Speed_lvl_5
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Speed_lvl_5"), null,
                new ItemStack(upgrade_speed_lvl5),
                "IRI",
                "RBR",
                "IRI",
                'B', new ItemStack(upgrade_speed_lvl4),
                'R', new ItemStack(Items.REDSTONE),
                'I', new ItemStack(Items.NETHER_STAR));
        //Speed_lvl_4
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Speed_lvl_4"), null,
                new ItemStack(upgrade_speed_lvl4),
                "IRI",
                "RBR",
                "IRI",
                'B', new ItemStack(upgrade_speed_lvl3),
                'R', new ItemStack(Items.REDSTONE),
                'I', new ItemStack(Items.EMERALD));
        //Speed_lvl_3
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Speed_lvl_3"), null,
                new ItemStack(upgrade_speed_lvl3),
                "IRI",
                "RBR",
                "IRI",
                'B', new ItemStack(upgrade_speed_lvl2),
                'R', new ItemStack(Items.REDSTONE),
                'I', new ItemStack(Items.DIAMOND));
        //Speed_lvl_2
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Speed_lvl_2"), null,
                new ItemStack(upgrade_speed_lvl2),
                "IRI",
                "RBR",
                "IRI",
                'B', new ItemStack(upgrade_speed_lvl1),
                'R', new ItemStack(Items.REDSTONE),
                'I', new ItemStack(Items.GOLD_INGOT));
        //Speed_lvl_1
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Speed_lvl_1"), null,
                new ItemStack(upgrade_speed_lvl1),
                "IRI",
                "RBR",
                "IRI",
                'B', new ItemStack(upgrade_blank),
                'R', new ItemStack(Items.REDSTONE),
                'I', new ItemStack(Items.IRON_INGOT));
        //Generator_Cobble
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Generator_Cobble"), null,
                new ItemStack(upgrade_gen_cobblestone),
                "III",
                "IBI",
                "III",
                'B', new ItemStack(upgrade_blank),
                'I', new ItemStack(Blocks.COBBLESTONE));
        //Generator_Gravel
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Generator_Gravel"), null,
                new ItemStack(upgrade_gen_gravel),
                "III",
                "IBI",
                "III",
                'B', new ItemStack(upgrade_blank),
                'I', new ItemStack(Blocks.GRAVEL));
        //Generator_Sand
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Generator_Sand"), null,
                new ItemStack(upgrade_gen_sand),
                "III",
                "IBI",
                "III",
                'B', new ItemStack(upgrade_blank),
                'I', new ItemStack(Blocks.SAND));
        //Upgrade_Blank
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Upgrade_Blank"), null,
                new ItemStack(upgrade_blank),
                "IOI",
                "PFP",
                "IOI",
                'O', new ItemStack(Items.DYE,1,14),
                'I', new ItemStack(Items.IRON_INGOT),
                'P', new ItemStack(Items.PAPER),
                'F', new ItemStack(Items.ITEM_FRAME));
        //Universal_Generator
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Universal_Generator"), null,
                new ItemStack(Universal_Generator),
                "CSG",
                "WPL",
                "CSG",
                'C', new ItemStack(C1),
                'S', new ItemStack(S1),
                'G', new ItemStack(G1),
                'W', new ItemStack(Items.WATER_BUCKET),
                'P', new ItemStack(Blocks.HOPPER),
                'L', new ItemStack(Items.LAVA_BUCKET));
    }
}