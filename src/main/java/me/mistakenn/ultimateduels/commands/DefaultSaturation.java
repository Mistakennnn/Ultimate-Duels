package me.mistakenn.ultimateduels.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DefaultSaturation implements CommandExecutor {
    public int defaultSaturation = 0;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p = (Player) sender;

        switch (args.length) {
            case 0:
                p.sendMessage(ChatColor.RED + "You need to pass a number between 0-20!");
                p.sendMessage(ChatColor.RED + "Correct synthax: /defaultsaturation <amount>");
                break;

            case 1:
                try {
                    int argument = Integer.parseInt(args[0]);
                    if (argument >= 0 && argument <= 20) {
                        defaultSaturation = argument;
                    }
                }
                catch (NumberFormatException e) {
                    p.sendMessage(ChatColor.RED + "You need to pass a number between 0-20!");
                    p.sendMessage(ChatColor.RED + "Correct synthax: /defaultsaturation <amount>");
                }
                break;

            default:
                p.sendMessage(ChatColor.RED + "Don't give more than 1 argument!");
                p.sendMessage(ChatColor.RED + "Correct synthax: /defaultsaturation <amount>");
                break;
        }

        return true;
    }
}
