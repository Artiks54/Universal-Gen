package com.ariks.universalgen.Util;

import com.ariks.universalgen.UniversalGen;
import net.minecraft.client.resources.I18n;

public class LocalizedStringKey {
    public static final String modid = UniversalGen.MOD_ID + "_";
    public String StrRedstoneMode = I18n.format(modid+"gui.button.StrRedstone");
    public String StrRedstoneModeRevers = I18n.format(modid+"gui.button.StrRedstoneRevers");
    public String StrTextWorking = I18n.format(modid+"gui.button.working");
    public String StrTextAlways = I18n.format(modid+"gui.button.always");
    public String StrImageString = I18n.format(modid+"gui.button.image");
    public String StrProgress = I18n.format(modid+"gui.bar.progress");
}
