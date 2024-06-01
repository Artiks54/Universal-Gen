package com.ariks.universalgen.Block.COBBLE;

import com.ariks.universalgen.Register.RegistryGui;
import com.ariks.universalgen.Register.RegistryItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class CobbleGenTile extends TileEntityLockable  implements ITickable {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(2, ItemStack.EMPTY);
    public int count,mode;
    private final Block BlockGenerated = Blocks.SAND;
    private final int NeedTickToGenerate = 200;
    private int progress;
    private int addProgress = 1;
    @Override
    public void update() {
        if (!world.isRemote) {
            this.getUpgradeSpeed();
                if (mode == 0) {
                    GenerateSandMyInventory();
                }
                if (mode == 1) {
                    GenerateSandOtherInventory();
            }
        }
    }
    public void ToogleMode(){
        mode++;
        markDirty();
        if(mode > 1){
            mode = 0;
        }
    }
    private void GenerateSandOtherInventory(){
        for (EnumFacing facing : EnumFacing.VALUES) {
            BlockPos neighborPos = this.pos.offset(facing);
            TileEntity tileEntity = world.getTileEntity(neighborPos);
            if(tileEntity instanceof CobbleGenTile){
                break;
            }
            if (tileEntity instanceof IInventory) {
                IInventory inventory = (IInventory) tileEntity;
                boolean foundEmptySlot = false;
                for (int slot = 0; slot < inventory.getSizeInventory(); slot++) {
                    ItemStack stack = inventory.getStackInSlot(slot);
                    ItemStack newStack = new ItemStack(BlockGenerated, count);
                    if (stack.isEmpty()) {
                        if (inventory.isItemValidForSlot(slot, newStack )) {
                            if(progress >= NeedTickToGenerate){
                                progress = 0;
                                inventory.setInventorySlotContents(slot, newStack);
                            }
                            foundEmptySlot = true;
                            break;
                        }
                    } else if (stack.getCount() < 64 && stack.getItem() == Item.getItemFromBlock(BlockGenerated)) {
                        int availableSpace = 64 - stack.getCount();
                        int toAdd = Math.min(count, availableSpace);
                        if (inventory.isItemValidForSlot(slot, new ItemStack(BlockGenerated, toAdd))) {
                            if(progress >= NeedTickToGenerate){
                                progress = 0;
                                stack.grow(toAdd);
                                inventory.setInventorySlotContents(slot, stack);
                            }
                            foundEmptySlot = true;
                            break;
                        }
                    }
                }
                if(foundEmptySlot){
                    progress += addProgress;
                }
            }
        }
    }
    private void GenerateSandMyInventory(){
        int slotGenerated = 0;
        if (inventory.get(slotGenerated).isEmpty() || inventory.get(slotGenerated).getCount() < 64) {
            progress += addProgress;
        }
        if (progress >= NeedTickToGenerate) {
            if (inventory.get(slotGenerated).isEmpty()) {
                inventory.set(slotGenerated, new ItemStack(BlockGenerated, count));
            } else if (inventory.get(slotGenerated).getCount() < 64) {
                int availableSpace = 64 - inventory.get(slotGenerated).getCount();
                int toAdd = Math.min(count, availableSpace);
                inventory.get(slotGenerated).grow(toAdd);
            }
            progress = 0;
        }
    }
    private void getUpgradeSpeed(){
        if(inventory.get(1).getItem() == RegistryItems.upgrade_lvl4){
            addProgress = 200;
        }
        if(inventory.get(1).getItem() == RegistryItems.upgrade_lvl3){
            addProgress = 10;
        }
        if(inventory.get(1).getItem() == RegistryItems.upgrade_lvl2){
            addProgress = 4;
        }
        if(inventory.get(1).getItem() == RegistryItems.upgrade_lvl1){
            addProgress = 2;
        }
        if(inventory.get(1).isEmpty()){
            addProgress = 1;
        }
    }
    @Override
    public @NotNull NBTTagCompound writeToNBT(@NotNull NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("progress", progress);
        nbt.setInteger("count",count);
        nbt.setInteger("mode",mode);
        nbt.setTag("inventory", ItemStackHelper.saveAllItems(new NBTTagCompound(), inventory));
        return nbt;
    }
    @Override
    public void readFromNBT(@NotNull NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        progress = nbt.getInteger("progress");
        count = nbt.getInteger("count");
        mode = nbt.getInteger("mode");
        NBTTagCompound inventoryTag = nbt.getCompoundTag("inventory");
        ItemStackHelper.loadAllItems(inventoryTag, inventory);
    }
    @Override
    public int getSizeInventory() {
        return inventory.size();
    }
    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.inventory) {
            if (!stack.isEmpty()) return false;
        }
        return true;
    }
    @Override
    public @NotNull ItemStack getStackInSlot(int index) {
        return this.inventory.get(index);
    }
    @Override
    public @NotNull ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }
    @Override
    public @NotNull ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }
    @Override
    public void setInventorySlotContents(int index, @NotNull ItemStack stack) {
        inventory.set(index, stack);
        if (stack.getCount() > getInventoryStackLimit()) {
            stack.setCount(getInventoryStackLimit());
        }
        markDirty();
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
    public void openInventory(@Nonnull EntityPlayer player) {}
    @Override
    public void closeInventory(@Nonnull EntityPlayer player) {}
    @Override
    public boolean isItemValidForSlot(int index, @Nonnull ItemStack stack) {
        return false;
    }
    public int getField(int id) {
       if(id == 1){
           return progress;
       }
       if(id == 2){
            return NeedTickToGenerate;
       }
       if(id == 3){
            return mode;
       }
       return id;
    }
    public void setField(int id, int value) {
        if(id == 1){
            progress = value;
        }
        if(id == 3){
            mode = value;
        }
    }
    public int getFieldCount()
    {
        return 3;
    }
    @Override
    public void clear() {
        this.inventory.clear();
    }
    @Override
    public @NotNull String getName() {
        return "CobbleGen";
    }
    @Override
    public boolean hasCustomName() {
        return false;
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