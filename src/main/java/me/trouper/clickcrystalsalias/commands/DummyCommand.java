package me.trouper.clickcrystalsalias.commands;

import io.github.itzispyder.pdk.commands.Args;
import io.github.itzispyder.pdk.commands.CommandRegistry;
import io.github.itzispyder.pdk.commands.CustomCommand;
import io.github.itzispyder.pdk.commands.Permission;
import io.github.itzispyder.pdk.commands.completions.CompletionBuilder;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.NPC;
import org.bukkit.entity.Player;

@CommandRegistry(value="dummy", permission=@Permission("op"))
public class DummyCommand implements CustomCommand {

    @Override
    public void dispatchCommand(CommandSender sender, Args args) {
        Player p = (Player) sender;
        Location loc = p.getLocation();

        World w = p.getWorld();
    }

    @Override
    public void dispatchCompletions(CompletionBuilder b) {

    }
}
