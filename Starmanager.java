package com.starsteal;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class StarManager {

    public static ItemStack createFireStar() {
        return createStar("§cFire Star", "Shift+Right Click: Fire Beam",
                "Shift+Left Click: Fire Cage", "Shift+F: Fire Shuttle");
    }

    public static ItemStack createWaterStar() {
        return createStar("§bWater Star", "Shift+Right Click: Water Dragon",
                "Shift+Left Click: Water Shield", "Shift+F: Water Punch");
    }

    public static ItemStack createEarthStar() {
        return createStar("§aEarth Star", "Shift+Right Click: Earth Monster",
                "Shift+Left Click: Earth Wall", "Shift+F: Earth Poison");
    }

    public static ItemStack createAirStar() {
        return createStar("§fAir Star", "Shift+Right Click: Flight",
                "Shift+Left Click: Air Kick", "Shift+F: Levitation");
    }

    public static ItemStack createIceStar() {
        return createStar("§bIce Star", "Shift+Right Click: Freeze",
                "Shift+Left Click: Ice Jump", "Shift+F: Ice Holy");
    }

    public static ItemStack createThunderStar() {
        return createStar("§eThunder Star", "Shift+Right Click: Thunder Kill",
                "Shift+Left Click: Thunder Bolt", "Shift+F: Thunder Shock");
    }

    // Helper method to avoid repetition
    private static ItemStack createStar(String name, String ability1, String ability2, String ability3) {
        ItemStack star = new ItemStack(Material.NETHER_STAR, 1);
        ItemMeta meta = star.getItemMeta();
        meta.setDisplayName(name);
        ArrayList<String> lore = new ArrayList<>();
        lore.add("Abilities:");
        lore.add(ability1);
        lore.add(ability2);
        lore.add(ability3);
        meta.setLore(lore);
        star.setItemMeta(meta);
        return star;
    }
}
