package me.mistakenn.ultimateduels.commands.kitsGive;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class swordKit implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player)
        {
            Player p = (Player) sender;
            PlayerInventory playerInventory = p.getInventory();

            ItemStack[] armorContents = new ItemStack[4];

            armorContents[3] = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta metaDiamondHelmet = armorContents[3].getItemMeta();
            metaDiamondHelmet.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
            armorContents[3].setItemMeta(metaDiamondHelmet);

            armorContents[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta metaDiamondChestplate = armorContents[2].getItemMeta();
            metaDiamondChestplate.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
            armorContents[2].setItemMeta(metaDiamondChestplate);

            armorContents[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta metaDiamondPants = armorContents[1].getItemMeta();
            metaDiamondPants.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
            armorContents[1].setItemMeta(metaDiamondPants);

            armorContents[0] = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta metaDiamondBoots = armorContents[0].getItemMeta();
            metaDiamondBoots.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
            armorContents[0].setItemMeta(metaDiamondBoots);

            ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);

            playerInventory.clear();

            playerInventory.setArmorContents(armorContents);
            playerInventory.setItem(0, diamondSword);
        }

        return true;
    }
}
