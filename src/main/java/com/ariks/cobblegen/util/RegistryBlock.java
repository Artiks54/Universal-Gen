package com.ariks.cobblegen.util;

import com.ariks.cobblegen.Block.CobbleGen.CobbleGenBlock;
import com.ariks.cobblegen.Block.CobbleGen.CobbleGenBlockEnum;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class RegistryBlock {
    public static Block CobbleGenLvl1 = new CobbleGenBlock("CobbleGenLvl1",CobbleGenBlockEnum.lvl_1);
    public static Block CobbleGenLvl2 = new CobbleGenBlock("CobbleGenLvl2",CobbleGenBlockEnum.lvl_2);
    public static Block CobbleGenLvl3 = new CobbleGenBlock("CobbleGenLvl3",CobbleGenBlockEnum.lvl_3);
    public static Block CobbleGenLvl4 = new CobbleGenBlock("CobbleGenLvl4",CobbleGenBlockEnum.lvl_4);
    public static Block CobbleGenLvl5 = new CobbleGenBlock("CobbleGenLvl5",CobbleGenBlockEnum.lvl_5);
    public static final List<Block> BLOCKS = new ArrayList<>();
    static {
        Field[] fields = RegistryBlock.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (Block.class.isAssignableFrom(field.getType())) {
                    Block block = (Block) field.get(null);
                    BLOCKS.add(block);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public static void preInit() {
        for (Block block : BLOCKS) {
            setRegister(block);
        }
    }
    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        for (Block block : BLOCKS) {
            setRender(block);
        }
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
