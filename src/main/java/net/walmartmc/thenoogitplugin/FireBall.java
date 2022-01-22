package net.walmartmc.thenoogitplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FireBall {

    public static ItemStack getFireball() {
        ItemStack fireball = new ItemStack(Material.FIRE_CHARGE);
        fireball.setAmount(1);
        ItemMeta m = fireball.getItemMeta();
        assert m != null;
        NamespacedKey key = new NamespacedKey(TheNoogitPlugin.plugin, TheNoogitPlugin.plugin.getDescription().getName());
        m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        m.setDisplayName(ChatColor.DARK_PURPLE + "Fireball");
        fireball.setItemMeta(m);
        return fireball;
    }

    public static void trigger(Player admin) {
        Fireball fireball = admin.launchProjectile(Fireball.class);
        fireball.setVelocity(fireball.getVelocity().multiply(20));
        fireball.setIsIncendiary(false);
        fireball.setYield(0f);
    }
}
