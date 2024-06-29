package net.villagersyt.flexiessentials.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.Player;
import java.util.Set;

public class GodModeListener implements Listener {
    private final Set<Player> godModePlayers;

    public GodModeListener(Set<Player> godModePlayers) {
        this.godModePlayers = godModePlayers;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (godModePlayers.contains(player)) {
                event.setCancelled(true);
            }
        }
    }
}