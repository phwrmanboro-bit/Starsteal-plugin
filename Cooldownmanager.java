package com.starsteal.cooldown;

import org.bukkit.entity.Player;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {

    // playerUUID -> (abilityName -> cooldownEndTime)
    private static final Map<UUID, Map<String, Long>> cooldowns = new HashMap<>();

    // cooldown check
    public static boolean isOnCooldown(Player player, String ability) {
        UUID uuid = player.getUniqueId();

        if (!cooldowns.containsKey(uuid)) return false;
        if (!cooldowns.get(uuid).containsKey(ability)) return false;

        long endTime = cooldowns.get(uuid).get(ability);
        return System.currentTimeMillis() < endTime;
    }

    // cooldown set
    public static void setCooldown(Player player, String ability, int seconds) {
        UUID uuid = player.getUniqueId();
        cooldowns.putIfAbsent(uuid, new HashMap<>());

        long endTime = System.currentTimeMillis() + (seconds * 1000L);
        cooldowns.get(uuid).put(ability, endTime);
    }

    // cooldown remaining
    public static int getRemaining(Player player, String ability) {
        if (!isOnCooldown(player, ability)) return 0;

        long endTime = cooldowns.get(player.getUniqueId()).get(ability);
        return (int) ((endTime - System.currentTimeMillis()) / 1000);
    }
}
