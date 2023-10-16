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

public class potKit implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (sender instanceof Player)
        {
            Player p = (Player) sender;
            PlayerInventory playerInventory = p.getInventory();

            ItemStack[] armorContents = new ItemStack[4];

            armorContents[3] = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta metaDiamondHelmet = armorContents[3].getItemMeta();
            metaDiamondHelmet.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            armorContents[3].setItemMeta(metaDiamondHelmet);

            armorContents[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta metaDiamondChestplate = armorContents[2].getItemMeta();
            metaDiamondChestplate.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            armorContents[2].setItemMeta(metaDiamondChestplate);

            armorContents[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta metaDiamondPants = armorContents[1].getItemMeta();
            metaDiamondPants.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            armorContents[1].setItemMeta(metaDiamondPants);

            armorContents[0] = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta metaDiamondBoots = armorContents[0].getItemMeta();
            metaDiamondBoots.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            armorContents[0].setItemMeta(metaDiamondBoots);

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

            ItemStack regenPots = new ItemStack(Material.SPLASH_POTION, 1);
            PotionMeta metaRegenPots = (PotionMeta) regenPots.getItemMeta();
            metaRegenPots.setBasePotionData(new PotionData(PotionType.REGEN, true, false));
            regenPots.setItemMeta(metaRegenPots);

            ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta metaDiamondSword = diamondSword.getItemMeta();
            metaDiamondSword.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
            metaDiamondSword.addEnchant(Enchantment.DURABILITY, 3, true);
            metaDiamondSword.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
            diamondSword.setItemMeta(metaDiamondSword);

            ItemStack food = new ItemStack(Material.COOKED_BEEF, 20);

            playerInventory.clear();

            playerInventory.setArmorContents(armorContents);
            playerInventory.setItemInOffHand(food);
            playerInventory.setItem(0, diamondSword);

            int[] healthPotSlots = {1, 2, 3, 4, 5, 9, 10, 11, 12, 13, 14, 18, 19, 20, 21, 22, 23, 27, 28, 29, 30, 31, 32};
            int[] strengthPotSlots = {7, 16, 25, 34};
            int[] speedPotSlots = {6, 15, 24, 33};
            int[] regenPotSlots = {8, 17, 26, 35};

            for (int slot : healthPotSlots){
                playerInventory.setItem(slot, healthPots);
            }

            for (int slot : regenPotSlots){
                playerInventory.setItem(slot, regenPots);
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
