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

public class Bone {

    public static ItemStack getBone() {
        ItemStack bone = new ItemStack(Material.BONE);
        bone.setAmount(1);
        ItemMeta m = bone.getItemMeta();
        assert m != null;
        NamespacedKey key = new NamespacedKey(TheNoogitPlugin.plugin, TheNoogitPlugin.plugin.getDescription().getName());
        m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        m.setDisplayName(ChatColor.DARK_PURPLE + "Bone Breaker");
        bone.setItemMeta(m);
        return bone;
    }

    public static void trigger(Player admin, Player victim) {
        admin.sendMessage(ChatColor.GREEN + "You broke the bones of " + ChatColor.WHITE + victim.getName());
        victim.sendMessage(ChatColor.RED + "Your bones have been broken by " + ChatColor.WHITE + admin.getName());
        victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 600, 10, false));
        victim.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 600, 10, false));
    }
}
