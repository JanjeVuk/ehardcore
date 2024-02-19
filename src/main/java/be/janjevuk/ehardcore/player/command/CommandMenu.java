package be.janjevuk.ehardcore.player.command;

import be.janjevuk.ehardcore.gui.player.MainGUI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandMenu implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

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