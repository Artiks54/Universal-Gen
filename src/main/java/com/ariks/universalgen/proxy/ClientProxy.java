package com.ariks.universalgen.proxy;


import com.ariks.universalgen.Register.RegistryBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import java.util.Objects;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit() {
        super.preInit();
    }
    @Override
    public void Init() {
        super.Init();
        RegistryBlock.registerRender();
    }
    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), id));
    }
    @Override
    @SideOnly(Side.CLIENT)
    public void renderItemOnScreen(ItemStack current, int x, int y) {
        if (current == null) {
            return;
        }
        RenderItem itemRender = Minecraft.getMinecraft().getRenderItem();
        GlStateManager.color(1, 1, 1, 1);
        RenderHelper.enableStandardItemLighting();
        RenderHelper.enableGUIStandardItemLighting();
        itemRender.renderItemAndEffectIntoGUI(current, x, y);
        RenderHelper.disableStandardItemLighting();
    }
}