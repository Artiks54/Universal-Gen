package com.ariks.sandgen.Block.CobbleGen;

import com.ariks.sandgen.Register.RegistryGui;
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

public class TileGen extends TileEntityLockable implements ITickable {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(1,ItemStack.EMPTY);
    public int count,speed,mode;
    private int progress;
    @Override
    public void update() {
        if (!world.isRemote) {
            if(mode == 0){
                GenerateSandMyInventory();
            }
            if(mode == 1){
                GenerateSandOtherInventory();
            }
        }
    }
    public void ToogleMode(){
        mode++;
        progress = 0;
        markDirty();
        if(mode > 1){
            mode = 0;
        }
    }
    private void GenerateSandOtherInventory(){
        for (EnumFacing facing : EnumFacing.VALUES) {
            BlockPos neighborPos = this.pos.offset(facing);
            TileEntity tileEntity = world.getTileEntity(neighborPos);
            if(tileEntity instanceof TileGen){
                break;
            }
            if (tileEntity instanceof IInventory) {
                IInventory inventory = (IInventory) tileEntity;
                boolean foundEmptySlot = false;
                for (int slot = 0; slot < inventory.getSizeInventory(); slot++) {
                    ItemStack stack = inventory.getStackInSlot(slot);
                    ItemStack newStack = new ItemStack(Blocks.SAND, count);
                    if (stack.isEmpty()) {
                        if (inventory.isItemValidForSlot(slot, newStack )) {
                            if(progress >= speed){
                                progress = 0;
                                inventory.setInventorySlotContents(slot, newStack);
                            }
                            foundEmptySlot = true;
                            break;
                        }
                    } else if (stack.getCount() < 64 && stack.getItem() == Item.getItemFromBlock(Blocks.SAND)) {
                        int availableSpace = 64 - stack.getCount();
                        int toAdd = Math.min(count, availableSpace);
                        if (inventory.isItemValidForSlot(slot, new ItemStack(Blocks.SAND, toAdd))) {
                            if(progress >= speed){
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
                    progress++;
                }
            }
        }
    }
    private void GenerateSandMyInventory(){
        int slotID = 0;
        if (inventory.get(slotID).isEmpty() || inventory.get(slotID).getCount() < 64) {
            progress++;
        }
        if (inventory.get(slotID).getCount() == 64) {
            progress = 0;
        }
        if (progress >= speed) {
            if (inventory.get(slotID).isEmpty()) {
                inventory.set(slotID, new ItemStack(Blocks.SAND, count));
            } else if (inventory.get(slotID).getCount() < 64) {
                int availableSpace = 64 - inventory.get(slotID).getCount();
                int toAdd = Math.min(count, availableSpace);
                inventory.get(slotID).grow(toAdd);
            }
            progress = 0;
        }
    }
    @Override
    public @NotNull NBTTagCompound writeToNBT(@NotNull NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("progress", progress);
        nbt.setInteger("count",count);
        nbt.setInteger("speed",speed);
        nbt.setInteger("mode",mode);
        nbt.setTag("inventory", ItemStackHelper.saveAllItems(new NBTTagCompound(), inventory));
        return nbt;
    }
    @Override
    public void readFromNBT(@NotNull NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        progress = nbt.getInteger("progress");
        count = nbt.getInteger("count");
        speed = nbt.getInteger("speed");
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
        return this.inventory.isEmpty();
    }
    @Override
    public @NotNull ItemStack getStackInSlot(int index) {
        return this.inventory.get(index);
    }
    @Nonnull
    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }
    @Nonnull
    @Override
    public ItemStack removeStackFromSlot(int index) {
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
            return speed;
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
        if(id == 2){
            speed = value;
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
        return "SandGen";
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
        return new SandGenBlockContainer(playerInventory,this, playerIn);
    }
    @Override
    public @NotNull String getGuiID() {
        return String.valueOf(RegistryGui.GUI_SAND_GEN);
    }
}
