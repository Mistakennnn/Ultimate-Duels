package me.mistakenn.ultimateduels.listeners;

import me.mistakenn.ultimateduels.commands.DefaultSaturation;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;

public class PlayerRespawnListener implements Listener {
    private final DefaultSaturation defaultSaturationInstance;
    private static Plugin plugin;
    public static void initialize(Plugin plugin) {
        PlayerRespawnListener.plugin = plugin;
    }

    public PlayerRespawnListener(DefaultSaturation defaultSaturationInstance) {
        this.defaultSaturationInstance = defaultSaturationInstance;
    }

    @EventHandler
    public void onPlayerRespawn (PlayerRespawnEvent e)
    {
        Player p = e.getPlayer();
        Bukkit.getScheduler().runTaskLater(plugin, () -> {
            p.setSaturation(defaultSaturationInstance.defaultSaturation);
        }, 1L);
    }

}
