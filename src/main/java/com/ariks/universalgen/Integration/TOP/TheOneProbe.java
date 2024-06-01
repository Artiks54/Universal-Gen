package com.ariks.universalgen.Integration.TOP;

import com.ariks.universalgen.Block.COBBLE.CobbleGenTile;
import com.ariks.universalgen.Block.SAND.SandGenTile;
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
            if (tile instanceof SandGenTile) {
                SandGenTile sandGenTile = (SandGenTile) tile;
                if (sandGenTile.getField(3) == 0) {
                    iProbeInfo.text("Mode: in");
                }
                if (sandGenTile.getField(3) == 1) {
                    iProbeInfo.text("Mode: out");
                }
                int percent = ((sandGenTile.getField(1) * 100) / sandGenTile.getField(2));
                iProbeInfo.progress(percent, 100);
                iProbeInfo.item(new ItemStack(Blocks.SAND, ((SandGenTile) tile).getStackInSlot(0).getCount()));
            }
            if (tile instanceof CobbleGenTile) {
                CobbleGenTile CobbleGenTile = (CobbleGenTile) tile;
                if (CobbleGenTile.getField(3) == 0) {
                    iProbeInfo.text("Mode: in");
                }
                if (CobbleGenTile.getField(3) == 1) {
                    iProbeInfo.text("Mode: out");
                }
                int percent = ((CobbleGenTile.getField(1) * 100) / CobbleGenTile.getField(2));
                iProbeInfo.progress(percent, 100);
                iProbeInfo.item(new ItemStack(Blocks.COBBLESTONE, ((CobbleGenTile) tile).getStackInSlot(0).getCount()));
            }
        }
    }
}