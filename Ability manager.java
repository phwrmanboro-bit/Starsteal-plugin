package com.starsteal;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class AbilityManager implements Listener {

    @EventHandler
    public void onUse(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand() == null) return;
        if (!p.getInventory().getItemInMainHand().hasItemMeta()) return;

        String name = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName();

        if (name.contains("Fire Star")) {
            fireAbilities(p, e);
        }
    }

    /* ================= FIRE STAR ================= */

    private void fireAbilities(Player p, PlayerInteractEvent e) {

        /* 🔥 FIRE BEAM (Shift + Right Click) */
        if (p.isSneaking() && e.getAction().toString().contains("RIGHT")) {

            if (CooldownManager.isOnCooldown(p, "fire_beam")) return;

            Location start = p.getEyeLocation();
            Vector dir = start.getDirection().normalize();

            for (int i = 1; i <= 25; i++) {
                Location point = start.clone().add(dir.clone().multiply(i));

                p.getWorld().spawnParticle(
                        Particle.FLAME,
                        point,
                        3,
                        0, 0, 0,
                        0
                );

                for (Entity ent : p.getWorld().getNearbyEntities(point, 1, 1, 1)) {
                    if (ent instanceof LivingEntity && ent != p) {
                        ((LivingEntity) ent).damage(10.0, p); // 5 hearts
                        ent.setFireTicks(100);
                        i = 25;
                        break;
                    }
                }
            }

            p.getWorld().playSound(p.getLocation(), Sound.ITEM_FIRECHARGE_USE, 1f, 1f);
            CooldownManager.startCooldown(p, "fire_beam", 10);
        }

        /* 🔥 FIRE CAGE (Shift + Left Click) */
        if (p.isSneaking() && e.getAction().toString().contains("LEFT")) {

            if (CooldownManager.isOnCooldown(p, "fire_cage")) return;

            for (Entity ent : p.getNearbyEntities(10, 10, 10)) {
                if (ent instanceof LivingEntity && ent != p) {

                    Location l = ent.getLocation();

                    for (int x = -1; x <= 1; x++) {
                        for (int z = -1; z <= 1; z++) {
                            l.clone().add(x, 0, z).getBlock().setType(Material.FIRE);
                            l.clone().add(x, 2, z).getBlock().setType(Material.FIRE);
                        }
                    }
                }
            }

            p.getWorld().playSound(p.getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1f, 0.7f);
            CooldownManager.startCooldown(p, "fire_cage", 10);
        }
    }
}
