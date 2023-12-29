package me.trouper.clickcrystalsalias.events;

import io.github.itzispyder.pdk.events.CustomListener;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import me.trouper.clickcrystalsalias.commands.AutoKitCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements CustomListener {
    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getPlayer();
        if (AutoKitCommand.autoKitMap.containsKey(p.getUniqueId())) {
            p.performCommand("k" + AutoKitCommand.autoKitMap.get(p.getUniqueId()));
        }
        if (p.getWorld().getName().equals("spawn")) {
            Bukkit.getScheduler().runTaskLater(ClickCrystalsAlias.getInstance(),()->{
                p.performCommand("box");
            },5);
        }
    }
}
