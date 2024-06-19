package com.ariks.universalgen.Block.UniversalGen;


import com.ariks.universalgen.UniversalGen;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlockUniversalGen extends Block {
    public BlockUniversalGen(String name) {
        super(Material.IRON);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(UniversalGen.UniversalGenTab);
        this.setHardness(2.5F);
        this.setResistance(3.5f);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("pickaxe", 1);
    }
    @Nullable
    @Override
    public TileEntity createTileEntity(@NotNull World world, @NotNull IBlockState state) {
        return new TileUniversalGen();
    }
    @Override
    public boolean onBlockActivated(@NotNull World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state, @NotNull EntityPlayer playerIn, @NotNull EnumHand hand, @NotNull EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntity tile = worldIn.getTileEntity(pos);
        if (!worldIn.isRemote && tile instanceof TileUniversalGen) {
            int id = Integer.parseInt(((TileUniversalGen) tile).getGuiID());
            playerIn.openGui(UniversalGen.instance, id, worldIn, pos.getX(), pos.getY(), pos.getZ());
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
    @Override
    public void breakBlock(World worldIn, @NotNull BlockPos pos, @NotNull IBlockState state) {
        TileEntity tileEntity = worldIn.getTileEntity(pos);
        assert tileEntity != null;
        InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tileEntity);
        super.breakBlock(worldIn, pos, state);
    }
    @Override
    public @NotNull AxisAlignedBB getBoundingBox(@NotNull IBlockState state, @NotNull IBlockAccess source, @NotNull BlockPos pos) {
        return new AxisAlignedBB(0.062, 0, 0.062, 0.938, 0.875, 0.938);
    }
    @Override
    public boolean isOpaqueCube(@NotNull IBlockState state) {
        return false;
    }
    @Override
    public boolean isNormalCube(@NotNull IBlockState state, @NotNull IBlockAccess world, @NotNull BlockPos pos) {
        return false;
    }
    @Override
    public boolean isFullCube(@NotNull IBlockState state) {
        return false;
    }
}
