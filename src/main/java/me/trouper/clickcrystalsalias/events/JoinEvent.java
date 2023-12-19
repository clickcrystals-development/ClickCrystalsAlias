package me.trouper.clickcrystalsalias.events;

import io.github.itzispyder.pdk.events.CustomListener;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import net.kyori.adventure.text.Component;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinEvent implements CustomListener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.joinMessage(Component.text(color("&8[&2+&8] &b" + e.getPlayer().getName())));
        e.getPlayer().teleport(ClickCrystalsAlias.config.getSpawn());
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        e.quitMessage(Component.text(color("&8[&4-&8] &b" + e.getPlayer().getName())));
    }
}
