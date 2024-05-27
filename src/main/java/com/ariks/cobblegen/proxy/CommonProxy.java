package com.ariks.cobblegen.proxy;

import com.ariks.cobblegen.CobbleGen;
import com.ariks.cobblegen.util.RegistryBlock;
import com.ariks.cobblegen.util.RegistryGui;
import com.ariks.cobblegen.util.RegistryTile;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
    public void preInit() {
        RegistryBlock.preInit();
        RegistryTile.preInit();
        NetworkRegistry.INSTANCE.registerGuiHandler(CobbleGen.instance, new RegistryGui());
    }
    public void Init(){
    }
    public void postInit(){
    }
}