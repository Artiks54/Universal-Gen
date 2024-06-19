package com.ariks.universalgen.Register;

import com.ariks.universalgen.Block.CommpressedBlock.CompressedCobbleBlock;
import com.ariks.universalgen.Block.CommpressedBlock.CompressedGravelBlock;
import com.ariks.universalgen.Block.CommpressedBlock.CompressedSandBlock;
import com.ariks.universalgen.Block.UniversalGen.BlockUniversalGen;
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
    public static Block Universal_Generator = new BlockUniversalGen("universal_generator");
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
    public static Block G1  = new CompressedGravelBlock("g1","9 blocks");
    public static Block G2  = new CompressedGravelBlock("g2","81 blocks");
    public static Block G3  = new CompressedGravelBlock("g3","729 blocks");
    public static Block G4  = new CompressedGravelBlock("g4","6.561 blocks");
    public static Block G5  = new CompressedGravelBlock("g5","59.049 blocks");
    public static Block G6  = new CompressedGravelBlock("g6","531.441 blocks");
    public static Block G7  = new CompressedGravelBlock("g7","4.782.969 blocks");
    public static Block G8  = new CompressedGravelBlock("g8","43.046.721 blocks");
    public static Block G9  = new CompressedGravelBlock("g9","387.420.489 blocks");

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
