package com.ariks.universalgen.Block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.NotNull;

public abstract class ExampleContainer extends Container {
    protected ExampleTile tile;
    private boolean hasTile;
    private int[] tileMap;
    private void SetTile(ExampleTile tile) {
        this.hasTile = true;
        this.tile = tile;
        this.tileMap = new int[tile.getValueList().length];
    }
    public ExampleContainer() {
        this.hasTile = false;
    }
    public ExampleContainer(ExampleTile tile) {
        this.SetTile(tile);
    }
    protected void PlayerInventory(InventoryPlayer inventoryPlayer) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        PlayerHotbar(inventoryPlayer);
    }
    private void PlayerHotbar(InventoryPlayer inventoryPlayer) {
        for (int k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(inventoryPlayer, k, 8 + k * 18, 142));
        }
    }
    protected void SyncValue() {
        int ValueId;
        for (IContainerListener listener : this.listeners) {
            for (int j = 0; j < tile.getValueList().length; j++) {
                ValueId = tile.getValueList()[j];
                int value = this.tile.getValue(ValueId);
                if (this.tileMap[j] != value) {
                    listener.sendWindowProperty(this, ValueId, value);
                    this.tileMap[j] = value;
                }
            }
        }
    }
    @Override
    public void detectAndSendChanges() {
        if (tile != null) {
            this.SyncValue();
        }
        super.detectAndSendChanges();
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        tile.setValue(id, data);
    }
    @Override
    public boolean canInteractWith(@NotNull EntityPlayer entityPlayer) {
        return this.tile.isUsableByPlayer(entityPlayer);
    }
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        return ItemStack.EMPTY;
    }
}