package com.ariks.universalgen.Block.SAND;

import com.ariks.universalgen.Item.UpgradeItem;
import net.minecraft.inventory.IContainerListener;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SandGenBlockContainer extends Container {
    private final SandGenTile tileEntity;
    private int progress;
    private int NeedTickToGenerate;
    private int mode;
    public SandGenBlockContainer(InventoryPlayer playerInventory, SandGenTile tileEntity, EntityPlayer player) {
        this.tileEntity = tileEntity;
        tileEntity.openInventory(player);
        this.addSlotToContainer(new Slot(tileEntity, 1, 80, 9){
            @Override
            public int getItemStackLimit(@NotNull ItemStack stack) {
                return 1;
            }
            @Override
            public boolean isItemValid(@NotNull ItemStack stack) {
                return stack.getItem() instanceof UpgradeItem;
            }
        });
        this.addSlotToContainer(new Slot(tileEntity, 0, 80, 35) {
            @Override
            public boolean isItemValid(@NotNull ItemStack stack) {
                return false;
            }
        });
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (int k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }
    public @NotNull ItemStack transferStackInSlot(@NotNull EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < this.tileEntity.getSizeInventory()) {
                if (!this.mergeItemStack(itemstack1, this.tileEntity.getSizeInventory(), this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, this.tileEntity.getSizeInventory(), false)) {
                return ItemStack.EMPTY;
            }
            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }
    public void addListener(@NotNull IContainerListener listener) {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileEntity);
    }
    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();
        for (IContainerListener icontainerlistener : this.listeners) {
            if (this.progress != this.tileEntity.getField(1)) {
                icontainerlistener.sendWindowProperty(this, 1, this.tileEntity.getField(1));
            }
            if (this.NeedTickToGenerate != this.tileEntity.getField(2)) {
                icontainerlistener.sendWindowProperty(this, 2, this.tileEntity.getField(2));
            }
            if (this.mode != this.tileEntity.getField(3)) {
                icontainerlistener.sendWindowProperty(this, 3, this.tileEntity.getField(3));
            }
        }
        this.progress = this.tileEntity.getField(1);
        this.NeedTickToGenerate = this.tileEntity.getField(2);
        this.mode = this.tileEntity.getField(3);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        this.tileEntity.setField(id, data);
    }
    @Override
    public boolean canInteractWith(@NotNull EntityPlayer entityPlayer) {
        return this.tileEntity.isUsableByPlayer(entityPlayer);
    }
    @Override
    public void onContainerClosed(@NotNull EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        this.tileEntity.closeInventory(playerIn);
    }
}
