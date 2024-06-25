package com.ariks.universalgen.Register;

import com.ariks.universalgen.Block.CommpressedBlock.CompressedCobbleBlock;
import com.ariks.universalgen.Block.CommpressedBlock.CompressedGravelBlock;
import com.ariks.universalgen.Block.CommpressedBlock.CompressedSandBlock;
import com.ariks.universalgen.Block.UniversalGen.BlockUniversalGen;
import com.ariks.universalgen.Util.Config;
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
    static String x1 = "9 blocks";
    static String x2 = "81 blocks";
    static String x3 = "729 blocks";
    static String x4 = "6.561 blocks";
    static String x5 = "59.049 blocks";
    static String x6 = "531.441 blocks";
    static String x7 = "4.782.969 blocks";
    static String x8 = "43.046.721 blocks";
    static String x9 = "387.420.489 blocks";
    public static Block Universal_Generator = new BlockUniversalGen("universal_generator");
    public static Block C1  = new CompressedCobbleBlock("c1",x1);
    public static Block C2  = new CompressedCobbleBlock("c2",x2);
    public static Block C3  = new CompressedCobbleBlock("c3",x3);
    public static Block C4  = new CompressedCobbleBlock("c4",x4);
    public static Block C5  = new CompressedCobbleBlock("c5",x5);
    public static Block C6  = new CompressedCobbleBlock("c6",x6);
    public static Block C7  = new CompressedCobbleBlock("c7",x7);
    public static Block C8  = new CompressedCobbleBlock("c8",x8);
    public static Block C9  = new CompressedCobbleBlock("c9",x9);
    public static Block S1  = new CompressedSandBlock("s1",x1);
    public static Block S2  = new CompressedSandBlock("s2",x2);
    public static Block S3  = new CompressedSandBlock("s3",x3);
    public static Block S4  = new CompressedSandBlock("s4",x4);
    public static Block S5  = new CompressedSandBlock("s5",x5);
    public static Block S6  = new CompressedSandBlock("s6",x6);
    public static Block S7  = new CompressedSandBlock("s7",x7);
    public static Block S8  = new CompressedSandBlock("s8",x8);
    public static Block S9  = new CompressedSandBlock("s9",x9);
    public static Block G1  = new CompressedGravelBlock("g1",x1);
    public static Block G2  = new CompressedGravelBlock("g2",x2);
    public static Block G3  = new CompressedGravelBlock("g3",x3);
    public static Block G4  = new CompressedGravelBlock("g4",x4);
    public static Block G5  = new CompressedGravelBlock("g5",x5);
    public static Block G6  = new CompressedGravelBlock("g6",x6);
    public static Block G7  = new CompressedGravelBlock("g7",x7);
    public static Block G8  = new CompressedGravelBlock("g8",x8);
    public static Block G9  = new CompressedGravelBlock("g9",x9);
    public static void preInit() {
        setRegister(Universal_Generator);
        if(Config.BooleanCompressedSand) {
            setRegister(S1);
            setRegister(S2);
            setRegister(S3);
            setRegister(S4);
            setRegister(S5);
            setRegister(S6);
            setRegister(S7);
            setRegister(S8);
            setRegister(S9);
        }
        if(Config.BooleanCompressedCobblestone) {
            setRegister(C1);
            setRegister(C2);
            setRegister(C3);
            setRegister(C4);
            setRegister(C5);
            setRegister(C6);
            setRegister(C7);
            setRegister(C8);
            setRegister(C9);
        }
        if(Config.BooleanCompressedGravel) {
            setRegister(G1);
            setRegister(G2);
            setRegister(G3);
            setRegister(G4);
            setRegister(G5);
            setRegister(G6);
            setRegister(G7);
            setRegister(G8);
            setRegister(G9);
        }
    }
    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        setRender(Universal_Generator);
        if(Config.BooleanCompressedSand) {
            setRender(S1);
            setRender(S2);
            setRender(S3);
            setRender(S4);
            setRender(S5);
            setRender(S6);
            setRender(S7);
            setRender(S8);
            setRender(S9);
        }
        if(Config.BooleanCompressedCobblestone) {
            setRender(C1);
            setRender(C2);
            setRender(C3);
            setRender(C4);
            setRender(C5);
            setRender(C6);
            setRender(C7);
            setRender(C8);
            setRender(C9);
        }
        if(Config.BooleanCompressedGravel) {
            setRender(G1);
            setRender(G2);
            setRender(G3);
            setRender(G4);
            setRender(G5);
            setRender(G6);
            setRender(G7);
            setRender(G8);
            setRender(G9);
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
