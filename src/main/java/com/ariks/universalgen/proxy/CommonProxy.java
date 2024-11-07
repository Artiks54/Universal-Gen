package com.ariks.universalgen.proxy;

import com.ariks.universalgen.Block.UniversalGen.*;
import com.ariks.universalgen.Block.UniversalGen.GeneratorRecipes;
import com.ariks.universalgen.Register.*;
import com.ariks.universalgen.UniversalGen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
    public void preInit() {
        RegistryBlock.preInit();
        GameRegistry.registerTileEntity(TileUniversalGen.class, new ResourceLocation(UniversalGen.MOD_ID, "universal_generator"));
        GameRegistry.registerTileEntity(TileUniversalGenAdvanced.class, new ResourceLocation(UniversalGen.MOD_ID, "universal_generator_advanced"));
        GameRegistry.registerTileEntity(TileUniversalGenUltimate.class, new ResourceLocation(UniversalGen.MOD_ID, "universal_generator_ultimate"));
        GameRegistry.registerTileEntity(TileUniversalGenDragon.class, new ResourceLocation(UniversalGen.MOD_ID, "universal_generator_dragon"));
        RegistryReciep.preInit();
        GeneratorRecipes.initAllRecipes();
        NetworkRegistry.INSTANCE.registerGuiHandler(UniversalGen.instance, new RegistryGui());
    }
    public void Init(){
        RegistryNetwork.init();
    }
    public void postInit(){
    }
    public void registerItemRenderer(Item item, int meta, String id) {
    }
    public void renderItemOnScreen(ItemStack current, int x, int y) {}
}