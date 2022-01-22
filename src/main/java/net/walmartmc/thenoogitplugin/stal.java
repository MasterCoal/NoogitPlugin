package net.walmartmc.thenoogitplugin;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class stal {

    public static ItemStack getStal() {
        ItemStack stal = new ItemStack(Material.MUSIC_DISC_STAL);
        stal.setAmount(1);
        ItemMeta m = stal.getItemMeta();
        assert m != null;
        m.setDisplayName(ChatColor.DARK_PURPLE + "Stal Volume II");
        stal.setItemMeta(m);
        return stal;
    }

    public static void trigger(Player admin, Player victim) {
        admin.sendMessage(ChatColor.GREEN + "You stal'ed " + ChatColor.WHITE + victim.getName());
        victim.sendMessage(ChatColor.RED + "You have been stal'ed by " + ChatColor.WHITE + admin.getName());
        victim.playSound(victim.getLocation(), Sound.MUSIC_DISC_STAL, 100, 1);
        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                i++;
                if (i >= 50) {
                    cancel();
                }
                victim.spawnParticle(Particle.NOTE, new Location(victim.getWorld(), victim.getLocation().getX(), victim.getLocation().getY()+1, victim.getLocation().getZ()), 10);
            }
        }.runTaskTimerAsynchronously(TheNoogitPlugin.plugin, 0, 5);
    }
}
