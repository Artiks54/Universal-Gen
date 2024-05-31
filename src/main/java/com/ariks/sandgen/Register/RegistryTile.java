package com.ariks.sandgen.Register;

import com.ariks.sandgen.Block.CobbleGen.TileGen;
import com.ariks.sandgen.SandGen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryTile {
    public static void preInit() {
        GameRegistry.registerTileEntity(TileGen.class, new ResourceLocation(SandGen.MOD_ID, "SandGen"));
    }
}
