package de.Tiippex.EF.Addon.by.Tiippex.events;

import de.Tiippex.EF.Addon.by.Tiippex.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by Maximilian on 27.02.2017.
 */
public class BlockEvent implements Listener{
    @EventHandler
    public void BlockBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (Utils.frozen.contains(p.getName())) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void BlockPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (Utils.frozen.contains(p.getName())) {
            e.setCancelled(true);
        }
    }
}
