package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class ErrorCommand implements Command {
    private TaskList taskList;

    public ErrorCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute(CommandLineParser parser) {
        taskList.error(parser.command);
    }
}
