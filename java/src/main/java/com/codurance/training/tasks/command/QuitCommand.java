package com.codurance.training.tasks.command;

public class QuitCommand implements Command {
    @Override
    public void execute(CommandExecutor taskList) {
        taskList.quit();
    }
}
