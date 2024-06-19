package com.ariks.universalgen.proxy;

import com.ariks.universalgen.Register.*;
import com.ariks.universalgen.UniversalGen;
import com.ariks.universalgen.Util.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
    public void preInit() {
        RegistryBlock.preInit();
        RegistryItems.preInit();
        RegistryTile.preInit();
        RegistryReciep.preInit();
        NetworkRegistry.INSTANCE.registerGuiHandler(UniversalGen.instance, new RegistryGui());
    }
    public void Init(){
        RegistryNetwork.init();
        MinecraftForge.EVENT_BUS.register(new JoinDiscord());
    }
    public void postInit(){
    }
}