package me.mistakenn.ultimateduels.utils;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DuelsMenu {

    public static void duelsMenu(Player p)
    {
        Inventory duelsMenu = Bukkit.createInventory(p, 9, ChatColor.BLUE + "Select a gamemode!");

        makeAndAddItem(Material.DIAMOND_SWORD, "Sword", duelsMenu);
        makeAndAddItem(Material.DIAMOND_AXE, "Axe", duelsMenu);
        makeAndAddItem(Material.SPLASH_POTION, "Pot", duelsMenu);
        makeAndAddItem(Material.NETHERITE_HELMET, "NethPot", duelsMenu);
        makeAndAddItem(Material.GOLDEN_APPLE, "UHC", duelsMenu);
        makeAndAddItem(Material.ENDER_PEARL, "SMP", duelsMenu);

        p.openInventory(duelsMenu);
    }

    public static void makeAndAddItem(Material type, String name, Inventory inventory)
    {
        ItemStack item = new ItemStack(type, 1);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(name);
        item.setItemMeta(itemMeta);
        inventory.addItem(item);
    }

}
