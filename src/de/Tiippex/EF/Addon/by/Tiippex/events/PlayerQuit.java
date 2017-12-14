package de.Tiippex.EF.Addon.by.Tiippex.events;

import de.Tiippex.EF.Addon.by.Tiippex.API;
import de.Tiippex.EF.Addon.by.Tiippex.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;


public class PlayerQuit implements Listener{
    API api;

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        this.api = new API();
        if (this.api.isFrozen(p)) {
            Utils.frozen.remove(p.getName());
                    Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "ban " + p.getName() + " 2");
                    //p.removePotionEffect(PotionEffectType.SLOW);
                    p.removePotionEffect(PotionEffectType.JUMP);
                    p.setWalkSpeed(0.2F);
                    p.setFlySpeed(0.2F);
            return;
        }
    }
}
