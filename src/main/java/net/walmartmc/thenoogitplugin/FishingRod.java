package net.walmartmc.thenoogitplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class FishingRod {

    public static ItemStack getFishingRod() {
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        rod.setAmount(1);
        ItemMeta m = rod.getItemMeta();
        assert m != null;
        NamespacedKey key = new NamespacedKey(TheNoogitPlugin.plugin, TheNoogitPlugin.plugin.getDescription().getName());
        m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        m.setDisplayName(ChatColor.DARK_PURPLE + "Noogit's Rod");
        rod.setItemMeta(m);
        return rod;
    }

    public static void trigger(Player admin, Entity victim) {
        if (victim instanceof Player) {
            admin.sendMessage(ChatColor.GREEN + "You've flung " + ChatColor.WHITE + victim.getName());
            victim.sendMessage(ChatColor.RED + "You've been flung by " + ChatColor.WHITE + admin.getName());
        }
        if (victim != null) {
            victim.setVelocity(new Vector(0, 5, 0));
        }
    }
}