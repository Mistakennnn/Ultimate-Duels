package me.mistakenn.ultimateduels.listeners;

import me.mistakenn.ultimateduels.utils.KitGiver;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e)
    {
        Player p = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.BLUE + "Select a gamemode!"))
        {
            e.setCancelled(true);

            String gamemodeClicked = e.getCurrentItem().getItemMeta().getDisplayName();
            KitGiver.giveKit(gamemodeClicked, p, p);

        }
    }

}
