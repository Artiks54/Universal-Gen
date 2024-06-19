package com.ariks.universalgen.Util;

import com.ariks.universalgen.Item.UpgradeSpeed;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotUpgradeSpeed extends Slot {
    public SlotUpgradeSpeed(IInventory inventoryIn, int index, int xPosition, int yPosition) {
        super(inventoryIn, index, xPosition, yPosition);
    }
    @Override
    public boolean isItemValid(ItemStack stack) {
        if(stack.getItem() instanceof UpgradeSpeed){
            return true;
        }
        return false;
    }
    @Override
    public int getSlotStackLimit() {
        return 1;
    }
}