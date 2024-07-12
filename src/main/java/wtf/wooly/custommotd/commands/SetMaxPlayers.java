package wtf.wooly.custommotd.commands;

import wtf.wooly.custommotd.CustomMotd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.jetbrains.annotations.NotNull;

public class SetMaxPlayers implements CommandExecutor {
    private CustomMotd plugin;

    public SetMaxPlayers(CustomMotd plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission(CustomMotd.perms)) {
            try {
                int num = Integer.parseInt(args[0]);
                this.plugin.getConfig().set("max_players", num);
                this.plugin.getServer().setMaxPlayers(num);
            } catch (NumberFormatException e) {
                sender.sendMessage("Invalid number.");
            }
        }
        return true;
    }
}
