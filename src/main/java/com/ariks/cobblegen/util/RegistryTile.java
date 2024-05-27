package com.ariks.cobblegen.util;

import com.ariks.cobblegen.Block.CobbleGen.TileCobbleGen;
import com.ariks.cobblegen.CobbleGen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryTile {
    public static void preInit() {
        GameRegistry.registerTileEntity(TileCobbleGen.class, new ResourceLocation(CobbleGen.MOD_ID, "TileCobbleGen"));
    }
}
