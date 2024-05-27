package com.ariks.cobblegen.proxy;

import com.ariks.cobblegen.util.RegistryBlock;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
    }
    @Override
    public void Init() {
        super.Init();
        RegistryBlock.registerRender();
    }
    @Override
    public void postInit(){
        super.postInit();
    }
}