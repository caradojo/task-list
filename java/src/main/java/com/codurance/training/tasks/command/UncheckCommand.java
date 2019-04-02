package com.codurance.training.tasks.command;

public class UncheckCommand implements Command {
    private String taskId;

    public UncheckCommand(String taskId) {

        this.taskId = taskId;
    }

    @Override
    public void execute(CommandExecutor taskList) {
        taskList.uncheck(taskId);
    }
}
