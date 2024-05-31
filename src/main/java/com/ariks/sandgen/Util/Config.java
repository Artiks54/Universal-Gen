package com.ariks.sandgen.Util;

import com.ariks.sandgen.SandGen;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import java.io.File;

public class Config {
    protected static Configuration config;
    public static boolean BooleanHelloMsg;
    public static String TileName;
    private final static String speed = "_speed";
    private final static String count = "_count";
    private final static String TextS = "The speed in ticks to generate";
    private final static String TextC = "Number of items";
    public static boolean DebugMod;
    public static int speed_1,speed_2,speed_3,speed_4;
    public static int count_1,count_2,count_3,count_4;
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
//lvl_1
            TileName = "Sand_generator_lvl1";
            speed_1 = config.getInt(TileName+speed,Tile,20,1,Short.MAX_VALUE,TextS);
            count_1 = config.getInt(TileName+count,Tile,1,1,64,TextC);
//lvl_2
            TileName = "Sand_generator_lvl2";
            speed_2 = config.getInt(TileName+speed,Tile,20,1,Short.MAX_VALUE,TextS);
            count_2 = config.getInt(TileName+count,Tile,4,1,64,TextC);
//lvl_3
            TileName = "Sand_generator_lvl3";
            speed_3 = config.getInt(TileName+speed,Tile,20,1,Short.MAX_VALUE,TextS);
            count_3 = config.getInt(TileName+count,Tile,16,1,64,TextC);
//lvl_4
            TileName = "Sand_generator_lvl4";
            speed_4 = config.getInt(TileName+speed,Tile,20,1,Short.MAX_VALUE,TextS);
            count_4 = config.getInt(TileName+count,Tile,64,1,64,TextC);

        } finally {
            if(config.hasChanged()) config.save();
        }
    }
    public static void registerConfig(FMLPreInitializationEvent event){
        SandGen.config = new File(event.getModConfigurationDirectory()+"/"+SandGen.MOD_NAME);
        SandGen.config.mkdirs();
        init(new File(SandGen.config.getPath(),SandGen.MOD_NAME+".cfg"));
    }
}