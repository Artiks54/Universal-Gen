package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Core.TileExampleInventory;
import com.ariks.universalgen.Register.RegistryGui;
import com.ariks.universalgen.Util.Config;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ITickable;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class TileUniversalGen extends TileExampleInventory implements ITickable {
    private int progress;
    private int amount = 1;
    private int amountMode = 1;
    private boolean redstoneSignal,redstoneMode;
    private int booleanMode;
    private int currentRecipe;

    private List<GeneratorRecipes> getGeneratorRecipes() {
        return GeneratorRecipes.getRecipes();
    }

    public TileUniversalGen(){
        super(9);
        this.setSlotsForExtract(0,9);
    }
    protected int maxProgress() {
        List<GeneratorRecipes> recipes = GeneratorRecipes.getRecipes();
        if (checkRecipes(recipes)) {
            return (recipes.get(currentRecipe).getGenerationTime() / Config.RequiredGeneratorTick);
        }
        return 0;
    }
    private boolean checkRecipes(List<GeneratorRecipes> recipes) {
        return recipes != null && !recipes.isEmpty();
    }
    protected int maxModesAmount(){
        return 1;
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
    private boolean CanGenerate() {
        List<GeneratorRecipes> recipes = getGeneratorRecipes();
        if (!recipes.isEmpty()) {
            GeneratorRecipes recipe = recipes.get(currentRecipe);
            ItemStack item = recipe.getRecipeOutput();
            for (int i = 0; i < this.getSizeInventory(); i++) {
                ItemStack stack = this.getStackInSlot(i);
                if (stack.isEmpty() || (ItemStack.areItemsEqual(stack, item) && ItemStack.areItemStackTagsEqual(stack, item) && stack.getCount() < stack.getMaxStackSize())) {
                    return true;
                }
            }
        }
        return false;
    }
    private void Generate() {
        List<GeneratorRecipes> recipes = getGeneratorRecipes();
        if (!recipes.isEmpty()) {
            GeneratorRecipes recipe = recipes.get(currentRecipe);
            ItemStack item = recipe.getRecipeOutput();
            this.ToggleAmount();
            int amountToGenerate = this.amount;
            int MaxStackSize = 64;
            for (int i = 0; i < this.getSizeInventory(); i++) {
                ItemStack stack = this.getStackInSlot(i);
                if (stack.isEmpty()) {
                    int amountToAdd = Math.min(amountToGenerate, MaxStackSize);
                    ItemStack newStack = item.copy();
                    newStack.setCount(amountToAdd);
                    this.setInventorySlotContents(i, newStack);
                    amountToGenerate -= amountToAdd;
                    if (amountToGenerate == 0) {
                        return;
                    }
                } else if (ItemStack.areItemsEqual(stack, item) && ItemStack.areItemStackTagsEqual(stack, item)) {
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
        amountMode = (amountMode % maxModesAmount()) + 1;
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
        currentRecipe = (currentRecipe + 1) % GeneratorRecipes.getRecipes().size();
        this.progress = 0;
        this.UpdateTile();
    }
    @Override
    public @NotNull NBTTagCompound writeToNBT(@NotNull NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setInteger("Progress", this.progress);
        nbt.setInteger("Mode",this.booleanMode);
        nbt.setInteger("Recipe",this.currentRecipe);
        nbt.setInteger("AmountMode",this.amountMode);
        nbt.setBoolean("Red",this.redstoneSignal);
        return nbt;
    }
    @Override
    public void readFromNBT(@NotNull NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        this.progress = nbt.getInteger("Progress");
        this.booleanMode = nbt.getInteger("Mode");
        this.currentRecipe = nbt.getInteger("Recipe");
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
            return this.currentRecipe;
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