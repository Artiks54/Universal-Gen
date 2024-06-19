package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Block.ExampleGuiContainer;
import com.ariks.universalgen.Util.GuiButtonNetwork;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiUniversalGen extends ExampleGuiContainer {
    private final TileUniversalGen tile;
    public GuiUniversalGen(InventoryPlayer inventory, TileUniversalGen tileEntity, EntityPlayer player) {
        super(new ContainerUniversalGen(inventory, tileEntity, player));
        this.tile = tileEntity;
        SetTexture("textures/gui/gui.png");
        SetWidth(176);
        SetHeight(168);
    }
    private void DrawButton(){
        int x = (this.width - xSize) / 2;
        int y = (this.height - ySize) / 2;
        int fix = 1;
        buttonList.clear();
        GuiButtonNetwork buttonToogleMode = new GuiButtonNetwork(tile, 1, x + 75, y + 58, 25 + fix, 13 + fix, "", 1);
        buttonToogleMode.setIdTexture(tile.getValue(3));
        buttonList.add(buttonToogleMode);
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
        this.DrawButton();
        int x = (this.width - xSize) / 2;
        int y = (this.height - ySize) / 2;
        int progress = tile.getValue(1);
        int NeedTickToGenerate = tile.getValue(2);
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
