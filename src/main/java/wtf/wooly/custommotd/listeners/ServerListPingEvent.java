package wtf.wooly.custommotd.listeners;

import wtf.wooly.custommotd.CustomMotd;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.List;
import java.util.UUID;

public class ServerListPingEvent implements Listener {
    private final CustomMotd plugin;

    public ServerListPingEvent(CustomMotd plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onServerListPing(PaperServerListPingEvent event) {
        String line1 = this.plugin.getConfig().getString("motd.line1");
        String line2 = this.plugin.getConfig().getString("motd.line2");
        event.motd(MiniMessage.miniMessage().deserialize(line1 + "<reset>\n" + line2));

        event.setServerIcon(this.plugin.icon);

        if(this.plugin.getConfig().getBoolean("enable_hover_message")){
            List<String> lines = this.plugin.getConfig().getStringList("player_hover_message");
            event.getListedPlayers().clear();
            for(int i = 0; i < lines.size(); i++){
                event.getListedPlayers().add(i, new PaperServerListPingEvent.ListedPlayerInfo(lines.get(i), UUID.randomUUID()));
            }

        }
    }
}
