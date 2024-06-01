package com.ariks.universalgen.proxy;


import com.ariks.universalgen.Register.RegistryBlock;
import com.ariks.universalgen.Register.RegistryItems;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
    }
    @Override
    public void Init() {
        super.Init();
        RegistryBlock.registerRender();
        RegistryItems.registerRender();
    }
    @Override
    public void postInit(){
        super.postInit();
    }
}