package com.nayruforest.messagelogging;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    private final MessageLogging plugin;

    public ChatListener(MessageLogging plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    // whenever a person sends a message to the chat or chat event is called
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        // get the string of the user who sent the message
        String playerName = event.getPlayer().getName();
        // get the string of the message the user sent
        String message = event.getMessage();
        // calling logToDiscord and parsing playerName and message
        plugin.getLogging().logToDiscord(playerName, message);
    }
}