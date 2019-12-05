package me.fascinated.social.command.commands;

import me.fascinated.social.Social;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Project: Social-Commands
 * Date: Sat 25, May at 03:24
 * Created By: ImFascinated
 */
public class SocialCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("social.command.admin")) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Social.getConfiguration().getConfiguration().getString("no-permission")));
            return false;
        }
        if (args.length < 1 || args.length > 2) {
            sender.sendMessage("§8§m---------------------------------------");
            sender.sendMessage("§a§lSocial §8┃ §fv" + Social.getInstance().getDescription().getVersion());
            sender.sendMessage("");
            sender.sendMessage("§8* §a/social reload §8- §fReloads the config!");
            sender.sendMessage("§8§m---------------------------------------");
        } else if (args[0].equalsIgnoreCase("reload")) {
            sender.sendMessage("§e§lNotice §8▪ §fThe configuration is reloading...");
            try {
                sender.sendMessage("§a§lSuccess §8▪ §fThe configuration has reloaded!");
                Social.getConfiguration().reloadConfig();
            } catch (Exception ex) {
                sender.sendMessage("§a§lSuccess §8▪ §fThe configuration has failed to reload!");
                ex.printStackTrace();
            }
        }
        return false;
    }
}
