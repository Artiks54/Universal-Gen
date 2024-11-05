package com.ariks.universalgen.Util;

import com.ariks.universalgen.UniversalGen;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public class Config {
    protected static Configuration config;
    public static int RequiredGeneratorTick;
    public static int RequiredGeneratorTickAdvanced;
    public static int RequiredGeneratorTickUltimate;
    public static int RequiredGeneratorTickDragon;
    public static void init(File file) {
        config = new Configuration(file);
        try {config.load();
            String Tile = "Tile";
            config.setCategoryComment(Tile,"TileEntity settings.");
            //Universal Generator
            RequiredGeneratorTick = config.getInt("Tile_Generator_Normal_NeedTick",Tile,20,1,Short.MAX_VALUE,"Need ticks to generate");
            RequiredGeneratorTickAdvanced = config.getInt("Tile_Generator_Advanced_NeedTick",Tile,10,1,Short.MAX_VALUE,"Need ticks to generate");
            RequiredGeneratorTickUltimate = config.getInt("Tile_Generator_Ultimate_NeedTick",Tile,5,1,Short.MAX_VALUE,"Need ticks to generate");
            RequiredGeneratorTickDragon = config.getInt("Tile_Generator_Dragon_NeedTick",Tile,1,1,Short.MAX_VALUE,"Need ticks to generate");
        } finally {
            if(config.hasChanged()) config.save();
        }
    }
    public static void registerConfig(@NotNull FMLPreInitializationEvent event){
        UniversalGen.config = new File(event.getModConfigurationDirectory()+"/"+"AriksProject54");
        UniversalGen.config.mkdirs();
        init(new File(UniversalGen.config.getPath(),UniversalGen.MOD_NAME+".cfg"));
    }
}