package com.ariks.sandgen.proxy;

import com.ariks.sandgen.Register.*;
import com.ariks.sandgen.SandGen;
import com.ariks.sandgen.Util.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
    public void preInit() {
        RegistryBlock.preInit();
        RegistryTile.preInit();
        RegistryReciep.preInit();
        NetworkRegistry.INSTANCE.registerGuiHandler(SandGen.instance, new RegistryGui());
    }
    public void Init(){
        RegistryNetwork.init();
        if(Config.BooleanHelloMsg) {
            MinecraftForge.EVENT_BUS.register(new JoinDiscord());
        }
    }
    public void postInit(){
    }
}