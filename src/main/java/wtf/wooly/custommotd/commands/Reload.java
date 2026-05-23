package wtf.wooly.custommotd.commands;

import wtf.wooly.custommotd.CustomMotd;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;

public final class Reload {
    private Reload() {
    }

    public static LiteralCommandNode<CommandSourceStack> node(CustomMotd plugin) {
        return Commands.literal("motd-reload")
                .requires(source -> source.getSender().hasPermission(CustomMotd.ADMIN_PERMISSION))
                .executes(ctx -> {
                    plugin.reloadAll();
                    ctx.getSource().getSender().sendMessage("Reloaded config.");
                    return Command.SINGLE_SUCCESS;
                })
                .build();
    }
}
