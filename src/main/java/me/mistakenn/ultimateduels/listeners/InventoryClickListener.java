package me.mistakenn.ultimateduels.listeners;

import me.mistakenn.ultimateduels.utils.KitGiver;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

import static org.bukkit.Bukkit.getLogger;

public class InventoryClickListener implements Listener {
    private Player targetPlayer;
    private static String lastSelectedGamemode;
    public InventoryClickListener()
    {
    }
    public InventoryClickListener(Player p)
    {
        this.targetPlayer = p;
    }


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

        else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Select a gamemode!"))
        {
            e.setCancelled(true);

            String gamemodeClicked = e.getCurrentItem().getItemMeta().getDisplayName();
            startDuel(gamemodeClicked, p, targetPlayer);
            lastSelectedGamemode = gamemodeClicked;
        }
    }

    public static void startDuel(String gamemodeClicked, Player p, Player targetPlayer)
    {
        String actualGamemode = Objects.requireNonNullElse(gamemodeClicked, lastSelectedGamemode);
        if (p != null && targetPlayer != null) {
            KitGiver.giveKit(actualGamemode, p, p);
            KitGiver.giveKit(actualGamemode, targetPlayer, p);
            p.setGameMode(GameMode.SURVIVAL);
            targetPlayer.setGameMode(GameMode.SURVIVAL);
            p.getServer().dispatchCommand(p, "heal");
            targetPlayer.getServer().dispatchCommand(targetPlayer, "heal");

            Location mapOPLegacy1 = new Location(p.getWorld(), 275, 9, 84);
            mapOPLegacy1.setYaw(-180);
            mapOPLegacy1.setPitch(0);
            Location mapOPLegacy2 = new Location(p.getWorld(), 275, 9, 56);
            mapOPLegacy2.setYaw(0);
            mapOPLegacy2.setPitch(0);
            p.teleport(mapOPLegacy1);
            targetPlayer.teleport(mapOPLegacy2);
        }
    }

}
