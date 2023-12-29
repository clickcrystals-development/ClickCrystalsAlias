package me.trouper.clickcrystalsalias;

import io.github.itzispyder.pdk.PDK;
import io.github.itzispyder.pdk.utils.misc.JsonSerializable;
import me.trouper.clickcrystalsalias.commands.*;
import me.trouper.clickcrystalsalias.data.Config;
import me.trouper.clickcrystalsalias.events.BlockPlaceListener;
import me.trouper.clickcrystalsalias.events.ChunkEvents;
import me.trouper.clickcrystalsalias.events.DeathEvent;
import me.trouper.clickcrystalsalias.events.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ClickCrystalsAlias extends JavaPlugin {
    public static Config config = JsonSerializable.load("plugins/ClickCrystalsAlias/config.json", Config.class, new Config());
    private static ClickCrystalsAlias instance;
    public static final Logger log = Bukkit.getLogger();

    @Override
    public void onEnable() {
        init();
    }

    @Override
    public void onDisable() {
        reloadKonfig();
    }

    public void init() {
        PDK.init(this);
        instance = this;
        reloadKonfig();
        initEvents();
        initCommands();
    }

    public static void reloadKonfig() {
        config = JsonSerializable.load("plugins/ClickCrystalsAlias/config.json", Config.class, new Config());
        config.save();
    }

    public void initEvents() {
        new ChunkEvents().register();
        new JoinEvent().register();
        new BlockPlaceListener().register();
        new DeathEvent().register();
    }

    public void initCommands() {
        new AdminCommand().register();
        new SpawnCommand().register();
        new DiscordCommand().register();
        new VulcanBanCommand().register();
        new BoxCommand().register();
        new AutoKitCommand().register();
    }

    public static ClickCrystalsAlias getInstance() {
        return instance;
    }

    public static void verbose(String message) {
        if (config.debugMode) {
            log.info(message);
        }
    }
}
