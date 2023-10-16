package me.mistakenn.ultimateduels.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class lokaDamage implements CommandExecutor {
    public boolean lokadmg = false;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        lokadmg = !lokadmg;
        Player p = (Player) sender;
        if (lokadmg)
        {
            p.sendMessage("Loka Damage ON!");
        }
        else
        {
            p.sendMessage("Loka Damage OFF!");
        }
        return true;
    }

    public boolean lokaDmg() {
        return lokadmg;
    }
}
