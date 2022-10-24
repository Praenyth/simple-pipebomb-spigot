package me.praenyth.plugins.pipebomb.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;

public class ContainerOpenListener implements Listener {
    @EventHandler
    public void onChestOpenWithPipebomb(InventoryOpenEvent event) {

        if (event.getInventory().contains(Material.TNT)) {
            Player player = (Player) event.getPlayer();
            float pipebombExplosionPower = 0f;
            for (ItemStack item : event.getInventory().getContents()) {
                if (item != null) {
                    if (item.hasItemMeta()) {
                        if (item.getItemMeta().hasDisplayName()) {
                            if (item.getType().equals(Material.TNT)) {
                                if (item.getItemMeta().getDisplayName().equalsIgnoreCase("pipebomb")) {
                                    pipebombExplosionPower += item.getAmount();
                                    event.getInventory().removeItem(item);
                                }
                            }
                        }
                    }
                }
            }

            if (pipebombExplosionPower > 20) {
                player.getWorld().createExplosion(player.getTargetBlockExact(5).getLocation(), 25f);
            } else if (pipebombExplosionPower > 0) {
                player.getWorld().createExplosion(player.getTargetBlockExact(5).getLocation(), pipebombExplosionPower+5f);
            }

        }

    }
}
