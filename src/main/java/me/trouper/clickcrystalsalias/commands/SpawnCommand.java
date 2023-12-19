package me.trouper.clickcrystalsalias.commands;

import io.github.itzispyder.pdk.commands.Args;
import io.github.itzispyder.pdk.commands.CommandRegistry;
import io.github.itzispyder.pdk.commands.CustomCommand;
import io.github.itzispyder.pdk.commands.completions.CompletionBuilder;
import io.github.itzispyder.pdk.utils.misc.SoundPlayer;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandRegistry(value="spawn")
public class SpawnCommand implements CustomCommand {



    @Override
    public void dispatchCommand(CommandSender sender, Args args) {

        Player p = (Player) sender;
        if (ClickCrystalsAlias.config.getSpawn().getWorld() == null) {
            p.sendMessage(Component.text(color(ClickCrystalsAlias.config.prefix + " There is no spawn yet!")));
            return;
        }
        p.sendMessage(Component.text(color(ClickCrystalsAlias.config.prefix + " teleporting you to spawn...")));
        p.teleport(ClickCrystalsAlias.config.getSpawn());
        SoundPlayer s = new SoundPlayer(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP,10,1);
        s.play(p);
        ClickCrystalsAlias.config.save();
    }

    @Override
    public void dispatchCompletions(CompletionBuilder b) {

    }
}
