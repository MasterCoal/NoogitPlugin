package net.walmartmc.thenoogitplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Feather {

    public static ItemStack getFeather() {
        ItemStack feather = new ItemStack(Material.FEATHER);
        feather.setAmount(1);
        ItemMeta m = feather.getItemMeta();
        assert m != null;
        NamespacedKey key = new NamespacedKey(TheNoogitPlugin.plugin, TheNoogitPlugin.plugin.getDescription().getName());
        m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        m.setDisplayName(ChatColor.DARK_PURPLE + "Feather of Flight");
        feather.setItemMeta(m);
        return feather;
    }

    public static void trigger(Player admin, Player victim) {
        admin.sendMessage(ChatColor.GREEN + "You tickled " + ChatColor.WHITE + victim.getName());
        victim.sendMessage(ChatColor.RED + "You have been tickled by " + ChatColor.WHITE + admin.getName());
        victim.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 600, 1, false));

    }
}
