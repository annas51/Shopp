package pl.britenet.campus.command;

import pl.britenet.campus.Constants;
import pl.britenet.campus.command.Command;

public class ExitCommand extends Command {

        public ExitCommand() {

            super(Constants.COMMAND_EXIT);
        }


        @Override
        public void execute() {
            System. exit(0);

        }
    }


