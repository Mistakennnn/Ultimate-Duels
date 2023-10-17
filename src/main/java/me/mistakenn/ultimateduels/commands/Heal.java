package me.mistakenn.ultimateduels.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        Player p = (Player) sender;

        switch(args.length) {
            case 0:
                p.setHealth(p.getMaxHealth());
                p.setSaturation(5);
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.YELLOW + "You have been healed!");
                break;

            case 1:
                Player targetPlayer = Bukkit.getPlayer(args[0]);
                if (targetPlayer != null && targetPlayer.isOnline())
                {
                    targetPlayer.setHealth(targetPlayer.getMaxHealth());
                    targetPlayer.setSaturation(5);
                    targetPlayer.setFoodLevel(20);
                    p.sendMessage(ChatColor.YELLOW + "You healed " + targetPlayer.getDisplayName() + "!");
                    targetPlayer.sendMessage(ChatColor.YELLOW + "You have been healed by " + p.getDisplayName() + "!");
                }
                else
                {
                    p.sendMessage(ChatColor.RED + "You need to give a valid online player as an argument!");
                }
                break;
            default:
                p.sendMessage(ChatColor.RED + "Correct synthax: /heal (player)");
                break;
        }

        return true;
    }
}
