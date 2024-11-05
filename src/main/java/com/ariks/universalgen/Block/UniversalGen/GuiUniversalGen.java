package com.ariks.universalgen.Block.UniversalGen;

import com.ariks.universalgen.Core.ExampleGuiContainer;
import com.ariks.universalgen.Gui.BarComponent;
import com.ariks.universalgen.Gui.GuiButtonImage;
import com.ariks.universalgen.Gui.GuiItemButton;
import com.ariks.universalgen.Util.LocalizedStringKey;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GuiUniversalGen extends ExampleGuiContainer {
    private final TileUniversalGen tile;
    private GuiItemButton buttonWork;
    private GuiItemButton buttonItem;
    private GuiButtonImage buttonImage;
    private final LocalizedStringKey LS = new LocalizedStringKey();
    private String WorkString;
    private String ItemString;

    public GuiUniversalGen(InventoryPlayer inventory, TileUniversalGen tileEntity, EntityPlayer player) {
        super(new ContainerUniversalGen(inventory, tileEntity, player));
        this.tile = tileEntity;
        setTexture("textures/gui/gui.png", 175, 165);
        BarComponent barComponent = new BarComponent(this,1,34,18,0,168,26,50,"textures/gui/gui.png");
        barComponent.setSideDirection("left");
        addBarComponent(barComponent);
    }
    @Override
    public void Tick() {
        setBarValue(1,tile.getValue(1),tile.getValue(2));
    }
    @Override
    public void TickScreen() {
        this.UpdateButton();
        this.DrawToolTipInfoButton();
    }
    @Override
    public void initGui() {
        super.initGui();
        int ScaledX = (this.width - this.xSize) / 2;
        int ScaledY = (this.height - this.ySize) / 2;
        this.buttonList.clear();
        buttonWork = new GuiItemButton(tile,1, ScaledX+151, ScaledY+5,1);
        buttonItem = new GuiItemButton(tile,2,ScaledX+151,ScaledY+27,2);
        buttonImage = new GuiButtonImage(tile,3,ScaledX+151,ScaledY+49,3);
        buttonList.add(buttonWork);
        buttonList.add(buttonItem);
        buttonList.add(buttonImage);
    }
    private void UpdateButton() {
        int work = tile.getValue(3);
        int item = tile.getValue(4);
        int amountMode = tile.getValue(5);
        switch (amountMode) {
            case 1: buttonImage.setTexture(0,0); break;
            case 2: buttonImage.setTexture(16,0); break;
            case 3: buttonImage.setTexture(32,0); break;
            case 4: buttonImage.setTexture(48,0); break;
            case 5: buttonImage.setTexture(64,0); break;
            case 6: buttonImage.setTexture(80,0); break;
            case 7: buttonImage.setTexture(96,0); break;
        }
        switch (item) {
            case 0:
                buttonItem.setStackRender(new ItemStack(Blocks.COBBLESTONE));
                ItemString = Blocks.COBBLESTONE.getLocalizedName();
                break;
            case 1:
                buttonItem.setStackRender(new ItemStack(Blocks.GRAVEL));
                ItemString = Blocks.GRAVEL.getLocalizedName();
                break;
            case 2:
                buttonItem.setStackRender(new ItemStack(Blocks.SAND));
                ItemString = Blocks.SAND.getLocalizedName();
                break;
            case 3:
                buttonItem.setStackRender(new ItemStack(Blocks.NETHERRACK));
                ItemString = Blocks.NETHERRACK.getLocalizedName();
                break;
            case 4:
                buttonItem.setStackRender(new ItemStack(Blocks.END_STONE));
                ItemString = Blocks.END_STONE.getLocalizedName();
                break;
            case 5:
                buttonItem.setStackRender(new ItemStack(Blocks.DIRT));
                ItemString = Blocks.DIRT.getLocalizedName();
                break;
        }
        switch (work) {
            case 0:
                WorkString = LS.StrTextWorking;
                buttonWork.setStackRender(new ItemStack(Blocks.REDSTONE_LAMP));break;
            case 1:
                WorkString = LS.StrTextAlways;
                buttonWork.setStackRender(new ItemStack(Blocks.REDSTONE_BLOCK));break;
            case 2:
                WorkString = LS.StrRedstoneMode;
                buttonWork.setStackRender(new ItemStack(Items.REDSTONE));break;
            case 3:
                WorkString = LS.StrRedstoneModeRevers;
                buttonWork.setStackRender(new ItemStack(Blocks.REDSTONE_TORCH));break;
        }
    }
    private void DrawToolTipInfoButton() {
        for (GuiButton button : buttonList) {
            if (button.isMouseOver()) {
                if (button.equals(buttonWork)) {
                    drawHoveringText(WorkString, getMouseX(), getMouseY());
                }
                if (button.equals(buttonItem)) {
                    drawHoveringText(ItemString, getMouseX(), getMouseY());
                }
                if (button.equals(buttonImage)) {
                    drawHoveringText(LS.StrImageString, getMouseX(), getMouseY());
                }
            }
        }
    }
}