package com.ariks.universalgen.Block;

import com.ariks.universalgen.UniversalGen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public abstract class ExampleGuiContainer extends GuiContainer {
    private ResourceLocation textures;
    private int Width,Height;
    public ExampleGuiContainer(Container container) {
        super(container);
    }
    public void SetTexture(String texturePath) {
        this.textures = new ResourceLocation(UniversalGen.MOD_ID, texturePath);
    }
    public void SetWidth(int Width) {
        this.Width = Width;
    }
    public void SetHeight(int Height) {
        this.Height = Height;
    }
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }
    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(textures);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, Width,Height);
    }
}