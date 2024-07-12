package wtf.wooly.custommotd;

import wtf.wooly.custommotd.commands.*;
import wtf.wooly.custommotd.listeners.*;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.CachedServerIcon;

import java.io.File;

public final class CustomMotd extends JavaPlugin implements Listener, CommandExecutor {
    public CachedServerIcon icon;
    public static final String perms = "custommotd.admin";
    private static int vanillaMaxPlayers;
    @Override
    public void onEnable() {
        saveDefaultConfig();

        if(!new File(getDataFolder(), "icon.png").exists())
            saveResource("icon.png", false);

        vanillaMaxPlayers = getServer().getMaxPlayers();

        reloadAll();

        getServer().getPluginManager().registerEvents(new ServerListPingEvent(this), this);
        getCommand("motdreload").setExecutor(new Reload(this));
        getCommand("maxplayers").setExecutor(new SetMaxPlayers(this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public void reloadAll(){
        reloadConfig();

        try {
            icon = getServer().loadServerIcon(new File(getDataFolder(), "icon.png"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(getConfig().getInt("max_players", -1) != -1)
            getServer().setMaxPlayers(getConfig().getInt("max_players"));
        else
            getServer().setMaxPlayers(vanillaMaxPlayers);
    }
}