package me.trouper.clickcrystalsalias.commands;

import io.github.itzispyder.pdk.commands.Args;
import io.github.itzispyder.pdk.commands.CommandRegistry;
import io.github.itzispyder.pdk.commands.CustomCommand;
import io.github.itzispyder.pdk.commands.Permission;
import io.github.itzispyder.pdk.commands.completions.CompletionBuilder;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import me.trouper.clickcrystalsalias.data.Config;
import net.kyori.adventure.text.Component;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandRegistry(value="cca",permission=@Permission(value="cca.admin",message="e"))
public class AdminCommand implements CustomCommand {

    @Override
    public void dispatchCommand(CommandSender sender, Args args) {
        if (!(sender instanceof Player p)) {
            return;
        }
        switch (args.first().toString()) {
            case "debugmode" -> {
                ClickCrystalsAlias.config.debugMode = true;
            }
            case "reload" -> {
                ClickCrystalsAlias.reloadKonfig();
            }
            case "setspawn" -> {
                ClickCrystalsAlias.config.spawnLocation.setSpawn(p.getLocation());
                p.sendMessage(Component.text(color(ClickCrystalsAlias.config.prefix + " Set the server spawn.")));
                ClickCrystalsAlias.config.save();
            }
        }
    }

    @Override
    public void dispatchCompletions(CompletionBuilder b) {
        b.then(b.arg("reload"));
        b.then(b.arg("debugmode"));
        b.then(b.arg("setspawn"));
    }

}
