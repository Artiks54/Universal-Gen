package com.ariks.sandgen.Block.CobbleGen;

import com.ariks.sandgen.SandGen;
import com.ariks.sandgen.Util.GuiButtonNetwork;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class SandGenGui extends GuiContainer {
    private final TileGen tileGen;
    private GuiButtonNetwork buttonToogleMode;
    private final ResourceLocation texture = new ResourceLocation(SandGen.MOD_ID, "textures/gui/gui.png");
    public SandGenGui(InventoryPlayer inventory, TileGen tileEntity, EntityPlayer player) {
        super(new SandGenBlockContainer(inventory,tileEntity,player));
        this.tileGen = tileEntity;
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
        if (buttonToogleMode.isMouseOver()) {
            if (tileGen.getField(3) == 0) {
                drawHoveringText("Generates to this inventory",mouseX,mouseY);
            }
            if (tileGen.getField(3) == 1) {
                drawHoveringText("Generates to the neighboring inventory",mouseX,mouseY);
            }
        }
    }
    private void DrawButton(){
        int x = (this.width - xSize) / 2;
        int y = (this.height - ySize) / 2;
        int fix = 1;
        buttonList.clear();
        buttonToogleMode = new GuiButtonNetwork(tileGen, 1, x + 75, y + 58, 25+fix, 13+fix, "", 1);
        buttonToogleMode.setIdTexture(tileGen.getField(3));
        buttonList.add(buttonToogleMode);
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        this.DrawButton();
        int x = (this.width - xSize) / 2;
        int y = (this.height - ySize) / 2;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
        drawTexturedModalRect(x, y, 0, 0, xSize,ySize);
        int progress = tileGen.getField(1);
        int maxProgress = tileGen.getField(2);
        int fix = 1;
        int wightTexture = 41;
        int heightTexture = 50;
        //Left to right
        int StartX_left_to_right = 34;
        int StartY_left_to_right = 18;
        //Right to left
        int StartX_right_to_left = 141+fix;
        int StartY_right_to_left = 18;
        //draw
        double draw = (double) (progress * (wightTexture + 1)) / (maxProgress + 1);
        //Left to right
        drawTexturedModalRect(x + StartX_left_to_right, y + StartY_left_to_right, 176, 0,(int) draw, heightTexture);
        //Right to left
        drawTexturedModalRect(x + StartX_right_to_left - (int) draw, y + StartY_right_to_left,(255+fix) - (int) draw , 0,(int) draw, heightTexture);
    }
}
