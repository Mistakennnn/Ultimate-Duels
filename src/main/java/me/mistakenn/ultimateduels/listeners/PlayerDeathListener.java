package me.mistakenn.ultimateduels.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.Plugin;

import java.time.Duration;
import java.util.Objects;

public class PlayerDeathListener implements Listener {
    private Plugin plugin;
    private int duelAmount;
    private Player player1;
    private Player player2;
    private int playerDeathCount;
    private int player1kills;
    private int player2kills;
    private InventoryClickListener inventoryClickListener; // Add this line

    public PlayerDeathListener(Plugin plugin) {
        this.plugin = plugin;
    }

    public PlayerDeathListener(Plugin plugin, int duelAmount, Player player1, Player player2, InventoryClickListener inventoryClickListener) {
        this.plugin = plugin;
        this.duelAmount = duelAmount;
        this.player1 = player1;
        this.player2 = player2;
        this.playerDeathCount = 1;
        this.player1kills = 0;
        this.player2kills = 0;
        this.inventoryClickListener = inventoryClickListener;
    }


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        e.getDrops().clear();
        e.setShouldDropExperience(false);
        Player killed = e.getEntity();
        Player killer = killed.getKiller();

        if (Objects.equals(player1, killer) || Objects.equals(player2, killed) || Objects.equals(player1, killed) || Objects.equals(player2, killer))
        {
            if (!(playerDeathCount>=duelAmount))
            {
                playerDeathCount++;
                player1.sendMessage(ChatColor.GREEN + "Round " + playerDeathCount + "/" + duelAmount + " starting!");
                player2.sendMessage(ChatColor.GREEN + "Round " + playerDeathCount + "/" + duelAmount + " starting!");
                Bukkit.getScheduler().runTaskLater(plugin, () -> {
                    killed.spigot().respawn();
                    inventoryClickListener.startDuel(null, player1, player2);
                }, 1);
            }

            if (Objects.equals(player1, killer)) {
                player1kills++;
            } else if (Objects.equals(player2, killer)) {
                player2kills++;
            }
            String score = ChatColor.BLUE + player1.getName() + " " + player1kills + ChatColor.YELLOW + " - " + ChatColor.RED + player2kills + " " + player2.getName();
            player1.sendTitle("", score);
            player2.sendTitle("", score);
        }
    }
}


