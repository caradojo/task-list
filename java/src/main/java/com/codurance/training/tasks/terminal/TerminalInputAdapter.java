package com.codurance.training.tasks.terminal;

import com.codurance.training.tasks.TaskList;
import com.codurance.training.tasks.command.Command;
import com.codurance.training.tasks.command.CommandFactory;

import java.io.BufferedReader;
import java.io.IOException;

public class TerminalInputAdapter {
    private BufferedReader in;

    public TerminalInputAdapter(BufferedReader in) {

        this.in = in;
    }

    public Command readCommand() {
        String commandLine;
        try {
            commandLine = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return CommandFactory.createCommand(commandLine);
    }
}
