package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class UncheckCommand implements CommandParser {

    private static final String TOKEN = "uncheck";
    private TaskList taskList;

    public UncheckCommand(TaskList taskList) {
        this.taskList = taskList;

    }

    @Override
    public boolean match(CommandLine commandLine) {
        return commandLine.command.equals(TOKEN);
    }

    @Override
    public ExecutableCommand parse(CommandLine commandLine) {
        return () -> this.taskList.uncheck(commandLine.getArgs());
    }
}
