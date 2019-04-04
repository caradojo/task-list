package com.codurance.training.tasks.command;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;


public class CommandFactory {

    public interface CommandLineFactory{
        Command create(String[] args);
    }
    public static Command createCommand(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];

        HashMap<String, CommandLineFactory> commandMap = new HashMap<>();
        commandMap.put("show", (t) -> new ShowCommand());
        commandMap.put("add", (t) -> buildAddCommand(commandRest[1]));
        commandMap.put("check", (t) -> new CheckCommand(commandRest[1]));
        commandMap.put("uncheck", (t) -> new UncheckCommand(commandRest[1]));
        commandMap.put("help", (t) -> new HelpCommand());
        commandMap.put("quit", (t) -> new QuitCommand());

        CommandLineFactory factory = commandMap.get(command);
        if (factory != null)
        {
            return factory.create(commandRest);
        }
        return new ErrorCommand(commandRest[0]);
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
