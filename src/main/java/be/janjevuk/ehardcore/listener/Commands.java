package be.janjevuk.ehardcore.listener;

import be.janjevuk.ehardcore.Main;
import be.janjevuk.ehardcore.player.command.CommandMenu;

import java.util.Objects;

public class Commands {

    public Commands(Main main) {
        playerCommands(main);
    }

    private void playerCommands(Main main) {
        Objects.requireNonNull(main.getCommand("menu")).setExecutor(new CommandMenu());
    }
}