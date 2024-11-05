package com.ariks.universalgen.Util;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SlotOut extends Slot {
    public SlotOut(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }
    @Override
    public boolean isItemValid(@NotNull ItemStack stack) {
        return false;
    }
    @Override
    public int getSlotStackLimit() {
        return 64;
    }
    @Override
    public int getItemStackLimit(ItemStack stack) {
        return 64;
    }
}
