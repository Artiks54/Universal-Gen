package com.ariks.universalgen.Gui;

import com.ariks.universalgen.Core.TileExampleContainer;
import com.ariks.universalgen.Network.UpdateTilePacket;
import com.ariks.universalgen.Register.RegistryNetwork;
import com.ariks.universalgen.UniversalGen;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import org.jetbrains.annotations.NotNull;

public class GuiItemButton extends GuiButtonExt {
    private ItemStack stack = ItemStack.EMPTY;
    private final int value;
    private final TileExampleContainer tile;
    private static final ResourceLocation texture =  new ResourceLocation(UniversalGen.MOD_ID,"textures/gui/button.png");

    public GuiItemButton(TileExampleContainer tile,int buttonId, int x, int y,int value) {
        super(buttonId, x, y, 20, 20, "");
        this.tile = tile;
        this.value = value;
    }
    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float p) {
        if (this.visible) {
            super.drawButton(mc, mouseX, mouseY, p);
            mc.getTextureManager().bindTexture(texture);
            this.drawTexturedModalRect(this.x,this.y,0,0,20,20);
            UniversalGen.proxy.renderItemOnScreen(this.stack, this.x+2, this.y+2);
        }
    }
    @Override
    public boolean mousePressed(@NotNull Minecraft mc, int mouseX, int mouseY) {
        if (super.mousePressed(mc, mouseX, mouseY)) {
            if (value != 0) {
                RegistryNetwork.network.sendToServer(new UpdateTilePacket(tile.getPos(), value));
                return true;
            }
        }
        return false;
    }
    public void setStackRender(ItemStack stackRender) {
        this.stack = stackRender;
    }
}