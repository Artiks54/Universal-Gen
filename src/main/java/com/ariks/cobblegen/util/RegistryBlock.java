package com.ariks.cobblegen.util;

import com.ariks.cobblegen.Block.CobbleGen.CobbleGenBlock;
import com.ariks.cobblegen.Block.CobbleGen.CobbleGenBlockEnum;
import com.ariks.cobblegen.Block.CompressedCobbleBlock;
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
    public static Block CobbleGenLvl1 = new CobbleGenBlock("cobble_gen_lvl1",CobbleGenBlockEnum.lvl_1);
    public static Block CobbleGenLvl2 = new CobbleGenBlock("cobble_gen_lvl2",CobbleGenBlockEnum.lvl_2);
    public static Block CobbleGenLvl3 = new CobbleGenBlock("cobble_gen_lvl3",CobbleGenBlockEnum.lvl_3);
    public static Block CobbleGenLvl4 = new CobbleGenBlock("cobble_gen_lvl4",CobbleGenBlockEnum.lvl_4);
    public static Block C1  = new CompressedCobbleBlock("c1","9 blocks");
    public static Block C2  = new CompressedCobbleBlock("c2","81 blocks");
    public static Block C3  = new CompressedCobbleBlock("c3","729 blocks");
    public static Block C4  = new CompressedCobbleBlock("c4","6.561 blocks");
    public static Block C5  = new CompressedCobbleBlock("c5","59.049 blocks");
    public static Block C6  = new CompressedCobbleBlock("c6","531.441 blocks");
    public static Block C7  = new CompressedCobbleBlock("c7","4.782.969 blocks");
    public static Block C8  = new CompressedCobbleBlock("c8","43.046.721 blocks");
    public static Block C9  = new CompressedCobbleBlock("c9","387.420.489 blocks");
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
