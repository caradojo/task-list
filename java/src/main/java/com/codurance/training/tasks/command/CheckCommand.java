package com.codurance.training.tasks.command;

public class CheckCommand implements Command {
    private String taskId;

    public CheckCommand(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public void execute(CommandExecutor taskList) {
        taskList.check(taskId);
    }
}
