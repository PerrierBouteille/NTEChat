package fr.perrier.ntechat;

import fr.perrier.ntechat.listener.*;
import lombok.*;
import org.bukkit.plugin.java.*;

public class Main extends JavaPlugin {

    @Getter
    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new ChatListener(),this);

    }
}
