package com.starsteal;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(args.length == 0) return false;

        if(args[0].equalsIgnoreCase("give")) {
            if(sender.hasPermission("starsteal.give") && args.length == 3){
                Player target = sender.getServer().getPlayer(args[1]);
                String star = args[2].toLowerCase();
                CraftingManager.giveStar(target, star);
            }
        } else if(args[0].equalsIgnoreCase("recipe")) {
            if(args.length == 2){
                String star = args[1].toLowerCase();
                CraftingManager.showRecipe((Player) sender, star);
            }
        }

        return true;
    }
}
