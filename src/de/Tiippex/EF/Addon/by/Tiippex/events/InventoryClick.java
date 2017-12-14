package de.Tiippex.EF.Addon.by.Tiippex.events;

import de.Tiippex.EF.Addon.by.Tiippex.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


/**
 * Created by Maximilian on 23.02.2017.
 */
public class InventoryClick implements Listener {
    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = ((Player) e.getWhoClicked());
        if (Utils.frozen.contains(p.getName())) {
            e.setCancelled(true);
        }
    }
}