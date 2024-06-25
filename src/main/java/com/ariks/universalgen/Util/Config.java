package com.ariks.universalgen.Util;

import com.ariks.universalgen.UniversalGen;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.jetbrains.annotations.NotNull;
import java.io.File;

public class Config {
    protected static Configuration config;
    public static boolean BooleanHelloMsg,BooleanCompressedCobblestone,BooleanCompressedSand,BooleanCompressedGravel;
    public static void init(File file) {
        config = new Configuration(file);
        try {config.load();
            String General = "General";
            config.setCategoryComment(General,"General settings");
            BooleanHelloMsg = config.getBoolean("Join_Discord",General,true,"Start message");
            BooleanCompressedCobblestone = config.getBoolean("Compressed_Cobblestone",General,true,"register");
            BooleanCompressedSand = config.getBoolean("Compressed_Sand",General,true,"register");
            BooleanCompressedGravel = config.getBoolean("Compressed_Gravel",General,true,"register");
        } finally {
            if(config.hasChanged()) config.save();
        }
    }
    public static void registerConfig(@NotNull FMLPreInitializationEvent event){
        UniversalGen.config = new File(event.getModConfigurationDirectory()+"/"+ UniversalGen.MOD_NAME);
        UniversalGen.config.mkdirs();
        init(new File(UniversalGen.config.getPath(),UniversalGen.MOD_NAME+".cfg"));
    }
}