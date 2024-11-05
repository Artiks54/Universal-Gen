package com.ariks.universalgen.Register;

import com.ariks.universalgen.UniversalGen;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import static com.ariks.universalgen.Register.RegistryBlock.*;

public class RegistryReciep {
    public static void preInit() {
        //Universal_Generator
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Universal_Generator"), null,
                new ItemStack(Universal_Generator),
                "CSG",
                "WPL",
                "DNE",
                'D', new ItemStack(Blocks.DIRT),
                'N', new ItemStack(Blocks.NETHERRACK),
                'E', new ItemStack(Blocks.END_STONE),
                'C', new ItemStack(Blocks.COBBLESTONE),
                'S', new ItemStack(Blocks.SAND),
                'G', new ItemStack(Blocks.GRAVEL),
                'W', new ItemStack(Items.WATER_BUCKET),
                'P', new ItemStack(Items.NETHER_STAR),
                'L', new ItemStack(Items.LAVA_BUCKET));
        //Advanced
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Universal_Generator_Advanced"), null,
                new ItemStack(Universal_Generator_Advanced),
                "BGB",
                "BPB",
                "BGB",
                'B', new ItemStack(Blocks.GOLD_BLOCK),
                'P', new ItemStack(Items.GOLDEN_PICKAXE),
                'G', new ItemStack(Universal_Generator));
        //Ultimate
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Universal_Generator_Ultimate"), null,
                new ItemStack(Universal_Generator_Ultimate),
                "BGB",
                "BPB",
                "BGB",
                'B', new ItemStack(Blocks.DIAMOND_BLOCK),
                'P', new ItemStack(Items.DIAMOND_PICKAXE),
                'G', new ItemStack(Universal_Generator_Advanced));
        //Dragon
        GameRegistry.addShapedRecipe(
                new ResourceLocation(UniversalGen.MOD_ID + ":" + "Universal_Generator_Dragon"), null,
                new ItemStack(Universal_Generator_Dragon),
                "BGB",
                "BPB",
                "BGB",
                'B', new ItemStack(Items.NETHER_STAR),
                'P', new ItemStack(Blocks.DRAGON_EGG),
                'G', new ItemStack(Universal_Generator_Ultimate));
    }
}