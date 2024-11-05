package com.ariks.universalgen.Register;

import com.ariks.universalgen.Block.UniversalGen.BlockUniversalGen;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.Objects;

public class RegistryBlock {

    public static Block Universal_Generator = new BlockUniversalGen("universal_generator",1);
    public static Block Universal_Generator_Advanced = new BlockUniversalGen("universal_generator_advanced",2);
    public static Block Universal_Generator_Ultimate = new BlockUniversalGen("universal_generator_ultimate",3);
    public static Block Universal_Generator_Dragon = new BlockUniversalGen("universal_generator_dragon",4);
    public static void preInit() {
        setRegister(Universal_Generator);
        setRegister(Universal_Generator_Advanced);
        setRegister(Universal_Generator_Ultimate);
        setRegister(Universal_Generator_Dragon);
    }
    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        setRender(Universal_Generator);
        setRender(Universal_Generator_Advanced);
        setRender(Universal_Generator_Ultimate);
        setRender(Universal_Generator_Dragon);
    }
    private static void setRegister(Block block) {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(Objects.requireNonNull(block.getRegistryName())));
    }
    @SideOnly(Side.CLIENT)
    private static void setRender(Block block) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Objects.requireNonNull(block.getRegistryName()), "inventory"));
    }
}
