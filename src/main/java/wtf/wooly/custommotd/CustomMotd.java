package wtf.wooly.custommotd;

import wtf.wooly.custommotd.commands.Reload;
import wtf.wooly.custommotd.commands.SetMaxPlayers;
import wtf.wooly.custommotd.listeners.ServerListPingListener;

import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.CachedServerIcon;

import java.io.File;
import java.util.List;

public final class CustomMotd extends JavaPlugin {
    public static final String ADMIN_PERMISSION = "custommotd.admin";

    private CachedServerIcon icon;
    private int vanillaMaxPlayers;

    @Override
    public void onEnable() {
        saveDefaultConfig();

        if (!new File(getDataFolder(), "icon.png").exists()) {
            saveResource("icon.png", false);
        }

        vanillaMaxPlayers = getServer().getMaxPlayers();

        reloadAll();

        getServer().getPluginManager().registerEvents(new ServerListPingListener(this), this);

        getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            Commands commands = event.registrar();
            commands.register(Reload.node(this), "Reloads config and icon");
            commands.register(SetMaxPlayers.node(this), "Manually set max player limit for the server", List.of("set-max-players"));
        });
    }

    public CachedServerIcon getIcon() {
        return icon;
    }

    public void reloadAll() {
        reloadConfig();

        File iconFile = new File(getDataFolder(), "icon.png");
        try {
            icon = getServer().loadServerIcon(iconFile);
        } catch (Exception e) {
            icon = null;
            getLogger().warning("Could not load server icon from " + iconFile + ": " + e.getMessage());
        }

        int maxPlayers = getConfig().getInt("max_players", -1);
        getServer().setMaxPlayers(maxPlayers != -1 ? maxPlayers : vanillaMaxPlayers);
    }
}
