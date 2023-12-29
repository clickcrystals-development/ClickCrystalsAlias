package me.trouper.clickcrystalsalias.commands;

import io.github.itzispyder.pdk.commands.Args;
import io.github.itzispyder.pdk.commands.CommandRegistry;
import io.github.itzispyder.pdk.commands.CustomCommand;
import io.github.itzispyder.pdk.commands.completions.CompletionBuilder;
import io.github.itzispyder.pdk.utils.misc.SoundPlayer;
import me.trouper.clickcrystalsalias.ClickCrystalsAlias;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandRegistry(value="discord")
public class DiscordCommand implements CustomCommand {

    @Override
    public void dispatchCommand(CommandSender sender, Args args) {
        sender.sendMessage(Component
                .text(color(ClickCrystalsAlias.config.prefix + "Click here to join the discord! \n &8> &d&n" + ClickCrystalsAlias.config.discordURL))
                .clickEvent(ClickEvent.openUrl(ClickCrystalsAlias.config.discordURL)));
    }

    @Override
    public void dispatchCompletions(CompletionBuilder b) {

    }
}
