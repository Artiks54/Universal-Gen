package com.ariks.sandgen.proxy;


import com.ariks.sandgen.Register.RegistryBlock;

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