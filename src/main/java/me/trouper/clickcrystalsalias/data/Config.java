package me.trouper.clickcrystalsalias.data;

import io.github.itzispyder.pdk.utils.misc.JsonSerializable;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.io.File;

public class Config implements JsonSerializable<Config> {
    @Override
    public File getFile() {
        return new File("plugins/ClickCrystalsAlias/config.json");
    }

    public String prefix = "&bClick&3Crystals &8» &7";
    public String discordURL = "https://discord.gg/tMaShNzNtP";
    public boolean debugMode = true;
    public String tempChunks = "tempchunks";
    // public Location spawn = Location(Bukkit.getWorld("spawn"),0,0,0,0,0);
    public SpawnLocation spawnLocation = new SpawnLocation();

    public static class SpawnLocation {
        public String world = "spawn";
        public double x = 0;
        public double y = 0;
        public double z = 0;
        public float pitch = 0;
        public float yaw = 0;
        public static void setSpawn(Location l) {
            ClickCrystalsAlias.config.spawnLocation.x = l.getX();
            ClickCrystalsAlias.config.spawnLocation.y = l.getY();
            ClickCrystalsAlias.config.spawnLocation.z = l.getZ();
            ClickCrystalsAlias.config.spawnLocation.pitch = l.getPitch();
            ClickCrystalsAlias.config.spawnLocation.yaw = l.getYaw();
            ClickCrystalsAlias.config.spawnLocation.world = l.getWorld().getName();
        }
    }
    public static Location getSpawn() {
        return new Location(ClickCrystalsAlias.getInstance().getServer().getWorld(ClickCrystalsAlias.config.spawnLocation.world), ClickCrystalsAlias.config.spawnLocation.x,ClickCrystalsAlias.config.spawnLocation.y,ClickCrystalsAlias.config.spawnLocation.z,ClickCrystalsAlias.config.spawnLocation.yaw,ClickCrystalsAlias.config.spawnLocation.pitch);
    }
}
