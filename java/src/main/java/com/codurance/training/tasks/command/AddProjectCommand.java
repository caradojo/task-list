package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class AddProjectCommand implements Command {
    private TaskList taskList;

    AddProjectCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute(CommandLineParser parser) {
        this.taskList.addProject(parser.getArgs());
    }
}
