package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class CheckCommand implements CommandParser {
    private static final String TOKEN = "check";
    private TaskList taskList;

    public CheckCommand(TaskList taskList) {
        this.taskList = taskList;

    }

    @Override
    public boolean match(CommandLine commandLine) {
        return commandLine.command.equals(TOKEN);
    }

    @Override
    public ExecutableCommand parse(CommandLine commandLine) {
        return () -> this.taskList.check(commandLine.getArgs());
    }
}
