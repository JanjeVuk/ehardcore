package be.janjevuk.ehardcore.gui.builder;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {
    private final ItemStack item;
    private final ItemMeta meta;

    public ItemBuilder(Material material, int amount, String displayName) {
        this.item = new ItemStack(material, amount);
        this.meta = this.item.getItemMeta();
        setDisplayname(displayName);
        this.item.setItemMeta(this.meta);
    }

    public void setDisplayname(String displayName){
        meta.displayName(Component.text(displayName));
    }

    public void addLore(Component line){
        List<Component> lore = meta.hasLore() ? meta.lore() : new ArrayList<>();
        if (lore != null) {
            lore.add(line);
        }
        meta.lore(lore);
        item.setItemMeta(meta);
    }

    public void removeLoreLine(int index){
        List<Component> lore = meta.hasLore() ? meta.lore() : new ArrayList<>();
        if (lore != null) {
            lore.remove(index);
        }
        meta.lore(lore);
        item.setItemMeta(meta);
    }

    public void setLores(List<Component> lores){
        meta.lore(lores);
        item.setItemMeta(meta);
    }

    public void addEnchant(Enchantment enchant, int level){
        meta.addEnchant(enchant, level, true);
        item.setItemMeta(meta);
    }

    public void removeEnchant(Enchantment enchantment){
        if (meta.hasEnchant(enchantment)) meta.removeEnchant(enchantment);
        item.setItemMeta(meta);
    }

    public void removeAllEnchant(){
        meta.removeEnchantments();
    }

    public void hideEnchant(){
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
    }

    public ItemStack build(){
        return this.item;
    }
}