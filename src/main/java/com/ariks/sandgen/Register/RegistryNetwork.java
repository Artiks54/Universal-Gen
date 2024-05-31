package com.ariks.sandgen.Register;

import com.ariks.sandgen.Network.UpdateTilePacket;
import com.ariks.sandgen.SandGen;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class RegistryNetwork {
    public static SimpleNetworkWrapper network;
    public static void init() {
        network = NetworkRegistry.INSTANCE.newSimpleChannel(SandGen.MOD_ID);
        network.registerMessage(UpdateTilePacket.Handler.class, UpdateTilePacket.class, 1, Side.SERVER);
    }
}
