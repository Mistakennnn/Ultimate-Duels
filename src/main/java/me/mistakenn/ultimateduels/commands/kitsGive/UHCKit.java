package me.mistakenn.ultimateduels.commands.kitsGive;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class UHCKit implements CommandExecutor {
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
            metaDiamondChestplate.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
            armorContents[2].setItemMeta(metaDiamondChestplate);

            armorContents[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta metaDiamondPants = armorContents[1].getItemMeta();
            metaDiamondPants.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
            armorContents[1].setItemMeta(metaDiamondPants);

            armorContents[0] = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta metaDiamondBoots = armorContents[0].getItemMeta();
            metaDiamondBoots.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
            armorContents[0].setItemMeta(metaDiamondBoots);

            ItemStack shield = new ItemStack(Material.SHIELD);

            ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta metaDiamondSword = diamondSword.getItemMeta();
            metaDiamondSword.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
            diamondSword.setItemMeta(metaDiamondSword);

            ItemStack blocks = new ItemStack(Material.COBBLESTONE, 64);

            ItemStack bow = new ItemStack(Material.BOW);
            ItemMeta metaBow = bow.getItemMeta();
            metaBow.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
            bow.setItemMeta(metaBow);

            ItemStack diamondAxe = new ItemStack(Material.DIAMOND_AXE);
            ItemMeta metaDiamondAxe = diamondAxe.getItemMeta();
            metaDiamondAxe.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
            diamondAxe.setItemMeta(metaDiamondAxe);

            ItemStack goldenApples = new ItemStack(Material.GOLDEN_APPLE, 13);

            ItemStack crossbow = new ItemStack(Material.CROSSBOW);
            ItemMeta metaCrossbow = crossbow.getItemMeta();
            metaCrossbow.addEnchant(Enchantment.PIERCING, 1, true);
            crossbow.setItemMeta(metaCrossbow);

            ItemStack lavaBucket = new ItemStack(Material.LAVA_BUCKET, 1);

            ItemStack waterBucket = new ItemStack(Material.WATER_BUCKET, 1);

            ItemStack cobwebs = new ItemStack(Material.COBWEB, 8);

            ItemStack arrows = new ItemStack(Material.ARROW, 16);

            ItemStack diamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta metaDiamondPickaxe = diamondPickaxe.getItemMeta();
            metaDiamondPickaxe.addEnchant(Enchantment.DIG_SPEED, 3, true);
            metaDiamondPickaxe.addEnchant(Enchantment.DURABILITY, 1, true);
            diamondPickaxe.setItemMeta(metaDiamondPickaxe);

            playerInventory.clear();

            playerInventory.setArmorContents(armorContents);
            playerInventory.setItemInOffHand(shield);

            playerInventory.setItem(0, diamondSword);
            playerInventory.setItem(1, blocks);
            playerInventory.setItem(2, bow);
            playerInventory.setItem(3,diamondAxe);
            playerInventory.setItem(4,goldenApples);
            playerInventory.setItem(5,crossbow);
            playerInventory.setItem(6, lavaBucket);
            playerInventory.setItem(7, waterBucket);
            playerInventory.setItem(8, cobwebs);

            playerInventory.setItem(9, arrows);
            playerInventory.setItem(12, diamondPickaxe);
            playerInventory.setItem(13, waterBucket);
            playerInventory.setItem(14,lavaBucket);
            playerInventory.setItem(15, shield);
            playerInventory.setItem(22, waterBucket);
            playerInventory.setItem(23, waterBucket);
            playerInventory.setItem(28, blocks);
        }

        return true;
    }
}
