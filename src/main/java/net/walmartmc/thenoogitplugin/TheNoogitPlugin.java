package net.walmartmc.thenoogitplugin;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class TheNoogitPlugin extends JavaPlugin implements CommandExecutor {

    public Events events;

    public static Inventory inv;

    public static TheNoogitPlugin plugin;

    public TheNoogitPlugin() {
        plugin = this;
    }

    public static TheNoogitPlugin getInstance() {
        return plugin;
    }

    public static void createinv(Player target) {
        inv = Bukkit.createInventory(null, 27,  ChatColor.BLACK + "         Noogit's Panel");

        inv.setItem(0, Feather.getFeather());
        inv.setItem(1, Bone.getBone());
        inv.setItem(2, Pickle.getPickle());
        inv.setItem(3, WifeBeater.getWifeBeater());
        inv.setItem(4, FireBall.getFireball());
        inv.setItem(5, Cleaner.getCleaner());
        inv.setItem(6, FishingRod.getFishingRod());
        inv.setItem(7, SlappyFish.getSlappyFish());
        inv.setItem(8, stal.getStal());

        target.openInventory(inv);
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage( ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "TheNoogitPlugin" + ChatColor.DARK_GRAY + "]" + ChatColor.WHITE + " starting up...");
        Objects.requireNonNull(Bukkit.getPluginCommand("noogit")).setExecutor(this);
        events = new Events(this);
        Bukkit.getConsoleSender().sendMessage( ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "TheNoogitPlugin" + ChatColor.DARK_GRAY + "]" + ChatColor.GREEN + " finished!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("noogit")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("walmartmc.admin")) {
                    if (args.length == 0) {
                        createinv(player);
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
