package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

public class HelpCommand implements CommandParser {
    public static final String TOKEN = "help";
    private TaskList taskList;

    public HelpCommand(TaskList taskList) {

        this.taskList = taskList;
    }

    @Override
    public ExecutableCommand parse(CommandOptionIterator parser) {
        return () -> this.taskList.help();
    }
}
