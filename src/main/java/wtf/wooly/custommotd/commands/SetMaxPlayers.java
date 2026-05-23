package wtf.wooly.custommotd.commands;

import wtf.wooly.custommotd.CustomMotd;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.tree.LiteralCommandNode;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import io.papermc.paper.command.brigadier.Commands;

public final class SetMaxPlayers {
    private SetMaxPlayers() {
    }

    public static LiteralCommandNode<CommandSourceStack> node(CustomMotd plugin) {
        return Commands.literal("max-players")
                .requires(source -> source.getSender().hasPermission(CustomMotd.ADMIN_PERMISSION))
                .then(Commands.argument("count", IntegerArgumentType.integer(0))
                        .executes(ctx -> {
                            int count = IntegerArgumentType.getInteger(ctx, "count");
                            plugin.getConfig().set("max_players", count);
                            plugin.saveConfig();
                            plugin.getServer().setMaxPlayers(count);
                            ctx.getSource().getSender().sendMessage("Max players set to " + count);
                            return Command.SINGLE_SUCCESS;
                        }))
                .executes(ctx -> {
                    ctx.getSource().getSender().sendMessage("Usage: /max-players <number>");
                    return Command.SINGLE_SUCCESS;
                })
                .build();
    }
}
