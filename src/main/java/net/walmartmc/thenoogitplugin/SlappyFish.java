package net.walmartmc.thenoogitplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SlappyFish {

    public static ItemStack getSlappyFish() {
        ItemStack fish = new ItemStack(Material.COD);
        fish.setAmount(1);
        ItemMeta m = fish.getItemMeta();
        assert m != null;
        NamespacedKey key = new NamespacedKey(TheNoogitPlugin.plugin, TheNoogitPlugin.plugin.getDescription().getName());
        m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        m.setDisplayName(ChatColor.DARK_PURPLE + "Slappy Fish");
        fish.setItemMeta(m);
        return fish;
    }

    public static void trigger(Player admin, Player victim) {
        victim.setVelocity(admin.getLocation().getDirection().multiply(10));
    }
}