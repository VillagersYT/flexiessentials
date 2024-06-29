package net.villagersyt.flexiessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                toggleFly(player, sender);
            } else {
                sender.sendMessage("§cCorrect usage : /fly <player>");
            }
        } else {
            String playerName = args[0];
            Player targetPlayer = Bukkit.getPlayer(playerName);

            if (targetPlayer != null) {
                toggleFly(targetPlayer, sender);
            } else {
                sender.sendMessage("§cThe player " + playerName + " is not online.");
            }
        }
        return true;
    }

    private void toggleFly(Player player, CommandSender sender) {
        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage("§eThe fly has been disable.");
            if (!player.equals(sender)) {
                sender.sendMessage("§eThe fly has been disable for " + player.getName() + ".");
            }
        } else {
            player.setAllowFlight(true);
            player.sendMessage("§eThe fly has been enable.");
            if (!player.equals(sender)) {
                sender.sendMessage("§eThe fly has been enable for " + player.getName() + ".");
            }
        }
    }
}