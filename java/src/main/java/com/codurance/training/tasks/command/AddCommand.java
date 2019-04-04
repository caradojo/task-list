package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class AddCommand implements Command {
    public static final String TOKEN = "add";
    private TaskList taskList;

    public AddCommand(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public void execute(CommandLineParser parser) {
        CommandLineParser subCommand = parser.next();
        buildAddCommand(subCommand).execute(subCommand);
    }

    private Command buildAddCommand(CommandLineParser commandLine) {
        if (commandLine.command.equals("project")) {
            return new AddProjectCommand(taskList);
        } else if (commandLine.command.equals("task")) {
            return new AddTaskCommand(taskList);
        }
        throw new NotImplementedException();
    }
}
