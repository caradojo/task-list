package com.codurance.training.tasks.command;

import java.util.Map;


public class CommandLineParser {

    private Map<String, CommandParser> commandMap;
    private ErrorCommand errorCommand;

    public CommandLineParser(Map<String, CommandParser> commandMap, ErrorCommand errorCommand) {
        this.commandMap = commandMap;
        this.errorCommand = errorCommand;
    }

    public ExecutableCommand parse(String commandLine) {
        CommandOptionIterator parser = new CommandOptionIterator(commandLine);

        CommandParser cmd = commandMap.get(parser.command);
        if (cmd != null)
        {
            return cmd.parse(parser);
        }
        return errorCommand.parse(parser);
    }

}
