package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class AddTaskCommand implements Command {
    private TaskList taskList;

    AddTaskCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute(CommandLineParser parser) {
        CommandLineParser next = parser.next();
        this.taskList.addTask(next.command, next.getArgs());
    }
}
