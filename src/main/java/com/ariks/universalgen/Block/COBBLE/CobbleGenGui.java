package com.ariks.universalgen.Block.COBBLE;

import com.ariks.universalgen.UniversalGen;
import com.ariks.universalgen.Util.GuiButtonNetwork;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CobbleGenGui extends GuiContainer {
    private final CobbleGenTile cobbleGenTile;
    private GuiButtonNetwork buttonToogleMode;
    private final ResourceLocation texture = new ResourceLocation(UniversalGen.MOD_ID, "textures/gui/gui.png");
    public CobbleGenGui(InventoryPlayer inventory, CobbleGenTile tileEntity, EntityPlayer player) {
        super(new CobbleGenBlockContainer(inventory,tileEntity,player));
        this.cobbleGenTile = tileEntity;
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
        if (buttonToogleMode.isMouseOver()) {
            if (cobbleGenTile.getField(3) == 0) {
                drawHoveringText("Generates to this inventory",mouseX,mouseY);
            }
            if (cobbleGenTile.getField(3) == 1) {
                drawHoveringText("Generates to the neighboring inventory",mouseX,mouseY);
            }
        }
    }
    private void DrawButton(){
        int x = (this.width - xSize) / 2;
        int y = (this.height - ySize) / 2;
        int fix = 1;
        buttonList.clear();
        buttonToogleMode = new GuiButtonNetwork(cobbleGenTile, 1, x + 75, y + 58, 25+fix, 13+fix, "", 1);
        buttonToogleMode.setIdTexture(cobbleGenTile.getField(3));
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
        int progress = cobbleGenTile.getField(1);
        int NeedTickToGenerate = cobbleGenTile.getField(2);
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
        double draw = (double) (progress * (wightTexture + 1)) / (NeedTickToGenerate + 1);
        //Left to right
        drawTexturedModalRect(x + StartX_left_to_right, y + StartY_left_to_right, 176, 0,(int) draw, heightTexture);
        //Right to left
        drawTexturedModalRect(x + StartX_right_to_left - (int) draw, y + StartY_right_to_left,(255+fix) - (int) draw , 0,(int) draw, heightTexture);
    }
}
