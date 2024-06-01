package com.ariks.universalgen;

import com.ariks.universalgen.proxy.CommonProxy;
import com.ariks.universalgen.Util.Config;
import com.ariks.universalgen.Register.RegistryBlock;
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

@Mod(modid = UniversalGen.MOD_ID, version = UniversalGen.VERSION, name = UniversalGen.MOD_NAME,useMetadata = true, acceptedMinecraftVersions = "[1.12]")
public class UniversalGen {
    public static File config;
    public static final String MOD_ID = "universalgen";
    public static final String MOD_NAME = "Universal Gen";
    public static final String VERSION = "1.1";
    public static Logger logger;
    @Mod.Instance(UniversalGen.MOD_ID)
    public static UniversalGen instance;
    @SidedProxy(clientSide = "com.ariks.universalgen.proxy.ClientProxy", serverSide = "com.ariks.universalgen.proxy.CommonProxy")
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
    public static CreativeTabs UniversalGenTab = new CreativeTabs("universalgen") {
        @Override
        public @NotNull ItemStack getTabIconItem() {
            return new ItemStack(RegistryBlock.SandGenLvl1);
        }
    };
}
