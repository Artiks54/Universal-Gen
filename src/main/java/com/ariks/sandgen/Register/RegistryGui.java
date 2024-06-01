package com.ariks.sandgen.Register;

import com.ariks.sandgen.Block.CobbleGen.SandGenBlockContainer;
import com.ariks.sandgen.Block.CobbleGen.SandGenGui;
import com.ariks.sandgen.Block.CobbleGen.TileGen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.Objects;

public class RegistryGui implements IGuiHandler {
    public static final int GUI_SAND_GEN = 0;
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_SAND_GEN) {
            return new SandGenBlockContainer(player.inventory, (TileGen) Objects.requireNonNull(world.getTileEntity(new BlockPos(x, y, z))), player);
        }
        return null;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement ( int ID, EntityPlayer player, World world,int x, int y, int z){
        if (ID == GUI_SAND_GEN) {
            return new SandGenGui(player.inventory, (TileGen) world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        return null;
    }
}

