package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class QuitCommand implements CommandParser {
    private static final String TOKEN = "quit";
    private TaskList taskList;

    public QuitCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean match(CommandLine commandLine) {
        return commandLine.command.equals(TOKEN);
    }

    @Override
    public ExecutableCommand parse(CommandLine commandLine) {
        return () -> this.taskList.quit();
    }
}
