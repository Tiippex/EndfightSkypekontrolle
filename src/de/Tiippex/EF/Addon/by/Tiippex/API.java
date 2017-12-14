package de.Tiippex.EF.Addon.by.Tiippex;


import org.bukkit.entity.Player;

public class API {

    public boolean isFrozen(Player p) {
        return Utils.frozen.contains(p.getName());
    }


}