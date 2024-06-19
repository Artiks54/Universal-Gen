package com.ariks.universalgen.Item;

import com.ariks.universalgen.UniversalGen;
import net.minecraft.item.Item;

public class UpgradeItem extends Item {
    public UpgradeItem(String name) {
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setMaxStackSize(64);
        this.setCreativeTab(UniversalGen.UniversalGenTab);
        this.setNoRepair();
    }
}