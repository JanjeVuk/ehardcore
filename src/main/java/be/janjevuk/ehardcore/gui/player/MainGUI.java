package be.janjevuk.ehardcore.gui.player;

import be.janjevuk.ehardcore.gui.builder.GuiBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainGUI implements Listener {

    private static final String invName = "PROFIL : ";

    // Initiate the GUI for the player
    public static void open(Player player) {
        GuiBuilder inv = new GuiBuilder(player, 5, invName);


        // Open the inventory for the player
        player.openInventory(inv.build());
    }

    // This method is called whenever a player clicks in an inventory
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        //check if target inventory is gui profil
        if(!event.getView().title().equals(Component.text(invName))){
            return;
        }

        event.setCancelled(true);



    }

}