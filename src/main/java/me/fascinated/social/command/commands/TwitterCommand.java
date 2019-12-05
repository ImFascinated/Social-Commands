package me.fascinated.social.command.commands;

import me.fascinated.social.Social;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TwitterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (Social.getConfiguration().getConfiguration().getBoolean("twitter-command.enabled")) {
            if (sender.hasPermission("social.command.twitter")) {
                for (String msg : Social.getConfiguration().getConfiguration().getStringList("twitter-command.message"))
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            } else
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Social.getConfiguration().getConfiguration().getString("no-permission")));
        } else
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Social.getConfiguration().getConfiguration().getString("command-disabled")));
        return false;
    }
}
