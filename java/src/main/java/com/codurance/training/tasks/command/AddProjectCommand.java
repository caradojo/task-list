package com.codurance.training.tasks.command;

public class AddProjectCommand implements Command {
    private String command;

    public AddProjectCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute(CommandExecutor taskList) {
        taskList.addProject(command);
    }
}
