package com.ariks.universalgen.Block;

import com.ariks.universalgen.UniversalGen;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.jetbrains.annotations.NotNull;


public class CompressedSandBlock extends Block {
    public CompressedSandBlock(String name) {
        super(Material.IRON);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(UniversalGen.UniversalGenTab);
        this.setHardness(2.0F);
        this.setResistance(4.0f);
        this.setSoundType(SoundType.METAL);
        this.setHarvestLevel("shovel", 2);
    }
    @Override
    public boolean canHarvestBlock(@NotNull IBlockAccess world, @NotNull BlockPos pos, @NotNull EntityPlayer player) {
        return true;
    }
}