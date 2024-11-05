package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Core.TileExampleInventory;
import com.ariks.universalgen.Register.RegistryGui;
import com.ariks.universalgen.Util.Config;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.List;

public class TileUniversalGen extends TileExampleInventory implements ITickable {
    private int progress;
    private int amount = 1;
    private int amountMode = 1;
    private boolean redstoneSignal,redstoneMode;
    private int booleanMode;
    private int currentItemIndex = 0;
    private static final List<ItemStack> itemsToGenerate = new ArrayList<>();
    public TileUniversalGen(){
        super(9);
        this.setSlotsForExtract(0,9);
    }
    public int maxProgress() {
        return Config.RequiredGeneratorTick;
    }
    @Override
    public void update() {
        if (!world.isRemote) {
            this.CheckRedstoneSignal();
            if(this.CanGenerate() && (booleanMode == 1 || redstoneMode)) {
                progress++;
                this.UpdateTile();
                if(progress >= maxProgress()) {
                    this.Generate();
                    progress = 0;
                }
            }
        }
    }
    static {
        itemsToGenerate.add(new ItemStack(Blocks.COBBLESTONE));
        itemsToGenerate.add(new ItemStack(Blocks.GRAVEL));
        itemsToGenerate.add(new ItemStack(Blocks.SAND));
        itemsToGenerate.add(new ItemStack(Blocks.NETHERRACK));
        itemsToGenerate.add(new ItemStack(Blocks.END_STONE));
        itemsToGenerate.add(new ItemStack(Blocks.DIRT));
    }
    private boolean CanGenerate() {
        ItemStack item = itemsToGenerate.get(currentItemIndex);
        for (int i = 0; i < this.getSizeInventory(); i++) {
                ItemStack stack = this.getStackInSlot(i);
                if (stack.isEmpty() || (stack.getItem() == item.getItem() && ItemStack.areItemStackTagsEqual(stack, item) && stack.getCount() < stack.getMaxStackSize())) {
                    return true;
                }
            }
        return false;
    }
    private void Generate() {
        ItemStack item = itemsToGenerate.get(currentItemIndex);
        this.ToggleAmount();
        int amountToGenerate = this.amount;
        int MaxStackSize = 64;
        for (int i = 0; i < this.getSizeInventory(); i++) {
            ItemStack stack = this.getStackInSlot(i);
            if (stack.isEmpty()) {
                int amountToAdd = Math.min(amountToGenerate, MaxStackSize);
                this.setInventorySlotContents(i, new ItemStack(item.getItem(), amountToAdd));
                amountToGenerate -= amountToAdd;
                if (amountToGenerate == 0) {
                    return;
                }
            } else if (stack.getItem() == item.getItem() && ItemStack.areItemStackTagsEqual(stack, item)) {
                if (stack.getCount() < MaxStackSize) {
                    int spaceLeft = MaxStackSize - stack.getCount();
                    int amountToAdd = Math.min(amountToGenerate, spaceLeft);
                    stack.grow(amountToAdd);
                    amountToGenerate -= amountToAdd;
                    if (amountToGenerate == 0) {
                        return;
                    }
                }
            }
        }
    }
    private void CheckRedstoneSignal() {
        redstoneMode = (booleanMode == 2 && redstoneSignal) || (booleanMode == 3 && !redstoneSignal);
    }
    public void setRedstoneSignal(boolean redstoneSignal) {
        this.redstoneSignal = redstoneSignal;
    }
    public void ToggleWork() {
        this.progress = 0;
        booleanMode = (booleanMode + 1) % 4;
        this.UpdateTile();
    }
    public void ToggleAmountMode() {
        amountMode = (amountMode % 7) + 1;
        this.ToggleAmount();
        this.UpdateTile();
    }
    private void ToggleAmount(){
        switch (amountMode){
            case 1: amount = 1;break;
            case 2: amount = 2;break;
            case 3: amount = 4;break;
            case 4: amount = 8;break;
            case 5: amount = 16;break;
            case 6: amount = 32;break;
            case 7: amount = 64;break;
        }
    }
    public void ToggleItem() {
        currentItemIndex = (currentItemIndex + 1) % itemsToGenerate.size();
        this.progress = 0;
        this.UpdateTile();
    }
    @Override
    public @NotNull NBTTagCompound writeToNBT(@NotNull NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("Progress", this.progress);
        nbt.setInteger("Mode",this.booleanMode);
        nbt.setInteger("Item",this.currentItemIndex);
        nbt.setInteger("AmountMode",this.amountMode);
        nbt.setBoolean("Red",this.redstoneSignal);
        return nbt;
    }
    @Override
    public void readFromNBT(@NotNull NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.progress = nbt.getInteger("Progress");
        this.booleanMode = nbt.getInteger("Mode");
        this.currentItemIndex = nbt.getInteger("Item");
        this.amountMode = nbt.getInteger("AmountMode");
        this.redstoneSignal = nbt.getBoolean("Red");
        this.amountMode = nbt.getInteger("AmountMode");
    }
    @Override
    public int getValue(int id) {
        if(id == 1){
            return progress;
        }
        if(id == 2){
            return maxProgress();
        }
        if (id == 3) {
            return this.booleanMode;
        }
        if(id == 4){
            return this.currentItemIndex;
        }
        if(id == 5){
            return this.amountMode;
        }
        return id;
    }
    @Override
    public String getGuiID() {
        return String.valueOf(RegistryGui.Gui_Universal_gen);
    }
}