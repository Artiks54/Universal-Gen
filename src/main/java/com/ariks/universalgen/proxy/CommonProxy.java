package com.ariks.universalgen.proxy;

import com.ariks.universalgen.Register.*;
import com.ariks.universalgen.UniversalGen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.network.NetworkRegistry;


public class CommonProxy {
    public void preInit() {
        RegistryBlock.preInit();
        RegistryTile.preInit();
        RegisrtyRecipes.preInit();
        NetworkRegistry.INSTANCE.registerGuiHandler(UniversalGen.instance, new RegistryGui());
    }
    public void Init(){
        RegistryNetwork.init();
    }
    public void postInit(){
    }
    public void registerItemRenderer(Item item, int meta, String id) {
    }
    public void renderItemOnScreen(ItemStack current, int x, int y) {}
}