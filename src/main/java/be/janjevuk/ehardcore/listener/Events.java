/**
* This is the "Events" class.
* This class is used to manage events in the plugin.
* This class requires an object of type "Main" to work properly.
* The main class is used to get the "PluginManager" object which in turns is used to register events.
*/
package be.janjevuk.ehardcore.listener;

import be.janjevuk.ehardcore.Main;
import be.janjevuk.ehardcore.gui.player.MainGUI;
import org.bukkit.plugin.PluginManager;

public class Events {

    /**
    * "PluginManager" object that is used to manage plugin events.
    */
    private final PluginManager pm;

    /**
    * This is the constructor of the "Events" class.
    * This constructor requires a "Main" object to initialize the "PluginManager".
    * The "PluginManager" is used to register events in the main object.
    *
    * @param main An object of type "Main".
    */
    public Events(Main main) {
        this.pm = main.getServer().getPluginManager();

        eventsGui(main);
    }

    /**
    * Method to register the events of the GUI.
    * This method requires a "Main" object to register events of the GUI in the main object.
    *
    * @param main An object of type "Main".
    */
    private void eventsGui(Main main){
        pm.registerEvents(new MainGUI(), main);
    }
}