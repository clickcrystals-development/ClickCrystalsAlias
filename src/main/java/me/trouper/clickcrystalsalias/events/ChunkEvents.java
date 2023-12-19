package me.trouper.clickcrystalsalias.events;

import io.github.itzispyder.pdk.events.CustomListener;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.world.ChunkUnloadEvent;

public class ChunkEvents implements CustomListener {

    @EventHandler
    public void onChunkUnload(ChunkUnloadEvent e) {
        World targetWorld = Bukkit.getWorld(ClickCrystalsAlias.config.tempChunks);
        World currentWorld = e.getWorld();
        //ClickCrystalsAlias.verbose("Unloaded a chunk... \n" + "Current World: " + currentWorld.getName() + "\n" +"Target World: " + targetWorld.getName());
        if (targetWorld.equals(currentWorld)) {
            int chunkX = e.getChunk().getX();
            int chunkZ = e.getChunk().getZ();
            //ClickCrystalsAlias.verbose("Attempting to delete the chunk");
            e.setSaveChunk(false);
            Bukkit.getScheduler().runTask(ClickCrystalsAlias.getInstance(), () -> targetWorld.unloadChunk(chunkX, chunkZ, false));
        }
    }
}
