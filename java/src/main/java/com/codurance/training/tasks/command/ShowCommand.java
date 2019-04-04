package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class ShowCommand implements Command {
    public static final String TOKEN = "show";
    private TaskList taskList;

    public ShowCommand(TaskList taskList) {

        this.taskList = taskList;
    }

    @Override
    public void execute(CommandLineParser parser) {
        this.taskList.show();
    }
}
