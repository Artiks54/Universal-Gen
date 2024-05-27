package com.ariks.cobblegen;

import com.ariks.cobblegen.proxy.CommonProxy;
import com.ariks.cobblegen.util.Config;
import com.ariks.cobblegen.util.RegistryBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import java.io.File;

@Mod(modid = CobbleGen.MOD_ID, version = CobbleGen.VERSION, name = CobbleGen.MOD_NAME,useMetadata = true, acceptedMinecraftVersions = "[1.12]")
public class CobbleGen {
    public static File config;
    public static final String MOD_ID = "cobblegen";
    public static final String MOD_NAME = "Cobble Gen";
    public static final String VERSION = "1.0";
    public static Logger logger;
    @Mod.Instance(CobbleGen.MOD_ID)
    public static CobbleGen instance;
    @SidedProxy(clientSide = "com.ariks.cobblegen.proxy.ClientProxy", serverSide = "com.ariks.cobblegen.proxy.CommonProxy")
    public static CommonProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        Config.registerConfig(event);
        proxy.preInit();
        logger = event.getModLog();
    }
    @EventHandler
    public void init(FMLInitializationEvent event){
        proxy.Init();
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit();
    }
    public static CreativeTabs CobbleGenTab = new CreativeTabs("CobbleGen") {
        @Override
        public @NotNull ItemStack getTabIconItem() {
            return new ItemStack(RegistryBlock.CobbleGenLvl1);
        }
    };
}
