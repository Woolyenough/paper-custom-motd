package wtf.wooly.custommotd.commands;

import wtf.wooly.custommotd.CustomMotd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.jetbrains.annotations.NotNull;

public class SetMaxPlayers implements CommandExecutor {
    private final CustomMotd plugin;

    public SetMaxPlayers(CustomMotd plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission(CustomMotd.perms)) {
            if (args.length != 1) {
                sender.sendMessage("Usage: /max-players <number>");
                return true;
            }
            try {
                int num = Integer.parseInt(args[0]);
                this.plugin.getConfig().set("max_players", num);
                this.plugin.saveConfig();
                this.plugin.getServer().setMaxPlayers(num);
                sender.sendMessage("Max players set to " + num);
            } catch (NumberFormatException e) {
                sender.sendMessage("Invalid number.");
            }
        }
        return true;
    }
}
