package de.Tiippex.EF.Addon.by.Tiippex.events;

import de.Tiippex.EF.Addon.by.Tiippex.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

/**
 * Created by Maximilian on 23.02.2017.
 */
public class EntityDamageByEntity implements Listener {


    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (Utils.frozen.contains(p.getName())) {
                e.setCancelled(true);
            }
            Utils.frozen.forEach(s -> {
                if(e.getDamager().getName().equalsIgnoreCase(s))  {
                    e.setCancelled(true);
                }
            });

        }
    }
    @EventHandler
    public void onEntityDamage(EntityDamageEvent e){
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (Utils.frozen.contains(p.getName())) {
                e.setCancelled(true);
            }
        }
    }

}