package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class AddTaskCommand implements CommandParser {
    private TaskList taskList;

    public AddTaskCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean match(CommandLine commandLine) {
        return commandLine.command.equals("add")
                && commandLine.option().name.equals("task");
    }

    @Override
    public ExecutableCommand parse(CommandLine commandLine) {
        String[] args = commandLine.option().getArgs(2);
        return () -> this.taskList.addTask(args[0], args[1]);
    }
}
