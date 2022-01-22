package net.walmartmc.thenoogitplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

public class Cleaner {

    public static ItemStack getCleaner() {
        ItemStack cleaner = new ItemStack(Material.BLAZE_ROD);
        cleaner.setAmount(1);
        ItemMeta m = cleaner.getItemMeta();
        assert m != null;
        m.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        m.setDisplayName(ChatColor.DARK_PURPLE + "Cleaner");
        cleaner.setItemMeta(m);
        return cleaner;
    }

    public static void trigger(Player admin, Player victim) {
        admin.sendMessage(ChatColor.GREEN + "You've cleaned " + ChatColor.WHITE + victim.getName());
        victim.sendMessage(ChatColor.GREEN + "You've been cleaned by " + ChatColor.WHITE + admin.getName());
        for (PotionEffect effect : victim.getActivePotionEffects())
            victim.removePotionEffect(effect.getType());
        victim.stopSound(Sound.MUSIC_DISC_STAL);
        victim.setHealth(20);
    }
}
