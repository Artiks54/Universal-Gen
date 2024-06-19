package com.ariks.universalgen.Register;

import com.ariks.universalgen.Block.UniversalGen.TileUniversalGen;
import com.ariks.universalgen.UniversalGen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryTile {
    public static void preInit() {
        GameRegistry.registerTileEntity(TileUniversalGen.class, new ResourceLocation(UniversalGen.MOD_ID, "CobbleGen"));
    }
}
