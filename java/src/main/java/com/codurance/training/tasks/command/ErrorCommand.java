package com.codurance.training.tasks.command;

public class ErrorCommand implements Command {
    private String command;

    public ErrorCommand(String command) {

        this.command = command;
    }

    @Override
    public void execute(CommandExecutor taskList) {
        taskList.error(command);
    }
}
