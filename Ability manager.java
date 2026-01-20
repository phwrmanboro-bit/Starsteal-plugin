package com.starsteal.ability;

import com.starsteal.cooldown.CooldownManager;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.List;

public class AbilityManager {

    /* ================= FIRE STAR ================= */

    public void fireBeam(Player player) {
        if (CooldownManager.isOnCooldown(player, "FIRE_BEAM")) return;
        CooldownManager.setCooldown(player, "FIRE_BEAM", 10);

        player.getWorld().rayTraceEntities(
                player.getEyeLocation(),
                player.getLocation().getDirection(),
                30,
                entity -> entity instanceof LivingEntity && entity != player
        ).getHitEntity();

        player.launchProjectile(SmallFireball.class);
    }

    public void fireCage(Player player) {
        if (CooldownManager.isOnCooldown(player, "FIRE_CAGE")) return;
        CooldownManager.setCooldown(player, "FIRE_CAGE", 15);

        for (Entity e : player.getNearbyEntities(10, 10, 10)) {
            if (e instanceof LivingEntity le) {
                le.setFireTicks(100);
            }
        }
    }

    public void fireShuttle(Player player) {
        if (CooldownManager.isOnCooldown(player, "FIRE_SHUTTLE")) return;
        CooldownManager.setCooldown(player, "FIRE_SHUTTLE", 20);

        for (Entity e : player.getNearbyEntities(15, 15, 15)) {
            e.setVelocity(new org.bukkit.util.Vector(0, 2.5, 0));
        }
    }

    /* ================= WATER STAR ================= */

    public void waterDragon(Player player) {
        if (CooldownManager.isOnCooldown(player, "WATER_DRAGON")) return;
        CooldownManager.setCooldown(player, "WATER_DRAGON", 20);

        for (Entity e : player.getNearbyEntities(20, 20, 20)) {
            e.setVelocity(player.getLocation().getDirection().multiply(2));
        }
    }

    public void waterShield(Player player) {
        if (CooldownManager.isOnCooldown(player, "WATER_SHIELD")) return;
        CooldownManager.setCooldown(player, "WATER_SHIELD", 20);

        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 400, 1));
    }

    public void waterPunch(Player player) {
        if (CooldownManager.isOnCooldown(player, "WATER_PUNCH")) return;
        CooldownManager.setCooldown(player, "WATER_PUNCH", 10);

        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 9));
    }

    /* ================= EARTH STAR ================= */

    public void earthMonster(Player player) {
        if (CooldownManager.isOnCooldown(player, "EARTH_MONSTER")) return;
        CooldownManager.setCooldown(player, "EARTH_MONSTER", 30);

        World w = player.getWorld();
        for (int i = 0; i < 10; i++) {
            w.spawnEntity(player.getLocation(), EntityType.IRON_GOLEM);
        }
    }

    public void earthWall(Player player) {
        if (CooldownManager.isOnCooldown(player, "EARTH_WALL")) return;
        CooldownManager.setCooldown(player, "EARTH_WALL", 15);

        Location loc = player.getLocation().add(player.getLocation().getDirection().multiply(3));
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                loc.clone().add(x, y, 0).getBlock().setType(Material.BAMBOO_BLOCK);
            }
        }
    }

    public void earthPoison(Player player) {
        if (CooldownManager.isOnCooldown(player, "EARTH_POISON")) return;
        CooldownManager.setCooldown(player, "EARTH_POISON", 20);

        for (Entity e : player.getNearbyEntities(10, 10, 10)) {
            if (e instanceof LivingEntity le) {
                le.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 1, 4));
            }
        }
    }

    /* ================= AIR STAR ================= */

    public void airFlight(Player player) {
        if (CooldownManager.isOnCooldown(player, "AIR_FLIGHT")) return;
        CooldownManager.setCooldown(player, "AIR_FLIGHT", 300);

        player.setAllowFlight(true);
    }

    public void airKick(Player player) {
        if (CooldownManager.isOnCooldown(player, "AIR_KICK")) return;
        CooldownManager.setCooldown(player, "AIR_KICK", 15);

        for (Entity e : player.getNearbyEntities(30, 30, 30)) {
            e.setVelocity(player.getLocation().getDirection().multiply(3));
        }
    }

    public void airLevitation(Player player) {
        if (CooldownManager.isOnCooldown(player, "AIR_LEVITATION")) return;
        CooldownManager.setCooldown(player, "AIR_LEVITATION", 20);

        for (Entity e : player.getNearbyEntities(20, 20, 20)) {
            if (e instanceof LivingEntity le) {
                le.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 200, 1));
            }
        }
    }

    /* ================= ICE STAR ================= */

    public void iceFreeze(Player player) {
        if (CooldownManager.isOnCooldown(player, "ICE_FREEZE")) return;
        CooldownManager.setCooldown(player, "ICE_FREEZE", 15);

        for (Entity e : player.getNearbyEntities(20, 20, 20)) {
            if (e instanceof LivingEntity le && e != player) {
                le.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 10));
            }
        }
    }

    public void iceJump(Player player) {
        if (CooldownManager.isOnCooldown(player, "ICE_JUMP")) return;
        CooldownManager.setCooldown(player, "ICE_JUMP", 30);

        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 600, 5));
    }

    public void iceHoly(Player player) {
        if (CooldownManager.isOnCooldown(player, "ICE_HOLY")) return;
        CooldownManager.setCooldown(player, "ICE_HOLY", 25);

        World w = player.getWorld();
        Location l = player.getLocation();
        for (int i = 0; i < 30; i++) {
            w.spawnParticle(Particle.SNOWFLAKE, l, 50, 10, 10, 10);
        }
    }

    /* ================= THUNDER STAR ================= */

    public void thunderKill(Player player) {
        if (CooldownManager.isOnCooldown(player, "THUNDER_KILL")) return;
        CooldownManager.setCooldown(player, "THUNDER_KILL", 60);

        for (Entity e : player.getNearbyEntities(10, 10, 10)) {
            if (e instanceof LivingEntity le && e != player) {
                le.damage(1000);
                player.getWorld().strikeLightningEffect(le.getLocation());
            }
        }
    }

    public void thunderBolt(Player player) {
        if (CooldownManager.isOnCooldown(player, "THUNDER_BOLT")) return;
        CooldownManager.setCooldown(player, "THUNDER_BOLT", 40);

        for (Entity e : player.getNearbyEntities(20, 20, 20)) {
            player.getWorld().strikeLightning(e.getLocation());
        }
    }

    public void thunderShock(Player player) {
        if (CooldownManager.isOnCooldown(player, "THUNDER_SHOCK")) return;
        CooldownManager.setCooldown(player, "THUNDER_SHOCK", 20);

        for (Entity e : player.getNearbyEntities(20, 20, 20)) {
            if (e instanceof LivingEntity le) {
                le.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 1));
            }
        }
    }
                    }
