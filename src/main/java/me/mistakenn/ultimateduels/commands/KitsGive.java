package me.mistakenn.ultimateduels.commands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
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

public class KitsGive implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p = (Player) sender;

        switch(args.length) {
            case 0:
                p.sendMessage(ChatColor.RED + "Please specify what kit to give.");
                p.sendMessage(ChatColor.RED + "Correct synthax: /kit (mode) (player)");
                break;

            case 1:
                giveKit(args[0], p, p);
                break;

            case 2:
                Player targetPlayer = Bukkit.getPlayer(args[1]);
                if (targetPlayer != null && targetPlayer.isOnline())
                {
                    giveKit(args[0], targetPlayer, p);
                }
                else
                {
                    p.sendMessage(ChatColor.RED + "You need to give a valid online player as an argument!");
                }
                break;

            default:
                p.sendMessage(ChatColor.RED + "Don't give more than 2 arguments!");
                p.sendMessage(ChatColor.RED + "Correct synthax: /kit (mode) (player)");
                break;
        }

        return true;
    }

    public void giveKit (String argument, Player p, Player sender)
    {
        PlayerInventory playerInventory = p.getInventory();
        ItemStack[] armorContents = new ItemStack[4];
        int[] healthPotSlots;
        int[] strengthPotSlots;
        int[] speedPotSlots;
        int[] xpBottleSlots;
        int[] totemSlots;

        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack shield = new ItemStack(Material.SHIELD);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
        ItemStack crossbow = new ItemStack(Material.CROSSBOW);
        ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 64);
        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
        ItemStack xpBottles = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
        ItemStack healthPots = new ItemStack(Material.SPLASH_POTION, 1);
        ItemStack strengthPots = new ItemStack(Material.SPLASH_POTION, 1);
        ItemStack speedPots = new ItemStack(Material.SPLASH_POTION, 1);

        PotionMeta metaHealthpots = (PotionMeta) healthPots.getItemMeta();
        metaHealthpots.setBasePotionData(new PotionData(PotionType.INSTANT_HEAL, false, true));
        healthPots.setItemMeta(metaHealthpots);

        PotionMeta metaStrengthPots = (PotionMeta) strengthPots.getItemMeta();
        metaStrengthPots.setBasePotionData(new PotionData(PotionType.STRENGTH, false, true));
        strengthPots.setItemMeta(metaStrengthPots);

        PotionMeta metaSpeedPots = (PotionMeta) speedPots.getItemMeta();
        metaSpeedPots.setBasePotionData(new PotionData(PotionType.SPEED, false, true));
        speedPots.setItemMeta(metaSpeedPots);

        switch (argument.toLowerCase()) {
            case "sword":
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

                playerInventory.clear();

                playerInventory.setArmorContents(armorContents);
                playerInventory.setItem(0, diamondSword);

                break;

            case "axe":
                armorContents[3] = new ItemStack(Material.DIAMOND_HELMET);
                armorContents[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
                armorContents[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
                armorContents[0] = new ItemStack(Material.DIAMOND_BOOTS);

                ItemStack axeArrows = new ItemStack(Material.ARROW, 6);

                playerInventory.clear();

                playerInventory.setArmorContents(armorContents);
                playerInventory.setItemInOffHand(shield);

                playerInventory.setItem(0, diamondSword);
                playerInventory.setItem(2, bow);
                playerInventory.setItem(3, axe);
                playerInventory.setItem(4, axeArrows);
                playerInventory.setItem(5, crossbow);

                break;

            case "pot":
                armorContents[3] = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta metaPotHelmet = armorContents[3].getItemMeta();
                metaPotHelmet.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                armorContents[3].setItemMeta(metaPotHelmet);

                armorContents[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta metaPotChestplate = armorContents[2].getItemMeta();
                metaPotChestplate.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                armorContents[2].setItemMeta(metaPotChestplate);

                armorContents[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta metaPotPants = armorContents[1].getItemMeta();
                metaPotPants.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                armorContents[1].setItemMeta(metaPotPants);

                armorContents[0] = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta metaPotBoots = armorContents[0].getItemMeta();
                metaPotBoots.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                armorContents[0].setItemMeta(metaPotBoots);
                ItemStack regenPots = new ItemStack(Material.SPLASH_POTION, 1);
                PotionMeta metaRegenPots = (PotionMeta) regenPots.getItemMeta();
                metaRegenPots.setBasePotionData(new PotionData(PotionType.REGEN, true, false));
                regenPots.setItemMeta(metaRegenPots);

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

                healthPotSlots = new int[]{1, 2, 3, 4, 5, 9, 10, 11, 12, 13, 14, 18, 19, 20, 21, 22, 23, 27, 28, 29, 30, 31, 32};
                strengthPotSlots = new int[]{7, 16, 25, 34};
                speedPotSlots = new int[]{6, 15, 24, 33};
                int[] regenPotSlots = {8, 17, 26, 35};

                setItems(strengthPotSlots, strengthPots, playerInventory);
                setItems(speedPotSlots, speedPots, playerInventory);
                setItems(healthPotSlots, healthPots, playerInventory);
                setItems(regenPotSlots, regenPots, playerInventory);

                break;

            case "nethpot":
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

                ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
                ItemMeta metaSword = sword.getItemMeta();
                metaSword.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                metaSword.addEnchant(Enchantment.DURABILITY, 3, true);
                sword.setItemMeta(metaSword);

                playerInventory.clear();

                playerInventory.setArmorContents(armorContents);
                playerInventory.setItemInOffHand(gaps);

                healthPotSlots = new int[]{2, 3, 4, 5, 9, 10,11, 12, 13, 16, 18, 19, 20, 21, 27, 28, 29, 30};
                strengthPotSlots = new int[]{7, 14, 23, 25, 32, 34};
                speedPotSlots = new int[]{8, 15, 22, 24, 31, 33};
                xpBottleSlots = new int[]{1, 17};
                totemSlots = new int[]{6, 26, 35};

                playerInventory.setItem(0, sword);

                setItems(xpBottleSlots, xpBottles, playerInventory);
                setItems(strengthPotSlots, strengthPots, playerInventory);
                setItems(speedPotSlots, speedPots, playerInventory);
                setItems(healthPotSlots, healthPots, playerInventory);
                setItems(totemSlots, totem, playerInventory);

                break;

            case "uhc":
                armorContents[3] = new ItemStack(Material.DIAMOND_HELMET);
                ItemMeta metaUHCHelmet = armorContents[3].getItemMeta();
                metaUHCHelmet.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                armorContents[3].setItemMeta(metaUHCHelmet);

                armorContents[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta metaUHCChestplate = armorContents[2].getItemMeta();
                metaUHCChestplate.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                armorContents[2].setItemMeta(metaUHCChestplate);

                armorContents[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemMeta metaUHCPants = armorContents[1].getItemMeta();
                metaUHCPants.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                armorContents[1].setItemMeta(metaUHCPants);

                armorContents[0] = new ItemStack(Material.DIAMOND_BOOTS);
                ItemMeta metaUHCBoots = armorContents[0].getItemMeta();
                metaUHCBoots.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                armorContents[0].setItemMeta(metaUHCBoots);

                ItemMeta metaUHCSword = diamondSword.getItemMeta();
                metaUHCSword.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
                diamondSword.setItemMeta(metaUHCSword);

                ItemStack blocks = new ItemStack(Material.COBBLESTONE, 64);

                ItemMeta metaBow = bow.getItemMeta();
                metaBow.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                bow.setItemMeta(metaBow);

                ItemMeta metaDiamondAxe = axe.getItemMeta();
                metaDiamondAxe.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                axe.setItemMeta(metaDiamondAxe);

                ItemStack UHCGaps = new ItemStack(Material.GOLDEN_APPLE, 13);

                ItemMeta metaCrossbow = crossbow.getItemMeta();
                metaCrossbow.addEnchant(Enchantment.PIERCING, 1, true);
                crossbow.setItemMeta(metaCrossbow);

                ItemStack lavaBucket = new ItemStack(Material.LAVA_BUCKET, 1);
                ItemStack waterBucket = new ItemStack(Material.WATER_BUCKET, 1);
                ItemStack cobwebs = new ItemStack(Material.COBWEB, 8);
                ItemStack UHCArrows = new ItemStack(Material.ARROW, 16);

                ItemStack diamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
                ItemMeta metaDiamondPickaxe = diamondPickaxe.getItemMeta();
                metaDiamondPickaxe.addEnchant(Enchantment.DIG_SPEED, 3, true);
                metaDiamondPickaxe.addEnchant(Enchantment.DURABILITY, 1, true);
                diamondPickaxe.setItemMeta(metaDiamondPickaxe);

                playerInventory.clear();

                playerInventory.setArmorContents(armorContents);
                playerInventory.setItemInOffHand(shield);

                int[] waterBucketSlots = {7, 13, 22, 23};
                int[] lavaBucketSlots = {6, 14};
                int[] blockSlots = {1, 28};

                playerInventory.setItem(0, diamondSword);
                playerInventory.setItem(2, bow);
                playerInventory.setItem(3,axe);
                playerInventory.setItem(4,UHCGaps);
                playerInventory.setItem(5,crossbow);
                playerInventory.setItem(8, cobwebs);
                playerInventory.setItem(9, UHCArrows);
                playerInventory.setItem(12, diamondPickaxe);
                playerInventory.setItem(15, shield);

                setItems(waterBucketSlots, waterBucket, playerInventory);
                setItems(lavaBucketSlots, lavaBucket, playerInventory);
                setItems(blockSlots, blocks, playerInventory);

                break;

            case "smp":
                armorContents[3] = new ItemStack(Material.NETHERITE_HELMET);
                ItemMeta metaSMPHelmet = armorContents[3].getItemMeta();
                metaSMPHelmet.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                metaSMPHelmet.addEnchant(Enchantment.DURABILITY, 3, true);
                metaSMPHelmet.addEnchant(Enchantment.MENDING, 1, true);
                armorContents[3].setItemMeta(metaSMPHelmet);

                armorContents[2] = new ItemStack(Material.NETHERITE_CHESTPLATE);
                ItemMeta metaSMPChestplate = armorContents[2].getItemMeta();
                metaSMPChestplate.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                metaSMPChestplate.addEnchant(Enchantment.DURABILITY, 3, true);
                metaSMPChestplate.addEnchant(Enchantment.MENDING, 1, true);
                armorContents[2].setItemMeta(metaSMPChestplate);

                armorContents[1] = new ItemStack(Material.NETHERITE_LEGGINGS);
                ItemMeta metaSMPLeggings = armorContents[1].getItemMeta();
                metaSMPLeggings.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                metaSMPLeggings.addEnchant(Enchantment.DURABILITY, 3, true);
                metaSMPLeggings.addEnchant(Enchantment.MENDING, 1, true);
                armorContents[1].setItemMeta(metaSMPLeggings);

                armorContents[0] = new ItemStack(Material.NETHERITE_BOOTS);
                ItemMeta metaSMPBoots = armorContents[0].getItemMeta();
                metaSMPBoots.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
                metaSMPBoots.addEnchant(Enchantment.DURABILITY, 3, true);
                metaSMPBoots.addEnchant(Enchantment.MENDING, 1, true);
                armorContents[0].setItemMeta(metaSMPBoots);

                ItemMeta metaShield = shield.getItemMeta();
                metaShield.addEnchant(Enchantment.DURABILITY, 3, true);
                metaShield.addEnchant(Enchantment.MENDING, 1, true);
                shield.setItemMeta(metaShield);

                ItemStack fresPots = new ItemStack(Material.SPLASH_POTION, 1);
                PotionMeta metaFresPots = (PotionMeta) fresPots.getItemMeta();
                metaFresPots.setBasePotionData(new PotionData(PotionType.FIRE_RESISTANCE, true, false));
                fresPots.setItemMeta(metaFresPots);

                ItemStack nokbsword = new ItemStack(Material.NETHERITE_SWORD);
                ItemStack kbsword = new ItemStack(Material.NETHERITE_SWORD);
                ItemMeta metaNoKbSword = nokbsword.getItemMeta();
                metaNoKbSword.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                metaNoKbSword.addEnchant(Enchantment.DURABILITY, 3, true);
                metaNoKbSword.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
                nokbsword.setItemMeta(metaNoKbSword);
                metaNoKbSword.addEnchant(Enchantment.KNOCKBACK, 1, true);
                kbsword.setItemMeta(metaNoKbSword);

                ItemStack SMPAxe = new ItemStack(Material.NETHERITE_AXE);
                ItemMeta metaAxe = SMPAxe.getItemMeta();
                metaAxe.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
                metaAxe.addEnchant(Enchantment.DURABILITY, 3, true);
                SMPAxe.setItemMeta(metaAxe);

                ItemStack enderPearls = new ItemStack(Material.ENDER_PEARL, 16);

                playerInventory.clear();

                playerInventory.setArmorContents(armorContents);
                playerInventory.setItemInOffHand(shield);

                strengthPotSlots = new int[]{1, 10, 11, 12, 13, 14, 19, 20, 21, 22, 23};
                speedPotSlots = new int[]{2, 15, 16, 24, 25, 28, 29, 30, 31, 32, 33};
                xpBottleSlots = new int[]{7, 17};
                int[] enderPearlSlots = {8, 9, 18};
                int[] gapSlots = {4, 26};
                int[] fresPotSlots = {5, 34, 35};

                playerInventory.setItem(0, kbsword);
                playerInventory.setItem(27, nokbsword);
                playerInventory.setItem(3, SMPAxe);
                playerInventory.setItem(6, totem);

                setItems(xpBottleSlots, xpBottles, playerInventory);
                setItems(gapSlots, gaps, playerInventory);
                setItems(enderPearlSlots, enderPearls, playerInventory);
                setItems(strengthPotSlots, strengthPots, playerInventory);
                setItems(speedPotSlots, speedPots, playerInventory);
                setItems(fresPotSlots, fresPots, playerInventory);

                break;

            default:
                sender.sendMessage(ChatColor.RED + "This isn't a valid kit!");
                sender.sendMessage(ChatColor.RED + "Kit options are Sword, Axe, Pot, NethPot, UHC, SMP.");
                break;
        }
    }

    public void setItems(int[] slots, ItemStack item, PlayerInventory playerInventory) {
        for (int slot: slots)
        {
            playerInventory.setItem(slot, item);
        }

    }
}