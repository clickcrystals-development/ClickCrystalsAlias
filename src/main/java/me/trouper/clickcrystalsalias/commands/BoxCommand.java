package me.trouper.clickcrystalsalias.commands;

import io.github.itzispyder.pdk.commands.Args;
import io.github.itzispyder.pdk.commands.CommandRegistry;
import io.github.itzispyder.pdk.commands.CustomCommand;
import io.github.itzispyder.pdk.commands.completions.CompletionBuilder;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

import java.io.Console;

@CommandRegistry("box")
public class BoxCommand implements CustomCommand {

    @Override
    public void dispatchCommand(CommandSender sender, Args args) {
        Bukkit.getScheduler().runTask(ClickCrystalsAlias.getInstance(),() -> {
           ClickCrystalsAlias.getInstance().getServer().dispatchCommand(Bukkit.getConsoleSender(),"sudo " + sender.getName() + " warp box");
        });
    }

    @Override
    public void dispatchCompletions(CompletionBuilder b) {

    }
}
