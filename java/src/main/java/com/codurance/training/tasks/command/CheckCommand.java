package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class CheckCommand implements Command {
    public static final String TOKEN = "check";
    private TaskList taskList;

    public CheckCommand(TaskList taskList) {
        this.taskList = taskList;

    }

    @Override
    public void execute(CommandLineParser parser) {
        this.taskList.check(parser.getArgs());
    }
}
