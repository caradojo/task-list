package com.codurance.training.tasks.command;

public interface CommandExecutor {
    void show();

    void add(String commandLine);

    void check(String idString);

    void uncheck(String idString);

    void help();

    void error(String command);
}
