package com.starsteal;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        getCommand("starsteal").setExecutor(new CommandManager());
        getLogger().info("StarSteal Plugin Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("StarSteal Plugin Disabled!");
    }

    public static Main getInstance() {
        return instance;
    }
}
