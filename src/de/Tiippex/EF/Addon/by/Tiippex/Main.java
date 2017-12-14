package de.Tiippex.EF.Addon.by.Tiippex;


import de.Tiippex.EF.Addon.by.Tiippex.commands.SkypekontrolleCMD;
import de.Tiippex.EF.Addon.by.Tiippex.events.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Main extends JavaPlugin{
    private static Main instance;
    public Location spawn = null;
    @Override
    public void onDisable() {


        Bukkit.getConsoleSender().sendMessage("§5Endfight Addon by Tiippex §8» §ddeactivated");
    }


    @Override
    public void onEnable() {
        instance = this;

        this.getCommand("skypekontrolle").setExecutor(new SkypekontrolleCMD());


        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EntityDamageByEntity(), this);
        pm.registerEvents(new PlayerDropItem(), this);
        pm.registerEvents(new PlayerQuit(), this);
        pm.registerEvents(new PlayerTeleport(), this);
        pm.registerEvents(new InventoryClick(), this);
        pm.registerEvents(new InventoryOpen(), this);
        pm.registerEvents(new PlayerInteract(), this);
        pm.registerEvents(new PlayerPickup(), this);

        Bukkit.getConsoleSender().sendMessage("§5Endfight Addon by Tiippex §8» §dactivated");
    }
    public static Main getInstance() {
        return instance;
    }

    public void logToFile(String message) {
        try {
            File dataFolder = getDataFolder();
            if(!dataFolder.exists())
            {
                dataFolder.mkdir();
            }

            File saveTo = new File(getDataFolder(), "skypekontrolle.log");
            if (!saveTo.exists())
            {
                saveTo.createNewFile();
            }


            FileWriter fw = new FileWriter(saveTo, true);

            PrintWriter pw = new PrintWriter(fw);

            pw.println(message);

            pw.flush();

            pw.close();

        } catch (IOException e)
        {

            e.printStackTrace();

        }

    }

}
