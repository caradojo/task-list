package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class ShowCommand implements CommandParser {
    public static final String TOKEN = "show";
    private TaskList taskList;

    public ShowCommand(TaskList taskList) {

        this.taskList = taskList;
    }

    @Override
    public ExecutableCommand parse(CommandOptionIterator parser) {
        return () -> this.taskList.show();
    }
}
