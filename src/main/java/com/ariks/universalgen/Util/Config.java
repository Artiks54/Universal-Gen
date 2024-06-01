package com.ariks.universalgen.Util;

import com.ariks.universalgen.UniversalGen;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import java.io.File;

public class Config {
    protected static Configuration config;
    public static String TileName;
    private final static String count = "_count";
    private final static String TextC = "Number of items";
    public static boolean DebugMod,IntegrationTheOneProbeTA,BooleanHelloMsg;
    public static int Scount_1,Scount_2,Scount_3,Scount_4,Scount_5;
    public static int Ccount_1,Ccount_2,Ccount_3,Ccount_4,Ccount_5;
    public static void init(File file) {
        config = new Configuration(file);
        try {config.load();
            String General = "General";
            String Tile = "Tile";
            config.setCategoryComment(General,"General settings");
            config.setCategoryComment(Tile,"TileEntity settings .Before changing these values, it is best to destroy the already installed TileEntity \n" +
                    "If this is not possible, then in order for the value in TileEntity to change, it will need to be set again.");
            DebugMod = config.getBoolean("Debug_Mode",General,false,"Debug modes");
            BooleanHelloMsg = config.getBoolean("Hello_Message",General,true,"Send chat hello message");
            IntegrationTheOneProbeTA = config.getBoolean("integration_top_addons",General,true,"Integration TheOneProbe-TopAddons");
//lvl_1
            TileName = "Sand_generator_lvl1";
            Scount_1 = config.getInt(TileName+count,Tile,1,1,64,TextC);
//lvl_2
            TileName = "Sand_generator_lvl2";
            Scount_2 = config.getInt(TileName+count,Tile,4,1,64,TextC);
//lvl_3
            TileName = "Sand_generator_lvl3";
            Scount_3 = config.getInt(TileName+count,Tile,16,1,64,TextC);
//lvl_4
            TileName = "Sand_generator_lvl4";
            Scount_4 = config.getInt(TileName+count,Tile,32,1,64,TextC);
//lvl_5
            TileName = "Sand_generator_lvl5";
            Scount_5 = config.getInt(TileName+count,Tile,64,1,64,TextC);
//lvl_1
            TileName = "Cobble_generator_lvl1";
            Ccount_1 = config.getInt(TileName+count,Tile,1,1,64,TextC);
//lvl_2
            TileName = "Cobble_generator_lvl2";
            Ccount_2 = config.getInt(TileName+count,Tile,4,1,64,TextC);
//lvl_3
            TileName = "Cobble_generator_lvl3";
            Ccount_3 = config.getInt(TileName+count,Tile,16,1,64,TextC);
//lvl_4
            TileName = "Cobble_generator_lvl4";
            Ccount_4 = config.getInt(TileName+count,Tile,32,1,64,TextC);
//lvl_5
            TileName = "Cobble_generator_lvl5";
            Ccount_5 = config.getInt(TileName+count,Tile,64,1,64,TextC);
        } finally {
            if(config.hasChanged()) config.save();
        }
    }
    public static void registerConfig(FMLPreInitializationEvent event){
        UniversalGen.config = new File(event.getModConfigurationDirectory()+"/"+ UniversalGen.MOD_NAME);
        UniversalGen.config.mkdirs();
        init(new File(UniversalGen.config.getPath(), UniversalGen.MOD_NAME+".cfg"));
    }
}