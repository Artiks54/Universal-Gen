package com.ariks.universalgen.Register;

import com.ariks.universalgen.Block.UniversalGen.TileUniversalGen;
import com.ariks.universalgen.Block.UniversalGen.TileUniversalGenAdvanced;
import com.ariks.universalgen.Block.UniversalGen.TileUniversalGenDragon;
import com.ariks.universalgen.Block.UniversalGen.TileUniversalGenUltimate;
import com.ariks.universalgen.UniversalGen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegistryTile {
    public static void preInit(){
        GameRegistry.registerTileEntity(TileUniversalGen.class, new ResourceLocation(UniversalGen.MOD_ID, "universal_generator"));
        GameRegistry.registerTileEntity(TileUniversalGenAdvanced.class, new ResourceLocation(UniversalGen.MOD_ID, "universal_generator_advanced"));
        GameRegistry.registerTileEntity(TileUniversalGenUltimate.class, new ResourceLocation(UniversalGen.MOD_ID, "universal_generator_ultimate"));
        GameRegistry.registerTileEntity(TileUniversalGenDragon.class, new ResourceLocation(UniversalGen.MOD_ID, "universal_generator_dragon"));
    }
}
