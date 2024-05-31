package com.ariks.sandgen.Register;

import com.ariks.sandgen.SandGen;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import static com.ariks.sandgen.Register.RegistryBlock.*;
public class RegistryReciep {
    public static void preInit() {
        String[] Level = {"1","2","3","4","5","6","7","8","9"};
        Block[] CBlockInput = {Blocks.SAND,S1,S2,S3,S4,S5,S6,S7,S8};
        Block[] CBlockOutput = {S1,S2,S3,S4,S5,S6,S7,S8,S9};
        Block[] CBlockInputRevers = {S9,S8,S7,S6,S5,S4,S3,S2,S1};
        Block[] CBlockOutputRevers = {S8,S7,S6,S5,S4,S3,S2,S1,Blocks.SAND};
        //Block to block
        for (int i = 0; i < Level.length; i++) {
            String level = Level[i];
            Block input = CBlockInput[i];
            Block output = CBlockOutput[i];
            String recipeID = "Compressed_" + level;
            GameRegistry.addShapedRecipe(
                    new ResourceLocation(SandGen.MOD_ID, recipeID), null,
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
                    new ResourceLocation(SandGen.MOD_ID, recipeID), null,
                    new ItemStack(output, 9),
                    Ingredient.fromItems(Item.getItemFromBlock(input))
            );
        }
        //CobbleGen_Lvl_1
        GameRegistry.addShapedRecipe(
                new ResourceLocation(SandGen.MOD_ID + ":" + "Sand_gen_lvl_1"), null,
                new ItemStack(SandGenLvl1),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(Blocks.SAND),
                'W', new ItemStack(Items.WATER_BUCKET),
                'P', new ItemStack(Blocks.IRON_BLOCK),
                'L', new ItemStack(Items.LAVA_BUCKET));
        //CobbleGen_Lvl_2
        GameRegistry.addShapedRecipe(
                new ResourceLocation(SandGen.MOD_ID + ":" + "Sand_gen_lvl_2"), null,
                new ItemStack(SandGenLvl2),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(S1),
                'W', new ItemStack(SandGenLvl1),
                'P', new ItemStack(Blocks.GOLD_BLOCK),
                'L', new ItemStack(SandGenLvl1));
        //CobbleGen_Lvl_3
        GameRegistry.addShapedRecipe(
                new ResourceLocation(SandGen.MOD_ID + ":" + "Sand_gen_lvl_3"), null,
                new ItemStack(SandGenLvl3),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(S2),
                'W', new ItemStack(SandGenLvl2),
                'P', new ItemStack(Blocks.DIAMOND_BLOCK),
                'L', new ItemStack(SandGenLvl2));
        //CobbleGen_Lvl_4
        GameRegistry.addShapedRecipe(
                new ResourceLocation(SandGen.MOD_ID + ":" + "Sand_gen_lvl_4"), null,
                new ItemStack(SandGenLvl4),
                "CCC",
                "WPL",
                "CCC",
                'C', new ItemStack(S3),
                'W', new ItemStack(SandGenLvl3),
                'P', new ItemStack(Blocks.EMERALD_BLOCK),
                'L', new ItemStack(SandGenLvl3));
    }
}