package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class UncheckCommand implements CommandParser {

    public static final String TOKEN = "uncheck";
    private TaskList taskList;

    public UncheckCommand(TaskList taskList) {
        this.taskList = taskList;

    }

    @Override
    public ExecutableCommand parse(CommandOptionIterator parser) {
        return () -> this.taskList.uncheck(parser.getArgs());
    }
}
