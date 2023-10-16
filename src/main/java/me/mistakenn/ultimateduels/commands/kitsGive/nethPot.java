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
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;

public class nethPot implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            PlayerInventory playerInventory = p.getInventory();

            ItemStack[] armorContents = new ItemStack[4];

            armorContents[3] = new ItemStack(Material.NETHERITE_HELMET);
            ItemMeta metaHelmet = armorContents[3].getItemMeta();
            metaHelmet.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            metaHelmet.addEnchant(Enchantment.DURABILITY, 3, true);
            metaHelmet.addEnchant(Enchantment.MENDING, 1, true);
            armorContents[3].setItemMeta(metaHelmet);

            armorContents[2] = new ItemStack(Material.NETHERITE_CHESTPLATE);
            ItemMeta metaChestplate = armorContents[2].getItemMeta();
            metaChestplate.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            metaChestplate.addEnchant(Enchantment.DURABILITY, 3, true);
            metaChestplate.addEnchant(Enchantment.MENDING, 1, true);
            armorContents[2].setItemMeta(metaChestplate);

            armorContents[1] = new ItemStack(Material.NETHERITE_LEGGINGS);
            ItemMeta metaLeggings = armorContents[1].getItemMeta();
            metaLeggings.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            metaLeggings.addEnchant(Enchantment.DURABILITY, 3, true);
            metaLeggings.addEnchant(Enchantment.MENDING, 1, true);
            armorContents[1].setItemMeta(metaLeggings);

            armorContents[0] = new ItemStack(Material.NETHERITE_BOOTS);
            ItemMeta metaBoots = armorContents[0].getItemMeta();
            metaBoots.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            metaBoots.addEnchant(Enchantment.DURABILITY, 3, true);
            metaBoots.addEnchant(Enchantment.MENDING, 1, true);
            armorContents[0].setItemMeta(metaBoots);

            ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 64);

            ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
            ItemStack xpBottles = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);

            ItemStack healthPots = new ItemStack(Material.SPLASH_POTION, 1);
            PotionMeta metaHealthpots = (PotionMeta) healthPots.getItemMeta();
            metaHealthpots.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL, false, true));
            healthPots.setItemMeta(metaHealthpots);

            ItemStack strengthPots = new ItemStack(Material.SPLASH_POTION, 1);
            PotionMeta metaStrengthPots = (PotionMeta) strengthPots.getItemMeta();
            metaStrengthPots.setBasePotionData(new PotionData(PotionType.STRENGTH, false, true));
            strengthPots.setItemMeta(metaStrengthPots);

            ItemStack speedPots = new ItemStack(Material.SPLASH_POTION, 1);
            PotionMeta metaSpeedPots = (PotionMeta) speedPots.getItemMeta();
            metaSpeedPots.setBasePotionData(new PotionData(PotionType.SPEED, false, true));
            speedPots.setItemMeta(metaSpeedPots);

            ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
            ItemMeta metaSword = sword.getItemMeta();
            metaSword.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            metaSword.addEnchant(Enchantment.DURABILITY, 3, true);
            sword.setItemMeta(metaSword);

            playerInventory.clear();

            playerInventory.setArmorContents(armorContents);
            playerInventory.setItemInOffHand(gaps);

            int[] healthPotSlots = {2, 3, 4, 5, 9, 10,11, 12, 13, 16, 18, 19, 20, 21, 27, 28, 29, 30};
            int[] strengthPotSlots = {7, 14, 23, 25, 32, 34};
            int[] speedPotSlots = {8, 15, 22, 24, 31, 33};
            int[] xpBottleSlots = {1, 17};
            int[] totemSlots = {6, 26, 35};

            playerInventory.setItem(0, sword);

            for (int slot : xpBottleSlots){
                playerInventory.setItem(slot, xpBottles);
            }

            for (int slot : healthPotSlots){
                playerInventory.setItem(slot, healthPots);
            }

            for (int slot : totemSlots){
                playerInventory.setItem(slot, totem);
            }

            for (int slot : strengthPotSlots){
                playerInventory.setItem(slot, strengthPots);
            }

            for (int slot : speedPotSlots){
                playerInventory.setItem(slot, speedPots);
            }


        }
        return true;
    }
}
