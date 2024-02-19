package be.janjevuk.ehardcore;

import be.janjevuk.ehardcore.listener.Commands;
import be.janjevuk.ehardcore.listener.Events;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private Main instance;


    @Override
    public void onEnable() {
        new Commands(this);
        new Events(this);

        instance = this;

        saveDefaultConfig();



        Bukkit.getLogger().info("Plugin has been enabled");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public Main getInstance() {
        return instance;
    }
}