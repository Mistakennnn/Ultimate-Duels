package me.mistakenn.ultimateduels.commands.kitsGive;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class axeKit implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player)
        {
            Player p = (Player) sender;
            PlayerInventory playerInventory = p.getInventory();

            ItemStack[] armorContents = new ItemStack[4];

            armorContents[3] = new ItemStack(Material.DIAMOND_HELMET);
            armorContents[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
            armorContents[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
            armorContents[0] = new ItemStack(Material.DIAMOND_BOOTS);

            ItemStack shield = new ItemStack(Material.SHIELD);

            ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);

            ItemStack bow = new ItemStack(Material.BOW);

            ItemStack axe = new ItemStack(Material.DIAMOND_AXE);

            ItemStack arrows = new ItemStack(Material.ARROW, 6);

            ItemStack crossbow = new ItemStack(Material.CROSSBOW);


            playerInventory.clear();

            playerInventory.setArmorContents(armorContents);
            playerInventory.setItemInOffHand(shield);

            playerInventory.setItem(0, diamondSword);
            playerInventory.setItem(2, bow);
            playerInventory.setItem(3, axe);
            playerInventory.setItem(4, arrows);
            playerInventory.setItem(5, crossbow);
        }

        return true;
    }
}
