package com.starsteal;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CraftingManager {

    private static boolean fireStarCrafted = false;
    private static boolean waterStarCrafted = false;
    private static boolean earthStarCrafted = false;
    private static boolean airStarCrafted = false;
    private static boolean iceStarCrafted = false;
    private static boolean thunderStarCrafted = false;

    public static void giveStar(Player player, String star){
        switch(star){
            case "fire":
                if(fireStarCrafted){
                    player.sendMessage("Fire Star already crafted!");
                    return;
                }
                fireStarCrafted = true;
                player.getInventory().addItem(StarManager.createFireStar());
                break;

            case "water":
                if(waterStarCrafted){
                    player.sendMessage("Water Star already crafted!");
                    return;
                }
                waterStarCrafted = true;
                player.getInventory().addItem(StarManager.createWaterStar());
                break;

            case "earth":
                if(earthStarCrafted){
                    player.sendMessage("Earth Star already crafted!");
                    return;
                }
                earthStarCrafted = true;
                player.getInventory().addItem(StarManager.createEarthStar());
                break;

            case "air":
                if(airStarCrafted){
                    player.sendMessage("Air Star already crafted!");
                    return;
                }
                airStarCrafted = true;
                player.getInventory().addItem(StarManager.createAirStar());
                break;

            case "ice":
                if(iceStarCrafted){
                    player.sendMessage("Ice Star already crafted!");
                    return;
                }
                iceStarCrafted = true;
                player.getInventory().addItem(StarManager.createIceStar());
                break;

            case "thunder":
                if(thunderStarCrafted){
                    player.sendMessage("Thunder Star already crafted!");
                    return;
                }
                thunderStarCrafted = true;
                player.getInventory().addItem(StarManager.createThunderStar());
                break;
        }
    }

    public static void showRecipe(Player player, String star){
        switch(star){
            case "fire":
                player.sendMessage("Fire Star Recipe: Diamonds + Lava + Nether Star");
                break;
            case "water":
                player.sendMessage("Water Star Recipe: Diamonds + Water Buckets + Nether Star");
                break;
            case "earth":
                player.sendMessage("Earth Star Recipe: Diamonds + Redstone + Nether Star");
                break;
            case "air":
                player.sendMessage("Air Star Recipe: Diamonds + Iron + Nether Star");
                break;
            case "ice":
                player.sendMessage("Ice Star Recipe: Diamonds + Ice + Nether Star");
                break;
            case "thunder":
                player.sendMessage("Thunder Star Recipe: Diamonds + Gold + Netherite + Nether Star");
                break;
        }
    }
}
