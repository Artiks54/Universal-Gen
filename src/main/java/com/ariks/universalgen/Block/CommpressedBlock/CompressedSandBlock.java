package com.ariks.universalgen.Block.CommpressedBlock;

import com.ariks.universalgen.UniversalGen;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.SoundType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class CompressedSandBlock extends BlockFalling {
    String tooltip;
    public CompressedSandBlock(String name,String tooltip) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(UniversalGen.UniversalGenTab);
        this.setHardness(2.0F);
        this.setResistance(4.0f);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("shovel", 2);
        this.tooltip = tooltip;
    }
    @Override
    public boolean canHarvestBlock(@NotNull IBlockAccess world, @NotNull BlockPos pos, @NotNull EntityPlayer player) {
        return true;
    }
    @Override
    public void addInformation(@NotNull ItemStack stack, @Nullable World player, @NotNull List<String> tooltip, @NotNull ITooltipFlag advanced) {
        tooltip.add(this.tooltip);
    }
}