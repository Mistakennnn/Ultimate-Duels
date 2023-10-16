package me.mistakenn.ultimateduels.listeners;

import me.mistakenn.ultimateduels.scoreboard.healthIndicators;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinEventListener implements Listener {
    healthIndicators healthIndic = new healthIndicators();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        System.out.println("Player joined");

        healthIndic.setHealthScoreboard(e.getPlayer());
    }

}
