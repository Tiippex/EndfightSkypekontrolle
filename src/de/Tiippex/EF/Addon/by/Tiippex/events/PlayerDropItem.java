package de.Tiippex.EF.Addon.by.Tiippex.events;

import de.Tiippex.EF.Addon.by.Tiippex.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;


public class PlayerDropItem implements Listener {
    API api;
    @EventHandler
    public void onDrops(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        this.api = new API();
        if (this.api.isFrozen(player)) {
            e.setCancelled(true);
        }
    }
}
