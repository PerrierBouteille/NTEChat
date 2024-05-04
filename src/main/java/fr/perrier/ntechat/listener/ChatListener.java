package fr.perrier.ntechat.listener;

import com.nametagedit.plugin.*;
import fr.perrier.ntechat.*;
import fr.perrier.ntechat.utils.*;
import net.md_5.bungee.api.chat.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.permissions.*;

import java.util.*;

public class ChatListener implements Listener {

    @EventHandler(ignoreCancelled = false, priority = EventPriority.HIGH)
    public void onChat(AsyncPlayerChatEvent event) {
        if(event.isCancelled()) return;

        String prefix = NametagEdit.getApi().getFakeTeam(event.getPlayer()).getPrefix();
        String suffix = NametagEdit.getApi().getFakeTeam(event.getPlayer()).getSuffix();
        String format = Main.getInstance().getConfig().getString("chatformat");

        if(format == null) return;

        format = format.replace("%prefix%",prefix);
        format = format.replace("%suffix%",suffix);
        format = format.replace("%player%",event.getPlayer().getName());
        format = format.replace("%message",event.getMessage());

        String finalFormat = format;
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.spigot().sendMessage(new TextComponent(ChatUtil.translate(finalFormat)));
        });
        event.setCancelled(true);
    }
}
