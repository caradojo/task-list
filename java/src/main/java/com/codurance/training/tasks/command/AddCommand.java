package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AddCommand implements CommandParser {
    public static final String TOKEN = "add";
    private TaskList taskList;

    public AddCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public ExecutableCommand parse(CommandOptionIterator parser) {
        CommandOptionIterator subCommand = parser.next();
        return buildAddCommand(subCommand).parse(subCommand);
    }

    private CommandParser buildAddCommand(CommandOptionIterator commandLine) {
        if (commandLine.command.equals("project")) {
            return new AddProjectCommand(taskList);
        } else if (commandLine.command.equals("task")) {
            return new AddTaskCommand(taskList);
        }
        throw new NotImplementedException();
    }
}
