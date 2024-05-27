package com.ariks.cobblegen.util;

import com.ariks.cobblegen.Block.CobbleGen.CobbleGenBlockContainer;
import com.ariks.cobblegen.Block.CobbleGen.CobbleGenGui;
import com.ariks.cobblegen.Block.CobbleGen.TileGen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class RegistryGui implements IGuiHandler {
    public static final int GUI_COBBLE_GEN = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == GUI_COBBLE_GEN) {
            return new CobbleGenBlockContainer(player.inventory, (TileGen) world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        return null;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement ( int ID, EntityPlayer player, World world,int x, int y, int z){
        if (ID == GUI_COBBLE_GEN) {
            return new CobbleGenGui(player.inventory, (TileGen) world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        return null;
    }
}

