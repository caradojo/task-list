package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class AddProjectCommand implements CommandParser {
    private TaskList taskList;

    public AddProjectCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean match(CommandLine commandLine) {
        return commandLine.command.equals("add")
                && commandLine.option().name.equals("project");
    }

    @Override
    public ExecutableCommand parse(CommandLine commandLine) {
        return () -> this.taskList.addProject(commandLine.option().getArgs());
    }
}
