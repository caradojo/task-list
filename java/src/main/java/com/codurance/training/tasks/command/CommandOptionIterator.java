package com.codurance.training.tasks.command;

public class CommandOptionIterator {
    public final String command;
    private final String[] commandRest;

    public CommandOptionIterator(String commandLine) {
        commandRest = commandLine.split(" ", 2);
        command = commandRest[0];

    }

    String getArgs() {
        return commandRest[1];
    }

    CommandOptionIterator next() {
        return new CommandOptionIterator(commandRest[1]);
    }
}
