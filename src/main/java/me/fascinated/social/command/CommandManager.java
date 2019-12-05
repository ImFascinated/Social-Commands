package me.fascinated.social.command;

import me.fascinated.social.Social;
import me.fascinated.social.command.commands.*;
import org.bukkit.command.CommandExecutor;

public class CommandManager {
    public CommandManager() {
        registerCommand("social", new SocialCommand());
        registerCommand("discord", new DiscordCommand());
        registerCommand("store", new StoreCommand());
        registerCommand("teamspeak", new TeamspeakCommand());
        registerCommand("twitter", new TwitterCommand());
        registerCommand("website", new WebsiteCommand());
    }

    private void registerCommand(String command, CommandExecutor executor) {
        Social.getInstance().getCommand(command).setExecutor(executor);
    }
}
