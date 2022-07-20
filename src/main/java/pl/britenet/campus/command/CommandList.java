package pl.britenet.campus.command;

import pl.britenet.campus.Constants;
import pl.britenet.campus.service.CommandService;

public class CommandList extends Command {
    private final CommandService commandService;
    public CommandList(CommandService commandService) {
        super(Constants.COMMAND_ALL_COMMAND);
        this.commandService = commandService;
    }

    @Override
    public void execute()  {
        System.out.println("komendy: all-commend");
        this.commandService.getCommandList().forEach(command -> System.out.println(command.getName()));

    }

}