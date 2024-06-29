package net.villagersyt.flexiessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class healCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                healPlayer(player, sender);
            } else {
                sender.sendMessage("§cCorrect usage : /heal <player>");
            }
        } else {
            String playerName = args[0];
            Player targetPlayer = Bukkit.getPlayer(playerName);

            if (targetPlayer != null) {
                healPlayer(targetPlayer, sender);
            } else {
                sender.sendMessage("§cThe player " + playerName + " is not online.");
            }
        }
        return true;
    }

    private void healPlayer(Player player, CommandSender sender) {
        player.setHealth(player.getMaxHealth());
        player.setFoodLevel(20);
        player.setSaturation(20.0f);
        player.sendMessage("§eYou have been healed.");
        if (!player.equals(sender)) {
            sender.sendMessage("§eThe player " + player.getName() + " has been healed.");
        }
    }
}