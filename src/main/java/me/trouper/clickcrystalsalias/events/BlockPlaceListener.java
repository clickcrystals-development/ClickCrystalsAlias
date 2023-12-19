package me.trouper.clickcrystalsalias.events;

import io.github.itzispyder.pdk.events.CustomListener;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements CustomListener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Block b = e.getBlock();
        if (b.getWorld().equals(ClickCrystalsAlias.getInstance().getServer().getWorld("spawn")) && e.getPlayer().getGameMode().equals(GameMode.SURVIVAL)) {
            Bukkit.getScheduler().runTaskLater(ClickCrystalsAlias.getInstance(),() -> {
                b.getLocation().getBlock().setType(Material.AIR);
            },10 * 20);
        }
    }
}
