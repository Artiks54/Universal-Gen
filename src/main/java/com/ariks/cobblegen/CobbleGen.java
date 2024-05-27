package com.ariks.cobblegen;

import com.ariks.cobblegen.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.jetbrains.annotations.NotNull;

@Mod(modid = CobbleGen.MODID, version = CobbleGen.VERSION, name = CobbleGen.NAME)
public class CobbleGen {
    public static final String MODID = "cobblegen";
    public static final String NAME = "Cobble Gen";
    public static final String VERSION = "1.0";
    @SidedProxy(clientSide = "com.ariks.cobblegen.proxy.ClientProxy", serverSide = "com.ariks.cobblegen.proxy.CommonProxy")
    public static CommonProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    }
    @EventHandler
    public void init(FMLInitializationEvent event){
    }
    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
    }
    public static CreativeTabs tabExampleMod = new CreativeTabs("Cobble-Gen") {
        @Override
        public @NotNull ItemStack getTabIconItem() {
            return new ItemStack(Blocks.COBBLESTONE);
        }
    };
}
