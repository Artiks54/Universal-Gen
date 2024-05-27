package com.ariks.cobblegen.util;

import com.ariks.cobblegen.CobbleGen;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class JoinDiscord {
    @SubscribeEvent
    public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        TextComponentString hello = new TextComponentString("Hello "+event.player.getName());
        hello.getStyle().setColor(TextFormatting.GREEN);
        event.player.sendMessage(hello);
        TextComponentString mainMessage = new TextComponentString("Cobble-Gen version. "+TextFormatting.DARK_PURPLE+ CobbleGen.VERSION);
        mainMessage.getStyle().setColor(TextFormatting.GREEN);
        event.player.sendMessage(mainMessage);
        TextComponentString linkMessage = new TextComponentString(TextFormatting.GREEN+"->"+TextFormatting.DARK_PURPLE+" https://discord.gg/Mp5sEpE3B3 "+TextFormatting.GREEN+"<-");
        linkMessage.getStyle()
                .setUnderlined(true)
                .setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://discord.gg/Mp5sEpE3B3"))
                .setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TextComponentString("Join the official discord link")));
        event.player.sendMessage(linkMessage);
    }
}