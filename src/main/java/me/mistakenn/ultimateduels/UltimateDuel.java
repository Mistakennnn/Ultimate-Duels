package me.mistakenn.ultimateduels;

import me.mistakenn.ultimateduels.commands.Heal;
import me.mistakenn.ultimateduels.commands.KitsGive;
import me.mistakenn.ultimateduels.commands.lokaDamage;
import me.mistakenn.ultimateduels.listeners.EntityDamageByEntityListener;
import me.mistakenn.ultimateduels.listeners.EntityDamageListener;
import me.mistakenn.ultimateduels.listeners.PlayerJoinEventListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class UltimateDuel extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("kit").setExecutor(new KitsGive());
        getCommand("heal").setExecutor(new Heal());

        lokaDamage lokaDamageInstance = new lokaDamage();
        getCommand("lokadamage").setExecutor(lokaDamageInstance);

        getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(lokaDamageInstance), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinEventListener(), this);
    }
}
