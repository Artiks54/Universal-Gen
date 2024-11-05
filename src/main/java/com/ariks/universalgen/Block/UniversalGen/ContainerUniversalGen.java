package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Core.ExampleContainer;
import com.ariks.universalgen.Util.SlotOut;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ContainerUniversalGen  extends ExampleContainer {
    public ContainerUniversalGen(InventoryPlayer inventoryPlayer, TileUniversalGen tileEntity, EntityPlayer entityPlayer) {
        super(tileEntity);
        this.addSlotToContainer(new SlotOut(tileEntity,0,61,17));
        this.addSlotToContainer(new SlotOut(tileEntity,1,79,17));
        this.addSlotToContainer(new SlotOut(tileEntity,2,97,17));
        this.addSlotToContainer(new SlotOut(tileEntity,3,61,35));
        this.addSlotToContainer(new SlotOut(tileEntity,4,79,35));
        this.addSlotToContainer(new SlotOut(tileEntity,5,97,35));
        this.addSlotToContainer(new SlotOut(tileEntity,6,61,53));
        this.addSlotToContainer(new SlotOut(tileEntity,7,79,53));
        this.addSlotToContainer(new SlotOut(tileEntity,8,97,53));
        PlayerInventory(inventoryPlayer);
    }
    @Override
    public @NotNull ItemStack transferStackInSlot(@NotNull EntityPlayer player, int slotIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = inventorySlots.get(slotIndex);
        if (slot != null && slot.getHasStack()) {
            ItemStack slotStack = slot.getStack();
            itemstack = slotStack.copy();
            if (slotIndex < 9) {
                if (!this.mergeItemStack(slotStack, 9, 36 + 9, false)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (!this.mergeItemStack(slotStack, 0, 0, false)) {
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