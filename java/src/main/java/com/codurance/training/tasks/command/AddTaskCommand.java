package com.codurance.training.tasks.command;

public class AddTaskCommand implements Command {
    private String projectName;
    private String description;

    public AddTaskCommand(String projectName, String description) {
        this.projectName = projectName;
        this.description = description;
    }

    @Override
    public void execute(CommandExecutor taskList) {
        taskList.addTask(projectName, description);
    }
}
