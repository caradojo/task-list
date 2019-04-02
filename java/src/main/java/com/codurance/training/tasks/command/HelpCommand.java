package com.codurance.training.tasks.command;

public class HelpCommand implements Command {
    @Override
    public void execute(CommandExecutor taskList) {
        taskList.help();
    }
}
