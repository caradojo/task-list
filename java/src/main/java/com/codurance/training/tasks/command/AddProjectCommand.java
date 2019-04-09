package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class AddProjectCommand implements CommandParser {
    private TaskList taskList;

    AddProjectCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public ExecutableCommand parse(CommandOptionIterator parser) {
        return () -> this.taskList.addProject(parser.getArgs());
    }
}
