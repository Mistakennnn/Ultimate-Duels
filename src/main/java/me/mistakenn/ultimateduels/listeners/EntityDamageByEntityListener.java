package me.mistakenn.ultimateduels.listeners;

import me.mistakenn.ultimateduels.commands.lokaDamage;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class EntityDamageByEntityListener implements Listener {
    private final lokaDamage lokaDamageInstance;

    public EntityDamageByEntityListener(lokaDamage lokaDamageInstance) {
        this.lokaDamageInstance = lokaDamageInstance;
    }

    @EventHandler
    public void OnEntityDamageByEntity(EntityDamageByEntityEvent e) {

        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            Player p = (Player) e.getDamager();
            Player v = (Player) e.getEntity();
            if (v.isBlocking() && isAxe(p.getInventory().getItemInMainHand())) {
                    p.playSound(p.getLocation(), Sound.ITEM_SHIELD_BREAK, 1.0F, 1.0F);
            }

            if (lokaDamageInstance.lokaDmg()) {
                double originalDamage = e.getDamage();
                double increasedDamage = originalDamage * 1.33;
                e.setDamage(increasedDamage);
            }

        }
    }

    public boolean isAxe(ItemStack itemStack) {
        return itemStack.getType() == Material.WOODEN_AXE ||
                itemStack.getType() == Material.STONE_AXE ||
                itemStack.getType() == Material.IRON_AXE ||
                itemStack.getType() == Material.GOLDEN_AXE ||
                itemStack.getType() == Material.DIAMOND_AXE ||
                itemStack.getType() == Material.NETHERITE_AXE;
    }
}
