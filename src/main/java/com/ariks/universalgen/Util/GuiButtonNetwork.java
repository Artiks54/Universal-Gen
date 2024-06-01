package com.ariks.universalgen.Util;

import com.ariks.universalgen.Network.UpdateTilePacket;
import com.ariks.universalgen.Register.RegistryNetwork;
import com.ariks.universalgen.UniversalGen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import org.jetbrains.annotations.NotNull;

public class GuiButtonNetwork extends GuiButtonExt {
    private final int valueChange;
    private final TileEntity tile;
    private int idTexture;
    public GuiButtonNetwork(TileEntity tile, int id, int xPos, int yPos, int width, int height, String displayString, int value) {
        super(id, xPos, yPos, width, height, displayString);
        this.valueChange = value;
        this.tile = tile;
    }
    public void setIdTexture(int idTexture){
        this.idTexture = idTexture;
    }
    @Override
    public void drawButton(Minecraft mc, int mouseX, int mouseY, float partial) {
        super.drawButton(mc, mouseX, mouseY, partial);
        ResourceLocation texture = new ResourceLocation(UniversalGen.MOD_ID, "textures/gui/buttons.png");
        mc.getTextureManager().bindTexture(texture);
        if(idTexture == 0){
            Gui.drawModalRectWithCustomSizedTexture(this.x, this.y, 0, 0, this.width, this.height, 256, 256);
        }
        if(idTexture == 1){
            Gui.drawModalRectWithCustomSizedTexture(this.x, this.y, 0, 15, this.width, this.height, 256, 256);
        }
    }
    @Override
    public boolean mousePressed(@NotNull Minecraft mc, int mouseX, int mouseY) {
        if (super.mousePressed(mc, mouseX, mouseY)) {
            RegistryNetwork.network.sendToServer(new UpdateTilePacket(tile.getPos(),valueChange));
            return true;
        } else {
            return false;
        }
    }
}
