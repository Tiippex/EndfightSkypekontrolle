package de.Tiippex.EF.Addon.by.Tiippex.events;

import de.Tiippex.EF.Addon.by.Tiippex.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by Maximilian on 25.02.2017.
 */
public class PlayerInteract implements Listener{
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (Utils.frozen.contains(p.getName())) {
            e.setCancelled(true);
        }
    }
}
