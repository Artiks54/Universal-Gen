package com.ariks.cobblegen.proxy;

import com.ariks.cobblegen.CobbleGen;
import com.ariks.cobblegen.util.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
    public void preInit() {
        RegistryBlock.preInit();
        RegistryTile.preInit();
        RegistryReciep.preInit();
        NetworkRegistry.INSTANCE.registerGuiHandler(CobbleGen.instance, new RegistryGui());
    }
    public void Init(){
        if(Config.BooleanHelloMsg) {
            MinecraftForge.EVENT_BUS.register(new JoinDiscord());
        }
    }
    public void postInit(){
    }
}