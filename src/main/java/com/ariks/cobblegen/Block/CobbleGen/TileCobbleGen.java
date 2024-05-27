package com.ariks.cobblegen.Block.CobbleGen;

import com.ariks.cobblegen.util.RegistryGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import javax.annotation.Nonnull;

public class TileCobbleGen extends TileEntityLockable implements ITickable {
    private final ItemStackHandler inventory = new ItemStackHandler(1) {@Override protected void onContentsChanged(int slot) {markDirty();}};
    public final int id;
    private ItemStack itemStack;
    private int progress;
    public TileCobbleGen(int id) {
        this.id = id;
    }
    @Override
    public void update() {
        if (!world.isRemote) {
            SetComponentGen();
            if (itemStack == null) return;
            if (inventory.getStackInSlot(0).isEmpty() || inventory.getStackInSlot(0).getCount() < 64) {
                progress++;
                if (progress >= 20) {
                    inventory.insertItem(0, itemStack, false);
                    progress = 0;
                }
            }
        }
    }
    private void SetComponentGen(){
        switch (id){
            case 1: itemStack = new ItemStack(Blocks.COBBLESTONE);break;
            case 2: itemStack = new ItemStack(Blocks.IRON_BLOCK);break;
            case 3: itemStack = new ItemStack(Blocks.DIAMOND_BLOCK);break;
            case 4: itemStack = new ItemStack(Blocks.GOLD_BLOCK);break;
            case 5: itemStack = new ItemStack(Blocks.EMERALD_BLOCK);break;
        }
    }
    @Override
    public @NotNull NBTTagCompound writeToNBT(@NotNull NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setTag("inventory", inventory.serializeNBT());
        nbt.setInteger("progress", progress);
        return nbt;
    }
    @Override
    public void readFromNBT(@NotNull NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        inventory.deserializeNBT(nbt.getCompoundTag("inventory"));
        progress = nbt.getInteger("progress");
    }
    @Override
    public int getSizeInventory() {
        return 1;
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
    @Override
    public @NotNull ItemStack getStackInSlot(int index) {
        return inventory.getStackInSlot(index);
    }
    @Nonnull
    @Override
    public ItemStack decrStackSize(int index, int count) {
        return inventory.extractItem(index, count, false);
    }
    @Nonnull
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return inventory.extractItem(index, inventory.getSlotLimit(index), false);
    }
    @Override
    public void setInventorySlotContents(int index, @Nonnull ItemStack stack) {
        inventory.setStackInSlot(index, stack);
    }
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    @Override
    public boolean isUsableByPlayer(@Nonnull EntityPlayer player) {
        return !isInvalid() && player.getDistanceSq(pos.add(0.5, 0.5, 0.5)) <= 64;
    }
    @Override
    public void openInventory(@Nonnull EntityPlayer player) {
    }
    @Override
    public void closeInventory(@Nonnull EntityPlayer player) {
    }
    @Override
    public boolean isItemValidForSlot(int index, @Nonnull ItemStack stack) {
        return false;
    }
    public int getField(int id)
    {
        if (id == 1) {
            return this.progress;
        }
        return id;
    }
    public void setField(int id, int value)
    {
        if (id == 1) {
            this.progress = value;
        }
    }
    @Override
    public int getFieldCount() {
        return 1;
    }
    @Override
    public void clear() {
        this.inventory.setSize(0);
    }
    @Override
    public @NotNull String getName() {
        return "CobbleGen";
    }
    @Override
    public boolean hasCustomName() {
        return true;
    }
    @Nonnull
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentString(getName());
    }
    @Override
    public @NotNull Container createContainer(@NotNull InventoryPlayer playerInventory, @NotNull EntityPlayer playerIn) {
        return new CobbleGenBlockContainer(playerInventory,this, playerIn);
    }
    @Override
    public @NotNull String getGuiID() {
        return String.valueOf(RegistryGui.GUI_COBBLE_GEN);
    }
}
