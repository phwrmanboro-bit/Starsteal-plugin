package com.starsteal;

import com.starsteal.ability.AbilityManager;
import com.starsteal.cooldown.CooldownManager;
import com.starsteal.star.StarManager;
import org.bukkit.plugin.java.JavaPlugin;

public class StarSteal extends JavaPlugin {

    private static StarSteal instance;
    private CooldownManager cooldownManager;
    private StarManager starManager;

    @Override
    public void onEnable() {
        instance = this;

        cooldownManager = new CooldownManager();
        starManager = new StarManager(this);

        getServer().getPluginManager().registerEvents(
                new AbilityManager(this, cooldownManager, starManager),
                this
        );

        getCommand("starsteal").setExecutor(new StarStealCommand(starManager));

        getLogger().info("StarSteal plugin ENABLED");
    }

    @Override
    public void onDisable() {
        getLogger().info("StarSteal plugin DISABLED");
    }

    public static StarSteal getInstance() {
        return instance;
    }
}
