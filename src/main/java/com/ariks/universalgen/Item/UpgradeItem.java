package com.ariks.universalgen.Item;

import com.ariks.universalgen.UniversalGen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
}