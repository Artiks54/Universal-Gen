package com.ariks.universalgen.Network;

import com.ariks.universalgen.Block.SandGen.TileGen;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class UpdateTilePacket implements IMessage {
    private BlockPos pos;
    private int value;
    public UpdateTilePacket() {}
    public UpdateTilePacket(BlockPos pos, int value) {
        this.value = value;
        this.pos = pos;
    }
    @Override
    public void fromBytes(ByteBuf buf) {
        this.pos = BlockPos.fromLong(buf.readLong());
        this.value = buf.readInt();
    }
    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(this.pos.toLong());
        buf.writeInt(value);
    }
    public static class Handler implements IMessageHandler<UpdateTilePacket, IMessage> {
        @Override
        public IMessage onMessage(UpdateTilePacket message, MessageContext ctx) {
            WorldServer world = ctx.getServerHandler().player.getServerWorld();
            BlockPos pos = message.pos;
            world.addScheduledTask(() -> {
                if (world.isBlockLoaded(pos)) {
                    TileEntity tile = world.getTileEntity(pos);
                    if(tile instanceof TileGen) {
                        TileGen TileGen = (TileGen) tile;
                        if (message.value == 1) {
                            TileGen.ToogleMode();
                        }
                    }
                }
            });
            return null;
        }
    }
}
