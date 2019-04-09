package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class ErrorCommand implements CommandParser {
    private TaskList taskList;

    public ErrorCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean match(CommandLine commandLine) {
        return false;
    }

    @Override
    public ExecutableCommand parse(CommandLine commandLine) {
        return () -> taskList.error(commandLine.command);
    }
}
