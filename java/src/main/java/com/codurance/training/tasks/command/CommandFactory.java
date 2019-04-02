package com.codurance.training.tasks.command;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class CommandFactory {
    public static Command createCommand(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                return new ShowCommand();
            case "add":
                return buildAddCommand(commandRest[1]);
            case "check":
                return new CheckCommand(commandRest[1]);
            case "uncheck":
                return new UncheckCommand(commandRest[1]);
            case "help":
                return new HelpCommand();
            case "quit":
                return new QuitCommand();
            default:
                return new ErrorCommand(commandRest[0]);
        }
    }

    private static Command buildAddCommand(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            return new AddProjectCommand(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            return new AddTaskCommand(projectTask[0], projectTask[1]);
        }
        throw new NotImplementedException();
    }
}
