package com.nayruforest.messagelogging;

import org.bukkit.plugin.java.JavaPlugin;
import logging.Logging;

public final class MessageLogging extends JavaPlugin {

    private Logging logging;

    @Override
    // when public enabled
    public void onEnable() {
        // insert your webhook url in (make sure its valid)
        this.logging = new Logging("put your webhook here");
        // registers chat event listener
        getServer().getPluginManager().registerEvents(new ChatListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Logging getLogging() {
        return logging;
    }
}