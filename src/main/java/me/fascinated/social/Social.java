package me.fascinated.social;

import lombok.Getter;
import me.fascinated.social.command.CommandManager;
import me.fascinated.social.util.Config;
import me.fascinated.social.util.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

public class Social extends JavaPlugin {
    @Getter private static Social instance;
    @Getter private static Config configuration;

    public void onEnable () {
        instance = this;

        configuration = new Config(this, "config.yml", null);
        configuration.saveDefaultConfig();

        new Metrics(this);
        new CommandManager();
    }
}
