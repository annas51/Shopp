package pl.britenet.campus.service;

import pl.britenet.campus.command.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommandService {
    public final List<Command> commandList;

    public CommandService() {
        this.commandList = new ArrayList<>();
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public void registerCommand(Command command) {
        this.commandList.add(command);
    }

    public Optional<Command> getCommand(String name) {
        return this.commandList.stream()
                .filter( command -> command.getName().equalsIgnoreCase(name) )
                .findFirst();
    }
}
