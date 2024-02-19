package be.janjevuk.ehardcore.player.command;

import be.janjevuk.ehardcore.gui.player.MainGUI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * CommandMenu class that handles the menu command in the game
 */
public class CommandMenu implements CommandExecutor {

    /**
     * This method is called whenever a player uses the menu command.
     * If the sender isn't a player or the player doesn't have permission, this method does nothing.
     * If the player has permission, this method opens the main gui.
     *
     * @param sender    The sender of the command, should be a player
     * @param command   The command that was used
     * @param label     An alias of the command that was used. This can contain spaces if the command consisted of multiple words
     * @param args      Any additional arguments passed with the command. This usually comes after the command label.
     * @return          Returns true if the command was successfully processed, otherwise false.
     */
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if(!(sender instanceof Player)){
            Bukkit.getLogger().fine("You're not a player");
            return false;
        }

        Player player = (Player) sender;

        if(!player.hasPermission("menu.open")){
            player.sendMessage("You don't have permission to open the menu.");
            return false;
        }

        //open main gui
        MainGUI.open(player);
        return true;
    }
}