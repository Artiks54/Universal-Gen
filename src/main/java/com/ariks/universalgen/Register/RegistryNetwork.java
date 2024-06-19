package com.ariks.universalgen.Register;

import com.ariks.universalgen.Network.UpdateTilePacket;
import com.ariks.universalgen.UniversalGen;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class RegistryNetwork {
    public static SimpleNetworkWrapper network;
    public static void init() {
        network = NetworkRegistry.INSTANCE.newSimpleChannel(UniversalGen.MOD_ID);
        network.registerMessage(UpdateTilePacket.Handler.class, UpdateTilePacket.class, 1, Side.SERVER);
    }
}