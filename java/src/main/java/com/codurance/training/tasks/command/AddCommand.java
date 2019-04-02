package com.codurance.training.tasks.command;

public class AddCommand implements Command {
    private String command;

    public AddCommand(String command) {
        this.command = command;
    }

    @Override
    public void execute(CommandExecutor taskList) {
        taskList.add(command);
    }
}
