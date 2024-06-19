package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Block.ExampleTile;
import com.ariks.universalgen.Register.RegistryGui;
import com.ariks.universalgen.Register.RegistryItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import org.jetbrains.annotations.NotNull;

public class TileUniversalGen extends ExampleTile implements ITickable, IInventory, ISidedInventory {
    private final NonNullList<ItemStack> inventory = NonNullList.withSize(4, ItemStack.EMPTY);
    public int mode;
    public int amount = 1;
    private ItemStack itemGenerated = ItemStack.EMPTY;
    private final int NeedTickToGenerate = 200;
    private int progress;
    private int addProgress = 1;
    @Override
    public void update() {
        if (!world.isRemote) {
            if(mode == 0) {
                this.GenerateSandMyInventory();
            }
            if(mode == 1) {
                this.GenerateSandOtherInventory();
            }
            this.UpdateTile();
        }
    }
    private void GenerateSandOtherInventory(){
        this.getUpgradeAmount();
        for (EnumFacing facing : EnumFacing.VALUES) {
            BlockPos neighborPos = this.pos.offset(facing);
            TileEntity tileEntity = world.getTileEntity(neighborPos);
            if(tileEntity instanceof TileUniversalGen){
                break;
            }
            if (tileEntity instanceof IInventory) {
                IInventory inventors = (IInventory) tileEntity;
                boolean foundEmptySlot = false;
                for (int slot = 0; slot < inventors.getSizeInventory(); slot++) {
                    ItemStack stack = inventors.getStackInSlot(slot);
                    ItemStack newStack = itemGenerated;
                    if (stack.isEmpty()) {
                        if (inventors.isItemValidForSlot(slot, newStack )) {
                            if(progress >= NeedTickToGenerate){
                                progress = 0;
                                inventors.setInventorySlotContents(slot, newStack);
                            }
                            foundEmptySlot = true;
                            break;
                        }
                    } else if (stack.getCount() < 64 && stack.getItem() == itemGenerated.getItem()) {
                        int availableSpace = 64 - stack.getCount();
                        int toAdd = Math.min(amount, availableSpace);
                        if (inventors.isItemValidForSlot(slot, itemGenerated)) {
                            if(progress >= NeedTickToGenerate){
                                progress = 0;
                                stack.grow(toAdd);
                                inventors.setInventorySlotContents(slot, stack);
                            }
                            foundEmptySlot = true;
                            break;
                        }
                    }
                }
                if(foundEmptySlot && !inventory.get(3).isEmpty()){
                    this.getUpgradeSpeed();
                    progress += addProgress;
                }
            }
        }
    }
    private void GenerateSandMyInventory() {
        int slotGenerated = 0;
        this.getUpgradeAmount();
        boolean shouldGenerate;
        if (!inventory.get(slotGenerated).isEmpty() && !ItemStack.areItemsEqual(inventory.get(slotGenerated), itemGenerated)) {
            shouldGenerate = false;
        } else {
            shouldGenerate = true;
        }
        if (shouldGenerate && !inventory.get(3).isEmpty() && (inventory.get(slotGenerated).isEmpty() || inventory.get(slotGenerated).getCount() < 64 )) {
            this.getUpgradeSpeed();
            progress += addProgress;
        }
        if (progress >= NeedTickToGenerate && shouldGenerate) {
            if (inventory.get(slotGenerated).isEmpty()) {
                inventory.set(slotGenerated, itemGenerated.copy());
            } else if (inventory.get(slotGenerated).getCount() < 64 && !inventory.get(3).isEmpty()) {
                int availableSpace = 64 - inventory.get(slotGenerated).getCount();
                int toAdd = Math.min(itemGenerated.getCount(), availableSpace);
                inventory.get(slotGenerated).grow(toAdd);
            }
            progress = 0;
        }
    }
    private void getUpgradeGenerator(){
        if (inventory.get(3).getItem() == RegistryItems.upgrade_gen_cobblestone){
            itemGenerated = new ItemStack(Blocks.COBBLESTONE,amount);
        } else if (inventory.get(3).getItem() == RegistryItems.upgrade_gen_sand){
            itemGenerated = new ItemStack(Blocks.SAND,amount);
        } else if (inventory.get(3).getItem() == RegistryItems.upgrade_gen_gravel){
            itemGenerated = new ItemStack(Blocks.GRAVEL,amount);
        } else if(inventory.get(3).isEmpty()){
            itemGenerated = ItemStack.EMPTY;
        }
    }
    private void getUpgradeAmount(){
        if (inventory.get(2).getItem() == RegistryItems.upgrade_count_lvl6){
            amount = 64;
        } else if (inventory.get(2).getItem() == RegistryItems.upgrade_count_lvl5){
            amount = 32;
        } else if (inventory.get(2).getItem() == RegistryItems.upgrade_count_lvl4){
            amount = 16;
        } else if (inventory.get(2).getItem() == RegistryItems.upgrade_count_lvl3){
            amount = 8;
        } else if (inventory.get(2).getItem() == RegistryItems.upgrade_count_lvl2){
            amount = 4;
        } else if (inventory.get(2).getItem() == RegistryItems.upgrade_count_lvl1){
            amount = 2;
        } else if (inventory.get(2).isEmpty()){
            amount = 1;
        }
        this.getUpgradeGenerator();
    }
    private void getUpgradeSpeed(){
        if (inventory.get(1).getItem() == RegistryItems.upgrade_speed_lvl6){
            addProgress = 200;
        } else if (inventory.get(1).getItem() == RegistryItems.upgrade_speed_lvl5){
            addProgress = 50;
        } else if (inventory.get(1).getItem() == RegistryItems.upgrade_speed_lvl4){
            addProgress = 25;
        } else if (inventory.get(1).getItem() == RegistryItems.upgrade_speed_lvl3){
            addProgress = 10;
        } else if (inventory.get(1).getItem() == RegistryItems.upgrade_speed_lvl2){
            addProgress = 5;
        } else if (inventory.get(1).getItem() == RegistryItems.upgrade_speed_lvl1){
            addProgress = 2;
        } else if (inventory.get(1).isEmpty()){
            addProgress = 1;
        }
    }
    public void ToogleMode(){
        mode++;
        progress = 0;
        if(mode > 1){
            mode = 0;
        }
    }
    @Override
    public @NotNull NBTTagCompound writeToNBT(@NotNull NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("progress", progress);
        nbt.setInteger("amount",amount);
        nbt.setInteger("mode",mode);
        nbt.setTag("inventory", ItemStackHelper.saveAllItems(new NBTTagCompound(), inventory));
        return nbt;
    }
    @Override
    public void readFromNBT(@NotNull NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        progress = nbt.getInteger("progress");
        amount = nbt.getInteger("amount");
        mode = nbt.getInteger("mode");
        NBTTagCompound inventoryTag = nbt.getCompoundTag("inventory");
        ItemStackHelper.loadAllItems(inventoryTag, inventory);
    }
    @Override
    public int getValue(int id) {
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
    @Override
    public void setValue(int id, int value) {
        if(id == 1){
            progress = value;
        }
        if(id == 3){
            mode = value;
        }
    }
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentString(getName());
    }
    @Override
    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn) {
        return new ContainerUniversalGen(playerInventory,this, playerIn);
    }
    @Override
    public String getGuiID() {
        return String.valueOf(RegistryGui.Gui_Universal_gen);
    }
    @Override
    public void openInventory(EntityPlayer entityPlayer) {}
    @Override
    public void closeInventory(EntityPlayer entityPlayer) {}
    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {return false;}
    @Override
    public int getField(int i) {return 0;}
    @Override
    public void setField(int i, int i1) {}
    @Override
    public int getFieldCount() {return 0;}
    @Override
    public void clear() {
        this.inventory.clear();
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
    public ItemStack getStackInSlot(int index) {
        return this.inventory.get(index);
    }
    @Override
    public ItemStack decrStackSize(int index, int count) {
        return ItemStackHelper.getAndSplit(this.inventory, index, count);
    }
    @Override
    public ItemStack removeStackFromSlot(int index) {
        return ItemStackHelper.getAndRemove(this.inventory, index);
    }
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }
    @Override
    public String getName() {
        return "UniversalGenTile";
    }
    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        inventory.set(index, stack);
        if (stack.getCount() > getInventoryStackLimit()) {
            stack.setCount(getInventoryStackLimit());
        }
        if(index == 3){
            progress = 0;
        }
        this.UpdateTile();
    }
    @Override
    public int[] getSlotsForFace(EnumFacing enumFacing) {
        return new int[4];
    }
    @Override
    public boolean canInsertItem(int index, ItemStack itemStack, EnumFacing enumFacing) {
        return false;
    }
    @Override
    public boolean canExtractItem(int index, ItemStack itemStack, EnumFacing enumFacing) {
        if(index == 0){
            return true;
        }
        return false;
    }
}