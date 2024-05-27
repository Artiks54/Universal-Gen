package com.ariks.cobblegen.Block.CobbleGen;

import com.ariks.cobblegen.CobbleGen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CobbleGenGui extends GuiContainer {
    private final ResourceLocation texture = new ResourceLocation(CobbleGen.MOD_ID, "textures/gui/gui.png");
    public CobbleGenGui(InventoryPlayer inventory, TileCobbleGen tileEntity, EntityPlayer player) {
        super(new CobbleGenBlockContainer(inventory,tileEntity,player));
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX,mouseY);
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.drawDefaultBackground();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        int x = (this.width - xSize) / 2;
        int y = (this.height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize,ySize);
    }
}
