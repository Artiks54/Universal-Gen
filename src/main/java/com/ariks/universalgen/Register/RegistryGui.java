package com.ariks.universalgen.Register;

import com.ariks.universalgen.Block.UniversalGen.ContainerUniversalGen;
import com.ariks.universalgen.Block.UniversalGen.GuiUniversalGen;
import com.ariks.universalgen.Block.UniversalGen.TileUniversalGen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.Objects;

public class RegistryGui implements IGuiHandler {
    public static final int Gui_Universal_gen = 0;
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (ID == Gui_Universal_gen) {
            return new ContainerUniversalGen(player.inventory, (TileUniversalGen) Objects.requireNonNull(world.getTileEntity(new BlockPos(x, y, z))), player);
        }
        return null;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public Object getClientGuiElement ( int ID, EntityPlayer player, World world,int x, int y, int z){
        if (ID == Gui_Universal_gen) {
            return new GuiUniversalGen(player.inventory, (TileUniversalGen) world.getTileEntity(new BlockPos(x, y, z)), player);
        }
        return null;
    }
}