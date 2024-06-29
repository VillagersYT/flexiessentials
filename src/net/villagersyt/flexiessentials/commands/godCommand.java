package net.villagersyt.flexiessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class godCommand implements CommandExecutor {
    private static Set<Player> godModePlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                toggleGodMode(player, sender);
            } else {
                sender.sendMessage("Correct usage : /god <player>");
            }
        } else {
            String playerName = args[0];
            Player targetPlayer = Bukkit.getPlayer(playerName);

            if (targetPlayer != null) {
                toggleGodMode(targetPlayer, sender);
            } else {
                sender.sendMessage("§cThe player " + playerName + " is not online.");
            }
        }
        return true;
    }

    private void toggleGodMode(Player player, CommandSender sender) {
        if (godModePlayers.contains(player)) {
            godModePlayers.remove(player);
            player.sendMessage("§eThe god mode has been disable.");
            if (!player.equals(sender)) {
                sender.sendMessage("§eThe god mode has been disable for " + player.getName() + ".");
            }
        } else {
            godModePlayers.add(player);
            player.sendMessage("§eThe god mode has been enable.");
            if (!player.equals(sender)) {
                sender.sendMessage("§eThe god mode has been enable for " + player.getName() + ".");
            }
        }
    }

    public static Set<Player> getGodModePlayers() {
        return godModePlayers;
    }
}