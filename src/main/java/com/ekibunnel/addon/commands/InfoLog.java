package com.ekibunnel.addon.commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.commands.Command;
import net.minecraft.command.CommandSource;

import static com.ekibunnel.addon.CmdlogAddon.LOG;

/**
 * The Meteor Client command API uses the <a href="https://github.com/Mojang/brigadier">same command system as Minecraft does</a>.
 */
public class InfoLog extends Command {
    /**
     * The {@code name} parameter should be in kebab-case.
     */
    public InfoLog() {
        super("info", "Log a message at the INFO level.");
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(argument("message", StringArgumentType.greedyString()).executes(context -> {
            String argument = StringArgumentType.getString(context, "message");
            info(argument);
            LOG.info("[CMDLOGADDON] " + argument);
            return SINGLE_SUCCESS;
        }));
    }
}
