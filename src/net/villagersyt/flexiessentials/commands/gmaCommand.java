package net.villagersyt.flexiessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;

public class gmaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage("§eYou are now in adventure.");
            } else {
                sender.sendMessage("§cCorrect usage : /gma <player>");
            }
        } else {
            String playerName = args[0];
            Player targetPlayer = Bukkit.getPlayer(playerName);

            if (targetPlayer != null) {
                targetPlayer.setGameMode(GameMode.ADVENTURE);
                targetPlayer.sendMessage("§eYou are now in adventure.");
                sender.sendMessage("§e" + targetPlayer.getName() + " is now in adventure.");
            } else {
                sender.sendMessage("§cThe player " + playerName + " is not online.");
            }
        }
        return true;
    }
}
