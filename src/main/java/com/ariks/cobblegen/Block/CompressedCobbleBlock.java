package com.ariks.cobblegen.Block;

import com.ariks.cobblegen.CobbleGen;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;

public class CompressedCobbleBlock extends Block {
    String string;
    public CompressedCobbleBlock(String name,String tooltip) {
        super(Material.IRON);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(CobbleGen.CobbleGenTab);
        this.setHardness(3.5F);
        this.setResistance(6.5f);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("pickaxe", 2);
        this.string = tooltip;
    }
    @Override
    public boolean canHarvestBlock(@NotNull IBlockAccess world, @NotNull BlockPos pos, @NotNull EntityPlayer player) {
        return true;
    }
    @Override
    public void addInformation(@NotNull ItemStack stack, @Nullable World player, @NotNull List<String> tooltip, @NotNull ITooltipFlag advanced) {
        tooltip.add(string);
    }
}
