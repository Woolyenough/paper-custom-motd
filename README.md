Paper plugin for easily modifying the MOTD, player limit, and listed player info (message when hovering cursor over the player count). Compatible exclusively with Paper, utilising the `PaperServerListPingEvent` listener.

## Commands & Permissions:
- `/max-players <int>` (alias: `/set-max-players`) - set server player limit from in-game (also sets it in config)
- `/motd-reload` - reload the config

Both commands require the permission `custommotd.admin`.

[Default config.yml](https://github.com/Woolyenough/paper-custom-motd/blob/latest/src/main/resources/config.yml)