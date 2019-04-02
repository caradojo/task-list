package com.codurance.training.tasks.command;

public class ShowCommand implements Command {
    @Override
    public void execute(CommandExecutor taskList) {
        taskList.show();
    }
}
