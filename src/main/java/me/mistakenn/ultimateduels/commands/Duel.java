package me.mistakenn.ultimateduels.commands;

import me.mistakenn.ultimateduels.listeners.InventoryClickListener;
import me.mistakenn.ultimateduels.listeners.PlayerDeathListener;
import me.mistakenn.ultimateduels.utils.DuelsMenu;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class Duel implements CommandExecutor {
    Plugin plugin;

    public Duel(Plugin plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p = (Player) sender;

        switch (args.length) {
            case 0:
                p.sendMessage(ChatColor.RED + "Need to specify who to duel!");
                p.sendMessage(ChatColor.RED + "Correct synthax: /duel <targetplayer>");
                break;

            case 1:
                handleDuelCommand(p, args[0], false, null);
                break;

            case 2:

                try {
                    int duelAmount = Integer.parseInt(args[1]);
                    handleDuelCommand(p, args[0], true, duelAmount);
                } catch (NumberFormatException e) {
                    p.sendMessage(ChatColor.RED + "Invalid duel amount. Please provide a valid integer.");
                }
                break;

            default:
                p.sendMessage(ChatColor.RED + "Too many arguments!");
                p.sendMessage(ChatColor.RED + "Correct synthax: /duel <targetplayer>");
                break;
        }

        return true;
    }

    private void handleDuelCommand(Player p, String targetPlayerName, boolean multipleRounds, Integer duelAmount) {
        Player targetPlayer = Bukkit.getPlayer(targetPlayerName);
        if (onlineDifferentPlayer(p, targetPlayer)) {
            InventoryClickListener pass = new InventoryClickListener(targetPlayer);
            Bukkit.getServer().getPluginManager().registerEvents(pass, plugin);
            DuelsMenu.duelsMenu(p, true);

            if (multipleRounds && duelAmount != null)
            {
                PlayerDeathListener passDeath = new PlayerDeathListener(plugin, duelAmount, p, targetPlayer, pass);
                Bukkit.getServer().getPluginManager().registerEvents(passDeath, plugin);
            }
        }
    }

    public boolean onlineDifferentPlayer(Player p, Player targetPlayer)
    {
        if (targetPlayer != null && targetPlayer.isOnline())
        {
            if (targetPlayer != p)
            {
                return true;
            }
            else{
                p.sendMessage(ChatColor.RED + "Can't duel yourself!");
                return false;
            }
        }
        else {
            p.sendMessage(ChatColor.RED + "You need to give a valid online player as an argument!");
            return false;
        }
    }
}
