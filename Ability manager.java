package com.starsteal;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerInteractEvent;

public class AbilityManager implements Listener {

    @EventHandler
    public void onUse(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand() == null) return;

        String name = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName();

        if (name.contains("Fire Star")) {
            fireAbilities(p, e);
        }

        if (name.contains("Water Star")) {
            waterAbilities(p, e);
        }
    }

    private void fireAbilities(Player p, PlayerInteractEvent e) {

        if (p.isSneaking() && e.getAction().toString().contains("RIGHT")) {

            if (CooldownManager.isOnCooldown(p, "fire_beam")) return;
            p.getWorld().strikeLightningEffect(p.getTargetBlock(null, 20).getLocation());
            CooldownManager.startCooldown(p, "fire_beam", 10);
        }

        if (p.isSneaking() && e.getAction().toString().contains("LEFT")) {

            if (CooldownManager.isOnCooldown(p, "fire_cage")) return;

            p.getNearbyEntities(10,10,10).forEach(ent -> {
                ent.setFireTicks(100);
            });

            CooldownManager.startCooldown(p, "fire_cage", 10);
        }
    }

    private void waterAbilities(Player p, PlayerInteractEvent e) {

        if (p.isSneaking() && e.getAction().toString().contains("RIGHT")) {

            if (CooldownManager.isOnCooldown(p, "water_dragon")) return;

            p.getWorld().spawnParticle(Particle.WATER_SPLASH, p.getLocation(), 200);
            CooldownManager.startCooldown(p, "water_dragon", 20);
        }
    }
}
