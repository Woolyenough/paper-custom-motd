Paper plugin for easily modifying the MOTD, player limit, and listed player info (message when hovering cursor over the player count). Compatible exclusively with Paper, utilising the modern `PaperServerListPingEvent` listener. Designed for simplicity.

## Commands & Permissions:
- `/maxplayers <int>` (alias: `/setmaxplayers`) - set server player limit from in-game (also sets it in config)
- `/motdreload` - reload the config

Both commands require the permission `custommotd.admin`.

## Default config:
```yaml
# Uses Adventure's MiniMessage: https://docs.advntr.dev/minimessage/format.html
motd:
  line1: "First line"
  line2: "Second line"

# Uses legacy colour codes (e.g., §a, §1)
enable_hover_message: true
player_hover_message:
  - "First line"
  - "Second line"

# Set -1 to leave unchanged
max_players: 50
```