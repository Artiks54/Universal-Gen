package com.ariks.cobblegen.Block.CobbleGen;

import com.ariks.cobblegen.CobbleGen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CobbleGenGui extends GuiContainer {
    private final TileGen tileGen;
    private final ResourceLocation texture = new ResourceLocation(CobbleGen.MOD_ID, "textures/gui/gui.png");
    public CobbleGenGui(InventoryPlayer inventory, TileGen tileEntity, EntityPlayer player) {
        super(new CobbleGenBlockContainer(inventory,tileEntity,player));
        this.tileGen = tileEntity;
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

        int progress = tileGen.getField(1);
        int maxProgress = tileGen.getField(2);
        int fix = 1;
        int wightTexture = 40;
        int heightTexture = 50;
        //Left to right
        int StartX_left_to_right = 34;
        int StartY_left_to_right = 18;
        //Right to left
        int StartX_right_to_left = 141+fix;
        int StartY_right_to_left = 18;
        //draw
        int draw = (progress * (wightTexture + 1)) / (maxProgress + 1);
        //Left to right
        drawTexturedModalRect(x + StartX_left_to_right, y + StartY_left_to_right, 176, 0,draw, heightTexture);
        //Right to left
        drawTexturedModalRect(x + StartX_right_to_left - draw, y + StartY_right_to_left,(255+fix) - draw , 0,draw, heightTexture);
    }
}
