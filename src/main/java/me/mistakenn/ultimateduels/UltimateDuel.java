package me.mistakenn.ultimateduels;

import me.mistakenn.ultimateduels.commands.DefaultSaturation;
import me.mistakenn.ultimateduels.commands.Heal;
import me.mistakenn.ultimateduels.commands.KitsGive;
import me.mistakenn.ultimateduels.commands.LokaDamage;
import me.mistakenn.ultimateduels.listeners.EntityDamageByEntityListener;
import me.mistakenn.ultimateduels.listeners.EntityDamageListener;
import me.mistakenn.ultimateduels.listeners.PlayerJoinListener;
import me.mistakenn.ultimateduels.listeners.PlayerRespawnListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class UltimateDuel extends JavaPlugin {

    @Override
    public void onEnable() {
        PlayerRespawnListener.initialize(this);

        DefaultSaturation defaultSaturationIntance = new DefaultSaturation();
        getCommand("defaultsaturation").setExecutor(defaultSaturationIntance);

        LokaDamage lokaDamageInstance = new LokaDamage();
        getCommand("lokadamage").setExecutor(lokaDamageInstance);

        getCommand("kit").setExecutor(new KitsGive());
        getCommand("heal").setExecutor(new Heal(defaultSaturationIntance));

        getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(lokaDamageInstance), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(defaultSaturationIntance), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(defaultSaturationIntance), this);
    }
}
