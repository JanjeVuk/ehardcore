package be.janjevuk.ehardcore.gui.builder;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
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

    public Inventory build() {
        return this.inventory;
    }
}