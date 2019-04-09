package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class HelpCommand implements CommandParser {
    private static final String TOKEN = "help";
    private TaskList taskList;

    public HelpCommand(TaskList taskList) {

        this.taskList = taskList;
    }

    @Override
    public boolean match(CommandLine commandLine) {
        return commandLine.command.equals(TOKEN);
    }

    @Override
    public ExecutableCommand parse(CommandLine commandLine) {
        return () -> this.taskList.help();
    }
}
