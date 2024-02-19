package be.janjevuk.ehardcore.gui.builder;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public class GuiBuilder {
    private final Inventory inventory;
    private final ItemBuilder itemFill;
    private final ItemBuilder itemContour;
    private final ItemBuilder back;

    public GuiBuilder(Player player, int row, String title) {
        this.inventory = Bukkit.createInventory(player, row * 9, Component.text(title));
        this.itemFill = new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE, 1, " ");
        this.itemContour = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, " ");
        this.back = new ItemBuilder(Material.SPRUCE_DOOR, 1, "§cback");
        setupTemplate();
    }

    public void addItem(ItemBuilder item, int x, int y){
        inventory.setItem((y - 1) * 9 + x - 1, item.build());
    }

    private void setupTemplate() {
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, itemFill.build());
        }

        for (int i = 0; i < 9; i++) {
            inventory.setItem(i, itemContour.build());
            inventory.setItem(inventory.getSize() - 9 + i, itemContour.build());
        }

        for (int i = 9; i < inventory.getSize() - 9; i += 9) {
            inventory.setItem(i, itemContour.build());
            inventory.setItem(i + 8, itemContour.build());
        }

        inventory.setItem(inventory.getSize() - 5, back.build());
    }


    public static void playSound(Sound sound, Player player){
        player.playSound(player.getLocation(), sound, 1f, 1f);
    }

    public static Boolean secureInteraction(InventoryClickEvent event, String title) {
        if (event.getSlotType() == InventoryType.SlotType.OUTSIDE) return false;
        if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) return false;
        // Check if target inventory has the same title
        return event.getView().title().equals(Component.text(title));

    }






    public Inventory build() {
        return this.inventory;
    }
}