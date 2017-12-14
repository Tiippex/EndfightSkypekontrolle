package de.Tiippex.EF.Addon.by.Tiippex.commands;


import de.Tiippex.EF.Addon.by.Tiippex.Main;
import de.Tiippex.EF.Addon.by.Tiippex.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static de.Tiippex.EF.Addon.by.Tiippex.TitleAPI.sendTitle;

public class SkypekontrolleCMD implements CommandExecutor{

    public String kontrolleur;

    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {

        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        kontrolleur = cs.getName();

        if (cmd.getName().equalsIgnoreCase("skypekontrolle")) {
            if (!cs.hasPermission("ef.skypekontrolle")) {
                cs.sendMessage("§5§lClaimMC §8§l| §cDu hast nicht genug Rechte.");
                return true;
            }
        }

        if (!(cs instanceof Player)) {
            cs.sendMessage("§5§lClaimMC §8§l| §cDu bist kein Spieler.");
            return false;
        }

        if (args.length == 0) {
            cs.sendMessage("§5§lClaimMC §8§l| §7Bitte benutze: /skypkontrolle <Spieler>");
            return true;
        }

        if (args.length == 1) {
            Player t = Main.getInstance().getServer().getPlayer(args[0]);
            if (t == null) {
                cs.sendMessage("§5§lClaimMC §8§l| §7Der Spieler ist nicht Online.");
            }



            if (!Utils.frozen.contains(t.getName())) {
            cs.sendMessage("§5§lClaimMC §8§l| §bSkypeKontrolle gestartet.");
            Main.getInstance().logToFile("[Started] " + format.format(now) + " --> " + cs.getName() + " --> " + t.getName());

                Utils.scheduler.put(t.getName(), Bukkit.getScheduler().runTaskTimer(Main.getInstance(), () -> {
                    if(Utils.frozen.contains(t.getName())) {
                        t.sendMessage("§6§m-----------------------------------------------");
                        t.sendMessage("§8███████");
                        t.sendMessage("§8█§6██§c█§6██§8█   §cDu wirkst nicht ganz Legit!");
                        t.sendMessage("§8█§6██§c█§6██§8█");
                        t.sendMessage("§8█§6██§c█§6██§8█   §cBitte schick deinen Skype-Namen");
                        t.sendMessage("§8█§6█████§8█   §cper /msg an " + cs.getName() + ".");
                        t.sendMessage("§8█§6██§c█§6██§8█   §4Dafür hast du 5 Minuten Zeit.");
                        t.sendMessage("§8███████");
                        t.sendMessage("§6§m-----------------------------------------------");
                        sendTitle(t.getPlayer(), "§4§k...§r §cSkype-Kontrolle §4§k...", "§cAusloggen = Ban", 90, 90, 90);
                    }
                }, 0*20, 15*20));
                //t.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 255, false, false));
                t.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, Integer.MAX_VALUE, 150, false, false));
                t.setWalkSpeed(0);
                t.setFlySpeed(0);
                t.playSound(t.getLocation(), Sound.GHAST_SCREAM, 1.0F, 1.0F);
                Utils.frozen.add(t.getName());
                return true;
            }
            //t.removePotionEffect(PotionEffectType.SLOW);
            t.removePotionEffect(PotionEffectType.JUMP);
            t.setWalkSpeed(0.2F);
            t.setFlySpeed(0.2F);
            Utils.frozen.remove(t.getName());
            Utils.scheduler.get(t.getName()).cancel();
            Utils.scheduler.remove(t.getName());
            Main.getInstance().logToFile("[Stopped] " + format.format(now) + " --> " + cs.getName() + " --> " + t.getName());
            cs.sendMessage("§5§lClaimMC §8§l| §bSkypeKontrolle beendet.");
            return true;
        }

        return false;
    }

}
