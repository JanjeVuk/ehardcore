package be.janjevuk.ehardcore.gui.player;

import be.janjevuk.ehardcore.gui.builder.GuiBuilder;
import be.janjevuk.ehardcore.gui.builder.ItemBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Objects;

public class MainGUI implements Listener {

    private static final String title = "§8Interface";

    // Initiate the GUI for the player
    public static void open(Player player) {
        GuiBuilder inv = new GuiBuilder(player, 5, title);

        ItemBuilder profil = new ItemBuilder(Material.PLAYER_HEAD, 1, "§7Profil §8: §c" + player.getName());
        profil.addLore(Component.text(" "));
        profil.addLore(Component.text("§c-------------"));
        profil.addLore(Component.text("§7Grade : "));
        profil.addLore(Component.text("§7Bourse : "));
        profil.addLore(Component.text("§7Guilde : "));
        profil.addLore(Component.text("§c-------------"));
        profil.addLore(Component.text(" "));


        SkullMeta meta = (SkullMeta) profil.build().getItemMeta();
        meta.setOwningPlayer(player);
        profil.build().setItemMeta(meta);



        inv.addItem(profil, 2,2);

        // Open the inventory for the player
        player.openInventory(inv.build());
    }

    // This method is called whenever a player clicks in an inventory
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        if(!GuiBuilder.secureInteraction(event, title)) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();

        switch (event.getCurrentItem().getType()) {
            case SPRUCE_DOOR:
                player.closeInventory();
                GuiBuilder.playSound(Sound.BLOCK_CHEST_CLOSE, player);
                break;
            default:
                break;
        }

    }

}