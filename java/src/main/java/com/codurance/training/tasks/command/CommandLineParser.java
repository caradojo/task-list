package com.codurance.training.tasks.command;

public class CommandLineParser {
    public final String command;
    private final String[] commandRest;

    public CommandLineParser(String commandLine) {
        commandRest = commandLine.split(" ", 2);
        command = commandRest[0];

    }

    String getArgs() {
        return commandRest[1];
    }

    CommandLineParser next() {
        return new CommandLineParser(commandRest[1]);
    }
}
