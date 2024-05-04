package fr.perrier.ntechat.utils;

import net.md_5.bungee.api.*;

public class ChatUtil {
    public static String translate(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
