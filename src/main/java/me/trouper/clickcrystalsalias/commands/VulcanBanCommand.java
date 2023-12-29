package me.trouper.clickcrystalsalias.commands;

import io.github.itzispyder.pdk.Global;
import io.github.itzispyder.pdk.commands.Args;
import io.github.itzispyder.pdk.commands.CommandRegistry;
import io.github.itzispyder.pdk.commands.CustomCommand;
import io.github.itzispyder.pdk.commands.Permission;
import io.github.itzispyder.pdk.commands.completions.CompletionBuilder;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;

@CommandRegistry(value="vulcanban", permission=@Permission(value="ysb.vulcanban", message="You are not the anticheat!"),printStackTrace = true)
public class VulcanBanCommand implements CustomCommand, Global {
    @Override
    public void dispatchCommand(CommandSender sender, Args args) {
        Bukkit.broadcast(Component.text(color(ClickCrystalsAlias.config.prefix + "Vulcan AntiCheat has removed &c" + args.get(1) + "&7 from the game due to cheating. I'm always watching...")));
        Bukkit.getScheduler().runTask(ClickCrystalsAlias.getInstance(), e -> {
            banPlayer(Bukkit.getPlayer(args.get(1).toString()));
        });

    }

    @Override
    public void dispatchCompletions(CompletionBuilder b) {
    }

    public static void banPlayer(OfflinePlayer p) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban " + p.getName() + " 1d -s [AntiCheat]\n You have been automatically temp-banned for the use of unfair advantages! Appeal on " + ClickCrystalsAlias.config.discordURL);
    }
}
