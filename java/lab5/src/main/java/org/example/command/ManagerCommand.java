package org.example.command;

import java.util.HashMap;

public class ManagerCommand {
    private HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String CommandName, Command command) {
        commandMap.put(CommandName, command);
    }

    public void execute(String commandName) {
        Command command = commandMap.get(commandName);
        if (command == null) {
            throw new IllegalStateException("не найдено команды " + commandName);
        }
        command.execute();
    }
}
