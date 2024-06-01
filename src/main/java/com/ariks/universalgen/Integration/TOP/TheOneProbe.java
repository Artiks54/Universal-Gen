package com.ariks.universalgen.Integration.TOP;

import com.ariks.universalgen.Block.SandGen.TileGen;
import com.ariks.universalgen.UniversalGen;
import com.ariks.universalgen.Util.Config;
import io.github.drmanganese.topaddons.addons.AddonBlank;
import io.github.drmanganese.topaddons.api.TOPAddon;
import mcjty.theoneprobe.api.IProbeHitData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@TOPAddon(dependency = UniversalGen.MOD_ID, order = 0)
public class TheOneProbe extends AddonBlank {
    @Override
    public void addProbeInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, EntityPlayer entityPlayer, World world, IBlockState iBlockState, IProbeHitData iProbeHitData) {
        TileEntity tile = world.getTileEntity(iProbeHitData.getPos());
        if(Config.IntegrationTheOneProbeTA) {
            if (tile instanceof TileGen) {
                TileGen tileGen = (TileGen) tile;
                if (tileGen.getField(3) == 0) {
                    iProbeInfo.text("Mode: in");
                }
                if (tileGen.getField(3) == 1) {
                    iProbeInfo.text("Mode: out");
                }
                int percent = ((tileGen.getField(1) * 100) / tileGen.getField(2));
                iProbeInfo.progress(percent, 100);
                iProbeInfo.item(new ItemStack(Blocks.SAND, ((TileGen) tile).getStackInSlot(0).getCount()));
            }
        }
    }
}