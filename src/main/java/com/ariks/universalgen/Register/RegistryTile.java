package com.ariks.universalgen.Register;

import com.ariks.universalgen.Block.COBBLE.CobbleGenTile;
import com.ariks.universalgen.Block.SAND.SandGenTile;
import com.ariks.universalgen.UniversalGen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryTile {
    public static void preInit() {
        GameRegistry.registerTileEntity(SandGenTile.class, new ResourceLocation(UniversalGen.MOD_ID, "SandGen"));
        GameRegistry.registerTileEntity(CobbleGenTile.class, new ResourceLocation(UniversalGen.MOD_ID, "CobbleGen"));
    }
}
