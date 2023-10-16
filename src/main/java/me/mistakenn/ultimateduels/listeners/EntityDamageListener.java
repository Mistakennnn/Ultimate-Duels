package me.mistakenn.ultimateduels.listeners;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onEntityDamage(EntityDamageEvent e)
    {
        System.out.println("Entity damaged");

        if (e.getEntity() instanceof Player)
        {
            Player p = (Player) e.getEntity();
        }

    }

}
