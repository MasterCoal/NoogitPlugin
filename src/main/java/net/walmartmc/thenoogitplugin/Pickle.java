package net.walmartmc.thenoogitplugin;

import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class Pickle {

    public static ItemStack getPickle() {
        ItemStack pickle = new ItemStack(Material.SEA_PICKLE);
        pickle.setAmount(1);
        ItemMeta m = pickle.getItemMeta();
        assert m != null;
        NamespacedKey key = new NamespacedKey(TheNoogitPlugin.plugin, TheNoogitPlugin.plugin.getDescription().getName());
        m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        m.setDisplayName(ChatColor.DARK_PURPLE + "Cod Flare");
        pickle.setItemMeta(m);
        return pickle;
    }

    public static void trigger(Player admin, Location loc) {
        admin.sendMessage(ChatColor.GREEN + "Cod flare fired!");
        Location newLoc = loc;
        newLoc.setY(loc.getY()+1);
        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                i++;
                if (i >= 10) {
                    cancel();
                }
                loc.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()), 100);
                loc.getWorld().spawnParticle(Particle.ASH, new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()), 100);
            }
        }.runTaskTimerAsynchronously(TheNoogitPlugin.plugin, 0, 1);
        loc.getWorld().spawnEntity(newLoc, EntityType.COD);
        loc.getWorld().spawnEntity(newLoc, EntityType.COD);
        loc.getWorld().spawnEntity(newLoc, EntityType.COD);
        loc.getWorld().spawnEntity(newLoc, EntityType.COD);
        loc.getWorld().spawnEntity(newLoc, EntityType.COD);
        loc.getWorld().spawnEntity(newLoc, EntityType.COD);
        loc.getWorld().spawnEntity(newLoc, EntityType.COD);
        loc.getWorld().spawnEntity(newLoc, EntityType.COD);
        loc.getWorld().spawnEntity(newLoc, EntityType.COD);
        loc.getWorld().spawnEntity(newLoc, EntityType.COD);
        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                i++;
                if (i >= 10) {
                    cancel();
                }
                loc.getWorld().spawnParticle(Particle.CAMPFIRE_SIGNAL_SMOKE, new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()), 10);
                loc.getWorld().spawnParticle(Particle.ASH, new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()), 100);
            }
        }.runTaskTimerAsynchronously(TheNoogitPlugin.plugin, 0, 10);
    }
}
