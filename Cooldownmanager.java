package com.starsteal;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class CooldownManager {

    // Map<Player UUID, Map<Ability Name, EndTime>>
    private static final HashMap<UUID, HashMap<String, Long>> cooldowns = new HashMap<>();

    // Start cooldown for a player ability
    public static void startCooldown(Player player, String ability, int seconds) {
        cooldowns.putIfAbsent(player.getUniqueId(), new HashMap<>());
        cooldowns.get(player.getUniqueId()).put(ability, System.currentTimeMillis() + (seconds * 1000));
    }

    // Check if ability is on cooldown
    public static boolean isOnCooldown(Player player, String ability) {
        if (!cooldowns.containsKey(player.getUniqueId())) return false;
        if (!cooldowns.get(player.getUniqueId()).containsKey(ability)) return false;

        long timeLeft = cooldowns.get(player.getUniqueId()).get(ability) - System.currentTimeMillis();
        if (timeLeft > 0) {
            player.sendMessage("Ability on cooldown: " + (timeLeft / 1000) + "s left");
            return true;
        }
        return false;
    }

    // Remove cooldown manually (optional)
    public static void removeCooldown(Player player, String ability) {
        if(cooldowns.containsKey(player.getUniqueId()))
            cooldowns.get(player.getUniqueId()).remove(ability);
    }
}
