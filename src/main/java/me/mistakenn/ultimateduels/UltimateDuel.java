package me.mistakenn.ultimateduels;

import me.mistakenn.ultimateduels.commands.kitsGive.*;
import me.mistakenn.ultimateduels.commands.lokaDamage;
import me.mistakenn.ultimateduels.listeners.EntityDamageByEntityListener;
import me.mistakenn.ultimateduels.listeners.EntityDamageListener;
import me.mistakenn.ultimateduels.listeners.PlayerJoinEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class UltimateDuel extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("uhckit").setExecutor(new UHCKit());
        getCommand("swordkit").setExecutor(new swordKit());
        getCommand("axekit").setExecutor(new axeKit());
        getCommand("nethpotkit").setExecutor(new nethPot());
        getCommand("potkit").setExecutor(new potKit());
        getCommand("smpkit").setExecutor(new smpKit());

        lokaDamage lokaDamageInstance = new lokaDamage();
        getCommand("lokadamage").setExecutor(lokaDamageInstance);

        getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(lokaDamageInstance), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(), this);
    }
}
