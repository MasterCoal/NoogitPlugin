package net.walmartmc.thenoogitplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WifeBeater {

    public static ItemStack getWifeBeater() {
        ItemStack wifebeater = new ItemStack(Material.STICK);
        wifebeater.setAmount(1);
        ItemMeta m = wifebeater.getItemMeta();
        assert m != null;
        NamespacedKey key = new NamespacedKey(TheNoogitPlugin.plugin, TheNoogitPlugin.plugin.getDescription().getName());
        m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        m.setDisplayName(ChatColor.DARK_PURPLE + "Wife Beater");
        wifebeater.setItemMeta(m);
        return wifebeater;
    }

    public static void trigger(Player admin, Entity victim) {
        if (victim instanceof Player) {
            if (!victim.getName().equals("MasterCoal")) {
                ((Player) victim).setHealth(0);
            } else {
                admin.setHealth(0);
            }
        } else {
            LivingEntity le = (LivingEntity) victim;
            assert le != null;
            le.setHealth(0);
        }
    }
}