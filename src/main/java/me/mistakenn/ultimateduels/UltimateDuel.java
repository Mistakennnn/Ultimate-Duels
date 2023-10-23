package me.mistakenn.ultimateduels;

import me.mistakenn.ultimateduels.commands.DefaultSaturation;
import me.mistakenn.ultimateduels.commands.Heal;
import me.mistakenn.ultimateduels.commands.Kit;
import me.mistakenn.ultimateduels.commands.LokaDamage;
import me.mistakenn.ultimateduels.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class UltimateDuel extends JavaPlugin {

    @Override
    public void onEnable() {
        PlayerRespawnListener.initialize(this);

        DefaultSaturation defaultSaturationIntance = new DefaultSaturation();
        getCommand("defaultsaturation").setExecutor(defaultSaturationIntance);

        LokaDamage lokaDamageInstance = new LokaDamage();
        getCommand("lokadamage").setExecutor(lokaDamageInstance);

        getCommand("kit").setExecutor(new Kit());
        getCommand("heal").setExecutor(new Heal(defaultSaturationIntance));

        getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(lokaDamageInstance), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(defaultSaturationIntance), this);
        getServer().getPluginManager().registerEvents(new PlayerRespawnListener(defaultSaturationIntance), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
    }
}
