package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class AddTaskCommand implements CommandParser {
    private TaskList taskList;

    AddTaskCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public ExecutableCommand parse(CommandOptionIterator parser) {
        CommandOptionIterator next = parser.next();
        return () -> this.taskList.addTask(next.command, next.getArgs());
    }
}
