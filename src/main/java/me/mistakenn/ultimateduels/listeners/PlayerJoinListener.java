package me.mistakenn.ultimateduels.listeners;

import me.mistakenn.ultimateduels.commands.DefaultSaturation;
import me.mistakenn.ultimateduels.scoreboard.HealthIndicators;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    HealthIndicators healthIndic = new HealthIndicators();
    private final DefaultSaturation defaultSaturationInstance;

    public PlayerJoinListener(DefaultSaturation defaultSaturationInstance) {
        this.defaultSaturationInstance = defaultSaturationInstance;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        Player p = e.getPlayer();
        p.setSaturation(defaultSaturationInstance.defaultSaturation);
        healthIndic.setHealthScoreboard(e.getPlayer());
    }

}
