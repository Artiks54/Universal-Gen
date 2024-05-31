package com.ariks.sandgen;

import com.ariks.sandgen.proxy.CommonProxy;
import com.ariks.sandgen.Util.Config;
import com.ariks.sandgen.Register.RegistryBlock;
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

@Mod(modid = SandGen.MOD_ID, version = SandGen.VERSION, name = SandGen.MOD_NAME,useMetadata = true, acceptedMinecraftVersions = "[1.12]")
public class SandGen {
    public static File config;
    public static final String MOD_ID = "sandgen";
    public static final String MOD_NAME = "Sand Gen";
    public static final String VERSION = "1.3";
    public static Logger logger;
    @Mod.Instance(SandGen.MOD_ID)
    public static SandGen instance;
    @SidedProxy(clientSide = "com.ariks.sandgen.proxy.ClientProxy", serverSide = "com.ariks.sandgen.proxy.CommonProxy")
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
    public static CreativeTabs SandGenTab = new CreativeTabs("SandGen") {
        @Override
        public @NotNull ItemStack getTabIconItem() {
            return new ItemStack(RegistryBlock.SandGenLvl1);
        }
    };
}
