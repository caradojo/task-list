package com.codurance.training.tasks.command;

import java.util.Collection;


public class CommandLineParser {

    private Collection<CommandParser> commands;
    private ErrorCommand errorCommand;

    public CommandLineParser(Collection<CommandParser> commands, ErrorCommand errorCommand) {
        this.commands = commands;
        this.errorCommand = errorCommand;
    }

    public ExecutableCommand parse(CommandLine commandLine) {

        CommandParser cmd = commands.stream().filter(p -> p.match(commandLine))
                .findFirst()
                .orElse(errorCommand);

        return cmd.parse(commandLine);
    }

}
