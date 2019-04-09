package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class QuitCommand implements CommandParser {
    public static final String TOKEN = "quit";
    private TaskList taskList;

    public QuitCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public ExecutableCommand parse(CommandOptionIterator parser) {
        return () -> this.taskList.quit();
    }
}
