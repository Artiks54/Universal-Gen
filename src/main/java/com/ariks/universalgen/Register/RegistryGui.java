package com.ariks.universalgen.Register;

import com.ariks.universalgen.Block.COBBLE.CobbleGenBlockContainer;
import com.ariks.universalgen.Block.COBBLE.CobbleGenGui;
import com.ariks.universalgen.Block.COBBLE.CobbleGenTile;
import com.ariks.universalgen.Block.SAND.SandGenBlockContainer;
import com.ariks.universalgen.Block.SAND.SandGenGui;
import com.ariks.universalgen.Block.SAND.SandGenTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.Objects;

public class RegistryGui implements IGuiHandler {
    public static final int GUI_SAND_GEN = 0;
    public static final int GUI_COBBLE_GEN = 1;
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_SAND_GEN) {
            return new SandGenBlockContainer(player.inventory, (SandGenTile) Objects.requireNonNull(world.getTileEntity(new BlockPos(x, y, z))), player);
        }
        if (ID == GUI_COBBLE_GEN) {
            return new CobbleGenBlockContainer(player.inventory, (CobbleGenTile) Objects.requireNonNull(world.getTileEntity(new BlockPos(x, y, z))), player);
        }
        return null;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement ( int ID, EntityPlayer player, World world,int x, int y, int z){
        if (ID == GUI_SAND_GEN) {
            return new SandGenGui(player.inventory, (SandGenTile) world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        if (ID == GUI_COBBLE_GEN) {
            return new CobbleGenGui(player.inventory, (CobbleGenTile) world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        return null;
    }
}

