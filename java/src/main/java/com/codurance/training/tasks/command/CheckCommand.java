package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class CheckCommand implements CommandParser {
    public static final String TOKEN = "check";
    private TaskList taskList;

    public CheckCommand(TaskList taskList) {
        this.taskList = taskList;

    }

    @Override
    public ExecutableCommand parse(CommandOptionIterator parser) {
        return () -> this.taskList.check(parser.getArgs());
    }
}
