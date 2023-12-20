package me.mistakenn.ultimateduels.commands;

import me.mistakenn.ultimateduels.utils.DuelsMenu;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Kit implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p = (Player) sender;

        switch (args.length) {
            case 0:
                DuelsMenu.duelsMenu(p, false);
                break;

            default:
                p.sendMessage(ChatColor.RED + "Too many arguments!");
                p.sendMessage(ChatColor.RED + "Correct synthax: /kit");
                break;
        }

        return true;
    }
}