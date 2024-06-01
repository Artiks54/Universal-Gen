package com.ariks.universalgen.Item;

import com.ariks.universalgen.Block.COBBLE.CobbleGenTile;
import com.ariks.universalgen.Block.SAND.SandGenTile;
import com.ariks.universalgen.UniversalGen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

public class UpgradeItem extends Item {
    public UpgradeItem(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setMaxStackSize(64);
        this.setCreativeTab(UniversalGen.UniversalGenTab);
        this.setNoRepair();
    }
    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }
    @Override
    public @NotNull EnumActionResult onItemUse(@NotNull EntityPlayer player, @NotNull World worldIn, @NotNull BlockPos pos, @NotNull EnumHand hand, @NotNull EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if(!worldIn.isRemote && player.isSneaking()) {
            if (tile instanceof SandGenTile) {
                if (((SandGenTile) tile).getStackInSlot(1).isEmpty()) {
                    ((SandGenTile) tile).setInventorySlotContents(1, new ItemStack(this));
                    player.getHeldItem(hand).stackSize -=1;
                }
            }
            if (tile instanceof CobbleGenTile) {
                if (((CobbleGenTile) tile).getStackInSlot(1).isEmpty()) {
                    ((CobbleGenTile) tile).setInventorySlotContents(1, new ItemStack(this));
                    player.getHeldItem(hand).stackSize -=1;
                }
            }
        }
        return null;
    }
}