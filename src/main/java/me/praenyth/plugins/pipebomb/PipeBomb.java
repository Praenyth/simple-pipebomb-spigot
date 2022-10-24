package me.praenyth.plugins.pipebomb;

import me.praenyth.plugins.pipebomb.events.ContainerOpenListener;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public final class PipeBomb extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ContainerOpenListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
