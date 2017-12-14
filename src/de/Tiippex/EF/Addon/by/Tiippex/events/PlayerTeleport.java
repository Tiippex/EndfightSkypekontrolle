package de.Tiippex.EF.Addon.by.Tiippex.events;

import de.Tiippex.EF.Addon.by.Tiippex.API;
import de.Tiippex.EF.Addon.by.Tiippex.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 * Created by Maximilian on 23.02.2017.
 */
public class PlayerTeleport implements Listener{
    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e) {
        Player p = e.getPlayer();
        if (Utils.frozen.contains(p.getName())) {

        e.setCancelled(true);
        }
    }
}
