package com.ariks.universalgen.Block.UniversalGen;

import net.minecraft.item.ItemStack;

public class GeneratedItem {
    private final ItemStack itemStack;
    private final int generationTime;
    public GeneratedItem(ItemStack itemStack, int generationTime) {
        this.itemStack = itemStack;
        this.generationTime = generationTime;
    }
    public ItemStack getItemStack() {
        return itemStack;
    }
    public int getGenerationTime() {
        return generationTime;
    }
}
