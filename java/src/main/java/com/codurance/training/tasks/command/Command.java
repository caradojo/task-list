package com.codurance.training.tasks.command;

public interface Command {
    void execute(CommandExecutor taskList);
}
