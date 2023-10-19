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
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;
import org.jetbrains.annotations.NotNull;

public class KitsGive implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        Player p = (Player) sender;

        switch (args.length) {
            case 0:
                p.sendMessage(ChatColor.RED + "Please specify what kit to give.");
                p.sendMessage(ChatColor.RED + "Correct synthax: /kit (mode) (player)");
                break;

            case 1:
                giveKit(args[0], p, p);
                break;

            case 2:
                Player targetPlayer = Bukkit.getPlayer(args[1]);
                if (targetPlayer != null && targetPlayer.isOnline()) {
                    giveKit(args[0], targetPlayer, p);
                } else {
                    p.sendMessage(ChatColor.RED + "You need to give a valid online player as an argument!");
                }
                break;

            default:
                p.sendMessage(ChatColor.RED + "Don't give more than 2 arguments!");
                p.sendMessage(ChatColor.RED + "Correct synthax: /kit <gamemode> [targetplayer]");
                break;
        }

        return true;
    }

    public void giveKit(String argument, Player p, Player sender) {
        PlayerInventory playerInventory = p.getInventory();
        ItemStack[] armorContents = new ItemStack[4];
        int[] healthPotSlots;
        int[] strengthPotSlots;
        int[] speedPotSlots;
        int[] xpBottleSlots;
        int[] totemSlots;

        Enchantment[] maxedArmorEnchs = {Enchantment.PROTECTION_ENVIRONMENTAL, Enchantment.DURABILITY, Enchantment.MENDING};
        int[] maxedArmorEnchLvls = {4, 3, 1};

        ItemStack diamondSword = new ItemStack(Material.DIAMOND_SWORD);
        ItemStack netheriteSword = new ItemStack(Material.NETHERITE_SWORD);
        ItemStack shield = new ItemStack(Material.SHIELD);
        ItemStack bow = new ItemStack(Material.BOW);
        ItemStack axe = new ItemStack(Material.DIAMOND_AXE);
        ItemStack diamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
        ItemStack crossbow = new ItemStack(Material.CROSSBOW);
        ItemStack gaps = new ItemStack(Material.GOLDEN_APPLE, 64);
        ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 1);
        ItemStack xpBottles = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);

        ItemStack healthPots = createPotion(PotionType.INSTANT_HEAL, false, true);
        ItemStack strengthPots = createPotion(PotionType.STRENGTH, false, true);
        ItemStack speedPots = createPotion( PotionType.SPEED, false, true);
        ItemStack regenPots = createPotion(PotionType.REGEN, false, true);
        ItemStack fresPots = createPotion(PotionType.FIRE_RESISTANCE, true, false);

        switch (argument.toLowerCase()) {
            case "sword":
                armorContents[3] = new ItemStack(Material.DIAMOND_HELMET);
                armorContents[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
                armorContents[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
                armorContents[0] = new ItemStack(Material.DIAMOND_BOOTS);

                enchantItems(armorContents, Enchantment.PROTECTION_ENVIRONMENTAL, 3);

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
                armorContents[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
                armorContents[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
                armorContents[0] = new ItemStack(Material.DIAMOND_BOOTS);

                enchantItems(armorContents, Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                enchantItem(diamondSword, new Enchantment[]{Enchantment.DAMAGE_ALL, Enchantment.DURABILITY, Enchantment.SWEEPING_EDGE}, new int[]{5, 3, 3});

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
                armorContents[2] = new ItemStack(Material.NETHERITE_CHESTPLATE);
                armorContents[1] = new ItemStack(Material.NETHERITE_LEGGINGS);
                armorContents[0] = new ItemStack(Material.NETHERITE_BOOTS);

                enchantItems(armorContents, maxedArmorEnchs, maxedArmorEnchLvls);
                enchantItem(netheriteSword, new Enchantment[]{Enchantment.DAMAGE_ALL, Enchantment.DURABILITY}, new int[]{5, 3});

                playerInventory.clear();

                playerInventory.setArmorContents(armorContents);
                playerInventory.setItemInOffHand(gaps);

                healthPotSlots = new int[]{2, 3, 4, 5, 9, 10, 11, 12, 13, 16, 18, 19, 20, 21, 27, 28, 29, 30};
                strengthPotSlots = new int[]{7, 14, 23, 25, 32, 34};
                speedPotSlots = new int[]{8, 15, 22, 24, 31, 33};
                xpBottleSlots = new int[]{1, 17};
                totemSlots = new int[]{6, 26, 35};

                playerInventory.setItem(0, netheriteSword);

                setItems(xpBottleSlots, xpBottles, playerInventory);
                setItems(strengthPotSlots, strengthPots, playerInventory);
                setItems(speedPotSlots, speedPots, playerInventory);
                setItems(healthPotSlots, healthPots, playerInventory);
                setItems(totemSlots, totem, playerInventory);

                break;

            case "uhc":
                armorContents[3] = new ItemStack(Material.DIAMOND_HELMET);
                armorContents[2] = new ItemStack(Material.DIAMOND_CHESTPLATE);
                armorContents[1] = new ItemStack(Material.DIAMOND_LEGGINGS);
                armorContents[0] = new ItemStack(Material.DIAMOND_BOOTS);

                enchantItems(armorContents, Enchantment.PROTECTION_ENVIRONMENTAL, 3);
                enchantItem(armorContents[2], Enchantment.PROTECTION_ENVIRONMENTAL, 2);

                ItemStack blocks = new ItemStack(Material.COBBLESTONE, 64);
                ItemStack UHCGaps = new ItemStack(Material.GOLDEN_APPLE, 13);
                ItemStack lavaBucket = new ItemStack(Material.LAVA_BUCKET, 1);
                ItemStack waterBucket = new ItemStack(Material.WATER_BUCKET, 1);
                ItemStack cobwebs = new ItemStack(Material.COBWEB, 8);
                ItemStack UHCArrows = new ItemStack(Material.ARROW, 16);

                enchantItem(bow, Enchantment.ARROW_DAMAGE, 1);
                enchantItem(diamondSword, Enchantment.DAMAGE_ALL, 4);
                enchantItem(axe, Enchantment.DAMAGE_ALL, 1);
                enchantItem(crossbow, Enchantment.PIERCING, 1);
                enchantItem(diamondPickaxe, new Enchantment[]{Enchantment.DURABILITY, Enchantment.DIG_SPEED}, new int[]{1, 3});

                playerInventory.clear();

                playerInventory.setArmorContents(armorContents);
                playerInventory.setItemInOffHand(shield);

                int[] waterBucketSlots = {7, 13, 22, 23};
                int[] lavaBucketSlots = {6, 14};
                int[] blockSlots = {1, 28};

                playerInventory.setItem(0, diamondSword);
                playerInventory.setItem(2, bow);
                playerInventory.setItem(3, axe);
                playerInventory.setItem(4, UHCGaps);
                playerInventory.setItem(5, crossbow);
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
                armorContents[2] = new ItemStack(Material.NETHERITE_CHESTPLATE);
                armorContents[1] = new ItemStack(Material.NETHERITE_LEGGINGS);
                armorContents[0] = new ItemStack(Material.NETHERITE_BOOTS);
                enchantItems(armorContents, maxedArmorEnchs, maxedArmorEnchLvls);

                enchantItem(shield, new Enchantment[]{Enchantment.DURABILITY, Enchantment.MENDING}, new int[]{3, 1});

                ItemStack nokbsword = new ItemStack(Material.NETHERITE_SWORD);
                ItemStack kbsword = new ItemStack(Material.NETHERITE_SWORD);
                ItemStack[] SMPSwords = {kbsword, nokbsword};
                Enchantment[] SMPSwordsEnchs = {Enchantment.DAMAGE_ALL, Enchantment.DURABILITY, Enchantment.FIRE_ASPECT};
                int[] SMPSwordsEnchLvls = {5, 3, 2};
                enchantItems(SMPSwords, SMPSwordsEnchs, SMPSwordsEnchLvls);
                enchantItem(SMPSwords[0], Enchantment.KNOCKBACK, 1);

                ItemStack SMPAxe = new ItemStack(Material.NETHERITE_AXE);
                enchantItem(SMPAxe, new Enchantment[]{Enchantment.DAMAGE_ALL, Enchantment.DURABILITY}, new int[]{5, 3});

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

                playerInventory.setItem(0, SMPSwords[0]);
                playerInventory.setItem(27, SMPSwords[1]);
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
        for (int slot : slots) {
            playerInventory.setItem(slot, item);
        }
    }

    public ItemStack[] enchantItems(ItemStack[] items, Enchantment[] enchantments, int[] levels) {
        for (ItemStack item : items) {
            ItemMeta itemMeta = item.getItemMeta();
            for (int i = 0; i < enchantments.length; i++) {
                itemMeta.addEnchant(enchantments[i], levels[i], true);
                item.setItemMeta(itemMeta);
            }
        }
        return items;
    }

    public ItemStack[] enchantItems(ItemStack[] items, Enchantment enchantment, int level) {
        for (ItemStack item : items) {
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.addEnchant(enchantment, level, true);
            item.setItemMeta(itemMeta);
        }
        return items;
    }

    public ItemStack enchantItem(ItemStack item, Enchantment[] enchantments, int[] levels) {
        ItemMeta itemMeta = item.getItemMeta();
        for (int i = 0; i < enchantments.length; i++) {
            itemMeta.addEnchant(enchantments[i], levels[i], true);
            item.setItemMeta(itemMeta);
        }
        return item;
    }

    public ItemStack enchantItem(ItemStack item, Enchantment enchantment, int level) {
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.addEnchant(enchantment, level, true);
        item.setItemMeta(itemMeta);
        return item;
    }

    public ItemStack createPotion(PotionType effect, boolean extended, boolean lvl2) {
        ItemStack pot = new ItemStack(Material.SPLASH_POTION, 1);
        PotionMeta metaPot = (PotionMeta) pot.getItemMeta();
        metaPot.setBasePotionData(new PotionData(effect, extended, lvl2));
        pot.setItemMeta(metaPot);
        return pot;
    }
}