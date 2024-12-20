Paper plugin for easily modifying the MOTD, player limit, and listed player info (message when hovering cursor over the player count). Compatible exclusively with Paper, utilising the modern `PaperServerListPingEvent` listener. Designed for simplicity & tailored for the newest versions of the game.

## Commands & Permissions:
- `/max-players <int>` (alias: `/set-max-players`) - set server player limit from in-game (also sets it in config)
- `/motd-reload` - reload the config

Both commands require the permission `custommotd.admin`.

## Default config:
```yaml
# Uses Adventure's MiniMessage: https://docs.advntr.dev/minimessage/format.html
motd:
  line1: "<red>First <gradient:#aa0000:#0000aa>line</gradient>"
  line2: "<blue><u>Second</u> line"

# Uses legacy colour codes (e.g., §a, §1)
enable_hover_message: true
player_hover_message:
  - "§a§lFirst line"
  - "§cSecond line"

# Set -1 to leave unchanged
max_players: 50
```
