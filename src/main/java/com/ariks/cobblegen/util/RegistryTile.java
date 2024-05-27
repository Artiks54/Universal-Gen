package com.ariks.cobblegen.util;

import com.ariks.cobblegen.Block.CobbleGen.TileGen;
import com.ariks.cobblegen.CobbleGen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryTile {
    public static void preInit() {
        GameRegistry.registerTileEntity(TileGen.class, new ResourceLocation(CobbleGen.MOD_ID, "CobbleGen"));
    }
}
