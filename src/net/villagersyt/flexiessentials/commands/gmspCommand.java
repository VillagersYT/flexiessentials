package net.villagersyt.flexiessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.GameMode;

public class gmspCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage("§eYou are now in spectator.");
            } else {
                sender.sendMessage("§cCorrect usage : /gmsp <player>");
            }
        } else {
            String playerName = args[0];
            Player targetPlayer = Bukkit.getPlayer(playerName);

            if (targetPlayer != null) {
                targetPlayer.setGameMode(GameMode.SPECTATOR);
                targetPlayer.sendMessage("§eYou are now in spectator.");
                sender.sendMessage("§e" + targetPlayer.getName() + " is now in spectator.");
            } else {
                sender.sendMessage("§cThe player " + playerName + " is not online.");
            }
        }
        return true;
    }
}
