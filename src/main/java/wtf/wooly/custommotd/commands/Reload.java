package wtf.wooly.custommotd.commands;

import wtf.wooly.custommotd.CustomMotd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {
    private final CustomMotd plugin;

    public Reload(CustomMotd plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.hasPermission(CustomMotd.perms)) {
            this.plugin.getServer().getScheduler().runTask(this.plugin, this.plugin::reloadAll);
            sender.sendMessage("Reloaded config.");
        }
        return true;
    }
}
