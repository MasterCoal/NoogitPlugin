package net.walmartmc.thenoogitplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Events implements Listener {

    public Events(TheNoogitPlugin main) {
        TheNoogitPlugin.getPlugin(TheNoogitPlugin.class).getServer().getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    public void onDamage(PlayerItemDamageEvent e) {
        ItemStack item = e.getItem();
        if (item.getType().equals(Material.FISHING_ROD) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Noogit's Rod")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getInventory().equals(TheNoogitPlugin.inv)) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);
                ItemStack item = e.getCurrentItem();
                if (item.getType().equals(Material.FEATHER) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Feather of Flight")) {
                    p.getInventory().addItem(Feather.getFeather());
                }
                if (item.getType().equals(Material.BONE) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Bone Breaker")) {
                    p.getInventory().addItem(Bone.getBone());
                }
                if (item.getType().equals(Material.STICK) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Wife Beater")) {
                    p.getInventory().addItem(WifeBeater.getWifeBeater());
                }
                if (item.getType().equals(Material.BLAZE_ROD) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Cleaner")) {
                    p.getInventory().addItem(Cleaner.getCleaner());
                }
                if (item.getType().equals(Material.COD) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Slappy Fish")) {
                    p.getInventory().addItem(SlappyFish.getSlappyFish());
                }
                if (item.getType().equals(Material.FIRE_CHARGE) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Fireball")) {
                    p.getInventory().addItem(FireBall.getFireball());
                }
                if (item.getType().equals(Material.FISHING_ROD) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Noogit's Rod")) {
                    p.getInventory().addItem(FishingRod.getFishingRod());
                }
                if (item.getType().equals(Material.SEA_PICKLE) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Cod Flare")) {
                    p.getInventory().addItem(Pickle.getPickle());
                }
                if (item.getType().equals(Material.MUSIC_DISC_STAL) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Stal Volume II")) {
                    p.getInventory().addItem(stal.getStal());
                }
            }
        }
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        Entity entity;
        entity = e.getDamager();
        if (entity instanceof Player) {
            Player p = (Player) entity;
            ItemStack item = p.getInventory().getItemInMainHand();
            entity = e.getEntity();
            if (entity instanceof Player) {
                Player v = (Player) entity;
                if (item.getType().equals(Material.FEATHER) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Feather of Flight")) {
                    if (p.hasPermission("walmartmc.admin")) {
                        Feather.trigger(p, v);
                    } else {
                        p.sendMessage(ChatColor.RED + "You arent supposed to have this...");
                        e.setCancelled(true);
                    }
                }
                if (item.getType().equals(Material.BONE) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Bone Breaker")) {
                    if (p.hasPermission("walmartmc.admin")) {
                        Bone.trigger(p, v);
                    } else {
                        p.sendMessage(ChatColor.RED + "You arent supposed to have this...");
                        e.setCancelled(true);
                    }
                }
                if (item.getType().equals(Material.STICK) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Wife Beater")) {
                    if (p.hasPermission("walmartmc.admin")) {
                        WifeBeater.trigger(p, v);
                    } else {
                        p.sendMessage(ChatColor.RED + "You arent supposed to have this...");
                        e.setCancelled(true);
                    }
                }
                if (item.getType().equals(Material.BLAZE_ROD) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Cleaner")) {
                    if (p.hasPermission("walmartmc.admin")) {
                        Cleaner.trigger(p, v);
                    } else {
                        p.sendMessage(ChatColor.RED + "You arent supposed to have this...");
                        e.setCancelled(true);
                    }
                }
                if (item.getType().equals(Material.COD) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Slappy Fish")) {
                    if (p.hasPermission("walmartmc.admin")) {
                        SlappyFish.trigger(p, v);
                    } else {
                        p.sendMessage(ChatColor.RED + "You arent supposed to have this...");
                        e.setCancelled(true);
                    }
                }
                if (item.getType().equals(Material.MUSIC_DISC_STAL) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Stal Volume II")) {
                    if (p.hasPermission("walmartmc.admin")) {
                        stal.trigger(p, v);
                    } else {
                        p.sendMessage(ChatColor.RED + "You arent supposed to have this...");
                        e.setCancelled(true);
                    }
                }

            } else {
                if (item.getType().equals(Material.STICK) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Wife Beater")) {
                    if (p.hasPermission("walmartmc.admin")) {
                        WifeBeater.trigger(p, entity);
                    } else {
                        p.sendMessage(ChatColor.RED + "You arent supposed to have this...");
                        e.setCancelled(true);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onFishingRod(PlayerFishEvent e) {
        Player p = e.getPlayer();
        Entity entity = e.getCaught();
        ItemStack item = p.getInventory().getItemInMainHand();
        if (item.getType().equals(Material.FISHING_ROD) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Noogit's Rod")) {
            if (p.hasPermission("walmartmc.admin")) {
                assert entity != null;
                FishingRod.trigger(p, entity);
            } else {
                p.sendMessage(ChatColor.RED + "You arent supposed to have this...");
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onPlace(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType() != Material.AIR) {
            if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                ItemStack item = p.getInventory().getItemInMainHand();
                if (item.getType().equals(Material.SEA_PICKLE) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Cod Flare")) {
                    if (p.hasPermission("walmartmc.admin")) {
                        Pickle.trigger(p, Objects.requireNonNull(e.getClickedBlock()).getLocation());
                        e.setCancelled(true);
                        item.setAmount(item.getAmount() - 1);

                        if (item.getAmount() < 1) {
                            item = null;
                        }

                        p.getInventory().setItemInMainHand(item);
                    } else {
                        p.sendMessage(ChatColor.RED + "You arent supposed to have this...");
                        e.setCancelled(true);
                    }
                }
            }
        }
    }
    @EventHandler
    public void onFireballRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType() != Material.AIR) {
            if ((e.getAction().equals(Action.RIGHT_CLICK_AIR) | (e.getAction().equals(Action.RIGHT_CLICK_BLOCK)))) {
                ItemStack item = p.getInventory().getItemInMainHand();
                if (item.getType().equals(Material.FIRE_CHARGE) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Fireball")) {
                    e.setCancelled(true);
                    if (p.hasPermission("walmartmc.admin")) {
                        FireBall.trigger(p);
                    } else {
                        p.sendMessage(ChatColor.RED + "You arent supposed to have this...");
                    }
                } else {
                    if (item.getType().equals(Material.MUSIC_DISC_STAL) && Objects.requireNonNull(item.getItemMeta()).getDisplayName().equals(ChatColor.DARK_PURPLE + "Stal Volume II")) {
                        if (p.hasPermission("walmartmc.admin")) {
                            Pickle.trigger(p, Objects.requireNonNull(e.getClickedBlock()).getLocation());
                            e.setCancelled(true);
                            item.setAmount(item.getAmount() - 1);

                            if (item.getAmount() < 1) {
                                item = null;
                            }

                            p.getInventory().setItemInMainHand(item);
                            ItemStack head = p.getInventory().getHelmet();
                            if (head == null) {
                                p.getInventory().setHelmet(stal.getStal());
                            }
                        }
                    }
                }
            }
        }
    }
}
