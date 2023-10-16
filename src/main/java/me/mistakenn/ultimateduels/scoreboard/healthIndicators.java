package me.mistakenn.ultimateduels.scoreboard;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;


public class healthIndicators {

    public void setHealthScoreboard(Player player) {
        Objective oob = player.getScoreboard().getObjective("opp-hp");
        if(oob != null) oob.unregister();

        Objective o = player.getPlayer().getScoreboard().registerNewObjective("opp-hp", "health", "❤", RenderType.INTEGER);
        o.setDisplaySlot(DisplaySlot.BELOW_NAME);
    }
}