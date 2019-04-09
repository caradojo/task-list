package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class ErrorCommand implements CommandParser {
    private TaskList taskList;

    public ErrorCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public ExecutableCommand parse(CommandOptionIterator parser) {
        return () -> taskList.error(parser.command);
    }
}
