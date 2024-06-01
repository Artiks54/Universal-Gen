package com.ariks.universalgen.Register;

import com.ariks.universalgen.Block.COBBLE.CobbleGenBlock;
import com.ariks.universalgen.Block.COBBLE.CobbleGenBlockEnum;
import com.ariks.universalgen.Block.COBBLE.CompressedCobbleBlock;
import com.ariks.universalgen.Block.SAND.SandGenBlock;
import com.ariks.universalgen.Block.SAND.SandGenBlockEnum;
import com.ariks.universalgen.Block.SAND.CompressedSandBlock;
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
    public static Block SandGenLvl1 = new SandGenBlock("sand_gen_lvl1", SandGenBlockEnum.lvl_1);
    public static Block SandGenLvl2 = new SandGenBlock("sand_gen_lvl2", SandGenBlockEnum.lvl_2);
    public static Block SandGenLvl3 = new SandGenBlock("sand_gen_lvl3", SandGenBlockEnum.lvl_3);
    public static Block SandGenLvl4 = new SandGenBlock("sand_gen_lvl4", SandGenBlockEnum.lvl_4);
    public static Block SandGenLvl5 = new SandGenBlock("sand_gen_lvl5", SandGenBlockEnum.lvl_5);
    public static Block CobbleGenLvl1 = new CobbleGenBlock("cobble_gen_lvl1", CobbleGenBlockEnum.lvl_1);
    public static Block CobbleGenLvl2 = new CobbleGenBlock("cobble_gen_lvl2", CobbleGenBlockEnum.lvl_2);
    public static Block CobbleGenLvl3 = new CobbleGenBlock("cobble_gen_lvl3", CobbleGenBlockEnum.lvl_3);
    public static Block CobbleGenLvl4 = new CobbleGenBlock("cobble_gen_lvl4", CobbleGenBlockEnum.lvl_4);
    public static Block CobbleGenLvl5 = new CobbleGenBlock("cobble_gen_lvl5", CobbleGenBlockEnum.lvl_5);
    public static Block S1  = new CompressedSandBlock("s1","9 blocks");
    public static Block S2  = new CompressedSandBlock("s2","81 blocks");
    public static Block S3  = new CompressedSandBlock("s3","729 blocks");
    public static Block S4  = new CompressedSandBlock("s4","6.561 blocks");
    public static Block S5  = new CompressedSandBlock("s5","59.049 blocks");
    public static Block S6  = new CompressedSandBlock("s6","531.441 blocks");
    public static Block S7  = new CompressedSandBlock("s7","4.782.969 blocks");
    public static Block S8  = new CompressedSandBlock("s8","43.046.721 blocks");
    public static Block S9  = new CompressedSandBlock("s9","387.420.489 blocks");
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
