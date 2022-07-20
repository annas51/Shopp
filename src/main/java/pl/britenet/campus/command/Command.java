package pl.britenet.campus.command;

import java.text.ParseException;

public abstract class Command {
    private final String name;

    public Command(String name) {
        this.name = name;
    }

    public abstract void execute() throws ParseException;

    public String getName() {
        return name;
    }
}
