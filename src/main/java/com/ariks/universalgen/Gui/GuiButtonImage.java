package com.ariks.universalgen.Gui;

import com.ariks.universalgen.Core.TileExampleContainer;
import com.ariks.universalgen.Network.UpdateTilePacket;
import com.ariks.universalgen.Register.RegistryNetwork;
import com.ariks.universalgen.UniversalGen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class GuiButtonImage extends GuiButton {

    private static final ResourceLocation icon = new ResourceLocation(UniversalGen.MOD_ID, "textures/gui/buttons.png");
    private static final ResourceLocation texture =  new ResourceLocation(UniversalGen.MOD_ID,"textures/gui/button.png");
    private final int value;
    private int textureX, textureY;
    private final TileExampleContainer tile;

    public GuiButtonImage(TileExampleContainer tile, int buttonId, int x, int y, int Value) {
        super(buttonId, x, y, 20, 20, "");
        this.tile = tile;
        this.value = Value;
    }

    @Override
    public boolean mousePressed(@NotNull Minecraft mc, int mouseX, int mouseY) {
        if (super.mousePressed(mc, mouseX, mouseY)) {
            if (value != 0) {
                RegistryNetwork.network.sendToServer(new UpdateTilePacket(tile.getPos(), value));
                return true;
            }
        }
        return super.mousePressed(mc, mouseX, mouseY);
    }

    public void setTexture(int textureX, int textureY) {
        this.textureX = textureX;
        this.textureY = textureY;
    }

    @Override
    public void drawButton(@NotNull Minecraft mc, int mouseX, int mouseY, float p) {
        if (this.visible) {
            super.drawButton(mc, mouseX, mouseY, p);
            mc.getTextureManager().bindTexture(texture);
            this.drawTexturedModalRect(this.x,this.y,0,0,20,20);
            mc.getTextureManager().bindTexture(icon);
            this.drawTexturedModalRect(this.x + 2, this.y + 2, textureX, textureY, 16, 16);
        }
    }
}