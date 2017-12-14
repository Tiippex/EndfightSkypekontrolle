package de.Tiippex.EF.Addon.by.Tiippex.events;

import de.Tiippex.EF.Addon.by.Tiippex.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;

/**
 * Created by Maximilian on 24.02.2017.
 */
public class InventoryOpen implements Listener{
    @EventHandler
    public void onInvOpen (InventoryOpenEvent e) {
        Player p = ((Player) e.getPlayer());
        if (Utils.frozen.contains(p.getName())) {
            p.closeInventory();
            e.setCancelled(true);
        }
    }
}
