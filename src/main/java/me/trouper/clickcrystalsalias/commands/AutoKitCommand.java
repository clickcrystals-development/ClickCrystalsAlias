package me.trouper.clickcrystalsalias.commands;

import io.github.itzispyder.pdk.commands.Args;
import io.github.itzispyder.pdk.commands.CommandRegistry;
import io.github.itzispyder.pdk.commands.CustomCommand;
import io.github.itzispyder.pdk.commands.completions.CompletionBuilder;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@CommandRegistry(value="autokit")
public class AutoKitCommand implements CustomCommand {
    public static Map<UUID,Integer> autoKitMap = new HashMap<>();
    @Override
    public void dispatchCommand(CommandSender sender, Args args) {
        Player p = (Player) sender;
        autoKitMap.put(p.getUniqueId(),args.get(0).toInt());
        p.sendMessage(Component.text(color(ClickCrystalsAlias.config.prefix + "Set your auto-kit to slot &3" + autoKitMap.get(p.getUniqueId()) + "&7.")));
    }

    @Override
    public void dispatchCompletions(CompletionBuilder b) {

    }
}
