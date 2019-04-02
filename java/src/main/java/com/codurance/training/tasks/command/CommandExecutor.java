package com.codurance.training.tasks.command;

public interface CommandExecutor {
    void show();

    void check(String idString);

    void uncheck(String idString);

    void help();

    void error(String command);

    void addTask(String projectName, String description);

    void addProject(String projectName);

    void quit();
}
