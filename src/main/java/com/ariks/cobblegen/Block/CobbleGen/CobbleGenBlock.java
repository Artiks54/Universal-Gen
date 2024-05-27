package com.ariks.cobblegen.Block.CobbleGen;

import com.ariks.cobblegen.CobbleGen;
import com.ariks.cobblegen.util.Config;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CobbleGenBlock extends Block {
    private final CobbleGenBlockEnum tileType;
    public CobbleGenBlock(String name,CobbleGenBlockEnum tileType) {
        super(Material.IRON);
        this.setRegistryName(name);
        this.tileType = tileType;
        this.setUnlocalizedName(name);
        this.setCreativeTab(CobbleGen.CobbleGenTab);
        this.setHardness(2.5F);
        this.setResistance(4.5f);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("pickaxe", 1);
    }
    @Override
    public boolean onBlockActivated(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state, @NotNull EntityPlayer playerIn, @NotNull EnumHand hand, @NotNull EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if(!worldIn.isRemote && tile instanceof TileGen){
            int id = Integer.parseInt(((TileGen) tile).getGuiID());
            playerIn.openGui(CobbleGen.instance,id,worldIn,pos.getX(),pos.getY(),pos.getZ());
        }
        return true;
    }
    @Override
    public boolean hasTileEntity(@NotNull IBlockState state) {
        return true;
    }
    @Override
    public boolean canHarvestBlock(@NotNull IBlockAccess world, @NotNull BlockPos pos, @NotNull EntityPlayer player) {
        return true;
    }
    @Nullable
    @Override
    public TileEntity createTileEntity(@NotNull World world, @NotNull IBlockState state) {
        TileGen tileEntity = new TileGen();
        tileEntity.count = tileType.getCount();
        tileEntity.speed = tileType.getSpeed();
        return tileEntity;
    }
    @Override
    public void breakBlock(World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state) {
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        assert tileEntity != null;
        InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tileEntity);
        super.breakBlock(worldIn, pos, state);
    }
    @Override
    public void onBlockPlacedBy(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state, @NotNull EntityLivingBase placer, @NotNull ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if (Config.DebugMod && !worldIn.isRemote) {
            CobbleGen.logger.info(
                    "CobbleGen-log: Block place: "+getUnlocalizedName()+" Cord: " + pos.getX() + "," + pos.getY() + "," + pos.getZ()+" DismID: "+worldIn.provider.getDimension()+" PlayerName: "+placer.getName());
        }
    }
}