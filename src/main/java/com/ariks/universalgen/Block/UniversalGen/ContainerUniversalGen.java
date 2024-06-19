package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Block.ExampleContainer;
import com.ariks.universalgen.Util.SlotOut;
import com.ariks.universalgen.Util.SlotUpgradeCount;
import com.ariks.universalgen.Util.SlotUpgradeGen;
import com.ariks.universalgen.Util.SlotUpgradeSpeed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerUniversalGen  extends ExampleContainer {
    public ContainerUniversalGen(InventoryPlayer inventoryPlayer, TileUniversalGen tileEntity, EntityPlayer entityPlayer) {
        super(tileEntity);
        this.addSlotToContainer(new SlotOut(tileEntity, 0, 80, 35));
        this.addSlotToContainer(new SlotUpgradeSpeed(tileEntity, 1, 58, 9));
        this.addSlotToContainer(new SlotUpgradeCount(tileEntity, 2, 80, 9));
        this.addSlotToContainer(new SlotUpgradeGen(tileEntity, 3, 102, 9));
        PlayerInventory(inventoryPlayer);
    }
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(slotIndex);
        if (slot != null && slot.getHasStack()) {
            ItemStack slotStack = slot.getStack();
            itemstack = slotStack.copy();
            if (slotIndex == 0 || slotIndex == 1 || slotIndex == 2 || slotIndex == 3) {
                if (!this.mergeItemStack(slotStack,4, 40, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!this.mergeItemStack(slotStack, 1, 4, false)) {
                    return ItemStack.EMPTY;
                }
            }
            if (slotStack.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (slotStack.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, slotStack);
        }
        return itemstack;
    }
}