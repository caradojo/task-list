package com.codurance.training.tasks.command;

public class CommandLine {
    public final String command;
    private final String[] commandRest;

    public CommandLine(String commandLine) {
        commandRest = commandLine.split(" ", 2);
        command = commandRest[0];

    }

    String getArgs() {
        return commandRest[1];
    }

    OptionLine option() {
        return new OptionLine(commandRest[1]);
    }

}

