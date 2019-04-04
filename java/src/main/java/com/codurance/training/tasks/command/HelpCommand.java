package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class HelpCommand implements Command {
    public static final String TOKEN = "help";
    private TaskList taskList;

    public HelpCommand(TaskList taskList) {

        this.taskList = taskList;
    }

    @Override
    public void execute(CommandLineParser parser) {
        this.taskList.help();
    }
}
