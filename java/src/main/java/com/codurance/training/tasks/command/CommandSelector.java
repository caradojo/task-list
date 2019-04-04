package com.codurance.training.tasks.command;

import com.codurance.training.tasks.TaskList;

import java.util.Map;


public class CommandSelector {

    private Map<String, Command> commandMap;
    private ErrorCommand errorCommand;

    public CommandSelector(Map<String, Command> commandMap, ErrorCommand errorCommand) {
        this.commandMap = commandMap;
        this.errorCommand = errorCommand;
    }

    public Command selectCommand(String command) {

        Command cmd = commandMap.get(command);
        if (cmd != null)
        {
            return cmd;
        }
        return errorCommand;
    }

}
