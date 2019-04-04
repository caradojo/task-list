package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class UncheckCommand implements Command {

    public static final String TOKEN = "uncheck";
    private TaskList taskList;

    public UncheckCommand(TaskList taskList) {
        this.taskList = taskList;

    }

    @Override
    public void execute(CommandLineParser parser) {

        this.taskList.uncheck(parser.getArgs());
    }
}
