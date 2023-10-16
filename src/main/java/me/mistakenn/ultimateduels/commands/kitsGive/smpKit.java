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
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;

public class smpKit implements CommandExecutor {
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

            ItemStack shield = new ItemStack(Material.SHIELD);
            ItemMeta metaShield = shield.getItemMeta();
            metaShield.addEnchant(Enchantment.DURABILITY, 3, true);
            metaShield.addEnchant(Enchantment.MENDING, 1, true);
            shield.setItemMeta(metaShield);

            ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 64);

            ItemStack enderPearls = new ItemStack(Material.ENDER_PEARL, 16);

            ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
            ItemStack xpBottles = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);

            ItemStack strengthPots = new ItemStack(Material.SPLASH_POTION, 1);
            PotionMeta metaStrengthPots = (PotionMeta) strengthPots.getItemMeta();
            metaStrengthPots.setBasePotionData(new PotionData(PotionType.STRENGTH, false, true));
            strengthPots.setItemMeta(metaStrengthPots);

            ItemStack speedPots = new ItemStack(Material.SPLASH_POTION, 1);
            PotionMeta metaSpeedPots = (PotionMeta) speedPots.getItemMeta();
            metaSpeedPots.setBasePotionData(new PotionData(PotionType.SPEED, false, true));
            speedPots.setItemMeta(metaSpeedPots);

            ItemStack fresPots = new ItemStack(Material.SPLASH_POTION, 1);
            PotionMeta metaFresPots = (PotionMeta) fresPots.getItemMeta();
            metaFresPots.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE, true, false));
            fresPots.setItemMeta(metaFresPots);

            ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
            ItemStack kbsword = new ItemStack(Material.NETHERITE_SWORD);
            ItemMeta metaSword = sword.getItemMeta();
            metaSword.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            metaSword.addEnchant(Enchantment.DURABILITY, 3, true);
            metaSword.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
            sword.setItemMeta(metaSword);
            metaSword.addEnchant(Enchantment.KNOCKBACK, 1, true);
            kbsword.setItemMeta(metaSword);

            ItemStack axe = new ItemStack(Material.NETHERITE_AXE);
            ItemMeta metaAxe = axe.getItemMeta();
            metaAxe.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            metaAxe.addEnchant(Enchantment.DURABILITY, 3, true);
            axe.setItemMeta(metaAxe);

            playerInventory.clear();

            playerInventory.setArmorContents(armorContents);
            playerInventory.setItemInOffHand(shield);

            int[] enderPearlSlots = {8, 9, 18};
            int[] gapSlots = {4, 26};
            int[] strengthPotSlots = {1, 10, 11, 12, 13, 14, 19, 20, 21, 22, 23};
            int[] speedPotSlots = {2, 15, 16, 24, 25, 28, 29, 30, 31, 32, 33};
            int[] fresPotSlots = {5, 34, 35};
            int[] xpBottleSlots = {7, 17};

            playerInventory.setItem(0, kbsword);
            playerInventory.setItem(27, sword);
            playerInventory.setItem(3, axe);

            playerInventory.setItem(6, totem);

            for (int slot : xpBottleSlots){
                playerInventory.setItem(slot, xpBottles);
            }

            for (int slot : gapSlots){
                playerInventory.setItem(slot, gaps);
            }

            for (int slot : enderPearlSlots){
                playerInventory.setItem(slot, enderPearls);
            }

            for (int slot : strengthPotSlots){
                playerInventory.setItem(slot, strengthPots);
            }

            for (int slot : speedPotSlots){
                playerInventory.setItem(slot, speedPots);
            }

            for (int slot: fresPotSlots){
                playerInventory.setItem(slot, fresPots);
            }


        }
        return true;
    }
}
